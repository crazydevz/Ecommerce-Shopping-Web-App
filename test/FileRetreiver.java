/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Talha Iqbal
 */

// This is just a test class for file retreival testing for an upcoming feature.

public class FileRetreiver {
    public static void main(String[] args){
        File f = new File("F:\\Temporary Codes\\OnlineShoppingSystem\\Images");
        if(!f.exists()){
            System.err.println("file not accessible!");
        }
        List<File> files = new ArrayList<>(Arrays.asList(f.listFiles()));
        
        for(File filePath : files){
            System.out.println(filePath.getPath());
        }
    }
}
