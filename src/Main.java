import java.util.Scanner;

/**
 * Clase Main - Menu interactivo para el Arbol Binario de Busqueda (BST).
 *
 * Permite al usuario operar el arbol en tiempo real:
 *   - Insertar valores
 *   - Eliminar valores (maneja los 3 casos)
 *   - Buscar valores
 *   - Ver recorridos
 *   - Ver estructura visual del arbol
 *   - Ver tabla de complejidad Big O
 *
 * @author Proyecto Estructuras de Datos - BST
 * @version 2.0
 */
public class Main {

    private static final String LINEA  = "-".repeat(50);
    private static final String LINEA2 = "=".repeat(50);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST arbol  = new BST();
        int opcion;

        bienvenida();

        do {
            menu();
            System.out.print("  Seleccione una opcion: ");
            opcion = leerEntero(sc);

            switch (opcion) {
                case 1 -> insertar(sc, arbol);
                case 2 -> eliminar(sc, arbol);
                case 3 -> buscar(sc, arbol);
                case 4 -> recorridos(arbol);
                case 5 -> verArbol(arbol);
                case 6 -> complejidad();
                case 0 -> despedida();
                default -> System.out.println("\n  [!] Opcion invalida. Intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }

    // =========================================================
    //  OPCIONES DEL MENU
    // =========================================================

    /** Opcion 1: Insertar uno o varios valores */
    private static void insertar(Scanner sc, BST arbol) {
        encabezado("INSERTAR VALOR");
        System.out.print("  Ingrese el valor a insertar: ");
        int valor = leerEntero(sc);
        arbol.insert(valor);
        System.out.println("\n  [OK] Valor " + valor + " insertado correctamente.");
        System.out.println("  Altura actual del arbol: " + arbol.altura());
        System.out.println();
        arbol.imprimirArbol();
        arbol.inOrder();
    }

    /** Opcion 2: Eliminar un valor (muestra que caso aplica antes de eliminar) */
    private static void eliminar(Scanner sc, BST arbol) {
        encabezado("ELIMINAR VALOR");

        if (arbol.estaVacio()) {
            System.out.println("  [!] El arbol esta vacio. No hay nada que eliminar.");
            return;
        }

        System.out.print("  Ingrese el valor a eliminar: ");
        int valor = leerEntero(sc);

        if (!arbol.search(valor)) {
            System.out.println("\n  [--] El valor " + valor + " no existe en el arbol.");
            return;
        }

        // Explicar que caso se va a aplicar antes de eliminar
        String caso = arbol.diagnosticarCaso(valor);
        System.out.println("\n  Caso detectado: " + caso);
        System.out.println("  Eliminando " + valor + "...\n");

        arbol.delete(valor);
        System.out.println("  [OK] Valor " + valor + " eliminado correctamente.");
        System.out.println("  Altura actual del arbol: " + arbol.altura());
        System.out.println();
        arbol.imprimirArbol();
        arbol.inOrder();
    }

    /** Opcion 3: Buscar un valor */
    private static void buscar(Scanner sc, BST arbol) {
        encabezado("BUSCAR VALOR");
        System.out.print("  Ingrese el valor a buscar: ");
        int valor = leerEntero(sc);
        boolean encontrado = arbol.search(valor);
        System.out.println();
        if (encontrado) {
            System.out.println("  [OK]  El valor " + valor + " SI existe en el arbol.");
        } else {
            System.out.println("  [--]  El valor " + valor + " NO existe en el arbol.");
        }
    }

    /** Opcion 4: Mostrar los tres recorridos */
    private static void recorridos(BST arbol) {
        encabezado("RECORRIDOS DEL ARBOL");
        if (arbol.estaVacio()) {
            System.out.println("  [!] El arbol esta vacio.");
            return;
        }
        arbol.inOrder();
        arbol.preOrder();
        arbol.postOrder();
    }

    /** Opcion 5: Ver estructura visual */
    private static void verArbol(BST arbol) {
        encabezado("ESTRUCTURA VISUAL DEL ARBOL");
        System.out.println("  (L = hijo izquierdo  /  R = hijo derecho)\n");
        if (arbol.estaVacio()) {
            System.out.println("  (arbol vacio)");
            return;
        }
        arbol.imprimirArbol();
        System.out.println("  Altura: " + arbol.altura() + " nivel(es)");
    }

    /** Opcion 6: Tabla de complejidad Big O */
    private static void complejidad() {
        encabezado("COMPLEJIDAD ALGORITMICA (Big O)");
        System.out.println("  Operacion       Caso promedio    Caso peor");
        System.out.println("  " + "-".repeat(44));
        System.out.println("  insert       -> O(log n)         O(n)");
        System.out.println("  search       -> O(log n)         O(n)");
        System.out.println("  delete       -> O(log n)         O(n)");
        System.out.println("  inOrder      -> O(n)             O(n)");
        System.out.println("  preOrder     -> O(n)             O(n)");
        System.out.println("  postOrder    -> O(n)             O(n)");
        System.out.println("  altura       -> O(n)             O(n)");
        System.out.println();
        System.out.println("  Nota: el peor caso ocurre cuando los valores se");
        System.out.println("  insertan en orden (ej: 1,2,3,4,5), degenerando");
        System.out.println("  el arbol en una lista enlazada.");
    }

    // =========================================================
    //  PANTALLAS FIJAS
    // =========================================================

    private static void bienvenida() {
        System.out.println("\n" + LINEA2);
        System.out.println("    ARBOL BINARIO DE BUSQUEDA (BST)");
        System.out.println("    Estructuras de Datos - Java 17+");
        System.out.println(LINEA2);
        System.out.println("  insert  | search  | delete  | recorridos");
        System.out.println("  in-order | pre-order | post-order | Big O");
        System.out.println(LINEA2);
    }

    private static void menu() {
        System.out.println("\n" + LINEA);
        System.out.println("  MENU PRINCIPAL");
        System.out.println(LINEA);
        System.out.println("  [1] Insertar valor");
        System.out.println("  [2] Eliminar valor");
        System.out.println("  [3] Buscar valor");
        System.out.println("  [4] Ver recorridos (In / Pre / Post Order)");
        System.out.println("  [5] Ver estructura visual del arbol");
        System.out.println("  [6] Ver complejidad Big O");
        System.out.println("  [0] Salir");
        System.out.println(LINEA);
    }

    private static void despedida() {
        System.out.println("\n" + LINEA2);
        System.out.println("  Programa finalizado.");
        System.out.println(LINEA2 + "\n");
    }

    // =========================================================
    //  UTILIDADES
    // =========================================================

    private static void encabezado(String titulo) {
        System.out.println("\n" + LINEA);
        System.out.println("  >> " + titulo);
        System.out.println(LINEA);
    }

    /**
     * Lee un entero de forma segura. Si el usuario escribe texto,
     * muestra un aviso y pide el dato de nuevo.
     */
    private static int leerEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("  [!] Ingrese un numero entero valido: ");
            sc.next();
        }
        return sc.nextInt();
    }
}
