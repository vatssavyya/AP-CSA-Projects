import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Board field = new Board();
        while (true) {
          System.out.println(
            """
            1. Print the Board
            2. Resize the board
            3. Enter a word (doesn't override it)
            4. Overwrite Text
            5. Load File
            6. Clear
            7. Exit    
            """);
          System.out.println();
          System.out.print("Enter a number: ");
          int var1 = intIn(1, 7);
          System.out.println();

          switch (var1){
            case 1:
               field.print();
               break; 
            case 2: 
                System.out.print("Enter row size: ");
                int row = intIn(1, 100);
                System.out.println();
                System.out.print("Enter column size: ");
                int col = intIn(1, 100);
                field.update(row,col);
                System.out.println("updated");
                break;
            case 3:
                System.out.print("Enter the word: ");
                String word = sIn();
                System.out.print("Which row: ");
                int row1 = intIn(0, field.getRow()-1);
                System.out.println();
                System.out.print("Which column: ");
                int col1 = intIn(0, field.getCol()-1);
                System.out.print("Horizontal? (true/false) ");
                boolean hori = scanner.nextBoolean();
                System.out.println();
                System.out.print("Reverse? (true/false) ");
                boolean rev = scanner.nextBoolean();
                field.loadWord(word, row1, col1, hori, rev);
                break;
            case 4:
                System.out.print("Enter the word: ");
                String word1 = sIn();
                System.out.print("Which row: ");
                int row2 = intIn(0, field.getRow()-1);
                System.out.println();
                System.out.print("Which column: ");
                int col2 = intIn(0, field.getCol()-1);
                System.out.print("Horizontal? (true/false) ");
                boolean hori1 = scanner.nextBoolean();
                System.out.println();
                System.out.print("Reverse? (true/false) ");
                boolean rev1 = scanner.nextBoolean();
                field.write(word1, row2, col2, hori1, rev1);
                break;
            case 5:
                System.out.println("enter file name: ");
                String filename = sIn();
                field.loadFile(filename);
                System.out.println("file cmds executed");
                break;
            case 6:
                field.reset();
                System.out.println("Board is reset now ");
                break;
            case 7:
                System.out.flush();
                System.out.println("exited");
                System.exit(0);
          }

        }
	}
	
	private static int intIn(int low, int high)
    {
        boolean cont = true;
        Scanner keyboard = new Scanner(System.in);
        String input;
        boolean invalid = true;
        int choice=0;
        while (cont)        
        {
            try
            {
                input = keyboard.nextLine ();
	            choice = Integer.parseInt (input);
	            if (choice<low || choice>high)
	                System.out.println("Please select a number between " + low + " and " + high);
	            else
	                cont = false;
            }
        	catch (Exception e)
        	{
	            System.out.println ("Please enter a number");
        	}
        }
        return choice;
    }
  
    private static String sIn()
    {
        boolean cont = true;
        Scanner keyboard = new Scanner (System.in);
        String input="";
        boolean invalid = true;
        while (cont)        
        {
            try
            {
                input = keyboard.nextLine ();
	            cont = false;
            }
        	catch (Exception e)
        	{
	            System.out.println ("Invalid input");
        	}
        }
        return input;
    }
}
