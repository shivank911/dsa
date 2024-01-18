
class Graph {
    constructor(noOfVertices)
    {
        this.noOfVertices = noOfVertices;
        this.AdjList = new Map();
    }
    addVertex(v){
        this.AdjList.set(v, []);
    }
    addEdge(v, w){
        this.AdjList.get(v).push(w);
        this.AdjList.get(w).push(v);
    }
    printGraph(){
        var get_keys = this.AdjList.keys();
        for (var i of get_keys) {
            var get_values = this.AdjList.get(i);
            var conc = "";
        for (var j of get_values)
        conc += j + " ";        
        console.log(i + " -> " + conc);
        }
    }
 
    // bfs(v)
    // dfs(v)
}


// var g = new Graph(6);
// var vertices = [ 'A', 'B', 'C', 'D', 'E', 'F' ];

// for (var i = 0; i < vertices.length; i++) {
//     g.addVertex(vertices[i]);
// }


// g.addEdge('A', 'B');
// g.addEdge('A', 'D');
// g.addEdge('A', 'E');
// g.addEdge('B', 'C');
// g.addEdge('D', 'E');
// g.addEdge('E', 'F');
// g.addEdge('E', 'C');
// g.addEdge('C', 'F');
// //g.printGraph();




//////////////////////////////////////////////////

// module.exports = { 
//     //param A : array of strings
//     //return an integer
//        dfs : function(A,i,j,visited){
//            visited[i][j]=true;
//            for(let k = 0;k<4;k++){
//                let x = +dx[k] + +i;
//                let y = +dy[k] + +j;
//                if(x >= 0 && x < A.length && y >= 0 && y < A[0].length && !visited[x][y] && A[x][y] == 'X'){
//                    this.dfs(A,x,y,visited);
//                } 
//            }
//        },
       
//        black : function(A){
//            let count = 0;
//            let visited = new Array(A.length);
//            for(let i = 0; i < A.length; i++)
//            {
//                visited[i] = new Array(A[i].length);
//            }
//            for(let i = 0; i < A.length; i++)
//            {
//                for(let j = 0; j < A[i].length; j++)
//                {
//                    visited[i][j] = false;
//                }
//            }
//            for(let i in A){
//                for(let j in A[i]){
//                    if(A[i][j] == 'X' && visited[i][j]!=true){
//                        this.dfs(A,i,j,visited);
//                        count++;
//                    }
//                }
//            }
//            return count;
//        }
       
//    };
//    const dx = [-1,0,1,0];
//    const dy = [0,-1,0,1];
   
//    let A = [ ['X', 'X', 'X'], ['X', 'X', 'X'], ['X', 'X', 'X'] ];
//    console.log(module.exports.black(A));



/////////////////////////////////

// module.exports = { 
//     //param A : integer
//     //param B : integer
//     //param C : integer
//     //param D : integer
//     //param E : array of integers
//     //param F : array of integers
//     //return a strings
//        isValid : function(x,y,A,B,C,D,E,F){
//            if(x<0 || x>A || y<0 || y>B){
//                return false;
//            }else{
//                for(let i = 0;i<C;i++){
//                    if(Math.pow(E[i]-x,2)-Math.pow(F[i]-y,2)<=D*D){
//                        return true;
//                    }
//                }
//                return false;
//            }
//        },
//        dfs : function(i,j,vis,A,B,C,D,E,F){
//          vis[i][j] = true;
//          for(let k=0;k<8;k++){
//              let x = +dx[k] + +i;
//              let y = +dy[k] + +j;
//              if(this.isValid(x,y,A,B,C,D,E,F)){
//                  this.dfs(x,y,vis);
//              }
//          }
//        },
//        solve : function(A, B, C, D, E, F){
//            let vis = new Array(A+1);
//            for(let i =0; i <A+1;i++){
//                vis[i] = new Array(B+1);
//            }
//            for(let i = 0;i<A+1;i++){
//                for(let j =0;j<B+1;j++){
//                    vis[i][j] = false;
//                }
//            }
//            this.dfs(0,0,vis,A,B,C,D,E,F);
//            if(vis[A][B]){
//             return "YES";
//            }else{
//             return "NO";
//            }
//        }
//    };
   let dx = [-1, 0, 1, 0, -1, 1, -1, 1];
   let dy = [0, -1, 0, 1, -1, 1, 1, -1];
   module.exports = { 
    //param A : array of array of integers
    //return an integer
       dfs : function(A,i,j){
           A[i][j]=0;
           for(let k=0;k<8;k++){
               let x = +dx[k] + +i;
               let y = +dy[k] + +j;
               if(x>=0 && x<A.length  && y >=0 && y<A[i].length && A[i][j]==1){
                 this.dfs(A,x,y);
               }
           }
       },
       solve : function(A){
           let count = 0;
           for(let i = 0;i<A.length;i++){
               for(let j=0;j<A[i].length;j++){
                   if(A[i][j] === 1){
                       count++;
                      this.dfs(A,i,j);
                       
                   }
               }
           }
           return count;
       }
   };
   let A = [[0,0,1,0,1,0,1,1,1],[0,1,0,0,1,1,1,0,1]];
   console.log(module.exports.solve(A));
   console.log(A);
  
module.exports = {
    solve : function(A,B,C,D){
        let G = new Graph(A);
        
    }
}