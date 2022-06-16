package tasca2n1ex1;

public class Tasca2n1ex1 {
	public static void main(String[] args) {
		Venda venda = new Venda();
		Producte producte1 = new Producte();

		try {
			venda.calcularTotal();
		} catch (VendaBuidaException e) {
			System.out.println(e.getMessage());
			;
		}
		venda.getProductes().add(producte1);
		try {
			venda.calcularTotal();
		} catch (VendaBuidaException e) {
			System.out.println(e.getMessage());
			;
		}

	}

}
