function showDetail() { 
//����
  var bgObj=document.getElementById("bgDiv");
  
  bgObj.style.width = "100%";
  bgObj.style.height = "3900px";
//���崰��
  var msgObj=document.getElementById("msgDiv");
  msgObj.style.marginTop = -75 +  document.documentElement.scrollTop + "px";
//�ر�
  document.getElementById("msgShut").onclick = function(){
  bgObj.style.display = msgObj.style.display = "none";
  }
  msgObj.style.display = bgObj.style.display = "block";
}