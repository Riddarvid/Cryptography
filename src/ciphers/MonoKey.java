package ciphers;

public interface MonoKey {
    char encrypt(char toEncrypt);
    char decrypt(char toDecrypt);
    MonoKey getComplement();
}
