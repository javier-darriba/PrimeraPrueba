package com.cursojava.modelo;

/**
 * Clase que representa un Coche y extiende la clase Vehiculo.
 * Por lo que también implementa la interfaz Conducible.
 * 
 * @author Javier Darriba Gonzalez / Viewnext
 * @version 1.0 10/12/2024
 */
public class Coche extends Vehiculo {

	public Coche(String matricula, Color color) {
		super(matricula, color, 4);
	}

}
