package tree;
import java.util.*;
public class binarysearchtree {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int val,Node left,Node right){
            this.data=val;
            this.left=left;
            this.right=right;
        }
    }
    public static Node construct(int[] arr,int lo,int hi){
        if(lo>hi)
        return null;
        int mid=(lo+hi)/2;
        Node left=construct(arr, lo, mid-1);
        Node right=construct(arr, mid+1, hi);
        Node root=new Node(arr[mid],left,right);
        return root;
    }
    public static void display(Node node){
        if (node == null) {
            return;
          }
      
          String str = "";
          str += node.left == null ? "." : node.left.data + "";
          str += " <- " + node.data + " -> ";
          str += node.right == null ? "." : node.right.data + "";
          System.out.println(str);
      
          display(node.left);
          display(node.right);
    }
    public static void main(String args[]){
        int arr[]={12,25,37,50,62,75,87};
        Node root=construct(arr,0,arr.length-1);
        display(root);
    }
    
}
