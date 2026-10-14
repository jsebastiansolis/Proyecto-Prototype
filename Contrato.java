public class Contrato implements Documento {

    private String numero;
    private String contratista;
    private String entidadContratante;
    private double valor;
    private int duracion;

    public Contrato(String numero, String contratista,
                    String entidadContratante, double valor,
                    int duracion) {

        this.numero = numero;
        this.contratista = contratista;
        this.entidadContratante = entidadContratante;
        this.valor = valor;
        this.duracion = duracion;
    }

    @Override
    public Documento clonar() {
        return new Contrato(
            this.numero,
            this.contratista,
            this.entidadContratante,
            this.valor,
            this.duracion
        );
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("TIPO: CONTRATO");
        System.out.println("Numero: " + numero);
        System.out.println("Contratista: " + contratista);
        System.out.println("Entidad contratante: " + entidadContratante);
        System.out.println("Valor: $" + valor);
        System.out.println("Duracion: " + duracion + " meses");
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getContratista() {
        return contratista;
    }

    public void setContratista(String contratista) {
        this.contratista = contratista;
    }

    public String getEntidadContratante() {
        return entidadContratante;
    }

    public void setEntidadContratante(String entidadContratante) {
        this.entidadContratante = entidadContratante;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}