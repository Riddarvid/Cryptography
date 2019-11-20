package ciphers;

import languages.Language;

public class MonoSolution {
    private final Text cipherText;
    private final Text plainText;
    private final MonoKey encryptionKey;
    private final MonoKey decryptionKey;
    private final double error;
    private final Language language;

    public MonoSolution(Text cipherText, Text plainText, MonoKey encryptionKey, Language language) {
        this.cipherText = cipherText;
        this.plainText = plainText;
        this.language = language;
        this.encryptionKey = encryptionKey;
        this.decryptionKey = encryptionKey.getComplement();
        error = calculateError();
    }

    private double calculateError() {
        double error = 0;
        for (int i = 0; i < language.getNumberOfLetters(); i++) {
            char c = language.intToChar(i);
            error += Math.abs(language.getFrequency(c) - plainText.getFrequencies().get(c));
        }
        return error;
    }

    public MonoKey getEncryptionKey() {
        return encryptionKey;
    }

    public double getError() {
        return error;
    }

    public Text getPlainText() {
        return plainText;
    }

    @Override
    public String toString() {
        return "Solution: " + plainText.getContent() + "\n\t\t\t\t" + language.getAlphabetString() + "\nEncryption key: " + encryptionKey + "\nDecryption key: " + decryptionKey + "\nError: " + error;
    }
}
