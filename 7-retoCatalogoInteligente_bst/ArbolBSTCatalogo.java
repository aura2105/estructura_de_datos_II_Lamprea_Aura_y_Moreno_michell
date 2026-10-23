
public class ArbolBSTCatalogo {

    // Nodo principal desde el cual comienza el árbol.
    private NodoProducto raiz;

    // =====================================================
    // INSERCION PUBLICA
    // =====================================================
    public void insertar(Producto producto) {

        // No se permite insertar un producto nulo.
        if (producto == null) {
            throw new IllegalArgumentException(
                    "El producto no puede ser null."
            );
        }

        // Inicia la inserción desde la raíz.
        raiz = insertarRec(raiz, producto);
    }

    // Inserta un producto de manera recursiva.
    private NodoProducto insertarRec(
            NodoProducto nodo, Producto producto) {

        // Si no existe un nodo, crea uno nuevo.
        if (nodo == null) {
            return new NodoProducto(producto);
        }

        // Compara los códigos de los productos.
        int codigoNuevo = producto.getCodigo();
        int codigoActual = nodo.getProducto().getCodigo();

        if (codigoNuevo < codigoActual) {

            // El código menor va al lado izquierdo.
            nodo.setIzquierdo(
                    insertarRec(nodo.getIzquierdo(), producto)
            );

        } else if (codigoNuevo > codigoActual) {

            // El código mayor va al lado derecho.
            nodo.setDerecho(
                    insertarRec(nodo.getDerecho(), producto)
            );

        } else {

            // No se permiten códigos repetidos.
            throw new IllegalArgumentException(
                    "Codigo duplicado: " + codigoNuevo
            );
        }

        // Devuelve el nodo actualizado.
        return nodo;
    }

    // =====================================================
    // BUSQUEDA
    // =====================================================

    // Busca un producto usando su código.
    public Producto buscar(int codigo) {
        return buscarRec(raiz, codigo);
    }

    // Realiza la búsqueda recursiva.
    private Producto buscarRec(
            NodoProducto nodo, int codigo) {

        // Si llegamos a un espacio vacío, no existe.
        if (nodo == null) {
            return null;
        }

        int codigoActual = nodo.getProducto().getCodigo();

        // Si los códigos coinciden, encontramos el producto.
        if (codigo == codigoActual) {
            return nodo.getProducto();
        }

        // Si es menor, buscamos por la izquierda.
        if (codigo < codigoActual) {
            return buscarRec(nodo.getIzquierdo(), codigo);
        }

        // Si es mayor, buscamos por la derecha.
        return buscarRec(nodo.getDerecho(), codigo);
    }

    // =====================================================
    // BUSQUEDA CON TRAZA
    // =====================================================

    // Inicia una búsqueda que registra el camino
    // y la cantidad de comparaciones.
    public ResultadoBusqueda buscarConTraza(int codigo) {
        return buscarConTrazaRec(
                raiz, codigo, 0, new StringBuilder()
        );
    }

    // Busca el producto y construye el recorrido.
    private ResultadoBusqueda buscarConTrazaRec(
            NodoProducto nodo,
            int codigo,
            int comparaciones,
            StringBuilder camino) {

        // Si el nodo es nulo, la búsqueda termina.
        if (nodo == null) {

            if (camino.length() > 0) {
                camino.append(" -> null");
            } else {
                camino.append("null");
            }

            return new ResultadoBusqueda(
                    null, comparaciones, camino.toString()
            );
        }

        // Cada nodo visitado cuenta como una comparación.
        comparaciones++;

        int codigoActual = nodo.getProducto().getCodigo();

        // Agrega el código actual al camino.
        if (camino.length() > 0) {
            camino.append(" -> ");
        }
        camino.append(codigoActual);

        // Si coincide, devuelve el producto encontrado.
        if (codigo == codigoActual) {
            return new ResultadoBusqueda(
                    nodo.getProducto(),
                    comparaciones,
                    camino.toString()
            );
        }

        // Continúa por el lado que corresponda.
        if (codigo < codigoActual) {
            return buscarConTrazaRec(
                    nodo.getIzquierdo(),
                    codigo,
                    comparaciones,
                    camino
            );
        }

        return buscarConTrazaRec(
                nodo.getDerecho(),
                codigo,
                comparaciones,
                camino
        );
    }

    // =====================================================
    // CALCULO DE ALTURA
    // =====================================================

    // La altura se mide en aristas:
    // árbol vacío = -1; una hoja = 0.
    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(NodoProducto nodo) {

        // Un nodo nulo tiene altura -1.
        if (nodo == null) {
            return -1;
        }

        // Calcula la altura de ambos lados.
        int izq = alturaRec(nodo.getIzquierdo());
        int der = alturaRec(nodo.getDerecho());

        // Devuelve la altura del lado más largo más uno.
        return 1 + Math.max(izq, der);
    }

    // =====================================================
    // RECORRIDO INORDEN
    // =====================================================

    // Muestra los productos ordenados por código ascendente.
    public void mostrarInorden() {
        mostrarInordenRec(raiz);
    }

    private void mostrarInordenRec(NodoProducto nodo) {

        // No hay nada que imprimir si el nodo es nulo.
        if (nodo == null) {
            return;
        }

        // Primero imprime el subárbol izquierdo.
        mostrarInordenRec(nodo.getIzquierdo());

        // Después imprime el producto actual.
        System.out.println(nodo.getProducto());

        // Finalmente imprime el subárbol derecho.
        mostrarInordenRec(nodo.getDerecho());
    }

    // =====================================================
    // IMPRESION DEL ARBOL
    // =====================================================

    // Inicia la impresión desde la raíz.
    public void imprimirArbol() {
        imprimirArbolRec(raiz, 0);
    }

    // Imprime el árbol de lado, con sangría por nivel.
    private void imprimirArbolRec(
            NodoProducto nodo, int nivel) {

        // Si el nodo no existe, termina.
        if (nodo == null) {
            return;
        }

        // Primero imprime el lado derecho.
        imprimirArbolRec(nodo.getDerecho(), nivel + 1);

        // La sangría permite visualizar la profundidad.
        System.out.println(
                "    ".repeat(nivel)
                        + nodo.getProducto().getCodigo()
        );

        // Después imprime el lado izquierdo.
        imprimirArbolRec(nodo.getIzquierdo(), nivel + 1);
    }
}
