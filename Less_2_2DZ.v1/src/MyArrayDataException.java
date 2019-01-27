public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j){
        super("Не удалось преобразование типов в элементе: " + i + j);
    }

}
