/*
ID: jacob.h2
LANG: JAVA
TASK: palsquare
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class palsquare {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("palsquare.in"));
        PrintWriter out = new PrintWriter(new File("palsquare.out"));
        int base = in.nextInt();
        for(int i = 1; i <= 300; i++) {
            String square = Integer.toString(i * i, base).toUpperCase();
            if(palin(square)) out.println(Integer.toString(i, base).toUpperCase() + " " + square);
        }
        out.close();
    }

    public static boolean palin(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) return false;
        }
        return true;
    }
}
