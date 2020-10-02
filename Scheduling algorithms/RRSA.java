import java.util.Scanner;
class RR{
    int n,time,quantum,i;
    int[] at,bt,wt,rem_bt,tat,pno;
    void print(String s){
        System.out.println(s);
    }
    void findwaitingtime(){
        int time=0;
        while (true) {
            boolean done=true;
            for(int i=0;i<n;i++){
                if(rem_bt[i]>0){
                done=false;
                if(rem_bt[i]>quantum){
                    time+=quantum;
                    rem_bt[i]-=quantum;
                }
                else{
                    time+=rem_bt[i];
                    wt[i]=time-bt[i];
                    rem_bt[i]=0;
                }
            }
            }
            if(done==true)
                break;
        }
    }
    void findturnaroundtime(){
        for(int i=0;i<n;i++)
            tat[i]=bt[i]+wt[i];
    }
    void findavgtime(){
        int total_wt=0,total_tat=0;
        for(int i=0;i<n;i++){
            total_wt+=wt[i];
            total_tat+=tat[i];
        }
        print("Average waiting time="+(float)total_wt/(float)n);
        print("Average turnaround time ="+(float)total_tat/(float)n);
    }
    void display(){
        print("Process\tArrival time\tBurst time\tWaiting time\t TurnAround time");
        for(i=0;i<n;i++){
            print(""+(i+1)+"\t\t"+at[i]+"\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
        }
    }
    void input(){
        Scanner S1=new Scanner(System.in);
        print("Enter the no of processes");
        n=S1.nextInt();
        at=new int[n];
        bt=new int[n];
        rem_bt=new int[n];
        wt=new int[n];
        tat=new int[n];
        print("Enter the Arrival times");
        for(int i=0;i<n;i++)
            at[i]=S1.nextInt();
        print("Enter the Burst times");
        for(int i=0;i<n;i++)
            bt[i]=S1.nextInt();
        for(int i=0;i<n;i++)
            rem_bt[i]=bt[i];
        print("Enter the time quantum");
        quantum=S1.nextInt();
        S1.close();
    }
    void start(){
        input();
        findwaitingtime();
        findturnaroundtime();
        display();
        findavgtime();
    }

}
public class RRSA{
    public static void main(String[] args){
        RR b=new RR();
        b.start();
    }
}