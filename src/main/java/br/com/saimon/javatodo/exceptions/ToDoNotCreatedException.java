package br.com.saimon.javatodo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ToDoNotCreatedException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ToDoNotCreatedException(String message){
        super(message);
    }
}
