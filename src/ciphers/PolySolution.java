package ciphers;

import languages.Language;

public class PolySolution {
    private final Text cipherText;
    private final Text plainText;
    private final PolyKey encryptionKey;
    private final PolyKey decryptionKey;
    private final double error;
    private final Language language;

    public PolySolution(Text cipherText, Text plainText, PolyKey encryptionKey, Language language) {
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

    public PolyKey getEncryptionKey() {
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
        return "Solution: " + plainText.getContent() + "\nEncryption key: " + encryptionKey + "\nDecryption key: " + decryptionKey + "\nError: " + error;
    }
}
