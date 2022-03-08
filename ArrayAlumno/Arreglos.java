package ArrayAlumno;

import java.util.Scanner;

public class Arreglos {

    /**
     * @param args the command line arguments
     */
    //static int numeros[]=new int[100];
    static boolean flag=true;
    //alumnos

    static int MAXIMO_ALUMNOS=10;
    static Alumnos alumnos[]=new Alumnos[MAXIMO_ALUMNOS];
    static int posicion_Actual=0;

    public static void main(String[] args) {
        // TODO code application logic here
        /*
        objeto obj=new objeto();
        objeto obj2=new objeto();
        objetos[0]=obj;
        objetos[1]=obj2;
        objetos[2]=obj2;
        objetos[3]=obj;

        objetos[1]=null;//eliminacion logica no fisica
        */
        //if(objetos[1]!=null)


        menu();


    }

    /*
    1 inicialize el array con los 100 primeros numero pares
    2 buscar dada una posicion
    3 visualize la informacion del arreglo
    4 cambiar/actualizar su valor dada una posicion
    5 salir
    */

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
                    ingresar();
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

    static boolean getDni(String dni){

        for(int pos=0;pos<posicion_Actual;pos++){
            Alumnos al=alumnos[pos];
            if(al.getDni().equals(dni))
                return true;
        }
        return false;
    }
    static int getDniPos(String dni){
        for(int pos=0;pos<posicion_Actual;pos++){
            Alumnos al=alumnos[pos];
            //if(al.getDni()==dni)
            if(al.getDni().equals(dni))
                return pos;
        }
        return -1;
    }

    //metodo para agregar al principio, al final y en una posicion
    private static void ingresar() {

        if(posicion_Actual<MAXIMO_ALUMNOS){
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
            alumnos[posicion_Actual]=al;
            posicion_Actual++;
            flag=false;//saber si hay elementos en mmi arreglo
        }else{
            System.out.println("No s epuede ingresar mas alumnos!!");
        }
    }

    private static void buscar() {
        if(flag){
            System.out.println("No se puede buscar,se necesita inicializar la informacion!!");
            return;
        }
        System.out.println("Digite dni del alumno");
        Scanner teclado=new Scanner(System.in);
        String dni=teclado.nextLine();


        if(getDni(dni)){
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
        int pos=getDniPos(dni);
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
        int pos=getDniPos(dni);
        if(pos!=-1){
            //lo encuentra
            alumnos[pos]=null;
            System.out.println("Alumno eliminado!");
        }else{
            System.out.println("No se ha encontrado ningun Alumno!");
        }

    }


}
