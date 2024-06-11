import java.util.Arrays;
import java.util.List;

public class Main {

    public static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("The size of the array should be 4x4");
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Invalid data in the cell " + i + ", " + j);
                }
            }
        }
        return sum;
    }

    private static List<String[][]> getArrays() {
        String[][] arr1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] arr2 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        String[][] arr3 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "word", "12"},
                {"13", "14", "15", "16"}
        };

        return Arrays.asList(arr1, arr2, arr3);
    }

    public static void main(String[] args) {
        List<String[][]> arrays = getArrays();

        for (String[][] arr : arrays) {
            try {
                int result = sumArray(arr);
                System.out.println("Result: " + result);
            } catch (MyArraySizeException e) {
                System.out.println("Array size exception: " + e.getMessage());
            } catch (MyArrayDataException e) {
                System.out.println("Array data exception: " + e.getMessage());
            }
        }
    }
}
