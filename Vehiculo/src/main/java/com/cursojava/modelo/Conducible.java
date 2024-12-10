package com.cursojava.modelo;

/**
 * Interfaz que proporciona los metodos necesarios para controlar un vehiculo.
 * 
 * @author Javier Darriba Gonzalez / Viewnext
 * @version 1.0 10/12/2024
 */
public interface Conducible {
	
	public void avanzar(double metros);
	
	public void retroceder(double metros);
	
	public void parar();

}
