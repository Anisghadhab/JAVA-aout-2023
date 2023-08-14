package com.anis.dojos.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.anis.dojos.models.Belt;
import com.anis.dojos.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional <User> findByEmail(String email);
	List <User> findAll();

}
