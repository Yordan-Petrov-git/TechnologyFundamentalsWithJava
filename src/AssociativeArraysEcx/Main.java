package AssociativeArraysEcx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class maina {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

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
}