package com.carlosrdev.demo.ejercicios.arrays;

import com.carlosrdev.demo.utils.TestHelper;

/**
 * Ejercicios fáciles de Arrays del curso
 */
public class EjerciciosFaciles {
    
    /**
     * Ejercicio 1: Encuentra el número más grande en un array
     * @param numeros Array de enteros
     * @return El número más grande
     */
    public static int encontrarMaximo(int[] numeros) {
        int max = numeros[0];
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > max) {
                max = numeros[i];
            }
        }
        return max;
    }
    
    /**
     * Ejercicio 2: Suma todos los elementos de un array
     * @param numeros Array de enteros
     * @return La suma de todos los elementos
     */
    public static int sumarElementos(int[] numeros) {
        int suma = 0;
        for (int numero : numeros) {
            suma += numero;
        }
        return suma;
    }

    /**
     * Ejercicio 3: Cuantos numeros pares hay en un array
     * @param numeros Array de enteros
     * @return Conteo de pares en el Array
     */
    public static int contarPares(int[] numeros) {
        int contador = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }
    
    /**
     * Método main para probar los ejercicios
     */
    public static void main(String[] args) {
        System.out.println("=== Ejercicios Fáciles de Arrays ===");
        
        // Datos de prueba
        int[] numeros = {5, 2, 8, 1, 9, 3};
        
        // Probar ejercicio 1
        System.out.println("Array: ");
        TestHelper.printArray(numeros);
        System.out.println("Máximo: " + encontrarMaximo(numeros));
        
        // Probar ejercicio 2
        System.out.println("Suma: " + sumarElementos(numeros));

        System.out.println("Contar pares: " + contarPares(numeros));
    }
}