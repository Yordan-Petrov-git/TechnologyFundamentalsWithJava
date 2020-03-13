package TextProcessingandRegularExpressions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main2 {
    public static BufferedReader reader =
            new BufferedReader(
                    new InputStreamReader(
                            System.in
                    )
            );

    public static void main(String[] args) throws IOException {
//==============================================================
//1.	Repeat strings
        // repeatStrings();
        //==============================================================
        // 2.	Substring
        //substring();
        //==============================================================

        //==============================================================

        //==============================================================

        //==============================================================



    }

    private static void substring() throws IOException {
        String keyWord = reader.readLine();
        String lineSecond = reader.readLine();

        int index = lineSecond.indexOf(keyWord);


        while (index != -1) {
            lineSecond =
                    lineSecond.substring(0, index)
                            + lineSecond.substring(index + keyWord.length());
            index = lineSecond.indexOf(keyWord);
        }
        System.out.println(lineSecond);
    }


    private static void repeatStrings() throws IOException {
        String[] word = (reader.readLine().split("\\s+"));

        StringBuilder sb = new StringBuilder();
        for (String s : word) {
            for (int i = 0; i < s.length(); i++) {
                sb.append(s);
            }
        }
        System.out.println(sb);
    }
}
