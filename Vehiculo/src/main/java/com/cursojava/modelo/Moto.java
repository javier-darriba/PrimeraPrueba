package com.cursojava.modelo;

/**
 * Clase que representa una Moto y extiende la clase Vehiculo.
 * Por lo que también implementa la interfaz Conducible.
 * 
 * @author Javier Darriba Gonzalez / Viewnext
 * @version 1.0 10/12/2024
 */
public class Moto extends Vehiculo {

	public Moto(String matricula, Color color) {
		super(matricula, color, 2);
	}

}