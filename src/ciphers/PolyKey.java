package ciphers;

public interface PolyKey {
    char encrypt(char toEncrypt, int position);
    char decrypt(char toDecrypt, int position);
    PolyKey getComplement();
}
