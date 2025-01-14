package vn.hoidanit.jobhunter.domain;

public class RestResponse<T> {
    private int statusCode;
    private String error;

    private Object message;
    private T data;

    // Getter and Setter for statusCode
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    // Getter and Setter for error
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    // Getter and Setter for message
    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    // Getter and Setter for data
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
