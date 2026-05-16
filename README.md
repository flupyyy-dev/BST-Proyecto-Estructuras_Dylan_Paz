🌳 Árbol Binario de Búsqueda
Binary Search Tree — Java 17+
Mostrar imagen
Mostrar imagen
Mostrar imagen
Implementación completa desde cero · Sin librerías nativas de árboles · Menú interactivo en consola
</div>

¿Qué es un BST?
Un Árbol Binario de Búsqueda es una estructura de datos jerárquica donde cada nodo cumple una regla simple pero poderosa:
        [50]
       /    \
    [30]    [70]        Todo lo de la izquierda < raíz
    /  \    /  \        Todo lo de la derecha  > raíz
 [20] [40] [60] [80]
                  \
                  [90]
Esta propiedad permite buscar, insertar y eliminar en O(log n) en el caso promedio — equivalente a una búsqueda binaria, pero sobre datos dinámicos.

Estructura del Proyecto
BST_Proyecto/
│
├── 📄 README.md
└── 📁 src/
    ├── Nodo.java   →  Define cada nodo: dato + hijo izquierdo + hijo derecho
    ├── BST.java    →  Toda la lógica del árbol (insertar, buscar, eliminar, recorrer)
    └── Main.java   →  Menú interactivo en consola

Funcionalidades
#OpciónDescripción1Insertar valorColoca el valor en su posición correcta2Eliminar valorDetecta y explica el caso antes de eliminar3Buscar valorRetorna si el valor existe o no4Ver recorridosIn-Order, Pre-Order y Post-Order5Ver árbol visualImprime la jerarquía con ramas L / R6Ver Big OTabla de complejidad algorítmica0SalirCierra el programa

Métodos Implementados
insert(int valor)
Recorre el árbol de forma recursiva comparando valores hasta encontrar la posición correcta. No permite duplicados.
search(int valor)
Descarta la mitad del árbol en cada paso, igual que una búsqueda binaria. Retorna true o false.
delete(int valor) — 3 casos
El método más complejo del árbol. Antes de eliminar, el programa explica qué caso aplica:
CasoSituaciónSoluciónCaso 1Nodo sin hijos (hoja)Se elimina directamenteCaso 2Nodo con un solo hijoEl hijo sube y ocupa su lugarCaso 3Nodo con dos hijosSe busca el sucesor in-order (mínimo del subárbol derecho), se copia su valor al nodo y se elimina el sucesor
Recorridos
MétodoOrdenResultadoinOrder()Izquierdo → Raíz → DerechoValores en orden ascendentepreOrder()Raíz → Izquierdo → DerechoÚtil para copiar el árbolpostOrder()Izquierdo → Derecho → RaízÚtil para liberar memoria

Complejidad Algorítmica
OperaciónCaso PromedioCaso PeorinsertO(log n)O(n)searchO(log n)O(n)deleteO(log n)O(n)inOrder / preOrder / postOrderO(n)O(n)alturaO(n)O(n)

¿Cuándo ocurre el peor caso O(n)?
Cuando los valores se insertan en orden ascendente o descendente (ej: 1, 2, 3, 4, 5). El árbol se degenera en una lista enlazada y pierde toda ventaja logarítmica.


Compilar y Ejecutar
Requisitos: Java 17 o superior
bash# Entrar a la carpeta src
cd BST_Proyecto/src

# Compilar
javac Nodo.java BST.java Main.java

# Ejecutar
java Main
Vista previa del menú:
==================================================
    ARBOL BINARIO DE BUSQUEDA (BST)
    Estructuras de Datos - Java 17+
==================================================
  [1] Insertar valor
  [2] Eliminar valor
  [3] Buscar valor
  [4] Ver recorridos (In / Pre / Post Order)
  [5] Ver estructura visual del arbol
  [6] Ver complejidad Big O
  [0] Salir
Ejemplo de eliminación con diagnóstico automático:
  Ingrese el valor a eliminar: 30

  Caso detectado: CASO 3 - Dos hijos: el sucesor in-order es 40,
                  reemplaza a 30 y se elimina del subarbol derecho.

  [OK] Valor 30 eliminado correctamente.

Implementación
Todo el árbol está implementado con recursión pura, sin estructuras auxiliares. No se usa ninguna librería nativa de Java que maneje árboles (TreeMap, TreeSet, etc.).
Nodo.java  →  int dato  +  Nodo izquierdo  +  Nodo derecho
BST.java   →  Nodo raiz  +  métodos recursivos
Main.java  →  Scanner   +  menú de opciones
