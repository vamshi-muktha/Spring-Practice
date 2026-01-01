package com.tcs.problem1;

import java.util.HashSet;

public class RandomModule {
    public static void main(String[] args) {

        HashSet<Integer> hs = new HashSet<>();
        int n = 55;

        // Fill numbers 1 to 55
        for (int i = 1; i <= n; i++) {
            hs.add(i);
        }

        // 11 groups
        for (int i = 0; i < 11; i++) {
            int[] temp = new int[5];

            for (int l = 0; l < 5; l++) {
                int x = (int)(Math.random() * 55) + 1;

                while (!hs.contains(x)) {
                    x = (int)(Math.random() * 55) + 1;
                }

                temp[l] = x;
                hs.remove(x);
            }

            // Print group
            System.out.print("Group " + (i + 1) + ": ");
            for (int s : temp) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
