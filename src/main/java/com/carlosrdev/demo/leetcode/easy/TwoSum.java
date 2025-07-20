package com.carlosrdev.demo.leetcode.easy;

import java.util.Arrays;

/**
 * LeetCode #1 - Two Sum
 * https://leetcode.com/problems/two-sum/
 * 
 * Dificultad: Fácil
 * Tags: Array, Hash Table
 * 
 * Problema: Dado un array de enteros nums y un entero target,
 * retorna los índices de los dos números que suman target.
 */
public class TwoSum {
    
    /**
     * Solución usando fuerza bruta - O(n²)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        // TODO: Implementar solución fuerza bruta
        return new int[]{};
    }
    
    /**
     * Solución optimizada usando HashMap - O(n)
     */
    public static int[] twoSumOptimized(int[] nums, int target) {
        // TODO: Implementar solución optimizada
        return new int[]{};
    }
    
    /**
     * Método main para probar las soluciones
     */
    public static void main(String[] args) {
        System.out.println("=== LeetCode #1 - Two Sum ===");
        
        // Caso de prueba 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output (Brute Force): " + Arrays.toString(twoSumBruteForce(nums1, target1)));
        System.out.println("Output (Optimized): " + Arrays.toString(twoSumOptimized(nums1, target1)));
        System.out.println("Expected: [0, 1]");
        
        // Caso de prueba 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("\\nInput: " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output (Brute Force): " + Arrays.toString(twoSumBruteForce(nums2, target2)));
        System.out.println("Output (Optimized): " + Arrays.toString(twoSumOptimized(nums2, target2)));
        System.out.println("Expected: [1, 2]");
    }
}