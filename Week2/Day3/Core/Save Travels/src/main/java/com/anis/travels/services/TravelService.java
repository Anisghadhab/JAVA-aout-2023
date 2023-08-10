package com.anis.travels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.anis.travels.models.Travel;
import com.anis.travels.repositories.TravelRepository;

@Service
public class TravelService {
    private final TravelRepository travelRepository;
    
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }
    
    // Display all travel
    
    public List<Travel> allTravels() {
    	return travelRepository.findAll();
    }
     // Create a travel 
    public Travel createTravel(Travel travel) {
    	return travelRepository.save(travel);
    }
    
    // Find one
    public Travel findTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepository.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
    // Delete a travel
 	public void deleteTravel(Long id) {
 		travelRepository.deleteById(id);
 	}
 	// Update a travel
	public Travel updateTravel(Travel travel) {
		return travelRepository.save(travel);
	}

}
