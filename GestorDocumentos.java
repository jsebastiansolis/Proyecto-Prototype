import java.util.ArrayList;

public class GestorDocumentos {

    private ArrayList<Documento> plantillas;
    private ArrayList<Documento> documentosGenerados;

    public GestorDocumentos() {
        plantillas = new ArrayList<>();
        documentosGenerados = new ArrayList<>();
    }

    public void registrarPlantilla(Documento documento) {
        plantillas.add(documento);
        System.out.println("Plantilla registrada correctamente.");
    }

    public void mostrarPlantillas() {
        if (plantillas.isEmpty()) {
            System.out.println("No hay plantillas registradas.");
            return;
        }

        System.out.println("\n--- PLANTILLAS REGISTRADAS ---");

        for (int i = 0; i < plantillas.size(); i++) {
            System.out.println("\nPlantilla " + (i + 1));
            plantillas.get(i).mostrarInformacion();
        }
    }

    public void clonarPlantilla(int indice) {
        if (indice < 0 || indice >= plantillas.size()) {
            System.out.println("Numero de plantilla invalido.");
            return;
        }

        Documento copia = plantillas.get(indice).clonar();
        documentosGenerados.add(copia);

        System.out.println("Documento clonado correctamente.");
        copia.mostrarInformacion();
    }

    public void mostrarDocumentosGenerados() {
        if (documentosGenerados.isEmpty()) {
            System.out.println("No hay documentos generados.");
            return;
        }

        System.out.println("\n--- DOCUMENTOS GENERADOS ---");

        for (int i = 0; i < documentosGenerados.size(); i++) {
            System.out.println("\nDocumento " + (i + 1));
            documentosGenerados.get(i).mostrarInformacion();
        }
    }

    public void modificarDocumento(int indice, String campo,
                                   String nuevoValor) {

        if (indice < 0 || indice >= documentosGenerados.size()) {
            System.out.println("Numero de documento invalido.");
            return;
        }

        Documento documento = documentosGenerados.get(indice);
        boolean modificado = false;

        if (documento instanceof Contrato) {
            Contrato c = (Contrato) documento;

            switch (campo) {
                case "1":
                    c.setNumero(nuevoValor);
                    modificado = true;
                    break;
                case "2":
                    c.setContratista(nuevoValor);
                    modificado = true;
                    break;
                case "3":
                    c.setEntidadContratante(nuevoValor);
                    modificado = true;
                    break;
                case "4":
                    c.setValor(Double.parseDouble(nuevoValor));
                    modificado = true;
                    break;
                case "5":
                    c.setDuracion(Integer.parseInt(nuevoValor));
                    modificado = true;
                    break;
            }

        } else if (documento instanceof Factura) {
            Factura f = (Factura) documento;

            switch (campo) {
                case "1":
                    f.setNumero(nuevoValor);
                    modificado = true;
                    break;
                case "2":
                    f.setCliente(nuevoValor);
                    modificado = true;
                    break;
                case "3":
                    f.setFecha(nuevoValor);
                    modificado = true;
                    break;
                case "4":
                    f.setSubtotal(Double.parseDouble(nuevoValor));
                    modificado = true;
                    break;
                case "5":
                    f.setImpuestos(Double.parseDouble(nuevoValor));
                    modificado = true;
                    break;
            }

        } else if (documento instanceof InformeTecnico) {
            InformeTecnico informe = (InformeTecnico) documento;

            switch (campo) {
                case "1":
                    informe.setTitulo(nuevoValor);
                    modificado = true;
                    break;
                case "2":
                    informe.setResponsable(nuevoValor);
                    modificado = true;
                    break;
                case "3":
                    informe.setArea(nuevoValor);
                    modificado = true;
                    break;
                case "4":
                    informe.setFecha(nuevoValor);
                    modificado = true;
                    break;
                case "5":
                    informe.setConclusiones(nuevoValor);
                    modificado = true;
                    break;
            }
        }

        if (modificado) {
            System.out.println("Documento modificado correctamente.");
        } else {
            System.out.println("Opcion de campo invalida.");
        }
    }

    public int cantidadPlantillas() {
        return plantillas.size();
    }

    public int cantidadDocumentosGenerados() {
        return documentosGenerados.size();
    }
}