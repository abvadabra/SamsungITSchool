package ru.redenergy.rc.flying.models;

import ru.redenergy.rc.Position;
import ru.redenergy.rc.flying.ElectricDrone;
import ru.redenergy.rc.flying.parts.Rotor;

public class ARDrone extends ElectricDrone{

	protected float rotorsRotation = 25.0F;
	
	public ARDrone(Position pos){
		super(pos);
		addRotor(new Rotor(this, rotorsRotation));
		addRotor(new Rotor(this, rotorsRotation));
		addRotor(new Rotor(this, rotorsRotation));
		addRotor(new Rotor(this, rotorsRotation));
	}

	@Override
	public String getLabel(){
		return "AR Drone 2.0";
	}
}
