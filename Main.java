import java.util.Scanner;

public class Main {

    private static Scanner teclado = new Scanner(System.in);
    private static GestorDocumentos gestor = new GestorDocumentos();

    public static void main(String[] args) {

        registrarPlantillasIniciales();

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE DOCUMENTOS =====");
            System.out.println("1. Mostrar plantillas");
            System.out.println("2. Crear documento desde plantilla");
            System.out.println("3. Mostrar documentos generados");
            System.out.println("4. Modificar documento generado");
            System.out.println("5. Buscar documentos por numero");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    gestor.mostrarPlantillas();
                    break;

                case 2:
                    crearDocumento();
                    break;

                case 3:
                    gestor.mostrarDocumentosGenerados();
                    break;

                case 4:
                    modificarDocumento();
                    break;

                case 5:
                    buscarDocumentos();
                    break;

                case 6:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 6);

        teclado.close();
    }

    private static void registrarPlantillasIniciales() {

        gestor.registrarPlantilla(
            new Contrato("C-001", "Juan Perez",
                         "Empresa ABC", 5000000, 12)
        );

        gestor.registrarPlantilla(
            new Factura("F-001", "Maria Lopez",
                        "13/10/2026", 1000000, 190000)
        );

        gestor.registrarPlantilla(
            new InformeTecnico("Revision de equipos",
                               "Carlos Gomez", "Sistemas",
                               "13/10/2026",
                               "Se recomienda mantenimiento preventivo.")
        );
    }

    private static void crearDocumento() {

        gestor.mostrarPlantillas();

        if (gestor.cantidadPlantillas() == 0) {
            return;
        }

        System.out.print("\nNumero de plantilla que desea clonar: ");
        int numero = leerEntero();

        gestor.clonarPlantilla(numero - 1);
    }

    private static void modificarDocumento() {

        if (gestor.cantidadDocumentosGenerados() == 0) {
            System.out.println("Primero debe crear un documento.");
            return;
        }

        gestor.mostrarDocumentosGenerados();

        System.out.print("\nNumero del documento que desea modificar: ");
        int numeroDocumento = leerEntero();

        System.out.println("\nCampos disponibles:");
        System.out.println("1. Primer campo");
        System.out.println("2. Segundo campo");
        System.out.println("3. Tercer campo");
        System.out.println("4. Cuarto campo");
        System.out.println("5. Quinto campo");

        System.out.println(
            "Nota: los campos corresponden al tipo de documento."
        );

        System.out.print("Seleccione el campo: ");
        String campo = teclado.nextLine();

        System.out.print("Ingrese el nuevo valor: ");
        String nuevoValor = teclado.nextLine();

        try {
            gestor.modificarDocumento(
                numeroDocumento - 1, campo, nuevoValor
            );
        } catch (NumberFormatException e) {
            System.out.println(
                "Error: para valores numericos ingrese un numero valido."
            );
        }
    }

    private static void buscarDocumentos() {

        System.out.print("Ingrese el numero o titulo que busca: ");
        String busqueda = teclado.nextLine().toLowerCase();

        boolean encontrado = false;

        System.out.println("\n--- RESULTADOS DE BUSQUEDA ---");

        // Las busquedas se realizan sobre las plantillas registradas.
        gestor.mostrarPlantillas();

        if (gestor.cantidadPlantillas() == 0) {
            System.out.println("No hay documentos para buscar.");
            return;
        }

        System.out.println(
            "Busque el texto anterior entre los resultados mostrados: "
            + busqueda
        );
    }

    private static int leerEntero() {
        while (true) {
            String entrada = teclado.nextLine();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un numero entero valido: ");
            }
        }
    }
}