package com.anis.dojos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anis.dojos.models.Belt;
import com.anis.dojos.repositories.BeltRepository;

@Service
public class BeltService {
	private final BeltRepository beltRepository;

	public BeltService(BeltRepository beltRepository) {
		this.beltRepository = beltRepository;
	}

	// Display all Belts

	public List<Belt> allBelts() {
		return beltRepository.findAll();
	}

	// Create a belt
	public Belt createBelt(Belt belt) {
		return beltRepository.save(belt);
	}

	// Find one
	public Belt findBelt(Long id) {
		Optional<Belt> optionalBelt = beltRepository.findById(id);
		if (optionalBelt.isPresent()) {
			return optionalBelt.get();
		} else {
			return null;
		}
	}

	// Delete a belt
	public void deleteBelt(Long id) {
		beltRepository.deleteById(id);
	}

	// Update a belt
	public Belt updateBelt(Belt belt) {
		return beltRepository.save(belt);
	}
}
