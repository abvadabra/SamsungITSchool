package ru.redenergy.rc.flying;

import ru.redenergy.rc.Position;
import ru.redenergy.rc.RemoteControlableDevice;
import ru.redenergy.rc.parts.GasTank;

public abstract class GasDrone extends RemoteControlableDevice {

	protected GasTank tank;
	protected float gasConsumption;
	
	public GasDrone(Position initialPos) {
		super(initialPos);
	}
	
	public GasTank getGasTanl(){
		return tank;
	}
	
	public float getGasConsumption(){
		return gasConsumption;
	}
	
	public void setGasConsumption(float gasC){
		this.gasConsumption = gasC;
	}
}
