public class test {
    public static void main(String[] args) {
        String word = "Neighboring";
        char char1 = 'g';
        System.out.println(thingy(word, char1));
    }
    public static int thingy(String word, char char1) {
        int i;
        int index1 = -1;
        for (i = (word.length()-1); i > 0; i++) {
            if (word.charAt(i) == char1) {
                index1 = i;
                break;
            }
        }
        return index1;
    }
}
