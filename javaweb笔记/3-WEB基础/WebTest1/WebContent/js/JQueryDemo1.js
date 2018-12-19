//图片的左右滑动
$('#d1 img').hover(
	function(){
		$(this).animate(
			{'margin-left':'-100px'}
		,300);	
	},		
	function(){
		$(this).animate(
			{'margin-left':'0px'}
		,300);	
	}		
);
//图片的单击切换的方法1
var i = 0;
$('#d2 img').click(
	function(){
		if(i%2){
			this.src='images/1.jpg';
		}else{
			this.src='images/2.jpg';
		}
		i++;
});
//点击题目显示隐藏内容
$('h2').click(
	function(){
		$(this).next().toggle(1000);
	}
);

