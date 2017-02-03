$(function(){
		
		if(user != ""){
			$(".nav1").css("display", "none");
		}else{
			$(".nav2").css("display", "none");
		}
		
		$(".buy").click(function(){
			var id = $(this).parent().prevAll("#id").text();
			var numFromDB = $(this).parent().prevAll("#num").text();
			
			if (user == "") {
				alert("请先登录");
				return;
			} else {
				var num;
				while (true) {
					num = prompt("请输入购买的数量", "1");
					//alert(parseInt(num));
					if(num == null){
						//用户取消输入
						return;
					}else if((isNaN(parseInt(num))) || parseInt(num) == 0 || parseInt(num) < 0){
						//输入非数字、空、小于0
						alert("请输入正确的购买数量");
						continue;
					}else if(parseInt(num) > parseInt(numFromDB)){
						//输入的数量不正确
						alert("抱歉，库存不足");
						continue;
					}else{
						break;
					}
				}
				window.open("shoppingCommodityServlet?id=" + id + "&num=" + num, "_self");
			}	
		});
		
		$(".search button").click(function(){
			var id = $(this).prev().val();
			window.open("queryCommodityServlet?id=" + id, "_self");		
		});
	})