
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JOptionPane;

class Ejercicio1 {

	public static void main(String[] args) {

		String a = JOptionPane.showInputDialog("Introduce la cantidad de alumnos:");
		int numAlumnos = Integer.parseInt(a);

		String b = JOptionPane.showInputDialog("Introduce la cantidad de notas:");
		double numNotas = Integer.parseInt(b);

		Hashtable<String, Double> notas = rellenarNotas(numAlumnos, numNotas);
		mostarNotas(notas);
						
	}
	
	public static Hashtable<String, Double> rellenarNotas(int numAlumnos, Double numNotas){
		Hashtable<String, Double> resultado = new Hashtable<String, Double>();
		
		for (int i = 0; i < numAlumnos; i++) {
			
			Double notaMedia = 0.0;
			String nombreAlumno = JOptionPane.showInputDialog("Introduce el nombre del alumno");
			
			for (int j = 0; j < numNotas; j++) {
				
				String numNota = JOptionPane.showInputDialog("Introduce la " + (j+1) + " nota del " + (i+1) + " alumno");
				Double numNotaDoble = Double.parseDouble(numNota);
				
				notaMedia += numNotaDoble;
				
			}
			
			notaMedia = notaMedia/numNotas;
			
			resultado.put(nombreAlumno, notaMedia);
			
		}
				
		return resultado;
	}
	
	public static void mostarNotas(Hashtable<String, Double> mediaNotas) {
		
		Enumeration<String> EnumerationClave = mediaNotas.keys();
		Enumeration<Double> EnumerationValor = mediaNotas.elements();
		
		while (EnumerationClave.hasMoreElements()){
			System.out.println("El alumn@ " + EnumerationClave.nextElement() + " tiene una media de " + EnumerationValor.nextElement());
		}
		
	}

}