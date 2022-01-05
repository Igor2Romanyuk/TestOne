import java.util.ArrayList;

public class MatrixAnalysis {
    private static ArrayList<int[]> chain = new ArrayList<>();
    private static ArrayList<int[]> ignoringChars = new ArrayList<>();

    public static ArrayList<int[]> analysis(char[][] matrix, String word) {
        getIndexCharsInMatrix(matrix, word);
        return chain;
    }

    private static void getIndexCharsInMatrix(char[][] matrix, String word) {
        chain.clear();
        ignoringChars.clear();
        for (int w = 0; w < word.length(); w++) {
            if (w == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        if (matrix[i][j] == word.charAt(w) && !isIgnoring(w, i, j)) {
                            chain.add(new int[]{w, i, j});
                            break;
                        }
                    }
                    if (chain.size() > 0) break;
                }
            } else {
                int backCharIndex = (w - 1);
                int row = chain.get(backCharIndex)[1];
                int column = chain.get(backCharIndex)[2];
                if (row != matrix.length - 1) {
                    if (matrix[row + 1][column] == word.charAt(w) && !isIgnoring(w, row + 1, column)) {
                        chain.add(new int[]{w, row + 1, column});
                        continue;
                    }
                }
                if (row != 0) {
                    if (matrix[row - 1][column] == word.charAt(w) && !isIgnoring(w, row - 1, column)) {
                        chain.add(new int[]{w, row - 1, column});
                        continue;
                    }
                }
                if (column != matrix.length - 1) {
                    if (matrix[row][column + 1] == word.charAt(w) && !isIgnoring(w, row, column + 1)) {
                        chain.add(new int[]{w, row, column + 1});
                        continue;
                    }
                }
                if (column != 0) {
                    if (matrix[row][column - 1] == word.charAt(w) && !isIgnoring(w, row, column - 1)) {
                        chain.add(new int[]{w, row, column - 1});
                        continue;
                    }
                }
                ignoringChars.add(new int[]{w - 1, row, column});
                chain.remove(chain.get(w - 1));
                w -= 2;
            }
        }
    }

    public static void print(ArrayList<int[]> chain) {
        for (int i = 0; i < chain.size(); i++) {
            int[] ints = chain.get(i);
            if (i > 0) {
                System.out.print("->");
            }
            System.out.print(ints[0] + "[" + ints[1] + "," + ints[2] + "]");
        }
    }

    private static boolean isIgnoring(int w, int row, int column) {
        for (int[] ints : ignoringChars) {
            if (ints[0] == w && ints[1] == row && ints[2] == column) {
                return true;
            }
        }
        return false;
    }
}
