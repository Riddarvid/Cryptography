package ciphers.caesar;

import languages.Language;
import ciphers.MonoKey;

public class CaesarKey implements MonoKey {
    private final int shift;
    private final Language language;

    public CaesarKey(int shift, Language language) {
        this.language = language;
        this.shift = shift;
    }

    public CaesarKey(char shift, Language language) {
        this.language = language;
        this.shift = language.charToInt(shift);
    }

    @Override
    public char encrypt(char toEncrypt) {
        int charValue = language.charToInt(toEncrypt);
        charValue += shift;
        charValue %= language.getNumberOfLetters();
        return language.intToChar(charValue);
    }

    @Override
    public char decrypt(char toDecrypt) {
        int charValue = language.charToInt(toDecrypt);
        charValue -= shift;
        charValue += language.getNumberOfLetters();
        charValue %= language.getNumberOfLetters();
        return language.intToChar(charValue);
    }

    @Override
    public MonoKey getComplement() {
        return new CaesarKey(language.getNumberOfLetters() - shift, language);
    }

    @Override
    public String toString() {
        return Character.toString(language.intToChar(shift));
    }

    public int getKey() {
        return shift;
    }
}
