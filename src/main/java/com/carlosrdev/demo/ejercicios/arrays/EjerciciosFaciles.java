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
        // TODO: Implementar este método
        return 0;
    }
    
    /**
     * Ejercicio 2: Suma todos los elementos de un array
     * @param numeros Array de enteros
     * @return La suma de todos los elementos
     */
    public static int sumarElementos(int[] numeros) {
        // TODO: Implementar este método
        return 0;
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
    }
}