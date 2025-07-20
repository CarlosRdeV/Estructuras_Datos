package com.carlosrdev.demo.utils;

import java.util.*;

/**
 * Clase de utilidad para ayudar con las pruebas de ejercicios
 */
public class TestHelper {
    
    /**
     * Imprime un array de manera formateada
     */
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
    
    /**
     * Imprime una lista de manera formateada
     */
    public static <T> void printList(List<T> list) {
        System.out.println(list);
    }
    
    /**
     * Imprime un mapa de manera formateada
     */
    public static <K, V> void printMap(Map<K, V> map) {
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
    
    /**
     * Genera un array de números aleatorios
     */
    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(max - min + 1) + min;
        }
        return arr;
    }
    
    /**
     * Verifica si dos arrays son iguales
     */
    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }
    
    /**
     * Mide el tiempo de ejecución de una función
     */
    public static void measureTime(Runnable function, String description) {
        long startTime = System.nanoTime();
        function.run();
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000.0; // Convert to milliseconds
        System.out.printf("%s tomó %.2f ms%n", description, duration);
    }
}