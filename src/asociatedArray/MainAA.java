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
        //01.   Count Chars in a String
        //countCharsInString(reader.readLine());
//=============================================================
        //2.    A Miner Task
        //aMinerTask();
//=============================================================
        //3.	Legendary Farming
//=============================================================
        //4.	Orders
//=============================================================
        //5.	SoftUni Parking
//=============================================================
        //6.	Courses
//=============================================================
        //7.	Student Academy
//=============================================================
        //8.	Company Users
//=============================================================
        //9.	*ForceBook
//=============================================================
        //10.	*SoftUni Exam Results
//=============================================================


    }

    private static void aMinerTask() throws IOException {
        LinkedHashMap<String, Integer> linkedHashMap =
                new LinkedHashMap<>();

        String input = "";

        while (!"stop".equals(input = reader.readLine())) {

            String resource = input;
            int quantity = Integer.parseInt(reader.readLine());
            if (!linkedHashMap.containsKey(resource)) {
                linkedHashMap.put(resource, quantity);

            } else {
                linkedHashMap.put(resource, linkedHashMap.get(resource)
                        + quantity);
            }

        }
        linkedHashMap.entrySet().forEach(e -> {
            System.out.println(
                    String.format("%s -> %d"
                            , e.getKey(), e.getValue()));
        });
    }

    private static void countCharsInString(String textInput) throws IOException {

        LinkedHashMap<Character, Integer> countChars =
                new LinkedHashMap<>();

        String text =
                String.join("", textInput.split("\\s+"));


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
