# 📚 Arrays (Arreglos) en Java

## 🎯 ¿Qué es un Array?

Un **array** es la estructura de datos más básica en Java. Es una colección de elementos del mismo tipo, almacenados en posiciones de memoria consecutivas. Cada elemento tiene un **índice** (posición) que empieza desde 0.

### 💡 Analogía Simple
Piensa en un array como una **fila de casilleros numerados** en un gimnasio:
- Cada casillero tiene un número (índice)
- Todos los casilleros son del mismo tamaño (mismo tipo de dato)
- Puedes acceder directamente a cualquier casillero si conoces su número

## 🔧 Características Principales

- **Tamaño fijo**: Una vez creado, no puede cambiar de tamaño
- **Indexado**: Acceso directo por posición (muy rápido)
- **Homogéneo**: Todos los elementos son del mismo tipo
- **Eficiente en memoria**: Los elementos están juntos en memoria

## 📝 Sintaxis Básica

### Declaración e Inicialización

```java
// Forma 1: Declarar y crear por separado
int[] numeros;
numeros = new int[5]; // Array de 5 enteros

// Forma 2: Declarar y crear en una línea
int[] numeros = new int[5];

// Forma 3: Crear con valores iniciales
int[] numeros = {10, 20, 30, 40, 50};

// Forma 4: Crear con new y valores
int[] numeros = new int[]{10, 20, 30, 40, 50};
```

### Acceso a Elementos

```java
int[] numeros = {10, 20, 30, 40, 50};

// Leer elementos
int primero = numeros[0];    // 10
int tercero = numeros[2];    // 30

// Modificar elementos  
numeros[1] = 99;             // Ahora es {10, 99, 30, 40, 50}

// Obtener la longitud
int tamaño = numeros.length; // 5
```

## 🛠️ Operaciones Más Importantes

### 1. Recorrer un Array

```java
int[] numeros = {10, 20, 30, 40, 50};

// Forma tradicional con for
for (int i = 0; i < numeros.length; i++) {
    System.out.println("Índice " + i + ": " + numeros[i]);
}

// Forma moderna con for-each
for (int numero : numeros) {
    System.out.println(numero);
}
```

### 2. Buscar un Elemento

```java
public static int buscar(int[] array, int elemento) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == elemento) {
            return i; // Retorna el índice donde lo encontró
        }
    }
    return -1; // No encontrado
}
```

### 3. Encontrar el Máximo y Mínimo

```java
public static int encontrarMaximo(int[] array) {
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
        if (array[i] > max) {
            max = array[i];
        }
    }
    return max;
}

public static int encontrarMinimo(int[] array) {
    int min = array[0];
    for (int i = 1; i < array.length; i++) {
        if (array[i] < min) {
            min = array[i];
        }
    }
    return min;
}
```

### 4. Copiar un Array

```java
import java.util.Arrays;

int[] original = {1, 2, 3, 4, 5};

// Método 1: Arrays.copyOf()
int[] copia1 = Arrays.copyOf(original, original.length);

// Método 2: System.arraycopy()
int[] copia2 = new int[original.length];
System.arraycopy(original, 0, copia2, 0, original.length);

// Método 3: clone()
int[] copia3 = original.clone();
```

### 5. Ordenar un Array

```java
import java.util.Arrays;

int[] numeros = {5, 2, 8, 1, 9};
Arrays.sort(numeros); // Ordena el array original
// Resultado: {1, 2, 5, 8, 9}
```

## 📊 Ejemplo Completo

```java
public class EjemploArrays {
    public static void main(String[] args) {
        // Crear array de calificaciones
        double[] calificaciones = {8.5, 9.2, 7.8, 6.5, 9.8, 8.0};
        
        // Mostrar todas las calificaciones
        System.out.println("Calificaciones:");
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Estudiante " + (i+1) + ": " + calificaciones[i]);
        }
        
        // Calcular promedio
        double suma = 0;
        for (double nota : calificaciones) {
            suma += nota;
        }
        double promedio = suma / calificaciones.length;
        System.out.println("Promedio: " + promedio);
        
        // Encontrar la mejor calificación
        double mejor = calificaciones[0];
        for (double nota : calificaciones) {
            if (nota > mejor) {
                mejor = nota;
            }
        }
        System.out.println("Mejor calificación: " + mejor);
    }
}
```

## 🏋️‍♂️ Ejercicios

### 🟢 Ejercicios Fáciles

**Ejercicio 1: Suma de Elementos**
```java
// Escribe un método que sume todos los elementos de un array de enteros
public static int sumarElementos(int[] array) {
    // Tu código aquí
    // Ejemplo: {1, 2, 3, 4, 5} → resultado: 15
}
```

**Ejercicio 2: Contar Pares**
```java
// Escribe un método que cuente cuántos números pares hay en un array
public static int contarPares(int[] array) {
    // Tu código aquí
    // Ejemplo: {1, 2, 3, 4, 5, 6} → resultado: 3
}
```

### 🟡 Ejercicios Medios

**Ejercicio 3: Invertir Array**
```java
// Escribe un método que invierta los elementos de un array sin crear uno nuevo
public static void invertirArray(int[] array) {
    // Tu código aquí
    // Ejemplo: {1, 2, 3, 4, 5} → {5, 4, 3, 2, 1}
}
```

**Ejercicio 4: Segundo Mayor**
```java
// Encuentra el segundo número más grande en un array (sin duplicados)
public static int segundoMayor(int[] array) {
    // Tu código aquí
    // Ejemplo: {3, 1, 4, 1, 5, 9, 2} → resultado: 5 (el segundo mayor único)
}
```

### 🔴 Ejercicios Difíciles

**Ejercicio 5: Rotar Array**
```java
// Rota un array k posiciones hacia la derecha
public static void rotarDerecha(int[] array, int k) {
    // Tu código aquí
    // Ejemplo: {1, 2, 3, 4, 5}, k=2 → {4, 5, 1, 2, 3}
}
```

**Ejercicio 6: Subarray con Mayor Suma**
```java
// Encuentra la suma máxima de un subarray contiguo (Algoritmo de Kadane)
public static int maxSumaSubarray(int[] array) {
    // Tu código aquí
    // Ejemplo: {-2, 1, -3, 4, -1, 2, 1, -5, 4} → resultado: 6 (subarray {4, -1, 2, 1})
}
```

## 💡 Consejos Importantes

1. **Índices válidos**: Siempre van de 0 a `length-1`
2. **ArrayIndexOutOfBoundsException**: Cuidado con acceder a índices inválidos
3. **Inmutabilidad del tamaño**: No puedes cambiar el tamaño después de crear el array
4. **Inicialización**: Los arrays se inicializan con valores por defecto (0 para números, null para objetos)
5. **Referencia vs Valor**: Los arrays son objetos, se pasan por referencia

## 🚀 Siguiente Paso

Una vez que domines los arrays, estarás listo para aprender sobre **ArrayList** en [02-ArrayList.md](02-ArrayList.md), que es como un array que puede crecer y reducirse dinámicamente.