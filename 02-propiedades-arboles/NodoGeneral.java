import java.util.ArrayList;
import java.util.List;

public class NodoGeneral<T> {

    private T dato;
    private List<NodoGeneral<T>> hijos;

    // Constructor del nodo
    public NodoGeneral(T dato) {
        this.dato = dato;
        this.hijos = new ArrayList<>();
    }

    // Obtener el dato
    public T getDato() {
        return dato;
    }

    // Obtener los hijos
    public List<NodoGeneral<T>> getHijos() {
        return hijos;
    }

    // Agregar un hijo
    public void agregarHijo(NodoGeneral<T> hijo) {
        hijos.add(hijo);
    }

    // Calcular el grado del nodo
    public int getGrado() {
        return hijos.size();
    }

    // Verificar si es una hoja
    public boolean esHoja() {
        return hijos.isEmpty();
    }
}
