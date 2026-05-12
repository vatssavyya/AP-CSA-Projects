public class Methods {
    public Methods() {
    }
    //should be unreadable, this ciphers into it
    public String convert(String nums) {
        String jumbled = "";
        String[] arrayThing = nums.split(" ");
        for (int i = 0; i < arrayThing.length; i++) {
            jumbled += (char)(Integer.parseInt(arrayThing[i]));
        }
        return jumbled;
    }
    //do 2 * mod 257 cuz it guarentees a return to 1
    public String decode(String encString) {
        return "";
    }
}