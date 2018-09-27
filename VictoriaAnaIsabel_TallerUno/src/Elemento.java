import processing.core.*;
import java.util.*;
public abstract class Elemento {

	protected int colur;
	protected int tam;
	protected PVector pos;
	protected float vel1;
	protected float vel2;
	protected PApplet app;
	protected int alfa;
	
	
	
	

	public Elemento(PApplet app, float x, float y) {
		this.app = app;
		alfa = 255;
	}
	
	public abstract void pintar(); 
		
	
    public abstract void actualizar();

    public abstract void pintar2();

	public int getAlfa() {
		return alfa;
	}

	public void setAlfa(int alfa) {
		this.alfa = alfa;
	}
    
}
