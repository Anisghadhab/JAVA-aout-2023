package com.caresoft.clinicapp;

public abstract class User {
	protected Integer id;
    protected int pin;
    
    // CONSTRUCTOR
    
    public User(Integer id) {
		this.id = id;
	}
	// GETTERS & SETTERS
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}

	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		return false;
	}
    
	    // TO DO: Getters and setters
		// Implement a constructor that takes an ID
    
    
	}



