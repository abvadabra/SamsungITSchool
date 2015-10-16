package ru.redenergy.rc.flying;

import ru.redenergy.rc.Position;
import ru.redenergy.rc.parts.Battery;


public abstract class ElectricDrone extends Drone {
	
	protected Battery battery;
	protected float energyConsumption;
	
	public ElectricDrone(Position initialPos) {
		super(initialPos);
	}
	
	public Battery getBattery(){
		return battery;
	}
	
	public float getEnergyConsumption(){
		return energyConsumption;
	}
	
	public void setEnergyConsumption(float energyC){
		this.energyConsumption = energyC;
	}
}
