package com.anis.beltreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anis.beltreview.models.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	List <Project> findAll();
}
