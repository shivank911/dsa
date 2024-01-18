// class Graph{
//     constructor(n){
//         this.n = n;
//         this.adjList = new Map()
//     }
//     addVtx(v){
//         this.adjList.set(v,[]);
//     }
//     addEdge(v,u){
//         this.adjList.get(v).push(u);
//     }
//     printGraph(){
//         var get_keys = this.adjList.keys();
//         for (var i of get_keys) {
//             var get_values = this.adjList.get(i);
//             var conc = "";
//             for (var j of get_values)
//             conc += j + " ";        
//             console.log(i + " -> " + conc);
//         }
//     }
// }
// let ans = [];
// module.exports = { 
//  //param A : integer
//  //param B : array of array of integers
//  //return a array of integer
    
    
// 	solve : function(A, B){
//         let G = new Graph(A+1);
//         for(let i = 1;i<=A;i++){
//             G.addVtx(i);
//         }
//         for(let k = 0;k<B.length;k++){
//             G.addEdge(B[k][0],B[k][1]);
//         }
//         G.printGraph();
//         let vis = new Array(A+1);
//         for(let i =0;i<A+1;i++){
//             vis[i] = false;
//         }
//         let que = [];
//         que.push(1);
//         vis[1]=true;
//         ans.push(1);
//         while(que.length>0){
//             let node = que.shift();
//             for(let i of G.adjList.get(node)){
//                 if(!vis[i]){
//                     que.push(i);
//                     ans.push(i);
//                 }
//             }
//         }
//         return ans;
// 	}
// };
// let arr = [[1, 5],[6, 3],[6, 1],[5, 1],[5, 6],[3, 4],[4, 2]];
// console.log(module.exports.solve(6,arr));
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
    addEdge(v,u){
        this.adjList.get(v).push(u);
        this.adjList.get(u).push(v);
    }
}
// module.exports = { 
//  //param A : integer
//  //param B : array of array of integers
//  //return an integer
//     dfs : function(G,i,vis){
//         let list = G.adjList.get(i);
//         if(list.length>0){
//             list.forEach((nbr)=>{
//                 if(vis[nbr] === vis[i]){
//                     return false;
//                 }
//                 vis[nbr] = 1 - vis[i];
//                 return this.dfs(G,nbr,vis);
//             });
//         }
//         return true;
//     },
// 	solve : function(A, B){
//         let G = new Graph(A);
//         let vis = new Array(A);
        
//         for(let i=0;i<A;i++){
//             G.addVtx(i);
//             vis[i] = -1;
//         }
//         for(let  j=0;j<B.length;j++){
//             G.addEdge(B[j][0],B[j][1]);
//         }
//         for(let node=0;node<A;node++){
//             if(vis[node]==-1){
//                 vis[node] = 0;
//                 if(!this.dfs(G,node,vis)){
//                     return 0;
//                 }
//             }
//         }

//         return 1;
// 	}
// };


// module.exports = { 
//     //param A : integer
//     //param B : array of array of integers
//     //return a array of integers
//        solve : function(A, B){
//         let ans = [];
//         let G = new Graph(A+1);
//         for(let i=0;i<A+1;i++){
//             G.addVtx(i);
//         }
//         for(let i=0;i<B.length;i++){
//             G.addEdge(B[i][0],B[i][1]);
//         }
//         let indegree = new Array(A+1).fill(0);
        
//         let keys = G.adjList.keys();
//         for(let j of keys){
//             for(let i of G.adjList.get(j)){ 
//                 indegree[i]++;
//             }
//         }console.log(indegree);
//         //console.log(G);
//         let queue = [];
//         for(let  i=1;i<A+1;i++){
//             if(indegree[i] === 0){
//                 queue.push(i);
//             }
//         }
//         while(queue.length>0){
//             let node = queue.shift();
//             ans.push(node);
//             for(let i of G.adjList.get(node)){
//                 indegree[i] = indegree[i]-1;
//                 if(indegree[i] === 0){
//                     queue.push(i);
//                 }
//             }

//         }
//         console.log(G);
        
//         return ans;
//     }
// };


// module.exports = {
//     dfs : function(G,i,color,vis){
//         vis[i] = color;
//         G.adjList.get(i).forEach(j => {
//             if(vis[j] === -1){
//                 this.dfs(G,j,color,vis);
//             }
//         });
//     },
//     solve : function(A,B,C,D){
//         let G = new Graph(A+1);
//         for(let  i=1;i<=A;i++){
//             G.addVtx(i);
//         }
//         for(let i=0;i<C.length;i++){
//             G.addEdge(C[i][0],C[i][1]);
//         }
//         let color = 0;
//         let batchStrength = [];
//         let vis = new Array(A+1).fill(-1);
//         for(let i=1;i<=A;i++){
//             if(vis[i]==-1){
//                 this.dfs(G,i,color,vis);
//             }
//             let sum = 0;
//             for(let j = 1;j<=A;j++){
//                 if(vis[j] === color){
//                     sum+=B[j-1];
//                 }
//             }
//             batchStrength.push(sum);
//             color++;
//         }
//         console.log(G);
//         return batchStrength.filter((elem)=>{
//             return elem>=D;
//         }).length;
//     }
// }

// module.exports = {
//     solve : function(A,B,C){
//         let G = new Graph(A+1);
//         for(let i=1;i<=A;i++){
//             G.addVtx(i);
//         }
//         for(let i=0;i<B.length;i++){
//             G.addEdge(B[i],C[i]);
//         }
//         let indegree = new Array(A+1).fill(0);
//         for(let  i=1;i<=A;i++){
//             let nbrs = G.adjList.get(i);
//             nbrs.forEach((nbr)=>{
//                 indegree[nbr]++;
//             });
//         };
//         let que = [];
//         let vis = new Array(A+1).fill(false);
//         for(let  i=1;i<=A;i++){
//             if(indegree[i]==0){
//                 que.push(i);
//             }
//         }
//         let count = 0;
//         while(que.length>0){
//             let node = que.shift();
//             let nbrs = G.adjList.get(node);
//             count++;
//             nbrs.forEach((nbr)=>{
//                 indegree[nbr] = indegree[nbr]-1;
//                 if(indegree[nbr] == 0){
//                     que.push(nbr);
//                 }
//             });
//         }
//         return count===A?1:0;
//     }
// }

let A = 20;
let B = [[1,5],[4,6],[18,3],[4,5],[15,9],[15,4]];
let C = [[13,20],[7,20],[8,19],[13,7],[13,8],[2,19]];


module.exports = {
    fastPower : function(val,base,mod){
        if(val == 0)
            return 1;
        let temp;
        if(val % 2 == 0){
            temp = this.fastPower(val/ 2, base, mod);
            temp = (temp % mod * temp % mod) % mod;
        }else{
            temp = base % mod;
            temp = (temp * this.fastPower(val - 1, base, mod) % mod) % mod;
        }
        return parseInt((temp + mod) % mod);
    },
    bfs : function(G,vis,i){
        let que = [];
        que.push(i);
        while(que.length>0){
            let node = que.shift();
            let nbrs = G.adjList.get(node);
            nbrs.forEach((nbr)=>{
                if(!vis[nbr]){
                    vis[nbr] = true;
                    que.push(nbr); 
                }
            })
        }
    },
    solve : function(A,B,C){
        let G = new Graph(A+1);
        for(let i=1;i<=A;i++){
            G.addVtx(i);
        }
        let walk = new Set();
        for(let  i=0;i<B.length;i++){
            walk.add(B[i][0]);
            walk.add(B[i][1]);
            G.addEdge(B[i][0],B[i][1]);
        }
        for(let i=0;i<C.length;i++){
            if(walk.has(C[i][0]) || walk.has(C[i][1])){
                return 0;
            }
            G.addEdge(C[i][0],C[i][1]);
        }
        
        let vis = new Array(A+1).fill(false);
        let groups = 0;
        for(let i=1;i<=A;i++){
            if(!vis[i]){
                groups++;
                this.bfs(G,vis,i);
            }
        }
        let mod = 1000000007;
        return this.fastPower(groups,2,mod);
    }
}

console.log(module.exports.solve(A,B,C));