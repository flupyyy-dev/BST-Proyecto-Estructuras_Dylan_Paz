/**
 * Clase Nodo - Representa cada elemento del Arbol Binario de Busqueda.
 *
 * Cada nodo almacena un valor entero y referencias a sus hijos
 * izquierdo y derecho. No se usan librerias externas de arboles.
 *
 * @author Proyecto Estructuras de Datos - BST
 * @version 1.0
 */
public class Nodo {

    int dato;        // Valor almacenado en el nodo
    Nodo izquierdo;  // Referencia al hijo izquierdo (valores menores)
    Nodo derecho;    // Referencia al hijo derecho (valores mayores)

    /**
     * Constructor que inicializa el nodo con un valor dado.
     * Los hijos se inicializan en null (nodo hoja por defecto).
     *
     * @param dato El valor entero a almacenar en este nodo.
     */
    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}
