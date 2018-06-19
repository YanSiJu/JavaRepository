//当页面加载完毕后获取各个元素 
window.onload = function(){
	 var container = document.getElementById('container');
	 var list = document.getElementById('list');
	 var buttons = document.getElementById('buttons').getElementsByTagName('span');
	 var pre = document.getElementById('prev');
	 var next = document.getElementById('next');
	 var index = 1;
	 var animated = false;
	 var timer;
	 //展现当前图片对应的按钮样式
	 function showButton(){
		 for(var i = 0; i < buttons.length; i++){
			 if(buttons[i].className == 'on'){
				 buttons[i].className = '';
				 break;
			 }
		 }
		 buttons[index-1].className = "on";
	 }
	 //实现图片切换
	 function animate(offset){
		 animated = true;
		 var newleft = parseInt(list.style.left) + offset;
		 var time = 300;// 位移总时间
		 var interval = 10;// 位移间隔时间
		 var speed = offset/(time/interval);// 每一次的位移量
 
		 function go(){
			 if((speed < 0 && parseInt(list.style.left) > newleft) 
					 || (speed > 0 && parseInt(list.style.left) < newleft)){
				 list.style.left = parseInt(list.style.left) + speed + 'px';
				 setTimeout(go,interval);
			 }
			 else{
				 animated = false;
				 list.style.left = newleft + 'px';
				 //当滚到最后一张图的附属图，立刻跳转至真正的最后一张图
				 if(newleft > -170){
					 list.style.left = -510 + 'px'; 
				 }
				//当滚到第一张图的附属图，立刻跳转至真正的第一张图
				 if(newleft < -510){
					 list.style.left = -170 + 'px'; 
				 }
			 }
		 }
		 go();
	 }
	 function play(){
		 timer = setInterval(function(){
			 next.onclick();
		 },510);
	 }
	 function stop(){
		 clearInterval(timer);
	 }
 
	 next.onclick = function(){
		 if(index == 3){
			 index = 1;
		 }
		 else{
			 index += 1;
		 }
		 showButton();
		 if(animated == false){
			 animate(-170);
		 }
	 }
	 pre.onclick = function(){
		 if(index == 1){
			 index = 3;
		 }
		 else{
			 index -= 1;
		 }
		 showButton();
		 if(animated == false){
			 animate(170);
		 }
	 }
 
	 for(var i = 0;i < buttons.length; i++){
		 buttons[i].onclick = function(){
			 if(this.className == 'on'){
				 return;
			 }
			 var myIndex = parseInt(this.getAttribute('index'));
			 var offset = -170 * (myIndex - index);
 
			 index = myIndex;
			 showButton();
			 if(animated == false){
				 animate(offset);
			 }
		 }
	 }
	 //鼠标移动至图片上时停止定时器
	 container.onmouseover = stop;
	 //鼠标离开时开启定时器
	 container.onmouseout = play;
	 //播放
	 play();
 }