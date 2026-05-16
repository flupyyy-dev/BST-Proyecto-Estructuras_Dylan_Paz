/**
 * Clase BST (Binary Search Tree) - Arbol Binario de Busqueda.
 *
 * Implementacion completa desde cero sin librerias nativas de Java.
 * Soporta insercion, busqueda, eliminacion y tres tipos de recorrido.
 *
 * Propiedades del BST:
 *   - Subarbol izquierdo contiene valores MENORES que la raiz.
 *   - Subarbol derecho contiene valores MAYORES que la raiz.
 *   - Cada subarbol tambien es un BST valido (propiedad recursiva).
 *
 * Complejidades:
 *   - Caso promedio: O(log n) para insertar, buscar y eliminar.
 *   - Caso peor (arbol degenerado): O(n).
 *
 * @author Proyecto Estructuras de Datos - BST
 * @version 1.2
 */
public class BST {

    // Raiz del arbol; null indica arbol vacio
    private Nodo raiz;

    /**
     * Constructor por defecto. El arbol inicia vacio.
     */
    public BST() {
        this.raiz = null;
    }

    // =========================================================
    //  INSERCION
    // =========================================================

    /**
     * Inserta un nuevo valor en el arbol.
     * Si el valor ya existe, se ignora (sin duplicados).
     *
     * Complejidad: O(log n) promedio, O(n) peor caso.
     *
     * @param valor El entero a insertar.
     */
    public void insert(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    /**
     * Metodo auxiliar recursivo para insercion.
     * Recorre el arbol comparando valores hasta encontrar la posicion correcta.
     *
     * @param nodo  Nodo actual en la recursion.
     * @param valor Valor a insertar.
     * @return El nodo actualizado (con el nuevo hijo si aplica).
     */
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        // Caso base: posicion vacia encontrada -> crear nuevo nodo aqui
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.dato) {
            // El valor es menor -> va al subarbol izquierdo
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.dato) {
            // El valor es mayor -> va al subarbol derecho
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        // Si valor == nodo.dato -> duplicado, no se inserta

        return nodo;
    }

    // =========================================================
    //  BUSQUEDA
    // =========================================================

    /**
     * Busca un valor en el arbol.
     *
     * Complejidad: O(log n) promedio, O(n) peor caso.
     *
     * @param valor El entero a buscar.
     * @return true si el valor existe, false en caso contrario.
     */
    public boolean search(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    /**
     * Metodo auxiliar recursivo para busqueda.
     *
     * @param nodo  Nodo actual.
     * @param valor Valor buscado.
     * @return true si se encuentra el valor.
     */
    private boolean buscarRecursivo(Nodo nodo, int valor) {
        // Caso base: llegamos a null -> el valor no existe
        if (nodo == null) {
            return false;
        }

        // Encontrado
        if (valor == nodo.dato) {
            return true;
        }

        // Decidir en que subarbol continuar
        if (valor < nodo.dato) {
            return buscarRecursivo(nodo.izquierdo, valor);
        } else {
            return buscarRecursivo(nodo.derecho, valor);
        }
    }

    // =========================================================
    //  ELIMINACION
    // =========================================================

    /**
     * Elimina un valor del arbol manejando los tres casos posibles:
     *   1. Nodo hoja (sin hijos).
     *   2. Nodo con exactamente un hijo.
     *   3. Nodo con dos hijos (usa el sucesor in-order).
     *
     * Complejidad: O(log n) promedio, O(n) peor caso.
     *
     * @param valor El entero a eliminar.
     */
    public void delete(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    /**
     * Metodo auxiliar recursivo para eliminacion.
     *
     * @param nodo  Nodo actual.
     * @param valor Valor a eliminar.
     * @return El nodo resultante luego de la eliminacion.
     */
    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        // Caso base: valor no existe en el arbol
        if (nodo == null) {
            System.out.println("  [Aviso] El valor " + valor + " no se encontro en el arbol.");
            return null;
        }

        if (valor < nodo.dato) {
            // El valor esta en el subarbol izquierdo
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, valor);

        } else if (valor > nodo.dato) {
            // El valor esta en el subarbol derecho
            nodo.derecho = eliminarRecursivo(nodo.derecho, valor);

        } else {
            // Nodo encontrado ---------------------------------

            // CASO 1: Nodo hoja (sin hijos)
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null; // Se elimina directamente

            // CASO 2a: Solo tiene hijo derecho
            } else if (nodo.izquierdo == null) {
                return nodo.derecho; // El hijo derecho reemplaza al nodo

            // CASO 2b: Solo tiene hijo izquierdo
            } else if (nodo.derecho == null) {
                return nodo.izquierdo; // El hijo izquierdo reemplaza al nodo

            // CASO 3: Tiene dos hijos
            } else {
                // Encontrar el sucesor in-order: el minimo del subarbol derecho
                Nodo sucesor = encontrarMinimo(nodo.derecho);

                // Copiar el valor del sucesor al nodo actual
                nodo.dato = sucesor.dato;

                // Eliminar el sucesor del subarbol derecho
                nodo.derecho = eliminarRecursivo(nodo.derecho, sucesor.dato);
            }
        }

        return nodo;
    }

    /**
     * Encuentra el nodo con el valor minimo en un subarbol.
     * El minimo siempre esta en el extremo izquierdo.
     *
     * @param nodo Raiz del subarbol donde buscar.
     * @return El nodo con el valor mas pequeno.
     */
    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    // =========================================================
    //  RECORRIDOS
    // =========================================================

    /**
     * Recorrido In-Order: Izquierdo -> Raiz -> Derecho.
     * Produce los valores en orden ASCENDENTE.
     * Complejidad: O(n).
     */
    public void inOrder() {
        System.out.print("  In-Order    (asc)        : ");
        inOrderRecursivo(raiz);
        System.out.println();
    }

    private void inOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            inOrderRecursivo(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inOrderRecursivo(nodo.derecho);
        }
    }

    /**
     * Recorrido Pre-Order: Raiz -> Izquierdo -> Derecho.
     * Util para copiar o serializar el arbol.
     * Complejidad: O(n).
     */
    public void preOrder() {
        System.out.print("  Pre-Order   (raiz primero): ");
        preOrderRecursivo(raiz);
        System.out.println();
    }

    private void preOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preOrderRecursivo(nodo.izquierdo);
            preOrderRecursivo(nodo.derecho);
        }
    }

    /**
     * Recorrido Post-Order: Izquierdo -> Derecho -> Raiz.
     * Util para liberar memoria o evaluar expresiones.
     * Complejidad: O(n).
     */
    public void postOrder() {
        System.out.print("  Post-Order  (raiz al final): ");
        postOrderRecursivo(raiz);
        System.out.println();
    }

    private void postOrderRecursivo(Nodo nodo) {
        if (nodo != null) {
            postOrderRecursivo(nodo.izquierdo);
            postOrderRecursivo(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    // =========================================================
    //  UTILIDADES
    // =========================================================

    /**
     * Verifica si el arbol esta vacio.
     *
     * @return true si no hay ningun nodo.
     */
    public boolean estaVacio() {
        return raiz == null;
    }

    /**
     * Calcula la altura del arbol (numero de niveles).
     * Un arbol vacio tiene altura 0.
     *
     * Complejidad: O(n).
     *
     * @return La altura del arbol.
     */
    public int altura() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(Nodo nodo) {
        if (nodo == null) return 0;
        int alturaIzq = calcularAltura(nodo.izquierdo);
        int alturaDer = calcularAltura(nodo.derecho);
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    // =========================================================
    //  VISUALIZACION EN CONSOLA
    // =========================================================

    /**
     * Imprime una representacion visual del arbol en consola.
     * Muestra la jerarquia con ramas (L = izquierdo, R = derecho).
     *
     * Ejemplo de salida:
     *   [50]
     *   |    L-- [30]
     *   |    |    L-- [20]
     *   |    |    R-- [40]
     *   |    R-- [70]
     *
     * Complejidad: O(n).
     */
    public void imprimirArbol() {
        if (raiz == null) {
            System.out.println("  (arbol vacio)");
            return;
        }
        imprimirRecursivo(raiz, "", "");
        System.out.println();
    }

    /**
     * Metodo auxiliar que imprime cada nodo con su prefijo de indentacion.
     *
     * @param nodo    Nodo actual.
     * @param prefijo Sangria acumulada para los hijos.
     * @param rama    Etiqueta de la rama ("L-- ", "R-- " o "").
     */
    private void imprimirRecursivo(Nodo nodo, String prefijo, String rama) {
        if (nodo == null) return;

        System.out.println("  " + prefijo + rama + "[" + nodo.dato + "]");

        String prefijoHijos = prefijo + (rama.equals("R-- ") ? "     " : "|    ");

        if (nodo.izquierdo != null || nodo.derecho != null) {
            imprimirRecursivo(nodo.izquierdo, prefijoHijos, "L-- ");
            imprimirRecursivo(nodo.derecho,   prefijoHijos, "R-- ");
        }
    }

    // =========================================================
    //  DIAGNOSTICO DE CASO DE ELIMINACION
    // =========================================================

    /**
     * Indica que caso de eliminacion se aplicara sobre un nodo dado.
     * Util para mostrar al usuario el razonamiento antes de eliminar.
     *
     * Casos posibles:
     *   CASO 1 - Nodo hoja (sin hijos)
     *   CASO 2 - Nodo con un solo hijo
     *   CASO 3 - Nodo con dos hijos (sucesor in-order)
     *
     * @param valor El valor del nodo a evaluar.
     * @return Cadena descriptiva del caso detectado.
     */
    public String diagnosticarCaso(int valor) {
        Nodo nodo = encontrarNodo(raiz, valor);
        if (nodo == null) return "Valor no encontrado en el arbol.";

        boolean tieneIzq = nodo.izquierdo != null;
        boolean tieneDer = nodo.derecho   != null;

        if (!tieneIzq && !tieneDer) {
            return "CASO 1 - Nodo hoja: se elimina directamente.";
        } else if (tieneIzq && tieneDer) {
            Nodo sucesor = encontrarMinimo(nodo.derecho);
            return "CASO 3 - Dos hijos: el sucesor in-order es " + sucesor.dato
                 + ", reemplaza a " + valor + " y se elimina del subarbol derecho.";
        } else {
            String hijo = tieneIzq
                    ? String.valueOf(nodo.izquierdo.dato)
                    : String.valueOf(nodo.derecho.dato);
            return "CASO 2 - Un solo hijo (" + hijo + "): sube y ocupa el lugar de " + valor + ".";
        }
    }

    /**
     * Busca y devuelve el nodo que contiene el valor dado.
     *
     * @param nodo  Nodo actual.
     * @param valor Valor buscado.
     * @return El nodo encontrado, o null si no existe.
     */
    private Nodo encontrarNodo(Nodo nodo, int valor) {
        if (nodo == null)        return null;
        if (valor == nodo.dato)  return nodo;
        if (valor < nodo.dato)   return encontrarNodo(nodo.izquierdo, valor);
        return                          encontrarNodo(nodo.derecho,    valor);
    }
}
