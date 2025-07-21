package com.carlosrdev.demo.ejercicios.arrays;

import com.carlosrdev.demo.utils.TestHelper;

public class EjerciciosMedios {

    /**
     * Ejercicio 0: Ordenar de forma descendente
     * @param numeros Array de enteros
     * @return Array ordenado de mayor a menor
     */
    public static int[] ordernarArray(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Ciclo i: " + i);
            int valorActual = numeros[i];
            int max = 0;
            int indexMax = 0;

            for (int j = i; j < numeros.length; j++) {
                System.out.println("Ciclo j: " + j );
                if (max < numeros[j]) {
                    max = numeros[j];
                    indexMax = j;
                }
            }
            System.out.println("Max: " + max);
            System.out.println("IndexMax: " + indexMax  );
            numeros[i] = max;
            numeros[indexMax] = valorActual;
        }
        return numeros;
    }

    /**
     * Ejercicio 1: Invertir un array
     * @param numeros Array de enteros
     * @return Array con los valores invertidos
     */
    public static int[] invertirArray(int[] numeros) {
        for (int i = 0; i < numeros.length / 2; i++) {
            int valorIzquierdo = numeros[i]; // El valor actual en la izquierda
            int indiceDerecho = numeros.length - 1 - i; // El índice del elemento opuesto
            int valorDerecho = numeros[indiceDerecho]; // El valor del elemento opuesto

            // Realizamos el intercambio
            numeros[i] = valorDerecho;
            numeros[indiceDerecho] = valorIzquierdo;
        }
        return numeros;
    }

    /**
     * Método main para probar los ejercicios
     */
    public static void main(String[] args) {
        System.out.println("=== Ejercicios Medios de Arrays ===");

        // Datos de prueba
        int[] numeros = {1,22,3,1,5,0};

        // Probar ejercicio 1
        System.out.println("Array: ");
        TestHelper.printArray(numeros);
        System.out.println("invertirArray : " );
        TestHelper.printArray(invertirArray(numeros));

        // Probar ejercicio 2
    }
}
