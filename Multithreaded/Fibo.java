


class Fibonacci implements Runnable{
    private int number;
    int result=0,t1,t2;
    public Fibonacci(int n){
        number=n;
    }
    public Fibonacci(){
        super();
    }
    int calculateFibonnaci(int number){
    	int a = 0, b = 1, c; 
        if (number == 0) 
            return a; 
        for (int i = 2; i <= number; i++) 
        { 
            c = a + b; 
            a = b; 
            b = c; 
        } 
        return b;
    }
    @Override
    public void run(){
        Thread th=Thread.currentThread();
        th.setName("Thread no."+number);
        System.out.println(th.getName()+"th term"+"="+calculateFibonnaci(number));
    }
}
public class Fibo{
    public static void main(String[] args){
        Fibonacci s=new Fibonacci(10);
        s.run();
    }
}
