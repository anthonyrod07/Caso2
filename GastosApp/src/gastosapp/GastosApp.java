/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gastosapp;

/**
 *
 * @author rodri
 */
import java.util.Scanner;

public class GastosApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de amigos que desea solicitar: ");
        int numAmigos = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                numAmigos = scanner.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ingrese un número válido para la cantidad de amigos que necesita:");
                scanner.next(); 
            }
        }
        scanner.nextLine(); 

        SistemaDeGastos sistema = new SistemaDeGastos(numAmigos);

        for (int i = 0; i < numAmigos; i++) {
            String nombre;
            do {
                System.out.print("Ingrese el nombre del Amigo " + (i + 1) + ": ");
                nombre = scanner.nextLine();
            } while (!esNombrePermitido(nombre));

            sistema.amigos[i] = new Amigo(nombre);
        }

        String[][] tablaMovimientos = {
            {"Cuenta 1", "Desayuno CoffePrime", "Josua, Greivin, Guillermo,Andres, Tavo, David ", "Guillermo", "120", "Dolares"},
            {"Cuenta 2", "Almuerzo Pig Factory", "Josua, Greivin, Guillermo,Andres, Tavo ", "Guillermo", "200", "Dolares"},
            {"Cuenta 3", "Cena FastFood", "Josua, David ", "David", "50", "Dolares"},
            {"Cuenta 4", "Pizza Hut", "Greivin, Guillermo,Andres, Tavo", "Tavo", "100", "Dolares"},
            {"Cuenta 5", "Quicksilver Store", "Guillermo ", "Greivin", "150", "Dolares"},
            {"Cuenta 6", "Apple Store", "Andres", "Josue", "200", "Dolares"},
            {"Cuenta 7", "Desayuno Chilis", "Josua, Greivin, Guillermo,Andres, Tavo, David ", "Greivin", "150", "Dolares"},
            {"Cuenta 8", "Almuerzo Hooters", "Josua, Greivin, Guillermo,Andres, Tavo, David ", "Tavo", "180", "Dolares"},
        };
        
        for (String[] movimiento : tablaMovimientos) {
            Movimiento nuevoMovimiento = new Movimiento(movimiento[1], numAmigos);
            for (int i = 2; i < movimiento.length - 2; i++) {
                nuevoMovimiento.agregarGasto(buscarIndiceAmigo(sistema.amigos, movimiento[i]), Double.parseDouble(movimiento[4]));
            }
            sistema.agregarMovimiento(nuevoMovimiento);
        }

        sistema.agregarMovimiento(new Movimiento("Cinepolis", numAmigos));
        sistema.movimientos[4].agregarGasto(0, 30.0);
        sistema.movimientos[4].agregarGasto(1, 25.0);
        
        System.out.print("Ingrese el nombre del amigo que desee analizar: ");
        String amigoAnalizar = scanner.nextLine();
        sistema.analizarDeuda(amigoAnalizar);
    }

    private static boolean esNombrePermitido(String nombre) {
        String[] nombresPermitidos = {"Josua", "Greivin", "Guillermo", "Andres", "Tavo", "David"};
        for (String nombrePermitido : nombresPermitidos) {
            if (nombrePermitido.equals(nombre)) {
                return true;
            }
        }
        System.out.println("Nombre no es permitido. Ingrese un nombre que sea valido.");
        return false;
    }

    private static int buscarIndiceAmigo(Amigo[] amigos, String nombreAmigo) {
        for (int i = 0; i < amigos.length; i++) {
            if (amigos[i].nombre.equals(nombreAmigo)) {
                return i;
            }
        }
        return -1;
    }
}