package ru.redenergy.rc;

/**
 * Represents position of RC Device in 3D world
 */
public class Position {
	protected int x, y, z;
	
	public Position(int x, int y, int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	public int getZ(){
		return z;
	}
	
	public double distance(Position pos){
		return Math.sqrt(Math.pow(pos.x - this.x, 2) + Math.pow(pos.y - this.y, 2) + Math.pow(pos.z - this.z, 2));
	}

	@Override
	public String toString() {
		return String.format("%d, %d, %d", this.x, this.y, this.z);
	}
	
	
}
