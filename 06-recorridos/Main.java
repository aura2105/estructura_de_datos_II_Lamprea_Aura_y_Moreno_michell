
public class Main {

    public static void main(String[] args) {

        // Crear el árbol de frutas
        ArbolBST arbol = new ArbolBST();

        // Insertar las diez frutas
        arbol.insertar("Manzana");
        arbol.insertar("Pera");
        arbol.insertar("Mango");
        arbol.insertar("Banano");
        arbol.insertar("Uva");
        arbol.insertar("Naranja");
        arbol.insertar("Papaya");
        arbol.insertar("Fresa");
        arbol.insertar("Kiwi");
        arbol.insertar("Piña");

        // Mostrar el recorrido Preorden
        System.out.println("RECORRIDO PREORDEN:");
        arbol.preorden(arbol.getRaiz());

        // Mostrar el recorrido Inorden
        System.out.println("\n\nRECORRIDO INORDEN:");
        arbol.inorden(arbol.getRaiz());

        // Mostrar el recorrido Postorden
        System.out.println("\n\nRECORRIDO POSTORDEN:");
        arbol.postorden(arbol.getRaiz());

        // Mostrar el recorrido por niveles
        System.out.println("\n\nRECORRIDO POR NIVELES:");
        arbol.porNiveles(arbol.getRaiz());

        System.out.println();
    }
}
