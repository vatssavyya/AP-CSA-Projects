import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Board extends Field {
    @Override
    public void update(int row, int column) {
        //make this retain words
        boolean[][] inUseOld = inUse;
        char[][] frameOld = frame;
        frame = new char[row][column];
        inUse = new boolean[row][column];
        propagate();

        for (int i = 0; i < inUseOld.length; i++) {
            if (i > (row - 1)){
                break;
            }
            for (int j = 0; ((j < inUseOld[i].length)); j++) {
                if (j > (column - 1)) {
                    break;
                }
                frame[i][j] = frameOld[i][j];
                inUse[i][j] = inUseOld[i][j];
            }
        }
    }

    public int getRow() {
        return frame.length;
    }

    public int getCol() {
        return frame[0].length;
    }
    
    public void reset() {
        propagate();
    }

    //no overwriting allowed
    public void loadWord(String word, int r, int c, boolean horizontal, boolean reverse) {
        if (reverse) {
            int var1 = word.length();
            for (int i = word.length()-1; i >= 0; i--) {
                word += word.charAt(i);
            }
        word = word.substring(var1);
        }

        if (horizontal) {
            int i = c;
            int counter = 0;
            while ((i < frame[0].length) && (counter < word.length())) {
                if (!inUse[r][i]) {
                    frame[r][i] = word.charAt(counter);
                    inUse[r][i] = true;
                }
                i++;
                counter++;
            }
        }

        else {
            int i = r;
            int counter = 0;
            while ((i < frame.length) && (counter < word.length())) {
                if (!inUse[i][c]) {
                    frame[i][c] = word.charAt(counter);
                    inUse[i][c] = true;
                }
                i++; 
                counter++;
            }
        }
    }

    //this one is allowed to overwrite
    public void write(String word, int r, int c, boolean horizontal, boolean reverse) {
        if (reverse) {
            int var1 = word.length();
            for (int i = word.length()-1; i >= 0; i--) {
                word += word.charAt(i);
            }
        word = word.substring(var1);
        }
        if (horizontal) {
            int i = c;
            int counter = 0;
            while ((i < frame[0].length) && (counter < word.length())) {
                frame[r][i] = word.charAt(counter);
                inUse[r][i] = true;
                i++;
                counter++;
            }
        }

        else {
            int i = r;
            int counter = 0;
            while ((i < frame.length) && (counter < word.length())) {
                frame[i][c] = word.charAt(counter);
                inUse[i][c] = true;
                i++; 
                counter++;
            }
        }
    }

    public void loadFile(String name) throws FileNotFoundException {
        File file = new File(name);
        Scanner troughton = new Scanner(file);

        while (troughton.hasNextLine()) {
            String[] array1 = troughton.nextLine().split(", ");
            String word = array1[0].substring(1, array1[0].length() - 1);
            int row = Integer.parseInt(array1[1]);
            int col = Integer.parseInt(array1[2]);
            boolean hor = true;
            if (array1[3].equals("V")) {
                hor = false;
            }
            if (hor) {
                if ((word.length()) > ((frame[0].length) - (col))) {
                    frame = new char[getRow()][word.length()+col];
                    inUse = new boolean[getRow()][word.length()+col];
                }
            }
            else {
                if (word.length() > (frame.length - row)) {
                    frame = new char[word.length()+row][getCol()];
                    inUse = new boolean[word.length()+row][getCol()];
                }
            }
            propagate();
        }
        Scanner troughton1 = new Scanner(file);
        while (troughton1.hasNextLine()) {
            String[] array1 = troughton1.nextLine().split(", ");
            String word = array1[0].substring(1, array1[0].length() - 1);
            int row = Integer.parseInt(array1[1]);
            int col = Integer.parseInt(array1[2]);
            boolean hor = true;
            if (array1[3].equals("V")) {
                hor = false;
            }
            write(word, row, col, hor, false);
       }
    }
}
