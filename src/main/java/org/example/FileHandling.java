package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
                List<Integer> row = new ArrayList<>();
                String[] lineNumbers = line.split(" ");
                for(String lineNumber : lineNumbers) {
                    row.add(Integer.parseInt(lineNumber));
                }
                matrix.add(row);
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
