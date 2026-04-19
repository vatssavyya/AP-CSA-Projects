public class MainPalinFile {
    public static void main(String[] args) {
        System.out.println (Checker.palindrome("A man a pla41275019284572187345831274581237598712395871329857123985732189  721093587123578032857 1235 ?>[][][][][][][][][][][][][]?>?>?>n a canal Panama")*100+"%");
        System.out.println (Checker.palindrome("Window")*100+"%");
        System.out.println (Checker.palindrome("Topsp0!ot")*100+"%");
        
        String str1 = "aa";
        String str2 = "ab";
        System.out.print (str1+ " is ");
        if (!Checker.anagram(str1,str2))
            System.out.print ("NOT ");
        System.out.println("an anagram of " + str2);
    }
}
