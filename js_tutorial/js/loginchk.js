document.addEventListener("DOMContentLoaded", function(){
    let userInfo = sessionStorage.getItem("user")
    console.log(userInfo)
    if(userInfo == null || userInfo == undefined){
         alert("로그인이 필요한 서비스입니다.")
         location.href="/login.html"
    }
    userInfo = JSON.parse(userInfo)
    document.getElementById("id").innerHTML = userInfo.miId
    document.getElementById("name").innerHTML = "("+ userInfo.miName +")"
    document.getElementById("logout").addEventListener("click",function(){
         sessionStorage.removeItem("user")
         location.href = "/login.html";
    })
})