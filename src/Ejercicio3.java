
import java.util.Hashtable;
import javax.swing.JOptionPane;
import java.util.Map.Entry;

public class Ejercicio3 {

	public static void main(String[] args) {

		Hashtable<String, Integer> productos = new Hashtable<String, Integer>();
		productos.put("Aguacate",6);
		productos.put("Fresa",4);
		productos.put("Kiwi",3);
		productos.put("Mango",9);
		productos.put("Papaya",8);
		productos.put("Cerezas",7);
		productos.put("Frambuesas",3);
		productos.put("Higos",5);
		productos.put("Arandanos",1);
		productos.put("Platanos",2);

		boolean continuar = true;
		while (continuar) {

			String a = JOptionPane
					.showInputDialog("Indique una opción:\n1.Añadir articulos\n2.Consultar\n3.Listar\n4.Exit");
			int selectOption = Integer.parseInt(a);

			switch (selectOption) {
			case 1:
				añadirProducto(productos);
				break;
			case 2:
				consultarInfo(productos);
				break;
			case 3:
				listarInfo(productos);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Hasta la próxima");
				continuar = false;

			}
		}

	}

	public static Hashtable<String, Integer> añadirProducto(Hashtable<String, Integer> productos) {

		listarInfo(productos);
		String nombreProducto = JOptionPane.showInputDialog("Indique el nombre del producto");

		String precioProducto = JOptionPane.showInputDialog("Indique el precio del producto");
		int precioProductoInt = Integer.parseInt(precioProducto);

		productos.put(nombreProducto, precioProductoInt);

		System.out.println(nombreProducto + " ha sido añadido con un precio de " + precioProductoInt+" €");

		return productos;
	}
	
	private static void consultarInfo(Hashtable<String, Integer> productos) {
		String producto = JOptionPane.showInputDialog("¿De que producto quiere consultar su precio?");
		System.out.println(productos.get(producto)+" €");
		
}

	private static void listarInfo(Hashtable<String, Integer> productos) {
		for (Entry<String, Integer> entry : productos.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue()+"€");
		}
	}


}
