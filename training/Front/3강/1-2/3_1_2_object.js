var myFriend = {
    key:"value", 
    addition:[
        {name:"codesquad"},
        {age:2}
    ]
};

console.log(myFriend.key);
//console.log(myFriend[key]);   //error
console.log(myFriend["key"]);

console.log(myFriend.addition[0].name);

for(key in myFriend){
    console.log(myFriend[key]);
}

console.log(Object.keys(myFriend));
Object.keys(myFriend).forEach(function(v){
    console.log(myFriend[v]);
});

