/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gastosapp;

class Movimiento {

    String descripcion;
    double[] gastos;

    public Movimiento(String descripcion, int numAmigos) {
        this.descripcion = descripcion;
        this.gastos = new double[numAmigos];
    }

    public void agregarGasto(int indiceAmigo, double monto) {

        if (indiceAmigo >= 0 && indiceAmigo < gastos.length) {
            gastos[indiceAmigo] += monto;
        } else {

            System.out.println("Índice de amigo que se encuentra fuera de los límites.");
        }

    }
}
