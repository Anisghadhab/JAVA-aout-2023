package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	
	// VARIABLE DECLARATION
	
    private ArrayList<String> patientNotes;

    // CONSTRUCTOR
	
	public Physician(Integer id) {
		super(id);
        this.patientNotes = new ArrayList<>(); // Initialize the ArrayList

		// TODO Auto-generated constructor stub
	}
   
	// METHODS
	
	public void newPatientNotes(String notes, String patientName, Date date) {
	    String report = "Patient Notes:\n";
	    if (date != null) {
	        report += String.format("Datetime Submitted: %s \n", date);
	    }
	    report += String.format("Reported By ID: %s\n", this.getId());
	    report += String.format("Patient Name: %s\n", patientName);
	    report += String.format("Notes: %s \n", notes);

	    System.out.println(report); // Print the report directly here
	    this.getPatientNotes().add(report);
	}

    
    
	
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		
		if (pin >= 1000 && pin <= 9999) {
            return true;
        } else 
            return false;
        
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		
	if( confirmedAuthID == getId()) {
		return true;
	} else
		return false;
	}

	// GETTERS & SETTERS
	
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	// GETTERS & SETTERS
	
	
	
}
