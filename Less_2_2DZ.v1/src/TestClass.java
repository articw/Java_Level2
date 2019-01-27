public class TestClass {

    public static void main(String[] args) {

        try {
          getSum();
        }catch (ArithmeticException e){
            System.out.println("Делить на ноль нельзя");
        }

    }

    public static int getSum() throws ArithmeticException  {
        int a = 1 / 0;
        return a;
    }
}
