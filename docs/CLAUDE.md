# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This project is a comprehensive Java data structures learning platform that combines:

1. **Spring Boot Application**: A Spring Boot 3.5.3 application using Java 17 and Maven with minimal dependencies
2. **Data Structures Course**: Complete educational documentation with theory, examples, and exercises
3. **Practice Environment**: Organized code structure for hands-on learning with course exercises and LeetCode problems

### Current Implementation Status
- ✅ **Documentation**: Complete tutorial series for 7 data structures
- ✅ **Project Structure**: All directories and packages organized
- ⚠️ **Exercises**: Only `arrays/EjerciciosFaciles.java` implemented (other directories empty)
- ⚠️ **LeetCode**: Only `easy/TwoSum.java` implemented (medium/hard directories empty)
- ✅ **Testing**: Basic structure in place
- ✅ **Utilities**: `TestHelper.java` available

## Common Commands

### Build and Run
- `./mvnw clean compile` - Clean and compile the project
- `./mvnw spring-boot:run` - Run the application (starts on default port 8080)
- `./mvnw clean package` - Build JAR file
- `./mvnw clean install` - Full build with tests

### Testing
- `./mvnw test` - Run all tests
- `./mvnw test -Dtest=ClassName` - Run specific test class
- `./mvnw test -Dtest=ClassName#methodName` - Run specific test method

### Development
- Use `./mvnw spring-boot:run` for development with hot reload (devtools included)
- Application properties are in `src/main/resources/application.properties`

### Running Exercises
- `./mvnw exec:java -Dexec.mainClass="com.carlosrdev.demo.ejercicios.arrays.EjerciciosFaciles"` - Run arrays exercise (✅ implemented)
- `./mvnw exec:java -Dexec.mainClass="com.carlosrdev.demo.leetcode.easy.TwoSum"` - Run TwoSum solution (✅ implemented)
- Other exercise directories (arraylist, linkedlist, hashmap, hashset, stack, queue, treemap) are empty and need implementation

## Project Structure

```
├── docs/                                  # 📚 Course documentation
│   ├── 00-INDICE-ESTRUCTURAS-DATOS.md   # Course index and overview
│   ├── 01-Arrays.md                      # Arrays tutorial
│   ├── 02-ArrayList.md                   # ArrayList tutorial
│   ├── 03-LinkedList.md                  # LinkedList tutorial
│   ├── 04-HashMap.md                     # HashMap tutorial
│   ├── 05-HashSet.md                     # HashSet tutorial
│   ├── 06-Stack-Queue.md                 # Stack and Queue tutorial
│   ├── 07-TreeMap-TreeSet.md             # TreeMap and TreeSet tutorial
│   ├── EJERCICIOS-LEETCODE.md           # LeetCode practice problems by data structure
│   └── CLAUDE.md                         # This file
│
├── src/main/java/com/carlosrdev/demo/    # 💻 Source code
│   ├── DemoApplication.java              # Main Spring Boot application class
│   │
│   ├── ejercicios/                       # 🏋️‍♂️ Course exercises by data structure
│   │   ├── arrays/                       # ✅ Array exercises (EjerciciosFaciles.java)
│   │   ├── arraylist/                    # ⚠️ ArrayList exercises (empty - pending)
│   │   ├── linkedlist/                   # ⚠️ LinkedList exercises (empty - pending)
│   │   ├── hashmap/                      # ⚠️ HashMap exercises (empty - pending)
│   │   ├── hashset/                      # ⚠️ HashSet exercises (empty - pending)
│   │   ├── stack/                        # ⚠️ Stack exercises (empty - pending)
│   │   ├── queue/                        # ⚠️ Queue exercises (empty - pending)
│   │   └── treemap/                      # ⚠️ TreeMap/TreeSet exercises (empty - pending)
│   │
│   ├── leetcode/                         # 🎯 LeetCode problems
│   │   ├── easy/                         # ✅ Easy difficulty problems (TwoSum.java)
│   │   ├── medium/                       # ⚠️ Medium difficulty problems (empty - pending)
│   │   └── hard/                         # ⚠️ Hard difficulty problems (empty - pending)
│   │
│   └── utils/                            # 🔧 Utility classes
│       └── TestHelper.java              # Helper methods for testing exercises
│
├── src/main/resources/
│   └── application.properties            # Spring Boot configuration
│
├── src/test/java/com/carlosrdev/demo/    # ✅ Test classes
│   ├── DemoApplicationTests.java         # Basic context loading test
│   ├── ejercicios/                       # Tests for course exercises
│   └── leetcode/                         # Tests for LeetCode solutions
│
└── README.md                             # Project overview and usage guide
```

## Architecture Notes

### Spring Boot Application
- Standard Spring Boot application with `@SpringBootApplication` annotation
- Uses Spring Boot's auto-configuration
- Minimal setup - ready for adding web, data, or other Spring modules
- Package structure: `com.carlosrdev.demo`

### Data Structures Course
- **Documentation**: Complete tutorial series in `docs/` covering 7 fundamental Java data structures
- **Theory**: Each tutorial includes conceptual explanations, examples, and 6 graded exercises
- **Practice**: Hands-on exercises organized in `src/main/java/com/carlosrdev/demo/ejercicios/`
- **Real Problems**: LeetCode solutions in `src/main/java/com/carlosrdev/demo/leetcode/`
- **Testing**: Unit tests in `src/test/` to validate solutions
- **Utilities**: Helper classes in `utils/` for common testing and debugging tasks

### Learning Path
1. Read theory in `docs/` (start with `00-INDICE-ESTRUCTURAS-DATOS.md`)
2. Implement exercises in `ejercicios/` for each data structure
3. Solve real problems in `leetcode/` organized by difficulty
4. Use `TestHelper` utilities to validate and debug solutions

### Next Steps for Development
**Priority Implementation Areas:**
1. **ArrayList exercises** - based on `02-ArrayList.md` tutorial
2. **LinkedList exercises** - based on `03-LinkedList.md` tutorial  
3. **HashMap exercises** - based on `04-HashMap.md` tutorial
4. **HashSet exercises** - based on `05-HashSet.md` tutorial
5. **Stack/Queue exercises** - based on `06-Stack-Queue.md` tutorial
6. **TreeMap/TreeSet exercises** - based on `07-TreeMap-TreeSet.md` tutorial
7. **LeetCode medium/hard problems** - expand problem collection