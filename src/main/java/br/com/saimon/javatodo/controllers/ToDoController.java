package br.com.saimon.javatodo.controllers;

import br.com.saimon.javatodo.models.entities.WorkToDo;
import br.com.saimon.javatodo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worktodo/v1")
public class ToDoController {

    @Autowired
    private ToDoService service;

    @GetMapping("/all")
    public List<WorkToDo> findAllToDo() {
        return service.findAllTodo();
    }

    @GetMapping("/{ready}/joblist")
    public List<WorkToDo> allJoblist(@PathVariable("ready") boolean ready) {
        return service.jobList(ready);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkToDo> findOneToDo(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findOneToDo(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOneToDo(@RequestBody WorkToDo work) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createToDo(work));
    }

    @PostMapping("/{id}/ready")
    public ResponseEntity<?> makeToDoReady(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.checkToDo(id));
    }
}
