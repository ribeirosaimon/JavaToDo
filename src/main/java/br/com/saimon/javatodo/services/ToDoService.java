package br.com.saimon.javatodo.services;

import br.com.saimon.javatodo.exceptions.ToDoNotFoundException;
import br.com.saimon.javatodo.models.entities.ToDo;
import br.com.saimon.javatodo.models.repositories.ToDoRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.Date;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDo createToDo(ToDo todo){
        return this.toDoRepository.save(todo);
    }

    public ToDo findOneToDo(long id){
        try{
            ToDo makeToDo = this.toDoRepository.findById(id).get();
            return makeToDo;
        } catch (ToDoNotFoundException e){
            throw new ToDoNotFoundException("Work not found");
        }
    }

    public ToDo checkToDo(Long id){
        ToDo job = findOneToDo(id);
        job.setDatetime(new Date());
        job.setCheck(true);
        return job;
    }
}
