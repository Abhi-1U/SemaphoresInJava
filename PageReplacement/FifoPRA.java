import java.util.Scanner;
class FIFOPGR{
    int I,J,j,P,N,K=3,k=0,fault=0,hit=0;
    int Arr[]={-1,-1,-1};
    int[] input;
    void pagehit(int i){
        if(input[i]==Arr[0]||input[i]==Arr[1]||input[i]==Arr[2]){
            hit+=1;
            display("hit");
            }
        else{
            pagefault(i);
            display("fault");
    }
    }
    void pagefault(int i){
        if(i<3){
            Arr[i]=input[i];
            fault+=1;
        }
        else{
            Arr[k]=input[i];
            k+=1;
            fault+=1;
        }
    }
    void kcheck(){
        if(k==3){
            k=0;
        }
    }
    void display(String s){
        System.out.print("Page"+s+":");
        for(int i=0;i<K;i++){
            System.out.print("\t");
            System.out.print(Arr[i]);
            System.out.print("|");
        }
        System.out.print("\n");
    }
    void input(){
        Scanner S1=new Scanner(System.in);
        System.out.println("Enter the number of Pages");
        P=S1.nextInt();
        input=new int[P];
        System.out.println("Enter the pages in sequential order");
        for(int i=0;i<P;i++){
            input[i]=S1.nextInt();
        }
        S1.close();
    }
    void Start(){
        input();
        for(int i=0;i<P;i++){
	        pagehit(i);
	        kcheck();
        }
        System.out.println("The Total Page Faults are :"+fault);
        System.out.println("The total Page Hits are :"+hit);
    }
}
public class FifoPRA{
    public static void main(String[] args){
    FIFOPGR d =new FIFOPGR();
    d.Start();
    }
}