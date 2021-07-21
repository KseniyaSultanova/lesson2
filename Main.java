public class Main {
    public static void main(String[] args) {
        String[][] arr =
                {{"1", "2", "3", "4"},
                {"5", "6", "7", "66"},
                {"11", "12", "13r", "14"},
                {"15", "16", "17", "18"},
        };

        System.out.println("Сумма масива" + sum(arr, 4));
    }

    public static int sum(String[][] arr, int arraySize) {
        int result = 0;


        if (arr.length != arraySize) {
            try {
                throw new MyArraySizeException("Неверный размер массива", arr.length);
            } catch (MyArraySizeException exception) {
                exception.printStackTrace();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != arraySize) {
                try {
                    throw new MyArraySizeException("Неверный размер массива", arr[i].length);
                } catch (MyArraySizeException exception) {
                    exception.printStackTrace();
                }
            }

            for (int j = 0; j < arr[i].length; ++j) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    try {
                        throw new MyArrayDataException("Нельзя привести к цифровому значению", i, j);
                    } catch (MyArrayDataException myArrayDataException) {
                        myArrayDataException.printStackTrace();
                    }
                }
            }
        }

        return result;
    }
}