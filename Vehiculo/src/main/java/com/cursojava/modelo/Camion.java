package com.cursojava.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Camion y extiende la clase Vehiculo.
 * Por lo que también implementa la interfaz Conducible.
 * 
 * @author Javier Darriba Gonzalez / Viewnext
 * @version 1.0 10/12/2024
 */
public class Camion extends Vehiculo {
	private final List<Double> tacometro;

	public Camion(String matricula, Color color, int numeroRuedas) {
		super(matricula, color, validarNumeroRuedas(numeroRuedas));
		this.tacometro = new ArrayList<>();
	}

	/**
     * Valida el número de ruedas que tiene el Camión.
     * 
     * @param numeroRuedas indica el número de ruedas del camion
     * @return numero de ruedas validado
     * @exception IllegalArgumentException en caso de que el número de ruedas no sea 6, 8, 10 o 12
     */
	private static int validarNumeroRuedas(int numeroRuedas) {
		if (numeroRuedas != 6 && numeroRuedas != 8 && numeroRuedas != 10 && numeroRuedas != 12) {
            throw new IllegalArgumentException("Un camión solo puede tener 6, 8, 10 o 12 ruedas.");
        }
        return numeroRuedas;
	}

	@Override
    public void arrancar() {
        super.arrancar();
        tacometro.clear();
    }

	@Override
    public void avanzar(double metros) {
        super.avanzar(metros);
        tacometro.add(velocidad());
    }

	@Override
    public void retroceder(double metros) {
        super.avanzar(metros);
        tacometro.add(velocidad());
    }

	/**
     * Imprime la lista de velocidades registradas en el tacómetro.
     * Si está vacío lo indica.
     */
	public void velocidadesTacometro() {
	    if (tacometro.isEmpty()) {
	        System.out.println("El tacómetro está vacío, no se han registrado velocidades todavía");
	    } else {
	        System.out.println("Velocidades registradas en el tacómetro (km/h):");
	        for (int i = 0; i < tacometro.size(); i++) {
	            System.out.printf("Velocidad %d: %.2f km/h%n", i + 1, tacometro.get(i));
	        }
	    }
	}

}
