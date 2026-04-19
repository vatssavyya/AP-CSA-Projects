
public class Test {
    public static void main(String[] args) {
        String[][] issac = new String[3][3]; // {{"h", "i"}, {"iss", "ac"}, {"bom", "bo"}}
        //System.out.println(issac[2][1]);
        issac[2][1] = "nigesh";
        //System.out.println(issac[2][1]);
        for (int i = 0; i < issac.length; i++) {
            for (int j = 0; j < issac[i].length; j++) { 
                System.out.println(issac[i][j]);
        }
        System.out.println();
        }
        }

    }

