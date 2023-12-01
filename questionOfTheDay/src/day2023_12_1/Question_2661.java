package day2023_12_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2661. 找出叠涂元素
 */

public class Question_2661 {

    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<Integer, int[]>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map.put(mat[i][j], new int[]{i, j});
                System.out.println(mat[i][j]+"\t"+Arrays.toString(map.get(mat[i][j])));

            }
        }
        System.out.println("===========");


        int[] rowCnt = new int[n];
        int[] colCnt = new int[m];
        for (int i = 0; i < arr.length; ++i) {
            int[] v = map.get(arr[i]);
            System.out.println(Arrays.toString(v));
            ++rowCnt[v[0]];
            if (rowCnt[v[0]] == m) {
                return i;
            }
            ++colCnt[v[1]];
            if (colCnt[v[1]] == n) {
                return i;
            }
        }
        return -1;
    }


    public static int Solution(int[] arr, int[][] mat) {


        HashMap<Integer, Integer> result = new HashMap<>();
        System.out.println(mat.length);
        System.out.println(mat[0].length);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                for (int k = 0; k < mat[0].length; k++) {

                    if (arr[i] == mat[j][k]) {


                        if(result.containsKey((j+1))) {

                            result.put((j+1),result.get((j+1)) + 1);

                        }else {
                            result.put((j+1),1);
                        }
                        if(result.containsKey(-(k+1))) {

                            result.put(-(k+1),result.get(-(k+1)) + 1);


                        }else {
                            result.put(-(k+1),1);

                        }
                        if( result.get((j+1)) == mat[0].length ) {
                            return i;
                        }
                        if(result.get(-(k+1)) == mat.length ) {
                            return i;
                        }

                    }



                }
            }
            System.out.println(result+"\t"+i);

        }
        System.out.println(result);

        return 0;
    }

    public static void main(String[] args) {


        int  [] a = {2,8,7,4,1,3,5,6,9};
        int [][] b = {{3,2,5},{1,4,6},{8,7,9}};

//        System.out.println(Solution(a,b));;
//        [2,8,7,4,1,3,5,6,9]
//        [[3,2,5],[1,4,6],[8,7,9]]

        firstCompleteIndex(a,b);



    }
}
