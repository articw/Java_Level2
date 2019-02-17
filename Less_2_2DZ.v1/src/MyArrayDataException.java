public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j){
        super(String.format("Не удалось преобразование типов в элементе [%d, %d]", i, j));
    }

}
