import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Ejercicio2 {
	public static void main(String[] args) {

		ArrayList<ArrayList> ventas = new ArrayList<ArrayList>();
		int registroVenta;
		int cont=0;

		do {
			
			String a = JOptionPane.showInputDialog("Tienes algún producto para registrar\n0. Si\n1. No");
			registroVenta = Integer.parseInt(a);
			
			if (registroVenta == 0) {
				
				String iva = JOptionPane.showInputDialog("Ingrese el IVA:\n 0.21\n 0.04");
				Double ivaDouble = Double.parseDouble(iva);

				String precioBruto = JOptionPane.showInputDialog("Ingrese el precio en bruto:");
				Double precioBrutoDouble = Double.parseDouble(precioBruto);

				String numArticulos = JOptionPane.showInputDialog("Ingrese el numero de articulos:");
				Double numArticulosDouble = Double.parseDouble(numArticulos);

				String cantidadPagada = JOptionPane.showInputDialog("Ingrese la cantidad pagada:");
				Double cantidadPagadaDouble = Double.parseDouble(cantidadPagada);

				carritoCompra(ventas, ivaDouble, precioBrutoDouble, numArticulosDouble, cantidadPagadaDouble);
				cont ++;
			}
		} while (registroVenta == 0);
		
		
		mostrarCompra(ventas);
		System.out.println("Se ha registrado "+cont+" productos"); 
	}

	public static ArrayList<ArrayList> carritoCompra(ArrayList<ArrayList> ventas, Double iva, Double precioBruto,
			Double numArticulos, Double cantidadPagada) {

		ArrayList<Double> venta = new ArrayList<Double>();

		ventas.add(venta);
		venta.add(iva);
		venta.add(precioBruto);
		venta.add(numArticulos);
		venta.add(cantidadPagada);

		return ventas;

	}

	public static void mostrarCompra(ArrayList<ArrayList> ventas) {

		for (int i = 0; i < ventas.size(); i++) {

			// Variable que nos permiten hacer operaciones
			Double iva = (Double) ventas.get(i).get(0);
			Double precioBruto = (Double) ventas.get(i).get(1);
			Double articulosComprados = (Double) ventas.get(i).get(2);
			Double cantidadPagada = (Double) ventas.get(i).get(3);

			System.out.println("IVA aplicado: " + iva);
			System.out.println("Precio total bruto: " + precioBruto+ "y precio más IVA"+((iva * precioBruto) + precioBruto));
			System.out.println("Numero de articulos comprados: " + articulosComprados);
			System.out.println("Cantidad pagada: " + cantidadPagada);
			System.out.println("Cambio a devolver al cliente: " + (cantidadPagada - ((iva * precioBruto) + precioBruto))+"\n");
		}

	}
}
