import java.util.Arrays;

public class studentID {
    public static void main(String[] args) {
        studentIdTranslator stu1 = new studentIdTranslator('A', 'A', true, 3);
        studentIdTranslator stu2 = new studentIdTranslator('B', 'B', true, 0);
        studentIdTranslator stu3 = new studentIdTranslator(7644);
        int comp = stu1.compareTo(stu2);
        if (comp==1) {
            System.out.println ("dude1's older");
        }    
        else if (comp==0) {
            System.out.println ("dudes are the same");
        }    
        else {
            System.out.println ("nah");
        }    
        // Declare an array of 20 StudentIDs
        studentIdTranslator[] array = new studentIdTranslator[20];
        for (int i = 0; i<array.length; i++)
        {
            array[i]=new studentIdTranslator((int)(Math.random()*8192));  //generate random IDs
        }
       
        Arrays.sort(array);  // sorts array by whatever is specified in compareTo

        // Print out the sorted array
        for(int i = 0; i<array.length;i++)
        {
            array[i].print();
        }
    }
}

class studentIdTranslator implements Comparable<studentIdTranslator> {
    private int ID;
    private int grade;
    private char firstN;
    private char lastN;
    private boolean isMale;
    private String IDString;
    private String gradeName;
    private String gender;

    public studentIdTranslator(int ID) {
        //constructor thing
        this.ID = ID;
        this.IDString = dectobinaryThing(ID);
        
        // first letter
        String firstLetterNums = IDString.substring(2, 7);
        int numVal = 0;
        for (int i = 0; i < firstLetterNums.length(); i++) {
            if (firstLetterNums.charAt(i) == '1') {
                numVal += Math.pow(2, 4 - i);
            }
        }
        char firstLetter = (char)(numVal + 64);
        if ((numVal + 64) > 90) {
            firstLetter = 'Z';
        }
        if (numVal == 0) {
            firstLetter = 'A';
        }
        this.firstN = firstLetter;

        //last letter
        String lastLetterNums = IDString.substring(7, 12);
        int numVal1 = 0;
        for (int j = 0; j < lastLetterNums.length(); j++) {
            if (lastLetterNums.charAt(j) == '1') {
                numVal1 += Math.pow(2, 4 - j);
            }
        }
        char lastLetter = (char)(numVal1 + 64);
        if ((numVal1 + 64) > 90) {
            lastLetter = 'Z';
        }
        if (numVal1 == 0) {
            lastLetter = 'A';
        }
        this.lastN = lastLetter;

        //grade thing
        String gradeThing = IDString.substring(0, 2);
        // set up the conversion for the extra credit thing later
        int gradeVal = 0;
        for (int i = 0; i < gradeThing.length(); i++) {
            if (gradeThing.charAt(i) == '1') {
                gradeVal += Math.pow(2, 1 - i);
            }
        }

        if (gradeVal == 0) {
            this.gradeName = "Freshman";
        } else if (gradeVal == 1) {
            this.gradeName = "Sophomore";
        } else if (gradeVal == 2) {
            this.gradeName = "Junior";
        } else {
            this.gradeName = "Senior";
        }
        this.grade = gradeVal;

        // gender thing
        boolean var1 = (this.ID % 2 == 0);
        if (var1) {
            this.gender = "Male";
        }
        else {
            this.gender = "Female";
        }
        this.isMale = var1;
        //System.out.println(IDString);
        print();
    }

    public studentIdTranslator(char firstN, char lastN, boolean isMale, int grade) {
        //second constructor thing
        //System.out.println("hi");
        this.firstN = firstN;
        this.lastN = lastN;
        this.isMale = isMale;
        this.grade = grade;
        String genderBit;
        String gradeBit;

        //gender
        if (this.isMale) {
            this.gender = "Male";
            genderBit = "0";
        }
        else {
            this.gender = "Female";
            genderBit = "1";
        }

        //grade 
        if (this.grade == 0) {
            this.gradeName = "Freshman";
            gradeBit = "00";
        } else if (this.grade == 1) {
            this.gradeName = "Sophomore";
            gradeBit = "01";
        } else if (this.grade == 2) {
            this.gradeName = "Junior";
            gradeBit = "10";
        } else {
            this.gradeName = "Senior";
            gradeBit = "11";
        }
        //first letter thing
        String var1 = "";
        int temp1 = ((int)(this.firstN)) - 64;
        while (temp1 > 0) {
            int rem = temp1 % 2;
            var1 = rem + var1;
            temp1 = temp1 / 2;
        }

        while (var1.length() < 5) {
            var1 = "0" + var1;
        }
        
        //last letter thing
        String var2 = "";
        int temp2 = ((int)(this.lastN)) - 64;
        while (temp2 > 0) {
            int rem1 = temp2 % 2;
            var2 = rem1 + var2;
            temp2 = temp2 / 2;
        }

        while (var2.length() < 5) {
            var2 = "0" + var2;
        }
        //adding it rn
        this.IDString = gradeBit + var1 + var2 + genderBit;

        //System.out.println(this.IDString);

        String temp3 = IDString;
        // set up the conversion for the extra credit thing later
        int num4 = 0;
        for (int i = 0; i < temp3.length(); i++) {
            if (temp3.charAt(i) == '1') {
                num4 += Math.pow(2, temp3.length() - 1 - i);
            }
        }
        this.ID = num4;
        print();
    }

    @Override
    public int compareTo(studentIdTranslator studentidthing) {
        if (this.grade > studentidthing.grade) {
            return -1;
        }
        else if (this.grade < studentidthing.grade) {
            return 1;
        }
        else {
            return 0;
        }
    }
    public String dectobinaryThing(int ID) {
        String var1 = "";
        if (ID == 0) {
            while (var1.length() < 13) {
                var1 = "0" + var1;
              }
        }
        else {
            // use 21 as an example or smth, it should be 10101
          while (ID > 0) {
            int rem = ID % 2;
            var1 = rem + var1;
            ID = ID / 2;
          }

          while (var1.length() < 13) {
            var1 = "0" + var1;
          }
        }
        return var1;
    }
    
    public char getFirstN() {
        return this.firstN;
    }

    public char getLastN() {
        return this.lastN;
    }

    public boolean getIsMale() {
        return this.isMale;
    }

    public int getGrade() {
        return this.grade;
        
    }

    public int getID() {
        return this.ID;
    }

    public void print() {
        System.out.println("This person is a " + this.gradeName + " " + this.gender + " with the initials " + this.firstN + " and " + this.lastN + " and the student ID " + this.ID);
    }

}
