package tasca2n1ex1;

import java.util.ArrayList;

public class Venda {

	private ArrayList<Producte> productes = new ArrayList<Producte>();
	private float totalPrice = 0;

	public void calcularTotal() throws VendaBuidaException  {

		if (productes.isEmpty()) {

			throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
		}
		
		try {
		for (int i = 0; i < productes.size()+1000; i++) {   // forço que es produeixi una excepcio size+1000
			totalPrice += productes.get(i).getPrice();
		}
		}
		catch (IndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
	}

	public ArrayList<Producte> getProductes() {
		return productes;
	}

	public void setProductes(ArrayList<Producte> productes) {
		this.productes = productes;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

}
