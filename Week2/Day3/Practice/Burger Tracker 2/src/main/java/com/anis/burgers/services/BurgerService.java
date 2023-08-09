package com.anis.burgers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anis.burgers.models.Burger;
import com.anis.burgers.repositories.BurgerRepository;

@Service
public class BurgerService {
    private final BurgerRepository burgerRepository;
    
    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }
    
    // Display all burger
    
    public List<Burger> allBurgers() {
    	return burgerRepository.findAll();
    }
     // Create a burger 
    public Burger createBurger(Burger burger) {
    	return burgerRepository.save(burger);
    }
    
    // Find one
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
    // Delete a burger
 	public void deleteBurger(Long id) {
 		burgerRepository.deleteById(id);
 	}
 	// Update a burger
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}

}
