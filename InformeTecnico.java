public class InformeTecnico implements Documento {

    private String titulo;
    private String responsable;
    private String area;
    private String fecha;
    private String conclusiones;

    public InformeTecnico(String titulo, String responsable,
                          String area, String fecha,
                          String conclusiones) {

        this.titulo = titulo;
        this.responsable = responsable;
        this.area = area;
        this.fecha = fecha;
        this.conclusiones = conclusiones;
    }

    @Override
    public Documento clonar() {
        return new InformeTecnico(
            this.titulo,
            this.responsable,
            this.area,
            this.fecha,
            this.conclusiones
        );
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("TIPO: INFORME TECNICO");
        System.out.println("Titulo: " + titulo);
        System.out.println("Responsable: " + responsable);
        System.out.println("Area: " + area);
        System.out.println("Fecha: " + fecha);
        System.out.println("Conclusiones: " + conclusiones);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getConclusiones() {
        return conclusiones;
    }

    public void setConclusiones(String conclusiones) {
        this.conclusiones = conclusiones;
    }
}