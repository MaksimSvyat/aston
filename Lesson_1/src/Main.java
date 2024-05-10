import java.util.Arrays;

public class Main {
    public static void printThreeWords() {
        System.out.print("Orange\nBanana\nApple\n");
    }

    public static void checkSumSign() {
        int number1 = 12;
        int number2 = -13;
        int sum = number1 + number2;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = 11;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 5;
        int b = 30;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static boolean isSumInRange(int number1, int number2) {
        boolean result = false;
        int sum = number1 + number2;

        if (sum >= 10 && sum <= 20) {
            result = true;
        }

        return result;
    }

    public static void compareNumberWithZero(int number) {
        if (number < 0) {
            System.out.println("отрицательное");
        } else {
            System.out.println("положительное");
        }
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void repeatString(String s, int num) {
        for (int i = 0; i < num; i++) {
            System.out.println(s);
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static int[] generateArray(int len, int initialValue) {
        if (len < 0) {
            return new int[0];
        }

        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }

        return array;
    }

    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(isSumInRange(1, 9));
        compareNumberWithZero(-1);
        System.out.println(isNegative(0));
        repeatString("не понятно, в столбик или в строчку))", 3);
        System.out.println(isLeapYear(1904));

//      10 задание
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0) {
                array1[i] = 1;
            } else if (array1[i] == 1) {
                array1[i] = 0;
            }
        }

        System.out.println(Arrays.toString(array1));

//      11 задание
        int[] array2 = new int[100];

        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }

        System.out.println(Arrays.toString(array2));

//      12 задание
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }

        System.out.println(Arrays.toString(array3));

//      13 задание
        int[][] matrix = new int[5][5];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - i - 1] = 1;
        }

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

//      14 задание
        System.out.println(Arrays.toString(generateArray(5, 27)));
    }
}