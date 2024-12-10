package com.cursojava.modelo;

import java.time.Duration;
import java.time.Instant;

/**
 * Clase abstacta que representa un vehiculo generico e implementa la interfaz conducible.
 * Almacena la constante MATRICULA, que sirve como identificador y el color del vehiculo.
 * 
 * @author Javier Darriba Gonzalez / Viewnext
 * @version 1.0 10/12/2024
 */
public abstract class Vehiculo implements Conducible{
	public final String MATRICULA;
	protected Color color;
	public final int NUMERO_RUEDAS;
	private Instant tiempoInicio;
	private double espacioRecorrido;
	private Duration tiempoViaje;

	public Vehiculo(String matricula, Color color, int ruedas) {
		super();
		if (!(matricula != null && matricula.matches("^[A-Z0-9]+$"))) {
			throw new IllegalArgumentException("La matrícula debe estar compuesta de números y letras en mayúscula.");
		}
		if (color == null) {
			throw new IllegalArgumentException("El color no puede ser nulo.");
		}
		this.MATRICULA = matricula;
		this.color = color;
		this.NUMERO_RUEDAS = ruedas;
		this.tiempoInicio = null;
		this.espacioRecorrido = 0.0;
		this.tiempoViaje = Duration.ZERO;
	}

	public void pintar(Color color) {
		if (color == null) {
            throw new IllegalArgumentException("El color no puede ser nulo.");
        }
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public double getEspacioRecorrido() {
		return espacioRecorrido;
	}

	public Duration getTiempoViaje() {
		if (this.tiempoInicio == null) {
			return tiempoViaje;
		} else {
			return Duration.between(tiempoInicio, Instant.now());
		}
	}

	public double velocidad() {
		long tiempoEnSegundos = getTiempoViaje().toSeconds();
		if (tiempoEnSegundos == 0) {
			throw new IllegalStateException("No se puede calcular la velocidad sin tiempo de viaje.");
		}

		return (double) (espacioRecorrido / tiempoEnSegundos) * 3.6;
	}
	
	/**
     * Arrancar indica el inicio del viaje con la puesta en marcha del vehículo.
     * 
     * @exception IllegalStateException en caso de que el vehiculo ya estuviera en marcha
     */
	public void arrancar() {
		if (tiempoInicio != null) {
			throw new IllegalStateException("El vehículo ya está en marcha.");
		}
		tiempoInicio = Instant.now();
		espacioRecorrido = 0.0;
	}
	
	/**
     * Avanzar suma al espacio recorrido la distancia indicada.
     * 
     * @param metros Distancia recorrida en metros
     * @exception IllegalStateException en caso de que el vehiculo no hubiera arrancado previamente
     * @exception IllegalArgumentException en caso de que la distancia recorrida sea negativa o cero, 
     * si no se mueve no lo considero un avance
     */
	public void avanzar(double metros) {
		if (tiempoInicio == null) {
			throw new IllegalStateException("Debe arrancar el vehículo antes de avanzar.");
		}
		if (metros <= 0) {
	        throw new IllegalArgumentException("La distancia a avanzar debe ser un valor positivo.");
	    }
		espacioRecorrido += metros;
	}

	/**
     * Retroceder resta al espacio recorrido la distancia indicada.
     * 
     * @param metros Distancia recorrida en metros
     * @exception IllegalStateException en caso de que el vehiculo no hubiera arrancado previamente
     * @exception IllegalArgumentException en caso de que la distancia recorrida sea negativa o cero, 
     * si no se mueve no lo considero un retroceso
     * @exception IllegalStateException en caso de que quiera retrocederse más allá de la distancia inicial
     */
	@Override
	public void retroceder(double metros) {
	    if (tiempoInicio == null) {
	        throw new IllegalStateException("Debe arrancar el vehículo antes de retroceder.");
	    }
	    if (metros <= 0) {
	        throw new IllegalArgumentException("La distancia a retroceder debe ser un valor positivo.");
	    }
	    if (espacioRecorrido < metros) {
	        throw new IllegalStateException("No se puede retroceder más distancia de la recorrida.");
	    }
	    espacioRecorrido -= metros;
	}

	/**
     * Parar indica el final del viaje con la puesta detención del vehículo.
     * 
     * @exception IllegalStateException en caso de que el vehiculo ya esté detenido
     */
	public void parar() {
		if (tiempoInicio == null) {
			throw new IllegalStateException("El vehículo no está en marcha.");
		}
		tiempoViaje = Duration.between(tiempoInicio, Instant.now());
		tiempoInicio = null;
	}

	public void informeDeViaje() {
	    System.out.println("Informe de viaje:");
	    System.out.println("-----------------");
	    System.out.printf("Tiempo de viaje: %d segundos.%n", getTiempoViaje().toSeconds());
	    System.out.printf("Espacio recorrido: %.2f metros.%n", getEspacioRecorrido());
	    System.out.printf("Velocidad promedio: %.2f km/h.%n", velocidad());
	}

}
