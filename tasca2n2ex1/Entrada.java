package tasca2n2ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

	static Scanner input = new Scanner(System.in);

	public static byte llegirByte(String message) throws InputMismatchException {

		byte dato = 0;
		boolean ok = false;
		do {
			try {
				System.out.println(message);
				dato = input.nextByte();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format. Hauràs de tornar-ho a intentar");
				input.nextLine();
			}
		} while (!ok);

		return dato;
	}

	public static int llegirInt(String message) {

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

	public static float llegirFloat(String message) {

		float dato = 0;
		boolean ok = false;
		do {

			try {
				System.out.println(message);
				dato = input.nextFloat();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format. Hauràs de tornar-ho a intentar");
				input.nextLine();
			}

		} while (!ok);

		return dato;
	}

	public static double llegirDouble(String message) {

		double dato = 0;
		boolean ok = false;
		do {

			try {
				System.out.println(message);
				dato = input.nextDouble();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format. Hauràs de tornar-ho a intentar");
				input.nextLine();
			}

		} while (!ok);

		return dato;
	}

	public static char llegirChar(String message) {
		String dato = "aa";

		do {
			try {
				System.out.println(message);
				dato = input.nextLine();
				if (dato.length() != 1) {
					throw new Exception();

				}
			} catch (Exception e) {
				System.out.println("Introdueix només un caracter, si us plau");
			}

		} while (dato.length() != 1);
		return dato.charAt(0);

	}

	public static String llegirString(String message) { // aqui perque hauria de fer saltar una
														// excepcio?¿?¿
		String dato = "";

		System.out.println(message);

		dato = input.nextLine();

		return dato;
	}

	public static boolean llegirSiNo(String message) {
		String dato = "";
		boolean ok = false;
		boolean retorn = false;
		System.out.println(message);

		do {
			try {
				dato = input.nextLine();
				if (dato.equalsIgnoreCase("s")) {
					ok = true;
					retorn = true;

				} else if (dato.equalsIgnoreCase("n")) {
					ok = true;
					retorn = false;
				} else {

					throw new Exception();

				}
			} catch (Exception e) {
				System.out.println("Introdueix només s o n");
			}
		} while (!ok);
		return retorn;
	}
}
