package br.com.saimon.javatodo.exceptions.handler;

import br.com.saimon.javatodo.exceptions.ExceptionResponse;
import br.com.saimon.javatodo.exceptions.ToDoNotCreatedException;
import br.com.saimon.javatodo.exceptions.ToDoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ToDoNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> toDoNotFoundException(Exception ex, WebRequest req){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                req.getDescription(false));
                return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ToDoNotCreatedException.class)
    public final ResponseEntity<ExceptionResponse> toDoNotCreatedException(Exception ex, WebRequest req){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
    }
}
