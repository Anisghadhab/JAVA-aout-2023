package com.anis.beltreview.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.anis.beltreview.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional <User> findByEmail(String email);
	List <User> findAll();

}
