package ciphers.monoAlphabetic;

import languages.Language;
import ciphers.*;

import java.util.*;

public class MonoAlphabeticCipher extends MonoCipher {
    public MonoAlphabeticCipher(Language language) {
        super(language);
    }

    @Override
    public Text encrypt(Text plainText, MonoKey key) {
        if (key.getClass() != MonoAlphabeticKey.class) {
            throw new InputMismatchException("Wrong keytype");
        }
        StringBuilder output = new StringBuilder();
        for (Character c : plainText.getContent().toCharArray()) {
            output.append(key.encrypt(c));
        }
        return new Text(language, output.toString());
    }

    @Override
    public PriorityQueue<MonoSolution> decrypt(Text cipherText) {
        //List<Key> keys = generateKeys();
        //char[] plainArr = new char[language.getNumberOfLetters()];
        //char[] cipherArr = new char[language.getNumberOfLetters()];
        //guess(plainArr, cipherArr, cipherText);
        //char[] plainArr = language.getAlphabetArr();
        char[] cipherArr = language.getAlphabetArr();
        return generateSolutions(cipherArr, cipherText);
    }

    private PriorityQueue<MonoSolution> generateSolutions(char[] cipherArr, Text cipherText) {
        MonoKey key = new MonoAlphabeticKey(cipherArr, language);
        MonoSolution bestSolution = decrypt(cipherText, key);
        PriorityQueue<MonoSolution> bestSolutions = new PriorityQueue<>(new SolutionComparatorBest());
        bestSolutions.add(bestSolution);
        while (true) {
            bestSolution = getBetter(bestSolution, cipherArr, cipherText);
            if (bestSolution == null) {
                break;
            }
            if (bestSolution.getError() < 0.5) {
                bestSolutions.add(bestSolution);
            }
        }
        return bestSolutions;
    }

    private MonoSolution getBetter(MonoSolution bestSolution, char[] cipherArr, Text cipherText) {
        double lowestError = bestSolution.getError();
        for (int i = 0; i < cipherArr.length - 1; i++) {
            for (int j = i + 1; j < cipherArr.length; j++) {
                swap(cipherArr, i, j);
                MonoKey key = new MonoAlphabeticKey(cipherArr, language);
                MonoSolution newSolution = decrypt(cipherText, key);
                if (newSolution.getError() < lowestError) {
                    return newSolution;
                }
                swap(cipherArr, i, j);
            }
        }
        return null;
    }

    private void guess(char[] plainArr, char[] cipherArr, Text cipherText) {
        PriorityQueue<Character> plainTextSorted = language.getFrequenciesSorted();
        PriorityQueue<Character> cipherTextSorted = cipherText.getFrequenciesSorted();
        for (int i = 0; i < language.getNumberOfLetters(); i++) {
            plainArr[i] = plainTextSorted.poll();
            cipherArr[i] = cipherTextSorted.poll();
        }
    }

    @Override
    public MonoSolution decrypt(Text cipherText, MonoKey key) {
        if (key.getClass() != MonoAlphabeticKey.class) {
            throw new InputMismatchException("Wrong keytype");
        }
        StringBuilder plainText = new StringBuilder();
        for (Character c : cipherText.getContent().toCharArray()) {
            plainText.append(key.decrypt(c));
        }
        return new MonoSolution(cipherText, new Text(language, plainText.toString()), key, language);
    }

    /*private List<Key> generateKeys() {
        char[] startPermutation = new char[language.getNumberOfLetters()];
        for (int i = 0; i < startPermutation.length; i++) {
            startPermutation[i] = language.intToChar(i);
        }
        List<Key> keys = new ArrayList<>();
        heap(startPermutation.length, startPermutation, keys);
        return keys;
    }*/

    private void heap(int k, char[] permutation, List<MonoKey> keys) {
        if (k == 1) {
            keys.add(new MonoAlphabeticKey(permutation, language));
        } else {
            heap(k - 1, permutation, keys);
            for (int i = 0; i < k - 1; i++) {
                if (k % 2 == 0) {
                    swap(permutation, i, k - 1);
                } else {
                    swap(permutation, 0, k - 1);
                }
                heap(k - 1, permutation, keys);
            }
        }
    }

    private void swap(char[] permutation, int i1, int i2) {
        char temp = permutation[i1];
        permutation[i1] = permutation[i2];
        permutation[i2] = temp;
    }
}
