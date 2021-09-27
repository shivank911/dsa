import java.util.*;

public class recurr {
    public static void tarversearrayfwd(int[] arr,int i){
        if(i==arr.length)
        return;
        System.out.print(arr[i]+" ");
        tarversearrayfwd(arr,i+1);
    }
    public static void traversearrayback(int arr[],int i){
        if(i==arr.length)
        return;
        traversearrayback(arr, i+1);
        System.out.print(arr[i] +" ");
    }
    public static void main(String args[]){
        int arr[]={1,2,3,4,5};
        tarversearrayfwd(arr, 0);
        traversearrayback(arr, 0);
    }
}
