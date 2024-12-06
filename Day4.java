import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


// answer: 2591

public class Day4 {
    static String[][] wordSearch;

    public static void main(String[] args){
        ArrayList<String> fileData = getFileData("src/Day4Test");
        wordSearch = new String[fileData.size()][fileData.get(0).length()];

        for (int r = 0; r < wordSearch.length; r++){
            for (int c = 0; c < wordSearch[0].length; c++){
                wordSearch[r][c] = fileData.get(r).substring(c, c + 1);
            }
        }

        System.out.println(partOne());
        System.out.println(partTwo());
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static int partOne(){
        int count = 0;
        for (int r = 0; r < wordSearch.length; r++){
            for (int c = 0; c < wordSearch[0].length; c++){
                if (wordSearch[r][c].equals("X")){
                    if (checkTopLeft(r,c)){
                        count++;
                    }
                    if (checkTop(r, c)){
                        count++;
                    }
                    if (checkTopRight(r, c)){
                        count++;
                    }
                    if (checkLeft(r, c)){
                        count++;
                    }
                    if (checkRight(r, c)){
                        count++;
                    }
                    if (checkBottomLeft(r, c)){
                        count++;
                    }
                    if (checkBottom(r, c)){
                        count++;
                    }
                    if (checkBottomRight(r, c)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int partTwo(){
        int count = 0;
            for (int r = 1; r < wordSearch.length - 1; r++){
                for (int c = 1; c < wordSearch[0].length - 1; c++){
                    if(wordSearch[r][c].equals("A") && mas(r ,c)){
                        count++;
                        System.out.println("COORDINATES: " + r + "," + c);
                    }
                }
            }
        return count;
    }

    // top
    public static boolean checkTopLeft(int x, int y){
        if (x < 3  || y < 3){
            return false;
        }
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += wordSearch[x - i][y - i];
        }
        return str.equals("XMAS");
    }
    public static boolean checkTop(int x, int y){
        if (y < 3){
            return false;
        }
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += wordSearch[x][y - i];
        }
        return str.equals("XMAS");
    }
    public static boolean checkTopRight(int x, int y){
        if (x > wordSearch[0].length - 4 || y < 3){
            return false;
        }
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += wordSearch[x + i][y - i];
        }
        return str.equals("XMAS");
    }

    // middle
    public static boolean checkLeft(int x, int y){
        if (x < 3){
            return false;
        }
        String str = "";
        for (int i = 0; i < 4; i++){
            str += wordSearch[x - i][y];
        }
        return str.equals("XMAS");
    }
    public static boolean checkRight(int x, int y){
        if (x > wordSearch[0].length - 4){
            return false;
        }
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += wordSearch[x + i][y];
        }
        return str.equals("XMAS");
    }



    // bottom
    public static boolean checkBottomLeft(int x, int y){
        if (x < 3 || y > wordSearch.length - 4){
            return false;
        }
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += wordSearch[x - i][y + i];
        }
        return str.equals("XMAS");
    }
    public static boolean checkBottom(int x, int y){
        if (y > wordSearch.length - 4){
            return false;
        }
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += wordSearch[x][y + i];
        }
        return str.equals("XMAS");
    }
    public static boolean checkBottomRight(int x, int y){
        if (x > wordSearch[0].length - 4 || y > wordSearch.length - 4){
            return false;
        }
        String str = "";
        for (int i = 0; i < 4; i++) {
            str += wordSearch[x + i][y + i];
        }
        return str.equals("XMAS");
    }


    // x-mas
    public static boolean mas(int x, int y){
        int count = 0;
        if (wordSearch[x - 1][y - 1].equals("M") && wordSearch[x + 1][y + 1].equals("S")){
            count++;
        }
        if (wordSearch[x + 1][y + 1].equals("M") && wordSearch[x - 1][y - 1].equals("S")){
            count++;
        }

        if (wordSearch[x + 1][y - 1].equals("M") && wordSearch[x - 1][y + 1].equals("S")){
            count++;
        }

        return count == 2;
    }
}