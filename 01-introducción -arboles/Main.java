
public class Main {

    public static void main(String[] args) {

        // NIVEL 1: Creamos el nodo principal del organigrama, llamado Empresa.
        // Este nodo será la raíz de nuestro árbol general.
        NodoGeneral<String> empresa =
                new NodoGeneral<>("Empresa");

        // NIVEL 2: Creamos el nodo Gerente general.
        NodoGeneral<String> gerente =
                new NodoGeneral<>("Gerente general");

        // Agregamos el gerente general como hijo de Empresa.
        empresa.agregarHijo(gerente);

        // NIVEL 3: ADMINISTRACION
        // Creamos el área de Administración.
        NodoGeneral<String> administracion =
                new NodoGeneral<>("Administracion");

        // Agregamos Administración como hijo del gerente general.
        gerente.agregarHijo(administracion);

        // Creamos el departamento de Finanzas.
        NodoGeneral<String> finanzas =
                new NodoGeneral<>("Finanzas");

        // Agregamos Finanzas al área de Administración.
        administracion.agregarHijo(finanzas);

        // Agregamos los subdepartamentos de Finanzas.
        finanzas.agregarHijo(
                new NodoGeneral<>("Contabilidad"));
        finanzas.agregarHijo(
                new NodoGeneral<>("Tesoreria"));
        finanzas.agregarHijo(
                new NodoGeneral<>("Facturacion"));

        // Creamos el departamento de Recursos Humanos.
        NodoGeneral<String> recursosHumanos =
                new NodoGeneral<>("Recursos Humanos");

        // Agregamos Recursos Humanos a Administración.
        administracion.agregarHijo(recursosHumanos);

        // Agregamos las áreas de Recursos Humanos.
        recursosHumanos.agregarHijo(
                new NodoGeneral<>("Seleccion"));
        recursosHumanos.agregarHijo(
                new NodoGeneral<>("Capacitacion"));
        recursosHumanos.agregarHijo(
                new NodoGeneral<>("Nomina"));

        // Creamos el departamento de Área Legal.
        NodoGeneral<String> areaLegal =
                new NodoGeneral<>("Area Legal");

        // Agregamos Área Legal a Administración.
        administracion.agregarHijo(areaLegal);

        // Agregamos las subdivisiones del Área Legal.
        areaLegal.agregarHijo(
                new NodoGeneral<>("Contratos"));
        areaLegal.agregarHijo(
                new NodoGeneral<>("Asesorias juridicas"));

        // NIVEL 3: PRODUCCION
        // Creamos el área de Producción.
        NodoGeneral<String> produccion =
                new NodoGeneral<>("Produccion");

        // Agregamos Producción como hijo del gerente general.
        gerente.agregarHijo(produccion);

        // Creamos el departamento de Supervisión.
        NodoGeneral<String> supervision =
                new NodoGeneral<>("Supervision");

        // Agregamos Supervisión al área de Producción.
        produccion.agregarHijo(supervision);

        // Agregamos los supervisores de área como hijo de Supervisión.
        supervision.agregarHijo(
                new NodoGeneral<>("Supervisores de area"));

        // Creamos el departamento de Calidad.
        NodoGeneral<String> calidad =
                new NodoGeneral<>("Calidad");

        // Agregamos Calidad a Producción.
        produccion.agregarHijo(calidad);

        // Agregamos los inspectores de calidad.
        calidad.agregarHijo(
                new NodoGeneral<>("Inspectores de calidad"));

        // Creamos el departamento de Operaciones.
        NodoGeneral<String> operaciones =
                new NodoGeneral<>("Operaciones");

        // Agregamos Operaciones a Producción.
        produccion.agregarHijo(operaciones);

        // Agregamos los técnicos de mantenimiento.
        operaciones.agregarHijo(
                new NodoGeneral<>("Tecnicos de mantenimiento"));

        // NIVEL 3: VENTAS
        // Creamos el área de Ventas.
        NodoGeneral<String> ventas =
                new NodoGeneral<>("Ventas");

        // Agregamos Ventas como hijo del gerente general.
        gerente.agregarHijo(ventas);

        // Creamos el departamento de Marketing.
        NodoGeneral<String> marketing =
                new NodoGeneral<>("Marketing");

        // Agregamos Marketing al área de Ventas.
        ventas.agregarHijo(marketing);

        // Agregamos las subdivisiones de Marketing.
        marketing.agregarHijo(
                new NodoGeneral<>("Publicidad"));
        marketing.agregarHijo(
                new NodoGeneral<>("Redes sociales"));

        // Creamos el departamento comercial.
        NodoGeneral<String> departamentoVentas =
                new NodoGeneral<>("Departamento comercial");

        // Agregamos el departamento comercial a Ventas.
        ventas.agregarHijo(departamentoVentas);

        // Agregamos los cargos del departamento comercial.
        departamentoVentas.agregarHijo(
                new NodoGeneral<>("Vendedores"));
        departamentoVentas.agregarHijo(
                new NodoGeneral<>("Ejecutivos comerciales"));

        // Creamos el área de Atención al cliente.
        NodoGeneral<String> atencion =
                new NodoGeneral<>("Atencion al cliente");

        // Agregamos Atención al cliente al área de Ventas.
        ventas.agregarHijo(atencion);

        // Agregamos las subdivisiones de Atención al cliente.
        atencion.agregarHijo(
                new NodoGeneral<>("Servicio al cliente"));
        atencion.agregarHijo(
                new NodoGeneral<>("Reclamos"));

        // Mostramos el título del organigrama en la consola.
        System.out.println("ORGANIGRAMA EMPRESARIAL");
        System.out.println("=======================");

        // Llamamos al método recursivo para imprimir el árbol.
        // Empresa es la raíz y el nivel inicial es cero.
        mostrarOrganigrama(empresa, 0);
    }

    // Método recursivo que recibe un nodo y su nivel de profundidad.
    public static void mostrarOrganigrama(
            NodoGeneral<String> nodo, int nivel) {

        // Imprimimos cuatro espacios por cada nivel del árbol.
        // Esto permite distinguir visualmente la jerarquía.
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }

        // Imprimimos el nombre del nodo actual.
        System.out.println("|-- " + nodo.getDato());

        // Recorremos todos los hijos del nodo actual.
        for (NodoGeneral<String> hijo : nodo.getHijos()) {

            // Llamamos nuevamente al método para mostrar cada hijo.
            // Aumentamos el nivel en uno para indicar que descendemos.
            mostrarOrganigrama(hijo, nivel + 1);
        }
    }
}
