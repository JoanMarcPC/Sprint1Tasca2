package tasca2n2ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {

	static Scanner input = new Scanner(System.in);

	public static byte llegirByte(String message) throws InputMismatchException {
		
		byte dato = 0;
		boolean ok = false;
		while (!ok)
			try {
				System.out.println(message);
				dato = input.nextByte();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format. Hauràs de tornar-ho a intentar");
				ok = false;
				input.next();
			}
		
		return dato;
	}

	public static int llegirInt(String message)  {

		int dato = 0;
		boolean ok = false;
		while (!ok) {

			try {
				System.out.println(message);
				dato = input.nextInt();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format. Hauràs de tornar-ho a intentar");
				ok = false;
				input.next();
			}

		}
		
		return dato;
	}

	public static float llegirFloat(String message) throws InputMismatchException {

		float dato = 0;
		boolean ok = false;
		while (!ok) {

			try {
				System.out.println(message);
				dato = input.nextFloat();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format. Hauràs de tornar-ho a intentar");
				ok = false;
				input.next();
			}

		}
		
		return dato;
	}

	public static double llegirDouble(String message) throws InputMismatchException {

		double dato = 0;
		boolean ok = false;
		while (!ok) {

			try {
				System.out.println(message);
				dato = input.nextDouble();
				ok = true;
			} catch (InputMismatchException e) {
				System.out.println("Error de format. Hauràs de tornar-ho a intentar");
				ok = false;
				input.next();
			}

		}
		
		return dato;
	}

	public static char llegirChar(String message) throws Exception {
		String dato = "aa";

		while (dato.length() != 1) {
			System.out.println(message);
			dato = input.nextLine();
			if (dato.length() != 1) {
				System.out.println("Introdueix només un caracter, si us plau");

			}
		}
		return dato.charAt(0);

	}

	public static String llegirString(String message) throws Exception {
		String dato = "";
		
		
		System.out.println(message);
		
		dato = input.nextLine();
		
		
		return dato;
	}

	public static boolean llegirSiNo(String message) {
		return true;
	}
}
