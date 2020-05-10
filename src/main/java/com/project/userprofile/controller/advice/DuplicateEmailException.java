package com.project.userprofile.controller.advice;

public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException() {
        super("Unique email constraint violation");
    }
}
