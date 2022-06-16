package tasca2n3ex1;

import java.util.Objects;

public class Butaca {
	private int fila;
	private int seient;
	private String persona;

	public Butaca(int fila, int seient, String persona) {

		this.fila = fila;
		this.seient = seient;
		this.persona = persona;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getSeient() {
		return seient;
	}

	public void setSeient(int seient) {
		this.seient = seient;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fila, seient);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Butaca other = (Butaca) obj;
		return fila == other.fila && seient == other.seient;
	}

	@Override
	public String toString() {
		return "Fila=" + fila + ", Seient=" + seient + ", Persona=" + persona;
	}

}
