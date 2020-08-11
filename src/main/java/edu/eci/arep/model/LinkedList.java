package edu.eci.arep.model;

/**
 * Es una calculadora que dado un archivo con una fila de datos, calcula la media y desviación estandar de estos.
 */
public class LinkedList {
	private Integer longitud = 0;
	private Nodo cabeza;
	private Nodo cola;
	public LinkedList(){
	}
	
	public Nodo getCabeza(){
		return this.cabeza;
	}
	public Nodo getCola(){
		return this.cola;
	}
	public void add(double valor){
		Nodo n = new Nodo(valor);
		if (this.cabeza == null){
			this.cabeza = n;
			this.cola=n;
		}
		else{
			this.cola.setSiguiente(n);
			n.setAnterior(this.cola);
			this.cola=n;
		}
		this.longitud+=1;
	}
	public void remove(int pos){
		if (pos < this.longitud){
			int i = 0;
			Nodo actual = this.cabeza;
			while (i < pos){
				actual = actual.getSiguiente();
				i++;
			}
			if (actual.getSiguiente() != null){
				actual.getSiguiente().setAnterior(actual.getAnterior());
			}
			else{
				this.cola = actual.getAnterior();
			}
			if (actual.getAnterior() != null){
				actual.getAnterior().setSiguiente(actual.getSiguiente());
			}
			else{
				this.cabeza = actual.getSiguiente();
			}
			this.longitud+=-1;
		}
	}	
	
	public int getLongitud(){
		return this.longitud;
	}
}