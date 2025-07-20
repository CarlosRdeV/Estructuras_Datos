# 📚 ArrayList en Java

## 🎯 ¿Qué es un ArrayList?

**ArrayList** es como un array "inteligente" que puede **crecer y encogerse** automáticamente. Es parte del framework de Collections de Java y resuelve la limitación principal de los arrays: el tamaño fijo.

### 💡 Analogía Simple
Si un array es como una **fila fija de casilleros**, ArrayList es como una **fila extensible**:
- Puedes agregar más casilleros cuando necesites
- Puedes remover casilleros que no uses
- El sistema maneja automáticamente el espacio

## 🔧 Características Principales

- **Tamaño dinámico**: Crece y se reduce automáticamente
- **Indexado**: Acceso directo por posición (como arrays)
- **Tipo genérico**: Especificas el tipo de datos que contiene
- **Basado en arrays**: Internamente usa un array que se redimensiona

## 📝 Sintaxis Básica

### Importar y Declarar

```java
import java.util.ArrayList;

// Declaración con tipo específico
ArrayList<String> nombres = new ArrayList<>();
ArrayList<Integer> numeros = new ArrayList<>();
ArrayList<Double> precios = new ArrayList<>();

// También puedes usar la interfaz List (recomendado)
import java.util.List;
List<String> nombres = new ArrayList<>();
```

### Crear con Valores Iniciales

```java
import java.util.Arrays;

// Crear a partir de un array
List<String> frutas = new ArrayList<>(Arrays.asList("manzana", "banana", "naranja"));

// Crear con capacidad inicial (opcional, para optimización)
List<Integer> numeros = new ArrayList<>(10); // Capacidad inicial de 10
```

## 🛠️ Métodos Más Importantes

### 1. Agregar Elementos

```java
List<String> frutas = new ArrayList<>();

// Agregar al final
frutas.add("manzana");      // ["manzana"]
frutas.add("banana");       // ["manzana", "banana"]

// Agregar en posición específica
frutas.add(1, "naranja");   // ["manzana", "naranja", "banana"]

// Agregar todos los elementos de otra colección
List<String> masFrutas = Arrays.asList("uva", "fresa");
frutas.addAll(masFrutas);   // ["manzana", "naranja", "banana", "uva", "fresa"]
```

### 2. Acceder y Modificar Elementos

```java
List<String> frutas = Arrays.asList("manzana", "banana", "naranja");

// Obtener elemento por índice
String primera = frutas.get(0);      // "manzana"
String ultima = frutas.get(frutas.size() - 1); // "naranja"

// Modificar elemento
frutas.set(1, "kiwi");              // ["manzana", "kiwi", "naranja"]

// Obtener tamaño
int tamaño = frutas.size();         // 3
```

### 3. Buscar Elementos

```java
List<String> frutas = Arrays.asList("manzana", "banana", "naranja");

// Verificar si contiene un elemento
boolean tiene = frutas.contains("banana");    // true

// Encontrar índice de un elemento
int indice = frutas.indexOf("naranja");       // 2
int noEncontrado = frutas.indexOf("uva");     // -1

// Último índice (útil para duplicados)
int ultimoIndice = frutas.lastIndexOf("manzana");
```

### 4. Eliminar Elementos

```java
List<String> frutas = new ArrayList<>(Arrays.asList("manzana", "banana", "naranja", "banana"));

// Remover por índice
String removida = frutas.remove(0);          // Remueve "manzana", retorna la removida

// Remover por valor (primera ocurrencia)
boolean seRemovio = frutas.remove("banana"); // Remueve primera "banana", retorna true

// Remover todos los elementos
frutas.clear();                              // ArrayList vacío

// Verificar si está vacío
boolean vacio = frutas.isEmpty();            // true
```

### 5. Recorrer ArrayList

```java
List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);

// Forma tradicional con for
for (int i = 0; i < numeros.size(); i++) {
    System.out.println("Índice " + i + ": " + numeros.get(i));
}

// Forma moderna con for-each
for (Integer numero : numeros) {
    System.out.println(numero);
}

// Con streams (Java 8+)
numeros.forEach(System.out::println);
```

### 6. Convertir y Copiar

```java
List<String> original = Arrays.asList("a", "b", "c");

// Convertir a array
String[] array = original.toArray(new String[0]);

// Crear copia
List<String> copia = new ArrayList<>(original);

// Sublista (vista, no copia)
List<String> sub = original.subList(1, 3); // ["b", "c"]
```

## 📊 Ejemplo Completo: Sistema de Tareas

```java
import java.util.*;

public class SistemaTareas {
    public static void main(String[] args) {
        // Crear lista de tareas
        List<String> tareas = new ArrayList<>();
        
        // Agregar tareas
        tareas.add("Estudiar Java");
        tareas.add("Hacer ejercicio");
        tareas.add("Leer libro");
        tareas.add("Llamar a mamá");
        
        System.out.println("📋 Lista de Tareas (" + tareas.size() + " tareas):");
        mostrarTareas(tareas);
        
        // Completar una tarea (remover)
        System.out.println("\n✅ Tarea completada: " + tareas.remove(1));
        
        // Agregar nueva tarea urgente al inicio
        tareas.add(0, "URGENTE: Entregar proyecto");
        
        // Modificar una tarea
        tareas.set(2, "Leer libro de programación");
        
        System.out.println("\n📋 Lista Actualizada:");
        mostrarTareas(tareas);
        
        // Buscar tarea específica
        String buscar = "Estudiar Java";
        if (tareas.contains(buscar)) {
            int posicion = tareas.indexOf(buscar);
            System.out.println("\n🔍 Encontrada: '" + buscar + "' en posición " + posicion);
        }
    }
    
    public static void mostrarTareas(List<String> tareas) {
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
    }
}
```

## ⚡ Complejidad Temporal

| Operación | Complejidad | Explicación |
|-----------|-------------|-------------|
| `get(i)` | O(1) | Acceso directo por índice |
| `add(elemento)` | O(1) amortizado | Agregar al final |
| `add(i, elemento)` | O(n) | Debe mover elementos |
| `remove(i)` | O(n) | Debe mover elementos |
| `contains(elemento)` | O(n) | Búsqueda lineal |
| `size()` | O(1) | Variable interna |

## 🏋️‍♂️ Ejercicios

### 🟢 Ejercicios Fáciles

**Ejercicio 1: Filtrar Números Pares**
```java
// Crea un método que tome una lista de enteros y retorne una nueva lista solo con los pares
public static List<Integer> filtrarPares(List<Integer> numeros) {
    // Tu código aquí
    // Ejemplo: [1, 2, 3, 4, 5, 6] → [2, 4, 6]
}
```

**Ejercicio 2: Duplicar Elementos**
```java
// Crea un método que duplique todos los elementos de una lista de enteros
public static void duplicarElementos(List<Integer> numeros) {
    // Tu código aquí (modifica la lista original)
    // Ejemplo: [1, 2, 3] → [1, 1, 2, 2, 3, 3]
}
```

### 🟡 Ejercicios Medios

**Ejercicio 3: Remover Duplicados**
```java
// Remueve todos los elementos duplicados de una lista, manteniendo solo la primera ocurrencia
public static void removerDuplicados(List<String> lista) {
    // Tu código aquí
    // Ejemplo: ["a", "b", "a", "c", "b"] → ["a", "b", "c"]
}
```

**Ejercicio 4: Intercalar Listas**
```java
// Intercala los elementos de dos listas del mismo tamaño
public static List<Integer> intercalar(List<Integer> lista1, List<Integer> lista2) {
    // Tu código aquí
    // Ejemplo: [1, 3, 5] y [2, 4, 6] → [1, 2, 3, 4, 5, 6]
}
```

### 🔴 Ejercicios Difíciles

**Ejercicio 5: Rotación Óptima**
```java
// Rota una lista k posiciones hacia la izquierda usando mínimo espacio extra
public static void rotarIzquierda(List<Integer> lista, int k) {
    // Tu código aquí (debe ser eficiente en espacio)
    // Ejemplo: [1, 2, 3, 4, 5], k=2 → [3, 4, 5, 1, 2]
}
```

**Ejercicio 6: Merge Sort en ArrayList**
```java
// Implementa el algoritmo Merge Sort para ordenar un ArrayList
public static void mergeSort(List<Integer> lista) {
    // Tu código aquí
    // Debe ordenar la lista original usando el algoritmo merge sort
}
```

## 🆚 ArrayList vs Array

| Característica | Array | ArrayList |
|----------------|-------|-----------|
| **Tamaño** | Fijo | Dinámico |
| **Sintaxis** | `int[] arr = new int[5]` | `List<Integer> list = new ArrayList<>()` |
| **Tipos** | Primitivos y objetos | Solo objetos (usa wrappers) |
| **Rendimiento** | Más rápido | Ligeramente más lento |
| **Memoria** | Menos overhead | Más overhead |
| **Métodos** | Limitados | Muchos métodos útiles |

## 💡 Cuándo Usar ArrayList

✅ **Usa ArrayList cuando:**
- No sabes el tamaño final de los datos
- Necesitas agregar/remover elementos frecuentemente  
- Quieres métodos útiles como `contains`, `indexOf`, etc.
- Trabajas con objetos (no primitivos)

❌ **Usa Array cuando:**
- El tamaño es fijo y conocido
- Necesitas máximo rendimiento
- Trabajas principalmente con tipos primitivos
- La memoria es muy limitada

## 🚀 Siguiente Paso

Ahora que entiendes ArrayList, es momento de aprender sobre **LinkedList** en [03-LinkedList.md](03-LinkedList.md), que maneja los datos de manera completamente diferente usando nodos enlazados.