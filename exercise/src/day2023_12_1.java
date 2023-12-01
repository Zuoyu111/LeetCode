public class day2023_12_1 {

    public static void setZeroes(int[][] matrix) {

        // [ [1,3],[3,4]]
        boolean [] col = new boolean[matrix.length];
        boolean [] row = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    col[i] = true;
                    row[j] = true;
                }
            }
        }

        for (int i = 0; i < col.length; i++) {
            for (int j = 0; j < row.length; j++) {
                if(row[i] || row[j]) {
                   matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
