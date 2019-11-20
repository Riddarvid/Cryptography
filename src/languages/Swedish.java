package languages;

public class Swedish extends Language {
    private static Language instance = new Swedish();

    private Swedish() {
        numberOfLetters = 29;
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
        intToChar.put(26, 'Å');
        intToChar.put(27, 'Ä');
        intToChar.put(28, 'Ö');
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
        charToInt.put('Å', 26);
        charToInt.put('Ä', 27);
        charToInt.put('Ö', 28);
        frequencies.put('A', 0.09383);
        frequencies.put('B', 0.01535);
        frequencies.put('C', 0.01486);
        frequencies.put('D', 0.04702);
        frequencies.put('E', 0.10149);
        frequencies.put('F', 0.02027);
        frequencies.put('G', 0.02862);
        frequencies.put('H', 0.02090);
        frequencies.put('I', 0.05817);
        frequencies.put('J', 0.00614);
        frequencies.put('K', 0.03140);
        frequencies.put('L', 0.05275);
        frequencies.put('M', 0.03471);
        frequencies.put('N', 0.08542);
        frequencies.put('O', 0.04482);
        frequencies.put('P', 0.01839);
        frequencies.put('Q', 0.00020);
        frequencies.put('R', 0.08431);
        frequencies.put('S', 0.06590);
        frequencies.put('T', 0.07691);
        frequencies.put('U', 0.01919);
        frequencies.put('V', 0.02415);
        frequencies.put('W', 0.00142);
        frequencies.put('X', 0.00159);
        frequencies.put('Y', 0.00708);
        frequencies.put('Z', 0.00070);
        frequencies.put('Å', 0.01338);
        frequencies.put('Ä', 0.01797);
        frequencies.put('Ö', 0.01305);
    }

    public static Language getInstance() {
        return instance;
    }


}
