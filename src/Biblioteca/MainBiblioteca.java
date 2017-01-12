package Biblioteca;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static Biblioteca.GestionaLibros.crearLibro;
import static Biblioteca.GestionaLibros.ficheros;

public class MainBiblioteca {

    private static Scanner sc = new Scanner(System.in);
    private static Libro libro;
    public static GestionaLibros gl= new GestionaLibros();

    public static void main(String[] args){
        crearMenu();
    }


    public static void crearMenu(){
        System.out.println("1. Guardar libros individuales");
        System.out.println("2. Recuperar libro individual");
        System.out.println("3. Modificar título o autor de un libro");
        System.out.println("4. Guardar listas de libros");
        System.out.println("5. Devolver años de unos ficheros");
        int seleccion = sc.nextInt();

        switch (seleccion){
            case 1:
/*                System.out.println("¿Cuántos libros vas a guardar?");
                int cantidad =sc.nextInt();*/
                gl.crearLibro();
                break;
            case 2:
                System.out.println("Escribe la ruta del fichero. Recuerda que el nombre del fichero es el del libro");
                // clean the buffer
                String basura = sc.nextLine();
                String rutaRecuperar = sc.nextLine();
                System.out.println("Voy a recuperar el libro: "+rutaRecuperar);
                if (rutaRecuperar.isEmpty()){
                    System.out.println("Introduce la ruta del libro.");
                }else{
                    File f = new File(rutaRecuperar);
                    if (f.exists()){
                        System.out.println("El fichero existe");
                        Libro libroR = gl.recuperar(rutaRecuperar);
                        libroR.printBook();
                        System.out.println("------VUELTA AL MENÚ------");
                        crearMenu();
                    }else {
                        System.out.println("El fichero no existe");
                        System.out.println("------VUELTA AL MENÚ------");
                        crearMenu();
                    }
                }

                break;
            case 3:
                System.out.println("Introduce la ruta absoluta del fichero a modificar");
                rutaRecuperar=sc.nextLine();
                //check if rutaRecuperar is not empty
                if (rutaRecuperar==null || rutaRecuperar.isEmpty()){
                    System.out.println("No has introducido una ruta.");
                    System.out.println("------VUELTA AL MENÚ------");
                    //if is empty go back to menu
                    crearMenu();
                }else {
                    //create "Libro" object and match it to Libro with path rutaRecuperar
                    Libro libroMod = gl.recuperar(rutaRecuperar);
                    System.out.println("¿Quieres modificar el título(1), el autor(2) o ambas(3)?");
                    int seleccionMod=sc.nextInt();
                    switch (seleccionMod){
                        case 1:
                            System.out.println("Introduce el título nuevo: ");
                            String basuraMod = sc.nextLine();
                            libroMod.setTitle(sc.nextLine());
                            System.out.println("TÍTULO MODIFICADO");
                            System.out.println("------VUELTA AL MENÚ------");
                            //if is empty go back to menu
                            crearMenu();
                            break;
                        case 2:
                            System.out.println("Introduce el autor nuevo: ");
                            String basuraMod2 = sc.nextLine();
                            libroMod.setAuthor(sc.nextLine());
                            System.out.println("AUTOR MODIFICADO");
                            System.out.println("------VUELTA AL MENÚ------");
                            //if is empty go back to menu
                            crearMenu();
                            break;
                        case 3:
                            System.out.println("Introduce el título nuevo: ");
                            String basuraMod3 = sc.nextLine();
                            libroMod.setTitle(sc.nextLine());
                            System.out.println("TÍTULO MODIFICADO");
                            System.out.println("Introduce el autor nuevo: ");
                            libroMod.setAuthor(sc.nextLine());
                            System.out.println("AUTOR MODIFICADO");
                            System.out.println("------VUELTA AL MENÚ------");
                            //if is empty go back to menu
                            crearMenu();
                    }

                }
                break;
            case 4:
                System.out.println("¿Cuántos libros vas a guardar?");
                int cantidadLista =sc.nextInt();
                gl.crearListaLibros(cantidadLista);
                crearLibro();
                break;
            case 5:
                //crear arraylist e gualar a gl.devolverAnyos(ficheros); y luego recorrerlo y escribir el los año
     
            default:
                System.out.println("No seleccionaste ninguna opción del menú.");
                crearMenu();
                break;
        }


    }
}
