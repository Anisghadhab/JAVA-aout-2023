package com.anis.dojos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.anis.dojos.models.Belt;

public interface BeltRepository extends CrudRepository<Belt, Long> {
	List <Belt> findAll();
}
