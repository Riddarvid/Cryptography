package languages;

public class English extends Language {
    private static Language instance = new English();

    public static Language getInstance() {
        return instance;
    }

    private English() {
        numberOfLetters = 26;
        intToChar.put(0, 'A');
        intToChar.put(1, 'B');
        intToChar.put(2, 'C');
        intToChar.put(3, 'D');
        intToChar.put(4, 'E');
        intToChar.put(5, 'F');
        intToChar.put(6, 'G');
        intToChar.put(7, 'H');
        intToChar.put(8, 'I');
        intToChar.put(9, 'J');
        intToChar.put(10, 'K');
        intToChar.put(11, 'L');
        intToChar.put(12, 'M');
        intToChar.put(13, 'N');
        intToChar.put(14, 'O');
        intToChar.put(15, 'P');
        intToChar.put(16, 'Q');
        intToChar.put(17, 'R');
        intToChar.put(18, 'S');
        intToChar.put(19, 'T');
        intToChar.put(20, 'U');
        intToChar.put(21, 'V');
        intToChar.put(22, 'W');
        intToChar.put(23, 'X');
        intToChar.put(24, 'Y');
        intToChar.put(25, 'Z');
        charToInt.put('A', 0);
        charToInt.put('B', 1);
        charToInt.put('C', 2);
        charToInt.put('D', 3);
        charToInt.put('E', 4);
        charToInt.put('F', 5);
        charToInt.put('G', 6);
        charToInt.put('H', 7);
        charToInt.put('I', 8);
        charToInt.put('J', 9);
        charToInt.put('K', 10);
        charToInt.put('L', 11);
        charToInt.put('M', 12);
        charToInt.put('N', 13);
        charToInt.put('O', 14);
        charToInt.put('P', 15);
        charToInt.put('Q', 16);
        charToInt.put('R', 17);
        charToInt.put('S', 18);
        charToInt.put('T', 19);
        charToInt.put('U', 20);
        charToInt.put('V', 21);
        charToInt.put('W', 22);
        charToInt.put('X', 23);
        charToInt.put('Y', 24);
        charToInt.put('Z', 25);
        frequencies.put('A', 0.08167);
        frequencies.put('B', 0.01492);
        frequencies.put('C', 0.02782);
        frequencies.put('D', 0.04253);
        frequencies.put('E', 0.12702);
        frequencies.put('F', 0.02228);
        frequencies.put('G', 0.02015);
        frequencies.put('H', 0.06094);
        frequencies.put('I', 0.06966);
        frequencies.put('J', 0.00153);
        frequencies.put('K', 0.00772);
        frequencies.put('L', 0.04025);
        frequencies.put('M', 0.02406);
        frequencies.put('N', 0.06749);
        frequencies.put('O', 0.07507);
        frequencies.put('P', 0.01929);
        frequencies.put('Q', 0.00095);
        frequencies.put('R', 0.05987);
        frequencies.put('S', 0.06327);
        frequencies.put('T', 0.09056);
        frequencies.put('U', 0.02758);
        frequencies.put('V', 0.00978);
        frequencies.put('W', 0.02360);
        frequencies.put('X', 0.00150);
        frequencies.put('Y', 0.01974);
        frequencies.put('Z', 0.00074);
    }
}
