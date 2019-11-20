package languages;

import java.util.*;

public abstract class Language {
    Map<Integer, Character> intToChar = new HashMap<>();
    Map<Character, Integer> charToInt = new HashMap<>();
    Map<Character, Double> frequencies = new HashMap<>();

    protected int numberOfLetters;

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public double getFrequency(char c) {
        return frequencies.get(c);
    }

    public PriorityQueue<Character> getFrequenciesSorted() {
        PriorityQueue<Character> pq = new PriorityQueue<>(new FrequencyComparator(frequencies));
        pq.addAll(frequencies.keySet());
        return pq;
    }

    public char intToChar(int n) {
        n += numberOfLetters;
        n %= numberOfLetters;
        return intToChar.get(n);
    }

    public int charToInt(char c) {
        if (charToInt.get(c) == null) {
            throw new InputMismatchException("This language does not contain the letter " + c);
        }
        return charToInt.get(c);
    }

    public char[] getAlphabetArr() {
        char[] alphabet = new char[numberOfLetters];
        for (int i = 0; i < numberOfLetters; i++) {
            alphabet[i] = intToChar(i);
        }
        return alphabet;
    }

    public String getAlphabetString() {
        StringBuilder sb = new StringBuilder();
        for (char c : getAlphabetArr()) {
            sb.append(c);
        }
        return sb.toString();
    }
}
