	var index = 1;
	
	layui.use('element', function(){
		var element = layui.element;
	});
	
	function show(){
		var a = ['ITS MY LIFE','MY PASSION','MY LIFE STYLE'];
		$('font:first-child').fadeOut(0);
	    $('font:first-child').fadeIn(1500);
		$('font:first').html(a[index]);
	    index++;
	    if(index>2){
	    	index=0;
	    }
	}
	$(function(){
		//定时替换小标题内容
		setInterval(show,4000);
	
		//实现加载div淡入效果
		$(".layui-col8").hide();
		$(".layui-col9").hide();
		$(".layui-col23").hide();
		$(".layui-col24").hide();	
		var content2_height = $("#content2").offset().top;
		var content4_height =	$("#content4").offset().top;
		$(window).scroll(function(){
			var this_scrollTop = $(this).scrollTop();
			if(this_scrollTop>parseFloat(content2_height)*(0.7)){
				$(".layui-col8").fadeIn(1000);
				$(".layui-col9").fadeIn(1000);		
			}
			if(this_scrollTop>parseFloat(content4_height)*(0.8)){
				$(".layui-col23").fadeIn(1000);
				$(".layui-col24").fadeIn(1000);				
			}
		});
	});
	
	$('li').click(function(){
		var liindex =parseInt($(this).index())+1;
		var id = "#content"+liindex;
		$("html,body").animate({scrollTop:$(id).offset().top},1000);
	})