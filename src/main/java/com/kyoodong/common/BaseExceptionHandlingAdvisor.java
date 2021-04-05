package com.kyoodong.common;

import com.connect.puppy.protocol.exception.FriendException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseExceptionHandlingAdvisor {

    @ExceptionHandler(FriendException.class)
    protected ResponseEntity<BaseResponseBody> friendExceptionHandler(FriendException e) {
        e.printStackTrace();
        return new ResponseEntity<>(
            new BaseResponseBody(
                false,
                null,
                System.currentTimeMillis(),
                e.getErrorCode(),
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value()
            ),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<BaseResponseBody> exceptionHandler(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(
            new BaseResponseBody(
                false,
                null,
                System.currentTimeMillis(),
                "EXP-1",
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value()
            ),
            HttpStatus.BAD_REQUEST
        );
    }
}
