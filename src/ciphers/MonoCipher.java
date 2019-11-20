package ciphers;

import languages.Language;

import java.util.PriorityQueue;

public abstract class MonoCipher {
    protected Language language;

    public MonoCipher(Language language) {
        this.language = language;
    }

    public abstract Text encrypt(Text plainText, MonoKey key);
    public abstract MonoSolution decrypt(Text cipherText, MonoKey key);
    public abstract PriorityQueue<MonoSolution> decrypt(Text cipherText);
}
