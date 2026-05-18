public class Main {
    public static void main(String[] args) {
        String var1 = Methods.convert("4 43 103 168 51 227 219 231 128 247 187 239 168 115 179 203 187 223 179 187");
        Methods.showPasses(var1);
        System.out.println(Methods.decode(var1));

        String var2 = Methods.convert("255 5 185 21 35 9 17 15 21");
        Methods.showPasses(var2);
        System.out.println(Methods.decode(var2));
    }
}