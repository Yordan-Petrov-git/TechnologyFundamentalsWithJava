package AssociativeArraysEcx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

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
        //legendaryFarming();
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

        LinkedHashMap<String, Set<String>> forcebook = new LinkedHashMap<>();

        String input = "";//Стринг за входните данни

        while (!"Lumpawaroo".equals(input = reader.readLine())) {//Изпълнявмае до подаване на команда
            String[] data = (Arrays.stream(
                    input.split("\\s+\\|\\s+ | \\s+\\->\\s+")))
                    .toArray(String[]::new);
            if (input.contains("|")) {//Ако имаме комадна |

                String forceSide = data[0];
                String forceUser = data[1];

                if (!forcebook.containsKey(forceSide)) {
                    forcebook.put(forceSide, new TreeSet<>());
                }


                    if (forcebook.entrySet().stream().noneMatch(e ->
                            e.getValue().contains(forceUser))) {
                    forcebook.get(forceSide).add(forceUser);
                }


            } else {

                String forceUser = data[0];
                String forceSide = data[1];


                forcebook.forEach((key, value) -> {
                    value.remove(forceUser);
                });

                forcebook.get(forceSide).add(forceSide);

            }


        }

        forcebook.entrySet().stream().sorted((e1, e2) -> {
            int sort =
                    Integer.compare(e2.getValue().size(), e1.getValue().size());
            if (sort == 0) {
                e1.getKey().compareTo(e2.getKey());
            }
            return sort;
        }).forEach(kvp -> {//shift + f6 i zagrajdmane group renaming !!
            System.out.println(String.format("Side: %s, Members: %d", kvp.getKey(), kvp.getValue().size()));
            kvp.getValue().forEach(u ->
                    System.out.println(String.format("! %s", u)));
        });

    }

    private static void legendaryFarming() throws IOException {
        LinkedHashMap<String, Integer> keyMaterials =
                new LinkedHashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        LinkedHashMap<String, Integer> junk =
                new LinkedHashMap<>();

        String winner = "";//Стойност за победителя
        boolean winStatus = false;//Стйност за вин статуса

        do {
            String[] data = reader.readLine().split("\\s+");

            for (int i = 0; i < data.length; i += 2) {
                //итерираме през всеи 2 елемента за да вземем ключ ис тойност
                int quantity = Integer.parseInt(data[i]);//Вземеме всяка стойност за количеството
                String material = data[i + 1].toLowerCase();//Вземаме всяка 2 ра стойност за материяал

                if (!keyMaterials.containsKey(material)) {
                    if (!junk.containsKey(material)) {//Хендалване на джънк материали
                        junk.put(material, quantity);
                    } else {
                        junk.put(material, junk.get(material) + quantity);
                    }
                } else {
                    keyMaterials.put(material,
                            keyMaterials.get(material) + quantity);
                    if (keyMaterials.get(material) >= 250) {//Приключване на програмата
                        keyMaterials.put(material,
                                keyMaterials.get(material) - 250);
                        winner = material;
                        winStatus = true;
                        break;
                    }
                }
            }

        } while (!winStatus);//към суловието за материали принтирането на резултата
        if (winner.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (winner.equals("motes")) {
            System.out.println("Dragonwrath obtained!");
        } else if (winner.equals("fragments")) {
            System.out.println("Valanyr obtained!");
        }
        keyMaterials
                .entrySet()//Вземем ключ ис тойност
                .stream()//Стриим
                .sorted((e1, e2) -> {//Сортиране по 2 критерия е1 и е2
                    int sort = Integer.compare(e2.getValue(),
                            e1.getValue());
                    if (sort == 0) {
                        sort = e1.getKey().compareTo(e2.getKey());
                    }
                    return sort;//Връщаме сортриовката
                }).forEach(e -> {//Итерация през елементти е и пронтирай
            //форматиран стринг ключ и стойност
            System.out.println(String.format(
                    "%s: %d", e.getKey(), e.getValue()
            ));
        });
        junk.entrySet().stream()//Вземаме ключ и стойност
                //Сраваняваме
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> {//Итериераме през джънк
                    System.out.println(String.format(
                            "%s: %d", e.getKey(), e.getValue()
                    ));
                });
    }

    private static void countCharsInString(String textInput) throws IOException {

        LinkedHashMap<Character, Integer> countChars =
                new LinkedHashMap<>();

        String text =
                String.join(" ", textInput.split("\\s+"));


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
