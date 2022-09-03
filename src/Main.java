import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(Mixing.mix(" In many languages", " there's a pair of functions"));

    }

    public class Mixing {

        public static String mix(String s1, String s2) {
            String[] one = s1.split("");
            String[] two = s2.split("");

            Map<String, Integer> mapOne = new HashMap<>();
            Map<String, Integer> mapTwo = new HashMap<>();


                for (String s : one) {
                    if (mapOne.containsKey(s)) {
                        mapOne.put(s, mapOne.get(s) + 1);
                    } else {
                        mapOne.put(s, 1);
                    }
                }

            Map<String, Integer> collect = mapOne.entrySet().stream()
                    .filter(a -> a.getValue() > 1)
                    .filter(a -> a.getKey().matches("[a-z]"))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue));

            for (String s : two) {
                if (mapTwo.containsKey(s)) {
                    mapTwo.put(s, mapTwo.get(s) + 1);
                } else {
                    mapTwo.put(s, 1);
                }
            }

            Map<String, Integer> collect1 = mapTwo.entrySet().stream()
                    .filter(a -> a.getValue() > 1)
                    .filter(a -> a.getKey().matches("[a-z]"))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue));

            StringBuilder str = new StringBuilder();

            for(Map.Entry<String, Integer> co : collect.entrySet()) {
                for (Map.Entry<String, Integer> co1 : collect1.entrySet()) {
                    if (co.getKey().equals(co1.getKey())) {
                        if (co.getValue()>co1.getValue()) {
                            str.append("1" + ":").append(String.join("", Collections.nCopies(co.getValue(), co.getKey()))).append("/");
                        } else if (co1.getValue()>co.getValue()) {
                            str.append("2" + ":").append(String.join("", Collections.nCopies(co1.getValue(), co1.getKey()))).append("/");
                        } else {
                            str.append("=" + ":").append(String.join("", Collections.nCopies(co1.getValue(), co1.getKey()))).append("/");

                        }
                    }
                }
            }

            for(Map.Entry<String, Integer> co : collect.entrySet()) {
                if (!collect1.containsKey(co.getKey())) {
                    str.append("1" + ":").append(String.join("", Collections.nCopies(co.getValue(), co.getKey()))).append("/");
                }
            }

            for (Map.Entry<String, Integer> co1 : collect1.entrySet()) {
                if (!collect.containsKey(co1.getKey())) {
                    str.append("2" + ":").append(String.join("", Collections.nCopies(co1.getValue(), co1.getKey()))).append("/");
                }
            }

            String[] a = str.toString().split("/");
            for(int i = 0; i < a.length - 1; ++i) {
                for (int j = i + 1; j < a.length; ++j) {
                    if (a[i].compareTo(a[j]) > 0) {
                        String temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
            Arrays.sort(a, Comparator.comparingInt(String::length).reversed());
            StringBuilder str2 = new StringBuilder();
            String separator = "";

            for (String s : a) {
                str2.append(separator);
                str2.append(s);
                separator = "/";
            }


            return str2.toString();
        }
    }
}