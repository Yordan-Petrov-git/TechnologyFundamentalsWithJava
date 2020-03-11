package asociatedArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class MainAA {

    public static BufferedReader reader =
            new BufferedReader(
                    new InputStreamReader(
                            System.in
                    )
            );

    public static void main(String[] args) throws IOException {

//=============================================================
        //01. Count Chars in a String
        countCharsInString(reader.readLine());
//=============================================================

    }

    private static void countCharsInString(String textInput) throws IOException {

        LinkedHashMap<Character, Integer> countChars =
                new LinkedHashMap<>();

        String text =
                String.join("",textInput.split("\\s+"));


        for (int i = 0; i < text.length(); i++) {
            char s = text.charAt(i);

            if (!countChars.containsKey(s)) {
                countChars.put(s, 1);
            } else {
                countChars.put(s, countChars.get(s) + 1);
            }
        }
        countChars.entrySet().forEach(e -> {
            System.out.println(
                    String.format("%c -> %d", e.getKey()
                            , e.getValue()));
        });
    }
}
