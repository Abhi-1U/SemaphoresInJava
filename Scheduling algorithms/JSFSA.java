import java.util.Scanner;
class SJF{
    int i,j,max=30,n,t;
    int wtc=0,tatc=0;
    int[] p,bt,wt,tat;
    double awt=0,atat=0;
    void bubblesort(){
        int i, j;
        for (i = 0; i < n-1; i++)
        {
           for (j = 0; j < n-i-1; j++)
           {
            if(bt[j]>bt[j+1])
            {
               t=bt[j];
               bt[j]=bt[j+1];
               bt[j+1]=t;
               t=p[j];
               p[j]=p[j+1];
               p[j+1]=t;
            }
           }
        }
    }
    void input(){
        Scanner s2=new Scanner(System.in);
        System.out.println("Enter the process numbers");
        for(int i=0;i<n;i++){
            p[i]=s2.nextInt();
        }
        System.out.println("Enter the burst times of these Processes");
        for(int i=0;i<n;i++){
            bt[i]=s2.nextInt();
        }
        s2.close();
    }
    void display(int i){
        System.out.println(""+p[i]+"\t\t"+bt[i]+"\t"+wt[i]+"\t"+tat[i]);
    }
    void wttat(int i){
        wt[i]=wtc;
        wtc=wt[i]+bt[i];
        tat[i]=wtc;
        tatc+=tat[i];
    }
    void start(){
        Scanner S1 = new Scanner(System.in);
        System.out.println("Enter the number of processes");
        n=S1.nextInt();
        p = new int[n];
        bt =new int[n];
        wt = new int[n];
        tat =new int[n];
        input();
        bubblesort();
        System.out.println("Process\tBurst time\tWaiting time\tTurnAround time");
        for(int i=0;i<n;i++){
            wttat(i);
            display(i);
        }
        awt=wtc/n;
        atat=tatc/n;
        System.out.println("The average waiting time is :"+awt);
        System.out.println("The average turn around time is :"+atat);
        S1.close();
    }
}
public class JSFSA{
    public static void main(String[] args){
        SJF s=new SJF();
        s.start();        
    }
}