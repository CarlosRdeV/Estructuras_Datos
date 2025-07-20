# 📚 HashMap en Java

## 🎯 ¿Qué es un HashMap?

**HashMap** es una estructura de datos que almacena pares **clave-valor** (key-value). Es como un diccionario donde puedes buscar el significado (valor) de una palabra (clave) de forma **súper rápida**.

### 💡 Analogía Simple
Imagina un **directorio telefónico moderno**:
- **Clave**: Nombre de la persona
- **Valor**: Número de teléfono  
- **Búsqueda rápida**: No necesitas hojear página por página, vas directo al nombre

## 🔧 Características Principales

- **Pares clave-valor**: Cada elemento tiene una clave única y un valor asociado
- **Búsqueda O(1)**: Encontrar un valor por su clave es extremadamente rápido
- **Claves únicas**: No puede haber dos claves iguales (los valores sí pueden repetirse)
- **Orden no garantizado**: Los elementos no mantienen orden de inserción
- **Permite null**: Acepta una clave null y múltiples valores null

## 🧮 ¿Cómo Funciona Internamente?

HashMap usa una **función hash** que convierte la clave en un índice de array:

```
Clave → Función Hash → Índice → Valor
"Juan" → hash("Juan") → 7 → "555-1234"
```

### Representación Simplificada
```
Índice:  [0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
Datos:   [∅] [∅] [Ana] [∅] [∅] [∅] [∅] [Juan] [∅] [Luis]
Valores: [∅] [∅] [555-9999] [∅] [∅] [∅] [∅] [555-1234] [∅] [555-5678]
```

## 📝 Sintaxis Básica

### Importar y Declarar

```java
import java.util.HashMap;
import java.util.Map;

// Crear HashMap especificando tipos de clave y valor
HashMap<String, Integer> edades = new HashMap<>();

// Usando interfaz Map (recomendado)
Map<String, String> telefonos = new Map<>();

// Con valores iniciales
Map<String, Integer> puntuaciones = new HashMap<>() {{
    put("Ana", 95);
    put("Luis", 87);
    put("Carlos", 92);
}};
```

## 🛠️ Métodos Más Importantes

### 1. Agregar y Actualizar Elementos

```java
Map<String, Integer> edades = new HashMap<>();

// Agregar elementos
edades.put("Ana", 25);        // {Ana=25}
edades.put("Luis", 30);       // {Ana=25, Luis=30}
edades.put("Carlos", 28);     // {Ana=25, Luis=30, Carlos=28}

// Actualizar (sobrescribir)
edades.put("Ana", 26);        // {Ana=26, Luis=30, Carlos=28}

// Agregar solo si no existe
Integer anterior = edades.putIfAbsent("Pedro", 35); // null (no existía)
Integer noAgregado = edades.putIfAbsent("Ana", 99); // 26 (ya existía, no se cambió)

// Agregar múltiples elementos
Map<String, Integer> nuevas = Map.of("María", 22, "José", 45);
edades.putAll(nuevas);
```

### 2. Obtener Elementos

```java
Map<String, Integer> edades = Map.of("Ana", 25, "Luis", 30, "Carlos", 28);

// Obtener valor por clave
Integer edadAna = edades.get("Ana");        // 25
Integer noExiste = edades.get("Pedro");     // null

// Obtener con valor por defecto
Integer edadPedro = edades.getOrDefault("Pedro", 0); // 0 (no existe)
Integer edadAna2 = edades.getOrDefault("Ana", 0);    // 25 (existe)

// Verificar si contiene clave o valor
boolean tieneAna = edades.containsKey("Ana");        // true
boolean tieneEdad25 = edades.containsValue(25);      // true

// Obtener tamaño
int tamaño = edades.size();                          // 3
boolean vacio = edades.isEmpty();                    // false
```

### 3. Remover Elementos

```java
Map<String, Integer> edades = new HashMap<>(Map.of("Ana", 25, "Luis", 30, "Carlos", 28));

// Remover por clave
Integer edadRemovidaAna = edades.remove("Ana");      // 25, queda {Luis=30, Carlos=28}

// Remover solo si tiene valor específico
boolean removidoLuis = edades.remove("Luis", 30);    // true, se remueve
boolean noRemovidoCarlos = edades.remove("Carlos", 99); // false, no se remueve

// Limpiar todo
edades.clear();                                      // {}
```

### 4. Iterar sobre HashMap

```java
Map<String, Integer> edades = Map.of("Ana", 25, "Luis", 30, "Carlos", 28);

// Iterar sobre las claves
System.out.println("=== Claves ===");
for (String nombre : edades.keySet()) {
    System.out.println(nombre);
}

// Iterar sobre los valores
System.out.println("=== Valores ===");
for (Integer edad : edades.values()) {
    System.out.println(edad);
}

// Iterar sobre los pares clave-valor (más común)
System.out.println("=== Pares Clave-Valor ===");
for (Map.Entry<String, Integer> entrada : edades.entrySet()) {
    System.out.println(entrada.getKey() + " tiene " + entrada.getValue() + " años");
}

// Con forEach (Java 8+)
edades.forEach((nombre, edad) -> 
    System.out.println(nombre + " → " + edad)
);
```

### 5. Operaciones Avanzadas

```java
Map<String, Integer> contador = new HashMap<>();

// Incrementar contador (patrón común)
String palabra = "java";
contador.put(palabra, contador.getOrDefault(palabra, 0) + 1);

// Usando merge (más elegante)
contador.merge(palabra, 1, Integer::sum); // Si existe suma 1, si no existe pone 1

// Compute si está ausente
contador.computeIfAbsent("python", k -> 0); // Solo agrega si no existe

// Compute siempre
contador.compute("java", (k, v) -> (v == null) ? 1 : v + 1); // Siempre aplica la función

// Replace
contador.replace("java", 5);              // Reemplaza solo si existe
contador.replace("java", 5, 10);          // Reemplaza solo si el valor actual es 5
```

## 📊 Ejemplo Completo: Sistema de Inventario

```java
import java.util.*;

public class SistemaInventario {
    public static void main(String[] args) {
        // Inventario: producto → cantidad
        Map<String, Integer> inventario = new HashMap<>();
        
        // Agregar productos iniciales
        inventario.put("Laptop", 10);
        inventario.put("Mouse", 25);
        inventario.put("Teclado", 15);
        inventario.put("Monitor", 8);
        
        System.out.println("📦 Inventario Inicial:");
        mostrarInventario(inventario);
        
        // Vender productos (reducir cantidad)
        venderProducto(inventario, "Laptop", 3);
        venderProducto(inventario, "Mouse", 5);
        
        // Agregar nuevo producto
        inventario.put("Webcam", 12);
        
        // Reabastecer existente
        reabastecer(inventario, "Monitor", 7);
        
        System.out.println("\n📦 Inventario Actualizado:");
        mostrarInventario(inventario);
        
        // Buscar producto específico
        buscarProducto(inventario, "Teclado");
        buscarProducto(inventario, "Impresora");
        
        // Mostrar productos con bajo stock
        System.out.println("\n⚠️ Productos con Bajo Stock (< 10):");
        mostrarBajoStock(inventario, 10);
        
        // Calcular valor total (simulando precios)
        Map<String, Double> precios = Map.of(
            "Laptop", 800.0, "Mouse", 25.0, "Teclado", 60.0, 
            "Monitor", 300.0, "Webcam", 80.0
        );
        calcularValorTotal(inventario, precios);
    }
    
    public static void mostrarInventario(Map<String, Integer> inventario) {
        if (inventario.isEmpty()) {
            System.out.println("  Inventario vacío");
            return;
        }
        
        for (Map.Entry<String, Integer> producto : inventario.entrySet()) {
            System.out.println("  " + producto.getKey() + ": " + producto.getValue() + " unidades");
        }
    }
    
    public static void venderProducto(Map<String, Integer> inventario, String producto, int cantidad) {
        int cantidadActual = inventario.getOrDefault(producto, 0);
        if (cantidadActual >= cantidad) {
            inventario.put(producto, cantidadActual - cantidad);
            System.out.println("✅ Vendido: " + cantidad + "x " + producto);
        } else {
            System.out.println("❌ Stock insuficiente de " + producto + " (disponible: " + cantidadActual + ")");
        }
    }
    
    public static void reabastecer(Map<String, Integer> inventario, String producto, int cantidad) {
        inventario.merge(producto, cantidad, Integer::sum);
        System.out.println("📈 Reabastecido: +" + cantidad + "x " + producto);
    }
    
    public static void buscarProducto(Map<String, Integer> inventario, String producto) {
        if (inventario.containsKey(producto)) {
            System.out.println("🔍 " + producto + ": " + inventario.get(producto) + " unidades disponibles");
        } else {
            System.out.println("🔍 " + producto + ": No encontrado en inventario");
        }
    }
    
    public static void mostrarBajoStock(Map<String, Integer> inventario, int limite) {
        for (Map.Entry<String, Integer> producto : inventario.entrySet()) {
            if (producto.getValue() < limite) {
                System.out.println("  ⚠️ " + producto.getKey() + ": " + producto.getValue() + " unidades");
            }
        }
    }
    
    public static void calcularValorTotal(Map<String, Integer> inventario, Map<String, Double> precios) {
        double valorTotal = 0;
        for (Map.Entry<String, Integer> producto : inventario.entrySet()) {
            String nombre = producto.getKey();
            Integer cantidad = producto.getValue();
            Double precio = precios.get(nombre);
            if (precio != null) {
                valorTotal += cantidad * precio;
            }
        }
        System.out.println("\n💰 Valor Total del Inventario: $" + String.format("%.2f", valorTotal));
    }
}
```

## ⚡ Complejidad Temporal

| Operación | Complejidad Promedio | Complejidad Peor Caso |
|-----------|---------------------|----------------------|
| `get(key)` | O(1) | O(n) |
| `put(key, value)` | O(1) | O(n) |
| `remove(key)` | O(1) | O(n) |
| `containsKey(key)` | O(1) | O(n) |

**Nota**: El peor caso O(n) ocurre cuando hay muchas colisiones hash, pero es muy raro en la práctica.

## 🏋️‍♂️ Ejercicios

### 🟢 Ejercicios Fáciles

**Ejercicio 1: Contador de Palabras**
```java
// Cuenta la frecuencia de cada palabra en un array de strings
public static Map<String, Integer> contarPalabras(String[] palabras) {
    // Tu código aquí
    // Ejemplo: ["java", "python", "java", "c++", "python", "java"] 
    // → {java=3, python=2, c++=1}
}
```

**Ejercicio 2: Intercambiar Claves y Valores**
```java
// Intercambia claves y valores de un HashMap (asume que valores son únicos)
public static Map<Integer, String> intercambiarClaveValor(Map<String, Integer> original) {
    // Tu código aquí
    // Ejemplo: {Ana=25, Luis=30} → {25=Ana, 30=Luis}
}
```

### 🟡 Ejercicios Medios

**Ejercicio 3: Merge de HashMaps**
```java
// Combina dos HashMaps sumando los valores de claves duplicadas
public static Map<String, Integer> combinarMapas(Map<String, Integer> mapa1, Map<String, Integer> mapa2) {
    // Tu código aquí
    // Ejemplo: {a=1, b=2} + {b=3, c=4} → {a=1, b=5, c=4}
}
```

**Ejercicio 4: Agrupar por Criterio**
```java
// Agrupa una lista de palabras por su primera letra
public static Map<Character, List<String>> agruparPorPrimeraLetra(List<String> palabras) {
    // Tu código aquí
    // Ejemplo: ["auto", "avión", "barco", "bicicleta"] 
    // → {a=[auto, avión], b=[barco, bicicleta]}
}
```

### 🔴 Ejercicios Difíciles

**Ejercicio 5: LRU Cache con HashMap**
```java
// Implementa un cache LRU usando HashMap + LinkedList o LinkedHashMap
public class LRUCache<K, V> {
    private final int capacidad;
    
    public LRUCache(int capacidad) {
        this.capacidad = capacidad;
        // Tu código aquí
    }
    
    public V get(K key) {
        // Tu código aquí - retorna valor y marca como recientemente usado
    }
    
    public void put(K key, V value) {
        // Tu código aquí - agrega/actualiza y maneja la capacidad
    }
}
```

**Ejercicio 6: Isomorfismo de Strings**
```java
// Determina si dos strings son isomórficos (existe mapeo 1:1 entre caracteres)
public static boolean sonIsomorficos(String s1, String s2) {
    // Tu código aquí usando HashMaps
    // Ejemplo: "egg" y "add" → true (e→a, g→d)
    // Ejemplo: "foo" y "bar" → false (o mapea a o y r)
}
```

## 💡 Tipos de Map en Java

| Tipo | Características | Cuándo Usar |
|------|----------------|-------------|
| **HashMap** | Rápido, no ordenado | Uso general, máximo rendimiento |
| **LinkedHashMap** | Mantiene orden de inserción | Cuando necesitas orden predecible |
| **TreeMap** | Ordenado por claves | Cuando necesitas claves ordenadas |
| **ConcurrentHashMap** | Thread-safe | Aplicaciones multihilo |

## 🆚 HashMap vs otras estructuras

| Operación | HashMap | ArrayList | LinkedList |
|-----------|---------|-----------|------------|
| **Búsqueda** | O(1) | O(n) | O(n) |
| **Inserción** | O(1) | O(1) al final | O(1) inicio/final |
| **Uso de memoria** | Más overhead | Menos overhead | Más overhead |
| **Orden** | No garantizado | Por índice | Por inserción |

## 💡 Cuándo Usar HashMap

✅ **Usa HashMap cuando:**
- Necesitas búsquedas muy rápidas por clave
- Tienes relaciones clave-valor
- El orden no importa
- Necesitas verificar existencia de elementos rápidamente

❌ **No uses HashMap cuando:**
- Necesitas mantener orden de inserción (usa LinkedHashMap)
- Necesitas orden natural de las claves (usa TreeMap)
- Trabajas con múltiples hilos sin sincronización (usa ConcurrentHashMap)
- Solo necesitas verificar existencia sin valores asociados (usa HashSet)

## 🚀 Siguiente Paso

Ahora que dominas HashMap, vamos a explorar **HashSet** en [05-HashSet.md](05-HashSet.md), que es perfecto para manejar conjuntos únicos de elementos sin duplicados.