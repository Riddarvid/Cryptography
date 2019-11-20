package ciphers;

import java.util.*;

public class AnalysisUtils {
    public static PriorityQueue<Cluster> findClusters(int length, String text) {
        List<Cluster> clusters = new ArrayList<>();
        for (int i = 0; i < text.length() - length; i++) {
            Cluster cluster = new Cluster(text.substring(i, i + length));
            if (!clusters.contains(cluster)) {
                clusters.add(cluster);
                cluster.incCount();
            } else {
                clusters.get(clusters.indexOf(cluster)).incCount();
            }
        }
        return new PriorityQueue<>(clusters);
    }

    public static PriorityQueue<Cluster> findClusters(int length, Text text) {
        return findClusters(length, text.getContent());
    }

    public static PriorityQueue<Cluster> findRepeats(int length, Text text) {
        return findRepeats(length, text.getContent());
    }

    public static PriorityQueue<Cluster> findRepeats(int length, String text) {
        List<Cluster> clusters = new ArrayList<>();
        for (int i = 0; i < text.length() - length; i++) {
            char c = text.charAt(i);
            int j = 0;
            for (; j < length - 1; j++) {
                if (text.charAt(i + j) != c) {
                    break;
                }
            }
            if (text.charAt(i + j) == c) {
                Cluster cluster = new Cluster(text.substring(i, i + length));
                if (clusters.contains(cluster)) {
                    clusters.get(clusters.indexOf(cluster)).incCount();
                } else {
                    clusters.add(cluster);
                    cluster.incCount();
                }
            }
        }
        return new PriorityQueue<>(clusters);
    }

    public static String partiallyTranslate(Text cipherText) {
        return partiallyTranslate(cipherText.getContent());
    }

    public static String partiallyTranslate(String cipherText) {
        Map<Character, Character> decryptMap = new HashMap<>();
        decryptMap.put('J', 't');
        decryptMap.put('D', 'h');
        decryptMap.put('S', 'e');
        decryptMap.put('Q', 'a');
        decryptMap.put('U', 's');
        decryptMap.put('N', 'r');
        decryptMap.put('Z', 'c');
        decryptMap.put('C', 'i');
        decryptMap.put('Y', 'p');
        decryptMap.put('X', 'f');
        decryptMap.put('V', 'l');
        decryptMap.put('G', 'n');
        decryptMap.put('K', 'w');
        decryptMap.put('B', 'o');
        decryptMap.put('T', 'm');
        decryptMap.put('F', 'k');
        decryptMap.put('L', 'y');
        decryptMap.put('E', 'g');
        decryptMap.put('W', 'd');
        decryptMap.put('H', 'q');
        decryptMap.put('M', 'u');
        decryptMap.put('A', 'b');
        decryptMap.put('O', 'x');
        decryptMap.put('R', 'j');
        decryptMap.put('I', 'v');
        decryptMap.put('P', 'z');
        StringBuilder plainText = new StringBuilder();
        for (char c : cipherText.toCharArray()) {
            if (decryptMap.containsKey(c)) {
                plainText.append(decryptMap.get(c));
            } else {
                plainText.append(c);
            }
        }
        return plainText.toString();
    }
}
