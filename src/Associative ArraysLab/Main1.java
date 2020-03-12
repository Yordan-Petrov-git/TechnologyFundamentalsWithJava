package AssociativeArraysEcx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main1 {


    public static BufferedReader reader =
            new BufferedReader(
                    new InputStreamReader(
                            System.in
                    ));

    public static void main(String[] args) throws IOException {

//================================================================
        //1.	Count Real Numbers
        //countRealNumbers();

//--------------------------------------------------------------------------
        //2.	Word Synonyms
        //wordSynonyms();
//==========================================================================================
//3.	Odd Occurrences
        //oddOcurrences();
//==================================================================================
//4.	Word Filter
        //wordsFilter();
//====================================================================================
        //5.	Largest 3 Numbers
        //largestNumbers();
//=====================================================================================
    }

    private static void countRealNumbers() throws IOException {
        //1.	Count Real Numbers
        Map<Double, Integer> map = new TreeMap<>();

        double[] numbers =
                Arrays.stream(
                        reader.readLine()
                                .split("\\s+"))
                        .mapToDouble(e -> Double.parseDouble(e)).toArray();

        for (double num : numbers) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        for (Map.Entry<Double, Integer> kvp : map.entrySet()) {
            System.out.println(
                    String.format("%.0f -> %d",
                            kvp.getKey(),
                            kvp.getValue()));
        }
    }

    private static void wordSynonyms() throws IOException {
        //2.	Word Synonyms
        LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String word = reader.readLine();
            String synonym = reader.readLine();
            lhm.putIfAbsent(word, new ArrayList<>());
            lhm.get(word).add(synonym);
        }
        lhm.forEach((key, value) -> {
            System.out.println(String.format("%s - %s", key, value).replaceAll("[\\[\\]]", ""));
        });
    }

    private static void oddOcurrences() throws IOException {
        //3.	Odd Occurrences
        String[] input = reader.readLine().split("\\s+");

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();


        for (String word : input) {
            String wordToLc = word.toLowerCase();
            if (map.containsKey(wordToLc)) {
                map.put(wordToLc, map.get(wordToLc) + 1);
            } else {
                map.put(wordToLc, 1);
            }
        }


        ArrayList<String> ods = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getValue() % 2 == 1) {
                ods.add(stringIntegerEntry.getKey());
            }
        }

        for (int i = 0; i < ods.size(); i++) {
            System.out.print(ods.get(i));
            if (i < ods.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private static void wordsFilter() throws IOException {
        //4.	Word Filter
        String[] words = Arrays.stream(
                reader.readLine().split("\\s+"))
                .filter(w -> w.length() % 2 == 0)
                .toArray(String[]::new);


        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }

    private static void largestNumbers() throws IOException {
        //5.	Largest 3 Numbers
        String[] input = reader.readLine().split("\\s+");

        List<Integer> sort =
                Arrays.stream(input)
                        .map(e ->
                                Integer.parseInt(e))
                        .sorted((a, b) -> Integer.compare(b, a)).limit(3).collect(Collectors.toList());
        System.out.println(String.format(sort.toString()).replaceAll("[\\[\\],]", ""));
    }
}
