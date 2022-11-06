package org.hyperskill.cinemarest;

public class AuthorizationException extends RuntimeException {

    private String error;


    public AuthorizationException(String error) {
        super(error);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
