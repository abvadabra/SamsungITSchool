package ru.redenergy.rc.flying.models;

import ru.redenergy.rc.Position;
import ru.redenergy.rc.flying.ElectricDrone;
import ru.redenergy.rc.flying.parts.Rotor;
import ru.redenergy.rc.parts.Battery;

public class ARDrone extends ElectricDrone{

	protected float rotorsRotation = 25.0F;
	protected static final int ARDRONE_BATTERY_SIZE = 1_000;
	
	public ARDrone(Position pos){
		super(new Battery(ARDRONE_BATTERY_SIZE), pos);
		setEnergyConsumption(3F);
		addRotor(new Rotor(this, rotorsRotation));
		addRotor(new Rotor(this, rotorsRotation));
		addRotor(new Rotor(this, rotorsRotation));
		addRotor(new Rotor(this, rotorsRotation));
	}

	@Override
	public String getModel(){
		return "AR Drone 2.0";
	}
}
