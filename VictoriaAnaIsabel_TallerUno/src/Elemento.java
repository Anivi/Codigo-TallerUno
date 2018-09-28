import processing.core.*;
import java.util.*;
public abstract class Elemento {

	LinkedList<Elemento>elemento;
	protected int colur;
	protected int tam;
	protected PVector pos;
	protected float vel1;
	protected float vel2;
	protected PApplet app;
	protected int alfa;
	
	
	
	

	public LinkedList<Elemento> getElemento() {
		return elemento;
	}
	public void setElemento(LinkedList<Elemento> elemento) {
		this.elemento = elemento;
	}
	public Elemento(PApplet app, float x, float y) {
		elemento= new LinkedList<Elemento>();
		this.app = app;
		alfa = 255;
	}
	public void organizar() {
		for (int i = 0; i < elemento.size(); i++) {
		float angulo= (PApplet.PI*2 / elemento.size())*i;
		float hipo =160;
		
		float a = PApplet.sin(angulo+app.radians(vel1))*hipo;
		float b = PApplet.cos(angulo+app.radians(vel1))*hipo;
		
		elemento.get(i).pintar();
		elemento.get(i).mover(pos.x - b, pos.y - a);
		
		}
		vel1++;
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
 public abstract void  mover(float x, float y);
	 
 public float getX() {
 return pos.x;
 }
 public float getY() {
 return pos.y;
 }
 
}

