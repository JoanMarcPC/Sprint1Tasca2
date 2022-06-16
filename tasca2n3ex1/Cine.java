package tasca2n3ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cine {
	private int filesTotals;
	private int seientsFila;
	private GestioButaques gestio;
	static Scanner input = new Scanner(System.in);

	public Cine() {
		this.gestio = new GestioButaques();

	}

	public void iniciar() {
		int option;
		do {
			option = menu();
			switch (option) {
			case 0:
				break;
			case 1:
				mostarButaques();
				break;
			case 2:
				mostrarButaquesPersona();
				break;
			case 3:
				reservarButaca();
				break;
			case 4:
				anularReserva();
				break;
			case 5:
				anularReservaPersona();
				break;
			}
		} while (option != 0);

	}

	public void demanarDadesInicials() {
		this.filesTotals = llegirInt("Introdueix el numero de files del cinema");
		this.seientsFila = llegirInt("Introdueix el numero de seients de cada fila");
	}

	public int menu() {
		int option = -1;
		do {
			option = llegirInt(
					"Escull la opció desitjada:\n0.- Sortir\n1.- Mostrar totes les butaques\n2.- Mostrar butaques d'una persona\n3.- Reservar butaca\n4.- Anular reserva amb fila/seient\n5.- Anular reserves d'una persona");
			if (option < 0 || option > 5) {
				System.out.println("Indica una opció que estigui disponible 0-5");
			}
		} while (option < 0 || option > 5);
		return option;
	}

	public void mostarButaques() {
		if (!this.gestio.getButaques().isEmpty()) {
			this.gestio.getButaques().forEach(b -> System.out.println(b.toString()));
		} else {
			System.out.println("No hi ha butaques a mostrar");
		}

	}

	public void mostrarButaquesPersona() {// suposo que no faig bé pq busco 2 cops pero em feia ilusió fer-ho amb lambda
		String persona = introduirPersona();
		int num = (int) this.gestio.getButaques().stream().filter(b -> b.getPersona().equalsIgnoreCase(persona))
				.count();
		if (num == 0) {
			System.out.println("La persona indicada no té butaques reservades");
		} else {
			this.gestio.getButaques().stream().filter(b -> b.getPersona().equalsIgnoreCase(persona))
					.forEach(b -> System.out.println(b));
		}
	}

	public void reservarButaca() {
		int fila;
		int seient;
		String persona;
		fila = introduirFila();
		seient = introduirSeient();
		persona = introduirPersona();
		try {
			this.gestio.afegirButaca(new Butaca(fila, seient, persona));
		} catch (ExcepcioButacaOcupada e) {
			// TODO Auto-generated catch block
			System.out.println("No es pot reservar una butaca ja reservada previament");
		}
	}

	public void anularReserva() {
		int fila = introduirFila();
		int seient = introduirSeient();
		try {
			this.gestio.eliminarButaca(fila, seient);
		} catch (ExcepcioButacaLliure e) {
			// TODO Auto-generated catch block
			System.out.println("No es pot esborrar la reserva d'una butaca, si no hi ha reserva previament.");
		}

	}

	public void anularReservaPersona() {
		String persona = introduirPersona();

		try {
			this.gestio.eliminarButacasPersona(persona);
			System.out.println("S'han anulat les butaques reservades de " + persona);
		} catch (ExcepcioButacaLliure e) {
			// TODO Auto-generated catch block
			System.out.println("La persona " + persona + " no té butaques reservades l'hotel");
		}
	}

	public String introduirPersona() {

		String nom = "";
		boolean ok = false;
		System.out.println("Introdueix el nom de la persona");
		input.nextLine();
		do {
			try {

				nom = input.nextLine();
				if (nom.matches(".*[0-9].*")) {

					throw new ExcepcioNomPersonaIncorrecte();

				} else {
					ok = true;

				}
			} catch (ExcepcioNomPersonaIncorrecte e) {
				input.nextLine();
				System.out.println("Introdueix només caracters NO numerics");
			}
		} while (!ok);
		return nom;
	}

	public int introduirFila() {
		int fila = -1;

		do {
			fila = llegirInt("Introdueix una fila del cinema (max:" + this.filesTotals + ")");
		} while (fila > this.filesTotals || fila < 0);
		return fila;
	}

	public int introduirSeient() {
		int seient = -1;

		do {
			seient = llegirInt("Introdueix un seient de la fila (max:" + this.seientsFila + ")");
		} while (seient > this.seientsFila || seient < 0);
		return seient;

	}

	public int llegirInt(String message) {

		int dato = 0;
		boolean ok = false;
		do {

			try {
				System.out.println(message);
				dato = input.nextInt();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format. Hauràs de tornar-ho a intentar");
				input.nextLine();
			}

		} while (!ok);

		return dato;
	}

}
