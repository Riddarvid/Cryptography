package ciphers;

import languages.FrequencyComparator;
import languages.Language;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Text {
    private String content;
    private Map<Character, Double> frequencies = new HashMap<>();

    public Text(Language language, String content) {
        this.content = content;
        for (int i = 0; i < language.getNumberOfLetters(); i++) {
            char c = language.intToChar(i);
            double frequency = (double)getCount(c) / (double)content.length();
            frequencies.put(c, frequency);
        }
    }

    public PriorityQueue<Character> getFrequenciesSorted() {
        PriorityQueue<Character> pq = new PriorityQueue<>(new FrequencyComparator(frequencies));
        pq.addAll(frequencies.keySet());
        return pq;
    }

    private int getCount(char c) {
        int count = 0;
        for (char test : content.toCharArray()) {
            if (test == c) {
                count++;
            }
        }
        return count;
    }

    public String getContent() {
        return content;
    }

    public Map<Character, Double> getFrequencies() {
        return frequencies;
    }

    public int length() {
        return content.length();
    }

    @Override
    public String toString() {
        return content;
    }
}
