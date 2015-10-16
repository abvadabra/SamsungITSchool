package ru.redenergy.rc.parts;

public class GasTank {
	protected float gasAmount;
	
	public GasTank(float energyAmount){
		this.gasAmount = energyAmount;
	}
	
	public boolean has(float amount){
		return gasAmount >= amount;
	}
	
	public boolean isEmpty(){
		return gasAmount <= 0;
	}
	
	public float getGasAmount(){
		return gasAmount;
	}
	
	public boolean consumeGas(float amount){
		boolean available = has(amount);
		if(available){
			gasAmount -= amount;
		}
		return available;
	}
}
