package com.kyoodong.common;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

@Order(20)
public class BaseResponseFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        ContentCachingResponseWrapper ccrw = new ContentCachingResponseWrapper(res);
        chain.doFilter(request, ccrw);
        String content = new String(ccrw.getContentAsByteArray());

        if (res.getStatus() == HttpStatus.OK.value()) {
            BaseResponseBody responseBody = new BaseResponseBody(
                true,
                content,
                System.currentTimeMillis(),
                null,
                null,
                res.getStatus()
            );

            HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(res);
            byte[] bytes = responseBody.toString().getBytes();
            responseWrapper.setContentLength(bytes.length);
            responseWrapper.getOutputStream().write(bytes);
            responseWrapper.getOutputStream().flush();
        } else {
            ccrw.copyBodyToResponse();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
