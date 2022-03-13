import java .util.*;
public class Level1 {
    public static void LongestConsecutiveSequence(int arr[]){
        HashMap<Integer,Boolean> mp=new HashMap<>();
        for(int i =0;i<arr.length;i++){
            mp.put(arr[i],true);
        }
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i]-1)){
                mp.put(arr[i],false);
            }
        }
        int max=-1;
        for(int i=0;i<arr.length;i++){
            int len=1;
            if(mp.containsKey(arr[i])){
                int val=arr[i];
                while(mp.containsKey(val+1)){
                    len++;
                    val++;
                }
                max=Math.max(max,len);
            }
        }
        System.out.println(max);
    }

    public static void kLargetElement(int arr[],int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        while(i<arr.length && pq.size()<k){
            pq.add(arr[i]);
            i++;
        }
        if(i<arr.length){
            while(i<arr.length){
                if(pq.peek()<arr[i]){
                pq.remove();
                pq.add(arr[i]);
                }
                i++;
            }
            System.out.println(pq);
        }
        else{
            System.out.println(pq);
        }
    }


    public static void MedianPriorityQueue(int arr[]){
        PriorityQueue<Integer> left=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right=new  PriorityQueue<>();

       
    }
    public class Pair implements Comparable<Pair>{
        int li;
        int idx;
        int val;
        Pair(int li,int idx,int val){
            this.li=li;
            this.idx=idx;
            this.val=val;
        }
        public int compareTo(Pair o){
            return this.val-o.val;
        }
    }
    public static ArrayList<Integer> mergeKsortedList(ArrayList<ArrayList<Integer>> li){
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=0;i<li.size();i++){
            Pair p=new Pair(i, 0, li.get(i).get(0));
            pq.add(p);
        }
        while(pq.size()>0){
            Pair p=pq.remove();
            ans.add(p.val);
            p.idx++;
            if(p.idx<li.get(p.li).size()){
                p.val=li.get(p.li).get(p.idx);
                pq.add(p);
            }
        }
        return ans;
    }
    public class Priorityqueue{
        ArrayList<Integer> data;
        public Priorityqueue(){
            data=new ArrayList<>();
        }
        public void add(int val){
            data.add(val);
            //heapify
            upheapify(data.size()-1);
        }
        public void upheapify(int idx){
            if(size==0){
                return;
            }
            int parent=(idx-1)/2;
            if(data.get(parent)>data.get(idx)){
                swap(idx,parent);
                upheapify(parent);
            }
        }
        public void swap(int idx,int parent){
            int idxth=data.get(idx);
            int parentelem=data.get(parent);
            data.set(idx, parentelem);
            data.set(parent, idxth);
        }
        public int remove(){
            int size=size();
            if(size==0){
                System.out.println("underflow");
                return -1;
            }
            swap(0,size-1);
            int val=data.remove(size-1);
            downheapify(0);
            return val;
        }
        public void downheapify(int idx){
            int mini=idx;
            int left=2*idx+1;
            if(left<data.size() && data.get(left)<data.get(mini)){
                mini=left;
            }
            int right=2*idx+2;
            if(right<data.size() && data.get(right)<data.get(mini)){
                mini=right;
            }
            if(mini!=idx){
                swap(idx,mini);
                downheapify(mini);
            }


        }
        public int peek(){
            if(this.size()==0){
                System.out.println("underflow");
                return -1;
            }
            return data.get(0);
        }
        public int size(){
            return data.size();
        }
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        LongestConsecutiveSequence(arr);
        kLargetElement(arr,3);
    }
}
