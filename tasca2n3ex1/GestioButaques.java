package tasca2n3ex1;

import java.util.ArrayList;
import java.util.ListIterator;

public class GestioButaques {
	private ArrayList<Butaca> butaques;

	public GestioButaques() {
		this.butaques = new ArrayList<Butaca>();
	}

	public ArrayList<Butaca> getButaques() {
		return butaques;
	}

	public void afegirButaca(Butaca butaca) throws ExcepcioButacaOcupada {

		int pos = cercarButaca(butaca.getFila(), butaca.getSeient());
		if (pos != -1) {
			throw new ExcepcioButacaOcupada();
		} else {
			this.butaques.add(butaca);
		}
	}

	public void eliminarButaca(int fila, int seient) throws ExcepcioButacaLliure {
		int pos = cercarButaca(fila, seient);
		if (pos != -1) {
			this.butaques.remove(pos);
			System.out.println("S'ha eliminat la reserva");
		} else {
			throw new ExcepcioButacaLliure();
		}

	}

	public int cercarButaca(int fila, int seient) {
		Butaca a = new Butaca(fila, seient, ""); // al metode equals (override) li dona igual la persona
		boolean found = false;
		for (int i = 0; i < this.butaques.size() && !found; i++) {

			if (found = this.butaques.get(i).equals(a)) {
				return i;
			}

		}
		return -1;
	}

	public void eliminarButacasPersona(String persona) throws ExcepcioButacaLliure {
		int borrados = 0;
		ListIterator<Butaca> it = this.butaques.listIterator();
		while (it.hasNext()) {
			if (it.next().getPersona().equalsIgnoreCase(persona)) {
				it.remove();
				borrados++;
			}
			if (borrados == 0) {
				throw new ExcepcioButacaLliure();
			}
		}

	}

}