/*
ID: jacob.h2
LANG: JAVA
TASK: transform
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class transform {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("transform.in"));
        PrintWriter out = new PrintWriter(new File("transform.out"));
        int size = in.nextInt();
        in.nextLine();
        boolean[][] mat = new boolean[size][size];
        boolean[][] res = new boolean[size][size];
        in.useDelimiter("");

        for(int r = 0; r < size; r++) {
            for(int c = 0; c < size; c++) {
                mat[r][c] = in.next().equals("-");
            }
            in.nextLine();
        }

        for(int r = 0; r < size; r++) {
            for(int c = 0; c < size; c++) {
                res[r][c] = in.next().equals("-");
            }
            if(r != size-1) in.nextLine();
        }

        boolean[][] rot;
        boolean[][] ref;
        if(matches(rot = rot(mat), res)) out.println("1");
        else if(matches(rot = rot(rot), res)) out.println("2");
        else if(matches(rot(rot), res)) out.println("3");
        else if(matches(ref = reflect(mat), res)) out.println("4");
        else if(matches(ref = rot(ref), res)) out.println("5");
        else if(matches(ref = rot(ref), res)) out.println("5");
        else if(matches(ref = rot(ref), res)) out.println("5");
        else if(matches(mat, res)) out.println("6");
        else out.println("7");

        in.close();
        out.close();
    }

    public static boolean[][] reflect(boolean[][] mat) {
        mat = mat.clone();
        for(int r = 0; r < mat.length; r++) {
            for(int c = 0; c < mat[r].length / 2; c++) {
                boolean tmp = mat[r][c];
                mat[r][c] = mat[r][mat[r].length - c - 1];
                mat[r][mat[r].length - c - 1] = tmp;
            }
        }
        return mat;
    }

    public static boolean[][] rot(boolean[][] mat) {
        boolean[][] res = new boolean[mat.length][mat[0].length];
        for(int i = 0; i < mat.length; i++) {
            for(int r = 0; r < mat.length; r++) {
                res[r][i] = mat[mat.length - i - 1][r];
                mat[mat.length - i - 1][r] = res[r][i];
            }
        }
        return res;
    }

    public static boolean matches(boolean[][] mat, boolean[][] res) {
        for(int r = 0; r < mat.length; r++) {
            for(int c = 0; c < mat[r].length; c++) {
                if(res[r][c] != mat[r][c]) return false;
            }
        }
        return true;
    }
}
