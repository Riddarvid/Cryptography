package ciphers.monoAlphabetic;

import ciphers.MonoKey;
import languages.Language;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class MonoAlphabeticKey implements MonoKey {
    private final Language language;
    private final Map<Character, Character> encryptMap;
    private final Map<Character, Character> decryptMap;

    public MonoAlphabeticKey(char[] cipherArr, Language language) {
        encryptMap = new HashMap<>();
        decryptMap = new HashMap<>();
        this.language = language;
        if (cipherArr.length != language.getNumberOfLetters()) {
            throw new InputMismatchException("Plain text and cipher text should contain all the letters in the language");
        }
        for (int i = 0; i < language.getNumberOfLetters(); i++) {
            encryptMap.put(language.intToChar(i), cipherArr[i]);
            decryptMap.put(cipherArr[i], language.intToChar(i));
        }
    }

    public MonoAlphabeticKey(char[] plainArr, char[] cipherArr, Language language) {
        encryptMap = new HashMap<>();
        decryptMap = new HashMap<>();
        this.language = language;
        if (plainArr.length != language.getNumberOfLetters() || cipherArr.length != language.getNumberOfLetters()) {
            throw new InputMismatchException("Plain text and cipher text should contain all the letters in the language");
        }
        for (int i = 0; i < language.getNumberOfLetters(); i++) {
            encryptMap.put(plainArr[i], cipherArr[i]);
            decryptMap.put(cipherArr[i], plainArr[i]);
        }
    }

    private MonoAlphabeticKey(Map<Character, Character> encryptMap, Map<Character, Character> decryptMap, Language language) {
        this.encryptMap = Map.copyOf(encryptMap);
        this.decryptMap = Map.copyOf(decryptMap);
        this.language = language;
    }

    @Override
    public char encrypt(char toEncrypt) {
        return encryptMap.get(toEncrypt);
    }

    @Override
    public char decrypt(char toDecrypt) {
        return decryptMap.get(toDecrypt);
    }

    @Override
    public MonoKey getComplement() {
        return new MonoAlphabeticKey(decryptMap, encryptMap, language);
    }

    @Override
    public String toString() {
        StringBuilder plainText = new StringBuilder();
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < language.getNumberOfLetters(); i++) {
            plainText.append(language.intToChar(i));
            cipherText.append(encrypt(language.intToChar(i)));
        }
        return cipherText.toString();
    }
}
