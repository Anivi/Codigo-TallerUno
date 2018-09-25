import processing.core.*;
import java.util.*;
public abstract class Elemento {

	protected int colur;
	protected int tam;
	protected PVector pos;
	protected float vel1;
	protected float vel2;
	protected PApplet app;
	
	
	
	
	public Elemento(PApplet app, float x, float y) {
		this.app = app;
	}
	
	public abstract void pintar(); 
		
	
    public abstract void actualizar();

    public abstract void pintar2();
    
}
