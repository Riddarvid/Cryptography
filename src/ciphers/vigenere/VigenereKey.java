package ciphers.vigenere;


import ciphers.PolyKey;
import ciphers.caesar.CaesarKey;
import languages.Language;

public class VigenereKey implements PolyKey {
    private int length;
    private CaesarKey[] keys;
    private Language language;

    public VigenereKey(char[] keyword, Language language) {
        this.language = language;
        this.length = keyword.length;
        keys = new CaesarKey[keyword.length];
        for (int i = 0; i < keyword.length; i++) {
            keys[i] = new CaesarKey(keyword[i], language);
        }
    }

    public VigenereKey(CaesarKey[] keys, Language language) {
        this.language = language;
        this.length = keys.length;
        this.keys = keys;
    }

    public char encrypt(char toEncrypt, int position) {
        return keys[position % length].encrypt(toEncrypt);
    }

    public char decrypt(char toDecrypt, int position) {
        return keys[position % length].decrypt(toDecrypt);
    }

    @Override
    public PolyKey getComplement() {
        CaesarKey[] complements = new CaesarKey[keys.length];
        for (int i = 0; i < keys.length; i++) {
            complements[i] = (CaesarKey)keys[i].getComplement();
        }
        return new VigenereKey(complements, language);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.length; i++) {
            sb.append(language.intToChar(keys[i].getKey()));
        }
        return sb.toString();
    }
}
