import java.util.ArrayList;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {

        String string;
        String word;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Entre string for the matrix:");
        string = scanner.nextLine();
        System.out.println("Entre the word to search in the matrix:");
        word = scanner.nextLine();

        char[][] matrix = Matrix.create(string.toUpperCase());
        System.out.println("Matrix:");
        Matrix.print(matrix);

        ArrayList<int[]> chain = MatrixAnalysis.analysis(matrix, word.toUpperCase());
        System.out.println("Result:");
        MatrixAnalysis.print(chain);
    }
}
