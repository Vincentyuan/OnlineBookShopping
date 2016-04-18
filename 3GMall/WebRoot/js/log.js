function showDetail() { 
//背景
  var bgObj=document.getElementById("bgDiv");
  
  bgObj.style.width = "100%";
  bgObj.style.height = "3900px";
//定义窗口
  var msgObj=document.getElementById("msgDiv");
  msgObj.style.marginTop = -75 +  document.documentElement.scrollTop + "px";
//关闭
  document.getElementById("msgShut").onclick = function(){
  bgObj.style.display = msgObj.style.display = "none";
  }
  msgObj.style.display = bgObj.style.display = "block";
}