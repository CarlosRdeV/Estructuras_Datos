# 📚 Stack y Queue en Java

## 🎯 ¿Qué son Stack y Queue?

**Stack** y **Queue** son estructuras de datos que restringen el acceso a los elementos según reglas específicas:

- **Stack (Pila)**: LIFO - "Last In, First Out" (Último en entrar, primero en salir)
- **Queue (Cola)**: FIFO - "First In, First Out" (Primero en entrar, primero en salir)

### 💡 Analogías Simples

**Stack** - Como una **pila de platos**:
- Solo puedes agregar platos arriba (push)
- Solo puedes quitar el plato de arriba (pop)
- El último plato que pusiste es el primero que puedes tomar

**Queue** - Como una **fila en el banco**:
- Las personas entran por atrás (enqueue)
- Las personas salen por adelante (dequeue)  
- El primero en llegar es el primero en ser atendido

## 🥞 STACK (Pila)

### 🔧 Características del Stack

- **LIFO**: Last In, First Out
- **Acceso restringido**: Solo puedes ver/modificar el elemento del tope
- **Operaciones principales**: push (agregar), pop (remover), peek/top (ver tope)

### 📝 Implementación en Java

Java tiene la clase `Stack`, pero es preferible usar `Deque` con `ArrayDeque`:

```java
import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

// Opción 1: Stack tradicional (menos recomendado)
Stack<Integer> pila = new Stack<>();

// Opción 2: Deque como Stack (más moderno y eficiente)
Deque<Integer> pila = new ArrayDeque<>();
```

### 🛠️ Métodos Principales del Stack

```java
Deque<String> pila = new ArrayDeque<>();

// Push - Agregar elemento al tope
pila.push("primero");    // ["primero"]
pila.push("segundo");    // ["segundo", "primero"] (segundo arriba)
pila.push("tercero");    // ["tercero", "segundo", "primero"]

// Peek - Ver el tope sin removerlo
String tope = pila.peek();  // "tercero" (no se remueve)

// Pop - Remover y obtener el tope
String removido = pila.pop();  // "tercero", queda ["segundo", "primero"]

// Verificar si está vacía
boolean vacia = pila.isEmpty();  // false

// Tamaño
int tamaño = pila.size();  // 2
```

### 📊 Ejemplo: Validador de Paréntesis

```java
import java.util.*;

public class ValidadorParentesis {
    public static boolean esValido(String expresion) {
        Deque<Character> pila = new ArrayDeque<>();
        
        for (char caracter : expresion.toCharArray()) {
            // Si es apertura, agregar a la pila
            if (caracter == '(' || caracter == '[' || caracter == '{') {
                pila.push(caracter);
            }
            // Si es cierre, verificar que coincida
            else if (caracter == ')' || caracter == ']' || caracter == '}') {
                if (pila.isEmpty()) {
                    return false; // Cierre sin apertura
                }
                
                char apertura = pila.pop();
                if (!coinciden(apertura, caracter)) {
                    return false; // No coinciden
                }
            }
        }
        
        return pila.isEmpty(); // Debe quedar vacía
    }
    
    private static boolean coinciden(char apertura, char cierre) {
        return (apertura == '(' && cierre == ')') ||
               (apertura == '[' && cierre == ']') ||
               (apertura == '{' && cierre == '}');
    }
    
    public static void main(String[] args) {
        String[] pruebas = {
            "()",           // true
            "()[]{}",       // true
            "(]",           // false
            "([)]",         // false
            "{[()]}",       // true
            "(((",          // false
        };
        
        for (String expresion : pruebas) {
            System.out.println(expresion + " → " + esValido(expresion));
        }
    }
}
```

## 🚶‍♂️ QUEUE (Cola)

### 🔧 Características del Queue

- **FIFO**: First In, First Out
- **Acceso restringido**: Agregar por atrás, remover por adelante
- **Operaciones principales**: offer/add (agregar), poll/remove (remover), peek (ver frente)

### 📝 Implementación en Java

```java
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;

// Opción 1: LinkedList como Queue
Queue<String> cola = new LinkedList<>();

// Opción 2: ArrayDeque como Queue (más eficiente)
Queue<String> cola = new ArrayDeque<>();
```

### 🛠️ Métodos Principales del Queue

```java
Queue<String> cola = new ArrayDeque<>();

// Offer/Add - Agregar elemento al final
cola.offer("primero");    // ["primero"]
cola.offer("segundo");    // ["primero", "segundo"]
cola.offer("tercero");    // ["primero", "segundo", "tercero"]

// Peek - Ver el frente sin removerlo
String frente = cola.peek();  // "primero" (no se remueve)

// Poll/Remove - Remover y obtener del frente
String removido = cola.poll();  // "primero", queda ["segundo", "tercero"]

// Verificar si está vacía
boolean vacia = cola.isEmpty();  // false

// Tamaño
int tamaño = cola.size();  // 2
```

**Diferencia entre métodos**:
- `offer()` vs `add()`: En colas limitadas, `offer()` retorna false si no puede agregar, `add()` lanza excepción
- `poll()` vs `remove()`: Si está vacía, `poll()` retorna null, `remove()` lanza excepción

### 📊 Ejemplo: Simulador de Impresora

```java
import java.util.*;

public class SimuladorImpresora {
    public static void main(String[] args) {
        Queue<Documento> colaImpresion = new ArrayDeque<>();
        
        // Agregar documentos a la cola
        colaImpresion.offer(new Documento("Reporte.pdf", 5));
        colaImpresion.offer(new Documento("Presentacion.pptx", 12));
        colaImpresion.offer(new Documento("Factura.pdf", 2));
        colaImpresion.offer(new Documento("Manual.docx", 25));
        
        System.out.println("🖨️ Simulador de Cola de Impresión");
        System.out.println("Documentos en cola: " + colaImpresion.size());
        
        // Simular impresión
        int tiempoTotal = 0;
        while (!colaImpresion.isEmpty()) {
            Documento siguiente = colaImpresion.peek();
            System.out.println("\\n⏳ Imprimiendo: " + siguiente.nombre + " (" + siguiente.paginas + " páginas)");
            
            // Simular tiempo de impresión
            int tiempoImpresion = siguiente.paginas * 2; // 2 segundos por página
            tiempoTotal += tiempoImpresion;
            
            // Remover de la cola
            colaImpresion.poll();
            
            System.out.println("✅ Completado en " + tiempoImpresion + " segundos");
            System.out.println("📄 Documentos restantes: " + colaImpresion.size());
        }
        
        System.out.println("\\n🎉 Todos los documentos impresos!");
        System.out.println("⏱️ Tiempo total: " + tiempoTotal + " segundos");
    }
}

class Documento {
    String nombre;
    int paginas;
    
    public Documento(String nombre, int paginas) {
        this.nombre = nombre;
        this.paginas = paginas;
    }
}
```

## 🔄 DEQUE (Double-Ended Queue)

**Deque** es una cola que permite agregar y remover desde ambos extremos:

```java
import java.util.Deque;
import java.util.ArrayDeque;

Deque<String> deque = new ArrayDeque<>();

// Agregar al frente
deque.addFirst("frente");      // ["frente"]
deque.offerFirst("nuevo");     // ["nuevo", "frente"]

// Agregar al final  
deque.addLast("final");        // ["nuevo", "frente", "final"]
deque.offerLast("ultimo");     // ["nuevo", "frente", "final", "ultimo"]

// Remover del frente
String primero = deque.removeFirst();  // "nuevo"
String frente = deque.pollFirst();     // "frente"

// Remover del final
String ultimo = deque.removeLast();    // "ultimo"
String final = deque.pollLast();       // "final"
```

## ⚡ Complejidad Temporal

| Operación | Stack (ArrayDeque) | Queue (ArrayDeque) | Queue (LinkedList) |
|-----------|-------------------|--------------------|--------------------|
| **push/offer** | O(1) | O(1) | O(1) |
| **pop/poll** | O(1) | O(1) | O(1) |
| **peek** | O(1) | O(1) | O(1) |
| **size** | O(1) | O(1) | O(1) |

## 🏋️‍♂️ Ejercicios

### 🟢 Ejercicios Fáciles

**Ejercicio 1: Invertir String con Stack**
```java
// Invierte una cadena usando un Stack
public static String invertirString(String texto) {
    // Tu código aquí
    // Ejemplo: "hello" → "olleh"
}
```

**Ejercicio 2: Simulador de Fila de Banco**
```java
// Simula una fila donde llegan clientes y son atendidos
public static void simularFilaBanco(String[] clientes) {
    // Tu código aquí - usa Queue
    // Muestra cuando cada cliente llega y cuando es atendido
}
```

### 🟡 Ejercicios Medios

**Ejercicio 3: Evaluador de Expresiones Postfija**
```java
// Evalúa una expresión en notación postfija usando Stack
public static int evaluarPostfija(String[] tokens) {
    // Tu código aquí
    // Ejemplo: ["3", "4", "+", "2", "*"] → ((3 + 4) * 2) = 14
}
```

**Ejercicio 4: Queue Circular**
```java
// Implementa una queue circular con array de tamaño fijo
public class QueueCircular<T> {
    private T[] array;
    private int frente, atras, tamaño, capacidad;
    
    public QueueCircular(int capacidad) {
        // Tu código aquí
    }
    
    public boolean offer(T elemento) {
        // Tu código aquí - agregar elemento
    }
    
    public T poll() {
        // Tu código aquí - remover elemento
    }
    
    public boolean isFull() {
        // Tu código aquí
    }
    
    public boolean isEmpty() {
        // Tu código aquí
    }
}
```

### 🔴 Ejercicios Difíciles

**Ejercicio 5: Stack con Mínimo en O(1)**
```java
// Implementa un Stack que puede retornar el mínimo elemento en O(1)
public class StackConMinimo {
    private Deque<Integer> datos;
    private Deque<Integer> minimos;
    
    public StackConMinimo() {
        // Tu código aquí
    }
    
    public void push(int elemento) {
        // Tu código aquí
    }
    
    public int pop() {
        // Tu código aquí
    }
    
    public int getMin() {
        // Tu código aquí - debe ser O(1)
    }
}
```

**Ejercicio 6: Simplificar Ruta de Archivo**
```java
// Simplifica una ruta de archivo Unix usando Stack
public static String simplificarRuta(String ruta) {
    // Tu código aquí
    // Ejemplo: "/a/./b/../../c/" → "/c"
    // Ejemplo: "/home//foo/" → "/home/foo"
}
```

## 🆚 Stack vs Queue - Cuándo Usar Cada Uno

### 📚 Casos de Uso para Stack

✅ **Usa Stack cuando:**
- **Undo/Redo**: Operaciones de deshacer/rehacer
- **Navegador**: Historial de páginas (botón "Atrás")
- **Llamadas de función**: El call stack del programa
- **Parsing**: Validación de paréntesis, expresiones matemáticas
- **Backtracking**: Algoritmos que necesitan "volver atrás"

### 🚶‍♂️ Casos de Uso para Queue

✅ **Usa Queue cuando:**
- **Procesamientos por orden**: Tareas que deben procesarse en orden de llegada
- **BFS**: Algoritmos de búsqueda en anchura
- **Simulaciones**: Filas de espera, sistemas de atención
- **Buffer**: Almacenamiento temporal con orden
- **Scheduling**: Planificación de tareas por prioridad temporal

## 💡 Implementaciones Recomendadas

| Necesidad | Implementación Recomendada | Razón |
|-----------|---------------------------|-------|
| **Stack** | `ArrayDeque` | Más eficiente que `Stack` legacy |
| **Queue** | `ArrayDeque` | Mejor rendimiento que `LinkedList` |
| **Deque** | `ArrayDeque` | Versatilidad y eficiencia |
| **Priority Queue** | `PriorityQueue` | Para elementos con prioridad |

## 🚀 Siguiente Paso

Ahora que dominas Stack y Queue, es momento de explorar **TreeMap y TreeSet** en [07-TreeMap-TreeSet.md](07-TreeMap-TreeSet.md), donde aprenderás sobre estructuras que mantienen los elementos automáticamente ordenados.