/*
ID: jacob.h2
LANG: JAVA
TASK: namenum
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class namenum {
    final static String o = "ADGJMPTW";
    final static String w = "BEHKNRUX";
    final static String t = "CFILOSVY";
    public static void main(String[] args) throws FileNotFoundException {
        HashSet<String> dict = new HashSet<>();
        Scanner in = new Scanner(new File("namenum.in"));
        Scanner din = new Scanner(new File("dict.txt"));
        PrintWriter out = new PrintWriter(new File("namenum.out"));

        while(din.hasNext()) dict.add(din.next());
        String id = in.next();
        ArrayList<String> res = new ArrayList<>();
        dfs(0, res, dict, id,"");
        if(res.size() == 0)out.println("NONE");
        for(String r : res) out.println(r);
        out.close();
    }

    public static void dfs(int i, ArrayList<String> res, HashSet<String> dict, String id, String str) {
        if(i == id.length()) {
            if(dict.contains(str)) res.add(str);
        }
        else {
            int base = Integer.parseInt(id.substring(i, i + 1)) - 2;
            dfs(i + 1, res, dict, id, str + o.charAt(base));
            dfs(i + 1, res, dict, id, str + w.charAt(base));
            dfs(i + 1, res, dict, id, str + t.charAt(base));
        }
    }
}
