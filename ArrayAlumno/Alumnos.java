package ArrayAlumno;

public class Alumnos {

    private String nombre;
    private String dni;
    private int edad;

    private float notas[];

    public Alumnos(String nombre, int edad,String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni=dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float[] getNotas() {
        return notas;
    }

    public void setNotas(float[] notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return "El nombre del Alumno es: "+this.nombre+"\n"+
                "Su edad del Alumno es: "+this.edad+"\n"+
                "Su dni del Alumno es: "+this.dni ;
    }


}
