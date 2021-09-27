import java.util.*;
class test {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static int solve(int [] arr,int n){
        int k=0;
        int jim=0,jam=0;
        HashMap<Integer,Integer> mp=new HashMap<>();
        mp.put(0,arr[0]);
        for(int i=1;i<n;i++){
            mp.put(i,mp.get(i-1)+arr[i]);
        }
        jim=arr[0];
        if(n<5){
            return arr[0]+arr[1]+arr[2];
        }
        else{
            k=1;
            int idx=1;
            int x=3*k;
            while(k<n && x<n){
                if(idx%2==1){
                    jam+=mp.get(x)-mp.get(k-1);
                }
                else{
                    jim+=mp.get(x)-mp.get(k-1);
                }
                k=Math.max(x,k);
                x=3*k;
                idx++;
                }
                for(int i=x/3+1;i<n;i++){
                    jim+=arr[i];
                }
                return jim;
            }
        } 

    public static void main(String args[]){
        Scanner scn=new Scanner (System.in);
        int n=scn.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int ans=solve(arr,n);
        System.out.println(ans);
        
    }
}
