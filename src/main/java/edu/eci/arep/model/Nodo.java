package edu.eci.arep.model;

/**
 * Es una calculadora que dado un archivo con una fila de datos, calcula la media y desviación estandar de estos.
 */
public class Nodo {
	private double valor;
	private Nodo siguiente;
	private Nodo anterior;
	public Nodo(double valor){
		this.valor = valor;
	}
	public Nodo(double valor, Nodo siguiente, Nodo anterior){
		this.valor = valor;
		this.siguiente = siguiente;
		this.anterior = anterior;
	}
	public double getValor(){
		return this.valor;
	}
	public Nodo getSiguiente(){
		return this.siguiente;
	}
	public Nodo getAnterior(){
		return this.anterior;
	}
	public void setValor(double valor){
		this.valor = valor;
	}
	public void setSiguiente(Nodo siguiente){
		this.siguiente = siguiente;
	}
	public void setAnterior(Nodo anterior){
		this.anterior = anterior;
	}
}