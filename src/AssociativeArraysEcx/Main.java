    package AssociativeArraysEcx;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Comparator;
    import java.util.LinkedHashMap;
    import java.util.Map;


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



        }

        private static void legendaryFarming() throws IOException {
            LinkedHashMap<String, Integer> keyMaterials =
                    new LinkedHashMap<>();
            keyMaterials.put("shards",0);
            keyMaterials.put("fragments",0);
            keyMaterials.put("motes",0);

            LinkedHashMap<String, Integer> junk =
                    new LinkedHashMap<>();

            String winner = "";
            boolean flag = false;

            do {
                String[] data = reader.readLine().split("\\s+");

                for (int i = 0; i < data.length; i += 2) {
                    int quantity = Integer.parseInt(data[i]);
                    String material = data[i + 1].toLowerCase();

                    if (!keyMaterials.containsKey(material)) {
                        if (!junk.containsKey(material)) {
                            junk.put(material, quantity);
                        } else {
                            junk.put(material, junk.get(material) + quantity);
                        }
                    } else {
                        keyMaterials.put(material,
                                keyMaterials.get(material) + quantity);
                        if (keyMaterials.get(material) >= 250) {
                            keyMaterials.put(material,
                                    keyMaterials.get(material) - 250);
                            winner = material;
                            flag = true;
                            break;
                        }
                    }
                }

            } while (!flag);
            if (winner.equals("shards")) {
                System.out.println("Shadowmourne obtained!");
            } else if (winner.equals("motes")) {
                System.out.println("Dragonwrath obtained!");
            } else if (winner.equals("fragments")) {
                System.out.println("Valanyr obtained!");
            }
            keyMaterials
                    .entrySet()
                    .stream()
                    .sorted((e1, e2) -> {
                        int sort = Integer.compare(e2.getValue(),
                                e1.getValue());
                        if (sort == 0) {
                            sort = e1.getKey().compareTo(e2.getKey());
                        }
                        return sort;
                    }).forEach(e -> {
                System.out.println(String.format(
                        "%s: %d", e.getKey(), e.getValue()
                ));
            });
            junk.entrySet().stream()
                    .sorted(Comparator.comparing(Map.Entry::getKey))
                    .forEach(e -> {
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
