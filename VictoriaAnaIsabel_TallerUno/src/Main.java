import processing.core.PApplet;

public class Main extends PApplet {
	
	Logica logica;

	public static void main(String[] args) {
	PApplet.main("Main");

	}

	public void settings() {
		
		size(1200,700);
	}
	public void setup() {
		  smooth();
		logica = new Logica(this);
	}
	
	public void draw() {
		background(0);
		logica.pintar();
	}
	public void keyPressed() {	
		logica.teclado();
	}
	public void mouseReleased() {
		logica.mouse();
	
		
	}
}

