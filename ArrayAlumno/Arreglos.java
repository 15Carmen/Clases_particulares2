package ArrayAlumno;

import java.util.Scanner;

public class Arreglos {

    /**
     * @param args the command line arguments
     */

    static boolean flag=true;

    //alumnos
    static int MAXIMO_ALUMNOS=10;
    static Alumnos alumnos[]=new Alumnos[MAXIMO_ALUMNOS];
    static int posicion_Actual=0;

    public static void main(String[] args) {

        menu();


    }

    private static void menu() {


        Scanner teclado=new Scanner(System.in);
        int opc=0;

        do{
            System.out.println("========== MENU ================");
            System.out.println("[1] Ingresar Alumnos");
            System.out.println("[2] Buscar un alumno");
            System.out.println("[3] Visualizar los Alumnos");
            System.out.println("[4] Modificar un Alumno");
            System.out.println("[5] Eliminar un Alumno");
            System.out.println("[6] Salir");
            opc=teclado.nextInt(); //teclado

            switch(opc){
                case 1:
                    ingresarFinal();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    modificar();
                    break;
                case 5:
                    eliminar();
                    break;
                case 6:
                    salir();
                    break;
                default:
                    System.out.println("Ingrese opcion valida[1-5]");
            }

        }while(opc!=6);
    }
    /*dada una posicion que devuelva su valor y no encuentra que devuelva -1*/

    static int getDni(String dni){
        for(int pos=0;pos<posicion_Actual;pos++){
            Alumnos al=alumnos[pos];
            //if(al.getDni()==dni)
            if(al.getDni().equals(dni))
                return pos;
        }
        return -1;
    }

    private static Alumnos ingresar() {

        Scanner teclado=new Scanner(System.in);

        System.out.println("Ingrese nombre de alumno!!");
        String nombre=teclado.nextLine();

        System.out.println("Ingrese edad de alumno!!");
        int edad=teclado.nextInt();

        System.out.println("Ingrese dni de alumno!!");
        //limpiar el buffer
        teclado.nextLine();
        String dni=teclado.nextLine();

        Alumnos al=new Alumnos(nombre,edad,dni);
        return al;
    }

    //metodo para agregar al principio, al final y en una posición

    private static void ingresarFinal() {

        if(posicion_Actual<MAXIMO_ALUMNOS){

            alumnos[posicion_Actual]= ingresar();
            posicion_Actual++;

            flag=false;//saber si hay elementos en mi arreglo
        }else{
            System.out.println("No se puede ingresar más alumnos!!");
        }
    }

    /*
    private static void ingresarPincipioFor(){

        Alumnos alu = new Alumnos();

        for ()


    }
*/
    private static void ingresarPrincipio(){

        System.arraycopy(alumnos, 0, alumnos, 1, alumnos.length);
        alumnos[0] = ingresar();

    }

    private static void ingresarMedio(){

        Scanner teclado=new Scanner(System.in);

        System.out.println("Ingrese la posicion en la que desea ingresar el alumno");
        int pos= teclado.nextInt();

        System.arraycopy(alumnos, pos, alumnos, pos++, alumnos.length);
        alumnos[pos] = ingresar();

    }

    private static void buscar() {

        if(flag){
            System.out.println("No se puede buscar,se necesita inicializar la informacion!!");
            return;
        }
        System.out.println("Digite dni del alumno");
        Scanner teclado=new Scanner(System.in);
        String dni=teclado.nextLine();

        if(getDni(dni) != -1){
            System.out.println("El alumno esta registrado!!");

        }else{
            System.out.println("El alumno NO esta registrado!!");
        }
    }

    private static void visualizar() {
        if(flag){
            System.out.println("No se puede presentar,se necesita inicializar la informacion!!");
            return;
        }
        for(int pos=0;pos<posicion_Actual;pos++){
            System.out.println("*********************");
            System.out.println(alumnos[pos].toString());
        }
        //yo te escucho,luego m,iramos porque no me escuchas
    }

    private static void modificar() {
        if(flag){
            System.out.println("No se puede modificar,se necesita inicializar la informacion!!");
            return;
        }
        System.out.println("Digite dni del Alumno");
        Scanner teclado=new Scanner(System.in);
        String dni=teclado.nextLine();
        int pos=getDni(dni);
        if(pos!=-1){
            Alumnos al=alumnos[pos];
            System.out.println("Digite su nombre");
            String nombre=teclado.nextLine();
            System.out.println("Digite su edad");
            int edad=teclado.nextInt();
            System.out.println("Digite su dni");
            String _dni=teclado.nextLine();
            al.setNombre(nombre);
            al.setEdad(edad);
            al.setDni(_dni);
            alumnos[pos]=al;
            System.out.println("Informacion cambiada!!");
        }else{
            System.out.println("Alumno NO encontrado!!");
        }
    }

    private static void salir() {
        System.out.println("Adios hasta la proxima!!");
        System.exit(0);
    }


    private static void eliminar() {
        if(flag){
            System.out.println("No se puede eliminar,se necesita inicializar la informacion!!");
            return;
        }
        System.out.println("Digite dni del Alumno");
        Scanner teclado=new Scanner(System.in);
        String dni=teclado.nextLine();
        int pos=getDni(dni);
        if(pos!=-1){
            //lo encuentra
            alumnos[pos]=null;
            System.out.println("Alumno eliminado!");
        }else{
            System.out.println("No se ha encontrado ningun Alumno!");
        }

    }


}
