package Biblioteca;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GestionaLibros {

    private static Scanner sc = new Scanner(System.in);
    private static Libro libro;
    private static ArrayList<Libro> librosLista =new ArrayList<Libro>();
    public static ArrayList<String> ficheros = new ArrayList<>();
    //save the book object and the file path

    public static void guardarLibro(Libro l,String fileName){

        ObjectOutputStream out=null;

        try {
            //write the book object to fileName
            out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(l);
            System.out.println("Titulo"+l.getTitle());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //try to close the ObjectOutputStream using the method
            intentarCerrar(out);
        }

    }


    public static void intentarCerrar(Closeable aCerrar) {
        try {
            if (aCerrar != null) {
                aCerrar.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }

    public static void crearListaLibros(int cantidad){

        sc = new Scanner(System.in);
        String title, author, editor;
        int pagesNum, publicationDate;

        if (cantidad>=1){
            //if the user has introduced more than 1 book to save
            //introduce title, author, editor, pagenumbers, date...
            for (int i = 0; i < cantidad; i++) {
                System.out.println("Intoduce el titulo del libro "+i+1);
                title = sc.next();
                if(title==null || title.isEmpty()){
                    System.out.println("Introduce un título correcto");
                    MainBiblioteca.crearMenu();
                }
                System.out.println("Intoduce el autor del libro "+i+1);
                author = sc.next();
                if(author==null || author.isEmpty()){
                    System.out.println("Introduce un título correcto");
                    MainBiblioteca.crearMenu();
                }
                System.out.println("Intoduce el editor del libro "+i+1);
                editor = sc.next();
                if(editor==null || editor.isEmpty()){
                    System.out.println("Introduce un título correcto");
                    MainBiblioteca.crearMenu();
                }
                System.out.println("¿Cuántas páginas tiene el libro? "+i+1);
                pagesNum = sc.nextInt();
                System.out.println("Intoduce la fecha de publicación: "+i+1);
                publicationDate = sc.nextInt();
                libro = new Libro(title, author, editor, pagesNum, publicationDate);
                librosLista.add(libro);

            }
        }else{
            System.out.println("Introduce más de un libro para crear una lista");
            System.out.println("------VUELTA AL MENÚ------");
            MainBiblioteca.crearMenu();
        }

        System.out.println("Dime la ruta absoluta donde guardar la lista");
        String ruta = sc.nextLine();
        ruta +=".txt";


        try {
            //le paso la ruta donde me va a guardar el fichero
            FileOutputStream fos = new FileOutputStream(ruta);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //¿qué voy a guardar?
            oos.writeObject(librosLista);
            intentarCerrar(fos);
            intentarCerrar(oos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

    }

    public static void crearLibro(){
        sc = new Scanner(System.in);
        String titleIndiv, authorIndiv, editorIndiv;
        int pagesNumIndiv, publicationDateIndiv;
        System.out.println("Intoduce el titulo del libro");
        titleIndiv = sc.next();
        System.out.println("Intoduce el autor del libro");
        authorIndiv = sc.next();
        System.out.println("Intoduce el editor del libro");
        editorIndiv = sc.next();
        System.out.println("¿Cuántas páginas tiene el libro? ");
        pagesNumIndiv = sc.nextInt();
        System.out.println("Intoduce la fecha de publicación: ");
        publicationDateIndiv = sc.nextInt();
        Libro libroIndiv = new Libro(titleIndiv, authorIndiv, editorIndiv, pagesNumIndiv, publicationDateIndiv);
        guardarLibro(libroIndiv, libroIndiv.getTitle()+".txt");
        System.out.println("Libro creado con éxito ");
        System.out.println("------VUELTA AL MENÚ------");
        MainBiblioteca.crearMenu();
    }
    //read the objects saved in the fileName

    public ArrayList<Integer>devolverAnyos(ArrayList<String> ficheros){
        Iterator<String> it = ficheros.iterator();
        String nombreFichero;
        Libro libroRecuperado;
        ArrayList<Integer> anyosLibros = new ArrayList<Integer>();
        while (it.hasNext()){
            nombreFichero = it.next();
            libroRecuperado=recuperar(nombreFichero);
            anyosLibros.add(libroRecuperado.getPublicationDate());
        }

        return anyosLibros;
    }

    public Libro recuperar(String f) {

        //comprobar si la ruta existe, si no existe decirle si desea crearlo
        Libro l = null;
        ObjectInputStream in=null;
        try {
            in = new ObjectInputStream(new FileInputStream(f));
            //casting to book object class
            l = (Libro) in.readObject();

        } catch (ClassNotFoundException ex) {
            System.err.println("Error de fichero");
        } catch (IOException ex) {
            System.err.println("Error IO");
        }finally{
            intentarCerrar(in);
        }
        return l;
    }


}
