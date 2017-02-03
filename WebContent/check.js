/**
 * 注册的信息是否符合规范
 * 
 * @param f
 * @returns {Boolean}
 */
function registCheck(f) {
	// 先对提示信息初始化
	document.getElementById("nameinfo").innerHTML = "";
	document.getElementById("passwordinfo").innerHTML = "";
	document.getElementById("password2info").innerHTML = "";
	
	var regName = /^[a-zA-Z][a-zA-Z0-9_]{1,9}$/g;
	var regPassword = /[\u4e00-\u9fa5]/g;
	var name = f.username.value;
	var password = f.password.value;
	var password2 = f.password2.value;

	if (name == "") {
		document.getElementById("nameinfo").innerHTML = "<font color='red'>请输入用户名</font>";
		return false;
	} else if (!regName.test(name)) {
		document.getElementById("nameinfo").innerHTML = "<font color='red'>以字母开头，字母数字或下划线组合</font>";
		return false;
	} else if (password == "") {
		document.getElementById("passwordinfo").innerHTML = "<font color='red'>请输入密码</font>";
		return false;
	} else if (regPassword.test(password)) {
		document.getElementById("passwordinfo").innerHTML = "<font color='red'>请不要输入汉字或空格</font>";
		return false;
	} else if (password != password2) {
		document.getElementById("password2info").innerHTML = "<font color='red'>两次密码不一致</font>";
		return false;
	}
}

function CommodityInfoCheck(f) {
	// 先对提示信息初始化
	document.getElementById("idInfo").innerHTML = "";
	document.getElementById("nameInfo").innerHTML = "";
	document.getElementById("priceInfo").innerHTML = "";
	document.getElementById("numInfo").innerHTML = "";
	//alert("111");
	var id = f.id.value;
	var name = f.name.value;
	var price = f.price.value;
	var num = f.num.value;

	// 价格格式正确，可以有一个小数点或没有，开头不能为0
	var priceReg = /^[1-9]\d{0,}(\.\d+)?$/g;
	// 数量格式正确，都是数字
	var numReg = /^(([1-9]\d*)|0)$/g;
	// id格式正确，都是数字
	var idReg = /^[0-9]*$/g;
	// 正确的商品名称,开头不能是空格
	var nameReg = /^\s+.*\s+$/g;

	//alert(num == "" || !numReg.test(num));
	
	
	if (id == "" || !idReg.test(id)) {
		document.getElementById("idInfo").innerHTML = "<font color='red'>请输入正确的商品编号</font>";
		return false;
	} else if ((name == "") || (nameReg.test(name))) {
		document.getElementById("nameInfo").innerHTML = "<font color='red'>请输入正确的商品名称</font>";
		return false;
	} else if ((price == "") || (!priceReg.test(price))) {
		document.getElementById("priceInfo").innerHTML = "<font color='red'>请输入正确的商品价格</font>";
		return false;
	} else if ((num == "") || (!numReg.test(num))) {
		document.getElementById("numInfo").innerHTML = "<font color='red'>请输入正确的商品库存</font>";
		return false;
	}
}