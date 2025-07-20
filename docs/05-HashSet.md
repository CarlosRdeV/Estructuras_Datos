# 📚 HashSet en Java

## 🎯 ¿Qué es un HashSet?

**HashSet** es una estructura de datos que almacena elementos **únicos** sin duplicados. Es como un HashMap, pero solo guarda las "claves" sin valores asociados. Perfecto para responder: "¿Este elemento ya existe?"

### 💡 Analogía Simple
Imagina una **lista de invitados VIP** de una fiesta:
- Cada nombre aparece solo una vez (sin duplicados)
- Puedes verificar rápidamente si alguien está en la lista
- No importa el orden de llegada, solo si está o no está

## 🔧 Características Principales

- **Elementos únicos**: No permite duplicados
- **Búsqueda O(1)**: Verificar existencia es súper rápido
- **Sin orden**: No mantiene orden de inserción (como HashMap)
- **Basado en HashMap**: Internamente usa HashMap con valores dummy
- **Permite null**: Acepta un solo elemento null

## 🧮 ¿Cómo Funciona Internamente?

HashSet usa internamente un HashMap donde:
- **Clave**: El elemento que agregas
- **Valor**: Un objeto dummy constante (PRESENT)

```java
// Simplificación de cómo funciona internamente
private HashMap<E, Object> map;
private static final Object PRESENT = new Object();

public boolean add(E element) {
    return map.put(element, PRESENT) == null;
}
```

## 📝 Sintaxis Básica

### Importar y Declarar

```java
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

// Crear HashSet
HashSet<String> nombres = new HashSet<>();

// Usando interfaz Set (recomendado)
Set<Integer> numeros = new HashSet<>();

// Con valores iniciales
Set<String> frutas = new HashSet<>(Arrays.asList("manzana", "banana", "naranja"));

// A partir de otra colección
List<String> lista = Arrays.asList("a", "b", "c", "a", "b");
Set<String> unicos = new HashSet<>(lista); // Automáticamente remueve duplicados
```

## 🛠️ Métodos Más Importantes

### 1. Agregar Elementos

```java
Set<String> frutas = new HashSet<>();

// Agregar elementos individuales
boolean agregado1 = frutas.add("manzana");    // true (se agregó)
boolean agregado2 = frutas.add("banana");     // true (se agregó)
boolean agregado3 = frutas.add("manzana");    // false (ya existía, no se agregó)

System.out.println(frutas); // [banana, manzana] (orden puede variar)

// Agregar múltiples elementos
Set<String> masFrutas = Arrays.asList("naranja", "uva", "banana");
frutas.addAll(masFrutas); // Solo agrega los que no existen
```

### 2. Verificar Existencia

```java
Set<String> frutas = new HashSet<>(Arrays.asList("manzana", "banana", "naranja"));

// Verificar si contiene un elemento
boolean tieneManzana = frutas.contains("manzana");    // true
boolean tieneUva = frutas.contains("uva");            // false

// Verificar si contiene todos los elementos de una colección
Set<String> buscar = Set.of("manzana", "banana");
boolean tieneAmbos = frutas.containsAll(buscar);      // true

// Verificar tamaño y si está vacío
int tamaño = frutas.size();        // 3
boolean vacio = frutas.isEmpty();  // false
```

### 3. Remover Elementos

```java
Set<String> frutas = new HashSet<>(Arrays.asList("manzana", "banana", "naranja", "uva"));

// Remover elemento específico
boolean removido = frutas.remove("banana");           // true (se removió)
boolean noRemovido = frutas.remove("kiwi");           // false (no existía)

// Remover múltiples elementos
Set<String> aRemover = Set.of("manzana", "uva");
frutas.removeAll(aRemover);                           // Remueve ambos

// Mantener solo elementos específicos (intersección)
Set<String> mantener = Set.of("naranja", "fresa");
frutas.retainAll(mantener);                           // Solo queda "naranja"

// Limpiar todo
frutas.clear();                                       // Set vacío
```

### 4. Iterar sobre HashSet

```java
Set<String> frutas = new HashSet<>(Arrays.asList("manzana", "banana", "naranja"));

// For-each (más común)
System.out.println("=== Frutas ===");
for (String fruta : frutas) {
    System.out.println("- " + fruta);
}

// Iterator
Iterator<String> it = frutas.iterator();
while (it.hasNext()) {
    String fruta = it.next();
    if (fruta.equals("banana")) {
        it.remove(); // Forma segura de remover durante iteración
    }
}

// Streams (Java 8+)
frutas.stream()
      .filter(fruta -> fruta.startsWith("m"))
      .forEach(System.out::println);

// forEach
frutas.forEach(fruta -> System.out.println("Fruta: " + fruta));
```

### 5. Operaciones de Conjuntos

```java
Set<Integer> conjunto1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
Set<Integer> conjunto2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));

// Unión (todos los elementos de ambos conjuntos)
Set<Integer> union = new HashSet<>(conjunto1);
union.addAll(conjunto2);
System.out.println("Unión: " + union); // [1, 2, 3, 4, 5, 6, 7, 8]

// Intersección (elementos comunes)
Set<Integer> interseccion = new HashSet<>(conjunto1);
interseccion.retainAll(conjunto2);
System.out.println("Intersección: " + interseccion); // [4, 5]

// Diferencia (elementos en conjunto1 pero no en conjunto2)
Set<Integer> diferencia = new HashSet<>(conjunto1);
diferencia.removeAll(conjunto2);
System.out.println("Diferencia: " + diferencia); // [1, 2, 3]

// Diferencia simétrica (elementos que están en uno u otro, pero no en ambos)
Set<Integer> difSimetrica = new HashSet<>(union);
difSimetrica.removeAll(interseccion);
System.out.println("Dif. Simétrica: " + difSimetrica); // [1, 2, 3, 6, 7, 8]
```

## 📊 Ejemplo Completo: Sistema de Etiquetas

```java
import java.util.*;

public class SistemaEtiquetas {
    public static void main(String[] args) {
        // Sistema de etiquetas para artículos de blog
        Map<String, Set<String>> articulos = new HashMap<>();
        
        // Agregar artículos con sus etiquetas
        agregarArticulo(articulos, "Introducción a Java", 
                       Set.of("java", "programacion", "tutorial", "principiantes"));
        
        agregarArticulo(articulos, "HashMap Avanzado", 
                       Set.of("java", "colecciones", "avanzado", "rendimiento"));
        
        agregarArticulo(articulos, "Python vs Java", 
                       Set.of("java", "python", "comparacion", "programacion"));
        
        agregarArticulo(articulos, "Estructuras de Datos", 
                       Set.of("algoritmos", "estructuras", "programacion", "java"));
        
        System.out.println("📚 Sistema de Etiquetas de Blog");
        mostrarArticulos(articulos);
        
        // Buscar artículos por etiqueta
        buscarPorEtiqueta(articulos, "java");
        buscarPorEtiqueta(articulos, "python");
        
        // Encontrar etiquetas más populares
        mostrarEtiquetasPopulares(articulos);
        
        // Artículos relacionados (que comparten etiquetas)
        encontrarRelacionados(articulos, "Introducción a Java");
    }
    
    public static void agregarArticulo(Map<String, Set<String>> articulos, String titulo, Set<String> etiquetas) {
        articulos.put(titulo, new HashSet<>(etiquetas)); // Copia para evitar modificaciones externas
        System.out.println("✅ Agregado: " + titulo);
    }
    
    public static void mostrarArticulos(Map<String, Set<String>> articulos) {
        System.out.println("\\n📋 Todos los Artículos:");
        for (Map.Entry<String, Set<String>> entrada : articulos.entrySet()) {
            System.out.println("  📄 " + entrada.getKey());
            System.out.println("     Etiquetas: " + entrada.getValue());
        }
    }
    
    public static void buscarPorEtiqueta(Map<String, Set<String>> articulos, String etiqueta) {
        System.out.println("\\n🔍 Artículos con etiqueta '" + etiqueta + "':");
        boolean encontrado = false;
        
        for (Map.Entry<String, Set<String>> entrada : articulos.entrySet()) {
            if (entrada.getValue().contains(etiqueta)) {
                System.out.println("  📄 " + entrada.getKey());
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("  (No se encontraron artículos)");
        }
    }
    
    public static void mostrarEtiquetasPopulares(Map<String, Set<String>> articulos) {
        // Contar frecuencia de etiquetas
        Map<String, Integer> contadorEtiquetas = new HashMap<>();
        
        for (Set<String> etiquetas : articulos.values()) {
            for (String etiqueta : etiquetas) {
                contadorEtiquetas.merge(etiqueta, 1, Integer::sum);
            }
        }
        
        System.out.println("\\n🏆 Etiquetas Más Populares:");
        contadorEtiquetas.entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(5)
            .forEach(entrada -> 
                System.out.println("  #" + entrada.getKey() + " (" + entrada.getValue() + " artículos)")
            );
    }
    
    public static void encontrarRelacionados(Map<String, Set<String>> articulos, String tituloBase) {
        Set<String> etiquetasBase = articulos.get(tituloBase);
        if (etiquetasBase == null) {
            System.out.println("\\n❌ Artículo no encontrado: " + tituloBase);
            return;
        }
        
        System.out.println("\\n🔗 Artículos relacionados con '" + tituloBase + "':");
        
        for (Map.Entry<String, Set<String>> entrada : articulos.entrySet()) {
            String titulo = entrada.getKey();
            Set<String> etiquetas = entrada.getValue();
            
            if (!titulo.equals(tituloBase)) {
                // Calcular intersección (etiquetas comunes)
                Set<String> comunes = new HashSet<>(etiquetasBase);
                comunes.retainAll(etiquetas);
                
                if (!comunes.isEmpty()) {
                    System.out.println("  📄 " + titulo + " (etiquetas comunes: " + comunes + ")");
                }
            }
        }
    }
}
```

## ⚡ Complejidad Temporal

| Operación | Complejidad Promedio | Complejidad Peor Caso |
|-----------|---------------------|----------------------|
| `add(element)` | O(1) | O(n) |
| `remove(element)` | O(1) | O(n) |
| `contains(element)` | O(1) | O(n) |
| `size()` | O(1) | O(1) |

## 🏋️‍♂️ Ejercicios

### 🟢 Ejercicios Fáciles

**Ejercicio 1: Elementos Únicos**
```java
// Remueve duplicados de una lista manteniendo solo elementos únicos
public static List<String> removerDuplicados(List<String> lista) {
    // Tu código aquí usando HashSet
    // Ejemplo: ["a", "b", "a", "c", "b", "d"] → ["a", "b", "c", "d"]
}
```

**Ejercicio 2: Verificar Subconjunto**
```java
// Verifica si el primer conjunto es subconjunto del segundo
public static boolean esSubconjunto(Set<Integer> conjunto1, Set<Integer> conjunto2) {
    // Tu código aquí
    // Ejemplo: {1, 2} es subconjunto de {1, 2, 3, 4} → true
}
```

### 🟡 Ejercicios Medios

**Ejercicio 3: Caracteres Únicos en String**
```java
// Verifica si un string tiene todos caracteres únicos
public static boolean tieneCaracteresUnicos(String texto) {
    // Tu código aquí usando HashSet
    // Ejemplo: "abcdef" → true, "abcabc" → false
}
```

**Ejercicio 4: Intersección de Múltiples Conjuntos**
```java
// Encuentra elementos comunes en una lista de conjuntos
public static Set<Integer> interseccionMultiple(List<Set<Integer>> conjuntos) {
    // Tu código aquí
    // Ejemplo: [{1,2,3}, {2,3,4}, {3,4,5}] → {3}
}
```

### 🔴 Ejercicios Difíciles

**Ejercicio 5: Números Faltantes**
```java
// Encuentra todos los números faltantes en un rango dado
public static Set<Integer> numerosFaltantes(int[] numeros, int inicio, int fin) {
    // Tu código aquí
    // Ejemplo: numeros=[1,3,5,7], inicio=1, fin=10 → {2,4,6,8,9,10}
}
```

**Ejercicio 6: Anagramas Agrupados**
```java
// Agrupa strings que son anagramas entre sí
public static Map<String, Set<String>> agruparAnagramas(String[] palabras) {
    // Tu código aquí usando HashSet
    // Ejemplo: ["eat","tea","tan","ate","nat","bat"] 
    // → {"aet": {"eat","tea","ate"}, "ant": {"tan","nat"}, "abt": {"bat"}}
}
```

## 💡 Tipos de Set en Java

| Tipo | Características | Cuándo Usar |
|------|----------------|-------------|
| **HashSet** | Rápido, no ordenado | Uso general, máximo rendimiento |
| **LinkedHashSet** | Mantiene orden de inserción | Cuando necesitas orden predecible |
| **TreeSet** | Ordenado naturalmente | Cuando necesitas elementos ordenados |
| **EnumSet** | Optimizado para enums | Solo para tipos enum |

## 🆚 HashSet vs otras estructuras

| Característica | HashSet | ArrayList | HashMap |
|----------------|---------|-----------|---------|
| **Duplicados** | No permite | Permite | Claves únicas, valores pueden repetirse |
| **Búsqueda** | O(1) | O(n) | O(1) |
| **Orden** | No garantizado | Por índice | No garantizado |
| **Uso de memoria** | Medio | Menos | Más (almacena claves y valores) |

## 💡 Cuándo Usar HashSet

✅ **Usa HashSet cuando:**
- Necesitas garantizar elementos únicos
- Quieres verificar existencia rápidamente
- Implementas operaciones de conjuntos (unión, intersección)
- El orden no importa
- Filtras duplicados de otra colección

❌ **No uses HashSet cuando:**
- Necesitas mantener orden (usa LinkedHashSet)
- Necesitas orden natural (usa TreeSet)
- Necesitas acceso por índice (usa ArrayList)
- Necesitas asociar valores a elementos (usa HashMap)

## 📚 Métodos equals() y hashCode()

Para que HashSet funcione correctamente con objetos personalizados, deben implementar `equals()` y `hashCode()`:

```java
public class Persona {
    private String nombre;
    private int edad;
    
    // Constructor, getters, setters...
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return edad == persona.edad && Objects.equals(nombre, persona.nombre);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad);
    }
}
```

## 🚀 Siguiente Paso

Ahora que entiendes HashSet, es momento de explorar **Stack y Queue** en [06-Stack-Queue.md](06-Stack-Queue.md), estructuras fundamentales que siguen reglas específicas de acceso: LIFO (Last In, First Out) y FIFO (First In, First Out).