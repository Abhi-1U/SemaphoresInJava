import java.util.Scanner;
class MUTEX4{
    int mutex=1,full=0,empty=3,x=0,n;
    Scanner S1=new Scanner(System.in);
    int decrement(int s){
        return (--s);
    }
    int increment(int s){
        return (++s);
    }
    boolean isnotempty(){
        if(empty!=0){
            return true;
        }
        else{
            return false;
        }
    }
    boolean isnotfull(){
        if(full!=0){
            return true;
        }
        else{
            return false;
        }
    }
    boolean ExchangeStatus(){
        if(mutex==1){
            return true;
        }
        else{
            return false;
        }
    }
    void producer(){
        mutex=decrement(mutex);
        full=increment(full);
        empty=decrement(empty);
        x++;
        display("Producer","produced");
        mutex=increment(mutex);
    }
    void consumer(){
        mutex=decrement(mutex);
        full=decrement(full);
        empty=increment(empty);
        x--;
        display("Consumer","Consumed");
        mutex=increment(mutex);
    }
    void Invalid(String s){
        System.out.println("The Buffer is"+s+"or signal not recieved");
    }
    int choice(){
        System.out.println("1.Producer 2.Consumer 3.Exit");
        System.out.println("Enter your choice");
        n=S1.nextInt();
        if(n==1){
            if(isnotempty()&&ExchangeStatus()){
                producer();
            }
            else{
                Invalid("Full");
            }
            return 1;
        }
        if(n==2){
            if(isnotfull()&&ExchangeStatus()){
                consumer();
            }
            else{
                Invalid("Empty");
            }
            return 2;
        }
        if(n==3){
                System.out.println("Thank You");
                return 3;
        }
        else{
                System.out.println("Invalid Input");
                return 0;
        }
        
    }
    void display(String s1,String s2){
        System.out.println("The "+s1+s2+"The content"+(x+1));
    }
    void start(){
        int y=0;
        while(y!=3){
            y=choice();
        }
        S1.close();
    }
}
public class MUTEX1{
    public static void main(String[] args){
        MUTEX4 M=new MUTEX4();
        M.start();
    }
}