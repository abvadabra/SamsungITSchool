package ru.redenergy.rc;


public abstract class RemoteControlableDevice {
	
	protected Position position;
	
	public RemoteControlableDevice(Position initialPos) {
		this.position = initialPos;
	}

	/**
	 * @return New position of the device
	 */
	public Position move(int x, int y, int z){
		int moveX = getPosition().getX() + x;
		int moveY = getPosition().getY() + y;
		int moveZ = getPosition().getZ() + z;
		Position newPos = new Position(moveX, moveY, moveZ);
		this.moveTo(newPos);
		return newPos;
	}
	
	public void moveTo(Position pos){
		this.position = pos;
	}

	public Position getPosition(){
		return position;
	}
	
	public abstract String getModel();
}
