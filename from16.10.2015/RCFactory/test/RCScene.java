import java.awt.Font;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import ru.redenergy.rc.RemoteControlableDevice;
import ru.redenergy.rc.flying.ElectricDrone;


public class RCScene {

	private final int width;
	private final int height;
	
	private GameController gameController = new GameController();
	
	private TrueTypeFont font;
	
	public RCScene(int width, int height) throws LWJGLException{
		this.width = width;
		this.height = height;
		Display.setDisplayMode(new DisplayMode(this.width, this.height));
	}
	
	public void start() throws LWJGLException{
		Display.create();
		setupFont();
		initGl();
		
		while(!Display.isCloseRequested()){
			gameController.updateTick();
			render();
			Display.update();
		}
		Display.destroy();
	}
	
	private void initGl(){
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glShadeModel(GL11.GL_SMOOTH);        
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glDisable(GL11.GL_LIGHTING);                    
 
		
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);                
        GL11.glClearDepth(1);                                       
 
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
 
        GL11.glViewport(0,0,width,height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
 
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	private void setupFont(){
		Font awtFont = new Font("Times New Roman", Font.PLAIN, 12);
		font = new TrueTypeFont(awtFont, true);
	}
	
	public void render(){
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
	    for(int i = 0; i < gameController.getDevices().size(); i++){
	    	renderDevice(gameController.getDevices().get(i), i == gameController.getSelected());
	    }
	}
	
	private void renderDevice(RemoteControlableDevice device, boolean selected){
		GL11.glColor3f(1F, 0F, 0F);
		if(selected){
			drawQuad(device.getPosition().getX() - 3, device.getPosition().getY() - 3, 30 + 6, 30 + 6);
		}
		GL11.glColor3f(0.5f,0.5f,1.0f);
		drawQuad(device.getPosition().getX(), device.getPosition().getY(), 30, 30);
	    font.drawString(device.getPosition().getX(), device.getPosition().getY() + 40, device.getModel(), Color.white);
	    if(device instanceof ElectricDrone){
	    	font.drawString(device.getPosition().getX(), device.getPosition().getY() + 52, 
	    			((ElectricDrone)device).getBattery().getEnergyAmount() + " / " + ((ElectricDrone)device).getBattery().getMaxEnergy(),
	    			Color.white);
	    }
	}
	
	private void drawQuad(int x, int y, int width, int height){
	    GL11.glDisable(GL11.GL_TEXTURE_2D);
	    GL11.glBegin(GL11.GL_QUADS);
	    GL11.glVertex2f(x, y);
		GL11.glVertex2f(x + width, y);
		GL11.glVertex2f(x + width, y + height);
		GL11.glVertex2f(x, y + height);
	    GL11.glEnd();
	    GL11.glEnable(GL11.GL_TEXTURE_2D);
	}
	
	public static void main(String[] args) throws LWJGLException{
		new RCScene(800, 600).start();
	}
}
