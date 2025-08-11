package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixMultiplication {

    private final List<List<Integer>> result;

    MatrixMultiplication(){
        result = new ArrayList<>();
    }

    public List<List<Integer>> calculateMul(List<List<Integer>> firstMatrix, List<List<Integer>> secondMatrix) throws InterruptedException {
        int N = firstMatrix.size();
        int M = firstMatrix.getFirst().size();
        int P = secondMatrix.getFirst().size();

        ExecutorService executor = Executors.newFixedThreadPool(N);

        for(int i = 0; i < N; i++) {
            int finalI = i; // effectively final
            executor.execute(() -> {
                List<Integer> rowList = new ArrayList<>();
                for(int j = 0; j < P; j++) {
                    int sum = 0;
                    for(int k = 0 ; k < M ; k++){
                        sum+= firstMatrix.get(finalI).get(k) * secondMatrix.get(k).get(j);
                    }
                    rowList.add(sum);
                }
                addingRowInMatrix(rowList);
            });
        }
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS); // wait for running tasks to finish
        return result;
    }
    public synchronized void addingRowInMatrix(List<Integer> row) {
        result.add(row);
    }

}
