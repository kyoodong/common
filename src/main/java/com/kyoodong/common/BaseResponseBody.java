package com.kyoodong.common;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BaseResponseBody {

    private boolean isSuccess;
    private byte[] data;
    private long timestamp;
    private int status;
    private String errorCode;
    private String errorMessage;

    public BaseResponseBody(boolean isSuccess, byte[] data, long timestamp, String errorCode, String errorMessage, int status) {
        this.isSuccess = isSuccess;
        this.data = data;
        this.timestamp = timestamp;
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public Object getData() {
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        String dataString = new String(data);
        JSONParser parser = new JSONParser();
        try {
            parser.parse(dataString);
        } catch (ParseException e) {
            dataString = "\"" + dataString + "\"";
        }

        return "{" +
            "\"isSuccess\":" + isSuccess +
            ", \"data\":" + dataString +
            ", \"timestamp\":" + timestamp +
            ", \"errorCode\":\"" + errorCode + "\"" +
            ", \"errorMessage\":\"" + errorMessage + "\"" +
            '}';
    }
}
