
import java.util.*;
public class ll{
    public static class Node {
        int data;
        Node next;
      }
    
      public static class LinkedList {
        Node head;
        Node tail;
        int size;
    
        void addLast(int val) {
          Node temp = new Node();
          temp.data = val;
          temp.next = null;
    
          if (size == 0) {
            head = tail = temp;
          } else {
            tail.next = temp;
            tail = temp;
          }
    
          size++;
        }
        public void removeFirst() {
          if (size == 0) {
            System.out.println("List is empty");
          } else if (size == 1) {
            head = tail = null;
            size = 0;
          } else {
            head = head.next;
            size--;
          }
        }
        public int getFirst() {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else {
            return head.data;
          }
        }
        public int getLast() {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else {
            return tail.data;
          }
        }
        public int getAt(int idx) {
          if (size == 0) {
            System.out.println("List is empty");
            return -1;
          } else if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
          } else {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
              temp = temp.next;
            }
            return temp.data;
          }
        }
        public void addFirst(int val) {
          Node temp = new Node();
          temp.data = val;
          temp.next = head;
          head = temp;
    
          if (size == 0) {
            tail = temp;
          }
    
          size++;
        }
        public void addAt(int idx, int val) {
          if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
          } else if (idx == 0) {
            addFirst(val);
          } else if (idx == size) {
            addLast(val);
          } else {
            Node node = new Node();
            node.data = val;
    
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
              temp = temp.next;
            }
            node.next = temp.next;
    
            temp.next = node;
            size++;
          }
        }
        public void removeLast() {
          if (size == 0) {
            System.out.println("List is empty");
          } else if (size == 1) {
            head = tail = null;
            size = 0;
          } else {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
              temp = temp.next;
            }
    
            tail = temp;
            tail.next = null;
            size--;
          }
        }
        public void removeAt(int idx) {
          if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
          } else if (idx == 0) {
            removeFirst();
          } else if (idx == size - 1) {
            removeLast();
          } else {
            Node temp = head;
            for (int i = 0; i < idx - 1; i++) {
              temp = temp.next;
            }
    
            temp.next = temp.next.next;
            size--;
          }
        }
    
        private Node getNodeAt(int idx) {
          Node temp = head;
          for (int i = 0; i < idx; i++) {
            temp = temp.next;
          }
          return temp;
        }
        public void oddEven() {
          LinkedList odd = new LinkedList();
          LinkedList even = new LinkedList();
    
          while (this.size > 0) {
            int val = this.getFirst();
            this.removeFirst();
    
            if (val % 2 == 0) {
              even.addLast(val);
            } else {
              odd.addLast(val);
            }
          }
    
          if (odd.size > 0 && even.size > 0) {
            odd.tail.next = even.head;
    
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;
          } else if (odd.size > 0) {
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;
          } else if (even.size > 0) {
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;
          }
        }
    }
    public static void construct(int[] arr,LinkedList list1){
        for(int i=0;i<arr.length;i++){
            list1.addLast(arr[i]);
        }
    }
    public  static void display(Node head) {
        for (Node temp = head; temp != null; temp = temp.next) {
          System.out.print(temp.data + " ");
        }
        System.out.println();
    }
    public static Node reverse(Node head){
        if(head==null)
        return null;
        Node tmp=head,prev=null,next;
        while(tmp!=null){
            next=tmp.next;
            tmp.next=prev;
            prev=tmp;
            tmp=next;
        }
        return prev;
    }
    public static int kthFromLast(Node head,int k) {
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k; i++) {
          fast = fast.next;
        }
  
        while (fast.next!=null ) {
          slow = slow.next;
          fast = fast.next;
        }
  
        return slow.data;
    }
    public static void removeDuplicates(LinkedList ll) {
        LinkedList res = new LinkedList();
  
        while (ll.size > 0) {
          int val = ll.getFirst();
          ll.removeFirst();
  
          if (res.size == 0 || val != res.tail.data) {
            res.addLast(val);
          }
        }
  
        ll.head = res.head;
        ll.tail = res.tail;
        ll.size = res.size;
      }
    public static Node midNode(Node head, Node tail) {
        Node f = head;
        Node s = head;
  
        while (f != tail && f.next != tail) {
          f = f.next.next;
          s = s.next;
        }
  
        return s;
      }
    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        LinkedList ml = new LinkedList();
  
        Node one = l1.head;
        Node two = l2.head;
        while (one != null && two != null) {
          if (one.data < two.data) {
            ml.addLast(one.data);
            one = one.next;
          } else {
            ml.addLast(two.data);
            two = two.next;
          }
        }
  
        while (one != null) {
          ml.addLast(one.data);
          one = one.next;
        }
  
        while (two != null) {
          ml.addLast(two.data);
          two = two.next;
        }
  
        return ml;
    }
    public static LinkedList mergeSort(Node head, Node tail) {
        if (head == tail) {
          LinkedList br = new LinkedList();
          br.addLast(head.data);
          return br;
        }
  
        Node mid = midNode(head, tail);
        LinkedList fsh = mergeSort(head, mid);
        LinkedList ssh = mergeSort(mid.next, tail);
        LinkedList sl = mergeTwoSortedLists(fsh, ssh);
        return sl;
      }
    public static void kReverse(LinkedList list1,int k) {
        LinkedList ml=new LinkedList();
        LinkedList hl=new LinkedList();
        while(list1.size>0){
            if(list1.size>k){
                for(int i=0;i<k;i++){
                    hl.addFirst(list1.getFirst());
                    list1.removeFirst();
                }
            }
            else{
                while(list1.size>0){
                    hl.addLast(list1.getFirst());
                    list1.removeFirst();
                }
            }
            if(ml.size==0)
            {
                ml=hl;
                hl=new LinkedList();
            }
            else{
                ml.tail.next=hl.head;
                ml.tail=hl.tail;
                ml.size+=hl.size;
                hl=new LinkedList();
            }
        }
        list1.head=ml.head;
        list1.tail=ml.tail;
        list1.size=ml.size;
      }
      public static Node reverseKGroup(Node head,int k){
        if (head==null) 
        return head;
        Node pre = null;
        Node root = head;
        for (int i = 0; i<k; i++){
            if (head==null) 
            return reverseKGroup(pre,i); 
        Node nxt=head.next;
        head.next=pre;
        pre=head;
        head=nxt;
    }
    root.next=reverseKGroup(head,k);
    return pre;
    }
    public static LinkedList add(LinkedList ll1,LinkedList ll2){
        if(ll2.size>ll1.size){
            return add(ll2,ll1);
        }
        Node rh1=reverse(ll1.head);
        Node rh2=reverse(ll2.head);
        LinkedList ans=new LinkedList();
        
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        // int m=scn.nextInt();
        // int arr2[]=new int[m];
        // for(int i=0;i<m;i++){
        //     arr2[i]=scn.nextInt();
        // }
        LinkedList list1=new LinkedList();
        //LinkedList list2=mergeSort(list1.head, list1.tail); 
        construct(arr,list1);
        //construct(arr2, list2);
        //display(list);
        //System.out.println(kthfromlast(list.head, 3));
        //display(oddevenlist(list.head));
        //display(mergeTwoSortedLists(list1.head, list2.head));
        //kReverse(list1, 2);
        //display(list1.head);
        //display(list2.head);
        display(reverseKGroup(list1.head, 3));
    }    
}
