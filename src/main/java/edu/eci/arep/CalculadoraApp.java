package edu.eci.arep;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import edu.eci.arep.model.*;
import java.lang.Math;

/**
 * Es una calculadora que dado un archivo con una fila de datos, calcula la media y desviación estandar de estos.
 */
public class CalculadoraApp {

    /**
     * Metodo principal que dado la ruta de un archivo, calcula la media y desviación estandar de los datos que se encuentren en dicho archivo.
     * @param args La ruta del archivo que contiene los datos
     */
    public static void main( String[] args ) throws IOException {
		try{
			String ruta = args[0];
			System.out.println(calcularMediaYDesviacion(ruta));
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Por favor, digite la ruta de un archivo.");
		}
    }
	
	public static String calcularMediaYDesviacion(String ruta) throws IOException{
        try{
			FileReader f = new FileReader(ruta);
			BufferedReader b = new BufferedReader(f);
			LinkedList lista = new LinkedList(); 
			String cadena;
			double numero;
			//FileReader f = new FileReader("src/test/java/edu/eci/arep/Prueba1.txt");
			while((cadena = b.readLine())!=null) {
				try{
					numero = Double.parseDouble(cadena);
					lista.add(numero);
				} catch (NumberFormatException e){
					System.out.println(cadena);
				}
			}
			b.close();
			int longitud = lista.getLongitud();
			double suma = 0;
			Nodo actual = lista.getCabeza();
			while (actual != null){
				suma += actual.getValor();
				actual = actual.getSiguiente();
			}
			double media = (double) suma / longitud; 
			suma = 0;
			actual = lista.getCabeza();
			while (actual != null){
				suma += (double) ((actual.getValor() - media)*(actual.getValor() - media)) / (longitud -1);
				actual = actual.getSiguiente();
				//System.out.println(suma);
			}
			double desviacionEstandar = Math.sqrt(suma);
			return "Mean: " + (double)(Math.round(media * 100d) / 100d) + " Std.Dev: " + (double)(Math.round(desviacionEstandar * 100d) / 100d); 
		}catch (FileNotFoundException e){
			return "Por favor, digite la ruta de un archivo que exista.";
		}
	}
}