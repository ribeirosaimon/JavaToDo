package br.com.saimon.javatodo.models.repositories;

import br.com.saimon.javatodo.models.entities.WorkToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<WorkToDo, Long> {
}
