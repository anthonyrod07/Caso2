/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gastosapp;

import java.util.Scanner;

class SistemaDeGastos {

    Amigo[] amigos;
    Movimiento[] movimientos;
    int numAmigos;

    public SistemaDeGastos(int numAmigos) {
        this.amigos = new Amigo[numAmigos];
        this.movimientos = new Movimiento[0];
        this.numAmigos = numAmigos;

        for (int i = 0; i < numAmigos; i++) {
            System.out.print("Ingrese el nombre del Amigo " + (i + 1) + ": ");
            Scanner scanner = new Scanner(System.in);
            String nombre = scanner.nextLine();
            amigos[i] = new Amigo(nombre);
        }
    }

    public void agregarMovimiento(Movimiento movimiento) {
        Movimiento[] temp = new Movimiento[movimientos.length + 1];
        System.arraycopy(movimientos, 0, temp, 0, movimientos.length);
        temp[movimientos.length] = movimiento;
        movimientos = temp;
    }

    public void analizarDeuda(String amigo) {
        Amigo amigoSeleccionado = null;

        for (Amigo a : amigos) {
            if (a.nombre.equals(amigo)) {
                amigoSeleccionado = a;
                break;
            }
        }

        if (amigoSeleccionado != null) {
            for (Movimiento m : movimientos) {
                amigoSeleccionado.deuda += m.gastos[buscarIndiceAmigo(amigo)];
            }

            System.out.println("Total que le deben a " + amigo + ": " + amigoSeleccionado.deuda);
        } else {
            System.out.println("Este amigo no pudo ser encontrado.");
        }
    }

    private int buscarIndiceAmigo(String nombreAmigo) {
        for (int i = 0; i < numAmigos; i++) {
            if (amigos[i].nombre.equals(nombreAmigo)) {
                return i;
            }
        }
        return -1;
    }
}

