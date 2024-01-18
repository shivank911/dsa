class Node{
    constructor(u,w){
        this.u = u;
        this.w = w;
    }
}
class Graph{
    constructor(n){
        this.n = n;
        this.adjList = new Map();
    }
    addVtx(v){
        this.adjList.set(v,[]);
    }
    addEdge(v,u,w){
        this.adjList.get(v).push(new Node(u,w));
        //this.adjList.get(u).push(v);
    }
}
module.exports = {
    solve : function(A,M){
        let G = new Graph(A);
        for(let i =1;i<=A;i++){
            G.addVtx(i);
        }
        for(let i=0;i<M.length;i++){
            G.addEdge(M[i][0],M[i][1],M[i][2]);
        }
        
    }
}