import ciphers.monoAlphabetic.MonoAlphabeticCipher;
import ciphers.vigenere.VigenereCipher;
import ciphers.vigenere.VigenereKey;
import languages.English;
import languages.Language;
import ciphers.*;
import ciphers.caesar.CaesarCipher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Queue;

public class Cryptography {
    private Language language = English.getInstance();
    private MonoCipher encryptionCipher = new CaesarCipher(language);
    private MonoCipher decryptionCipher = new MonoAlphabeticCipher(language);
    private VigenereCipher polyDecryptionCipher = new VigenereCipher(language);

    public static void main(String[] args) {
        new Cryptography().run();
    }

    private void run() {
        try {
            Text plainText = new Text(language, FileUtilities.format(Files.readString(Path.of("/home/riddarvid/projects/Cryptography/src/input"))));
            String keyText = "CYKABLYAT";
            VigenereKey key = new VigenereKey(keyText.toCharArray(), language);
            Text cipherText = polyDecryptionCipher.encrypt(plainText, key);
            System.out.println(cipherText.getContent());
            List<PolySolution> solutions = polyDecryptionCipher.decrypt(cipherText);
            printSolutions(solutions);
        } catch (IOException e) {
            System.out.println("Input file does not exist");
        }
    }

    private void printSolutions(List<PolySolution> solutions) {
        for (PolySolution s : solutions) {
            System.out.println(s);
            System.out.println();
        }
    }

    private List<PolySolution> decryptPoly(Text encrypted) {
        return polyDecryptionCipher.decrypt(encrypted);
    }

    private PolySolution decryptPoly(Text encrypted, String keyString) {
        VigenereKey key = new VigenereKey(keyString.toCharArray(), language);
        return polyDecryptionCipher.decrypt(encrypted, key);
    }

    private Queue<MonoSolution> decrypt(Text encrypted) {
        return decryptionCipher.decrypt(encrypted);
    }

    private Text encrypt(Text toEncrypt, MonoKey key) {
        return encryptionCipher.encrypt(toEncrypt, key);
    }

    public void printSolutions(Queue<MonoSolution> solutions) {
        while (!solutions.isEmpty()) {
            System.out.println(solutions.poll());
            System.out.println();
        }
    }
}
