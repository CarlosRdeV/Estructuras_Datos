# 📚 LinkedList en Java

## 🎯 ¿Qué es una LinkedList?

**LinkedList** es una estructura de datos donde los elementos están conectados mediante **enlaces** (referencias). A diferencia de ArrayList que usa un array interno, LinkedList usa **nodos** que apuntan al siguiente elemento, formando una cadena.

### 💡 Analogía Simple
Imagina una **cadena humana** donde cada persona:
- Tiene un dato (el elemento)
- Conoce quién es la siguiente persona (referencia al siguiente nodo)
- Para llegar a alguien específico, debes pasar persona por persona

## 🔧 Características Principales

- **Estructura enlazada**: Cada elemento apunta al siguiente
- **Tamaño dinámico**: Crece y se reduce fácilmente
- **Inserción/eliminación eficiente**: Especialmente al inicio y final
- **No indexada**: Para llegar al elemento N, debes pasar por todos los anteriores

## 📝 Estructura Interna

```java
// Así se ve internamente un nodo de LinkedList (simplificado)
class Node<E> {
    E data;           // El dato que almacena
    Node<E> next;     // Referencia al siguiente nodo
    Node<E> prev;     // Referencia al nodo anterior (LinkedList es doblemente enlazada)
}
```

### Representación Visual
```
[A] ⟷ [B] ⟷ [C] ⟷ [D]
 ↑                   ↑
first              last
```

## 📝 Sintaxis Básica

### Importar y Declarar

```java
import java.util.LinkedList;
import java.util.List;

// Crear LinkedList
LinkedList<String> nombres = new LinkedList<>();

// Usando interfaz List (recomendado)
List<String> nombres = new LinkedList<>();

// Con valores iniciales
LinkedList<Integer> numeros = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
```

## 🛠️ Métodos Más Importantes

### 1. Agregar Elementos

```java
LinkedList<String> lista = new LinkedList<>();

// Agregar al final
lista.add("A");           // [A]
lista.addLast("B");       // [A, B] (equivalente a add)

// Agregar al inicio
lista.addFirst("Z");      // [Z, A, B]

// Agregar en posición específica
lista.add(1, "X");        // [Z, X, A, B]

// Agregar como stack (pila)
lista.push("TOP");        // [TOP, Z, X, A, B] (equivalente a addFirst)
```

### 2. Acceder a Elementos

```java
LinkedList<String> lista = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));

// Obtener primer y último elemento
String primero = lista.getFirst();    // "A"
String ultimo = lista.getLast();      // "D"

// Obtener por índice (más lento que ArrayList)
String segundo = lista.get(1);        // "B"

// Peek (ver sin remover)
String cabeza = lista.peek();         // "A" (primer elemento)
String cola = lista.peekLast();       // "D" (último elemento)
```

### 3. Remover Elementos

```java
LinkedList<String> lista = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));

// Remover primer y último elemento
String primero = lista.removeFirst(); // Remueve y retorna "A"
String ultimo = lista.removeLast();   // Remueve y retorna "D"

// Remover como stack/queue
String cabeza = lista.poll();         // Remueve y retorna primer elemento
String cola = lista.pollLast();       // Remueve y retorna último elemento

// Remover por índice
String removido = lista.remove(1);    // Remueve elemento en posición 1

// Remover por valor
boolean seRemovio = lista.remove("B"); // Remueve primera ocurrencia de "B"
```

### 4. Métodos Especiales de LinkedList

```java
LinkedList<Integer> cola = new LinkedList<>();

// Usar como QUEUE (Cola - FIFO: First In, First Out)
cola.offer(1);        // Agregar al final [1]
cola.offer(2);        // Agregar al final [1, 2]
cola.offer(3);        // Agregar al final [1, 2, 3]
int siguiente = cola.poll();  // Remover del inicio → 1, queda [2, 3]

// Usar como STACK (Pila - LIFO: Last In, First Out)
LinkedList<String> pila = new LinkedList<>();
pila.push("primero");     // [primero]
pila.push("segundo");     // [segundo, primero]
pila.push("tercero");     // [tercero, segundo, primero]
String tope = pila.pop(); // Remover del tope → "tercero"
```

### 5. Iteración

```java
LinkedList<String> lista = new LinkedList<>(Arrays.asList("A", "B", "C"));

// For-each (recomendado)
for (String elemento : lista) {
    System.out.println(elemento);
}

// Iterator tradicional
Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}

// Iterator hacia atrás
Iterator<String> descIt = lista.descendingIterator();
while (descIt.hasNext()) {
    System.out.println(descIt.next()); // C, B, A
}
```

## 📊 Ejemplo Completo: Sistema de Playlist

```java
import java.util.*;

public class PlaylistMusical {
    public static void main(String[] args) {
        LinkedList<String> playlist = new LinkedList<>();
        
        // Agregar canciones
        playlist.add("Bohemian Rhapsody");
        playlist.add("Stairway to Heaven");
        playlist.add("Hotel California");
        
        System.out.println("🎵 Playlist inicial:");
        mostrarPlaylist(playlist);
        
        // Agregar canción urgente al inicio
        playlist.addFirst("🔥 NUEVA: Blinding Lights");
        
        // Agregar al final
        playlist.addLast("Sweet Child O' Mine");
        
        System.out.println("\n🎵 Después de agregar:");
        mostrarPlaylist(playlist);
        
        // Simular reproducción (remover del inicio)
        System.out.println("\n▶️ Reproduciendo: " + playlist.removeFirst());
        System.out.println("▶️ Reproduciendo: " + playlist.removeFirst());
        
        System.out.println("\n🎵 Canciones restantes:");
        mostrarPlaylist(playlist);
        
        // Ver siguiente sin reproducir
        if (!playlist.isEmpty()) {
            System.out.println("\n⏭️ Siguiente: " + playlist.peek());
        }
        
        // Funciones de navegación
        System.out.println("🔀 Mezclando playlist...");
        Collections.shuffle(playlist);
        mostrarPlaylist(playlist);
    }
    
    public static void mostrarPlaylist(LinkedList<String> playlist) {
        if (playlist.isEmpty()) {
            System.out.println("  (Playlist vacía)");
            return;
        }
        
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + playlist.get(i));
        }
    }
}
```

## ⚡ Complejidad Temporal

| Operación | ArrayList | LinkedList | Explicación LinkedList |
|-----------|-----------|------------|----------------------|
| `get(i)` | O(1) | O(n) | Debe recorrer desde el inicio |
| `add(elemento)` | O(1) amortizado | O(1) | Agregar al final es directo |
| `add(0, elemento)` | O(n) | O(1) | Cambiar referencia del primer nodo |
| `remove(0)` | O(n) | O(1) | Cambiar referencia del primer nodo |
| `remove(i)` | O(n) | O(n) | Debe encontrar el nodo primero |

## 🏋️‍♂️ Ejercicios

### 🟢 Ejercicios Fáciles

**Ejercicio 1: Invertir LinkedList**
```java
// Invierte una LinkedList usando solo sus métodos (sin crear nueva)
public static void invertirLista(LinkedList<Integer> lista) {
    // Tu código aquí
    // Ejemplo: [1, 2, 3, 4] → [4, 3, 2, 1]
    // Pista: usa removeFirst() y addLast()
}
```

**Ejercicio 2: Encontrar el Medio**
```java
// Encuentra el elemento del medio de una LinkedList
public static String encontrarMedio(LinkedList<String> lista) {
    // Tu código aquí
    // Ejemplo: ["A", "B", "C", "D", "E"] → "C"
    // Si hay tamaño par, retorna el primer elemento del medio
}
```

### 🟡 Ejercicios Medios

**Ejercicio 3: Merge de Dos Listas Ordenadas**
```java
// Combina dos LinkedList ordenadas en una sola lista ordenada
public static LinkedList<Integer> mergeListas(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
    // Tu código aquí
    // Ejemplo: [1, 3, 5] y [2, 4, 6] → [1, 2, 3, 4, 5, 6]
}
```

**Ejercicio 4: Remover Cada N Elementos**
```java
// Remueve cada n-ésimo elemento de la lista (problema de Josephus simplificado)
public static void removerCadaN(LinkedList<String> lista, int n) {
    // Tu código aquí
    // Ejemplo: ["A", "B", "C", "D", "E"], n=2 → remover "B", "D"
}
```

### 🔴 Ejercicios Difíciles

**Ejercicio 5: Detectar Ciclo**
```java
// Simula y detecta si hay un "ciclo" en una LinkedList
// (Para este ejercicio, simula creando una lista donde el último elemento "apunte" al primero)
public static boolean tieneCiclo(LinkedList<Integer> lista) {
    // Tu código aquí - usa el algoritmo de Floyd (tortuga y liebre)
    // Pista: usa dos "iteradores" a diferentes velocidades
}
```

**Ejercicio 6: Implementar LRU Cache**
```java
// Implementa un cache LRU (Least Recently Used) usando LinkedList
public class LRUCache<K, V> {
    private final int capacidad;
    private LinkedList<Pair<K, V>> cache;
    
    public LRUCache(int capacidad) {
        this.capacidad = capacidad;
        this.cache = new LinkedList<>();
    }
    
    public V get(K key) {
        // Tu código aquí
        // Si existe, moverlo al frente y retornar valor
    }
    
    public void put(K key, V value) {
        // Tu código aquí
        // Agregar al frente, si existe actualizar y mover al frente
        // Si excede capacidad, remover el último
    }
}
```

## 🆚 ArrayList vs LinkedList

| Operación | Mejor Opción | ¿Por qué? |
|-----------|--------------|-----------|
| **Acceso aleatorio** | ArrayList | O(1) vs O(n) |
| **Inserción al inicio** | LinkedList | O(1) vs O(n) |
| **Inserción al final** | Empate | Ambos O(1) |
| **Inserción en medio** | LinkedList | Si ya tienes la referencia |
| **Memoria** | ArrayList | Menos overhead por elemento |
| **Iteración secuencial** | ArrayList | Mejor localidad de memoria |

## 💡 Cuándo Usar LinkedList

✅ **Usa LinkedList cuando:**
- Insertas/eliminas frecuentemente al inicio o en posiciones conocidas
- Implementas stacks, queues, o deques
- No necesitas acceso aleatorio por índice
- El tamaño varía mucho dinámicamente

❌ **Usa ArrayList cuando:**
- Accedes frecuentemente a elementos por índice
- Haces muchas búsquedas
- La memoria es limitada
- Iteras secuencialmente la mayor parte del tiempo

## 🚀 Siguiente Paso

Ahora que entiendes las listas, es momento de aprender sobre **HashMap** en [04-HashMap.md](04-HashMap.md), donde exploraremos las estructuras clave-valor que permiten búsquedas súper rápidas.