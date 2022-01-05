public class Matrix {
    public static char[][] create(String string) {
        int arraySize = (int) Math.sqrt(string.length());
        char[][] result = new char[arraySize][arraySize];
        int index = 0;
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                result[i][j] = string.charAt(index);
                index++;
            }
        }
        return result;
    }

    public static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
