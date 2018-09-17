import processing.core.*;

public class Bowl {
    private boolean tapa = false;
    private int contador;
	PApplet app;
	String elemento;
	public Bowl(PApplet app, String e) {
		
		this.app =app;
		elemento = e;
	}
	public void pintar(int x) {
	if(elemento == "Fuego") {
		app.fill(231,37,18);
	}else if(elemento == "Aire") {
		app.fill(140);
	}else if(elemento == "Agua") {
		app.fill(59,131,189);
	}else if(elemento == "Tierra") {
		app.fill(166,94,46);
	}
	
		
		app.noStroke();
		app.ellipseMode(app.CENTER);
	 app.arc(x,600,180 , 180, app.radians(0),app.radians(180)); 
	 if(elemento == "Fuego") {
		 
			app.fill(255,0,0);
		}else if(elemento == "Aire") {
			app.fill(255);
		}else if(elemento == "Agua") {
			app.fill(30,45,110);
		}else if(elemento == "Tierra") {
			app.fill(56,44,30);
		}
	 
	 app.ellipse(x, 640, 50, 50);
		
		
	}
	
	public void cerrar(int x) {
		
		
		if(tapa == true) {
			
	contador++;
		
		if(elemento == "Fuego") {
			app.fill(231,37,18);
		}else if(elemento == "Aire") {
			app.fill(140);
		}else if(elemento == "Agua") {
			app.fill(59,131,189);
		}else if(elemento == "Tierra") {
			app.fill(166,94,46);
		}
		app.arc(x,600,180 , 180, app.radians(180),app.radians(360)); 
		if(contador == 150) {
			contador = 0;
			tapa=false;
		}
		}
	}
	public boolean isTapa() {
		return tapa;
	}
	public void setTapa(boolean tapa) {
		this.tapa = tapa;
	}
	
	
	}

    
