package org.example;

import java.io.File;

public class FileThreads implements Runnable{

    private final String fileName;
    private final FileHandling fileHandling;

    FileThreads(String fileName, FileHandling fileHandling) {
        this.fileName = fileName + ".txt";
        this.fileHandling = fileHandling;
    }

    public void run() {
        File f = new File(fileName);

        if(f.exists()){
            fileHandling.readFile(fileName);
        }
    }

    public FileHandling getFileHandling(){
        return fileHandling;
    }

    @Override
    public String toString() {
        return "MultiThreading{" +
                "fileNumber=" + fileName +
                ", fileHandling=" + fileHandling +
                '}';
    }
}
