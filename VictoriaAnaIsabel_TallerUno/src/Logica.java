import java.util.*;

import processing.core.PApplet;

public class Logica {

	LinkedList<Elemento>elemento;
	PApplet app;
	Elemento temp;
	LinkedList<Bowl>bowl;
	
	
	public Logica(PApplet app) {
		
		elemento = new LinkedList<Elemento>();
		this.app = app;
		bowl = new LinkedList<Bowl>();
		bowl.add(new Bowl(app, "Fuego"));
		bowl.add(new Bowl(app, "Aire"));
		bowl.add(new Bowl(app, "Agua"));
		bowl.add(new Bowl(app, "Tierra"));
	}
	
	
	public void pintar() {
		for(int i=0; i<bowl.size(); i++) {
			bowl.get(i).pintar(240*(i+1));
		}
	}
	
	public void teclado() {
		
	}
	public void mouse() {
		
	}
	public void generador() {
		
	}
	public void ordenar() {
		
	}
}
