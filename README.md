# 🌳 Árbol Binario de Búsqueda (BST) — Java 17+

> Implementación completa desde cero de un **Binary Search Tree (BST)** en Java.
> Proyecto universitario de **Estructuras de Datos** con menú interactivo, visualización del árbol y análisis de complejidad algorítmica.

---

# 📌 Características del Proyecto

✅ Implementación recursiva pura
✅ Sin uso de `TreeMap`, `TreeSet` ni librerías nativas de árboles
✅ Inserción, búsqueda y eliminación
✅ Recorridos del árbol
✅ Visualización jerárquica en consola
✅ Explicación automática de casos de eliminación
✅ Menú interactivo
✅ Análisis de complejidad Big O

---

# 🌲 ¿Qué es un BST?

Un **Árbol Binario de Búsqueda** es una estructura de datos jerárquica donde cada nodo cumple la siguiente propiedad:

```text
Todo valor menor va a la izquierda
Todo valor mayor va a la derecha
```

Ejemplo:

```text
                [50]
               /    \
           [30]    [70]
           /  \     /  \
        [20] [40] [60] [80]
                               \
                               [90]
```

Gracias a esta organización, el árbol permite realizar búsquedas eficientes similares a una búsqueda binaria.

---

# 📂 Estructura del Proyecto

```text
BST_Proyecto/
│
├── README.md
└── src/
    ├── Nodo.java
    ├── BST.java
    └── Main.java
```

| Archivo     | Descripción                         |
| ----------- | ----------------------------------- |
| `Nodo.java` | Define la estructura de cada nodo   |
| `BST.java`  | Implementa toda la lógica del árbol |
| `Main.java` | Menú interactivo y ejecución        |

---

# ⚙️ Funcionalidades

| Opción | Función                   |
| ------ | ------------------------- |
| 1      | Insertar valor            |
| 2      | Eliminar valor            |
| 3      | Buscar valor              |
| 4      | Ver recorridos            |
| 5      | Mostrar estructura visual |
| 6      | Ver complejidad Big O     |
| 0      | Salir                     |

---

# 🧠 Métodos Implementados

## `insert(int valor)`

Inserta un valor respetando la propiedad del BST.

* Menores → izquierda
* Mayores → derecha
* No permite duplicados

---

## `search(int valor)`

Busca un valor dentro del árbol.

Retorna:

```java
true
```

si el valor existe, o:

```java
false
```

si no existe.

---

# ❌ `delete(int valor)` — Eliminación de nodos

El método más importante y complejo del BST.

El programa detecta automáticamente qué caso aplicar:

| Caso   | Situación          | Acción                     |
| ------ | ------------------ | -------------------------- |
| Caso 1 | Nodo hoja          | Se elimina directamente    |
| Caso 2 | Nodo con un hijo   | El hijo reemplaza al nodo  |
| Caso 3 | Nodo con dos hijos | Se usa el sucesor in-order |

---

## 🔍 ¿Qué es el sucesor in-order?

Es el valor más pequeño del subárbol derecho.

Ejemplo:

```text
        [30]
       /    \
    [20]   [40]
```

El sucesor in-order de `30` es `40`.

---

# 🔄 Recorridos del Árbol

| Método        | Orden                      | Uso                        |
| ------------- | -------------------------- | -------------------------- |
| `inOrder()`   | Izquierda → Raíz → Derecha | Devuelve valores ordenados |
| `preOrder()`  | Raíz → Izquierda → Derecha | Copiar estructura          |
| `postOrder()` | Izquierda → Derecha → Raíz | Liberar memoria            |

---

# 📈 Complejidad Algorítmica (Big O)

| Operación  | Caso Promedio | Peor Caso |
| ---------- | ------------- | --------- |
| Insertar   | O(log n)      | O(n)      |
| Buscar     | O(log n)      | O(n)      |
| Eliminar   | O(log n)      | O(n)      |
| Recorridos | O(n)          | O(n)      |
| Altura     | O(n)          | O(n)      |

---

# ⚠️ ¿Cuándo ocurre el peor caso?

Cuando los valores se insertan en orden ascendente o descendente:

```text
1 → 2 → 3 → 4 → 5
```

El árbol pierde balance y se comporta como una lista enlazada.

---

# 🖥️ Vista Previa del Programa

```text
==================================================
    ARBOL BINARIO DE BUSQUEDA (BST)
    Estructuras de Datos - Java 17+
==================================================

  [1] Insertar valor
  [2] Eliminar valor
  [3] Buscar valor
  [4] Ver recorridos
  [5] Ver estructura visual
  [6] Ver complejidad Big O
  [0] Salir
```

---

# 🌳 Visualización del Árbol

```text
  [50]
  |    L-- [30]
  |    |    L-- [20]
  |    |    R-- [40]
  |    R-- [70]
  |         L-- [60]
  |         R-- [80]
```

---

# 💻 Compilación y Ejecución

## Requisitos

* Java 17 o superior

---

## Compilar

Luego de descargar y extraer el archivo comprimido, debe entrar a la carpeta y ejecutar terminal en la primera y única carpeta que se encuentra.
```bash
cd src
javac Nodo.java BST.java Main.java
```

---

## Ejecutar

```bash
java Main
```

---

# 📹 Video Explicativo

El proyecto incluye un video demostrando:

* Inserción de valores
* Eliminación de nodos
* Recorridos
* Explicación de Big O
* Funcionamiento interno del BST

🔗(https://youtu.be/ag83NW1ObcU)

---

# 🛠️ Tecnologías Utilizadas

* Java 17
* Programación Orientada a Objetos
* Recursión
* Estructuras de Datos

---

# 📚 Conceptos Aplicados

* Árboles binarios
* Recursividad
* Complejidad algorítmica
* Recorridos DFS
* Gestión dinámica de memoria
* Estructuras jerárquicas

---

# 👨‍💻 Autor

Proyecto desarrollado para el curso de **Estructuras de Datos**.
Por: Dylan Odair Paz Navas (202503824)
