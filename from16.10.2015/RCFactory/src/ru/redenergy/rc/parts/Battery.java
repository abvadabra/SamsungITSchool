package ru.redenergy.rc.parts;

public class Battery {
	protected float energyAmount;
	
	public Battery(float energyAmount){
		this.energyAmount = energyAmount;
	}
	
	public void chargeEnergy(float amount ){
		this.energyAmount += amount;
	}
	
	public boolean has(float amount){
		return energyAmount >= amount;
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
		return available;
	}
}
