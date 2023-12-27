// module.exports = { 
//     //param A : array of integers
//     //param B : array of array of integers
//     //return a array of long integer
    
//        prefixSum : function(A){
//         let outputArray = [];
//         let prefixSum = 0;
//         A.map(function (a){
//             prefixSum+=a;
//             outputArray.push(prefixSum);
//         });
//         return outputArray;
//        },
//        rangeSum : function(A, B){
//         let temp = module.exports.prefixSum(A);   
//         let outputArray = [];
//         B.map(function (a){
//             let ans = 0;
//             if(a[0] == 0){
//                 ans = temp[a[1]];
//             }
//             else{
//                 ans = temp[a[1]] - temp[a[0]-1];
//             }
//             outputArray.push(ans);           
//         });
//         console.log(outputArray);
//        }
//    };

// // var rangeSum = require("rangeSum");
// //module.exports.rangeSum([1,2,3,4],[[0,0],[1,2]]);


// module.exports = {
//     prefixSum : function(A){
//         let outputArray = [];
//         let prefixSum = 0;
//         A.map(function (a){
//             prefixSum+=a;
//             outputArray.push(prefixSum);
//         });
//         return outputArray;
//        },
//     solve : function(A){
//         let arr = module.exports.prefixSum(A);
//         let {left,right} = 0;
//         let ans = arr.map((elem,idx)=>{
//             if(idx === 0){
//                 left = 0;
//             }else{
//                 left = arr[idx-1];
//             }
//             right = arr[arr.length-1] - arr[idx];
//             if(left === right){
//                 return idx; 
//             }
//         });
//         if(ans === undefined){
//             return -1;
//         }else{
//             return ans;
//         }
//     }
// }

// //console.log(module.exports.solve([-7, 1, 5, 2, -4, 3, 0]));


// let arr = [1,2,3];
// // console.log(arr.filter((elem,idx)=>{
    
// //     return elem%2===0;
// // }));
// // console.log(arr.reduce((ans,elem,idx)=>{
// //     console.log(elem+" "+idx);
// //     ans+=elem
// //     return ans;
// // },0));



// module.exports = {
//     subArraySum : function(A){
//         let sum = 0;
//         A.map((elem,idx) => {
//             let len = A.length;
//             sum = sum + (elem * (idx+1) * (len-idx));
//         });
//         return sum;
//     }
// }

// console.log(module.exports.subArraySum(arr));


let B = [[1, 2],[4, 1],[2, 4],[3, 4],[5, 2],[1, 3]]
let graph = new Map();
for(let i=1;i<=5;i++)
graph.set(i,[]);
B.map((elem)=>{
    graph.get(elem[0]).push(elem[1]);
});
console.log(graph);
let c = 1;
let k =2;
console.log(c+k);