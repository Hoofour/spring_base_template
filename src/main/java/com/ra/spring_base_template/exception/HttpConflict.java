package com.ra.spring_base_template.exception;

public class HttpConflict extends RuntimeException {
    public HttpConflict(String message) {
        super(message);
    }
}
