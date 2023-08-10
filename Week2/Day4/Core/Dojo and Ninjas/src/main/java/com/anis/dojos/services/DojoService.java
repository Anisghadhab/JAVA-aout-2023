package com.anis.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anis.dojos.models.Dojo;
import com.anis.dojos.repositories.DojoRepository;
@Service
public class DojoService {
	 private final DojoRepository dojoRepository;
	    
	    public DojoService(DojoRepository dojoRepository) {
	        this.dojoRepository = dojoRepository;
	    }
	    
	    // Display all dojos
	    
	    public List<Dojo> allDojos() {
	    	return dojoRepository.findAll();
	    }
	     // Create a dojo 
	    public Dojo createDojo(Dojo dojo) {
	    	return dojoRepository.save(dojo);
	    }
	    
	    // Find one
	    public Dojo findDojo(Long id) {
	        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
	        if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }
	    }
	    // Delete a dojo
	 	public void deleteDojo(Long id) {
	 		dojoRepository.deleteById(id);
	 	}
	 	// Update a dojo
		public Dojo updateDojo(Dojo dojo) {
			return dojoRepository.save(dojo);
		}

}
