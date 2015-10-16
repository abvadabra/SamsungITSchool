package ru.redenergy.rc.flying.parts;

import ru.redenergy.rc.flying.Drone;


public class Rotor {
	protected Drone parent;
	protected float rotateSpeed;
	
	public Rotor(Drone parent, float rotationSpeed){
		this.parent = parent;
		this.rotateSpeed = rotationSpeed;
	}
	
	public float getRotateSpeed(){
		return rotateSpeed;
	}
	
	public Drone getParent(){
		return parent;
	}
}
