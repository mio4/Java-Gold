  /*
	辅助例子
	1,自动重置
	2,给元素添加动画
  */
  
  $(document).ready(function(){
       //手动重置页面元素
	  $("#reset").click(function(){
		  $("*").removeAttr("style");
		   $("div[class=none]").css({"display":"none"}); 
	  });
	  //判断是否自动重置
	   $("input[type=button]").click(function(){
		  if($("#isreset").is(":checked")){
			   $("#reset").click();
		   }
	  });
      //给id为mover的元素添加动画.
	   function animateIt() {
		  $("#mover").slideToggle("slow", animateIt);
	    }
		animateIt();
 })