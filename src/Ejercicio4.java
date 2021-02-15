import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

public class Ejercicio4 {

	public static void main(String[] args) {

		Hashtable<String, Integer> productos = new Hashtable<String, Integer>();
		productos.put("Aguacate", 6);
		productos.put("Fresa", 4);
		productos.put("Kiwi", 3);
		productos.put("Mango", 9);
		productos.put("Papaya", 8);
		productos.put("Cerezas", 7);
		productos.put("Frambuesas", 3);
		productos.put("Higos", 5);
		productos.put("Arandanos", 1);
		productos.put("Platanos", 2);

		productos.put("Pimiento Italiano", 2);
		productos.put("Pimiento Rojo", 2);
		productos.put("Tomate a granel", 1);
		productos.put("Pepino", 2);
		productos.put("Berenjena", 3);
		productos.put("Patatas", 3);
		productos.put("Calabacin", 2);
		productos.put("Cebollas", 1);
		productos.put("Champiñones", 4);
		productos.put("Brocoli", 4);

		ArrayList<ArrayList> ventas = new ArrayList<ArrayList>();

		boolean continuar = true;
		while (continuar) {

			String a = JOptionPane.showInputDialog(
					"Indique una opción:\n1.Mostrar productos disponibles\n2.Añadir producto\n3.Consultar producto"
							+ "\n4.Registrar venta\n5.Mostrar venta\n6.Exit");
			int selectOption = Integer.parseInt(a);

			switch (selectOption) {
			case 1:
				listarInfo(productos);
				break;
			case 2:
				añadirProducto(productos);
				break;
			case 3:
				consultarInfo(productos);
				break;
			case 4:
				registarVenta(ventas);
				break;
			case 5:
				mostrarCompra(ventas);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Hasta la próxima");
				continuar = false;

			}
		}

	}

	public static void registarVenta(ArrayList<ArrayList> ventas) {

		ArrayList<ArrayList> venta = new ArrayList<ArrayList>();

		int registroVenta;
		int cont = 0;

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
				cont++;
			}
		} while (registroVenta == 0);

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
		int cont = 0;

		for (int i = 0; i < ventas.size(); i++) {
			cont++;
			// Variable que nos permiten hacer operaciones
			Double iva = (Double) ventas.get(i).get(0);
			Double precioBruto = (Double) ventas.get(i).get(1);
			Double articulosComprados = (Double) ventas.get(i).get(2);
			Double cantidadPagada = (Double) ventas.get(i).get(3);

			System.out.println("IVA aplicado: " + iva);
			System.out.println(
					"Precio total bruto: " + precioBruto + "y precio más IVA" + ((iva * precioBruto) + precioBruto));
			System.out.println("Numero de articulos comprados: " + articulosComprados);
			System.out.println("Cantidad pagada: " + cantidadPagada);
			System.out.println(
					"Cambio a devolver al cliente: " + (cantidadPagada - ((iva * precioBruto) + precioBruto)) + "\n");

		}
		System.out.println("Se ha registrado " + cont + " productos");
	}

	public static Hashtable<String, Integer> añadirProducto(Hashtable<String, Integer> productos) {

		listarInfo(productos);
		String nombreProducto = JOptionPane.showInputDialog("Indique el nombre del producto");

		String precioProducto = JOptionPane.showInputDialog("Indique el precio del producto");
		int precioProductoInt = Integer.parseInt(precioProducto);

		productos.put(nombreProducto, precioProductoInt);

		System.out.println(nombreProducto + " ha sido añadido con un precio de " + precioProductoInt + " €");

		return productos;
	}

	private static void consultarInfo(Hashtable<String, Integer> productos) {
		String producto = JOptionPane.showInputDialog("¿De que producto quiere consultar su precio?");
		System.out.println(productos.get(producto) + " €");

	}

	private static void listarInfo(Hashtable<String, Integer> productos) {
		for (Entry<String, Integer> entry : productos.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
