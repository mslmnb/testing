package kz.gala.testing.util.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by Gala on 20.08.2017.
 */
public class ApplicationException extends RuntimeException {
    private final String msgCode;
    private final HttpStatus httpStatus;
    private final String[] args;

    public ApplicationException(String msgCode, HttpStatus httpStatus, String... args) {
        this.msgCode = msgCode;
        this.httpStatus = httpStatus;
        this.args = args;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String[] getArgs() {
        return args;
    }
}
