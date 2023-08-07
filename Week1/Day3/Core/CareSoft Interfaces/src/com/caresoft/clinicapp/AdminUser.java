package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
 
	// VARIABLE DECLARATION

    private String role;
    private ArrayList<String> securityIncidents;
    private String notes;
	
    // CONSTRUCTOR 
	
public AdminUser(Integer id, String role) {
		super(id);
		this.setRole(role);
		this.setSecurityIncidents(new ArrayList<>());
		// TODO Auto-generated constructor stub
	}
	
	// Methods
    
    public void newIncident() {
        String report = String.format(
            "===> Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.getId(), "AUTHORIZATION ATTEMPT SUCCESSFULLY FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "===> Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.getId(), "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		
		if (pin >= 100000) {
			
            return true;
        } 
		
		else 
			
            return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		
		if( confirmedAuthID == getId()) {
			
			newIncident();
			return true;
		} 
		
		else
			authIncident();
			return false;
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		
		
		return this.securityIncidents;
	}
	
	// Setters & Getters

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	
	

}
