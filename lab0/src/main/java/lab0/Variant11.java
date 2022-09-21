package lab0;

public class Variant11 {

    /*Integer11. A three-digit number is given.
     Find the sum and the product of its digits.*/

    public static int intTaskSum(int a) {
        assert Math.abs(a / 100) > 1 : "Error";
        return ((a / 100) + ((a % 100) / 10) + (a % 10));
    }

    public static int intTaskProd(int a) {
        assert Math.abs(a / 100) > 1 : "Error";
        return (a / 100) * ((a % 100) / 10) * (a % 10);
    }


    /* Boolean11. Two integers are given: A, B.
     Check the truth of the statement: "The numbers A and B have the same parity."*/

    public static boolean booleanTask(int a, int b) {
        return a == b;
    }


    /* If11. Given two variables of integer type: A and B. If their values are not equal,
    then assign the greatest of these values to each variable, and if they are equal,
    then assign zero values to the variables. Print the new values of variables A and B.*/

    public static int[] ifTask(int a, int b) {
        if (a == b) {
            a = 0;
            b = 0;
        } else if (a > b) {
            b = a;
        } else if (a < b) {
            a = b;
        }
        int[] res = {a, b};
        return res;
    }


    /* Case11. The locator is oriented to one of the cardinal directions ("N" - north, "W" - west, "S" - south,
     "E" - east) and can receive three digital rotation commands: 1 - turn left, -1 - turn right ,
     2 - turn by 180°. The symbol S is given — the initial orientation of the locator and the integers
     N1 and N2 — two sent commands. Output the orientation of the locator after executing these commands.*/

    public enum CARDINAL_DIRECTIONS{
        NORTH, WEST, SOUTH, EAST;
    }

    public static CARDINAL_DIRECTIONS caseTask(CARDINAL_DIRECTIONS S, int n1, int n2) { //переробити
        assert n1 == -1 || n1 == 2 || n1 == 0  :
                "Error";
        assert n2 == -1 || n2 == 2 || n2 == 0 :
                "Error";
        switch (S) {
            case NORTH:
                return checkNorth(n1, n2);
            case WEST:
                return checkWest(n1, n2);
            case SOUTH:
                return checkSouth(n1, n2);
            case EAST:
                return checkEast(n1, n2);
            default:
                throw new IllegalArgumentException("");
        }
    }

    private static CARDINAL_DIRECTIONS checkNorth(int n1, int n2) {
        switch (n1 + n2) {
            case -2:
                return CARDINAL_DIRECTIONS.SOUTH;
            case 0:
                return CARDINAL_DIRECTIONS.NORTH;
            case 1:
                return CARDINAL_DIRECTIONS.WEST;
            case 2:
                return CARDINAL_DIRECTIONS.SOUTH;
            case 3:
                return CARDINAL_DIRECTIONS.EAST;
            case 4:
                return CARDINAL_DIRECTIONS.NORTH;
            default:
                throw new IllegalArgumentException("");
        }
    }

    private static CARDINAL_DIRECTIONS checkWest(int n1, int n2) {
        switch (n1 + n2) {
            case -2:
                return CARDINAL_DIRECTIONS.EAST;
            case 0:
                return CARDINAL_DIRECTIONS.WEST;
            case 1:
                return CARDINAL_DIRECTIONS.SOUTH;
            case 2:
                return CARDINAL_DIRECTIONS.EAST;
            case 3:
                return CARDINAL_DIRECTIONS.NORTH;
            case 4:
                return CARDINAL_DIRECTIONS.WEST;
            default:
                throw new IllegalArgumentException("");
        }
    }

    private static CARDINAL_DIRECTIONS checkSouth(int n1, int n2) {
        switch (n1 + n2) {
            case -2:
                return CARDINAL_DIRECTIONS.NORTH;
            case 0:
                return CARDINAL_DIRECTIONS.SOUTH;
            case 1:
                return CARDINAL_DIRECTIONS.EAST;
            case 2:
                return CARDINAL_DIRECTIONS.NORTH;
            case 3:
                return CARDINAL_DIRECTIONS.WEST;
            case 4:
                return CARDINAL_DIRECTIONS.SOUTH;
            default:
                throw new IllegalArgumentException("");
        }
    }

    private static CARDINAL_DIRECTIONS checkEast(int n1, int n2) {
        switch (n1 + n2) {
            case -2:
                return CARDINAL_DIRECTIONS.WEST;
            case 0:
                return CARDINAL_DIRECTIONS.EAST;
            case 1:
                return CARDINAL_DIRECTIONS.NORTH;
            case 2:
                return CARDINAL_DIRECTIONS.WEST;
            case 3:
                return CARDINAL_DIRECTIONS.SOUTH;
            case 4:
                return CARDINAL_DIRECTIONS.EAST;
            default:
                throw new IllegalArgumentException("");
        }
    }


    /* For11. An integer N (> 0) is given. Find the amount
    N^2 + (N + 1)^2 + (N + 2)^2 + … + (2*N)^2
    (integer).*/

    public static int forTask(int n) {
        assert n > 0 : "N <= 0 !!";
        int sum = 0;
        for (int i = n; i <= (2 * n); i++) {
            sum += i * i;
        }
        return sum;
    }


    /* While11*. An integer N (> 1) is given. Output the smallest of the integers K for which the sum 1 + 2 + ... + K
     will be greater than or equal to N, and this sum itself.*/

    public static int[] whileTask(int n) {
        assert n > 1 : "N <= 1 !!!";
        int k = 1, sum = 0;
        while (sum < n) {
            sum += k;
            k++;
        }
        int[] res = {k - 1, sum};
        return res;
    }


    /* Given an array A of size N and an integer K (1 <= K <= N). Output array elements with ordinal numbers that are
    multiples of K: AK, A2·K, A3·K, … . Do not use the conditional operator.*/

    public static int[] arrayTask(int[] A, int k) {
        int n = A.length;
        assert k >= 1 : "K < 1!!!!";
        assert n >= k : "K > N";
        int arr[] = new int[n / k];
        int i = 1;
        while ((k * i) <= n) {
            arr[i - 1] = A[k * i];
            i++;
        }
        return arr;
    }


    /* Given a matrix of size M × N. Print its elements in the following order: first row from left to right, second
     row from right to left, third row from left to right, fourth row from right to left, etc.*/

    public static int[][] matrixTask(int[][] M) { //без розмірів
        int n = M.length, m = M[0].length;
        int matrix[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            if ((i % 2) == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = M[i][j];
                }
            }else{
                int l = m-1;
                for (int j = 0; j < m ; j++) {
                    matrix[i][j] = M[i][l];
                    l--;
                }
            }
        }
        return matrix;
    }

    public static void main(String args[]) {
    }

}
