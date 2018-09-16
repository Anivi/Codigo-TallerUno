import processing.core.*;
import java.util.*;
public abstract class Elemento {

	protected int colur;
	protected int tam;
	protected PVector pos;
	protected float vel1;
	protected float vel2;
	
	
	
	
	public Elemento(PApplet app) {
		
	}
	
	public abstract void pintar(); 
		
	
    public abstract void actualizar();
}

