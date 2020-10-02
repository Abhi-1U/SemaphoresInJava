import java.util.Scanner;
class LRU{
    int i,j,N,P,fault=0,hit=0;
    int[] time,arr,input;
    int findLRU(){
        int i,minimum=time[0],pos=0;
        for(i=0;i<N;i++){
            if(time[i]<minimum){
                minimum=time[i];
                pos=i;
            }
        }
        return pos;

    }
    int findposition(int val){
        int i;
        for(i=0;i<N;i++){
            if(arr[i]==val){
                return i;
            }
        }
        return 0;
    }
    void pagehit(int i){
        if(input[i]==arr[0]||input[i]==arr[1]||input[i]==arr[2]){
            hit+=1;
            display("hit");
            }
        else{
            pagefault(i);
            display("fault");
        }
    }

    void pagefault(int i){
        if(i>=N){
            arr[findLRU()]=input[i];
            time[findLRU()]=input[i];
            fault+=1;
        }
        else{
            arr[i]=input[i];
            time[i]=i;
            fault+=1;
        }
    }
    void input(){
        Scanner S2 =new Scanner(System.in);
        N=3;
        time=new int[N];
        arr=new int[N];
        System.out.println("Enter the number of Pages");
        P=S2.nextInt();
        input=new int[P];
        System.out.println("Enter the pages in sequential order");
        for(int i=0;i<P;i++){
            input[i]=S2.nextInt();
        }
        for(int i=0;i<N;i++){
            arr[i]=-1;
        }
        S2.close();
    }
    void display(String s){
        System.out.print("Page"+s+":");
        for(int i=0;i<N;i++){
            System.out.print("\t");
            System.out.print(arr[i]);
            System.out.print("|");
        }
        System.out.print("\n");
    }
    void start(){
        input();
        for(int i=0;i<P;i++){
	        pagehit(i);
        }
        System.out.println("The Total Page Faults are :"+fault);
        System.out.println("The total Page Hits are :"+hit);
    }
}
public class LRUPGR{
    public static void main(String[] args){
        LRU s=new LRU();
        s.start();
    }
}