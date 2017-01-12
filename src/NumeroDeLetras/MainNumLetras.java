package NumeroDeLetras;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainNumLetras {

    public static void main(String[] args){
        File f = new File("words.txt");
        int value = 2;
        try {
            longitude(value, f);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void longitude(int numberOfLetters,File file)throws IOException{
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String str;
        boolean moreThanOne = false;
        while((str = br.readLine()) !=null){
            if(str.length() == numberOfLetters){
                moreThanOne = true;
                System.out.println(str);
            }
        }
        if(!moreThanOne){
            System.out.println("Can't find words with that number of letters");
        }
    }

}
