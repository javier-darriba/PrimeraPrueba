package com.cursojava.principal;

import com.cursojava.modelo.Camion;
import com.cursojava.modelo.Color;

/**
 * Clase principal creada para simular viajes e imprimir la información por pantalla para probar las clases del modelo.
 * Indicar que tras empezar un viaje, antes de realizar cualquier cálculo que implique la velocidad debe pasar al menos 1 segundo.
 * 
 * @author Javier Darriba Gonzalez / Viewnext
 * @version 1.0 10/12/2024
 */
public class Viaje {

	public static void main(String[] args) throws InterruptedException {
		try {
            Camion camion = new Camion("5578FFK", Color.NEGRO, 8);
            System.out.println("Camión creado con matrícula: " + camion.MATRICULA);
            System.out.println("Color inicial: " + camion.getColor());
            System.out.println("Número de ruedas: " + camion.NUMERO_RUEDAS);

            camion.pintar(Color.AZUL);
            System.out.println("Color cambiado a: " + camion.getColor());

            camion.arrancar();
            System.out.println("El camión arranca el viaje");
            
            Thread.sleep(2000);
            
            camion.avanzar(100);
            System.out.println("Espacio recorrido: " + camion.getEspacioRecorrido() + " metros");

            Thread.sleep(500);
            camion.avanzar(200);
            System.out.println("Espacio recorrido: " + camion.getEspacioRecorrido() + " metros");

            camion.velocidadesTacometro();

            camion.parar();
            System.out.println("El camión termina el viaje");
            camion.informeDeViaje();

            camion.arrancar();
            System.out.println("Nuevo viaje iniciado");
            camion.velocidadesTacometro();
            
            Thread.sleep(3000);
            camion.avanzar(300);
            System.out.println("Espacio recorrido en el nuevo viaje: " + camion.getEspacioRecorrido() + " metros");
            
            camion.retroceder(50);
            System.out.println("Espacio recorrido en el nuevo viaje: " + camion.getEspacioRecorrido() + " metros");
            
            camion.parar();
            System.out.println("Nuevo viaje finalizado");
            camion.informeDeViaje();

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

	}

}
