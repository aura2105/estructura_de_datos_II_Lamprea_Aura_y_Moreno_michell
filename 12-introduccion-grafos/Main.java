
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Crear los vertices: estudiantes
        List<Vertice> estudiantes = new ArrayList<>();

        estudiantes.add(new Vertice("Ana"));
        estudiantes.add(new Vertice("Bruno"));
        estudiantes.add(new Vertice("Carla"));
        estudiantes.add(new Vertice("Diego"));
        estudiantes.add(new Vertice("Elena"));
        estudiantes.add(new Vertice("Felipe"));
        estudiantes.add(new Vertice("Gabriela"));
        estudiantes.add(new Vertice("Hugo"));
        estudiantes.add(new Vertice("Isabel"));
        estudiantes.add(new Vertice("Juan"));

        // Crear las aristas: relaciones entre estudiantes
        List<Arista> relaciones = new ArrayList<>();

        relaciones.add(new Arista("Ana", "Bruno", 8, false));
        relaciones.add(new Arista("Ana", "Carla", 6, false));
        relaciones.add(new Arista("Ana", "Diego", 5, false));
        relaciones.add(new Arista("Bruno", "Carla", 9, false));
        relaciones.add(new Arista("Bruno", "Elena", 4, false));
        relaciones.add(new Arista("Carla", "Diego", 7, false));
        relaciones.add(new Arista("Carla", "Felipe", 6, false));
        relaciones.add(new Arista("Diego", "Gabriela", 5, false));
        relaciones.add(new Arista("Elena", "Felipe", 8, false));
        relaciones.add(new Arista("Elena", "Hugo", 3, false));
        relaciones.add(new Arista("Felipe", "Isabel", 7, false));
        relaciones.add(new Arista("Gabriela", "Hugo", 6, false));
        relaciones.add(new Arista("Gabriela", "Juan", 4, false));
        relaciones.add(new Arista("Hugo", "Isabel", 5, false));
        relaciones.add(new Arista("Isabel", "Juan", 9, false));

        // Mostrar los vertices
        System.out.println("=== ESTUDIANTES DE LA RED ===");

        for (Vertice estudiante : estudiantes) {
            System.out.println(estudiante.getNombre());
        }

        // Mostrar las relaciones
        System.out.println("\n=== RELACIONES NO DIRIGIDAS ===");

        for (Arista relacion : relaciones) {
            relacion.mostrar();
        }

        // Identificar un ciclo
        System.out.println("\n=== CICLO IDENTIFICADO ===");
        System.out.println("Ana -> Bruno -> Carla -> Ana");

        // Calcular la densidad del grafo no dirigido
        int n = estudiantes.size();
        int m = relaciones.size();

        double densidad = (2.0 * m) / (n * (n - 1));

        System.out.println("\n=== CLASIFICACION DEL GRAFO ===");
        System.out.println("Vertices: " + n);
        System.out.println("Aristas: " + m);
        System.out.printf("Densidad: %.2f%n", densidad);
        System.out.println("Tipo: no dirigido y ponderado");
        System.out.println("El grafo tiene ciclos y es conexo.");
        System.out.println("Se considera relativamente disperso.");

        // Convertir las relaciones a dirigidas
        System.out.println("\n=== CONVERSION A GRAFO DIRIGIDO ===");

        for (Arista relacion : relaciones) {
            relacion.dirigida = true;
            relacion.mostrar();
        }
    }
}
