package br.com.saimon.javatodo.services;

import br.com.saimon.javatodo.models.entities.ToDo;
import br.com.saimon.javatodo.models.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo createToDo(Date datetime, String )

}
