public class Curso {
    private String carrera;
    private String nombre;
    private String nivel;
    private String tipo;
    private String requisitos;
    private String codigo;
    private String  creditos;


    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRequisitos() {
        return requisitos;
    }
    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCreditos() {
        return creditos;
    }
    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public void printCurso(){
        System.out.println("Carrera   : " + this.carrera);
        System.out.println("Nombre    : " + this.nombre);
        System.out.println("Creditos  : " + this.creditos);
        System.out.println("Codigo    : " + this.codigo);
        System.out.println("Nivel     : " + this.nivel);
        System.out.println("Requisitos: " + this.requisitos);
        System.out.println("Tipo      : " + this.tipo);
        System.out.println("\n");
    }
}
