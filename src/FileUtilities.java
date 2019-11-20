public class FileUtilities {
    static String format(String input) {
        StringBuilder sb = new StringBuilder();
        for (Character c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(c);
            }
        }
        return sb.toString().toUpperCase();
    }
}
