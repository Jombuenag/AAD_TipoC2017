package ContadorFicheros;

import java.io.File;

public class MainContador {

    public static void main(String[] args){
        File file = new File("/home/takuma/workspace/Examen_AAD_2017_C/src/ContadorFicheros/Takuma/");
        String startsWith = new String ("b");
        countFiles(file,startsWith);
    }

    private static void countFiles(File folder, String startsWith ){
        //if exists
        if(folder.exists()){
            //if can read
            if(folder.canRead()){
                File[] listOfFiles = folder.listFiles();
                int numFilesStarts = 0;
                for(int i = 0; i < listOfFiles.length; i++){
                    String files = listOfFiles[i].getName();
                    if(startsWith.length()>files.length()){
                        System.out.println("They are not equal");
                    }else{
                        int counter = 0;
                        for(int j = 0; j< startsWith.length(); j++){
                            char letter = startsWith.charAt(j);
                            char letterCheck = files.charAt(j);
                            if(letter == letterCheck){
                                counter++;
                            }
                        }
                        if(counter==startsWith.length()){
                            numFilesStarts++;
                        }
                    }
                }
                System.out.println("There are " + numFilesStarts + " which starts with " + startsWith);
            }else{
                System.out.println("You have no permissions in this folder");
            }
        }else{
            System.out.println("Folder does not exists");
        }
    }
}
