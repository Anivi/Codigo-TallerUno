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
			bowl.get(i).cerrar(240*(i+1));
		}
	}
	
	public void teclado() {
		for (int i = 0; i < bowl.size(); i++) {
			Bowl o = bowl.get(i);
			if(o.isTapa()==false) {
				if(app.key == 'f' && o.elemento == "Fuego") {
					o.setTapa(true);
					System.out.println("holi");
				}
				if(app.key == 'v' && o.elemento == "Aire") {
					o.setTapa(true);
					System.out.println("holi");
				}
				if(app.key == 'a' && o.elemento == "Agua") {
					o.setTapa(true);
					System.out.println("holi");
				}
				if(app.key == 't' && o.elemento == "Tierra") {
					o.setTapa(true);
					
				}
		}
		}
	}
	public void mouse() {
		
	}
	public void generador() {
		
	}
	public void ordenar() {
		
	}
}
