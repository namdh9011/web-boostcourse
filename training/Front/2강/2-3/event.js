var el = document.querySelector(".outside");

el.addEventListener("click", function(e){
    console.log("clicked!!");
    console.log("clicked!!", e);    //function에 e 를 붙여주면 click의 정보가 나옴.
    
    
    
    var target = e.target;          //event객체의 각종 정보를 확인할 수 있다.
    console.log(target.className, target.nodeName); 
    console.log(target.innerText); 
    debugger;               //브라우저에서 debugger에 걸리면 콘솔에서 event의 객체들을 확인할 수 있다.
});
