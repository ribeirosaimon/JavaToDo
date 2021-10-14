package br.com.saimon.javatodo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ToDoNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ToDoNotFoundException(String message){
        super(message);
    }
}
