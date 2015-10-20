package ru.redenergy.rc.parts;

public class Battery {
	protected float energyAmount;
	protected final float maxEnergy;
	protected boolean infinity = false;
	
	public Battery(float energyAmount){
		this.maxEnergy = energyAmount;
		this.energyAmount = energyAmount;
	}
	
	public void setInfinity(boolean infinity){
		this.infinity = infinity;
	}
	
	public void chargeEnergy(float amount ){
		this.energyAmount += amount;
	}
	
	public boolean has(float amount){
		return energyAmount >= amount;
	}
	
	public float getMaxEnergy(){
		return maxEnergy;
	}

	public boolean isEmpty(){
		return energyAmount <= 0;
	}
	
	public float getEnergyAmount(){
		return energyAmount;
	}
	
	public boolean consumeEnergy(float amount){
		boolean available = has(amount);
		if(available){
			energyAmount -= amount;
		}
		return available || infinity;
	}
}
