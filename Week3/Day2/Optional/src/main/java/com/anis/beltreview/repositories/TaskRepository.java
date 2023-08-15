package com.anis.beltreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anis.beltreview.models.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
	List <Task> findAll();

}
