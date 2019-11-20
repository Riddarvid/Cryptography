package ciphers.vigenere;

import ciphers.PolySolution;
import ciphers.Text;
import ciphers.caesar.CaesarCipher;
import ciphers.caesar.CaesarKey;
import languages.Language;

import java.util.ArrayList;
import java.util.List;

public class VigenereCipher {
    private Language language;

    public VigenereCipher(Language language) {
        this.language = language;
    }

    public Text encrypt(Text plainText, VigenereKey key) {
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            cipherText.append(key.encrypt(plainText.getContent().charAt(i), i));
        }
        return new Text(language, cipherText.toString());
    }

    public PolySolution decrypt(Text cipherText, VigenereKey key) {
        StringBuilder plainText = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            plainText.append(key.decrypt(cipherText.getContent().charAt(i), i));
        }
        return new PolySolution(cipherText, new Text(language, plainText.toString()), key, language);
    }

    public PolySolution decrypt(Text cipherText, int keyLength) {
        CaesarKey[] keys = new CaesarKey[keyLength];
        CaesarCipher caesarCipher = new CaesarCipher(language);
        for (int i = 0; i < keyLength; i++) {
            Text substring = getDivisible(cipherText, i, keyLength);
            keys[i] = (CaesarKey)caesarCipher.getKey(substring);
        }
        return decrypt(cipherText, new VigenereKey(keys, language));
    }

    private Text getDivisible(Text text, int divisor, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = divisor; i < text.length(); i += length) {
            sb.append(text.getContent().charAt(i));
        }
        return new Text(language, sb.toString());
    }

    public List<PolySolution> decrypt(Text cipherText) {
        List<PolySolution> solutions = new ArrayList<>();
        for (int keyLength = 1; keyLength < 20; keyLength++) {
            solutions.add(decrypt(cipherText, keyLength));
        }
        return solutions;
    }
}
