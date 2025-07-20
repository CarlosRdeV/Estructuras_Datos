# 📚 Curso de Estructuras de Datos en Java

Este proyecto contiene un curso completo de estructuras de datos en Java, con ejemplos prácticos y ejercicios de diferentes niveles.

## 🚀 Cómo Empezar

1. **Lee la documentación**: Comienza con `docs/00-INDICE-ESTRUCTURAS-DATOS.md`
2. **Practica con ejercicios**: Implementa los ejercicios en `src/main/java/com/carlosrdev/demo/ejercicios/`
3. **Desafíate con LeetCode**: Resuelve problemas reales en `src/main/java/com/carlosrdev/demo/leetcode/`

## 📁 Estructura del Proyecto

```
📦 demo/
├── 📚 docs/                     # Documentación del curso
│   ├── 00-INDICE-ESTRUCTURAS-DATOS.md
│   ├── 01-Arrays.md
│   ├── 02-ArrayList.md
│   ├── ... (7 tutoriales)
│   └── EJERCICIOS-LEETCODE.md
│
├── 💻 src/main/java/com/carlosrdev/demo/
│   ├── 🏋️‍♂️ ejercicios/          # Ejercicios del curso
│   │   ├── arrays/
│   │   ├── arraylist/
│   │   └── ... (por estructura)
│   │
│   ├── 🎯 leetcode/             # Problemas LeetCode
│   │   ├── easy/
│   │   ├── medium/
│   │   └── hard/
│   │
│   └── 🔧 utils/                # Herramientas de ayuda
│       └── TestHelper.java
│
└── ✅ src/test/                 # Tests unitarios
```

## 🎯 Orden de Estudio Recomendado

1. **Arrays** - Fundamentos básicos
2. **ArrayList** - Listas dinámicas
3. **LinkedList** - Listas enlazadas
4. **HashMap** - Mapas clave-valor
5. **HashSet** - Conjuntos únicos
6. **Stack/Queue** - LIFO/FIFO
7. **TreeMap/TreeSet** - Estructuras ordenadas

## 🏃‍♂️ Comandos de Desarrollo

```bash
# Compilar el proyecto
./mvnw clean compile

# Ejecutar una clase específica
./mvnw exec:java -Dexec.mainClass="com.carlosrdev.demo.ejercicios.arrays.EjerciciosFaciles"

# Ejecutar tests
./mvnw test

# Ejecutar Spring Boot (si necesario)
./mvnw spring-boot:run
```

## 📖 Cómo Usar Cada Sección

### 📚 Documentación (`docs/`)
- Lee cada archivo en orden secuencial
- Cada tutorial incluye teoría, ejemplos y ejercicios
- Usa como referencia durante la práctica

### 🏋️‍♂️ Ejercicios (`ejercicios/`)
- Implementa los ejercicios de cada tutorial
- Cada carpeta corresponde a una estructura de datos
- Comienza con ejercicios fáciles y avanza gradualmente

### 🎯 LeetCode (`leetcode/`)
- Problemas reales de la plataforma LeetCode
- Organizados por dificultad (easy/medium/hard)
- Consulta `docs/EJERCICIOS-LEETCODE.md` para la lista completa

### 🔧 Utils (`utils/`)
- Herramientas para ayudarte en la práctica
- `TestHelper.java` - Funciones útiles para testing
- Reutiliza estas utilidades en tus ejercicios

## 💡 Tips para Estudiantes

- **🎯 Enfócate en entender**, no solo memorizar
- **✍️ Escribe código a mano** antes de tipear
- **🔄 Practica regularmente**, la consistencia es clave
- **🐛 Debuggea tus errores** para aprender mejor
- **⏱️ Mide la complejidad** temporal de tus soluciones

## 🤝 Contribuciones

Este es un proyecto educativo. Si encuentras errores o tienes sugerencias, ¡son bienvenidas!

---

¡Feliz aprendizaje! 🎉 Recuerda: la programación se aprende programando.