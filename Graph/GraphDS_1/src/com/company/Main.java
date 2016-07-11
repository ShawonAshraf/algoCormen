package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("input.txt"));
        Graph g = new Graph(6, 15);
        final int E = 1;

        while(in.hasNextInt()) {
            int x = in.nextInt();
            int y = in.nextInt();

            g.add(x, y, E);
        }
        in.close();

        g.print();

        System.out.println("\n\nCalling BFS :::\n");
        for (int i = 1; i < 7; i++) {
            int[] ar = g.bfs(i);
            System.out.println(Arrays.toString(ar));
        }

    }

}
