package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {

        int filesCount = 2;
        ExecutorService executor = Executors.newFixedThreadPool(filesCount);

        List<FileThreads> tasks = new ArrayList<>();

        for (char i = 'A'; i <= 'B'; i++) {
            tasks.add(new FileThreads(String.valueOf(i),new FileHandling()));
        }

        for (int i = 0; i < filesCount; i++) {
            executor.execute(tasks.get(i));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS); // wait for running tasks to finish

        List<List<Integer>> matrixA = tasks.get(0).getFileHandling().getMatrix();
        List<List<Integer>> matrixB = tasks.get(1).getFileHandling().getMatrix();

        MatrixMultiplication multiplication = new MatrixMultiplication();

        List<List<Integer>> result = multiplication.calculateMul(matrixA, matrixB);


        for (List<Integer> numbers : result) {
            for (Integer number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}