public class MyArrayThread  extends  Thread{
    private float[] arr;

    public MyArrayThread(float[] arr){
        this.arr = arr;
    }

    @Override
    public void run(){
        //засекаем время выполнения
        System.out.printf("Thread id %d%n", getId());
        for(int i = 0; i < arr.length; i++ ){
            arr[i] = 1;
        }

        for(int i = 0; i < arr.length; i++ ){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    }

    public float[] getArr(){
        return arr;
    }
}
