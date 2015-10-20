package ru.redenergy.rc.flying;

import ru.redenergy.rc.Position;
import ru.redenergy.rc.parts.Battery;


public abstract class ElectricDrone extends Drone {
	
	protected final Battery battery;
	protected float energyConsumption; //per move meter
	
	public ElectricDrone(Battery battery, Position initialPos) {
		super(initialPos);
		this.battery = battery;
	}
	
	@Override
	public void moveTo(Position pos) {
		double moveEnergy = this.getPosition().distance(pos) * getEnergyConsumption();
		if(battery.consumeEnergy((float)moveEnergy)){
			super.moveTo(pos);
		}
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
