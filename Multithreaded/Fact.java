import java.math.BigInteger;

class Factorial implements Runnable {
    private int number;


    public Factorial(int number) {
        this.number = number;
    }

    public Factorial() {
        super();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private BigInteger calculateFactorial(int number) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= number; i++) {
            result = result.multiply(new BigInteger("" + i));
        }
        return result;
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        th.setName("Thread No. " + number);
        System.out.println(th.getName() + ":" + "!" + number + " = " + calculateFactorial(number));
    }
}
public class Fact{
    public static void main(String[] args){
        Factorial s=new Factorial(10);
        s.run();
    }
}