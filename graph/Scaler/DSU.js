class Graph{
    constructor(noOfNodes){
        this.noOfNodes = noOfNodes;
        this.adjList = new Map(noOfNodes);
    }
    addVtx(v){
        this.adjList.set(v,[]);
    }
    addEdge(v,u){
        this.adjList.get(v).push(u);
        //this.adjList.get(u).push(v);
    }
};
let parent = [];
let A,B,C,D,E;

module.exports = {
    root : function(x){
        while(parent[x]!=x){
            x = parent[x];
        }
        return x;
    },
    union(x,y){
        let px = this.root(x);
        let py = this.root(y);
        if(px === py){
            return false;
        }
        parent[px] = py; // parent[py] = px;
        return true;
    },
    solve : function(A,B){
        let G = new Graph(A);
        for(let  i=1;i<=A;i++){
            G.addVtx(i);
        }

    }
}