function ajax(data) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function() {
        console.log(this.responseText);
    });    
    oReq.open("GET", "./ajax.txt");//parameter를 붙여서 보낼수있음. 
    oReq.send();
}