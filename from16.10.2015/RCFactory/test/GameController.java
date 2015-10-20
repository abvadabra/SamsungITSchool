import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

import ru.redenergy.rc.Position;
import ru.redenergy.rc.RemoteControlableDevice;
import ru.redenergy.rc.flying.models.ARDrone;


public class GameController {
	private List<RemoteControlableDevice> devices = new ArrayList<RemoteControlableDevice>();
	private int selectedIndex = -1;
	
	public GameController() {
		ARDrone ardrone = new ARDrone(new Position(10, 10, 0));
		ardrone.getBattery().setInfinity(true);
		devices.add(ardrone);
		ARDrone ardrone1 = new ARDrone(new Position(100, 10, 0));
		ardrone1.getBattery().setInfinity(true);
		devices.add(ardrone1);
		ARDrone ardrone2 = new ARDrone(new Position(10, 100, 0));
		ardrone2.getBattery().setInfinity(true);
		devices.add(ardrone2);
		ARDrone ardrone3 = new ARDrone(new Position(100, 100, 0));
		ardrone3.getBattery().setInfinity(true);
		devices.add(ardrone3);
	}

	public List<RemoteControlableDevice> getDevices(){
		return devices;
	}

	public int getSelected(){
		return selectedIndex;
	}
	
	public void updateTick(){
		handleMouse();
		if(selectedIndex < 0) return;
		RemoteControlableDevice selectedDevices = devices.get(selectedIndex);
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) selectedDevices.move(1, 0, 0);
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) selectedDevices.move(-1, 0, 0);
		if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) selectedDevices.move(0, 1, 0);
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)) selectedDevices.move(0, -1, 0);
	}
	
	private void handleMouse(){
		if(Mouse.isButtonDown(0)){
			List<RemoteControlableDevice> devicesUnderMouse = getDevicesUnderMouse(Mouse.getX(), Display.getHeight() - Mouse.getY());
			if(!devicesUnderMouse.isEmpty()){
				selectedIndex = devices.indexOf(devicesUnderMouse.get(0));
			}
		}
	}
	
	private List<RemoteControlableDevice> getDevicesUnderMouse(int xPos, int yPos){
		List<RemoteControlableDevice> foundDevices = new ArrayList<RemoteControlableDevice>();
		for(RemoteControlableDevice device : devices){
			if(xPos >= device.getPosition().getX() && xPos <= device.getPosition().getX() + 30 &&
					yPos >= device.getPosition().getY() && yPos <= device.getPosition().getY() + 30){
				foundDevices.add(device);
			}
		}
		return foundDevices;
	}
}
