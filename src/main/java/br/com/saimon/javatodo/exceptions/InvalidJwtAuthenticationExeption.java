package br.com.saimon.javatodo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.naming.AuthenticationException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidJwtAuthenticationExeption extends AuthenticationException {
    private static final long serialVersionUID = 1L;

    public InvalidJwtAuthenticationExeption(String message) {
        super(message);
    }
}
