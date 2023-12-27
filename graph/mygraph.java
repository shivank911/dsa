// import java.util.*;
// public class mygraph {
//     public static class Edge{
//         int u;
//         int v;
//         int w;
//         Edge(int u,int v,int w){
//             this.u=u;
//             this.v=v;
//             this.w=w;
//         }
//     }
//     public static void addEdge(ArrayList<Edge>[] graph,int u,int v,int w){
//         graph[u].add(new Edge(u,v,w));
//         graph[v].add(new Edge(v,u,w));
//     }
//     public static void display(ArrayList<Edge>[] graph,int v){
//         for(int i=0;i<v;i++){
//             System.out.print(i+"->");
//             for(Edge e:graph[i]){
//                 System.out.print("("+e.v+","+e.w+")");
//             }
//             System.out.println();
//         }
//     }
//     public static boolean hasPath(ArrayList<Edge> graph[],int u,int v,boolean[] vis){
//         if(u==v)
//         return true;
//         boolean res=false;
//         vis[u]=true;
//         for(Edge e:graph[u]){
//             if(vis[e.v]!=true){
//                 res=res || hasPath(graph, e.v, v, vis);
//             }
//         }
//         return res;
//     }
//     public static int findEdge(ArrayList<Edge>[] graph,int u,int v){
//         for(int i=0;i<graph[u].size();i++){
//             Edge e=graph[u].get(i);
//             if(e.v==v)
//             return i;
//         }
//         return -1;
//     }
//     public static int countallpaths(ArrayList<Edge>[] graph,int src,int dest,boolean[] vis,String psf){
//         if(src==dest){
//             System.out.println(psf+dest);
//             return 1;
//         }
//         int count=0;
//         vis[src]=true;
//         for(Edge e:graph[src]){
//             if(!vis[e.v])
//             count+=countallpaths(graph, e.v, dest, vis, psf+src);
//         }
//         vis[src]=false;
//         return count;
//     }
//     public static void preorder(ArrayList<Edge> graph[],int src,int wsf,String psf,boolean[] vis){
//         System.out.println(src+"->"+(psf+src)+"@"+wsf);
//         vis[src]=true;
//         for(Edge e:graph[src]){
//             if(vis[e.v]!=true){
//                 preorder(graph, e.v, wsf+e.w, psf+src, vis);
//             }
//         }
//         vis[src]=false;
//     }
//     public static void postorder(ArrayList<Edge> graph[],int src,int wsf,String psf,boolean[] vis){
//         vis[src]=true;
//         for(Edge e:graph[src]){
//             if(vis[e.v]!=true){
//                 preorder(graph, e.v, wsf+e.w, psf+src, vis);
//             }
//         }
//         System.out.println(src+"->"+(psf+src)+"@"+wsf);
//         vis[src]=false;
//     }
//     public static class pair{
//         int heavypath;
//         String psf="";
//         pair(int heavyPath,String psf){
//             this.heavypath=heavyPath;
//             this.psf=psf;
//         }
//     }
//     public static pair heavyPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] vis){
//         if(src==dest){
//             return pair(0,src+"");
//         }
//         vis[src]=true;
//         pair myAns=new pair(0,"");
//         for(Edge e:graph[src]){
//             pair recans=heavyPath(graph, src, dest, vis);
//             if(!vis[src]){
//                 if(recans.heavypath!=-1 && recans.heavypath+e.w>myAns.heavypath){
//                     myAns.heavypath=recans.heavypath+e.w;
//                     myAns.psf=recans.psf+src;
//                 }
//             }
//         }

//     }
//     public static void main(String[] args) {
//         Scanner scn=new Scanner(System.in);
//         int v=7;
//         ArrayList<Edge>[] graph=new ArrayList<>[v];
//         for(int i=0;i<v;i++){
//             graph[i]=new ArrayList<>();
//         }
//         addEdge(graph, 0, 1, 10);
//         addEdge(graph, 0, 3, 10);
//         addEdge(graph, 1, 2, 10);
//         addEdge(graph, 2, 3, 40);
//         addEdge(graph, 3, 4, 2);
//         addEdge(graph, 4, 5, 2);
//         addEdge(graph, 4, 6, 8);
//         addEdge(graph, 5, 6, 3);

//         addEdge(graph, 0, 6, 3);
//         boolean vis[]=new boolean[v];

//         // display(graph, v);
//         // System.out.println(hasPath(graph, 0, 6, vis));
//         //System.out.println(countallpaths(graph, 0, 6, vis, ""));
//         preorder(graph, 0, 0, "", vis);
//     }

// }
