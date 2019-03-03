package com.koplus;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        String userWord = args[1];
        char[] userWordArr = userWord.toLowerCase().toCharArray();
        Arrays.sort(userWordArr);
        int sizeWord = userWordArr.length;

        ArrayList<String> result = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "WINDOWS-1257"));

        String line;
        while ((line = br.readLine()) != null) {
            if (line.length() != sizeWord) {
                continue;
            }
            char[] currentWord = line.toLowerCase().toCharArray();

            Arrays.sort(currentWord);

            if (Arrays.equals(currentWord, userWordArr)) {
                result.add(line);
            }
        }

        System.out.println((System.currentTimeMillis() - startTime) + " " + String.join(",", result));
    }
}