
public class Producto {

    // Atributos del producto.
    private final int codigo;
    private final String nombre;
    private final String categoria;
    private final double precio;

    // Constructor: permite crear un producto con sus datos.
    public Producto(int codigo, String nombre,
                    String categoria, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    // Devuelve el código del producto.
    public int getCodigo() {
        return codigo;
    }

    // Devuelve el nombre del producto.
    public String getNombre() {
        return nombre;
    }

    // Devuelve la categoría del producto.
    public String getCategoria() {
        return categoria;
    }

    // Devuelve el precio del producto.
    public double getPrecio() {
        return precio;
    }

    // Convierte los datos del producto en texto
    // para poder mostrarlos en la consola.
    @Override
    public String toString() {
        return codigo + " - " + nombre
                + " - " + categoria
                + " - $" + String.format("%.2f", precio);
    }
}
