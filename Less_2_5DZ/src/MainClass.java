/*
1. Необходимо написать два метода, которые делают следующее:
1) Создают одномерный длинный массив, например:
static final int size = 10000000;
static final int h = size / 2;
float[] arr = new float[size];
2) Заполняют этот массив единицами;
3) Засекают время выполнения: long a = System.currentTimeMillis();
4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
5) Проверяется время окончания метода System.currentTimeMillis();
6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);
Отличие первого метода от второго:
Первый просто бежит по массиву и вычисляет значения.
Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

Пример деления одного массива на два:
System.arraycopy(arr, 0, a1, 0, h);
System.arraycopy(arr, h, a2, 0, h);

Пример обратной склейки:
System.arraycopy(a1, 0, arr, 0, h);
System.arraycopy(a2, 0, arr, h, h);

Примечание:
System.arraycopy() копирует данные из одного массива в другой:
System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
По замерам времени:
Для первого метода надо считать время только на цикл расчета:
for (int i = 0; i < size; i++) {
arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
}
Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
 */

public class MainClass {

    static final int size = 10000000;
    static final int H = size / 2;
    static float[] arr = new float[size];
    static float[] a1 = new float[H];
    static float[] a2 = new float[H];


    public static void MyArrayCalcThread(float[] arr) {

        //Делим исходный массив на два
        long t1 = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, H);
        System.arraycopy(arr, H, a2, 0, H);
        System.out.println("Время разбивки массива на два: " + (System.currentTimeMillis() - t1));

        //Создаем два новых потока с вычислениями. Здесь парралельно записываются значения в а1 и а2.
        MyArrayThread thr1 = new MyArrayThread(a1);
        MyArrayThread thr2 = new MyArrayThread(a2);

        //Запускаем потоки. Блокировка и синхронизация не нужны, потому что два разных массива?
        long t2 = System.currentTimeMillis();
        thr1.start();
        //Почему время - 1?
        System.out.println("Время просчета первого массива: " + (System.currentTimeMillis() - t2));

        long t3 = System.currentTimeMillis();
        thr2.start();
        //Почему время - 0?
        System.out.println("Время просчета второго массива: " + (System.currentTimeMillis() - t3));
        //Получаем новые значения элементов массива после вычислений
        thr1.getArr();
        thr2.getArr();
        long t4 = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, H);
        System.arraycopy(a2, 0, arr, H, H);
        System.out.println("Время склейки массивов: " + (System.currentTimeMillis() - t4));
    }



    public static void main(String[] args)  {
            FirstArrayMethod fArr = new FirstArrayMethod();
            fArr.MyArrayCalc(arr);
            MyArrayCalcThread(arr);

    }

}
