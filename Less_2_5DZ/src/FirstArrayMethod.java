public class FirstArrayMethod {

    public void MyArrayCalc(float[] arr){
        //заполняем массив единицами
        long a = System.currentTimeMillis(); //засекаем время выполнения
        for(int i = 0; i < arr.length; i++ ){
            arr[i] = 1;
        }
        System.out.println(System.currentTimeMillis() - a);

        long b = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++ ){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - b);

    }
}
