var a = [1,2,3,"hello",null,true,[{1:0}]];

console.log(a.length);      //7

var a = [4];
a[1000] = 3;    
console.log(a.length);  //1001
console.log(5[500]);    //undefined

var a =[4];
a.push(5);
console.log(a);     //[4,5]

[1,2,3,4].indexOf(3);   //2
[1,2,3,4].join();       //"1,2,3,4"
[1,2,3,4].concat(2,3);  //[1,2,3,4,2,3]

var origin = [1,2,3,4];
var changedArray = [...origin,2,3];     //새로운 문법

//foreach
changedArray.forEach(function(v,i,o){
    console.log(v);
});


var fun = function(v,i,o){
    console.log(v);
};

changedArray.forEach(fun);

//map
var mapped = changedArray.map(function(v) {
    return v * 2; //changedArray의 원소를 돌면서, 값을 변경 시킨 후에 새로운 배열로 만들어서 변환한다.
});

console.log(mapped, changedArray);