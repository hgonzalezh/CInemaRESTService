package org.hyperskill.cinemarest;

class ExceptionResponse {
    private String error;

    public ExceptionResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

