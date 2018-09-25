import java.util.*;

import processing.core.PApplet;

public class Logica {

	LinkedList<Elemento> elemento;
	PApplet app;
	Elemento temp;
	LinkedList<Bowl> bowl;
	boolean act1 = false;
	boolean act2;
	boolean act3;
	boolean act4;
	boolean borrar1 = false;
	boolean borrar2 = false;
	boolean borrar3 = false;
	boolean borrar4 = false;
	boolean efec1 = false;
	boolean efec2 = false;
	boolean efec3 = false;
	boolean efec4 = false;
	int cont1;
	int cont2;
	int cont3;
	int cont4;

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
		for (int i = 0; i < elemento.size(); i++) {
			if (efec2 == true) {

				cont2++;
				if (elemento.get(i) instanceof Aire) {

					elemento.get(i).pintar2();
					System.out.println("yes");
				}
			}
			if (cont2 == 150) {
				cont2 = 0;
				efec2 = false;
			}
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
	}

	public void teclado() {

		for (int i = 0; i < bowl.size(); i++) {
			Bowl o = bowl.get(i);
			if (o.isTapa() == false) {
				if (app.key == 'f' && o.elemento == "Fuego") {
					o.setTapa(true);

				}
				if (app.key == 'v' && o.elemento == "Aire") {
					o.setTapa(true);
					efec2 = true;

				}
				if (app.key == 'a' && o.elemento == "Agua") {
					o.setTapa(true);

				}
				if (app.key == 't' && o.elemento == "Tierra") {
					efec4 = true;
					o.setTapa(true);

				}
			}
		}
	}

	public void mouse() {
		for (int i = 0; i < bowl.size(); i++) {
			if (app.dist(bowl.get(i).getX1(), 600, app.mouseX, app.mouseY) < 90) {
				if (bowl.get(i).elemento == "Fuego") {
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
					} else {
						borrar4 = true;
					}
				}
			}
		}
	}

	public void generador() {

	}

	public void ordenar() {

	}
}
