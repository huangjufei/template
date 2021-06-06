前端 :
document.getElementById("some id");这个方法是 HTML DOM 中定义的;
DOM (Document Object Model)(文档对象模型)是用于访问 HTML 元素的正式 W3C 标准;

------------
如需使用外部文件,请在 <script> 标签的 "src" 属性中设置该 .js 文件:
<script src="myScript.js"></script>
-----------
js变量需要通过var 申明,但在function()函数中就可以不用申明,这时就变为全局变量
-----------
JavaScript 数据类型
值类型(基本类型):字符串(String),数字(Number),布尔(Boolean),对空(Null),未定义(Undefined),Symbol;
引用数据类型:对象(Object),数组(Array),函数(Function);
-----------
JavaScript 对象
对象由花括号分隔;在括号内部,对象的属性以名称和值对的形式 (name: value) 来定义;属性由逗号分隔
var person={firstname:"John", lastname:"Doe", id:5566};
-----------
对象属性有两种寻址方式:
实例
name=person.lastname;
name=person["lastname"];
------------------
js 的函数参数,可以和调用的个数不一致;
------------
全局 JavaScript 变量
在函数外声明的变量是全局变量,网页上的所有脚本和函数都能访问它;
---------------
$(function(){
// do something
});
其实这个bai就是jq ready()的简写,他等价du于:
$(document).ready(function(){
//do something
})
//或者下面这个方法,jQuer的默认参数是:“document”;
$().ready(function(){
//do something
})
这个就是jq ready()的方法就是Dom Ready,他的作用或者意义就是:在DOM加载完成后就可以可以对DOM进行操作;
-------------
JS中的window对象

所有浏览器都支持window对象;他表示浏览器窗口;
$(function){
	window.rolleId = "123";
	var na = "a";//它们两个都是全局变量;
}


所有JavaScript全局对象,函数以及变量均自动成为window对象的成员;
全局变量是window对象的属性
全局函数是window对象的方法
--------------------
在 JavaScript 中对象 使用 名字作为索引;(本身是不支持数组名字索引的只是转为了对象)

如果你使用名字作为索引,当访问数组时,JavaScript 会把数组重新定义为标准对象;

执行这样操作后,数组的方法及属性将不能再使用,否则会产生错误:

实例
var person = [];
person["firstName"] = "John";
person["lastName"] = "Doe";
person["age"] = 46;
var x = person.length;         // person.length 返回 0
var y = person[0];             // person[0] 返回 undefined
--------------------

if (myObj !== null && typeof myObj !== "undefined") //错误的判断方式
	
正确的方式是我们需要先使用 typeof 来检测对象是否已定义:

if (typeof myObj !== "undefined" && myObj !== null) 
--------------------
程序块作用域
在每个代码块中 JavaScript 不会创建一个新的作用域,一般各个代码块的作用域都是全局的;

以下代码的的变量 i 返回 10,而不是 undefined:

实例
for (var i = 0; i < 10; i++) {
    // some code
}
return i;//返回10
+++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++
jQuery 语法

//jquery 中文手册
https://jquery.cuishifeng.cn/
主要分 基本 - 层级 - 基本筛选器 等这样来得到想到dom元素

jquery 本质就是一个函数,得到的就是dom数组

$ == window.$ == jQuery //源码可以看到

基础语法: $(selector).action()

美元符号定义 jQuery
选择符(selector)"查询"和"查找" HTML 元素
jQuery 的 action() 执行对元素的操作
--------------------
jQuery 入口函数:
为了防止文档在完全加载(就绪)之前运行 jQuery 代码即在 DOM 加载完成后才可以对 DOM 进行操作;
$(document).ready(function(){
   // 开始写 jQuery 代码...
});

window.onload = function () {
    // 执行代码
}

或jquery写法 上面等于下面
$(function(){
   // 开始写 jQuery 代码...
});

jquery 和 JavaScript 得到的是不同对象.
--------------------
jQuery 入口函数与 JavaScript 入口函数的区别:

 jQuery 的入口函数是在 html 所有标签(DOM)都加载之后,就会去执行;
 JavaScript 的 window.onload 事件是等到所有内容,包括外部图片之类的文件加载完后,才会执行;
--------------------
jQuery load() 方法是简单但强大的 AJAX 方法;

load() 方法从服务器(本地)加载数据,并把返回的数据放入被选元素中(页面会被直接回填数据);

语法:
$(selector).load(URL,data,callback);
必需的 URL 参数规定您希望加载的 URL;
可选的 data 参数规定与请求一同发送的查询字符串键/值对集合;
可选的 callback 参数是 load() 方法完成后所执行的函数名称;
--------------------
语法:
$.post(URL,data,callback);
必需的 URL 参数规定您希望请求的 URL;
可选的 data 参数规定连同请求发送的数据;
可选的 callback 参数是请求成功后所执行的函数名;

下面的例子使用 $.post() 连同请求一起发送数据:
实例
$("button").click(function(){
    $.post("/try/ajax/demo_test_post.php",
    {
        name:"菜鸟教程",
        url:"http://www.runoob.com"
    },
    function(data,status){
        alert("数据: \n" + data + "\n状态: " + status);
    });
});
--------------------
<script type="text/javascript" src="script/jquery-1.7.2.js"></script>
<script type="text/javascript">
//删除操作:根据询问返回值来确定是否需要发送 超链接
	$(function(){
		$(".delete").click(function(){
			var content = $(this).parent().parent().find("td:eq(1)").text();
			var flag = confirm("确定要删除名字为"+ content +"的信息吗?");
			return flag;
		})
	});
</script>
----------------------------------------------

如果不能写在HTML内容的后面,则需要在页面加载完成后再初始化.
<script type="text/javascript">
window.onload = function() {
  ...//javaScript防止页面没有初始化就执行javaScript代码
}
</script>

//jquery 防止页面没有初始化就执行javaScript代码
$(document).ready(function(){
	alert("作用和window.onload一样")
})
+++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++