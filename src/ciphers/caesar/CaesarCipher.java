package ciphers.caesar;

import languages.Language;
import ciphers.*;

import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class CaesarCipher extends MonoCipher {

    public CaesarCipher(Language language) {
        super(language);
    }

    public Text encrypt(Text plainText, MonoKey key) {
        if (key.getClass() != CaesarKey.class) {
            throw new InputMismatchException("Wrong keytype");
        }
        StringBuilder output = new StringBuilder();
        for (Character c : plainText.getContent().toCharArray()) {
            output.append(key.encrypt(c));
        }
        return new Text(language, output.toString());
    }

    public PriorityQueue<MonoSolution> decrypt(Text cipherText) {
        PriorityQueue<MonoSolution> solutions = new PriorityQueue<>(new SolutionComparatorBest());
        for (int i = 0; i < language.getNumberOfLetters(); i++) {
            CaesarKey key = new CaesarKey(i, language);
            MonoSolution decrypted = decrypt(cipherText, key);
            solutions.add(decrypted);
        }
        return solutions;
    }

    public MonoSolution decrypt(Text cipherText, MonoKey key) {
        if (key.getClass() != CaesarKey.class) {
            throw new InputMismatchException("Wrong keytype");
        }
        StringBuilder plainText = new StringBuilder();
        for (Character c : cipherText.getContent().toCharArray()) {
            plainText.append(key.decrypt(c));
        }
        return new MonoSolution(cipherText, new Text(language, plainText.toString()), key, language);
    }

    public MonoKey getKey(Text cipherText) {
        MonoSolution bestSolution = decrypt(cipherText, new CaesarKey('A', language));
        for (int i = 0; i < language.getNumberOfLetters(); i++) {
            CaesarKey key = new CaesarKey(i, language);
            MonoSolution decrypted = decrypt(cipherText, key);
            if (decrypted.getError() < bestSolution.getError()) {
                bestSolution = decrypted;
            }
        }
        return bestSolution.getEncryptionKey();
    }
}
