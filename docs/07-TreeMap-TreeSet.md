# 📚 TreeMap y TreeSet en Java

## 🎯 ¿Qué son TreeMap y TreeSet?

**TreeMap** y **TreeSet** son estructuras de datos que mantienen sus elementos **automáticamente ordenados**. Están basadas en **árboles binarios balanceados** (Red-Black Tree) que garantizan operaciones eficientes.

### 💡 Analogías Simples

**TreeMap** - Como un **diccionario físico**:
- Las palabras (claves) están ordenadas alfabéticamente
- Cada palabra tiene su definición (valor)
- Puedes encontrar cualquier palabra rápidamente porque están ordenadas

**TreeSet** - Como una **biblioteca organizada**:
- Los libros están ordenados (por título, autor, etc.)
- No hay libros duplicados
- Siempre sabes dónde encontrar lo que buscas

## 🌳 TREEMAP

### 🔧 Características del TreeMap

- **Ordenado**: Las claves se mantienen en orden natural o según un Comparator
- **Sin duplicados**: Cada clave es única
- **Basado en Red-Black Tree**: Árbol binario balanceado
- **Complejidad**: O(log n) para operaciones básicas

### 📝 Implementación en Java

```java
import java.util.TreeMap;
import java.util.Map;
import java.util.Comparator;

// TreeMap con orden natural (alfabético para Strings)
TreeMap<String, Integer> mapa = new TreeMap<>();

// TreeMap con Comparator personalizado
TreeMap<String, Integer> mapaReverso = new TreeMap<>(Comparator.reverseOrder());

// TreeMap con comparador personalizado
TreeMap<Persona, String> mapaPersonas = new TreeMap<>((p1, p2) -> p1.getEdad() - p2.getEdad());
```

### 🛠️ Métodos Principales del TreeMap

```java
TreeMap<String, Integer> ciudades = new TreeMap<>();

// Put - Agregar elementos (se ordenan automáticamente)
ciudades.put("Madrid", 3200000);     // {"Madrid": 3200000}
ciudades.put("Barcelona", 1600000);  // {"Barcelona": 1600000, "Madrid": 3200000}
ciudades.put("Valencia", 800000);    // {"Barcelona": 1600000, "Madrid": 3200000, "Valencia": 800000}
ciudades.put("Sevilla", 700000);     // Ordenado: Barcelona, Madrid, Sevilla, Valencia

// Get - Obtener valor por clave
Integer habitantes = ciudades.get("Madrid");  // 3200000

// Métodos específicos de TreeMap para navegación
String primeraClave = ciudades.firstKey();         // "Barcelona"
String ultimaClave = ciudades.lastKey();           // "Valencia"

Map.Entry<String, Integer> primerEntry = ciudades.firstEntry();
Map.Entry<String, Integer> ultimoEntry = ciudades.lastEntry();

// Navegación relativa
String siguiente = ciudades.higherKey("Madrid");   // "Sevilla"
String anterior = ciudades.lowerKey("Madrid");     // "Barcelona"

// Rangos (subMapas)
Map<String, Integer> rango = ciudades.subMap("Barcelona", "Sevilla"); // Barcelona a Madrid
Map<String, Integer> menores = ciudades.headMap("Madrid");  // Antes de Madrid
Map<String, Integer> mayores = ciudades.tailMap("Madrid");  // Madrid en adelante
```

### 📊 Ejemplo: Sistema de Calificaciones

```java
import java.util.*;

public class SistemaCalificaciones {
    public static void main(String[] args) {
        // TreeMap para mantener estudiantes ordenados por nombre
        TreeMap<String, Double> calificaciones = new TreeMap<>();
        
        // Agregar calificaciones
        calificaciones.put("Carlos", 8.5);
        calificaciones.put("Ana", 9.2);
        calificaciones.put("Luis", 7.8);
        calificaciones.put("María", 9.8);
        calificaciones.put("Pedro", 6.5);
        
        System.out.println("📊 Sistema de Calificaciones (ordenado alfabéticamente)");
        System.out.println("=" * 50);
        
        // Mostrar todas las calificaciones (automáticamente ordenadas)
        for (Map.Entry<String, Double> entry : calificaciones.entrySet()) {
            String estudiante = entry.getKey();
            Double nota = entry.getValue();
            String estado = nota >= 7.0 ? "✅ APROBADO" : "❌ REPROBADO";
            System.out.printf("%-10s: %.1f %s%n", estudiante, nota, estado);
        }
        
        // Estadísticas usando métodos de TreeMap
        System.out.println("\\n📈 Estadísticas:");
        System.out.println("Primer estudiante (alfabéticamente): " + calificaciones.firstKey());
        System.out.println("Último estudiante (alfabéticamente): " + calificaciones.lastKey());
        System.out.println("Nota más alta: " + Collections.max(calificaciones.values()));
        System.out.println("Nota más baja: " + Collections.min(calificaciones.values()));
        
        // Estudiantes en rango específico
        System.out.println("\\n👥 Estudiantes de 'C' a 'M':");
        Map<String, Double> rango = calificaciones.subMap("C", "N");
        rango.forEach((nombre, nota) -> System.out.println("  " + nombre + ": " + nota));
    }
}
```

## 🗂️ TREESET

### 🔧 Características del TreeSet

- **Ordenado**: Los elementos se mantienen en orden natural o según un Comparator
- **Sin duplicados**: Como un Set normal
- **Basado en TreeMap**: Internamente usa TreeMap<E, Object>
- **Complejidad**: O(log n) para operaciones básicas

### 📝 Implementación en Java

```java
import java.util.TreeSet;
import java.util.Comparator;

// TreeSet con orden natural
TreeSet<Integer> numeros = new TreeSet<>();

// TreeSet con orden reverso
TreeSet<String> palabras = new TreeSet<>(Comparator.reverseOrder());

// TreeSet con comparador personalizado
TreeSet<Persona> personas = new TreeSet<>((p1, p2) -> p1.getEdad() - p2.getEdad());
```

### 🛠️ Métodos Principales del TreeSet

```java
TreeSet<Integer> numeros = new TreeSet<>();

// Add - Agregar elementos (se ordenan automáticamente)
numeros.add(50);    // [50]
numeros.add(30);    // [30, 50]
numeros.add(70);    // [30, 50, 70]
numeros.add(10);    // [10, 30, 50, 70]
numeros.add(30);    // [10, 30, 50, 70] (no se duplica)

// Métodos de navegación
Integer primero = numeros.first();          // 10
Integer ultimo = numeros.last();            // 70

Integer siguiente = numeros.higher(30);     // 50
Integer anterior = numeros.lower(50);       // 30

// Métodos de rango
Set<Integer> menores = numeros.headSet(50);      // [10, 30]
Set<Integer> mayores = numeros.tailSet(50);      // [50, 70]
Set<Integer> rango = numeros.subSet(20, 60);     // [30, 50]

// Verificaciones
boolean existe = numeros.contains(30);      // true
boolean vacio = numeros.isEmpty();          // false
int tamaño = numeros.size();               // 4
```

### 📊 Ejemplo: Organizador de Tareas por Prioridad

```java
import java.util.*;

public class OrganizadorTareas {
    public static void main(String[] args) {
        // TreeSet que ordena tareas por prioridad y luego por nombre
        TreeSet<Tarea> tareas = new TreeSet<>((t1, t2) -> {
            int cmpPrioridad = Integer.compare(t1.prioridad, t2.prioridad);
            return cmpPrioridad != 0 ? cmpPrioridad : t1.nombre.compareTo(t2.nombre);
        });
        
        // Agregar tareas
        tareas.add(new Tarea("Estudiar Java", 1));
        tareas.add(new Tarea("Hacer ejercicio", 3));
        tareas.add(new Tarea("Comprar comida", 2));
        tareas.add(new Tarea("Llamar al médico", 1));
        tareas.add(new Tarea("Leer libro", 3));
        tareas.add(new Tarea("Pagar facturas", 1));
        
        System.out.println("📝 Organizador de Tareas (por prioridad)");
        System.out.println("=" * 45);
        
        String[] iconosPrioridad = {"🔴", "🟡", "🟢"};
        
        for (Tarea tarea : tareas) {
            String icono = iconosPrioridad[tarea.prioridad - 1];
            System.out.printf("%s Prioridad %d: %s%n", icono, tarea.prioridad, tarea.nombre);
        }
        
        System.out.println("\\n⚡ Próxima tarea más importante:");
        Tarea siguiente = tareas.first();
        System.out.println("👉 " + siguiente.nombre + " (Prioridad " + siguiente.prioridad + ")");
        
        // Tareas de alta prioridad (prioridad 1)
        System.out.println("\\n🔥 Tareas de alta prioridad:");
        TreeSet<Tarea> altaPrioridad = new TreeSet<>((t1, t2) -> t1.nombre.compareTo(t2.nombre));
        for (Tarea tarea : tareas) {
            if (tarea.prioridad == 1) {
                altaPrioridad.add(tarea);
            }
        }
        altaPrioridad.forEach(t -> System.out.println("  • " + t.nombre));
    }
}

class Tarea {
    String nombre;
    int prioridad; // 1 = alta, 2 = media, 3 = baja
    
    public Tarea(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
    
    @Override
    public String toString() {
        return nombre + " (P" + prioridad + ")";
    }
}
```

## ⚡ Complejidad Temporal

| Operación | TreeMap | TreeSet | HashMap | HashSet |
|-----------|---------|---------|---------|---------|
| **Inserción** | O(log n) | O(log n) | O(1) | O(1) |
| **Búsqueda** | O(log n) | O(log n) | O(1) | O(1) |
| **Eliminación** | O(log n) | O(log n) | O(1) | O(1) |
| **Primer/Último** | O(log n) | O(log n) | N/A | N/A |
| **Rango** | O(log n + k) | O(log n + k) | N/A | N/A |

**k** = número de elementos en el rango

## 🆚 TreeMap/TreeSet vs HashMap/HashSet

### 📊 Comparación Práctica

```java
// HashMap vs TreeMap
Map<String, Integer> hashMap = new HashMap<>();
Map<String, Integer> treeMap = new TreeMap<>();

// Ambos almacenan los mismos datos
hashMap.put("C", 3); hashMap.put("A", 1); hashMap.put("B", 2);
treeMap.put("C", 3); treeMap.put("A", 1); treeMap.put("B", 2);

// HashMap: orden impredecible
System.out.println("HashMap: " + hashMap); // Puede ser {A=1, B=2, C=3} o cualquier orden

// TreeMap: siempre ordenado
System.out.println("TreeMap: " + treeMap); // Siempre {A=1, B=2, C=3}
```

### ✅ Cuándo Usar TreeMap/TreeSet

**Usa TreeMap cuando:**
- Necesitas las claves ordenadas
- Quieres navegar por rangos de claves
- Necesitas encontrar claves cercanas
- El orden es importante para la lógica del negocio

**Usa TreeSet cuando:**
- Necesitas elementos únicos Y ordenados
- Quieres encontrar elementos en rangos
- Necesitas el menor/mayor elemento frecuentemente
- El orden natural es importante

### ❌ Cuándo NO Usar TreeMap/TreeSet

**NO uses TreeMap/TreeSet cuando:**
- Solo necesitas verificar existencia (usa HashMap/HashSet)
- El rendimiento es crítico y el orden no importa
- Los elementos no son comparables naturalmente
- Haces muchas inserciones/eliminaciones y pocas consultas ordenadas

## 🏋️‍♂️ Ejercicios

### 🟢 Ejercicios Fáciles

**Ejercicio 1: Contador de Palabras Ordenado**
```java
// Cuenta la frecuencia de palabras en un texto y las muestra ordenadas alfabéticamente
public static Map<String, Integer> contarPalabras(String texto) {
    // Tu código aquí
    // Ejemplo: "hola mundo hola" → {"hola": 2, "mundo": 1}
}
```

**Ejercicio 2: Top 10 Estudiantes**
```java
// Dado un TreeMap de estudiantes y calificaciones, obtén los 10 mejores
public static List<String> top10Estudiantes(TreeMap<String, Double> calificaciones) {
    // Tu código aquí
    // Retorna lista ordenada de los 10 estudiantes con mejores notas
}
```

### 🟡 Ejercicios Medios

**Ejercicio 3: Rango de Precios**
```java
// Encuentra productos en un rango de precios usando TreeMap
public static Map<String, Double> productosEnRango(TreeMap<String, Double> productos, 
                                                   double precioMin, double precioMax) {
    // Tu código aquí
    // Usa métodos de TreeMap para encontrar productos en el rango de precios
}
```

**Ejercicio 4: Ordenar por Múltiples Criterios**
```java
// Crea un TreeSet que ordene personas por edad, y si tienen la misma edad, por nombre
public static TreeSet<Persona> crearConjuntoOrdenado() {
    // Tu código aquí
    // Implementa Comparator que ordene por edad y luego por nombre
}

class Persona {
    String nombre;
    int edad;
    // Constructor y métodos necesarios
}
```

### 🔴 Ejercicios Difíciles

**Ejercicio 5: Calendario de Eventos**
```java
// Implementa un calendario que mantenga eventos ordenados por fecha
public class CalendarioEventos {
    private TreeMap<LocalDate, List<String>> eventos;
    
    public CalendarioEventos() {
        // Tu código aquí
    }
    
    public void agregarEvento(LocalDate fecha, String evento) {
        // Tu código aquí
    }
    
    public List<String> eventosEnRango(LocalDate inicio, LocalDate fin) {
        // Tu código aquí - obtén todos los eventos en el rango de fechas
    }
    
    public LocalDate proximaFechaConEventos(LocalDate desde) {
        // Tu código aquí - encuentra la próxima fecha que tiene eventos
    }
}
```

**Ejercicio 6: Cache LRU con TreeMap**
```java
// Implementa un cache LRU (Least Recently Used) usando TreeMap para orden de acceso
public class CacheLRU<K, V> {
    private final int capacidad;
    private TreeMap<Long, K> ordenAcceso;  // timestamp -> key
    private Map<K, V> datos;               // key -> value
    private Map<K, Long> ultimoAcceso;     // key -> timestamp
    private long timestamp;
    
    public CacheLRU(int capacidad) {
        // Tu código aquí
    }
    
    public V get(K key) {
        // Tu código aquí - obtener valor y actualizar acceso
    }
    
    public void put(K key, V value) {
        // Tu código aquí - agregar/actualizar y manejar capacidad
    }
    
    private void eliminarMenosUsado() {
        // Tu código aquí - usar TreeMap para encontrar el menos usado
    }
}
```

## 💡 Consejos de Implementación

### 🔧 Mejores Prácticas

1. **Comparators personalizados**: Siempre maneja casos de igualdad
```java
// ❌ Mal - puede perder elementos
Comparator<Persona> mal = (p1, p2) -> p1.getEdad() - p2.getEdad();

// ✅ Bien - maneja igualdad de edad
Comparator<Persona> bien = (p1, p2) -> {
    int cmpEdad = Integer.compare(p1.getEdad(), p2.getEdad());
    return cmpEdad != 0 ? cmpEdad : p1.getNombre().compareTo(p2.getNombre());
};
```

2. **Rendimiento**: TreeMap/TreeSet son más lentos que HashMap/HashSet
```java
// Para búsquedas frecuentes sin orden
Map<String, String> cache = new HashMap<>();  // ✅ Mejor

// Para datos que necesitan orden
Map<String, String> diccionario = new TreeMap<>();  // ✅ Apropiado
```

3. **Nulls**: TreeMap/TreeSet no admiten claves/elementos null
```java
TreeSet<String> set = new TreeSet<>();
set.add(null);  // ❌ NullPointerException
```

## 🚀 Aplicaciones Reales

### 🏪 Casos de Uso Comunes

- **Diccionarios y directorios**: Búsqueda ordenada de contactos
- **Sistemas de scoring**: Clasificaciones y rankings
- **Calendarios**: Eventos ordenados por fecha
- **Inventarios**: Productos ordenados por precio/categoría
- **Logs de sistema**: Entradas ordenadas por timestamp
- **Índices de base de datos**: Búsquedas por rango

## 🎓 Resumen

**TreeMap** y **TreeSet** son ideales cuando necesitas:
- ✅ Elementos ordenados automáticamente
- ✅ Búsquedas por rango eficientes  
- ✅ Navegación (anterior/siguiente)
- ✅ Operaciones sobre elementos ordenados

El trade-off es menor rendimiento (O(log n) vs O(1)) a cambio de funcionalidad de ordenamiento.

¡Felicidades! 🎉 Has completado el curso de estructuras de datos fundamentales en Java. Ahora tienes las herramientas para elegir la estructura correcta según tus necesidades específicas.