package br.com.saimon.javatodo.services;

import br.com.saimon.javatodo.converter.DozerConverter;
import br.com.saimon.javatodo.exceptions.ToDoNotCreatedException;
import br.com.saimon.javatodo.exceptions.ToDoNotFoundException;
import br.com.saimon.javatodo.models.entities.WorkToDo;
import br.com.saimon.javatodo.models.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;

    @Autowired
    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public WorkToDo createToDo(WorkToDo todo) throws ToDoNotCreatedException {
        Optional.ofNullable(todo).orElseThrow(() -> new ToDoNotCreatedException("Need Body request"));
        if (todo.getHomework() != null) {
            todo.setDatetime(new Date());
            todo.setCheckWork(false);
            WorkToDo workSaved = DozerConverter.parseObject(this.toDoRepository.save(todo), WorkToDo.class);
            return workSaved;
        } else {
            throw new ToDoNotCreatedException("Need one work");
        }
    }

    public List<WorkToDo> findAllTodo() {
        List<WorkToDo> objects = new ArrayList<WorkToDo>();
        var allTodo = this.toDoRepository.findAll();
        for (WorkToDo todo : allTodo) {
            objects.add(todo);
        }
        return DozerConverter.parseListObject(objects, WorkToDo.class);
    }

    public WorkToDo findOneToDo(long id) {
        var entity = this.toDoRepository.findById(id).orElseThrow(() -> new ToDoNotCreatedException("Work not found"));
        return DozerConverter.parseObject(entity, WorkToDo.class);
    }

    public WorkToDo checkToDo(Long id) {
        WorkToDo job = findOneToDo(id);
        job.setDatetime(new Date());
        job.setCheckWork(true);
        this.toDoRepository.save(job);
        return job;
    }

    public List<WorkToDo> jobList(boolean ready) {
        List<WorkToDo> myJobList = new ArrayList<>();
        for (WorkToDo c : findAllTodo()) {
            if (c.isCheckWork() == ready) {
                myJobList.add(c);
            }
        }
        return myJobList;
    }


}
