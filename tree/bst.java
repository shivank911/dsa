package tree;
import java.util.*;
class bst {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
    public static TreeNode construct(int[] arr,int lo,int hi){
        if(lo>hi)
        return null;
        int mid=(lo+hi)/2;
        TreeNode left=construct(arr, lo, mid-1);
        TreeNode right=construct(arr, mid+1, hi);
        TreeNode root=new TreeNode(arr[mid],left,right);
        return root;
    }
    public static TreeNode constructAL(ArrayList<TreeNode> al,int lo,int hi){
        if(lo>hi)
        return null;
        int mid=(lo+hi)/2;
        TreeNode left=constructAL(al, lo, mid-1);
        TreeNode right=constructAL(al, mid+1, hi);
        TreeNode root=new TreeNode(al.get(mid).val,left,right);
        return root;
    }
    public static int size(TreeNode root){
        if(root==null)
        return 0;
        return 1+size(root.left)+size(root.right);
    }
    public static int sumtree(TreeNode root){
        if(root==null)
        return 0;
        int sum=0;
        sum+=sumtree(root.left);
        sum+=sumtree(root.right);
        return root.val+sum;
    }
    public static int MaxTree(TreeNode root){
        if(root==null)
        return Integer.MIN_VALUE;
        return Math.max(root.val,Math.max(MaxTree(root.left),MaxTree(root.right)));
    } 
    public static int MinTree(TreeNode root){
        if(root==null)
        return Integer.MAX_VALUE;
        return Math.min(root.val,Math.min(MinTree(root.left),MinTree(root.right)));
    }   
    public static boolean find(TreeNode root,int data){
        if(root==null)
        return false;
        if(root.val==data){
            return true;
        }
        return find(root.left,data) || find(root.right,data);
    }
    public static int height(TreeNode root){
        if(root==null)
        return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    public static void display(TreeNode node){
        if (node == null) {
            return;
          }
      
          String str = "";
          str += node.left == null ? "." : node.left.val + "";
          str += " <- " + node.val + " -> ";
          str += node.right == null ? "." : node.right.val + "";
          System.out.println(str);
      
          display(node.left);
          display(node.right);
    }
    public static int levelorder(TreeNode root){
        LinkedList<TreeNode> que=new LinkedList<>();
        que.add(root);
        int state=1;
        int ht=height(root);
        int sum=0;
        while(que.size()>0){
            int size=que.size();
            while(size-->0){
                TreeNode temp=que.removeFirst();
                que.add(temp.left);
                que.add(temp.right);
            }
            state++;
            if(state==ht){
                break;
            }
        }
        while(que.size()>0){
            sum+=que.removeFirst().val;
        }
        return sum;
    }
    public static int deepestLeavesSum(TreeNode root){
        return levelorder(root);
    }
    public static int sumEvenGrandparent(TreeNode root){
        if(root==null)
        return 0;
        int sum=0;
        if(root.val%2==0){
            if(root.left!=null && root.left.left!=null)
            sum+=root.left.left.val;
            if(root.left!=null && root.left.right!=null)
            sum+=root.left.right.val;
            if(root.right!=null && root.right.left!=null)
            sum+=root.right.left.val;
            if(root.right!=null && root.right.right!=null)
            sum+=root.right.right.val;
        }
        return sum+sumEvenGrandparent(root.left)+sumEvenGrandparent(root.right);
    }
    static int sum=0;
    public static void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.right);
        sum+=root.val;
        root.val=sum;
        helper(root.left);
    }
    public static TreeNode bsttogst(TreeNode root){
        helper(root);
        return root;

    }
    public void helper(TreeNode root,int[] preorder,int i){
        if(preorder[i]<root.val){
            if(root.left==null)
            root.left=new TreeNode(preorder[i]);
            else
                helper(root.left,preorder,i);
        }
        else if(preorder[i]>root.val){
            if(root.right==null)
                root.right=new TreeNode(preorder[i]);
            else 
                helper(root.right,preorder,i);
        }
        
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode(preorder[0]);
        for(int i=1;i<preorder.length;i++){
            helper(root,preorder,i);
        }
        return root;
    }
    public static TreeNode lca(TreeNode root,int d1,int d2){
        if(root.val> d1 && root.val>d2){
            return lca(root.left,d1,d2);
        }
        else if(root.val <d1 && root.val<d2){
            return lca(root.right,d1,d2);
        }
        return root;
    }
    // public static boolean find(TreeNode node,int val){
    //     if(node.val<val){
    //         return find(node.right,val);
    //     }
    //     else if(node.val>val){
    //         return find(node.right,val);
    //     }
    //     else if(node.val==value){
    //         return true;
    //     }
    //     return false;
    // }
    public static void targetsumpair(TreeNode root,TreeNode node,int value){
        if(node==null)
        return;
        targetsumpair(root, root.left, value);
        int comp=value-node.val;
        if(node.val<comp){
        if(find(node,comp)==true){
            System.out.println(node.val+" "+comp);
        }
    }
        targetsumpair(root, node.right, value);
    }
    public static void treetoarr(ArrayList<TreeNode> al,TreeNode root){
        if(root==null)
        return;
        treetoarr(al, root.left);
        al.add(root);
        treetoarr(al, root.right);
    }
    public static TreeNode balancebst(TreeNode root){
        ArrayList<TreeNode> al=new ArrayList<>();
       treetoarr(al,root);
       root=constructAL(al, 0, al.size()-1);
       return root;


    }
    public static void flatten(TreeNode root){
        if(root==null)
        return ;
        if(root.left==null && root.right==null)
        return;
        if(root.left!=null){
            flatten(root.left);
            TreeNode right=root.right;
            root.right=root.left;
            root.left=null;
            while(root.right!=null)
            root=root.right;
            root.right=right;
        }
        flatten(root.right);
        return;
    }
    public static void main(String args[]){
        int arr[]={12,25,37,50,62,75,87};
        TreeNode root=construct(arr,0,arr.length-1);
        display(root);
        //System.out.println(size(root));
        // System.out.println(sumtree(root));
        // System.out.println(MaxTree(root));
        // System.out.println(MinTree(root));
        //System.out.println(find(root,99));
        //System.out.println(height(root));
        //System.out.println(deepestLeavesSum(root));
        System.out.println("");
        display(bsttogst(root));
        
    }
    
}
