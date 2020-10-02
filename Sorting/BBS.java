class Bubblesort{
    int[] sort;
    int length,i,j,temp;
    Bubblesort(int arr[],int n){
        sort=new int[n];
        for(int i=0;i<n;++i){
            sort[i]=arr[i];
        }
        length=n;
        for(i=0;i<n-1;i++){
            for(j=0;j<n-i-1;j++){
                if(sort[j]>sort[j+1]){
                    temp=sort[j];
                    sort[j]=sort[j+1];
                    sort[j+1]=temp;
                }
            }
        }
    }
    void Out(){
        for (int i: sort){
            System.out.print(i + " ");}
    }
}
public class BBS{
    public static void main(String[] args){
        int arre[]={3,1,0,3,3,1,10,5,6,4};
        int len=10;
        Bubblesort b=new Bubblesort(arre,len);
        b.Out();
    }
}