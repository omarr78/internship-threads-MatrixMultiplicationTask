package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileHandling {
    private final List<List<Integer>> matrix = new ArrayList<>();
    public void readFile(String filename) {
        try{
            File file = new File(filename);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String row = line.replaceAll(" ","");
                List<Integer> rowList = new ArrayList<>();
                for (int i = 0; i < row.length(); i++) {
                    char ch = row.charAt(i);
                    int num = ch - '0';
                    rowList.add(num);
                }
                matrix.add(rowList);
            }
            myReader.close();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    public List<List<Integer>> getMatrix() {
        return matrix;
    }
}
