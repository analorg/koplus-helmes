package com.koplus;

import java.util.ArrayList;

class Split {
    Split(String message) {
        this.time = System.currentTimeMillis();
        this.message = message;
    }

    Split() {
        this.time = System.currentTimeMillis();
    }

    long time;
    String message;
}

public class SimpleTimer {
    private static long startTime;
    private static ArrayList<Split> splits = new ArrayList<>();

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void split() {
        splits.add(new Split());
    }

    public static void split(String splitName) {
        splits.add(new Split(splitName));
    }

    public static void printResults() {
        for (int i = 0; i < splits.size(); i++) {
            if (null != splits.get(i).message) {
                System.out.printf("%d: \"%s\" %.04fs\n", (i + 1), splits.get(i).message, (splits.get(i).time - startTime) / 1000.f);
            } else {
                System.out.printf("Split-%d: %.04fs\n", (i + 1), (splits.get(i).time - startTime) / 1000.f);
            }
        }
    }
}