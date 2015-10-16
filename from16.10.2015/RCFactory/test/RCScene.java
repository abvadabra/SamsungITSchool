import ru.redenergy.rc.Position;
import ru.redenergy.rc.flying.Drone;
import ru.redenergy.rc.flying.models.ARDrone;
import ru.redenergy.rc.flying.parts.Rotor;


public class RCScene {
	
	public static void main(String[] args){
		Drone drone = new ARDrone(new Position(0, 0, 0));
		System.out.println("====ROTORS=====");
		for(Rotor r : drone.getRotors()){
			System.out.println();
		}
	}
}
