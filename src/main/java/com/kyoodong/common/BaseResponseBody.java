package com.kyoodong.common;

public class BaseResponseBody {

    private boolean isSuccess;
    private String data;
    private long timestamp;
    private int status;
    private String errorCode;
    private String errorMessage;

    public BaseResponseBody(boolean isSuccess, String data, long timestamp, String errorCode, String errorMessage, int status) {
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

    public void setData(String data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "{" +
            "\"isSuccess\":" + isSuccess +
            ", \"data\":\"" + data + "\"" +
            ", \"timestamp\":" + timestamp +
            ", \"errorCode\":\"" + errorCode + "\"" +
            ", \"errorMessage\":\"" + errorMessage + "\"" +
            '}';
    }
}
