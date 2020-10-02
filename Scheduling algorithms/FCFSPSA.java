import java.util.Scanner;
class FCFSP{
    int i,j,max=30,n,t;
    int wtc=0,tatc=0;
    int[] p,at,bt,wt,tat,priority;
    double awt,atat;
    void revbubblesort(){
        int i, j;
        for (i = 0; i < n-1; i++)
        {
           for (j = 0; j < n-i-1; j++)
           {
            if(priority[j]<priority[j+1])
            {  
               t=priority[j];
               priority[j]=priority[j+1];
               priority[j+1]=t;
               t=bt[j];
               bt[j]=bt[j+1];
               bt[j+1]=t;
               t=p[j];
               p[j]=p[j+1];
               p[j+1]=t;
               t=at[j];
               at[j]=at[j+1];
               at[j+1]=t;
            }
           }
        }
    }
    void input(){
        Scanner S2=new Scanner(System.in);
        System.out.println("Enter the Process Numbers");
        for(int i=0;i<n;i++){
            p[i]=S2.nextInt();
        }
        System.out.println("Enter the arrival times");
        for(i=0;i<n;i++){
            at[i]=S2.nextInt();
        } 
        System.out.println("Enter the burst times");
        for(i=0;i<n;i++){
            bt[i]=S2.nextInt();
        }
        System.out.println("Enter the Priorities");
        for(i=0;i<n;i++){
            priority[i]=S2.nextInt();
        }
        S2.close();
    }
    void display(int i){
        System.out.println(""+p[i]+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+priority[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
    }
    void wttat(int i){
        if(i==0){
            wt[i]=0;
            tat[i]=bt[i];
        }
        else{
            wt[i]=wt[i-1]+bt[i];
            wtc+=wt[i];
            tat[i]=wtc;
            tatc+=tat[i];
        }
    }
    void start(){
        Scanner S1=new Scanner(System.in);
        System.out.println("Enter the number of processes");
        n=S1.nextInt();
        p=new int[n];
        at=new int[n];
        bt=new int[n];
        wt=new int[n];
        tat=new int[n];
        priority=new int[n];
        input();
        revbubblesort();
        System.out.println("Process\tArrival time\tBurst time\tpriority\tWaiting time\tTurnAround time");
        for(int i=0;i<n;i++){
            wttat(i);
            display(i);
        }
        awt=wtc/n;
        atat=tatc/n;
        System.out.println("The average Waiting time is :"+awt);
        System.out.println("The average TurnAround time is:"+atat);
        S1.close();
    } 
}
public class FCFSPSA{
    public static void main(String[] args){
        FCFSP f=new FCFSP();
        f.start();
    }
}