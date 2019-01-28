/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
подаче массива другого размера необходимо бросить исключение MyArraySizeException.


2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.

3. В методе main() вызвать полученный метод, обработать возможные исключения
MySizeArrayException и MyArrayDataException и вывести результат расчета.

 */

public class MainClass {
    public static void main(String[] args) {
        //Как грамотно подавать на вход метода массив?
        String[][] arrayOfFour = {
                {"4", "6", "3", "8"},
                {"56", "43", "34", "23"},
                {"56", "21", "34", "23"},
                {"56", "43", "34", "23"}
        };

        String[][] arrayOfFive = {
                {"4", "6", "8", "1"},
                {"56", "23", "12", "43"},
                {"32", "67", "45", "43"},
                {"50", "76", "32", "64"},
                {"12", "43", "87", "77"}

        };

        String[][] arrayOfPlus = {
                {"4", "6", "8", "1"},
                {"56", "23", "12", "43"},
                {"32", "67", "45", "43"},
                {"50", "76", "", "64"}

        };

        //нормальный массив
        try {
            arrayOfFourTest(arrayOfFour);
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        //не та размерность
        try {
            arrayOfFourTest(arrayOfFive);
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }

        //не удалось преобразовать тип
        try {
            arrayOfFourTest(arrayOfPlus);
        } catch (MyArrayDataException | MyArraySizeException e) {
            System.out.println(e.getMessage());
        }


    }


    public static int arrayOfFourTest(String[][] arr) throws MyArrayDataException, MyArraySizeException {


        int count = 0;
        //Проеврка, если массив не 4х4
        if (4 != arr.length) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (4 != arr[i].length) {
                throw new MyArraySizeException();
            }
        }


        //обходим массив, преобразуем строковые величины в int и складываем
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i,j);
                }

            }

        }

        return count;
    }
}

