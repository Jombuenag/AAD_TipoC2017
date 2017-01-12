package Biblioteca;

import java.io.Serializable;

public class Libro implements Serializable {
    private static String title, author, editor;
    private static int pagesNum, publicationDate;


    public Libro(String titleL, String authorL, String editorL, int pagesNumL, int publicationDateL){
        title = titleL;
        author = authorL;
        editor =  editorL;
        pagesNum =pagesNumL;
        publicationDate = publicationDateL;

    }


    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Libro.title = title;
    }

    public static String getAuthor() {
        return author;
    }

    public static void setAuthor(String author) {
        Libro.author = author;
    }

    public static String getEditor() {
        return editor;
    }

    public static void setEditor(String editor) {
        Libro.editor = editor;
    }

    public static int getPagesNum() {
        return pagesNum;
    }

    public static void setPagesNum(int pagesNum) {
        Libro.pagesNum = pagesNum;
    }

    public static int getPublicationDate() {
        return publicationDate;
    }

    public static void setPublicationDate(int publicationDate) {
        Libro.publicationDate = publicationDate;
    }

    public static void printBook(){
        System.out.println("Título: "+title+" Autor: "+author+" Editor: "+editor+" NumPaginas: "+pagesNum+" Fecha publicación: "+publicationDate);
    }
}
