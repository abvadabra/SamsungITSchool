package ru.redenergy.rc.flying;

import java.util.Collections;
import java.util.List;

import ru.redenergy.rc.Position;
import ru.redenergy.rc.RemoteControlableDevice;
import ru.redenergy.rc.flying.parts.Rotor;

public abstract class Drone extends RemoteControlableDevice {
	
	protected float flyingSpeed;
	protected List<Rotor> rotors;

	public Drone(Position initialPos) {
		super(initialPos);
	}
	
	public void addRotor(Rotor rotor){
		this.rotors.add(rotor);
	}
	
	public List<Rotor> getRotors(){
		return Collections.unmodifiableList(rotors);
	}
	
	public float getFlyingSpeed(){
		return flyingSpeed;
	}
}
