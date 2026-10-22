
public class ArbolBST {

    private NodoArbol<String> raiz;
    private int comparaciones;

    public ArbolBST() {
        raiz = null;
        comparaciones = 0;
    }

    // Insertar una letra
    public void insertar(String letra) {
        raiz = insertarRec(raiz, letra);
    }

    // Inserción recursiva
    private NodoArbol<String> insertarRec(
            NodoArbol<String> nodo, String letra) {

        if (nodo == null) {
            return new NodoArbol<>(letra);
        }

        // Comparar letras alfabéticamente
        int resultado = letra.compareTo(nodo.getDato());

        if (resultado < 0) {
            nodo.setIzquierdo(
                insertarRec(nodo.getIzquierdo(), letra)
            );
        } else if (resultado > 0) {
            nodo.setDerecho(
                insertarRec(nodo.getDerecho(), letra)
            );
        }

        // Si la letra ya existe, no se duplica
        return nodo;
    }

    // Buscar una letra
    public boolean buscar(String letra) {
        comparaciones = 0;
        return buscarRec(raiz, letra);
    }

    // Búsqueda recursiva
    private boolean buscarRec(
            NodoArbol<String> nodo, String letra) {

        if (nodo == null) {
            return false;
        }

        comparaciones++;

        if (letra.equals(nodo.getDato())) {
            return true;
        }

        if (letra.compareTo(nodo.getDato()) < 0) {
            return buscarRec(nodo.getIzquierdo(), letra);
        }

        return buscarRec(nodo.getDerecho(), letra);
    }

    // Obtener el número de comparaciones
    public int getComparaciones() {
        return comparaciones;
    }

    // Calcular la altura en niveles
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NodoArbol<String> nodo) {
        if (nodo == null) {
            return 0;
        }

        int izquierda = alturaRec(nodo.getIzquierdo());
        int derecha = alturaRec(nodo.getDerecho());

        return 1 + Math.max(izquierda, derecha);
    }

    // Mostrar las letras en orden alfabético
    public void imprimirEnOrden() {
        imprimirEnOrdenRec(raiz);
        System.out.println();
    }

    private void imprimirEnOrdenRec(NodoArbol<String> nodo) {
        if (nodo != null) {
            imprimirEnOrdenRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            imprimirEnOrdenRec(nodo.getDerecho());
        }
    }
}
