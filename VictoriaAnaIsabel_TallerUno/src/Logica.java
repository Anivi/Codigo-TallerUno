import java.util.*;

import processing.core.PApplet;
import processing.core.PVector;

public class Logica {
    Elemento giran;
	private String [] lineas, palabras;
	private LinkedList<String>guardarTexto;
	
	private LinkedList<Viento> vientos;
	private LinkedList<Lluvia> lluvias;
	private LinkedList<Elemento> elemento;
	private PApplet app;
	private Elemento temp;
	private LinkedList<Bowl> bowl;
	private boolean act1 = false;
	private boolean act2;
	private boolean act3;
	private boolean act4;
	private boolean borrar1 = false;
	private boolean borrar2 = false;
	private boolean borrar3 = false;
	private boolean borrar4 = false;
	private boolean efec1 = false;
	private boolean efec2 = false;
	private boolean efec3 = false;
	private boolean efec4 = false;
	private int cont1;
	private int cont2;
	private int cont3;
	private int cont4;
	private float radious;
	private LinkedList<Incendio> incendios;
	private float x, y;
	private boolean asd = false;
	private float P_RADIOUS = 7;
	private PVector pos, vel;
	private int contclick;
	private int contsclick;
	private boolean camcol = false;
	private boolean masno = false;
	private boolean ruedan = false;

	public Logica(PApplet app) {
		
        giran = new Aire(app, app.width/2, app.height/2);
		radious = 0;
		incendios = new LinkedList<Incendio>();
		vientos = new LinkedList<Viento>();
		lluvias = new LinkedList<Lluvia>();
		for (int i = 0; i < 800; i++) {
			lluvias.add(new Lluvia(app));
		}
		elemento = new LinkedList<Elemento>();
		this.app = app;
		bowl = new LinkedList<Bowl>();
		bowl.add(new Bowl(app, "Fuego"));

		bowl.add(new Bowl(app, "Aire"));
		bowl.add(new Bowl(app, "Agua"));
		bowl.add(new Bowl(app, "Tierra"));
		cargarTXT();
		guardarTexto();
	}

	public void pintar() {
		
		giran.organizar();

		for (int i = 0; i < bowl.size(); i++) {
			bowl.get(i).pintar(240 * (i + 1));
			bowl.get(i).cerrar(240 * (i + 1));
		}
		for (int i = 0; i < elemento.size(); i++) {
			elemento.get(i).pintar();
		}

		if (borrar1 == true) {
			int cont = 0;
			for (int j = 0; j < elemento.size(); j++) {
				for (int e = 0; e < elemento.size(); e++) {
					if (elemento.get(e) instanceof Fuego) {
						elemento.remove(e);
					}
				}
			}
			for (int i = 0; i < elemento.size(); i++) {

				if (elemento.get(i) instanceof Fuego) {
					cont++;
				}
			}
			if (cont == 0) {
				act1 = false;
				borrar1 = false;
			}
		}
		if (borrar2 == true) {
			int cont = 0;
			for (int j = 0; j < elemento.size(); j++) {
				for (int e = 0; e < elemento.size(); e++) {
					if (elemento.get(e) instanceof Aire) {
						elemento.remove(e);
					}
				}
			}
			for (int i = 0; i < elemento.size(); i++) {

				if (elemento.get(i) instanceof Aire) {
					cont++;
				}
			}
			if (cont == 0) {
				act2 = false;
				borrar2 = false;
			}
		}
		if (borrar3 == true) {
			int cont = 0;
			for (int j = 0; j < elemento.size(); j++) {
				for (int e = 0; e < elemento.size(); e++) {
					if (elemento.get(e) instanceof Agua) {
						elemento.remove(e);
					}
				}
			}
			for (int i = 0; i < elemento.size(); i++) {

				if (elemento.get(i) instanceof Agua) {
					cont++;
				}
			}
			if (cont == 0) {
				act3 = false;
				borrar3 = false;
			}
		}
		if (borrar4 == true) {
			int cont = 0;
			for (int j = 0; j < elemento.size(); j++) {
				for (int e = 0; e < elemento.size(); e++) {
					if (elemento.get(e) instanceof Tierra) {
						elemento.remove(e);
					}
				}
			}
			for (int i = 0; i < elemento.size(); i++) {

				if (elemento.get(i) instanceof Tierra) {
					cont++;
				}
			}
			if (cont == 0) {
				act4 = false;
				borrar4 = false;
			}
		}

		if (efec2 == true) {
			vientos.add(new Viento(app));

			float targetx = app.mouseX;
			float targety = app.mouseY;

			for (int i = vientos.size() - 1; i >= 0; i--) {
				Viento pom = vientos.get(i);
				pom.show();
				pom.update();
				pom.physics();
				if (pom.alphaval == 0 && pom.gettingup == 0)
					vientos.remove(i);
			}
			cont2++;

		}
		if (cont2 == 150) {
			cont2 = 0;
			efec2 = false;
		}

		if (efec4 == true) {
			cont4++;
		}
		for (int i = 0; i < elemento.size(); i++) {
			if (efec4 == true) {

				if (elemento.get(i) instanceof Tierra) {

					elemento.get(i).pintar2();
					System.out.println("yes");
				}
			}
			if (cont4 == 250) {
				cont4 = 0;
				efec4 = false;
			}
		}
		if (efec3 == true) {
			cont3++;

			for (int j = 0; j < lluvias.size(); j++) {
				Lluvia a = lluvias.get(j);
				a.pintar();
				a.caer();
			}
			if (cont3 == 250) {
				cont3 = 0;
				efec3 = false;
			}
		}
		if (efec1 == true) {
			cont1++;
			if (app.keyPressed) {
				if (radious < 200) {
					radious += 2;
				}
				app.fill(255, 0, 0);
				app.ellipse(x, y, radious * 2, radious * 2);
			}
			LinkedList<Incendio> nextIncendios = new LinkedList<Incendio>();
			for (Incendio incendios : incendios) {
				incendios.update();
				incendios.display();
				if (!incendios.isDead()) {
					nextIncendios.add(incendios);
				}
			}
			incendios = nextIncendios;
		}
		if (cont1 == 250) {
			cont1 = 0;
			efec1 = false;
		}
		if (contclick >= 2) {
			contclick = 0;
		}
		if (contclick >= 1) {
			contsclick++;
			if (contsclick > 15) {
				contsclick = 0;
				contclick = 0;
			}
		}

		for (int i = 0; i < elemento.size(); i++) {
			if (elemento.get(i).pos.x > 1400) {
				elemento.remove(i);
			}
		}
		if (camcol == true) {
			if (masno == true) {
				System.out.println("-");
				for (int i = 0; i < elemento.size(); i++) {
					Elemento a = elemento.get(i);
					if (a.getAlfa() <= 0) {
						masno = true;
					}
					a.setAlfa(a.getAlfa() + 1);
				}
			}
			if (masno == false) {
				System.out.println("+");
				for (int i = 0; i < elemento.size(); i++) {
					Elemento a = elemento.get(i);

					if (a.getAlfa() >= 255) {
						masno = false;
					}
					a.setAlfa(a.getAlfa() - 1);
				}
			}
		}

	}

	public void teclado() {
if(ruedan==false) {
		if(app.key == 'o') {
			LinkedList<Elemento>ele = giran.getElemento();
			ele.add(new Fuego(app,giran.getX(), giran.getY()));	
			ele.add(new Tierra(app,giran.getX(), giran.getY()));	
			ele.add(new Agua(app,giran.getX(), giran.getY()));	
			ele.add(new Aire(app,giran.getX(), giran.getY()));	
			ele.add(new Fuego(app,giran.getX(), giran.getY()));	
			ele.add(new Tierra(app,giran.getX(), giran.getY()));	
			ele.add(new Agua(app,giran.getX(), giran.getY()));	
			ele.add(new Aire(app,giran.getX(), giran.getY()));
			ele.add(new Fuego(app,giran.getX(), giran.getY()));	
			ele.add(new Tierra(app,giran.getX(), giran.getY()));	
			ele.add(new Agua(app,giran.getX(), giran.getY()));	
			ele.add(new Aire(app,giran.getX(), giran.getY()));
			
			ruedan=true;
		}
}else {
			if(app.key == 'o') {
				for (int j = 0; j < guardarTexto.size(); j++) {
					if(guardarTexto.get(j).compareTo("compañera")== 0) {
						guardarTexto.set(j, "CoMpAñErA");
						System.out.println(guardarTexto.get(j));
					} else if (guardarTexto.get(j).compareTo("CoMpAñErA")== 0) {
						guardarTexto.set(j, "compañera");
						
					}
				}
				System.out.println("jejejeje");
				LinkedList<Elemento>ele = giran.getElemento();
		ele.removeAll(ele);
		ruedan = false;
			}
		
		}
			
		for (int i = 0; i < bowl.size(); i++) {
			Bowl o = bowl.get(i);
			if (o.isTapa() == false) {
				if (app.key == 'f' && o.elemento == "Fuego") {
					for (int j = 0; j < guardarTexto.size(); j++) {
						if(guardarTexto.get(j).compareTo("fuego")== 0) {
							guardarTexto.set(j, "FUEGO");
							System.out.println(guardarTexto.get(j));
						} else if (guardarTexto.get(j).compareTo("FUEGO")== 0) {
							guardarTexto.set(j, "fuego");
							
						}
					}
					o.setTapa(true);
					efec1 = true;
			guardarTexto();
					if (asd == false) {
						x = app.random(app.width);
						y = app.random(app.height);
					}
					asd = true;
				}
				
				if (app.key == 'v' && o.elemento == "Aire") {
					for (int j = 0; j < guardarTexto.size(); j++) {
						if(guardarTexto.get(j).compareTo("aire")== 0) {
							guardarTexto.set(j, "a_i_r_e");
							System.out.println(guardarTexto.get(j));
						} else if (guardarTexto.get(j).compareTo("a_i_r_e")== 0) {
							guardarTexto.set(j, "aire");
						
						}
					}
					o.setTapa(true);
					efec2 = true;
					guardarTexto();

				}
				
				if (app.key == 'a' && o.elemento == "Agua") {
					for (int j = 0; j < guardarTexto.size(); j++) {
						if(guardarTexto.get(j).compareTo("agua")== 0) {
							guardarTexto.set(j, "@gu@");
							System.out.println(guardarTexto.get(j));
						} else if (guardarTexto.get(j).compareTo("@gu@")== 0) {
							guardarTexto.set(j, "agua");
						
						}
					}
					efec3 = true;
					o.setTapa(true);

				}
				if (app.key == 't' && o.elemento == "Tierra") {
					for (int j = 0; j < guardarTexto.size(); j++) {
						if(guardarTexto.get(j).compareTo("tierra")== 0) {
							guardarTexto.set(j, "T13RR4");
							System.out.println(guardarTexto.get(j));
						} else if (guardarTexto.get(j).compareTo("T13RR4")== 0) {
							guardarTexto.set(j, "tierra");
						
						}
					}
					efec4 = true;
					o.setTapa(true);

				}
			}
		}
		if (app.key == 'r') {
			for (int j = 0; j < guardarTexto.size(); j++) {
				if(guardarTexto.get(j).compareTo("serena")== 0) {
					guardarTexto.set(j, "S_E_R_E_N_A");
					System.out.println(guardarTexto.get(j));
				} else if (guardarTexto.get(j).compareTo("S_E_R_E_N_A")== 0) {
					guardarTexto.set(j, "serena");
				
				}
			}
			
			camcol = true;
		}
	}

	public void mouse() {
		for (int i = 0; i < bowl.size(); i++) {
			if (app.dist(bowl.get(i).getX1(), 600, app.mouseX, app.mouseY) < 90) {
				if (bowl.get(i).elemento == "Fuego") {
					for (int j = 0; j < guardarTexto.size(); j++) {
						if(guardarTexto.get(j).compareTo("iceberg")== 0) {
							guardarTexto.set(j, "i-c-e-b-e-r-g");
							System.out.println(guardarTexto.get(j));
						} else if (guardarTexto.get(j).compareTo("i-c-e-b-e-r-g")== 0) {
							guardarTexto.set(j, "iceberg");
						
						}
					}
					if (act1 == false) {
						for (int j = 0; j < 6; j++) {
							if (j < 3) {
								elemento.add(new Fuego(app, bowl.get(i).getX1() - 70 + (50 * j), 600 - 40));
							} else if (j < 5) {
								elemento.add(new Fuego(app, bowl.get(i).getX1() - 45 + (50 * (j - 3)), 600 - 90));
							} else if (j == 5) {
								elemento.add(new Fuego(app, bowl.get(i).getX1() - 20, 600 - 140));
							}
						}
						camcol = false;
						act1 = true;
					} else {
						borrar1 = true;
					}
				} else if (bowl.get(i).elemento == "Aire") {
					if (act2 == false) {

						for (int j = 0; j < 6; j++) {
							if (j < 3) {
								elemento.add(new Aire(app, bowl.get(i).getX1() - 40 + (40 * j), 600 - 40));
							} else if (j < 5) {
								elemento.add(new Aire(app, bowl.get(i).getX1() - 20 + (40 * (j - 3)), 600 - 90));
							} else if (j == 5) {
								elemento.add(new Aire(app, bowl.get(i).getX1() - 5, 600 - 140));
							}
							camcol = false;
							act2 = true;
						}
					} else {
						borrar2 = true;
					}
				} else if (bowl.get(i).elemento == "Agua") {
					if (act3 == false) {
						for (int j = 0; j < 6; j++) {
							if (j < 3) {
								elemento.add(new Agua(app, bowl.get(i).getX1() - 50 + (50 * j), 600 - 40));
							} else if (j < 5) {
								elemento.add(new Agua(app, bowl.get(i).getX1() - 25 + (50 * (j - 3)), 600 - 90));
							} else if (j == 5) {
								elemento.add(new Agua(app, bowl.get(i).getX1() - 3, 600 - 140));
							}
						}
						camcol = false;
						act3 = true;
					} else {
						borrar3 = true;
					}
				} else if (bowl.get(i).elemento == "Tierra") {
					if (act4 == false) {
						for (int j = 0; j < 6; j++) {
							if (j < 3) {
								elemento.add(new Tierra(app, bowl.get(i).getX1() - 60 + (50 * j), 600 - 40));
							} else if (j < 5) {
								elemento.add(new Tierra(app, bowl.get(i).getX1() - 35 + (50 * (j - 3)), 600 - 90));
							} else if (j == 5) {
								elemento.add(new Tierra(app, bowl.get(i).getX1() - 10, 600 - 140));
							}
						}
						act4 = true;
						camcol = false;
					} else {
						borrar4 = true;
					}
				}
			}
		}
	}

	public void soltar() {
		if (radious > P_RADIOUS) {
			int num = (int) (app.sq(radious) * 0.06f);
			for (int i = 0; i < num; i++) {
				float ang = app.random(app.TWO_PI);
				float r = app.random(radious - P_RADIOUS);
				PVector pos = new PVector(x + r * app.cos(ang), y + r * app.sin(ang));
				incendios.add(new Incendio(pos, app));
			}
		}
		radious = 0;
		asd = false;
	}

	public void generador() {
		int re = (int) app.random(1, 5);
		if (app.mouseButton == app.RIGHT) {

			if (contclick == 1) {
				for (int j = 0; j < guardarTexto.size(); j++) {
					if(guardarTexto.get(j).compareTo("libertad")== 0) {
						guardarTexto.set(j, "l.i.b.e.r.t.a.d");
						System.out.println(guardarTexto.get(j));
					} else if (guardarTexto.get(j).compareTo("l.i.b.e.r.t.a.d")== 0) {
						guardarTexto.set(j, "libertad");
					
					}
				}
				switch (re) {
				case 1:
					elemento.add(new Fuego(app, app.mouseX, app.mouseY));
					break;
				case 2:
					elemento.add(new Agua(app, app.mouseX, app.mouseY));
					break;
				case 3:
					elemento.add(new Aire(app, app.mouseX, app.mouseY));
					break;
				case 4:
					elemento.add(new Tierra(app, app.mouseX, app.mouseY));
					break;
				}

			}
			contclick++;
		}
	}

	public void ordenar() {

	}
	public void cargarTXT() {
		lineas = app.loadStrings("texto.txt");
		
		//separa palabras en espacios
		for (int i = 0; i < lineas.length; i++) {
			palabras = PApplet.split(lineas[0], ' ');
		}
		//guardar
		guardarTexto = new LinkedList();
		for (int i = 0; i < palabras.length && palabras != null ; i++) {
			String temp = palabras[i];
			guardarTexto.add(new String(temp));
		}
		
	
	}
    public void guardarTexto() {
    	String[] temp = new String[155];
    	
    	for (int i = 0; i < guardarTexto.size(); i++) {
			temp[i] = guardarTexto.get(i);
		}
    	
  	app.saveStrings("textoMod.txt", temp);
    	
		}
    }

