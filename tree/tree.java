import java.util.*;
class tree{
   public static class Node{
        int data;
        ArrayList<Node> child=new ArrayList<>();
    }
    public static void display(Node root){
        System.out.print(root.data+"-> ");
        for(Node child:root.child){
            System.out.print(child.data+",");
        }
        System.out.println(".");
        for(Node child:root.child){
            display(child);
        }
    }
    public static int size(Node root){
        int si=0;
        for(Node child:root.child){
            si+=size(child);
        }
        return si+1;

    }
    public static int maximum(Node root){
        if(root==null)
        return Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        for(Node child:root.child){
            max=Math.max(max,maximum(child));
        }
        return Math.max(max, root.data);
    }
    public static int height(Node root){
        if(root==null)
        return 0;
        int height=0;
        for(Node child:root.child){
            height=Math.max(height, height(child));
        }
        return height+1;
    }
    public static void preorder(Node root){
     if(root==null)
     return;
     System.out.print(root.data+",");
     for(Node child:root.child){
        preorder(child);
     }   
    }
    public static void postorder(Node root){
        if(root==null)
        return;
        for(Node child:root.child){
            postorder(child);
        }
        System.out.print(root.data+",");
    }
    public static void levelorder(Node root){
        LinkedList<Node> que=new LinkedList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        que.add(root);
        while(que.size()!=0){
            int size=que.size();
            while(size-->0){
                Node temp=que.removeFirst();
                ans.add(temp.data);
                for(Node child:temp.child){
                    que.add(child);
                }
            }
        }
        System.out.print(ans);
    }
    public static void zigzag(Node root){
        Stack<Node> mains=new Stack<>();
        Stack<Node> helper=new Stack<>();
        mains.push(root);
        int lvl=0;
        while(mains.size()!=0){
            Node temp=mains.pop();
            System.out.print(temp.data+" ");
            if(lvl%2==0)
            for(Node child:temp.child){
                helper.push(child);
            }
            else{
                for(int i=temp.child.size()-1;i>=0;i--){
                    helper.push(temp.child.get(i));
                }
            }
            if(mains.size()==0){
                Stack<Node> tmp=helper;
                helper=mains;
                mains=tmp;
                lvl++;
                System.out.println();
            }
        } 
    }
    public static void mirror(Node root){
        for(Node child:root.child)
        {
            mirror(child);
        }
        Collections.reverse(root.child);
    }
    public static void removeLeaves(Node root){
        for(int i=root.child.size()-1;i>=0;i--){
            if(root.child.get(i).child.size()==0)
            root.child.remove(i);
        }
        for(Node child:root.child){
            removeLeaves(child);
        }
    }
    public static boolean findnode(int n,Node root){
        if(root==null)
        return false;
        if(n==root.data)
        return true;
        for(Node child:root.child){
            if(findnode(n,child))
            return true;
        }
        return false;
    }
    public static ArrayList<Integer> noodtorootpath(Node root,int val){
        if(root.data==val){
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(val);
            return ans;
        }
        
        for(Node child:root.child){
            ArrayList<Integer> res=new ArrayList<>();
            res=noodtorootpath(child, val);
            if(res.size()>0){
                res.add(root.data);
                return res;
            }
        }
        return new ArrayList<>();
    }
    public static Node getTail(Node root){
        while(root.child.size()==1){
            root=root.child.get(0);
        }
        return root;
    }
    public static void linearize(Node root){

        for(Node child:root.child){
            linearize(child);
        }
        while(root.child.size()>1){
            Node last=root.child.remove(root.child.size()-1);
            Node slast=root.child.get(root.child.size()-1);
            Node tail=getTail(slast);
            tail.child.add(last);

        }
    }
    //efficient o(n) 
    public static Node linearize2(Node root){
         if(root.child.size()==0){
             return root;
         }
        Node lkt=linearize2(root.child.get(root.child.size()-1));
        while(root.child.size()>1){
            Node last=root.child.remove(root.child.size()-1);
            Node slast=root.child.remove(root.child.size()-1);
            Node tail=linearize2(slast);
            tail.child.add(last);
        }
        return lkt;
    }
    public static int LowestCommonAncestor(Node root,int d1,int d2){
        ArrayList<Integer> one=noodtorootpath(root, d1);
        ArrayList<Integer> two=noodtorootpath(root, d2);
        int i=one.size()-1;
        int j=two.size()-1;
        while(i>=0 && j>=0 && one.get(i)==two.get(j)){
            i--;
            j--;
        }
        return one.get(i+1);
    }
    public static int distance(Node root,int d1,int d2){
        ArrayList<Integer> one=noodtorootpath(root, d1);
        ArrayList<Integer> two=noodtorootpath(root, d2);
        int i=one.size()-1;
        int j=two.size()-1;
        while(i>=0 && j>=0 && one.get(i)==two.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return i+j;
    } 
    // public String tree2str(Node root) {
    //     if(root==null)
    //         return "()";
    //     if(root.left==null && root.right==null)
    //         return ""+root.val;
    //     String left=tree2str(root.left);
    //     String right=tree2str(root.right);
    //     if(!left.equals("()")){
    //         left="("+left+")";
    //     }
    //     if(!right.equals("()")){
    //         right="("+right+")";
    //     }
    //     else{
    //         right="";
    //     }
    //     return root.data+left+right;
    // }
    public static boolean areMirror(Node n1,Node n2){
        if(n1.child.size()!=n2.child.size())
        return false;
        for(int i=0;i<n1.child.size();i++){
            Node c1=n1.child.get(i);
            Node c2=n2.child.get(n1.child.size()-1-i);
            if(areMirror(c1, c2)==false)
            return false;
        }
        return true;

    }
    public static boolean areSymmetric(Node root){
        return areMirror(root,root);
    }
    public static void predecessorANDsuccessor(Node root,int data){

    }
    static int msum;
    static int snode;
    public static int sumnodemax(Node root){
        int sum=0;
        for(Node child:root.child){
            sum+=sumnodemax(child);
        }
        sum+=root.data;
        if(msum<sum){
            msum=sum;
            snode=root.data;
        }
        return sum;
    }
    static int ceil;
    static int floor;
    public static void ceilandfloor(Node root,int data){
        if(root.data<data){
            ceil=Math.max(ceil, root.data);
        }
        if(root.data>data){
            floor=Math.min(floor, root.data);
        }
        for(Node child:root.child){
            ceilandfloor(child, data);
        }
    }
    // public static int kthlargest(Node root,int k){
    //     floor=Integer.MIN_VALUE;
    //     int data=Integer.MAX_VALUE;
    //     for(int i=0;i<k;i++){
    //         ceilandfloor(root, data);
    //         data=floor;
    //         floor=Integer.MIN_VALUE;
    //     }
    //     return factor;
    // }
    static int dia;
    public static int diameter(Node root){
        int ht=-1,slht=-1;
        for(Node child:root.child){
            int h=height(child);
            if(h>ht){
                slht=ht;
                ht=h;
            }
            else if(h>slht){
                slht=h;
            }
        }
        dia=Math.max(slht+ht+2,dia);
        return ht+1;

    }
    public static int talltree()
    public static void main(String[] args) {
		int[] arr={10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
        Node root=new Node();
        Stack<Node> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1)
            st.pop();
            else{
                Node temp=new Node();
                temp.data=arr[i];
                if(st.size()>0){
                 st.peek().child.add(temp);
                }
                else{
                    root=temp;
                }
                st.push(temp);
            }
        }
        display(root);
        //System.out.println(size(root));
        //System.out.println(maximum(root));
        //System.out.println(height(root));
        // preorder(root);
        // System.out.println();
        // postorder(root);
        //levelorder(root);
        //zigzag(root);
        //removeLeaves(root);
        //System.out.println(findnode(110,root));
        //System.out.println(noodtorootpath(root,110));
        //display(root);
        // linearize(root);
        // display(root);
        // System.out.println(LowestCommonAncestor(root, 70, 110));
        // System.out.println(distance(root, 70, 110));
        // msum=Integer.MIN_VALUE;
        // snode=0;
        // sumnodemax(root);
         System.out.println(msum+"@"+snode);


        
	}

}
