
要求:每个知识点如果你讲不清楚,就一定没掌握;那么就请一个一个知识的去屡屡;

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
jdk 里包含开发和运行环境,jre 只是运行环境



java数据类型分为: 基本数据类型 和 引用数据类型

								数据类型分
									|
				基本数据类型         			引用数据类型
					 |							|
			数值型,		字符型,布尔型            String,类class,接口interface,数组
			|		  		|		|
	整数(4)和浮点类型(2) char(1) boolean(1)
	|			|
byte,short,int,long;float,double

基础类型一共8个分为数值6个和字符和布尔；数值又分为整数4个浮点2个
-------------------------------------

数组的各个类型的初始化值是不一样的(根据类型判断值)

1,整数类型默认初始化是0;
2,浮点类型默认初始化值是0.0;
3,char 字符默认初始化为 ""
4,boolean 默人初始化为 false
5,引用数据类型 始化值为 null; 

orcle云
feijuhuang
feijuhuang@gmail.com
--------------------------------------
重点:
引用类型是地址传递,基本数据类型是值传递;

举例:
public static void main(String[] args) {
	int a = 1;
	int[] b = {1,2};
	compare(a,b);
	System.out.println(a);
	System.out.println(b[0]);
	
}

public static void compare(int a,int[] b) {
	a = 2;
	b[0] = 2;
}

输出:1和2

过上面的分析我们可以得出以下结论：

1,基本数据类型传值，对形参的修改不会影响实参；
2,引用类型传引用，形参和实参指向同一个内存地址（同一个对象），所以对参数的修改会影响到实际的对象。
3,但 String, Integer, Double等包装类型，可以理解为传值，最后的操作不会修改实参对象。

https://blog.csdn.net/Norte_L/article/details/80250057
-------------------------------------------------------
下面是java8源码:
首先:
一个字节占8位是规范.

boolean(1bit) < byte(1byte) < short,char(2byte) < float,int(4byte) < double,long(8byte)

因为java规范了如一个int占4个字节,一个byte一个字节;所以就确定了占几位,那么最大的数和最小数就自然出来了.


public static final byte   MIN_VALUE = -128;(1个字节,最高位是符号位1000,0000)
public static final byte   MAX_VALUE = 127;(1个字节,最高位是符号位0111,1111)

//Character最大值就65535(2乘16次就等于65535)(4个F,1F等于站4位(计算机只有0和1),4个F等于站16位,所以它是2个字节;
public static final char MAX_VALUE = '\uFFFF';
public static final char MIN_VALUE = '\u0000';

public static final short   MIN_VALUE = -32768;(2个字节)
public static final short   MAX_VALUE = 32767;

public static final int   MIN_VALUE = 0x80000000;(4个字节,最高位是符号位是1)	
public static final int   MAX_VALUE = 0x7fffffff; (4个字节,32位;最高位是0)

public static final long MIN_VALUE = 0x8000000000000000L;(明显是8个字节,是int的2被)
public static final long MAX_VALUE = 0x7fffffffffffffffL;

-----------------------------------------

1,System.out.println('A'+'A');//打印130(65+65),char类型相加会被当做字符值来做运算.
2,System.out.println("a"+'A');//打印aA,只要和""号的字符串运算,都变成两段字符串连接到一起

int i = 12; 
斜杠前是被除数
3,System.out.println(i/5); //打印2 ,因为是i是int类型是整数

---------------------------------------------------------------

格式:
switch(变量){
	
	case 值1：
		//添加业务逻辑
	case 值2：
		//添加业务逻辑
	break;
	
	default:
	break;
}

规则: 
1,case后只能填写变量值,不能填写范围
2,default 是可以省略的.并且位置是灵活的,但是通常放在 case 语句的后面.(作用像 else)
3,一旦满足某个case语句,则进入执行操作,直到-遇到 break 程序才会终止或走完.

建议:
若要判断的条件满足 switch 变量的数据类型,且值不多的情况下,建议选择 switch -case.

/**
 * switch 如何使用?
 * 1,只要没有遇到break 就会继续执行,和if语句不一样
 * 2,default 效果好比else 一样,都不满足时执行
 */
public class Test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("请输出成绩");
		int score = s.nextInt();	
		char tag;		
		switch (score / 10) {
		case 9:
		case 8:
			tag = 'a';
			break;
		case 7:
		case 6:
			tag = 'b';
			break;
		default:
			tag = 'c';
			break;
		}
		System.out.println("你的成绩等级为:"+tag);
	}
}

----------------------------------------------
break 和 continue 在循环中的区别?

循环中使用 break 是结束 当前 循环.
循环中使用 continue 是结束 当次 循环.  
break 和 continue  语句后面不能直接跟语句,因为不会执行,编译不能通过
---------------------------
for(int j=0; j<10; j++){	
	if(j % 4 == 0){	
		break;//break不会有任何输出,0%4等于0 直接就结束了循环
			//continue;//打印1235679
	}
	System.out.print(j);			
}
----------------------------------------------
/**
 * 需求：找出1-100中所有的质数(又叫素数)
 * 所谓质数就是 ：其含义就是除了数字1和本身之外不能被其他任何的数字除尽
 */	
	public static void main(String[] args) {	
		System.out.println(	getPrimeNumberToN(100));
		
	}
	   private static List<Integer> getPrimeNumberToN(int n) {
	        List<Integer> result = new ArrayList<>();//保存质数
			
	        for (int i = 2; i < n + 1; i++) {
	            if (isShuSu(i)) {
					//只有返回true时才添加到集合中
	                result.add(i);
	            }
	        }
	        return result;
	   }
	   
	/**
	 *判断一个数是不是素数：只能被1和本身整除
     * 说明：从2开始循环递增和传进来的值取模，不需要到n，也就是循环条件是 < n 就可以，
     * 这之间只要被整除了，那么他就不是素数了
	 */
	public static boolean isShuSu(int n) {
		for (int i = 2; i < n; i++) {
			//如果取模等于0就说明不是质数（素数），就返回flase
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
---------------------------------------------------------
源码 反码 补码

所有数字在计算机底层都以二进制形式存在.
计算机以补码的形式保存所有的整数.
正数的原码、反码、补码都相同

原码：将一个数值换成二进制数
反码：对原码按位取反,只是最高位(符号位)确定为1.(正数是0,负数是1)
补码: 计算机最后保存的;


负数的补码其实就是正数转2进制后,再加1，最后的前面全部补1
比如: -128
0111,1111 = 127
1000 0000 = -128
假如 是64位电脑
前面在加56个1,在把1000 000;刚好64位;计算器点十进制刚好是-128


UTF-8编码：一个英文字符等于一个字节，一个中文（含繁体）等于三个字节。
Unicode编码：一个英文等于两个字节，一个中文（含繁体）等于两个字节。

1B(byte,字节)= 8 bit
1KB(Kibibyte,1千字节)=1024B（1024字节）= 2^10 B；
1MB(Mebibyte,兆字节,百万字节,简称“兆”)=1024KB=2^20 B;

一兆等于多少字节?
1024*1024

注意:兆下面是千字节不是字节;

一个字节(byte) 由8个 bit 组成 -128到+127
最大正数 是:127 用 0 1 1 1 1 1 1 1;//127的 源码反码补码都是它
127 =				64 32 16 8 4 2 1;
						
公式 =			2^6	2^5	2^4	2^3	2^2	2^1	1;

最大负数是128(其实-128是从正的127转过去的)
0111 1111
1000 0000
然后前面加56个1



一个10进制数字怎么转为2进制?
每次除以2，记下余数，直到商小于2，然后按相反循序写出来就是结果。
相当于除2求余
如:
23/2=商11（余1）
11/2=商5（余1）
5/2=商2（余1）
2/2=商1（余0）
现在商小于2了,然后把余数连起来,所以十进制23 = 二进制10111

如何将一个8进制转2进制 ?
8进制的一位相当于2进制的3位

比如:0357（8进制不可能大于7）
011 101 111(这里3位一空格是为了人眼好区分)

如何将一个2进制转为8进制 ?
8进制的一位相当于2进制的3位
比如 :011 101 111
		3  5   7

如何将一个16进制转2进制 ?
16进制的一位相当于2进制的4位
如:0X3AF
0011 1010 1111

如何将一个2进制转为16进制 ?
4个2进制 是一个16进制的一位
如:0011 1010 1111
	3 	 A    F
--------------------------------------

取模 % 取余数
结果的符号取决于被模数(被模数是/前面那个)
———————————————————
前++ :先自增1,在做运算
后++ :先运算,在自增加1

int myint1 = 10;
int myint2 = myint1++;
System.out.println(myint1);// 11	
System.out.println(myint2);// 10 (比如统计,随时出错;只是只差1可能看不出)	


int myint3 = 10;
int myint4 = ++ myint3;
System.out.println(myint3);// 11	
System.out.println(myint4);// 11

& 于 && 的区别 :
&: 左边 false 右边都会进行运算
&& : 左边为 false ,右端不在运算	

| 于 || 的区别:
| : 当左端是 true 时,右端照样做运算
|| : 左边 true 时, 右端不在运算

开发 用&& 和 ||
----------------------------------------------
位运算符(位运行其实都不需要计算,它是cpu支持的,只是移动,当然64位比32更快)

<< 左移  3<<2 = 3*2*2 = 12
>> 右移  3>>1 = 3/2 = 1(最好直接画2进制来移)
>>> 无符号右移 3>>>1 = 3/2 = 1(不管符号位全部补0)
3>>>2 //打印0
注意没有无符号左移(因为最高位是符号位,移掉了数字就变了)

----------------------------------------------
与(and) 和 或(or) ,异或是与的反起来（它们3个可以看为一组记忆）
注意同样6和3每种运算结果都不一样

& 与运算 6 & 3 = 2  (画2进制运算,只有上下都是1才返回1)
0000 0110
0000 0011
---------
0000 0010 = 2


^ 异或运算 6 ^ 3 = 5 (异或就是&的取反)

0000 0110
0000 0011
---------
0000 0101 = 5


| 或运算 6 | 3 = 7 (画2进制运算,只要有一个1就是1)

0000 0110
0000 0011
---------
0000 0111 = 7
-----------------------------

~ 反码(负数符号都会改变,原始数+1)

~ 6 = -7
~ -6 = 5

-----------------------------
		功能:
要求不增加新变量来交换数值;只能通过异或

/**
 * 功能:交换2个变量,但不能定义零时变量
   原始方法:这种可以会损失精度
   思路:拿其中一个变量来得到2个变量的总和,在分别相减
 */
	//假如是a=5和b=2
	public static void reverse(int a,int b){
		//7=5+2;
		a = a +b;
		//5=7-2;
		b = a -b;
		//2=7-5;
		a = a -b;		
		System.out.println(a +"  "+ b);
	}
	
/**
 * 
   方式二: 通过异获的方式;假如是5和2(和上面就是全部换成异或符号)
 */
	public static void reverse(int a,int b){
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;		
		System.out.println(a +"  "+ b);
	}
我们来看看执行过程:
		//0101
		//0010
		//-----
		//0111(第一次算完a等于7)
		//0010
		//-----
		//0101（第二次算完b等于5）
		//0111
		//-----
		//0010(第3次算换a等于2)
--------------------------------------------
如何定义一个数组?

有两种方式:
1,静态初始化,初始化数组和数组元素的赋值同时进行.
names = new String[]{"周爽","国情","御龙"};

2,动态初始化,必须指定长度
scores = new String[4];
scores[0] = "周爽";
scores[2] = "国情";
scores[3] = "御龙";

Person [] p;
p = new Person[2];
自定义类也是可以的,如HashMap 中的Node
-------------------------------------------
//定义2维数组,
int [][] arr = new int [3][4]; 

	public static void main(String[] args){ 
		int [][] arr = {{1,2,4},{2,3},{1,2}};
		int sum = 0;
		for(int x=0; x<arr.length; x++){
			for (int y=0 ; y<arr[x].length; y++)
				sum=sum+arr[x][y];		
		}
	   System.out.println(sum);
    }

---------------------------------------------
下面这句代码内存空间会做什么
String[] s = new String[3]; 
	
1,首先会在栈空间建立一个s变量,然后在堆内存中 new 字符串数组 长度为3,默认值为 null（因为目前是字符串） .
	
2,栈空间的s变量 指向堆内存中的首地址,然后我们可以通过角标的方式移动角标得到对应的值	
	
栈 :stack  存放局部变量对象的引用.(对象数组的引用)
堆 :heap   new 出来的东西(如对象实体,数组实体)含成员变量
------------------------------------------------------

循环结构:	
	for(1; 2; 3){
		4;
	}
执行顺序			
1,初始化条件
2,循环条件
3,迭代部分
4,循环体	
			
最简单的无限循环格式for(;;)//不知道循环多少次,没有条件
-------------------------------		
			1	
			while(2){
				3;
			}
			
最简单的无限循环格式:while(true)
-----------------------------------		
		
为什么大神都喜欢用for循环?
for 循环中的变量 for 循环结束就释放了,而 while 中不会


2,while 和 do-while 的区别?
 do-while 至少会执行一次
--------------------------------------------------

嵌套循环的总次数 =  外层次数*内层次数
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
一维:是一条线；二维:是一个面；三维:是一个立体
				
//空间理解:外层控制行数,内层控制一列多少个
for(int i=0; i<=2; i++){			
	for(int j=0; j<=4; j++){
		System.out.print("*");
	}
	System.out.println();
}

//打印结果
3*5 = 15 总次数
/*
*****
*****
*****
*/

----------------------------------
/**
 * 需求:对2维数组进行遍历
	说白了就是先定位到行，在对这行循环;
 */
public static void main(String[] args) {
	int [][] ii= {{1,2,3},{4,5,6},{7,9}};
	
	//通过嵌套循环来模拟2维数组; 进行遍历
	for(int i=0; i<ii.length;i++){
		//对每一维数组进行角标长度遍历
		for(int j=0; j<ii[i].length;j++){
			
			System.out.print(ii[i][j]+" ");
		}
		System.out.println();
	}
}

--------------------------------------------------------------------------
数组的常见算法:
1,求数组的最大值,最小值,平均值,总和等
2,数组的复制,反转.
3,数组的排序

/**
 * 需求:数组的常见算法: 求最大值 求最小值 求总和 求平均值 数组的复制 数组的反转
 */
public class Test2Array {

	public static void main(String[] args) {

		int[] array = new int[] { -44, 77, 33, 66, 55, 88, 99, 0 };
		System.out.println("数组的长度为:" + array.length);

		/**
		 * 数组求最大值
			思路: 先假设数组0下标最大,然后依次比较，如果找到更大的重新赋值”最大值“变量
		 */
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if(array[i] > max){
				max = array[i];
			}		
		}
		System.out.println(max);
		
	
		/**
		 * 数组求总和
		 */
		 
		// 定义一个变量来存总和
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println(sum);

		// 求平均值	
		int avg = 0;
		avg = sum / array.length;
		System.out.println(avg);

		/**
		 * 数组的复制,定义一个数组来装array的值
		 */
		
		int[] array2 = new int[array.length];

		 for (int i = 0; i < array2.length; i++) {
			 
			 array2[i] = array[i];
		 }
		 
		 array2[2] = 22;//覆盖原本33的值
		 
		 
		// 打印array2
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + " ");

		}
		System.out.println();
		// 打印array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		

		/**
		 * 数组的反转
			思路:暂存，交换，交换永远是替换不换的法则
		 */
		for (int i=0,end = array.length-1;    i < end;      i++,end--) {
		
			// 前面一个值给变量暂时放着
			int temp = array[i];
			// 前面的值被后面的值覆盖
			array[i] = array[end];
			// 后面的值都前面的值覆盖
			array[end] = temp;
		}
		
		for (int i = 0; i < array.length; i++) {
				System.out.print(array[i]+" ");
		}

			
		//推荐第二种方式，特好理解（其实2个原理一样只是实现不一样，记住要-1）
		System.out.println();
		
		//循环次数少了一半
		for (int i = 0; i < array.length/2; i++) {
			//暂存，交换，交换永远是替换不换的法则		
			int temp = array[i];
			array[i] = array[array.length-1-i]; 
			array[array.length-1-i] = temp;		
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}	

	}
}

----------------------------------------------
数组的排序

1,插入排序
直接插入排序,折半插入排序,shell排序

2,交换排序
冒泡排序,快速排序(或分区交换排序)

3,选择排序简单选择排序,堆排序

4,归并排序

5,基数排序
--------------------------

功能:数组冒泡排序
思路:
(从外层取一个和后面的每一个进行比较，如果外层(i)的大就放后面(j)),最后形成从小到大排列

另:java 本身都给我们提供了对数组的排序 Arrays.sort(数组名),我们可以直接用
public static void sort(int[] items) {
	
	for (int i = 0; i < items.length; i++) {
		
		//注意j＝i, j < items.length, j一直加++,会往后面走
		for (int j = i; j < items.length; j++) {
			if(items[i] > items[j]) {
				//暂存，交换，交换永远是替换不换的法则	
				int temp = items[j];
				items[j] = items[i];
				items[i]= temp;
			}
		}
	}
}
------------------------------------------
import java.util.Arrays;
public class MySort {
  public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(123);
        test.add(11);
        test.add(12);
        test.add(23);
        fastSort(test);
        System.out.println(test);
    }

    /**
     * 功能:
     * 快速排序;数值越大优势越明显
     * 思路（递归循环）:
     * 随便找一个集合中的一个数,作为标杆(但要保证不下标越界)
     * 集合的每个元素和标杆对比,如果大放大集合,
     * 如果小放小集合,如果等于放中间;
     * 最后在把这个3个集合按小等大的顺序装一起
     *
     */
    public static void fastSort(List<Integer> items) {
        if (items.size() > 1) {
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();
            //这里get(0)也是可以的;随便找个数来对比
            Integer index = items.get(items.size() / 2);
            System.out.println("index="+index);
            for (Integer i : items) {
                if (i < index) {
                    smaller.add(i);
                } else if (i > index) {
                    larger.add(i);
                } else {
                    same.add(i);
                }
            }
            fastSort(smaller);//递归调用,注意这里每次调用都会new上面3个list(纯脑力还是很难的递归)
            fastSort(larger);
            //System.out.println("=====");
            items.clear();//清空这个原始集合
            items.addAll(smaller);//先放入小的部分
            items.addAll(same);//中间部分
            items.addAll(larger);//大于部分
        }
    }

}

------------------------------------------------------------
精华
成员变量和局部变量的区别:
成员变量存在堆内存的对象中;局部变量存在栈内存的方法中.
成员变量都有默认初始化值;局部变量没有默认初始化值.
成员变量随着对象的创建而存在,随着对象的消息而消失.
局部变量随着所属区域的执行而存在,随着所属区域的结束而释放.


静态使用的注意事项：
1,静态方法只能访问静态成员.(非静态则可以访问静态和非静态)
2,静态方法中不可以使用this或者super关键字
3,主函数是静态的.
 
用JAVA语言对现实生活中的事物通过类的形式来体现的.

怎么描述？
对于事物描述通常只关注两方面.一个是属性,一个是行为.

面向对象:3个特征:封装,继承,多态.

举例:类只是图纸.真实的汽车就是堆内存中的对象.

类和对象的关系:
类就是对现实生活中的事物的描述.
属性对应是类中 变量 ,行为对应的类中的 函数(也叫方法).

其实定义类就是在描述事物,就是在定义 属性和行为 . 属性和行为共同成为类中的成员
-------------------------------

this:代表它所在函数所属对象的引用.
～～～～～～～～～～～～～～～～～～

this 代表对象的引用

this 的2种应用:
1,用于区分局部和成员变量同名情况.
2,构造函数之间的相互调用.
-----------------------------------------------------------------------
代码块是类的第4个成员;
用来初始化 类 的 属性 ;只能用 static 来修饰
分为:静态代码块和非静态代码块两种

静态代码块:
1,随着类的加载而加载,而且只能被加载一次
2,多个静态代码块之间按照顺序执行
3,静态代码块的执行要早与非静态代码块
4,静态代码块中只能执行静态的属性或方法

非静态代码块:
1,每创建一个类对象,非静态代码块都会执行一次
2,代码块执行优先于构造器
3,多个非静态块也是按顺序执行

关于 属性赋值的操作:
1,默认初始化(永远第一)
2,静态代码块
3,显示初始化
4,代码块
5,构造器(居然到第5来了)
上面属性初始化的过程
6,通过对象的相应的属性进行修改
------------------------------------------------------
public static void main (String[] args)
主函数:是一个特殊的函数,作为程序入口,可以被Jvm调用

public : 函数访问权限放开
static : 主函数随着类的加载就已经存在了
void   : 主函数没有具体返回值
main   :不是关键字,但是是一个特殊单词,可以被jvm识别
(String[] args) :参数类型是字符串数组
主函数的格式是固定的.被jvm识别.

--------------------
静态代码块

特点: 随着类的加载而执行,且只执行一次,并优先于主函数.
可以用于给类进行初始化的.反正就是参考上面一句话,来思考你什么时候需要使用到静态代码块

注意静态代码块并不是静态方法
格式如下:
public class StaticDemo{
	static{
		System.out.println("c");
	}
	public static void main(String[] args){
		new suibian();
		new suibian();//静态代码块只会执行一次,构造器会执行2次
		System.out.println("over");
		suibian.show();
	}
	static{
		System.out.println("d");
	}
}
class suibian{	
	public suibian(){
		System.out.println("g");
	}
	static{
		System.out.println("a");
	}
	//注意这是静态方法,不是静态代码块;静态主函数只能调静态方法;
	static void show(){
		System.out.println("b");
	}
}
//打印结果:c,d,a,g,g,over,b
--------------------------------
public class StaticDemo {
	public static void main(String[] args) {
		new suibian(1);
		new suibian(2);		
	}
	static {
		System.out.println("d");
	}
}

class suibian {
	{
		System.out.println("f");//这是构造代码块
	}

	static {
		System.out.println("a");//这是静态代码块
	}
	//这是构造函数
	suibian(int z) {
		System.out.println("z");
	}
}

//打印结果:d,a,f,z,f,z
//结论 静态代码块在类加载时只会执行一次,代码块会在每次都会执行一次,和构造器一样,
//但比构造器先执行;既然知道了执行时间和顺序就看什么点需要什么业务需求选择使用哪种

结论 :静态代码块(对 类 初始化的) > 代码块(对 对象 初始化的) > 构造函数(对应 对象 进行初始化的)
-------------
person p = new person("zhangsan",20);

这句话都做了什么事？（其实下面的步骤只说了大概，主要根据加载时机来）
1,类加载器把person.class文件把类并加载到内存.
2,执行该类的静态代码块.如果有的话给person.class类进行初始化.
3,在堆内存中开辟空间,分配内存地址(这里主要开始 new 的动作).
4,在堆内存中建立对象的特有属性.并进行默认初始化.
5,属性进行显示初始化.
6,对象进行代码块初始化.
7,对象进行对应的构造函数初始化.
8,将堆内存地址赋给栈内存中的p变量.
-------------------------------------

2,子父类中的函数.
当子类出现和父类一模一样的函数时,
当子类对象调用该函数,会运行子类函数的内容,如同父类的函数内覆盖一样.这种情况是函数的另一个特性：重写(覆盖)
子类要访问父类中的同名函数用 super.函数名();

---------------------------------------------------------------------------

方法的重载(overload,相当多个不同方法)
同一个类中只要方法名相同 就构成了重载,和方法的参数，返回值类型没有关系

方法的重写(overrite,相当于一个方法)
,一般基于继承或接口(简单理解:就是全部都要一样(返回参数可以小于父类),只是方法体内部不同)
 除权限修饰符大于或等于父类; 子类的方法异常类型不能大于父类的;两个方法同为static 或同时不是
--------------------------------------------------
可变参数

1,格式 ： 数据类型 ...形参名
2,相当于一个可变长度的数组
3,若方法中存在可变个数的形参,那么一定要声明在方法形参的最后
4,在一个方法中,最多只能声明一个可变个数的形参
---------------------------------
public class VariableParameter {

	public static void main(String[] args) {
		VariableParameter vp = new VariableParameter();
		int a = vp.getNum(1 + 1); //2个参数
		int b = vp.getNum(1 + 1 + 1);//3个参数
		int c = vp.getNum(1 + 1 + 1 + 1);//4个参数
		System.out.println(a + " " + b + " " + c);
	}

	public int getNum(int... args) {
		int sum = 0;
		for (int i = 0; i < args.length; i++) {
			sum += args[i];
		}
		return sum;
	}
}
-------------------------------
构造器(constructor)的作用 ?
1,创建对象
2,给创建的对象的属性赋值

如何声明一个构造器 ?

权限修饰符 类名(形参){	
}

类的多个构造器之间构成重载

类对象的属性赋值的先后顺序在前面自己找
----------------------------------------
什么是javaBean ?

1,是一个公共的类
2,有公共的无参的构造方法
3,有属性,并提供了getter setter方法
------------------------------	
super ,this 关键字 可以修饰属性,方法

在子类的方法,构造器中,通过 super.属性 或者是 super.方法 的形式,显示调用父类
指定的属性或方法.

使用到 super 或 this 一定放在方法体的第一行;	
-------------------------------------------------
static 
静态可以修饰属性,方法,代码块,可以是类或是内部类；可以的认为静态方法在类加载的同时被初始化；

在static方法的内部不能调用非静态方法，反过来倒是可以的，而且可以在没有创建任何对象的前提下，仅仅通过类本身来调用static方法。
这实际上正是static方法的主要用途。它很像全局方法。Java中禁止使用全局方法，但你在类中置入static方法就可以访问其它
static方法和static域 —摘抄自《Java编程思想》

无论创建多少个对象，静态数据都只占用一份存储区域。static关键字不能应用于局部变量，因此它只能作用于域。如果是静态的
基本数据类型域，且也没有对它进行初始化，
那么它就会获得基本类型的标准初值；如果它是一个对象引用，那么它的默认初始化的值就是null。 
-----------------------------------------

final 最终的

final 修饰成员变量后变为常量,习惯上常量用大写字符表示 (常量赋值就不能再变了;静态变量也叫全局变量)
final 修饰方法 不能被重写.如 Object类的getClass()
final 修饰类 不能被继承. 如:String StringBuffer类 System 类


如果final修饰一个引用类型时，则在初始化之后不能再指向其他对象，但该引用所指向的对象的内容是可以发生变化的。
（引用不能被修改,值是可以被改变）

常量在哪里赋值?
final 修饰的 类成员变量 必须在申明时 或 构造方法里初始化。

常量可以同时用 static final 如果加了 static 修饰后,就不能再构造器里初始化了,必须立即赋值（配合使用的好处）
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

举例:被final修饰的引用类型,值是可以改变的
private static final List<Integer> l = new ArrayList<>();
public static void main(String[] args) {
		l.add(1);
		l.add(2);
		System.out.println(l.size());	
		for(Iterator<Integer> i = l.iterator();i.hasNext();){
			System.out.println(i.next());//打印1,2说明可以改值
		}
}
--------------------------------------------------------------------------
重点:
abstract :抽象的,可以用来修饰类,方法.

1,抽象类也有构造器(凡是类都有),但不能被实例化，因为常包含抽象方法
2,抽象类中可以没有抽象方法(但不推荐这样做)

abstract class Animal {  
    Animal(){  
        System.out.println("抽象类Animal无参构造器"); //此处执行前会默认执行super()  
    }  
      
    Animal(int a){  
        System.out.println("抽象类Animal有参构造器”+a);  
    }  
}  

public class Horse extends Animal {  
    Horse () {  
        System.out.println("子类horse无参构造器"); //此处执行前会默认执行super()  
    }  
      
    Horse (int h) {  
        super(3);  
        System.out.println("子类horse有参构造器");  
    }  
      
    public static void main(String [] args) {  
        Horse h = new Horse();  
        Animal h2 = new Horse(6);  
		Animal h3 = new Animal(); //报错,无法编译,抽象类不可实例化  
    }  
} 

二 抽象方法.
1,没有方法体(没有方法体), 如 public abstract void eat();
2,子类继承了抽象类,重写父类抽象方法后就可以实例化
3,若继承一个抽象类,没有重写所有的抽象方法,此类不能被实例化或改为抽象类

----------------------------------------------------------------
接口 (interface)与类是 并行 的一个概念
1,只能有常量，不能有普通变量(但不推荐使用)与抽象方法的一个集合;全是抽象方法，
不能有普通方法（因为默认 public abstract 修饰）
2,接口不能有构造器
3,实现接口的类,必须重写其中所有的抽象方法后才可以实例化.若没有全部重写,则此类还是一个抽象类
4,类可以实现多个接口.弥补了java的单继承
5,接口与接口之间存在继承关系(实现后你可以使用任何一个接口的方法或常量)
6,接口与实现类之间也存在多态性 


interface Person{
	public abstract void getRun();
}
---------------------------------------------------------------
抽象类和接口的区别以及使用场景(精华)

相同点:
两者都不能实例化.interface 实现类及 abstract class 的子类都必须要实现抽象方法后才可以实例化;

不同点:
1,interface 需要实现,要用 implements,而 abstract class 需要继承,要用 extends.
一个类可以实现多个 interface,但一个类只能继承一个 abstract class.
2,interface 强调特定功能的实现,而 abstract class 强调所属关系.
3,接口中只有常量,abstract class 中可以有普通变量

abstract class是 interface 与 Class 的中起承上启下(既可以有Class 的功能又有接口的功能).
interface 方法全抽象的,且被 public abstract 默认修饰


interface 的应用场合

1,类与类之前需要特定的接口进行协调,而不在乎其如何实现.需要将一组类视为单一的类,而调用者只通过接口来与这组类发生联系.
2,作为能够实现特定功能的标识存在,如Serializable就是一个空接口


abstract class 的应用场合

1,某些场合下,只靠纯粹的接口不能满足类与类之间的协调,还必需类中表示状态的变量来区别不同的关系.			
2,可以共享的方法,无需子类分别实现

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

多态(直到我学完设计模式才搞懂,作用强大,但泛型在Java更为重要)

多态:超类可以接受任何实现或继承的子类的实例;这样带来的好处是大大的提高程序的扩张性.

前提(核心中的核心): 
要有继承关系,要么是接口实现

缺点:
使用多态可能会用到强制转型(),判断对象a是否是类A的一个实例 使用 instanceof 
若a是b的实例 ,那么a也一定是b类的父类的实例(a既然已经是儿子，就一定是孙子)


举例:
interface Person{
	//每一个接口默认都有public abstract修饰，不写也有
	public abstract void getRun();
}

class Man implements Person{
	@Override
	public void getRun() {
		System.out.println("person");	
	}	
}	

public class TestInterface {

	public static void main(String[] args) {
		//Man是子类，用多态父类统一接收子类;面向抽象编程
		Person man = new Man();
		//方法中是父类接受子类,运行子类的方法体
		TestInterface.person(man);
	}
	
	public static void person(Person p){
		p.getRun();
	}
}

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
泛型(都是在集合中使用，和多态容易混淆，它们是不同的东西)
Generic 泛型 (泛型没有多态)

泛型的最主要的作用就是动态形参,可类型传递;防止类型转换错误

泛型，即“参数化类型”。就是多态传递有形参，调用此方法时传递实参

为什么需要泛型?
就是代替Object对象的如:
public Object doSomething(Object obj) {}
public <T> T doSomething(T t) {}

1,为了程序有更强的可用性,让类方法可以重用任何对象(泛型不支持多态)；
2,存取都可以出现类型转换异常.泛型就是明确类型,使用泛型后不需要强转
----------------------------
泛型举例:
如:
JqGridRequest<T> //分页请求,对请求条件,排序,PageNo,PageSize,T data 进行封装,盘古使用
JqGridResponse<T>//分页返回,对pageNo,totalPage,totalSize,List<T> data,resultCode,resultMsg 进行封装

----------------------------
注意事项:
1,泛型中不能放基本数据类型
2,泛型没有多态,必须保证前后<>的类型一致;就算是有继承关系也不可以(很重要的一句话)
3,把一个带泛型的直接给一赋个不带泛型的变量,泛型自动消失.但注意类型需要一致,不然会出现转换异常.
---------------------------------
泛型怎么来的?
我们可以查看到底层List源码,看见其实在底层 类上定义了List<E>这样的泛型,后面就嵌套出
很多方法 如:   add(E e) ;  E get(int index);等,这样一套底层嵌套,你会发现List<任何引用对象>,
极大提高了方法的复用性;从类接受具体类型传递到各方法（还不需要考虑转换异常，前后类型必须一致连继承都不可以）;
----------------------------------------------------

/**
 * 自定义一个泛型类可以参看Collection源码
 * DAO 的使用大大增加了泛型的理解,大大提高代码的重用性（何时我能写出这样的代码，大牛判断的一个指标）
	泛型是最难理解的基础知识
 */
public class DAO<T> {

	private T t;

	public T getT() {
		return t;
	}
	
	public void setT(T t) {
		this.t = t;
	}
	
	//声明泛型方法,因为有时方法中的类型 不一定就和类的类型一样（如这里T和E)
	//这里的类型相当于是传进来什么类型返回就是什么类型
	public <E> E getE(E e){
		return e;
	}
	
	//声明泛型方法(更加常用,方法级别的),实现数据到集合的复制,不要纠结第一个<E> 只是一种规范
	public <E> List<E> formArrayToList(E[] e,List<E> list){
		for(E e1 : e){
			list.add(e1);
		}
		return list;
	}	
}

------------------------------------------
这是初级理解,这只算是使用,难度在上面,上面是定义
	/**
	 * 使用泛型后:
	 * 1,想添加错类型,加都加不进
	 * 2,不在必要强转为 Entry 的那步了 如:Map.Entry entry = (Entry) obj;
	 * 3,全程看不到一个警告
	 */
	@Test
	public void test(){	
		Map<String,Integer> map = new HashMap<>();	
		map.put("a", 2);
		map.put("b", 3);
		map.put("c", 4);
		
		Set<Entry<String, Integer>> set = map.entrySet();	
		for (Entry<String, Integer> entry : set) {
			System.out.println(entry.getKey() +"=="+ entry.getValue());
		}			
	}	
----------------------------------------------------
精华
？通配符(也可以叫占位符)

？和 T 区别？
?可以接受任何类型，一般用在继承关系上；?不能限制实参类型一致
T可以接受任何类型， 一般用在类型有相互传递值上，要求类型一致
精华
https://blog.csdn.net/woshizisezise/article/details/79374460

public class Test {
	public static void main(String[] args) {
		List<User> lists = new ArrayList<>();
		show3(lists);//如果User不是Person的子类就会报错

	}
	
	//约束传入的类型必须的Person的子类
	public static void show3(List<? extends Person> list) {
		for (Person person : list) {
			System.out.println(person);
		}
	
	}
}


public class Test {

	public static void main(String[] args) {
		List<User> lists = new ArrayList<>();
		show3(lists);
	}
	//List<? extends T>问号和T的位置不可以换，且方法返回值多了一个<T>
	//且这时根据就约束不到?号是T的子类
	public static <T> void show3(List<? extends T> list) {
		for (T t : list) {
			System.out.println(t);
		}
	
	}
}
另：
上界：List<？extends Number> 类型参数可以是Number类型及其子类的；
下界：List<? super Integer> 类型参数可以是Integer类型或是其父类的；
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

类的第5个成员:内部类
1,类的内部在定义类的类叫内部类.
2,内部类分为 成员内部类(声明在类的内部且方法外) 和 局部内部类(方法里)
成员内部类:
相当于外部类的一个成员变量:
可以被 static final 修饰,可以调用外部类的属性,方法.

举例:
//这种创建线程的方式可以哦,其实可以看成是一个匿名内部类（成员内部类）
final Thread t1 = new Thread(new Runnable() {	
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " run 1");
	}
}, "T1");

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
STRING

字符串(引用数据类型)

java.lang包:
*******总结:字符串最好去Api中找.....

字符串特点:一旦初始化值就不能被改变,所谓的改变只是变量指向.和final还不一样,那个是指向不变值可以改变刚好相反

String str1 = "AA";
String str2 = "AA";
String str3 = new String ("AA");

str1变量在栈空间中,首先去找方法区中的字符串常量池中有AA这个字符串没,有就直接指向AA,没有就建立一个AA

str1 == str2 结果是 true;因为地址都是一样,都指向同一块内存

str3 变量在栈空间中, new String 在堆内存中, 但堆内存中的区域又指向了方法区中的字符串常量池
(因为是字符串是引用数据类型).先是去找有没AA这个字符串,有就直接指向AA,没有就建立一个AA

str1.equals (str3) 结果也是true; 但 str1 == str3 结果是 false (new 这种相当于又多了一个中间层);

equals比较的是字符值,== 比较的是地址;但是你可以重写equals方法让它和默认结果相反;
----------------------------------------------------
toString:
toString由: 类名+"@"十六转十进制的hashCode()值两部分组成

我们先来看看在Object类的toString方法,注意大部分类的toString内容是不一样的(它们自定义重写了toString方法)

public String toString(){
	return getClass().getName() + '@' + Integer.toHexString(hashCode());
}

hashCode()里面存的就是十进制的哈希值,就是对象的特征值 好比给你起身份证 可以唯一识别一个对象.
------------------------------------------------------
/**
 * 基本数据类型转String 和String转基本数据类型如何转?
 */
public static void main(String[] args) {
	String s = "123";
	int i = 123;
	float f = 123.0f;

	String ss = String.valueOf(f);// 基本数据类型转String
	float ff = Float.parseFloat(s);// String转基本数据类型
	int ii = Integer.parseInt(s);
	System.out.println(ss + "  " + ff + "  " + ii);
}
----------------------------------------------------

public class Test {
	
	/**
	 * 一段字符串在另一段字符串中出现了几次?
  		String e ="kkddissokk";
		System.out.println(get(e,"kk"));
	 */
	public static int get(String str,String key){		
		int count = 0, index = 0;		
		//思路：循环在长的字符串中查找短的字符串，如果找到就找到位置，重新截取在赋值给长字符串
		while((index = str.indexOf(key)) != -1){
			//能到这里说明已经匹配上了，indexOf 记录首次出现的位置,然后再将原字符串截取长度后重新赋值给
			//字符串变量
			str = str.substring(index + key.length());
			count++;
		}
		
		//第二种方式比上面快，如果找到直接移动下标的方式（字符串截取相对耗时）
//		while((index = str.indexOf(key, index)) != -1){
//			index = index+key.length();
//			count++;
//		}	
		
		return count;	
	}
	
	
	/**
	 * 反转指定位置的字符串,和反转全部(原理和反转数组一模一样，转为字符数组)
		String e ="abcdef";
		System.out.println(reverseString(e));
	 */
	public static String reverseString(String str,int start,int end){
		char[] arr = str.toCharArray();//字符串变数组，关键一步
		reverse(arr,start,end);//反转数组.重点
		return new String(arr);//返回将数组变成字符串
	}
	
	public static String reverseString(String str){//如果没有指定就全部反转,重载上面
		return reverseString(str,0,str.length());
	} 
	
	public static void reverse(char[] arr ,int st,int en){
		
		for(int start = st, end= en - 1;start < end; start++, end--){
			//暂存，交换，交换永远是替换不换的法则
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp; 
		}
	}
	
	
	/**
	 * 开始位置为0 ,是否为' '是就继续向后移动,但不能超出总长度-1;如果不为空就记录当前位置
	 * 后面一样的只是开始位置为总长度-1 ; 最后根据开后下标组合新的字符串返回.
	 * 
	 *  String e = "   asdf sd sd    ";
		String sq = myTrim(e);
		System.out.println(sq);
	 */
	public static String myTrim(String s){
		
		int start = 0;
		int end = s.length()-1;
		
		while(start <= end && s.charAt(start) == ' '){
			start++;
		}
		
		while(start <= end && s.charAt(end) == ' '){
			end--;
		}	
		
		return s.substring(start, end + 1);	
	}
	

	/**
	 * 字符串比较.返回2段字符串的最大相同字符串
	 * 	String e = "sskkdHOLLEhkk";
		String e1 = "skkdHDJEhdfgdfgdfg";
		System.out.println(maxString(e, e1));

	 */
	public static String maxString(String str, String key) {
		String max = "", min = "";
		max = (str.length() > key.length()) ? str : key;// 如果s1大于s2返回s1;;否者返回s2
		min = (max == str) ? key : str;
		// s1等于s1吗?等于返回s2=min;或者min=s1;结果始终得到了min.
		// sop(min);
		for (int x = 0; x < min.length(); x++)
			for (int y = 0, mid = min.length() - x; mid != min.length() + 1; y++, mid++) {
				    // y控制头指针,mid控制尾指针.
					// 第一进来0到最大角标,
					// 第二进来0到最大角标-1开始,,内循环每次加一格到最大角标
					// 第三进来0到最大角标-2开始,,内循环每次加一格到最大角标
					// 第四进来0到最大角标-3开始,,内循环每次加一格到最大角标
					// 每次生成的的y和mid传下来生成新的字符串.
				if (max.contains(min.substring(y, mid)))// 长的字符串包括短的没?
					return min.substring(y, mid);
			}
		return "-1";
	}
	
	
/**
 * 字符串的反转 ,方式一:用数组来反转 原理:前面角标++ 后面-- 然后前后对换,在从数组转会字符串
 * StringBuffer中有现成的reverse方法,但是那个方法会改变原始字符串的顺序
 * 
 * @return
 */
public static String myReverse1(String s, int start, int end) {

	char[] c = s.toCharArray();

	for (int i = start, j = end - 1; i < j; i++, j--) {
		//暂存，交换，交换永远是替换不换的法则	
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
	return new String(c);

}

/**
 * 字符串的反转方式2 StringBuffer中有现成的reverse方法,但是那个方法会改变原始字符串的顺序
 */
public static String myReverse2(String str) {
	StringBuffer sb = new StringBuffer(str);
	return sb.reverse().toString();
}

/**
 * 字符串的反转方式3 StringBuffer中有现成的reverse方法,但是那个方法会改变原始字符串的顺序
 */
public static String myReverse3(String str) {
	StringBuffer sb = new StringBuffer();

	for (int i = str.length() - 1; i >= 0; i--) {
		sb.append(str.charAt(i));
	}
	return sb.toString();

}

/**
 * 字符串的反转 ,方式四:用数组来反转 原理:前面角标++ 后面-- 然后前后对换,在从数组转会字符串
 */
public static String myReverse4(String s, int start, int end) {

	String newStart = s.substring(0, start);
	for (int i = end - 1; i >= start; i--) {
		char c = s.charAt(i);
		newStart += c;
	}
	// newStart += s.substring(end);
	return newStart;
}

}
--------------------------------------------------------

StringBuffer 是字符串缓冲区.在lang包中

*********记住缓冲区三个特点:************
1,长度是可变化的.
2,可以字节操作多个数据类型.
3,最终会通过toString方法变成字符串.


1,存储.
StringBuffer append():将指定数据作为参数添加到以后数据尾部.
StringBuffer insert(index,数据):可以将数据插入到指定index处.

2,删除.
StringBuffer delete(start,end):删除缓冲区中的数据
StringBuffer deleteChaAt(index):删除指定位置的字符.

3,获取
char charAt(int index)
int indexOf(string str)
int lastIndexOf(String str)
int length()
string substring (int start ,int end )

4,修改 replace(start,end,string);头,尾,字符串.
void setCharAt(int index ,char ch);

5,反转 reverse(); 

6,将缓冲区中指定数据存储到指定字符中.
void getChare (int srcBegin, int srcEnd, char[] dst, int dstBegin)

JDK1.5,版本之后出现了StringBuilder
StringBuffer 线程同步,StringBuilder 线程不同步但速度快

------------------------------------------------
时间
(线程不安全的，不建议使用;用LocalDateTime代替Date, LocalDataFormat代替SimpleDateFormat)

System 类 currentTimeMillis();返回当前时间的long型值.(此long值从1970年1月1日0点0分00秒到当前毫秒数)

举例:
public static void main(String[] args) throws ParseException {
	Date date = new Date();
	SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String sDate = s.format(date);//将日期格式转为字符串
	System.out.println(sDate);//2016-12-10 14:10:29
	Date date2 = s.parse(sDate);//将字符串格式转为日期格式
	System.out.println(date2);//Sat Dec 10 14:10:29 CST 2016
}

日期时间类型的比较:
int i = DateTool.parseDate("2016-08-16 14:22:22").compareTo(new Date());
System.out.println(i);

------------------------------------------------
Calendar :日历类

package com.atguigu.java;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/*
 * 与时间相关的类：
 * 1.System 类下的currentTimeMillis();
 * 2.Date类:java.util.Date 
 * 3.SimpleDateFormat类
 * 4.Calendar类
 */
 
@Test
public void test4(){
	
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(new Date());
	System.out.println("现在时间是：" + new Date());
	String year = String.valueOf(calendar.get(Calendar.YEAR));
	String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
	String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
	String week = String.valueOf(calendar.get(Calendar.DAY_OF_WEEK) - 1);
	System.out.println("现在时间是：" + year + "年" + month + "月" + day + "日，星期" + week);
	long now = calendar.getTimeInMillis();
	calendar.set(2018, 7, 1);// 这里与真实的月份之间减一月
	long birth = calendar.getTimeInMillis();
	long days = (now - birth) / (1000 * 60 * 60 * 24);
	System.out.println("今天和2018年8月1日相隔" + days + "天，" + "也就是说我在这个美丽的星球上已经幸福的生活了" + days + "天。");	
}

-----------------------------------------------------
	
计算时间差

@Test
public void texts(){
	dateDiff("1999-9-9 20:22:22", "1999-9-9 20:32:22", "yyyy-MM-dd HH:mm:ss");
}

public void dateDiff(String startTime,String endTime, String format) {
	//按照传入的格式生成一个simpledateformate对象
	SimpleDateFormat sd = new SimpleDateFormat(format);
	long nd = 1000*24*60*60;//一天的毫秒数
	long nh = 1000*60*60;//一小时的毫秒数
	long nm = 1000*60;//一分钟的毫秒数
	long ns = 1000;//一秒钟的毫秒数
	long diff;
	try {		
		//获得两个时间的毫秒时间差异
		diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
		long day = diff/nd;//计算差多少天
		long hour = diff%nd/nh;//计算差多少小时
		long min = diff%nd%nh/nm;//计算差多少分钟
		long sec = diff%nd%nh%nm/ns;//计算差多少秒//输出结果
		System.out.println("时间相差:"+day+"天"+hour+"小时"+min+"分钟"+sec+"秒.");
	} catch (Exception e) {
		// TODO: handle exception
	}	
}	
----------------------------------------------------
推荐
jdk1.8 推出线程安全的时间类LocalDateTime，用来代替Date和SimpleDataFormat

//https://blog.csdn.net/u010002184/article/details/79713573
//网上找的时间工具类
public class DateTimeUtils {
    private DateTimeUtils() {
    }

    private final static String COMMON_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private final static DateTimeFormatter COMMON_FORMATTER = DateTimeFormatter.ofPattern(COMMON_PATTERN);
    private final static ZoneOffset DEFAULT_ZONE_OFFSET = ZoneOffset.of("+8");

    public static String dateToString(LocalDateTime dateTime) {
        assert dateTime != null;
        return COMMON_FORMATTER.format(dateTime);
    }

    public static LocalDateTime stringToDate(String dateStr) {
        assert dateStr != null;
        return LocalDateTime.parse(dateStr, COMMON_FORMATTER);
    }

    public static String dateToString(LocalDateTime dateTime, DateTimeFormatter formatter) {
        assert dateTime != null;
        return formatter.format(dateTime);
    }

    public static LocalDateTime stringToDate(String dateStr, DateTimeFormatter formatter) {
        assert dateStr != null;
        return LocalDateTime.parse(dateStr, formatter);
    }

    public static long dateToTimeMillis(LocalDateTime dateTime) {
        assert dateTime != null;
        return dateTime.toInstant(DEFAULT_ZONE_OFFSET).toEpochMilli();
    }

    public static LocalDateTime timeMillisToDate(long timeMillis) {
        Instant instant = Instant.ofEpochMilli(timeMillis);
        return LocalDateTime.ofInstant(instant, DEFAULT_ZONE_OFFSET);
    }

    public static void main(String[] args) {
        String s = dateToString(LocalDateTime.now());
        System.out.println(s);
        System.out.println();
        String dateStr = "2019-01-01 12:12:12";
        LocalDateTime localDateTime = stringToDate(dateStr);
        System.out.println(localDateTime);
        System.out.println();
        System.out.println(dateToTimeMillis(localDateTime));
        System.out.println();
        System.out.println(timeMillisToDate(System.currentTimeMillis()));
    }
}	
	
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
异常体系结构

java.lang.Object
	|--java.lang.Throwable(所有异常都具有可抛性)
		|--java.lang.Error:错误,jdk本身错误,无需关心
		|--java.lang.Excption:异常.需要进行处理
			|--RuntimeException:运行时异常（ArrayIndexOutOfBoundsException数组下标越界 NullPointerException空指针
									ArithmeticException算法异常 ClassCastException类型转换异常,bean重复）			


异常的处理：
java 提供了特有的语句进行处理.如下:

try:{
	需要被检测的代码;
}catch(异常类 变量){
	处理异常的代码;(处理方式)
}finally{
	一定会执行的语句;
}


如何定义异常信息？
自定义类继承Throwable 或子类即可,将异常信息传给父类；
因为父类中已经把异常信息的操作都完成了,所以子类只要在构造时将异常传递给父类通过
 super 语句,然后直接通过getMessage方法获得异常信息.

继承原因：
异常体系有一个特点：因为异常类和异常都具备可抛性,这是 Throwable 这个体系独有特点.只有这个体系中的类和对象才可以被 throws 和 throw 操作
throws 和 throw 的区别:
throws 使用在的函数上,后面跟的是异常类,多个用逗号隔开.
throw 使用在函数内,后跟的是异常对象.
~~~~~~~~~~~~~~~~~~~
	
java程序分为javac.exe(编译)和java.exe(运行)两个过程

异常分两种：
Exception(编译) 和 RuntimeException(运行)
1,编译时异常必须显示告诉程序如何处理,要么方法上 throw ,要么 try;不然无法编译代码
如果 throw 的话,该方法上还必须 throws ,调用者必须处理(要么 try 要么继续 throws);
 
2,RuntimeException 以及子类如果在函数内 throw 抛出该异常,方法上可以不用声明,编译一样通过(所以就要看业务是否需要用户显示处理还是运行处理来判断哪种异常)
如果在方法上 throws 声明了该异常,调用者可以不用 try, catch 处理,
因为在运行时,出现了无法继续运算的情况,希望停止程序后,由程序员进行修正.
------------------
举例：
//如何自定义异常,继承一个异常超类即可
public class DefinedException extends RuntimeException{	

	/**
	 * 有参构造器，无参可以不需要；
	 * @param message 动态异常信息
	 */
	DefinedException(String message){
		super(message);
	}
	
}

public class MyAction {
		
	//请在这里测试一个throws ,看看调用者需要处理不	
	public int div(int a,int b) {
		if(b<0) {
			throw new DefinedException("RuntimeException直接停止");
		}else if (b==0) {
			//这里2个异常都是RuntimeException的小弟所以不用声明.当然不用处理
			throw new ArithmeticException("除数等于0不可以");
		}
		return a/b;
	}
}

public class Demo {

	public static void main(String[] args) {
		MyAction myaction = new MyAction();
		/**
		 * 如果不放到try里面程序会嘎然而止；(可能我们就想程序出错直接
		 * 就终止，就可以不try)
		 */
		int c = myaction.div(4, -1);
		/**try {
			int c = myaction.div(4, 0);
		} catch (Exception e) {
			System.out.println(e);
		}*/
		System.out.println("over");
	}
}
----------------------------
上面main方法的代码,其实开发中是在Controler层,正确处理service端throw异常可以是下面选一种:
SpringMvc 统一异常处理有 3 种方式(精华)，分别为：

1,spring MVC提供的SimpleMappingExceptionResolver
2,实现 HandlerExceptionResolver 接口 （这种基于xml配置可以直接跳转的页面；全局搜索有例子）
3,使用注解 @ControllerAdvice + @ExceptionHandler(方法注解)推荐 (百度网盘springbootHello-3有例子)

关于异常总结(精华)：

 java对异常进行了对象封装，jdk中有很多异常对象;但在业务开发时我们有很多业务异常我们希望有自己异常对象这样能更精确更友好提示用户;
所以出现了自定义异常类；实际开发时我们可能会在service层抛出各种自定义异常，如果我们在controler层对每个异常分别处理的话
会让我们代码可读性变差，和工作量加大；这时就统一异常处理就排上用场了；统一异常通过上面3种实现；

异常的出现可以让异常问题流程代码和正常代码分离,从而阅读性强

异常的好处:
1,将问题进行封装.
2,将正常流程代码和问题代码相分离,方便阅读.

异常的处理原则:
1,处理有两种: try 或者 throws.
2,调用到抛出异常的功能时,抛出几个就处理几个.一个 try 对应对一个 catch(规范)
3,多个 catch,父类的 catch 放在最下面(粒度细的放上面,粒度粗的放下面)
4,catch 内,需要定义针对性的处理方式,不要简单的定义printStackTrace,输出语句.更不要什么都不写.
当捕获到异常,本功能处理不了时,可以继续从 catch 中抛出.

在子父类覆盖时:
1,子类抛出的异常必须是父类的异常的子集或者子类.
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
包(package)
作用:对类文件进行分类管理,提供多层命名空间(防止类名一样,出现冲突

有了包后类的全名:包名.类名

主要记住第一排下面的"类"因为每个都支持;子类比同包访问的访问权限更高;
然后四种修饰public是全部,private只有一个;

  访问权限   类   同包  子类  其他包
  public     ∨   ∨   ∨     ∨

protected    ∨   ∨   ∨     ×

  default    ∨   ∨   ×      ×

  private    ∨   ×    ×      ×
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
正则表达式:
Regexp

入门可以直接看菜鸟中的java中的正则;
正则表达式用于操作字符串数据,通过一些特定的符号来体现,
缺点:虽然简化了书写,但是阅读性差.

百度一下:Pattern类与Matcher类详解;http://blog.csdn.net/kofandlizi/article/details/7323863
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
对于java正则表达式各种符号的功能请看:api文档中Pattern类,非常强大
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
http://tool.lu/regex/ 在线正则

常用正则:
email : ^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$
说明:以数字或字母(大小写)开头或中文,多个加@,多个数字或字母加多个 .多个字母或数字,同时已数字或字母结尾

手机号码 :^[1][34578][0-9]{9}$
说明:以1开头,第二位只能是34578,然后后面0-9数量为9为,加一起为11位;
年龄 : ^(?:[1-9][0-9]?|1[01][0-9]|120)$///分为3种可能 : 1-99 | 100-119 | 120
^(?:[0-9]{1,4}|10000)$//数字 0-10000的数字
身份证 : /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
说明 :我没具体读,只能验证格式,不能确认真伪.
"*":/[\w\W]+///不能为空
"*6-16":/^[\w\W]{6,16}$///请填写6到16位数字
"s":/^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]+$///不能输入特殊字符
"s6-18":/^[\u4E00-\u9FA5\uf900-\ufa2d\w\.\s]{6,18}$///请填写6到18位字符
"p":/^[0-9]{6}$///请填写邮政编码！
"url":/^(\w+:\/\/)?\w+(\.\w+)+.*$///请填写网址！
 
//长度应该在5-8之间,可以包含中文字符(一个汉字算一个字符)
^[a-zA-Z0-9\u4e00-\u9fa5]{5,8}$
	
#java如何使用:	

boolean isMatch = Pattern.matches("^[0-9]+", "123");//只使用一次时推荐
或
Pattern pattern = Pattern.compile("^[1][34578][0-9]{9}$");
Matcher matcher = pattern.matcher(cga.getMobilePhone());
if (!matcher.matches()) {
	return CommonUtil.bulidResult(1, "收货人的手机号码格式不正确", null);
}
或(String自身支持正则)	
if("123".matches("^[0-9]+")){	
}
--------------------------------------
Pattern p = Pattern.compile("\\d+");
Matcher m = p.matcher("1sa43fg322");
//find会多次查找,matches全部匹配,lookingAt匹配开始
while (m.find()) {
	System.out.println("一共匹配到几次:"+m.groupCount());
	System.out.println(m.group());//输出匹配到的字符串
	System.out.println(m.start() + "-" + m.end());//开始位和结束位置
}
//注意:只有当匹配操作成功,才可以使用start(),end(),group()三个方法,否则会抛出java.lang.IllegalStateException,也就是当matches(),lookingAt(),find()其中任意一个方法返回true时,才可以使用.
--------------------------------------
//如果在str中找到<号就是替换为$lt字母,url可能会使用到
str = Pattern.compile("<").matcher(str).replaceAll("&lt");
str = Pattern.compile(">").matcher(str).replaceAll("&gt");
----------------------------------
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex {
	public static void main(String[] args) {
		show4();
	}
	
	//判断手机号码格式
	public static void show1() {
		String s = "18982662024";
		String re = "1[358]\\d{9}";
		//上面下面一个效果 \\d 等价于 [0-9]
		String reg = "1[358][0-9]{9}";
		System.out.println(s.matches(reg));
	}
	
	//正则表达式分割
	public static void show2() {
		String s = "sdfaasdfssadfffp";
		String[] re = s.split("(.)\\1+");
		for (String a : re) {
			System.out.println(a);
		}
	}
	
	//隐藏手机号码部分数字
	public static void show3() {
		String s = "sdfaasdfssadfffp";
		String re = s.replaceAll("(.)\\1+", "$1");
		System.out.println(re);
		String ss = "18982662024";
		String ru = ss.replaceAll("(\\d{3})\\d{6}(\\d{2})", "$1******$2");
		//一个()包装成一组,$1表示第一组,$2表示第2组
		System.out.println(ru);
	}
	
	//获取三个字母组成的单词,搜索功能
	public static void show4() {
		String s = "sdf aasd fss ad fffp";
		String regex = "\\b[a-z]{3}\\b";
		//b表示 单词之间的空格,前面一个,后面跟一个
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		while (m.find()) {
			System.out.println(m.group());//获取匹配的子序列
			System.out.println(m.start() + " : " + m.end());
		}
	}
}
	
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
集合

Java 集合可分为 Collection 和 Map 两种体系
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

				List :ArrayList LinkedList Vector
Collection	
  				Set  :HashSet  LinkedHashSet TreeSet

Map	 				  HashMap  LinkedHashMap  TreeMap  Hashtable

Collections 工具箱这个类
---------------------------------
Collection 接口(里面有15个方法,子类共享)
	|---List 接口,继承了Collection接口(存储是有序的,可以重复)(如果要判断list中的元素的值是否相同，那么一定要重写equals)
		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			|---ArrayList(推荐.底层原理是数组)实现了List还实现了其它接口
			|---LinkedList(底层是链表,对于大量的插入,删用它)实现类
			|---vector(古老的,线程安全的,一般不用) 实现类
	|---Set(**存储**是无序的,不可重复;方法基本和父类Collection一样)
		~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			无序指的是存储的位置是无序,底层是按hashCode值存储的
			不可重复:Set集合存储 首先会判断HashCode值,如果值一样在判断equlas.
			如果不一样,直接存.这样大大提高了效率.这样Set必需复写好HashCode方法.和 equals 方法 
			****************
			
			|---HashSet(推荐)
			|---LinkedHashSet:根据元素的hashCode值来决定元素的存储位置,同时使用链表维护元素的次序,
								(使用效果是有序的,但底层其实无序,因为有链表维护)
			|---TreeSet:可以按照指定属性进行排序
				1,向TreeSet添加的元素必须是同一个类的.
				2,基础类型有默认排序;如String.包装类默认从小到大顺序遍历
				3,当向TreeSet添加自定义对象时,有两种排序方法: 1,自然排序,2,定制排序(往下走几十行会介绍)
				


另: HashSet集合底层其实用到了HashMap,key就是该对象,value统一放的是new Object();
重点:操作集合大多数  List和 linked我们要复写 equals ; 
Set和Map 我们要复写HashCode 和 equals ;


iterator()方法返回的是一个 Iterator 接口实现类的对象

@Test
public void test(){	
	List<Integer> l = new ArrayList<Integer>();
	l.add(1);
	l.add(2);
	l.add(3);
	Iterator<Integer> it = l.iterator();//方法返回的是一个 Iterator 接口实现类的对象

	while (it.hasNext()) {
		System.out.print(it.next());//1,2,3		
	}	
	
	System.out.println("---------------------------");	

	for(Iterator<Integer> i = l.iterator();i.hasNext();){//最后一个++操作在方法体中i.next();hasNext不会取出任何东西,推荐
			System.out.println(i.next());
	}

	for (Integer i : l) {
		System.out.print(i);//123
	}	
	System.out.println("--------普通循环不用-------");
}

 循环格式:
for(集合中对象的类型 对象变量:需要遍历的集合){
	具体操作
}

-------------------------------------------
Iterator和 for each的区别： 
1,for each 不能删除集合元素 
2,Iterator 只能使用自身的remove()方法来删除元素,不能用集合的删除操作 
3,ArrayList里,for循环较快,LinkedList里,使用iterator较快

//这里测试虽然没有问题,但原来我遇到过删除不了情况(错误的方式)
错误的:
public void delete(String id){
	for(CartItem item : items){
		if(item.getId().equals(id){
			items.remove(item);//这是错误的不能使用集合items来删除,可能出现线程并发异常
		}
	}
}

正确的方式要使用Iterator删除时使用it来删除(推荐,很爽)
public void delete(String id){
	for(Iterator<CartItem> it = items.iterator(); it.hasNext();){	
		CartItem item = it.next();
		if(item.getId().equals(id){
			it.remove(item);//使用iterator 删除
		}
	}
}


//数组转list错误的方式和正确方式；但这里删除推荐jdk8的removeIf来
	public static void main(String[] args) {     
	        String [] s = {"1","2","1","2"};
	        List<String> l = new ArrayList();
			
	        l = Arrays.asList(s);//错误方式
			l.remove(0);//报错java.lang.UnsupportedOperationException
			
	        List<String> l2 = new ArrayList(Arrays.asList(s)); //推荐使用  		
	        l2.remove(0);   		
	        System.out.println(l2.size());
	        System.out.println(s.length);       
	}

----------------------------------------
数组有个工具类 Arrays ,集合也有一个工具类(包含Map) Collections
----------------------------------------
Map
			
Map 接口(键值对的数据,api中的方法下面所有子接口实现类共享)
一个key--value 对,是一个Entry(包含键和值).所有的Entry是用Set存放的,不可重复.
	|---HashMap(主要使用,key是通过Set来存放的,所以不可重复,若相同保留是最后添加的那条)
	|---LinkedHashMap:使用了链表来维护添加Map中的顺序.
	|---TreeMap:按照添加进Map中的元素的Key的指定属性进行排序.要求Key必须是同一类的对象
	|---Hashtable(古老的,线程安全)
	    |---(子类:Properties):常用来处理属性文件,注意键和值都是String类型的
				public class Properties extends Hashtable<Object,Object> 
/**
 * 如何遍历Map集合:
 * 1,keySet(只能得到key)
 * 2.values(只能得到value)
 * 3,entrySet(键值都可以得到)
 */
public class MyMap {

	public static void main(String[] args) {		
		Map<String,Integer> map = new HashMap();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 3);	
		
		//通过entrySet,循环得到（推荐）
	    for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() +"=="+ m.getValue());
        }
	
		//2,通过keySet 返回的是一个Set得到的只是key的值,通过key又可以得到value(不推荐)
		Set s = map.keySet();
		for(Object o : s){
			System.out.println(o+"---"+map.get(o));//o是键,get(o)得到值		
		}	
		
		//3,只能得到value值(可以是增强for ,iterator)不推荐
		Collection c = map.values();
		Iterator i = c.iterator();
		while(i.hasNext()){
			System.out.println(i.next());//打印:1,2,3,3			
		}		
	}

}

---------------------------------------------------
了解，这种3方jar包多，直接百度最好
import com.commontools.xml.XmlTool;

Map<String, Object> map = new HashMap<String, Object>();
map.put("service", "pay.weixin.native");
String params = XmlTool.mapToXml(sParaTemp); // 把参数map转化为xml格式的字符串
------------------

Xml转Map // 把微信返回的xml结果解析为map
Map<String, Object> responseMap = XmlTool.xmlElements(str_result); 

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
比较2个不同对象的值是否相等(目的是为了排序):

实现这两种接口的第一种:comparable 或 comparator（推荐）后类才具有可比较性后,才可能如排序的现实

Person person1 = new Person("aa", 22);
Person person2 = new Person("aa", 22);

如果普通的比较一定是不相当等的,这时我们就需要实现comparable或comparator
而hashCode,equals同compareTo方法没有直接联系，只是为了逻辑一致我们常常也会重写
hashCode 和equals(主要针对于集合使用会需要这两个方法)；comparable或comparator这两个接口
都会调用每个类的compareTo()方法；

comparable和Comparator区别:
Comparator 推荐使用,因为它不用修改实体类的源码,思路一模一样,只是算法写的地点不一样	
-------------------------------------------------------------------

	@Test
	public void test() {
		// 第一步:建立comparator 比较方式的的方法（相当一套独立的算法当作参数使用）
		Comparator comparator = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				int i = o1.getId().compareTo(o2.getId());
				if (i == 0) {
					return o1.getName().compareTo(o2.getName());
				} else {
					return i;
				}
			}
		};
		

		
		// 第二步:通过TreeSet构造器传入自定义的比较方式
		
		Set<Person> treeSet = new TreeSet<Person>(comparator);
		Person c1 = new Person(1, "a");
		Person c3 = new Person(5, "c");
		Person c4 = new Person(4, "d");
		// 后面的一样:加入参数 进行比较
		treeSet.add(c1);
		treeSet.add(c3);
		treeSet.add(c4);
		
		Iterator<Person> it = treeSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().getId());
		}
		

	}


	/**
	 * 
	 * 第二种写法:更为匿名的方式
	 */
	@Test
	public void test() {
		//建立comparator 比较方式的的方法.（上面是分开写的，这里是写在一起的）
		Set<Person> treeSet = new TreeSet<Person>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				int i = o1.getId().compareTo(o2.getId());
				if (i == 0) {
					return o1.getName().compareTo(o2.getName());
				} else {
					return i;
				}
			}
		});
		
		Person c1 = new Person(1, "b");
		Person c3 = new Person(1, "a");
		Person c4 = new Person(4, "d");
		//id一样还会比较年龄
		treeSet.add(c1);
		treeSet.add(c3);
		treeSet.add(c4);
		Iterator<Person> it = treeSet.iterator();
		while (it.hasNext()) {
			Person p = it.next();
			System.out.println(p.getId()+"=="+p.getName());
		}

	}

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

枚举类(有点像内部类)

https://www.cnblogs.com/singlecodeworld/p/9887926.html

枚举的作用:
小范围数据库(一般是多个常量的集合)

好处:
含义明确,类型限制.
举例:一周的时间,不能使用int 直接来表示,因为可能出现8,还有就是使用1,业务含义也不明确;

注意:
枚举变量是常量(建议大写)多个之间用,号分割,最后一个用;结尾
枚举常量必须在其他成员之前
枚举中的构造器默认是私有.可以不用手动写
switch 支持枚举类,因为ordinal 方法.可以得到int类型的索引
switch 支持的类型有 : byte,char,short,int及包装类,枚举; 1.7,时有增加了String(因为hasCode返回一个int)


原始方法如何定义一个枚举类:
1,私有化构造器.
2,在类的内部创建枚举类的实例. 声明为 public static final
3,若有类属性,属性在构造器中赋值.属性声明为 :private final


1.5版本后 新特性,简化优化后 用 enum 关键字如何定义枚举类
//使用新特性来创建一个枚举类
enum Season {
	
	/**
	 * 第二步,对构造器进行实例话,新特性要求这个写在最上面 (这个可能会被面试官问到)
	   原始写法:public static final Season SPRING = new Season("spring", "春暖花开");	   
	   SPRING 就好比匿名内部类
	 * 
	 */
	SPRING("spring", "春天"),SUMMER("summer", "夏日炎炎"),
	AUTUMN("autumn", "秋高气爽"),WINTER("winter", "白雪皑皑");


	private final String seasonName;
	private final String seasonDesc;

	/**
	 * 1,第一步私有化构造器(不能通过new来创建对象,单例),成员变量在构造器中赋值,
		被final修饰可以在构造器赋值,但如果加了static就需立即赋值
	 */
	private Season(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}
	

	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc="
				+ seasonDesc + "]";
	}

}


//为什么要使用枚举?这里有点像map;用户传来一个值,通过循环的方式去找到对象的key然后得到值
//比如用户传来"spring"(原来对应的1)这样可读性变高;我们可以根据"spring"得到value,就是1.这样又保证了数据的安全性
//其实最后发现这些功能在常量上都能完成,为什么?答:枚举可以看见范围values方法

public static void main(String[] args) {
	//把下面这个方法直接放入枚举类中
	Season[] ss = Season.values();	
	for (Season season : ss) {
		if("spring".equals(season.getName())){
			System.out.println("返回你需要的值=" + season.getDesc());		
		}
	}
}
--------------------------
其中常用的方法:
values()返回类型为枚举类型的数组
valueOf(String name);传入字符串(大小写必须和声明的一致)得到对象

枚举类如何实现接口(不看,工作中没看见使用):
让类实现此接口,类的对象共享同一套接口的抽象方法的实现.
让类的每一个对象都是实现接口的抽象方法,进而通过类的对象调用被重写的抽象方法时,执行的效果不同
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
注解 Annotation

JDK提供的 常用注解:
@Override:表示是重写的父类的方法;该注释只能用于方法,比如我们常常用的toString()方法,
@Deprecated: 已过时;用于表示某个程序元素(可以修饰类,方法等)
@SuppressWarnings :抑制编译器警告

2,原注解: 修饰注解的注解

Retention:生命周期 SOURCE CLASS RUNTIME(必须)
Target :修饰的范围(必须)
Documented :是否能被javadoc解析
Inherited :是否具有继承性

使用场景: 数据库和类的字段的映射


//ElementType.METHOD 表示方法上可以使用,ElementType.Type 表示类或接口上可以使用
@Target({ElementType.METHOD,ElementType.Type})//说明自定义注解的使用范围;
@Retention(RetentionPolicy.RUNTIME)//生命周期分为:源码 < 编译 < 运行;这里使用的运行
@Inherited//可以继承,只能使用在类上
@Documented//可以生成javadoc,就是可以生成api文档

//上面都是元注解;每一个自定义注解都需要使用上面几个元注解;

//1,使用@interface 关键字定义注解
public @interface Description{	
	String desc();//2,成员以无参,无异常的方式声明
	String author();
	int age() default 18;//3,使用default为成员指定默认值;
	String value();//4,如果只有一个成员时,只能使用value作为名字;约定
	//5,如果一个定义注解没有一个成员就是标示注解
}

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
java7新特性
前提使用JDK7的包

1,新增二进制的表示方式:
System.out.println(123);//123十进制
System.out.println(0123);//83八进制
System.out.println(0x123);//291十六进制
System.out.println(0b0110);//6二进制

2,使用_线对数值进行分割表示.
System.out.println(1_2_3);//123 Java数值

3,增强版的随机数,支持线程安全,效率提高,且支持定义随机数范围.
ThreadLocalRandom 
System.out.println(ThreadLocalRandom.current().nextInt(1, 3));//只出现1,2
System.out.println(ThreadLocalRandom.current().nextDouble(1.10, 3.20));//1.3400984454836864

4,泛型的菱形语法,后面的只需要写<>就OK，原来必须和前面一样（只是少写2个单词）
Map<String,Object> map = new HashMap<>();

5,try(这里面开启资源){} 会自动关闭开启的资源,无需再去 finally 判断关闭

举例:
try (FileWriter fw = new FileWriter("c:/aa.txt")) {
		
} catch (Exception e) {
	e.printStackTrace();
}

6,增强的 throws ,可以抛出比方法上的异常大的异常. 

7,NIO 异步IO 
在内存中读写文件(加快速度),加入锁机制(提高安全);
//有很多方法,这里暂时看一下复制
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copy {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//50M,秒传
		URI uri = new File("/Users/tusm/Downloads/J2SE6.0_CN.chm").toURI();
		Path source = Paths.get(uri);
		Files.copy(source, new FileOutputStream("/Users/tusm/Downloads/J2SE6.0_CN2.chm"));
	}
}

另：

//得到相对路径,很实用
Path p = Paths.get(".");
System.out.println(p.toAbsolutePath());

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
反射
reflection  反射 
generic 泛型

****************************************************************
过程:
class类.java经过编译(javac.exe)以后,得到.class文件也叫字节码文件
再运行java.exe会运行JVM的 getClassLoader() 类的加载器 把.class文件加载到内存中的缓存区
.每一个放入缓存区中的.class文件 就是 一个Class的实例! (每一个运行时类只加载一次)
****************************************************************

反射是动态语言的基础.
类是对象的描述,对象是类的实例(经典呀)

万物皆对象那么类也应该是一种对象,既然类是一种对象,那么谁描述该对象?

JRE保留一个的Class抽象类.这个Class类(可以理解为对象)可以得到某个类的描述（类的定义）如:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
成员变量,形参,函数,构造器,实现了那些接口等,反射在运行期间得到这些信息,也就是反射存在的目的
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
反射只要理解了上面2句话,对于使用上就是 easy 的事.

Class 对象只能由系统生成
每一个类在JVM中只会有一个Class实例


java.lang.Class类是反射的源头!

Class的一个对象,就是那份字节码
Class实例:就是指JVM中的一份字节码 类.class 就是一份字节码

(JVM中只有一份字节码,新的覆盖原来的,另字节码只有在程序中使用到才会被加载到内存中,意思不是所有的class文件都会被加载到内存中)

Eclipse中的Outline视图就是通过反射机制做出来的
Class描述的是一切类,Object是描述一切对象
------------------------------------------------------------
获取Class实例的三种方式(就是那份类.class字节码):得到实例后我们就可以反射得到一切

//第一种:根据类名.class得到;速度最快,最稳定,但因为不能动态不常用
Class clz1 = String.class;
//第二种: 根据全路径得到,可能抛出空异常,但常用
Class clz2 = Class.forName("java.lang.String");
Object obj = new Date();
//第三种: 根据对象得到(说明已经在内存中了)
Class clz3 = obj.getClass();
System.out.println(clz1);//class java.lang.String
System.out.println(clz2);//class java.lang.String
System.out.println(clz3);//class java.util.Date
--------------------------

Constructor构造器,Mothod方法,Field成员变量等的信息:
比如想得到方法的返回值类型,修饰符,等都是Method类Api去找
--------------------------

开始使用,Class类API更加准确且多

获取类的构造器
public Constructor<?>[] getConstructors()// 返回只是public修饰的构造器
public Constructor<T> getConstructor(Class<?>... parameterTypes) //返回一个public修饰且根据参数类型去找对应的构造器

public Constructor<?>[] getDeclaredConstructors() //返回全部
public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)//根据参数获取构造器和访问权限无关


如 :clz.getConstructor(String.class); //返回一个public修饰且参数为一个String类型的构造器
-----------------------------------------
注意:不带Declared只能得到public修饰的,
根据上面的可以看出一共分为2类,获取全部和获取一个;然后都有获取public和于权限不关的.这样的规律

	/**
	 * 获取类全部的构造方法
	 */
	@Test
	public void constructor() throws ClassNotFoundException {
	
		Class clazz = Person.class;
		Constructor[] con = clazz.getDeclaredConstructors();
		// 假如要调用指定的构造器,我们传入指定的参数类型就Ok		
		
		for (Constructor constructor : con) {
			System.out.println(constructor);
		}
	}
	
----------------------------------------------------------------------
public T newInstance()

得到Class对象的实例,如果一个类中有public且有无参的构造器可以省略getConstructor方法.

对于有参数的构造器先使用getConstructor(Class<?>... parameterTypes)得到实例,在使用newInstance("实际参数")传进去参数
如: Employee e = clz.getConstructor(String.class).newInstance("小明"); 

对于private 修饰的加Declared,但为了安全考虑默认是不能直接访问私有构造器,解决方法如下:

constructor.setAccessible(boolean flag)//设置为true,表示允许访问

再调用newInstance(); //得到对象实例.
---------------------------------------------------------------
方法如何调用:

public Method[] getMethods()//得到public 修饰且包含继承或接口
getMethod(String methodName, Class<?>... parameterTypes) //返回指定方法,参数:方法名,可变参数类型;
getDeclaredMethods() //返回自身类的方法,不包含继承或接口,且和修饰符无关

上面得到方法后如何调用?

public Object invoke(Object obj, Object... args);
//参数1,构造器实例对象,args:方法里的实际参数,返回就是方法底层返回的结果

举例:
Class clz = User.class;
//获取一个方法
Method method = clz.getMethod(String.class);
//调用一个方法
method.invoke(clz.newInstance(),"小明");//第一个参数可以new User(),但为什么还会用发射啦?一般不可能这么用

--------------------------------------------------------------------
注意:在调用私有方法之前(invoke方法),要设置可访问.
constructor.setAccessible(boolean flag)//设置为true,表示允许访问

单利模式在反射面前就是透明的,但可以用一个静态变量count计数来防止

枚举单例,不能用newInstance方法,但反射可以的
---------------------------------------------------------------------
静态方法的调用:

如果底层方法是静态的,那么可以忽略指定的Object参数,传入null即可.
method.invoke(null,"小明");
---------------------------------------------------------------------
如果底层方法是一个可变参数怎么调用?

Method m = clz.getMethod("show2",int[].class);
m.invoke(null,int[]{1,2,3,4);


但是又个别参数会被自动解包,如String[],我们可以使用Object的一维数组包装一次
Method m = clz.getMethod("show1",String[].class);
m.invoke(null,new Object[]{new String[]{"小","时","候"});

因为一劳永逸的解决这个问题,结论是无论什么时候我们都加上这 new Object[]{"实际参数"}包装一次

--------------------------------------------------
通过反射获取字段:

和构造器,方法一样都是4个方法
获取全部,含继承或接口 getFields()
获取全部,不包含继承或接口 getDeclaredFields();

获取指定,含有继承或接口 getField(String name);
获取指定,不包含继承或接口 getDeclaredField(String name);
返回的是一个Field 对象.

当然它们的第一步都是获取字节码.
--------------------------------------------------
上面已经得到了字段的对象.如果想对这个字段赋值需要两步:
1,得到字段的对象.
2,给字段赋值

setXxx(Object obj, Xxx i) 
//参数obj就是字段的对象,参数Xxx : 需要设置的值
如:
ageField.setInt(User, 25);
注意:如果底层字段是静态 static 这里obj 就需要设置为 null,因为静态字段不属于某一个类 

Class clz = User.class; //得到字节码
Field ageField = clz.getDeclaredField("age");//得到字段对象
ageField.setAccessible(true);//对于private权限修饰的字段需要设置允许访问
User user = clz.Instance();//得到字节码的实例
ageField.setInt(user,24);//对字段设置值

注意:在User底层类中可以没有geter和setter方法,一样的可以设置参数值(这么强)
----------------------------------------------
获取字段的值

getXxx(Object object);//获取8种基本数据类型,参数是字段对象,返回Xxx类型
get(Object object);//获取引用数据类型,参数是字段对象,返回object类型
----------------------------------------------
Class类相关api:

int getModifiers():获取修饰符,返回的int值可以toString得到修饰符字符串
String getName():返回类的全限定名
package getPackage():获取该类的包
String getSimpleName():获取类的简单类名
Class getSuperClass():获得类的父类
boolean isArray():判断该Class实例是否是数组
boolean isEnum(): 判断该class实例是否是枚举
----------------------------------------------
如何获取Class的实例下面举了4种方式:

@Test
public void testInstance() throws ClassNotFoundException{
	
	Class p1 = Person.class;
	Class p2 = person.getClass();		
	Class p3 = Class.forName("com.entitys.Person");	
	//通过类的加载器,这里方法就能体现出反射的动态性	
	Class p4 = this.getClass().getClassLoader().loadClass("com.entitys.Person");

	//下面打印的hashCode都一样,只有第一才会被加载,后面直接在内存读
	System.out.println(p1.hashCode());
	System.out.println(p2.hashCode());
	System.out.println(p3.hashCode());
	System.out.println(p4.hashCode());
}

如何创建Class的实例?(重点)
上面4种方式在.newInstance();//得到实例对象,实际上就是调用了空参的构造器

-------------------------------------------------
简单使用:
@Test
public void test() throws Exception {

	Class clazz = Person.class;
	Person p = (Person) clazz.newInstance();
	
	Field f = clazz.getField("name");//这是public 修饰的成员变量
	f.set(p, "黄举飞");

	
	Field f2 =clazz.getDeclaredField("age");//这是privte修饰的成员变量
	f2.setAccessible(true);
	f2.set(p, 22);
	
	
	Method m = clazz.getMethod("show");	//public无参的方法	
	m.invoke(p);//如果方法没有返回值,返回null
	
	Method m2 = clazz.getDeclaredMethod("show2");
	m2.setAccessible(true);
	m2.invoke(p);
	
	Method m3 = clazz.getMethod("show",String.class);//public有参的方法	
	m3.invoke(p,"四川");
	
	Method s = clazz.getMethod("sh");//调用静态的方法
	s.invoke(person.class);
	
}
-----------------------------------------------------
Field

getFields():只能得到 public 修饰的属性,及其父类的属性
getDeclaredFields():可以得到全部属性,不包含父类

/**
 * 需求:获取 成员变量的修饰符,类型,名字
 (更多方法可以看Filed类的API)
 */
@Test
public void testField() throws Exception {
	
	Class clazz = Person.class;
	Field[] fields = clazz.getDeclaredFields();//不包含父类的任何类型	
	
	for (Field field : fields) {
		int i = field.getModifiers();//获取成员变量权限修饰符
		String modifier = Modifier.toString(i);//上面返回的是一个int类型的值
		System.out.print(modifier + " ");
		Class type = field.getType();//获取成员变量类型
		System.out.print(type + " ");
		String name = field.getName();//获取成变量性名字
		System.out.println(name);		
	}
}
-----------------------------------------
Method

Method[] m1 = clazz.getMethod();获取到对应的运行时类中声明为public方法(包含父类)
Method[] m2 = clazz.getDeclaredMethod();(获取对应运行时类声明的所有方法,但不包含父类)

/**
 * 获取方法的 注解 修饰符 返回值 名字 参数列表 异常
 (更多方法可以看Method类的API)
 */
@Test
public void testMethed() throws Exception {
	
	Class clazz = Person.class;
	Method[] methods = clazz.getDeclaredMethods();//不包含父类的任何类型	
	
	for (Method method : methods) {
		//声明在方法上的注解
		Annotation[] ann = method.getAnnotations();
		
		for (Annotation annotation : ann) {
			System.out.print(annotation + " ");			
		}
		//方法的修饰符
		String modifier = Modifier.toString(method.getModifiers());
		System.out.print(modifier+ " ");
		
		//返回值类型
		Class type = method.getReturnType();
		System.out.print(type+ " ");
		
		//方法名字
		System.out.print(method.getName() + " ");
		
		//参数类型列表
		Class[] param = method.getParameterTypes();
		
		if(param.length > 0){
			System.out.print("(");
		}
	
		int ii = param.length;
		for (int i = 0; i < param.length; i++,ii--) {

			System.out.print(param[i]+" ");
			if(ii == 1){
				System.out.print(")");
			}	
		}
		
		//方法上的异常
		Class[] exType = method.getExceptionTypes();
		for (Class class1 : exType) {
			System.out.println(class1);			
		}		
		System.out.println();		
	}
}
---------------------------------------------------------------

Java中9个预定义的Class实例(工作中没用到,但面试可能会问)
八个基本类型 4个整数 2个浮点 1个boolean 1个char 另加一个void


8大基本数据类型 中有一个常亮TYPE
Integer.TYPE == int.class //打印true,TYPE就是基本数据类型的Class实例

注意,Integer.class == int.class //打印 false,因为它们根本不是一种数据类型
------------------------------------------------------------
数组也是可以.class ,数组的比较结果和 类型和维数 有关系

String [] s = {};
String [] s1 = {"a","b"};
Class s3 = s.getClass();

System.out.println(s.getClass() == s1.getClass());//true
System.out.println(String [][].class== s3);//false 维数不一样

当然类型不一样结果肯定是 false
------------------------------------------------------------
/**
 * 获取父类的泛型,jdbc 必用(这个调式失败)
 */
@Test
public void superGeneric(){
	Class clazz = Person.class;
	Type type1 = clazz.getGenericSuperclass();
	
	ParameterizedType param = (ParameterizedType) type1;
	Type[] ars = param.getActualTypeArguments();
	
	System.out.println(((Class)ars[0]).getName());
	
}

clazz.getInterfaces();//获取实现的接口
clazz.getPackage();//获取所在的包
clazz.getAnnotation();//获取声明在类上的注解
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
静态代理

package comproxy;

/**
	根据设计模式来说：代理类持有被代理的引用	
   所谓代理，只是一个转发；真正的事还得由被代理来做；
 * 静态代理:要求被代理类和代理类同时实现一个相应的一套接口,
      代理类中去添加额外的逻辑后再调用被代理方法.
 *
 */
interface ProduceFactory {	//接口:生产工厂	
	void action();
}
//被代理类,实现了接口
class Nickfactory implements ProduceFactory{//被代理类
	@Override
	public void action() {
		System.out.println("Nick 运行中.... ");
	}
}
//代理类,实现了接口
class ProxyClass implements ProduceFactory{//代理类
	
	ProduceFactory pf;
	
	//通过构造器的方式传入被代理的对象.
	public ProxyClass(ProduceFactory pf) { 
		this.pf = pf;		
	}

	@Override
	public void action() {
		System.out.println("代理工厂运行中..,加入日志或其他逻辑功能");
		pf.action();//pf 是被代理的对象 ,当然执行的是被代理的方法
	}	

}

public class StaticTest {
	public static void main(String[] args) {		
		Nickfactory nick = new Nickfactory();
		ProxyClass pc = new ProxyClass(nick);
		pc.action();		
	}
}
--------------------------------------
动态代理—(底层依赖反射实现,精华)


动态代理:
在程序运行时,动态的创建一个代理类.
当调用代理类的实现的抽象方法时,就会转调被代理类的同样的方法

动态代理和静态代理的区别：

静态代理需要代理和被代理都实现同一接口，动态代理不需要

静态代理只服务于一种类型的对象，如果要服务多类型的对象。需要为每一种对象都进行代理.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

涉及到的技术点:(重点)
1,自定义类然后实现InvocationHandler接口,重写invoke()方法.

//使用时通过Proxy静态方法调用，在这句话运行时才会创建代理类这就是多态代理
2,Proxy.newInstance(obj.getClass().getClassLoader(), obj.getClass().getInterface(), h);
//注:obj :被代理类的对象; h:实现了invocationHandler接口的实现类的对象

具体代码如何写,和细节在这个链接
http://www.cnblogs.com/xiaoluo501395377/p/3383130.html
---------------------------------------------
jdk和CGlib 动态代理如何选择?

如果有接口我们选Jdk动态代理,没有接口选CGlib动态代理

++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++
IO(input,output)流

IO操作都依赖操作系统,这是为了系统安全的考虑,只要是系统调用就存在用户空间和内核空间切换的问题;
read从内核地址空间到用户地址空间,writer从用户地址空间到内核地址空间

IO流的作用(站在硬盘的角度):
数据从内存到硬盘（output写writer）,从硬盘到内存(input读read)的转换

java对数据的传输是通过流的方式;java用于操作流的对象都在IO包下
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

流按操作数据分为: 字节流(8bit) 和 字符流(16bit) 
流按流向分为    : 输入流 和 输出流

***********************************************
字节流的抽象类 InputStream,Outputstream 
字符流的抽象基类 Reader,Writer 																  
(其它40几个类都是以上面抽象类名作为后缀的)


数据的最常见体现形式是 File类.

File 类对象中的方法只有文件创建,删除,重命名等表面功能,**对于修改内容只能有io流来完成, 
File对象常作为io流的具体类的构造器的形参存在.


抽象基类(不能new)  四个基本文件流(统一多了一个File)   缓冲流(处理流的一种,可以提升文件操作的效率,统一Buffered开头)
	InputStream       FileInputStream          BufferedInputStream
	OutputStream      FileOutputStream         BufferedOutputStream(flush())
	Reader            FileReader               BufferedReader(readLine())
	Writer            FileWriter               BufferedWriter(flush()) 

注:
1,从硬盘中读入一个文件,要求此文件一定存在,若不存在则报FileNotFound的异常
2,从程序中输出一个文件到硬盘,此文件可以不存在.若不存在,就创建一个实现输出.存在覆盖(也可以不覆盖)
3,开发时,尽量缓冲流
4,先关输出流output,在关闭输入流input.将此操作放入 finally{}中

----------------------------------------------------

/**
 * FileInputStream 的hello
 * 注意:不能读汉字,这里我忽略try,catch,finally
 */
@Test
public void test(){
	
	FileInputStream input = null;
	input = new FileInputStream(new File("hello.txt"));	//File对象往往以参数的形式存在		
	int b;
	while( (b=input.read()) != -1 ){//read 如果读到没有了返回-1
		System.out.print((char)b);//本身读出来的是ASCII编码 (全数字),加char强转 
	}	
}

/**
 * FileOutputStream 的hello :相当于这就把内存的数据;永久的保存到了磁盘上
   用字节流写字符串 需要getBytes()转为字节 ,字符流写入字符串则不需要
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 特别注意:会将原有数据覆盖..小心
 */
@Test
public void outStream(){ 
	FileOutputStream output = null;
	//File:目的文件中
	output = new FileOutputStream(new File("hello.txt"));
	//将一个字符串转为数组再用流来写入 .特别注意:会将原有数据覆盖..小心
	output.write(new String ("123456asd").getBytes());
}



/**
 * 字符流只能是纯文本文件(不含图片),不然选字节流
 * 调节byte大小可以提升效率,加入缓冲流 更效率
 */	
@Test
public void copyText(){	
	FileReader fr = null;
	FileWriter fw = null;	
	fr = new FileReader(new File("hello.txt"));	//File对象往往以参数的形式存在	
	fw = new FileWriter(new File("hello3.txt"));	
	char[] b = new char[1024];//换为char类型,字节流是byte类型
	int len;//记录:实际读取好多数值
	while((len = fr.read(b)) != -1){
		fw.write(b, 0, len);//这里注意千万不能是b.length 或 b.	
	}
}


/**
 * 实际开发我们都使用缓冲包装后的流,效率最优
 * 注意:需要flush() 刷新一下
 * 220M 时间为 755毫秒(前提是1024*2)
 */	
@Test
public void Bufferedcopy(){
	
	long start = System.currentTimeMillis();	
	BufferedInputStream bis= null;
	BufferedOutputStream bos = null;
	try {		
		bis = new BufferedInputStream (
				new FileInputStream(new File("C:/Users/Administrator/Desktop/SVN.rar")));	
			
		bos = new BufferedOutputStream (
				new FileOutputStream(new File("C:/Users/Administrator/Desktop/2SVN.rar")));
		byte[] b = new byte[1024];//根据实际需求调节大小
		int len;//记录:实际读取好多数值
		
		//read方法只要不等于-1就说明还有数据,一般通过while循换操作,把读出的数据放到byte数组中,读满1024后写到输出流中
		//用len记录实际长度,主要就是针对最后一次,前面都是满的(自定义大小);读完一次写一次这样循环完成的复制功能	
		while( (len = bis.read(b)) != -1){
			bos.write(b, 0, len);
			bos.flush();//缓冲流我们最后要刷新一下
		}
		long end = System.currentTimeMillis();
		System.out.println("加入缓冲流复制需要的时间为:" + (end - start));
	}
}


/**
 * 
 * 转换流: 
	InputStreamReader  :输入字节流转Reader
	OutputStreamWriter  :输出字节流转Writer

 */	
@Test
public void switchStream() throws Exception{
	
	InputStreamReader isr = null;
	OutputStreamWriter osw = null;
	//转换流 就是在编码和转码的过程,后面跟用是加密,解码的时候也得用对应的编码解密.
	isr = new InputStreamReader(new FileInputStream(new File("hello.txt")),"utf-8");
	osw = new OutputStreamWriter(new FileOutputStream(new File("hello2.txt")),"GBK");//这样无法解密
	
	BufferedReader br = new BufferedReader(isr);//最后类型是字符流,那么包装类就是字符流
	BufferedWriter bw = new BufferedWriter(osw);
	
	char[]  b = new char[1024];
	String str; //一次读一行返回的是一个String类型
	//字符流可以使用readLine一次读一行,字节流原来判断-1,这里判断null原理一样
	while( (str = br.readLine()) != null ){
		bw.write(str);
		bw.newLine();//写完一行后 换行
		bw.flush();//记得刷新
	}
}

----------------------------------------------------
读取键盘录入:
java.lang.System
System.out:对应的是标准输出设备,控制台.
System.in:对应的标准输入设备:键盘.
-----------------------------------------------------	

打印流(所谓打印流,只有输出流)：

字符流：PrintWriter (比BufferedWriter还方便)
字节流: PrintWriter则不同,一定要在构造方法中设置自动刷新或者在调用println()方法以后再调用flush(),才可以立即完成输出。
//字符打印流(PrintWriter)
@Test
public void testPrintStream() throws IOException {	
	BufferedReader br = new BufferedReader(new FileReader("in.txt"));
	PrintWriter pw = new PrintWriter(new FileWriter("out.txt"));	
	String s = br.readLine();		
	while (null != s) {
		// PrintWriter的println方法 相当于 BufferedWriter 的write() + newLine()
		pw.println(s);
		s = br.readLine();
	}
	br.close();
	pw.close();
}

-------------------------------------------------	
数据流(没有字符流，居然工作中很少用，可以加密)

DataInputStream 和 DataOutputStream

写入数据流我们可以按我们定义类型写,这样有加密的效果.解析时必须对应才可以读处数据 

读取数据流值得我们注意的是和传统读法不一样 ,必须是对应的加密类型来读
--------------------------------------------------

对象流(没有字符流)
ObjectInputStream 和 ObjectOutputStream

对象的序列化过程：将内存中的对象通过ObjectOutputStream转换为二进制流,存储在硬盘文件中
对象的反序列化过程：将硬盘中的二进制文件通过ObjectInputStream转换为相应的对象
(全部过程于平台无关，但不要乱用；序列化性能很差)

如何实现序列化的类：
1,要求此类是可序列化的：实现Serializable接口
2,要求类的属性类同样的要实现Serializable接口
3,提供一个版本号：private static final long serialVersionUID(防止修改后可能找不到这个对象)
4,使用 static 或 transient 修饰的属性,不可实现序列化

/**
 * 描述 : Object转byte[]
 */
private byte[] toByteArray(Object obj) {
	byte[] bytes = null;
	ByteArrayOutputStream bos = new ByteArrayOutputStream();
	try {
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		oos.flush();
		bytes = bos.toByteArray();
		oos.close();//这个放finally
		bos.close();
	} catch (IOException ex) {
		ex.printStackTrace();
	}
	return bytes;
}

/**
 * 描述 : byte[]转Object
 */
private Object toObject(byte[] bytes) {
	Object obj = null;
	try {
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bis);
		obj = ois.readObject();
		ois.close();//这个放finally
		bis.close();
	} catch (IOException ex) {
		ex.printStackTrace();
	} catch (ClassNotFoundException ex) {
		ex.printStackTrace();
	}
	return obj;
}
--------------------------------- 
RandomAccessFile:随机流 支持输入,输出文件流 (根据model来决定是什么)

构造器
public RandomAccessFile(File file, String model) 
public RandomAccessFile(String name, String model)
 
model 参数指定 RandomAccessFile 的访问模式：
r: 以只读方式打开
rw：打开以取和写入
rwd:打开读取和写入；同步文件内容的更新
rws:打开读取和写入；同步文件内容和元数据的更新

另:随机流中有个seek(int index)方法,可以完成覆盖原数据的功能.
---------------------------------
/**
 * 需求:在文件中的第4个字节后添加 "xy真" 
 
 * 本身seek()方法直接使用时覆盖的效果(read()可以读汉字(一个汉字3个位置)但readLine()的方式只能是字母)
 * 
	思路:指针先到第4字节位置,然后后面的字节全部记录下来,再移动指针到第4位置后添加"xy" , 再把后面的字节添加回来
	RandomAccessFile 既可以读又可以写,还能指定位置;代码还更简洁
 */
@Test
public void randomAccessFile() throws Exception{	
	String  s = "xy真";
	RandomAccessFile rafw = null;
	rafw = new RandomAccessFile("d:\\hello.txt", "rw");	
	rafw.seek(4);//首先指针到第4个位置,只读取后面的数据	
	int len ;
	byte [] b = new byte[1024];
	StringBuffer sb = new StringBuffer();	
	while((len = rafw.read(b)) != -1){
		sb.append(new String(b, 0, len));//将数组转为字符串在添加到buffer中
	}
	rafw.seek(4);//找到文件第4个字符的位置
	rafw.write(s.getBytes());//然后加入s变量字符串,会立即写入到文件
	//int i = 1/0;
	rafw.write(sb.toString().getBytes());//再加入原文件第4字符后面的文字
}

--------------------------------------------------
/**
	需求:读取文件里内容转String类型
*平安mock(假项目)项目中，就是通过json.txt保存的返回前端的假数据(且定义了每个页面的返回格式)；
*/
使用org.apache.commons.io包读取文件更为简单:

import org.apache.commons.io.FileUtils;

File file = new File(Test1.class.getResource("/json.txt").getFile());		
//将文件类型转String类型；
String content = FileUtils.readFileToString(file);	
System.out.println(content);

org.apache.commons.io 关闭流更为简洁,底层和实现了AutoCloseable都可以使用通用关闭
++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * 读取配置文件两种情况
 * 1,在工程下
 * 2,在包下
 */

@Test
public void testClassLoader() throws IOException{
	//InputStream is = new FileInputStream(new File("db.properties"));//在一个工程下
	
	InputStream is = this.getClass().getClassLoader().getResourceAsStream("com\\entitys\\db.properties");//在一个包下
	Properties p = new Properties();
	p.load(is);
	String user = p.getProperty("user");
	System.out.println(user);
	
}
-------------------------------

Spring的Resource 接口

目的:
通过JDK中的File、URL类难以满足各种不同资源加载,Spring中设计的Resource接口提供获取文件资源(文件流,文件内容)
https://blog.csdn.net/xiaoliuliu2050/article/details/81463223

ResourceLoader是对资源加载的统一接口
所有的application 都实现了resourceLoader 接口,反过来说就是你得到ApplicationContext就可以得到Resource
得到resource就得到任何地方的文件对象.(可以是网络url,可以是本地文件绝对路径,可以是项目相对路径)

如何使用?
我们可以通过实现ApplicationContextAware接口得到application;然后得到resource

注意:我们需要对不同的地点的文件加前缀:
url:http://...//...(全部//线)
file:D:\apache-maven-3.2.5
classpath:applicationConfig.xml
如果不写前缀,默认在你的classes路径下找

classpath是指WEB-INF或target/classes/路径下
classpath和classpath*区别： 

classpath：只会到你的classes路径中查找找文件。

classpath*：不仅包含classes路径，还包括jar文件中（class路径）进行查找。
-------------------------------------------------------------------
//spring中读取配置文件
public static void main(String[] args) throws IOException {
		//不在jdk包中
		DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
		// Beans.xml这个文件在src/main/resources包路径下
		Resource resource = resourceLoader.getResource("classpath:Beans.xml");
		//也可以得到网络上的一个url
		//Resource resource = resourceLoader.getResource("https://www.baidu.com");
		URL url = resource.getURL();
		System.out.println(url);
		InputStreamReader input = new InputStreamReader(resource.getInputStream());
		BufferedReader b = new BufferedReader(input);
		String s = b.readLine();
		while (s != null) {
			System.out.println(s);
			s = b.readLine();
		}
		b.close();
	}

++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++
Socket{插座}

Socket就是java为网络服务提供的一种机制.网络通信其实就是Socket间的通信

对于java来说网络编程就是Socket编程
*************************************

　Socket封装了和java与TCP/IP交互的复杂过程。在设计模式中，Socket其实就是一个外观模式，
它把复杂的TCP/IP协议族隐藏在Socket接口后面.

//Socket,Servlet和http的关系
http://blog.sina.com.cn/s/blog_17bce02530102y50d.html

Servlet：使用http协议在服务器与客户端之间通信的技术。是Socket的一种应用。

//servlet与tomcat的关系
https://blog.csdn.net/baidu_36583119/article/details/79642407

简单理解依赖关系:
Servlet -> socket -> tcp/ip  
servlet提供基于http协议上的接口扩张，且目前就提供了http协议这种，当然以后可以扩展其他的
HttpServletRequest（请求） HttpServletResponse （响应）

如何才能准确的定位 internet 上的一台主机?
答:  ip  (端口定位的是某一个程序)
~~~~~~~~~~~~~~~~~~~
ip定位到电脑,端口定位到一个应用,然后就是io操作


如何创建一个InetAddress的对象? 

InetAddress inet = InetAddress.getByNmae("www.baidu.com");//域名 或 ip
InetAddress inet = InetAddress.getByNmae("192.168.110.16");
	
inet.getHostName();//得到域名: 
inet.getHostAddress();//返回IP地址,真实ip(Ipv4)
inet.getLocalHost();//返回本地主机

http:\\www.hao123\te.tex.com //URL=传输协议 + 主机名(就是域名或ip) +端口 (http 默认端口80)+ 文件路径

URL :统一资源定位符 一个URL的对象,对应这互联网上的一个资源

IP地址一般分为4段,最大255,8位组成一段
本地回环地址127.0.0.1,可以测试网络.电脑默认就是这个地址.

现在都是一个地区一个公网,然后下面类似局域网分段划分.
现在出的TCP/ipV6,分为6段,还包括字母.

传输协议一般比较常见  TCP , UDP ,Ftp
应用层 http或ftp
---> 传输层 (Tcp或UDP）
----> 网络层 （IP）
----> 物理+数据链路层 link


UDP 
(如视屏教学)
将数据及源和母的封装成数据包,不需要建立连接.
每个数据包的大小限制在64k内.
因无连接,是不可靠的协议
不需要建立连接,速度快.
主要使用这2个类 DatagramPacket, DatagramSocket


TCP
通过三次握手完成连接,形成传输数据的通道.在连接中进行大数据传输.
必须建立连接,效率会稍低.如打电话

每一个程序就是一个进程,不同的进程端口号不同.有效端口0-65535,其中0-1023,系统使用或保留端口

常用的端口(port)号:
ftp 21   http 80  Oracle 1521   mysql 3306  


针对网络通信的不同层次,java 提供了网络功能有4大类:
1,inetAddress :用于标示网络上的硬件资源
2,URL :统一资源定位符,通过url可以直接读取或写入(需要权限吧)网络上的数据
3,Sockets :使用Tcp协议实现网络通信的Socket相关的类
4,Datagram:使用UDP协议,将数据保存在数据报中,通过网络进行通信.


-------------------------------------------------------
/**
 * TCP 的Hello World . 开发不能抛异常(了解)
 */
public class TestTcp {

	@Test//服务端
	public void Service() throws Exception {
		ServerSocket ss = new ServerSocket(8989);	
		Socket s = ss.accept();//阻塞式,会一直监听
		InputStream input = s.getInputStream();	//从Socket中可以得到输入,输出流,后面的又是老套路
		byte [] b = new byte[1024];
		int len;
		while((len = input.read(b)) != -1){
			System.out.println(new String (b,0,len));
		}	
		s.close();
		ss.close();
	}
	
	@Test//客服端
	public void Client() throws Exception {		
		Socket s = new Socket("127.0.0.1",8989);	
		OutputStream out = s.getOutputStream();
		out.write("Tcp我来了!".getBytes());//
		out.close();
	}
}

---------------------------------------------------------
/**
 * 关于URL这个类的方法 可以查看API ,驾校支付项目就用了这来和微信联络
	思考:是否和爬虫功能类似
 */
public class Url {
		public static void main(String[] args) throws Exception {
		// 创建一个URL实例
		URL url = new URL("http://www.baidu.com");
		// 通过url的openStream方法获取url对象所表示的资源字节输入流
		InputStream in = url.openStream();
		//URLConnection  urlc = url.openConnection();//第二种方式
		//InputStream input = urlc.getInputStream();	
		//下面又是老套路
		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String data = null;
		while ((data = br.readLine()) != null) {
			System.out.println(data);
			//data = br.readLine();
		}
		br.close();
		isr.close();
		in.close();
	}
}
----------------------------------------------------------
/**
 * UDP 适用于教学视频,不怕丢包的,大数据情况使用,了解
	发现数据都是byte[]的方式发送的;
 */
public class TestUdp {

	@Test
	public void Recevie() throws Exception {
		// 创建UDP服务,建立端点.这里不定义系统随机分配端口
		DatagramSocket ds = new DatagramSocket(8888);// 不能把这句放入while中
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, buf.length);//相当于一个数据篮子
		// 获取接受的数据,放入篮子里也是阻塞式方法
		ds.receive(dp);
		String data = new String(dp.getData(), 0, dp.getLength());
		System.out.println(dp.getAddress().getHostAddress() + "说:  " + data);
		ds.close();
	}
	
	@Test
	public void send() throws Exception {
		//创建UDP服务,通过 DatagramSocket对象.相当于中间人如邮局
		DatagramSocket ds = new DatagramSocket();	
		byte[] buf = "Udp我来了!".getBytes();
		// 将数据打包.相当于装入信封,写好地址
		DatagramPacket dp = new DatagramPacket(buf, buf.length,InetAddress.getByName("127.0.0.1"), 8888);	
		// 通过socket服务,将已有的数据包发送出去,通过send()方法.
		ds.send(dp);
		ds.close();
	}
}
--------------------------------------------------------

/* 
需求:就是一个单边发送,单边接收消息的小程序;如果是两边的相当于一个简易聊天室
没有实现的 :聊天室其实就是在复制一套单边程序,通过ip交叉的方式就完成了
 */
import java.net.*;
import java.io.*;//一般用了net包就会用io包



/**
*接收方:程序启动后就是不会死,只是会阻塞哪里,一旦收到消息就会打印收到的数据;
*/
class Rece implements Runnable{
	
	private DatagramSocket ds;	
	
	public Rece (DatagramSocket ds){
		this.ds = ds;	
	}
	
	public void run(){	
		try{
			//无限循环
			while(true){
				byte[] buf = new byte[1024];
				DatagramPacket dp = new DatagramPacket(buf,buf.length);
				ds.receive(dp);//阻塞的,把读到的数据放到DatagramPacket中
				String ip = dp.getAddress().getHostAddress();
		
				System.out.println(ip+"  "+new String(dp.getData(),0,dp.getLength()));							
			}		
		}
		catch(Exception e) {
			throw new RuntimeException("接收时出错");			
		}		
	}		
}


/**
*发送方:程序启动会在监控system.in的数据,如果遇到"886"会结束循环
*/
class Send implements Runnable{

	private DatagramSocket ds;
	
	public Send (DatagramSocket ds){
		this.ds = ds;	
	}
	
	public void run(){	
		try{
			BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));			
			String line = null;
			while((line=bufr.readLine())!=null){
				System.out.println("我看启动后是否会立即一直循环");
				if ("886".equals(line)) break;			
				//把line的转成字节然后存储到buf数组中
				byte[] buf = line.getBytes();
				DatagramPacket dp = new DatagramPacket(buf,buf.length,InetAddress.getByName("127.0.0.1"),4002);				
				ds.send(dp);			
			}			
		}
		catch(Exception e){
			throw new RuntimeException("发送时出错");			
		}		
	}	
	
}



/**
 * 核心:服务端默认监听了这个端口,客户端刚好向服务监听的端口发送的了消息
 */
public class zhuhanshu{ 
	public static void main(String[] args)throws Exception{	

		 new Thread(new Rece(new DatagramSocket(4002)).start();
		 
		 new Thread(new Send(new DatagramSocket())).start();
	}	
}

-----------------------------------------------------------------------
-----------------------------------------------------------------------
-----------------------------------------------------------------------
NIO(jdk1.4就有了)，BIO，AIO

github上有2个项目;

//入门(基础概念.精华)
http://www.cnblogs.com/dolphin0520/p/3919162.html
//基础（精华）
https://www.cnblogs.com/dolphin0520/p/3916526.html
//文件搜索等一系列（精华）
http://tutorials.jenkov.com/java-nio/files.html
//只看前2个url,关于netty的(封装了nio)
https://www.cnblogs.com/applerosa/p/7141684.html


在网上有一些朋友将同步和异步分别与阻塞和非阻塞画上等号，事实上，它们是两组完全不同的概念。

　　同步和异步着重点在于多个任务的执行过程中，一个任务的执行是否会导致整个流程的暂时等待；
（如果A，B两个线程执行io操作，同步需要排队，A执行完了才能轮到B执行；异步同时执行）


　　而阻塞和非阻塞着重点在于发出一个请求操作时，如果进行操作的条件不满足是否会返会一个标志信息告知条件不满足。

同步异步主要是说的多线程层面分析，阻塞和非阻塞主要是单线程层面分析的



//入门例子(注释简单，请仔细翻译英文注解)
//需求：加载一个文件，然后通过NIO的形式读到Channel对象中，在到buffer容器中暂存，然后循环这个把文件内容读完
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
FileChannel inChannel = aFile.getChannel();//传统的stream都可以可到channel

//create buffer with capacity of 48 bytes
ByteBuffer buf = ByteBuffer.allocate(48);//创建容器,暂存缓冲区

int bytesRead = inChannel.read(buf); //read into buffer.(数据放入buffer)

while (bytesRead != -1) {
		//在调用channel的write方法之前必须调用buffer的flip方法
  buf.flip();  //make buffer ready for read(快速翻转,如果原来是读取现在就变为写操作,且是buffer对象的方法)
  while(buf.hasRemaining()){//是否还有剩余
      System.out.print((char) buf.get()); // read 1 byte at a time(一次读一字节,取出)
  }

  buf.clear(); //make buffer ready for writing
  bytesRead = inChannel.read(buf);
}
aFile.close();
-------------------------------
通过使用FileChannel可以从文件读或者向文件写入数据；
通过SocketChannel，以TCP来向网络连接的两端读写数据
通过ServerSocketChanel能够监听客户端发起的TCP连接，并为每个TCP连接创建一个新的SocketChannel来进行数据读写；
通过DatagramChannel，以UDP协议来向网络连接的两端读写数据。
-------------------------------
Netty 是一个 NIO 客户端服务器框架，使用它可以快速简单地开发网络应用程序，比如服务器和客户端的协议。
Netty 大大简化了网络程序的开发过程比如 TCP 和 UDP 的 socket 服务的开发。

gitHub 上有2个项目
-------------------------------


*************************************** 
自定义延迟1秒的功能
long time=System.currentTimeMillis();			
while((System.currentTimeMillis()-time<=1000)){
	//延迟1000执行内容体		
}
***********************************			
			
Mysql
账号万能: 'xxx' union select * from users;
密码万能: 'xxx' or 1='1';

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
中文乱码:
分请求和相应乱码

为什么会出现乱码?
Tomcat默认参数传输过程使用的编码为ISO-8859-1

总思路就是前端和后端编码一致；要求前端编码为utf-8,后端解码也用utf-8,下面只算是解决方法

从3个方面来解决乱码问题

1,在xxx.jsp页面保证 contentType="text/html;charset=utf-8" 和 pageEncoding="utf-8"
 
两项编码一致,且支持中文,通常建议utf-8,还需保证浏览器的显示字符编码和请求的jsp页面编码一致


2,对于post请求:request.getParamenter 前调用request.setCharacterEncoding("utf-8")即可


3,对于get 方法上述2种方式搞不定. 因为get默认在传值的时候用的是iso-8859-1, 所以我们可以通过先解码,再改码的方式得到UTF-8,
//就是需要每一个值都要设置.很麻烦,不可推荐,推荐下面全局的
String val = new String(value.getBytes("ISO-8859-1"),"utf-8");//使用ios8859解码后,再用utf-8编码


这个是全局的(只针对get请求有效)我们可以修改tomcat 的 Server.xml属性. (修改端口号哪行)
<Connector connectionTimeout="20000" port="8989" protocol="HTTP/1.1" redirectPort="8443" useBodyEncodingForURI="true"/>
或//推荐下面设置URI编码
<Connector connectionTimeout="20000" port="8989" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>

另:
对于响应时出现的乱码如何解决::
response.setcontentType = ("text/html;charset=utf-8");//设置响应的MIME类型和响应编码
-----------------------------------------------------
String s = new String("中国".getBytes(),"GBK");
//打印s 乱码
String s2 = new String(s.getBytes("GBK"),"UTF-8");
//打印正常
+++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++

需求:列出指定目录下的所有内容.
思路:
因为目录中还有目录,只要使用同一个列出目录功能的函数完成即可.
如果当前还是目录的话,就可以再次调用本功能.
也就是函数自身调用自身.这种表编程手法,称为递归

递归要注意的:
1,限定条件
2,要注意递归的递进次数,尽量避免内存溢出(压测一般都会死,所以递归对于高频发不推荐)


//  递归3个实例.有图,递归理解最好就是画图
public class RecurSion {
	public static void main(String[] args) throws IOException {
		//File d = new File("d:\\java");
		//showDir(d);// 列出指定目录下的所有内容
		toBin(6);// 2进制的值
		System.out.println(sum(3));// 一个数的总和

	}

	public static void showDir(File dir) {	
		if(!dir.exists()){
			throw new IllegalArgumentException("目录不存在"+dir);		
		}	
		// 返回是对象,对象就可以使用对象的方法.
		File[] files = dir.listFiles();
		for (int x = 0; x < files.length; x++) {
			if (files[x].isDirectory())// 是否为文件夹
				showDir(files[x]);// 是文件夹,就调用自己
			else
				System.out.println(files[x]);// 我是文件，就打印
		}
	}

	public static void toBin(int x) {
		if (x > 0) {
			x = x / 2;
			toBin(x);
			System.out.println(x % 2);
		}
	}

	/**
	 * 假设传入参数3；
	 * 1，if不成立，执行3+sum（3-1）
	 * 2，if不成里，执行3+2+sum（2-1）
	 * 3，if成立，返回 3+2+1
	 * 4,return 6
	 */
	public static int sum(int x) {
		if (x == 1) {
			return 1;		
		}	
		return x + sum(x - 1);
	}
}
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


多线程

程序:一个软件;如QQ,360等
进程:可以理解为 执行中的代码
线程: 一个进程可以包含多个线程,一个线程相当于一个子程序

java多线程可以有3种方式:
1,继承 Thread 类 (1,没指明就不用,因为锁难保证唯一,2,且java是单继承的)
2,实现 Runnable接口,共享变量好控制
对于继承方式想启动两个以上的线程,只能多 new Object 对象在.start()的方式,但这样共享变量不好控制
3,实现Callable,可以得到线程返回值;百度云有源码 线程3-Callable
http://blog.csdn.net/suifeng3051/article/details/49443835

Thread的常用方法:
start() : 使该线程开始执行；Java 虚拟机调用该线程的 run 方法.
run(): 子线程要执行的代码放入run()方法体中
currentThread():静态的,返回当前线程
getName():获取线程的名字
setName():设置线程名字
yield():让出处理时间,然后继续去争抢cpu 执行权
join():其他线程等待,这个线程执行完毕后,其它的再抢
isAlive():判断当前线程是否还活着
sleep(long value): 显示让当前线程睡眠
设置线程的优先级: setPriority(int newProiority):改变线程的优先级

-------------------------------
//通过变量控制线程是否运行,使用stop来暂停线程是错误的(它会戛然而止,不会输出下面的结束)
volatile boolean keepRunning; //保证其他线程能读到该值的变化
public void run(){
	
	while(keepRunning){//如果等于false时,前一次的for 循环一样会执行完!
		for(int i=0; i<5; i++){
			System.out.print("运行中..");
			Thread.yield();//让出当次执行权,在次争抢
		}
	}
	System.out.print("结束");
}
---------------
另 使用interrunpt()停止线程也是不正确的;
interrupt方法是用来唤醒被阻塞的线程的,如wait, sleep, join方法;

但此时线程的sleep等方法下面的catch语句就会接收到这个打断

try {
	Thread.sleep(2000L);
} catch (InterruptedException e) { //一旦使用Interrupt(打断),就会抓住这个异常
	//这里可以加入逻辑
}

--------------------------------
线程使用最大的问题就是共享资源 错误的增加或减少,
共享资源一次只能一个线程在使用完成后,修改值后;其他线程才可能使用这个资源,
且能正确的读到刚才被改变的共享资源值.
java使用synchronized 关键字来实现互斥;

--------------------

java使用 wait()和notify()或notifyAll()来实现同步的;

wait():使用一个线程处于等待状态,且释放所持有对象的lock;
notify();唤醒一个处于等待线程中的线程,其中唤醒谁JVM确定,不是按优先级;
notifyAll();唤醒全部等待中的线程
它们都是属于Object对象中的方法;

synchronized,volatile,final; 
//这3种可以保证变量的可见性,让值显示可见
------------------------------------

如何扩展java 并发的知识?
一,java Memory Mode (java 内存模型)
JMM 描述了java线程共享变量的访问规则,以及JVM中将变量存储到内存和从内存中读取出变量的底层细节;

二,Locks 和 Condition 类
java 锁机制和等待条件的高层实现;

三,java5中并发编程工具
java.util.concurrent
线程池 ExecutorService
Callable & Future
BlockingQuque

这几个类简化了线程使用,让你更关心业务中的任务;
-------------------------------------------------------
(精华中的精华,线程共享变量和这段话密切相关)
所有的变量都存储在主内存中;
每个线程有自己独立的工作内存,里面保存该线程使用到的变量(是主内存中该变量的一份拷贝)
线程对共享变量的所有操作都必须在自己的工作内存中进行,不能直接从主内存中读写
不同线程之间无法直接访问其他线程中的内存中的变量,线程之间变量值的传递需要通过主内存来转换

完成需要共享变量可见性.java使用 volatile 或 synchronized 让共享变量具备可见性;

synchronized 有两个功能: 
1,原子行 //互斥,一次能有一个线程进来(线程原子性可以理解为事务的一致性)
2,可见性 
synchronized 使用时的流程;
1,获得 互斥锁
2,清空工作区(线程)内存,从主内存拷贝变量到工作内存中
3,执行代码,将工作内存值刷新到主内存
4,释放 互斥锁

-----------------------
volatile 和 synchronized 都可以让变量可见,但 volatile 不能保证复合操作的原子性,但 volatile 执行数度更快

如果给一个变量加上volatile修饰符，就相当于：每一个线程中一旦这个值发生了变化就马上刷新回主存，使得各个线程取出的值相同。



举例:
private volatile int number = 0; //volatile只能可见,不能保证原子性
number ++;//看似只有一步,其实底层大概会有几步
1,读取number的值
2,将number值加1;
3,写最新的number到内存中;

因为是3步,就可能在多线程时错乱;不能保证原子性(不是多线程不会出现错乱)

而synchronized一次只能一个线程进去执行,就保证了原子性
synchronized(this){
	number ++; 
}
-------------------------------------
方式一：
/**
 * 功能描述:测试Volatile不能保证原子性，
 * 可以是synchronized可以完成；
 * 另Thread.activeCount()结合hread.yield()让当前主线程等待，请仔细
 * 想想主和其它线程的切换过程；
 */
public class VolatileDemo {

	// 共享数据的访问权限都必须定义为private
	private volatile int number;

	public int getNumber() {
		return this.number;
	}

	// synchronized加到方法上,但这样的执行时间会久,推荐精确力度
	public void setNumber() {
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		/**
		 * 下面是保证可见性的两种方式，我们选一种synchronized,
		 * volatile不能保存原子性；
		 */
		//synchronized (this) {
		//	this.number++;
		//}
		this.number++;//运行多次会出现错误
	}

	public static void main(String[] args) {

		final VolatileDemo vd = new VolatileDemo();
		for (int i = 0; i < 500; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					vd.setNumber(); // +1操作
				}
			}).start();
		}

		// Thread.activeCount()查询线程数量;如果大于1,说明除了主线程还有其他线程;这样可以保证子线程完毕后执行主线程
		// 另 Thread.activeCount()不能再Junit方法体中测试,判断会一直返回true
		while (Thread.activeCount() > 1) {
			Thread.yield();// 让出执行权;(作用:让全部子线程执行完成后才执行下面输出)
		}
		// 本来结果是等于500,但实际结果可能不是500,就是原子性出现了问题,就算可见却不能保证原子性
		System.out.println("子线程一定执行完毕了,最后值:" + vd.getNumber());
	}
}
-----------------------------------------------
精华
Thread 和 Runnable 的区别:
1,Runnable 避免了java单继承的问题;
2,Runnable 多个Runnbale 实例可以传给一个Thread实例中,这样可以更好的让多线程共享变量; 
不然共享变量需要就加 static
-----------------------------------------------
/**
 * 继承方式的Hello World；任何一个线程.yield()就会放弃cpu执行权,但并不是另一个线程就会执行，靠抢；
 */
public class ThreadDemo {
	public static void main(String[] args) {
		TestThread t1 = new TestThread().setName("线程1:").start();
		TestThread t2 = new TestThread().setName("线程2:").start();
	}
}

class TestThread extends Thread {

	public void run() { // 线程运行的代码都在run方法中
		for (int x = 0; x < 100; x++) {
			if(x % 10 == 0){
				Thread.currentThread().yield();//当前线程,放弃当前执行权
			}
			System.out.println(Thread.currentThread().getName() + x);
		}
	}
}

-------------------------------------------------------

/**
 * 需求: 模拟三个窗口一起卖100张票 
 * 思路: 3个窗口就是3个线程,都卖100张票相当于就是共享变量,卖票就是线程需要做的事,就是run方法体
	,内部就是一个-1操作;
	变量没有stract修饰,一样的可以完成.但要是继承Thread就必须要修饰静态才可以,如果不加锁可能会-1的现象,加锁后正常
 */
public class TestRunnable {

	public static void main(String[] args) {
		// 把实现了Runnable的类通过参数的方式传给多个Thread,且这个你N个线程都使用的一个对象 如:这里的my		
		MyRunnable my = new MyRunnable(); 	 
		new Thread(my).start();
		new Thread(my).start();
		new Thread(my).start();
	}
}

class MyRunnable implements Runnable {

	private int m = 100;// 普通变量

	@Override
	public void run() {
		while (true) {
			synchronized (this) {		
				if (m > 0) {//共享变量的改变，放在锁内
					try {
						Thread.sleep(20);// 如果当前线程冻结20毫秒,不加锁马上会出现卖票混乱,就算变量加静态也不能解决,只有加锁
					} catch (Exception e) {
					}
					System.out.println(Thread.currentThread().getName()+ "我是线程" + m--);
				}else{
					break;
				}
			}
		}
	}
}
------------------------------------------------------------
Thread 和 Runable 主要在使用时不一样,继承Thread的会被new多份,而实现Runable只会new一份
------------------------------------------------------------
线程的生命周期 : 新建 就绪 阻塞 运行 死亡; 就绪,阻塞,运行 可以循环出现

一个运行中的线程遇到 sleep()/wait()/join()/suspend("这个基本不用了")都会阻塞
sleep()时间到,获取同步锁 notify()/notifyAll()/resume("这个基本不用了")都会转到就绪

yield 不会线程阻塞,且和priority有关;

										
对于单线程来说是 : 
新建 -------->   就绪           -------->       运行         --------> 死亡
		start()				获得cpu执行权				正常运行完run()			
		
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	
对于多线程来说是 : 
新建 -------->   就绪           -------->       运行         --------> 死亡									
		start()				获得cpu执行权				正常运行完run()				
                             <--------		         	Error/Exception 未处理
							失去CPU执行权yield()		shop(过时)					

**************记住下面5句话*************
新建 对应代码中的 new Thread();
就绪 对应代码中的.start(),表示启动; //就绪会线程池队列中等待,由cpu随机调用那个线程运行
运行 对应run()方法被执行;
阻塞 比如在run()方法中使用了sleep或 wait()/join().. 
死亡 run()方法中代码结束就死亡了;
-----------------------------------------

线程 按功能可能分为: 用户线程和守护线程;
用户线程,就是我们能操作的;运行在前台

守护线程 运行在后台,为其他前台线程服务;
特点: 一旦所有的用户线程都结束运行,守护线程就随JVM一起结束工作;
应用: 数据库连接池中检测线程,jvm 虚拟机启动后的检测线程,垃圾回收线程;

如何使用:
setDaemon(true);
1,注意必须在start()方法之前调用,否则抛出异常;
2,在守护线程中产生的新的线程也是守护线程
3,不是所有的任务都可以分配给守护线程来执行的,比如读写操作或计算逻辑;
4,守护线程主要是监控用户线程的,如果里面有读写操作,用户线程结束会引发守护线程结束;


另: 我们可以使用JDK 自带的工具jstack查看进行是否是daemon 守护线程还是用户线程;
--------------------------------
/**
* 需求:同样是卖票,只是把synchronized换位了Lock
*/
public class MyRunnable implements Runnable {

	// Lock 的实现类来管理锁,明确指定哪里加锁,哪里解锁(必须手动解)
	Lock lock = new ReentrantLock();
	private int count = 500;
	private volatile boolean flag = true;

	@Override
	public void run() {
		
		while (flag) {
			
			try {
				lock.lock();// 加锁，不加锁数据错乱,可能要测试很几次才会出现，但一定会出现
				try {
					Thread.sleep(10);// 睡10毫秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (count > 0) {
					System.out.println(Thread.currentThread().getName() + "----" + count--);
				} else {
					flag = false;
				}
				
			} finally {
				lock.unlock();// 解锁都放finally里,对应最外层的try
			}
			
			Thread.yield();//强制放弃，加了后马上可以看到多线程在切换
		}
	}

	public static void main(String[] args) {
		MyRunnable my = new MyRunnable();
		new Thread(my).start();
		new Thread(my).start();
		new Thread(my).start();
	}

}
----------------------------------------------------------------------

死锁: 相互依赖需要的资源(如锁判断资源),就出现卡死.必考题
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
如何防止死锁:
1,同步监视器:俗称锁,任何一个类的对象都可以充当锁.想要保证线程安全,必须保证所有线程使用同一把锁
2,使用实现Runnable 接口的方式创建多个线程的话,同步代码块的锁,可以考虑是this,
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
3,如果使用继承Thread类的方式,慎用this (这里主要要看this当前对象是不是同一个对象)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
4,一般是同步代码块中出现同步函数 或 同步函数中出现同步代码块.却锁不一样.

如何找问题:
1,明确哪些代码是多线程代码
2,明确共享数据
3,明确多线程运行代码中哪些语句是操作共享数据的.
难道不是找锁上变量是否被相互依赖吗?
--------------------------------------------
值得一看:
/**
 * 需求:模拟两个窗口(多了不行)卖100张票且只能是2个窗口,要求一边卖一张.(2个线程就可以)
 * 这段代码永远不会出现一个线程执行两次的情况;因为睡眠和唤醒机制制约着
  思路:
  synchronize保证了只有一个线程可以进来,执行到wait()会释放锁,相当于当前线程就没在同步块中了,且被阻塞了;
			不会马上去抢run,只有等下个线程进去后才会唤醒它,就这样达到了两个线程可以切换的效果
 */
public class TestRunnable {

	public static void main(String[] args) {
		// 实现了Runnable的类,N个线程都使用一个对象 如:这里的my;这样更好的管理了共享变量
		MyRunnable my = new MyRunnable();
		Thread t1 = new Thread(my);
		Thread t2 = new Thread(my);
		Thread t3 = new Thread(my);//如果高于2个线程就不能控制每个线程执行一次
		Thread t4 = new Thread(my);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class MyRunnable implements Runnable {
	private volatile int m = 100;// 普通变量

	@Override
	public void run() {
		while (true) {

			synchronized (this) {
				notify();
				if (m > 0) {
					try {
						Thread.sleep(10);
					} catch (Exception e) {
					}
					System.out.println(Thread.currentThread().getName() + "我是线程" + m--);
				} else {
					break;
				}
				
				try {
					//在上面操作完共享变量后就可以释放锁了
					wait();//wait()方法是会释放锁的;所以另一个线程进来了;然后又唤醒它;只有notify 或notifyAll才可以叫醒它.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
-------------------------------------------
/**
精华:
 * 生产者和消费者问题 ,通过synchronized(同步锁)的等待和唤醒机制实现
 (大多数线程执行的run方法中的内容都是一样,这里是两种不同的run)
 * 设计思路: 消费者 只管消费(商品--) 没有逻辑 和 生产者(商品++) 只管生产没有逻辑
 * 店员控制商品数量,和逻辑
   ~~~~~~~~~~~~~~~~~
 *  生产方法 :如果大于20 让生产者睡觉;否则一直生产,并唤醒全部;
 *  消费方法 :如果商品=0 则让消费睡觉,否则一直消费,并唤醒全部;
 *  
 *  问题 : 效率不高,因为++ 或-- 只操作一次就结束了且马上唤醒全部,然后又要来判断;


首先抛出2个问题:
1,这里的 生产者和消费者问题 为什么会这么设计,有那些好处?还有其他思路不?
2,对于全部都是消费的情况为什么变简单了;多线程使用时怎么设计,设计以什么为标准?

总结: Consumer和Producer是2个线程; Clerk是共享变量(不能new多个);多线程往往就是操作业务后修改
共享变量;线程的个数不会造成线程的出错;只要保证共享变量是一份,且只有一个线程在使用;这里就会加锁
如这里Clerk的两个操作共享变量的方法都会加锁;
	然后因为一些业务需求比如数量小于0消费者不能在消费,这时就需要加入线程通信技术;
	
 */
public class TestProduceConsume {

	public static void main(String[] args) {
		Clerk clerk = new Clerk();//店员为同一个(这是线程设计的核心,看共享变量;
		
		//不能new多个,保存多个线程操作的是一个共享变量)
		Thread t1 = new Thread(new Producer(clerk),"++++");
		Thread t2 = new Thread(new Consumer(clerk),"----");
		Thread t3 = new Thread(new Consumer(clerk),"---");
		Thread t4 = new Thread(new Consumer(clerk),"--");
		Thread t5 = new Thread(new Consumer(clerk),"-");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}

//店员（所有逻辑处理都在店员这里，生产者和消费者只是调的方法不一样）
class Clerk {
	
	private volatile int productNumber; //产品数量

	//生产产品
	public synchronized void addProduct() {
		if (productNumber >= 20) {
			try {
				wait();//商品数量大于20,当前线程睡眠
			} catch (InterruptedException e) {
			}
			//如果我在这只唤醒对面不是更好性能
		} else {
			productNumber++;
			System.out.println(Thread.currentThread().getName() + ":生产第" + productNumber + "个产品");
			notifyAll();//这个代码这里有性能问题,唤醒全部不是又把才睡觉的自己也唤醒了;性能确实差
		}
	}

	//消费产品
	public synchronized void consumeProduct() {
		if (productNumber <= 0) {
			try {
				wait();//如果商品数量等于0当前线程睡眠
			} catch (InterruptedException e) {
			}
		} else {
			//如果大于商品大于0 ,消费商品并唤醒对方
			System.out.println(Thread.currentThread().getName() + ":消费第" + productNumber + "个产品");
			productNumber--;
			notifyAll();
		}
	}

}

//生产者类(注意线程方法里其实就一句代码,同步方法不一定在线程里面)
class Producer implements Runnable {
	private Clerk clerk;

	public Producer(Clerk clerk) {
		this.clerk = clerk;
	}

	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(13);//调节时间可以改变生产不过来的情况
				clerk.addProduct();
			} catch (InterruptedException e) {
			}
		}
	}
}

//消费者类(注意线程方法里其实就一句代码,同步方法不一定在线程里面)
class Consumer implements Runnable {
	private Clerk clerk;

	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}

	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(50);
				clerk.consumeProduct();
			} catch (InterruptedException e) {
			}
		}
	}
}



为什么要定义notifyAll
因为只用notify容易只唤醒本方的情况,导致程序中的所有线程都在等待(死锁).可能需要在构造的时候把生产线程的传给
消费线程,但这样如果线程大于2可能会死锁,所以会出现Lock来解决这个问题
—————————————————————————
精华
Lock 锁和Condition 知识；

　　synchronized是Java的一个关键字,也就是Java语言内置的特性,如果一个代码块被synchronized修饰了,
当一个线程获取了对应的锁,执行代码块时, 其他线程便只能等待;

获取锁的线程释放锁会有三种情况:
　　1).获取锁的线程执行完该代码块
　　2).线程执行发生异常,此时JVM会自动释放锁;
　　3).调用wait方法

Lock的特性:

　　1).Lock不是Java语言内置的;
　　2).synchronized是在JVM层面上实现的,如果代码执行出现异常,JVM会自动释放锁,但是Lock不行,要保证锁一定会被释放,
	就必须将unLock放到finally{}中(手动释放);

　　3).在资源竞争不是很激烈的情况下,Synchronized的性能要优于ReentrantLock,但是在很激烈的情况下,
synchronized的性能会下降几十倍;

　　4).有多种锁:
　　　　a. void lock(); // 无条件的锁;
　　　　b. void lockInterruptibly throws InterruptedException;//可中断的锁;
解释:使用ReentrantLock如果获取了锁立即返回,如果没有获取锁,当前线程处于休眠状态,直到获得锁或者当前线程
可以被别的线程中断去做其他的事情;但是synchronized没有获取到锁,则会一直等待下去;

　　　　c. boolean tryLock();//如果获取了锁立即返回true,如果没有,返回false,不会等待;
　　　　d. boolean tryLock(long timeout,TimeUnit unit);//如果获取了锁立即返回true,如果没有
//会等待参数给的时间,在等待的过程中,如果获取锁,则返回true,如果等待超时,返回false;

 

Condition的特性:

　　　　1.Condition中的await()方法相当于Object的wait()方法，Condition中的signal()方法相当于Object的notify()方法，
Condition中的signalAll()相当于Object的notifyAll()方法。不同的是，Object中的这些方法和同步锁捆绑使用的；
而Condition是需要与互斥锁/共享锁捆绑使用的。其实同步锁和互斥锁是一个概念

　　　　2.Condition它更强大的地方在于：能够更加精细的控制多线程(大于2个)的休眠与唤醒(前面的生产者消费者就是)
对于同一个锁，我们可以创建多个Condition，如果采用Object类中的wait(), notify(), notifyAll()就不可以；

－－－－－－－－－－－－－－－－－－－－－－－－－－
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 生产者消费者(推荐方式) 通过Lock(互斥锁)和Condition(互斥唤醒)实现
	Tesk相当于销售员,它控制着共享变量
 */
public class Task {

	private final Lock lock = new ReentrantLock();
	
	private final Condition addCondition = lock.newCondition();
	private final Condition subCondition = lock.newCondition();
	private volatile int num = 0;

	//生产者(循环判断,一旦高于20就等待,导致下面num++不会被执行;当小于20就会执行++操作,并唤醒消费者)
	public void add() {
		lock.lock();//得到锁
		try {
			while (num >= 20) {
				addCondition.await();
			}
			num++;
			System.out.println(Thread.currentThread().getName() + " 生产 " + num);
			this.subCondition.signal();//唤醒对方线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {// 释放锁
			lock.unlock();
		}
	}

	//消费者(循环判断,一旦小于等于0就等待;导致下面num--不会被执行;当大于0就会执行--操作,并唤醒生产者)
	public void subtract() {
		lock.lock();//得到锁
		try {
			while (num <= 0) {
				subCondition.await();
			}
			num--;
			System.out.println(Thread.currentThread().getName() + " 消费 " + num);
			addCondition.signal();//唤醒对方线程
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}


//生产线程,两个线程调用的不同的方法
public class AddThread implements Runnable {

	private Task task;

	public AddThread(Task task) {
		this.task = task;
	}

	@Override
	public void run() {
		//启动无限循环,但方法内通过判断,什么条件下结束或暂停循环;这是一种思路
		while(true) {
			task.add();
		}
	}
}
//消费线程,两个线程调用的不同的方法
public class SubThread implements Runnable {
    
    private Task task;
    
    public SubThread(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
		//启动无限循环,但方法内通过判断,什么条件下结束或暂停循环;这是一种思路
    	while(true) {
    		task.subtract();
    	}
    }

}

public class Test {
	public static void main(String[] args) {
			//task就是销售员,就是共享变量,它控制着共享变量增加还是减少的逻辑
	        Task task = new Task();	        
	        Thread t2=new Thread(new SubThread(task));
	        Thread t1=new Thread(new AddThread(task));	  	        
	        t1.start();
	        t2.start();     
	}
}

----------------------------------------------
wait()和sleep()的区别?
wait释放资源释放锁,sleep,yeild释放资源不释放锁.

如何让2个线程轮流执行?
切换问题,解决判断加 wait()加 notify()联合使用.或Condition(推荐)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

wait();等待 notify();唤醒 notifyAll();唤醒线程池的所有,它们都只能使用在同步块中.														
只有同一个锁上的被等待wait线程可以被同一个锁上的notify唤醒.等待和唤醒必须是同一个锁.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

为什么这些操作线程的方法要定义Object类中:因为锁可以是任意对象.(了解)
t1.join();时主线程会等待t1执行完毕后才会执行,至于还有其他线程在执行,cpu不管.
join主要用来临时加入线程,join运行时主线程就等待中...
Thread.yield();这个函数功能可以使2个线程交替执行是错误的.
优先级:
setPriority(int newPriority) 更改线程的优先级.         
MAX_PRIORITY 线程可以具有的最高优先级(10级).在Thread类
yield()暂停当前正在执行的线程对象,并执行其他线程,如果只有2个线程相当于交替执行  
----------------------------------------------------
并发是指同时有很多事要做(发生)，并行是指同时做多件事(执行)。

因此并发后 可以并行处理 也可以 串行处理，所以并发和并行是不同的概念。
-----------------------------------------------------  
ThreadLocal

ThreadLocal用来解决多线程环境中资源竞争的问题。它不是通过加锁的方式，而是通过每个线程保存一份资源的副本, 
这样各个线程访问本线程自己的那一份儿，从而避免了对资源竞争的问题。

private static final ThreadLocal<CurrentUser> threadLocal = new ThreadLocal<CurrentUser>();
得到当前用户;gsso,ppp项目都是这样得到当前用户的；

不是一个特殊的Thread，它只是一个线程的局部变量(其实就是一个Map),
ThreadLocal会为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线
程所对应的副本。这样做其实就是以空间换时间的方式,以耗费内存为代价,大大减少了线程同步(如synchronized)
所带来性能消耗 和 线程并发控制的复杂度。


虽然ThreadLocal和Synchonized都用于解决多线程并发访问，ThreadLocal与synchronized还是有本质的区别。
synchronized是利用锁的机制，使变量或代码块在某一时该只能被一个线程访问。而ThreadLocal为每一个线程都提供了变量的副本，
使得每个线程在某一时间访问到的并不是同一个对象.(线程独立数据)

synchronized关键字是Java利用锁的机制自动实现的，一般有同步方法和同步代码块两种使用方式。Java中所有的对象都自动含有单一的锁
(也称为监视器)，当在对象上调用其任意的synchronized方法时，此对象被加锁(一个任务可以多次获得对象的锁，计数会递增)

举例：
/**
 * ThreadLocal的作用就是让每一个线程都取到自己的变量；
 */
public class MyThreadLocal {
	
	//平安就是这样取的当前用户
	//private static final ThreadLocal<CurrentUser> threadLocal = new ThreadLocal<CurrentUser>();
	
	private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>() {
		/**
		 * ThreadLocal调用get方法时如果是null或调用remove后就会调用此方法;我们可以在这里返回初始值
		 */
		@Override
		protected Object initialValue() {
			System.out.println("调用get方法时,当前线程共享变量没有设置,调用initialValue获取默认值！");
			return 5555;
		}
	};

	public static void main(String[] args) {
		new Thread(new MyIntegerTask("Int1_")).start();
		new Thread(new MyIntegerTask("Int2_")).start();
		
	}


	public static class MyIntegerTask implements Runnable {
		private String name;

		MyIntegerTask(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			//如果删除这句,会调initialValue方法;
			MyThreadLocal.threadLocal.set(0);
			
			for (int i = 0; i <= 5; i++) {
				// ThreadLocal.get方法获取线程变量
				if (null == MyThreadLocal.threadLocal.get()) {
					// ThreadLocal.et方法设置线程变量
					MyThreadLocal.threadLocal.set(0);
					System.out.println("set_线程" + name);
				} else {
					if (i == 2) {
						//执行remove,会调用initialValue方法
						MyThreadLocal.threadLocal.remove();
					}
					
					if(null != MyThreadLocal.threadLocal.get()) {
						int num = (Integer) MyThreadLocal.threadLocal.get();
						MyThreadLocal.threadLocal.set(num + 1);
						System.out.println("get_线程" + name + ": " + MyThreadLocal.threadLocal.get());
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

---------------------------------
高级多线程
一,
atomicXXX和volatile的区别?
atomicInteger可以保证原子性,底层是CAS方式实现(可以看成乐观锁)
所谓原子操作是指不会被线程调度机制打断的操作；这种操作一旦开始，就一直运行到结束，中间不会有任何一个线程）
二,
钩子线程?
jvm关闭的时候先执行该线程钩子
Runtime.getRuntime().addShutdownHook(shutdownThread);
三,
CountDownLatch是一个同步工具类，它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。
CountDownLatch最重要的方法是countDown() 做减的操作 
await() 只要上面的减减操作没有到0 就会一直等待;


五,
在java5以后，一个可以调度执行的线程单元可以有三种方式定义：

Thread、Runnable、Callable，其中Runnable实现的是void run()方法，Callable实现的是
 V call()方法，并且可以返回执行结果，其中Runnable可以提交给Thread来包装下，
 直接启动一个线程来执行，而Callable则一般都是提交给ExecuteService来执行。

简单来说，Executor就是Runnable和Callable的调度容器，Future就是对于具体的调度任务的执行
结果进行查看，最为关键的是Future可以检查对应的任务是否已经完成，也可以阻塞在get方法上一直等待
任务返回结果。Runnable和Callable的差别就是Runnable是没有结果可以返回的，就算是通过Future
也看不到任务调度的结果的。 

有返回值的线程 

为什么需要?
Future 可用于异步获取子线程执行结果(其实就是自己创建了一个List,把每一个子线程结果装进去了) 
 或取消执行任务的场景。

1,可以通过 ExecutorService pool = Executors.newFixedThreadPool(taskSize); 设置线程个数
2,Future f = pool.submit(c);  通过这句话启动线程，线程返回值在f变量里面；c是Callable的一个实现类(返回值和Callable相关)
3,class MyCallable implements Callable<Object> 它就是c；重写call方法（方法体就是线程执行内容）
4, Future返回值保存在一个list中，这样我们可以马上关系线程，节约资源

六,
newFixedThreadPool创建的线程池corePoolSize和maximumPoolSize值是相等的，它使用的LinkedBlockingQueue；
newSingleThreadExecutor将corePoolSize和maximumPoolSize都设置为1，也使用的LinkedBlockingQueue；
newCachedThreadPool将corePoolSize设置为0，将maximumPoolSize设置为Integer.MAX_VALUE，使用的SynchronousQueue,
也就是说来了任务就创建线程运行，默认当线程空闲超过60秒就销毁。
newScheduledThreadPool 定时周期任务的线程池
七,
ConcurrentHashMap,如BlockingQueue(生产者消费者更好的实现),Semeaphore, CyclicBarrier, ReentrantLock,Future


javaseend
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

JDBC

让程序员和厂商都面对jdbc编程.

JDBC(Java Data Base Connectivity; java数据库连接) java提供连接数据库的一个 标准,由一组类和接口组成
,接口的实现由各大数据库厂商提供.(导入的数据库驱动包);

注意;jdbc隶属于javase,在开发中JDBC导入的包都是在java.sql或javax.sql中,千万不要导入和厂商实现的包

jdbc4。0版本对应这tomcat6版本
mysql 的驱动包的Driver 实现了java.sql.Driver接口

-------------------------------------------------
java 连接 数据库就2步(不算使用):
~~~~~~~~~~~~~~~~

1,加载数据库驱动(也叫注册)

Class.forName("com.mysql.jdbc.Driver”);//作用:告诉JVM数据库厂商的实现类全路径
步骤1,把com.mysql.jdbc.Driver这类的字节码加载进JVM ---> 创建Class对象
步骤2,当一份字节码被加载到JVM中,就会执行静态代码块中的代码.
步骤3,静态代码块中 java.sql.DriverManager.registerDriver(new Driver()); 就被执行了

2,得到连接
DriverManager.getConnection(url, user, password);

-------------------------------------------------------

现在DriverManager已经过时了,现在使用的是DataSource
https://blog.csdn.net/u013905744/article/details/52437597
https://blog.csdn.net/a3427603/article/details/86449198
-------------------------------------------------------

自己理解:jdk 提供了一些操作数据库的接口,接口的实现由不同的数据库厂商实现;开发程序员需要告诉jdk厂商全路径;开发程序就可以直接
得到数据库连接了;jdk通过接口的方式为数据库厂商和程序员之间搭了一座桥

对应下面的源码理解:
----------------------------------------------------------
//mysql类源码 (mysql 实现了java.sql.Driver)
public class Driver extends NonRegisteringDriver implements java.sql.Driver {

	//在静态代码块使用java.sql.DriverManager对mysql的Driver 进行注册
	static {
		try {
			java.sql.DriverManager.registerDriver(new Driver());
		} catch (SQLException E) {
			throw new RuntimeException("Can't register driver!");
		}
	}	
}
----------------------------------------------------------

可以在mysql控制台输入 show processlist 的mysql的运行进程

+-----+------+-----------------+--------------------+---------+------+-------+------------------+
| Id  | User | Host            | db                 | Command | Time | State | Info             |
+-----+------+-----------------+--------------------+---------+------+-------+------------------+
| 169 | root | localhost:53319 | NULL               | Sleep   | 4454 |       | NULL             |
| 170 | root | localhost:53324 | dayday             | Sleep   | 4446 |       | NULL             |
| 171 | root | localhost:53327 | information_schema | Sleep   | 4444 |       | NULL             |
| 172 | root | localhost:53328 | mysql              | Sleep   | 4442 |       | NULL             |
| 173 | root | localhost:53329 | test               | Sleep   | 4439 |       | NULL             |
| 175 | root | localhost:55837 | NULL               | Query   |    0 | NULL  | show processlist |
+-----+------+-----------------+--------------------+---------+------+-------+------------------+

注意:
在java6(jdbc4.0)版本开始,可以不在用加载注册驱动.直接通过DriverManager获取链接
为什么不需要?
从java6开始,规范要求每一个jdbc厂商驱动包都必须带META-INF/services/java.sql.Drver文件,
所有jdk默认会来这里取;但我们建议还是手动加载注册驱动,可以兼容之前的jdk版本
-----------------------------------------------------------------------
jdbc的 操作 步骤:
1,注册驱动
2,得到连接

3,创建执行sql语句的对象
4,执行sql
5,释放资源
----------------------------
第三步:
Connection属于javase中java.sql包下的一个接口;里面有创建等方法:
createStatement() :创建一个Statement对象来将sql语句发送到数据库
------------------------------------------------
第四步:
Statement属于javase中java.sql包下的一个接口;里面有一些执行方法如:
executeUpdate(String sql) //增删改
executeQuery(String sql);//查询,该语句返回单个ResultSet对象.

ResultSet表示数据库结果集的数据表; 也是java.sql下的一个接口
------------------------------------------------
第五步:
//立即释放资源,而不是等待它们被自动释放.(最好还是使用连接池,这样费资源)
close()//正确关闭资源的结构,先打try在打if; 变量定义在try外前,流程在try中.

try {
	
	if (statement != null) {
		statement.close();
	}
	
} catch (Exception e) {
	e.printStackTrace();
} finally {	

	try {
		if (connection != null) {
			statement.close();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
------------------------------------------------------------
Statement的继承体系:
	CallableStatement(接口):用于执行 SQL存储过程 的接口
	PreparedStatement(接口):表示预编译的 SQL语句 的对象
	
PreparedStatement 是 Statement 的子接口.作用就是预编译Statement
(预编译就是把不变的sql语句先放入缓存,多次sql执行可以重用,只是改动的传入值不一样,通过?占位),

精华
为什么有了Statement还要用preparedStatement?
1,可以让sql语句变得简单,使用statement静态sql语句需要拼装sql语句.而现在使用占位符
2,预编译(提高性能,但有的数据库不支持如Mysql,Order支持,超快
3,防止sql注入 'or 1=1 or'


如何使用PreparedStatement?

1,创建预编译sql
String sql = "INSERT INTO students VALUE (?,?,?)";//带有占位符的sql语句;
PreparedStatement ps = conn.preparedStatement(sql);
2,设值  
setXxx(int index, Object val) 设置占位符的值
3,执行SQL 
语句:executeQuery() 或 executeUpdate()

-----------------------------
Mysql5.5开始 的默认存储引擎(engine)是InnoDB 可以修改为ISAM 速度 比上面快10被但不支持事物									        
-----------------------------
如何创建一个sql类型的Date?
//外层是Sql 的Date
new Date(new java.util.Date().getTime())
------------------------------------------
JDBC 的dbcp 数据库连接池(缓冲池)

为什么需要连接池?

1,资源重用 
2,更快的反应数度(创建数据库连接很消耗资源且费时)
3,统一的连接管理,避免数据库连接泄露
4,新的资源分配手段 


连接池有很多如dbcp,c3p0,阿里连接池等

dbcp tomcat默认在用;c3p0 Hibernate默认使用;开发推荐阿里
---------------------------------------------	
注意:
1,我们在使用连接池的时候我们只需要启动的时候初始化一次就OK ,这个是很耗资源和耗时间的
2,这时我在关闭close()时,不是真正的关闭了连接,而是把连接还回了数据库连接池.

+++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++
精华
事务四大特征：原子性，一致性，隔离性和持久性。(简称ACID)
1. 原子性（Atomicity）
    要么全部执行成功,那么一条都不执行
2. 一致性（Consistency）
	例如一次转账过程中，从某一账户中扣除的金额与另一账户中存入的金额相等。
3. 隔离性（Isolation）
	隔离性和隔离级别有关;
4. 持久性（Durability）
    事务成功结束前必须保存至某种物理存储设备。
-------------------
	/**
	 *	需求: Tom 给 Jerry 汇款 500 元.
	 
	   注意:
	   如果多个操作, 每个操作使用的是自己的单独的连接, 则无法保证事务. 
	   
	   2. 具体步骤:
	   1). 事务操作开始前,关闭自动提交,作用执行 多条语句 后再手动提交
			connection.setAutoCommit(false); 
	   2). 提交事务
			connection.commit(); 
	   3). 回滚事务: 若出现异常, 则在 catch 块中回滚事务:
	 */
	  
	@Test
	public void testTransaction() {

		Connection connection = null;
		try {
			connection = JDBCTools.getConnection();
			connection.setAutoCommit(false);//开始事务操作前:取消默认提交.	
			String sql = "UPDATE users SET balance = balance - 500 WHERE id = 1";
			update(connection, sql);//第一条任务:同一个连接
			int i = 10 / 0;
			System.out.println(i);
			sql = "UPDATE users SET balance = " + "balance + 500 WHERE id = 2";
			update(connection, sql);//第二条任务:同一个connection
			// 提交事务
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();//在异常中回滚事务
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCTools.releaseDB(null, null, connection);//关闭连接
		}
}		

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

网络结构:

1,c/s 客服端/服务端 clinet/server
特点:
该结构的软件,客服端和服务端都需要编写
开发成本较高,维护较为麻烦
好处:客服端分担了一分部运算

2,b/s 浏览器/服务端 browser/server
特点:该结构的软件,只开发服务端,因为客服端直接由浏览器取代
开发成本相对低,维护更为简单
缺点:所有运算都要在服务端完成


精华
WEB应用 就是web应用程序的简称,就是一个可被浏览器访问的程序
用户通过浏览器发出http请求 到web服务器,web服务器上servlet程序处理用户的请求后并返回数据给用户;
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
而servlet需要运行在如Tomcat容器中,tomcat管理这个servlet的生命周期;jsp也是,因为jsp本质就是servlet
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

HTTP是 hyper text transfer protocol(超文本传输协议)的简写,属于应用层协议,
WEB浏览器与WEB服务器之间以一问一答的交互规则,这个规则就是HTTP协议
						
TCP/IP 和 Http的区别

　　TPC/IP协议(传输层协议),主要解决数据如何在网络中传输,而HTTP是应用层协议,主要解决如何拆分/包装数据.
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

　　术语TCP/IP代表 传输控制协议/网际协议, 指的是一系列协议,“IP”代表网际协议,找到另一台计算机

	TCP提供有保证的数据传输,而UDP不保证.

7	应用层	例如 HTTP、FTP、Telnet、SSH、NFS、SMTP 等
6	表示层(了解)	例如XDR、ASN.1、SMB、AFP、NCP
5	会话层(了解)	例如ASAP、TLS、SSH、ISO 8327 / CCITT X.225、RPC、NetBIOS、ASP、Winsock、BSD sockets
4	传输层	例如TCP、UDP   RTP、SCTP、SPX、ATP、IL
3	网络层	例如IP       ICMP、IGMP、IPX、BGP、OSPF、RIP、IGRP、EIGRP、ARP、RARP、
2	数据链路层(了解)	例如以太网、令牌环、HDLC、帧中继、ISDN、ATM、IEEE 802.11、FDDI、PPP
1	物理层	例如线路、光纤,无线电、信鸽
 

HTTP协议的几个重要概念

 源服务器(Originserver)：是一个给定资源可以在其上驻留或被创建的服务器.
 
 代理(Proxy)：一个中间程序,它可以充当一个服务器,也可以充当一个客户机,为其它客户机建立请求.
 请求是通过可能的翻译在内部或经过传递到其它的服务器中.一个代理在发送请求信息之前,必须解释并且
 如果可能重写它.
 代理经常作为通过防火墙的客户机端的门户,代理还可以作为一个帮助应用来通过协议处理没有被用户代理完成的请求.
 
 网关(Gateway)：一个作为其它服务器中间媒介的服务器.与代理不同的是,网关接受请求就好象对被请求
 的资源来说它就是源服务器；发出请求的客户机并没有意识到它在同网关打交道.
 网关经常作为通过防火墙的服务器端的门户,网关还可以作为一个协议翻译器以便存取那些存储在非HTTP系统中的资源.
 
-------------------------------------------
HTTP头
javaweb最重要就是学好 http协议,学不好就等于没学,学好了什么都简单

请求头（主要是带的客户机这边的信息）:

Accept:用于告诉服务器,客户机支持的数据类型
Accept-Charset:用于告诉服务器,客户机采用的编码
Accept-Encoding:用于告诉服务器,客户机支持的数据压缩格式
Accept-Language:客服及语言环境
Connection:是否保存当前连接
Cookie:客户机通过这个头可以向服务器带数据
Host:客户机通过这个头告诉服务器,想访问的主机名
Referer:客户机通过这个头告诉服务器,它是哪个资源来访问服务器的(防盗版)
User-Agent:客户机通过这个头告诉服务器,客户机的软件环境
If-Modified-Since:客户机通过这个头告诉服务器,资源的缓存时间(用于比较是否需要刷新)
//下面来值随便一个页面F12 截取下来的信息
General
Request URL:http://re.csdn.net/csdnbi
Request Method:POST
Status Code:200 OK
Remote Address:117.122.217.19:80

Request Headers
Accept:*/
Accept-Encoding:gzip, deflate
Accept-Language:zh-CN,zh;q=0.8,en;q=0.6
Connection:keep-alive
Content-Length:5548
Content-Type:text/plain;charset=UTF-8
Cookie:uuid_tt_dd=2404177576674807365_20161023; UE="";
Host:re.csdn.net
Origin:http://so.csdn.net
Referer:http://so.csdn.net/so/search/s.do?q=http&t=blog
User-Agent:Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36
------------------------------------------

响应头（服务器的信息）:
响应头其实就可以让客服机的浏览器想怎么办就怎么办.这就是响应头的意义
Location:这个头配合302状态使用,用于告诉客户机找谁
Server:服务器通过这个头,告诉浏览器服务器的类型
Content-Encoding :服务器通过这个头,数据的压缩格式
Content-Length:服务器通过这个头,告诉浏览器返回数据的长度
Content-Type:服务器通过这个头,告诉浏览器的类型
Last-Modified:服务器通过这个头,告诉浏览器当前资源的缓存时间
Refresh:服务器通过这个头,告诉浏览器多长时间刷新一次
Content-Disposition:服务器通过这个头,告诉浏览器以下载的方式打开数据
Transfer-Encoding:服务器通过这个头,告诉浏览器数据的传送格式

Etag:缓存相关的头
Expires:服务器通过这个头,告诉浏览器 返回的资源缓存多长时间,-1或0,则不缓存
Cache-Control:no-cache
Pragma:no-cache
服务器通过以上两个头,也是控制浏览器不要缓存数据

Response Headers
Access-Control-Allow-Credentials:true
Access-Control-Allow-Headers:DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,body
Access-Control-Allow-Methods:GET, POST, OPTIONS
Access-Control-Allow-Origin:http://so.csdn.net
Connection:keep-alive
Date:Thu, 01 Feb 2018 02:39:01 GMT
Keep-Alive:timeout=20
Server:openresty
Transfer-Encoding:chunked			

++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++

http效率更高,https安全性更高.

首先谈谈什么是HTTPS：
HTTPS(Secure Hyper Text Transfer Protocol)安全超文本传输协议 它是一个安全通信通道,它基于HTTP开发,
用于在客户计算机和服务器之间交换信息.它使用安全套接字层(SSL)进行信息交换,简单来说它是HTTP的安全版.


网络版的https 和开发版的https还不同

网络版:
SSL(非对称加密) + CA 认证

开发版:
没有浏览器:通过私下给客户端公钥加密来完成数据传输,不需要CA

有浏览器:可以要求客户端导入授信证书,相当于公钥
+++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++

Tomcat的运行原理:

Tomcat和apache的关系:
apache支持静态页，tomcat支持动态的，比如servlet等， 
一般使用apache+tomcat的话，apache只是作为一个转发，对jsp的处理是由tomcat来处理的。 
apache可以支持php\cgi\perl,但是要使用java的话，你需要tomcat在apache后台支撑，
将java请求由apache转发给tomcat处理。
apache是web服务器,Tomcat是应用（java）服务器,它一个servlet(jsp也翻译成servlet)容器,可以独立于apache运行。
--------------
为什么选择tomcat:
　Tomcat它是sun公司官方推荐的servlet和jsp容器
servlet和jsp的最新规范都可以在tomcat的新版本中得到实现.其次,Tomcat是完全免费的软件,


Tomcat目录
tomcat
|---bin：存放启动和关闭tomcat脚本；
|---conf：存放配置文件
|---doc: 存放Tomcat文档；
|---lib/japser/common: 存放Tomcat运行需要的库文件（JARS）；
|---logs: 存放Tomcat执行时的LOG日志文件；
|---src: 存放Tomcat的源代码；
|---webapps: Web项目发布目录
|---work: 存放jsp编译后产生的class文件；

conf文件夹里,主要有server.xml,context.xml,tomcat_user.xml,web.xml四个常用配置文件,

server.xml主要是服务器设置的,例如端口设置,路径设置.
下面对server.xml中tomcat的默认配置进行说明
---------------------------------
精华
简易结构图:
<Server> 顶层类元素，可包含多个service
	<Service> 顶层类元素，可包含一个Engine和多个Connector
		<Connector/> 链接器类，代表通信接口
		<Engine> 容器元素，为Service处理客户请求,含多个Host
			<Host> 容器元素，为Host处理客户请求，含多个Context
				<Context/> 容器元素，为Web应用处理客户请求
			</Host>
		</Engine>
	</Service>
</Server>

详解Tomcat 配置文件server.xml
文章来源,精华中的精华
http://www.cnblogs.com/kismetv/p/7228274.html

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++

核心文章web.xml
https://blog.csdn.net/believejava/article/details/43229361

SERVLET

什么是servlet?
servlet是在服务器上运行的小程序,就是一个Java类,可以处理Http请求
常见的方法有doGet(),doPost()等

服务器(硬件)上有安装了web容器(软件),免费的如tomcat管理着servlet生命周期,浏览器发送http请求后,
servlet.xml的service->connector(多个)->engin->host(多个)->context(多个)->web.xml
映射着使用哪个servlet,经过servlet处理后的请求返回给浏览器,用户就完成一次和服务器之间的交互;


Servlet 的 HelloWorld
创建一个 Servlet 接口的实现类. public class HelloServlet implements Servlet
这里的HelloServlet 就是一个servlet;

web.xml 文件中配置 Servlet接口 和 访问映射关系

<servlet>
	<!-- Servlet 注册的名字 -->
	<servlet-name>helloServlet</servlet-name>
	<!-- Servlet的全类名,具体后台操作就在这个servlet中 -->
	<servlet-class>com.atguigu.javaweb.HelloServlet</servlet-class>
</servlet>

<servlet-mapping>
	<!-- 需要和某一个 servlet 节点的 serlvet-name 子节点的文本节点一致 -->
	<servlet-name>helloServlet</servlet-name>
	<!-- 浏览器访问路径: / 代表当前 WEB 应用的根目录. -->
	<url-pattern>/hello</url-pattern>
</servlet-mapping>



Servlet 生命周期的方法: 以下方法都是由容器(如tomcat)负责调用. 

1). 构造器:第一次请求 Servlet 时,创建Servlet的实例(只被调用一次,这说明 Serlvet 的单实例的)
2). init方法: 在创建好实例后被调用. 用于初始化当前 Servlet(只被调用一次)

3). service: 被多次调用.每次请求都会调用service 方法.实际用于响应请求的

4). destroy: 在当前Servlet所在的WEB应用被正常卸载前调用.用于释放当前Servlet所占用的资源(只被调用一次)
 
总结 : 出了service每次会调用,其它都是运行一次;

	
load-on-startup: 可以指定 Serlvet 被创建的时机

若为 0 或正数, 则在当前 WEB 应用被Serlvet 容器加载时创建实例, 且数组越小越早被创建. 
若为负数, 则在第一次请求时被才创建.
<servlet>
	<servlet-name>secondServlet</servlet-name>
	<servlet-class>com.atguigu.javaweb.SecondServlet</servlet-class>
	<!-- 指定 Servlet 被创建的时机,有时一个servlet需要在另一个servlet之后才会创建成功. -->
	<load-on-startup>2</load-on-startup>
</servlet>


关于 serlvet-mapping：
1). 同一个Servlet可以被映射到多个URL上,即多个 <servlet-mapping>,
	而<servlet-name>子元素的设置值是同一个Servlet名字. 
	
2). 在Servlet映射到的URL中也可以使用 * 通配符,但是只能有两种固定的格式：
一种格式是“*.扩展名”,另一种格式是以正斜杠(/)开头并以“/*”结尾  

<servlet-mapping>
	<servlet-name>secondServlet</servlet-name>
	<url-pattern>/*</url-pattern>
</servlet-mapping>
OR
<servlet-mapping>
	<servlet-name>secondServlet</servlet-name>
	<url-pattern>*.do</url-pattern>
</servlet-mapping>

注意: 以下的既带 / 又带*
扩展名的不合法. 
<servlet-mapping>
	<servlet-name>secondServlet</servlet-name>
	<url-pattern>/*.action</url-pattern>
</servlet-mapping>
*/



ServletConfig: 封装了servlet(狭义理解可以读取web.xml配置文件)的配置信息,并且可以获取ServletContext对象

1). 配置 Serlvet 的初始化参数
	<servlet>
		<servlet-name>helloServlet</servlet-name>
		<servlet-class>com.atguigu.javaweb.HelloServlet</servlet-class>	
		
		<!-- 配置 Serlvet 的初始化参数. 且节点必须在 load-on-startup 节点的前面.-->
		<init-param>
			<!-- 参数名 -->
			<param-name>user</param-name>
			<!-- 参数值 -->
			<param-value>root</param-value>
		</init-param>
		
		<init-param>
			<param-name>password</param-name>
			<param-value>1230</param-value>
		</init-param>
		
		<load-on-startup>-1</load-on-startup>	
	</servlet>


ServletContext(大管家)
1).可以由SerlvetConfig 获取,也可以通过session,request获得
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
ServletContext servletContext = servletConfig.getServletContext();

2). 该对象代表当前 WEB 应用:可以认为 SerlvetContext 是当前WEB应用的一个大管家.可以从中获取到当前WEB应用的各个方面的信息.

获取当前 WEB 应用的初始化参数

<context-param>设置初始化参数可以为所有的Servlet都可以获取,
而<init-param>的初始化参数只能是当前Serlvet可以. 

<!-- WEB 应用的初始化参数,这是全局变量-->
<context-param>
	<param-name>driver</param-name>
	<param-value>com.mysql.jdbc.Driver</param-value>
</context-param>

<!--当前servlet可以得到-->
<init-param>
	<param-name>user</param-name>
	<param-value>root</param-value>
</init-param>

方法:
getInitParameter(String name): 获取指定参数名的初始化参数
getInitParameterNames(): 获取多个参数名组成的 Enumeration 对象. 
代码:
	ServletContext servletContext = servletConfig.getServletContext();		
	String driver = servletContext.getInitParameter("driver");
	System.out.println("driver:" + driver);
	
	Enumeration<String> names2 = servletContext.getInitParameterNames();
	while(names2.hasMoreElements()){
		String name = names2.nextElement();
		System.out.println("-->" + name); 
	}

	
获取当前WEB应用的某一个文件在服务器上的绝对路径, 而不是部署前的路径(必须会的)
已知一个文件相对项目的相对路径,得到绝对路径
String realUploadPath = session.getServletContext().getRealPath("/images");//和webApp在同一层有这样一个文件夹
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
/**
 * 上传文件
 * */
public static String fileUpload(HttpServletRequest request,
								String relativePath, MultipartFile filedata) {
			
	String savePath = request.getSession().getServletContext().getRealPath(relativePath);//相对路径得到真实路径
	System.out.println("savePath----------------"+savePath);	
	String fileID = UUID.randomUUID().toString();
	String fileName = filedata.getOriginalFilename();
	if (!filedata.isEmpty()) {
		String extensionName = fileName.substring(fileName.lastIndexOf("."));
		String name = fileID + extensionName;
		File fileDir = new File(savePath);
		if (!fileDir.exists()) {
			fileDir.mkdirs();
		}
		if (filedata != null && !filedata.isEmpty()) {
			try {
				//保存路径得到写入流
				FileOutputStream out = new FileOutputStream(savePath + File.separator + name);
				InputStream in = filedata.getInputStream();//得到上传文件的读取流
				byte buffer[] = new byte[1024];
				int len = 0;
				while ((len = in.read(buffer)) > 0) {
					out.write(buffer, 0, len);
				}
				out.flush();
				out.close();
				in.close();
				return name;
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		}
	}
	return "";
}
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
文件下载:
源码在:FileUpAndLoad20151116中downLoad包中index.jsp

步骤:
1,设置 contentType 响应头: 设置响应的类型是什么 ? 
response.setContentType("application/x-msdownload");  //核心参数

2,设置响应头: 通知浏览器不再自行处理(或打开)要下载的文件, 而由用户手工完成
response.setHeader("Content-Disposition", "attachment;filename=abc.txt");

3,具体的文件: 可以调用 response.getOutputStream 的方式, 以 IO 流的方式发送给客户端.

举例:
response.setContentType("application/x-msdownload");  //核心参数
response.setHeader("Content-Disposition", "attachment;filename=abc.txt");
OutputStream out = response.getOutputStream();
//这个文件名字可能和用户选择下载那个文件有关,或则就是写死的
InputStream in = new FileInputStream("C:\\Users\\JavaWEB监听器.pptx");
byte [] buffer = new byte[1024];
int len = 0;
while((len = in.read(buffer)) != -1){
	out.write(buffer, 0, len);
}
in.close();
++++++++++++++++++++++++++++++++++++++++++++++
动态设置contentType
import javax.activation.MimetypesFileTypeMap;
    private static void setContentTypeHeader(HttpResponse response, File file) {
        //使用mime对象获取文件类型
        MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
        response.headers().set(CONTENT_TYPE, mimeTypesMap.getContentType(file.getPath()));
    }

++++++++++++++++++++++++++++++++++++++++++++++
获取当前 WEB 应用的名称: 
String contextPath = servletContext.getContextPath();//项目名

getResourceAsStream(String path): path的/为当 WEB应用的根目录.
(这里/指D:\\apache-tomcat-7.0.62\\tomcat\\webapps\\当前项目)
代码:
InputStream is2 = servletContext.getResourceAsStream("/WEB-INF/classes/jdbc.properties");
	
总结servletContext 中可以得到:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1,web.xml的全局变量,局部变量
2,得到项目文件中的绝对路径 
3,得到项目文件的输入输出流
4,和attribute相关的方法
5,得到项目名字

 


GET 请求和 POST 请求:

使用GET方式传递参数:
在浏览器地址栏中输入某个URL地址,默认是GET请求
如果网页中的<form>表单元素的 method 属性被设置为了“GET”,浏览器提交这个FORM表单时生成的HTTP请求消息的请求方式也为GET. 
GET请求发送参数格式：http://www.atguigu.com/counter.jsp?name=lc&password=123
GET方式传送的数据量一般限制在 1KB以下. 

使用 POST 方式传递参数:
POST 请求方式主要用于向WEB服务器端程序提交FORM表单中的数据: form表单的method设为POST
POST 方式将表单字段元素及其数据作为HTTP消息的实体内容发送给 WEB 服务器,大小没有限制
										~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

如何在 Serlvet 中获取请求信息:


Servlet 的 service() 方法用于应答请求: 因为每次请求都会调用 service() 方法
public void service(ServletRequest request, ServletResponse response)
			
ServletRequest: 封装了请求信息,ServletResponse: 封装了响应信息

①. *getWriter(): 返回 PrintWriter 对象.调用该对象的print()方法,将把 print()中的参数直接打印到客户的浏览器上. 
②. 设置响应的内容类型: response.setContentType("application/msword"); //常用 
③. void sendRedirect(String location): 请求的重定向（此方法为 HttpServletResponse 中定义)

---------------------------------------------
1. GenericServlet(了解):

1). 是 Servlet 接口和 ServletConfig 接口的实现类. 但是一个抽象类. 其中的 service 方法为抽象方法
2). 如果新建的 Servlet 程序直接继承 GenericSerlvet 会使开发更简洁.
3). 具体实现:

①在 GenericServlet 中声明了一个 SerlvetConfig 类型的成员变量, 在 init(ServletConfig) 方法中对其进行了初始化 
②利用 servletConfig 成员变量的方法实现了 ServletConfig 接口的方法
③还定义了一个 init() 方法, 在 init(SerlvetConfig) 方法中对其进行调用, 子类可以直接覆盖 init() 在其中实现对 Servlet 的初始化. 
④不建议直接覆盖 init(ServletConfig), 因为如果忘记编写 super.init(config); 而还是用了 SerlvetConfig 接口的方法,
则会出现空指针异常. 
⑤新建的 init(){} 并非 Serlvet 的生命周期方法. 而 init(ServletConfig) 是生命周期相关的方法. 


public abstract class GenericServlet implements Servlet, ServletConfig {

	private ServletConfig servletConfig;
	
	
	/** 以下方法为 Servlet 接口的方法 **/
	@Override
	public void destroy() {}

	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		this.servletConfig = arg0;
		init();
	}

	public void init() throws ServletException{}

	@Override
	public abstract void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException;

	/** 以下方法为 ServletConfig 接口的方法 **/
	@Override
	public String getInitParameter(String arg0) {
		return servletConfig.getInitParameter(arg0);
	}

	@Override
	public Enumeration getInitParameterNames() {
		return servletConfig.getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		return servletConfig.getServletContext();
	}

	@Override
	public String getServletName() {
		return servletConfig.getServletName();
	}

}

-----------------------------------------
2. HttpServlet:

1). 继承自 GenericServlet. 针对于 HTTP 协议所定制. 
public abstract class GenericServlet implements Servlet, ServletConfig //一共4个,2个接口，1个抽象类，1个类
2). 在 service() 方法中直接把 ServletReuqest 和  ServletResponse 转为 HttpServletRequest 和 HttpServletResponse.
并调用了重载的 service(HttpServletRequest, HttpServletResponse)

在 service(HttpServletRequest, HttpServletResponse) 获取了请求方式: request.getMethod().根据请求方式创建
doGet或者是doPost

@Override
 public void service(ServletRequest req, ServletResponse res)
    throws ServletException, IOException {

    HttpServletRequest  request;
    HttpServletResponse response;
    
    try {
        request = (HttpServletRequest) req;
        response = (HttpServletResponse) res;
    } catch (ClassCastException e) {
        throw new ServletException("non-HTTP request or response");
    }
    service(request, response);
}

public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	//1. 获取请求方式.
	String method = request.getMethod();
	
	//2. 根据请求方式再调用对应的处理方法
	if("GET".equalsIgnoreCase(method)){
		doGet(request, response);
	}else if("POST".equalsIgnoreCase(method)){
		doPost(request, response);
	}
}



实际开发中, 直接继承 javax.servlet.http.HttpServlet, 并根据请求方式复写 doXxx() 方法即可. 
好处: 直接由针对性的覆盖 doXxx() 方法; 直接使用 HttpServletRequest 和  HttpServletResponse, 不再需要强转. 
-----------------------------------------------------
-----------------------------------------------------
4. 请求的转发和重定向(精华):
1). 本质区别: 请求的转发只发出了一次请求, 而重定向则发出了多次请求. 


转发: 地址栏是初次发出请求的地址.
重定向: 地址栏地址会改变. 为最后响应的那个地址  
   
转发: 最终request 是同一个对象. 
重定向: 最终request不是同一个对象.        

转发: 只能转发给当前 WEB 应用的的资源
重定向: 可以重定向到任何资源.      

转发: / 代表的是当前 WEB 应用的根目录
	注:localhost:8080/day_30/
重定向: / 代表的是当前 WEB 站点的根目录. 
	注:localhost:8080/

------------------------------------------------------------------------------------	
servlet和struts1及SpingMVC都是线程不安全的,struts2 是线程安全的

不安全的有两种解决方案:
1,实现SingleThreadModel ,一次只能一个线程访问,其它的等待（说明默认是支持并发的）
2,使用@Scope("prototype")//每次都会生成一个对象
3,不使用成员变量(因为就是成员变量会被重新赋值,推荐)


++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++

会话机制:

Cookie/Session机制详解

Cookie通过在客户端记录用户信息,Session通过在服务器端记录用户信息
			~~~~~~~~~~~~~~~~~


1.1  Cookie机制

为什么需要会话机制?
在程序中,会话跟踪是很重要的事情.理论上,一个用户的所有请求操作都应该属于同一个会话,另一个用户的所有请求操作则应该属于另一个会话
,二者不能混淆.例如,用户A在超市购买的任何商品都应该放在A的购物车内,不论是用户A什么时间购买的,这都是属于同一个会话的,
不能放入用户B或用户C的购物车内,这不属于同一个会话.

而Web应用程序是使用HTTP协议传输数据的.HTTP协议是无状态的协议.一旦数据交换完毕,客户端与服务器端的连接就会关闭,
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
再次交换数据需要建立新的连接.这就意味着服务器无法从连接上跟踪会话.即用户A购买了一件商品放入购物车内,
当再次购买商品时服务器已经无法判断该购买行为是属于用户A的会话还是用户B的会话了.要跟踪该会话,必须引入一种机制.

Cookie就是这样的一种机制.它可以弥补HTTP协议无状态的不足.在Session出现之前,基本上所有的网站都采用Cookie来跟踪会话.

1.1.1  什么是Cookie
是由W3C组织提出,最早由Netscape社区发展的一种机制.目前Cookie已经成为标准,
所有的主流浏览器如IE、Netscape、Firefox、Opera等都支持Cookie.

Cookie实际上是一小段的文本信息.客户端在请求服务器,如果服务器需要记录该用户状态,就使用response向客户端浏览器颁发一个,
				~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
然后客户端浏览器会把Cookie保存起来.当浏览器再请求该网站时,浏览器把请求的网址连同该Cookie一同提交给服务器.
								~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
服务器检查该Cookie,以此来辨认用户状态.服务器还可以根据需要修改Cookie的内容.


注意：Cookie功能需要浏览器的支持.
如果浏览器不支持Cookie(如部分手机中的浏览器)或者把Cookie禁用了,Cookie功能就会失效.
不同的浏览器采用不同的方式保存Cookie.
IE浏览器会在“C:\Documents and Settings\你的用户名\Cookies”文件夹下以文本文件形式保存,一个文本文件保存一个Cookie.


Java对Cookie封装成javax.servlet.http.Cookie类.每个Cookie都是该Cookie类的对象.
服务器通过操作Cookie类对象对客户端Cookie进行操作.
主要方法2个(得到和设置):
通过request.getCookies() 获取客户端提交的所有Cookie(以Cookie[] 形式返回),
通过response.addCookie(Cookiecookie) 向客户端设置Cookie (非常重要)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
因为Cookie类位于包javax.servlet.http.*下面,所以JSP中不需要import该类.


cookie 要尽可能的短，不要有中文


Cookie修改与删除

response对象提供的Cookie操作方法只有一个添加操作add(Cookie cookie)
要想修改Cookie只能使用相同key,不同value覆盖原来的Cookie;
删除时只需要把maxAge修改为0即可

注意：从客户端读取Cookie时,包括maxAge在内的其他属性都是不可读的,也不会被提交.浏览器提交Cookie时只会提交name与value属性.
maxAge属性只被浏览器用来判断Cookie是否过期（服务器说了算，客服端不能修改）
		

Cookie的域名

Cookie是不可跨域名的.域名www.google.com颁发的Cookie不会被提交到域名www.baidu.com去.这是由Cookie的隐私安全机制决定的.
~~~~~~~~~~~~~~~~~~~~~~																~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
隐私安全机制能够禁止网站非法获取其他网站的Cookie.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

正常情况下,同一个一级域名下的两个二级域名如www.google.com和www.images.google.com也不能交互使用Cookie,
因为二者的域名并不严格相同.如果想所有google.com名下的二级域名都可以使用该Cookie,需要设置Cookie的domain参数,例如：
                             ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
						 
Cookie cookie = new Cookie("time","20080808");  // 新建Cookie
cookie.setDomain(".google.com"); // 设置这个域名(一定是以.开头的;);这里表示只要是以这个路径结尾的都可以得到cookie
cookie.setPath("/");               //设置cookie的使用路径;这里这个项目下都可以使用(相对于domain的第二次约束)
cookie.setMaxAge(Integer.MAX_VALUE);   // 设置有效期
response.addCookie(cookie);           // 回写到客户端


如果是不同的主机之间如何共享Cookie
很多网站都有二级域名(配置虚拟主机):
一级域名: www.baidu.com
二级域名: www.music.baidu.com, map.baidu.com等
需求:多个二级域名之间共享登录信息:
cookie.setPath("/");
cookie.setDomain(".baidu.com");


可以修改本机C:\WINDOWS\system32\drivers\etc下的hosts文件来配置多个临时域名,
然后使用setCookie.jsp程序来设置跨域名Cookie验证domain属性.
注意：domain参数必须以点(".")开始.
																		
Domain为设置Cookie的有效域,Path限制有效路径,两个都是限制作用域的,如以下几种情况：
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


Cookie的安全属性

HTTP协议不仅是无状态的,而且是不安全的.使用HTTP协议的数据不经过任何加密就直接在网络上传播,有被截获的可能.使用HTTP协议传输
很机密的内容是一种隐患.如果不希望Cookie在HTTP等非安全协议中传输,可以设置Cookie的secure属性为true.										
						~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
浏览器只会在HTTPS和SSL等安全协议中传输此类Cookie.下面的代码设置secure属性为true：		
								
Cookie cookie = new Cookie("time", "20080808"); 
cookie.setSecure(true);  // 设置安全传输,这尼玛首先该网站要先支持https吧,没使用过
response.addCookie(cookie); //输出到客户端

提示：secure属性并不能对Cookie内容加密,因而不能保证绝对的安全性.如果需要高安全性,需要在程序中对Cookie内容加密、解密,以防泄密

（如果是网络拦截时还是拿到你加密后的码服务器还是无法辨认，只有服务返回的数据也是加密的，只有客服端知道怎么解;那么就算拿到cookie也没用）



2,第2种方案cookie放入session的对象,让它实现序列号接口(java.io.Serializable)
原因:多台服务器集群的时候,共享session数据(在网络上传输数据,就算访问的那台服务器挂了,session数据也不会丢)
序列化 :对象转为2进制数据(对象流)
反序列化: 2进制数据恢复为对象(对象流)


HttpSession对象

1. Session 的创建和销毁

Session 对象的销毁方式有如下2种: 
①. 直接调用 HttpSession 的 invalidate()

②. HttpSession 超过过期时间. 
		返回最大时效: getMaxInactiveInterval() 单位是秒
		设置最大时效: setMaxInactiveInterval(int interval)
		可以在 web.xml 文件中配置 Session 的最大时效, 单位是分钟. 	
	<session-config>
        <session-timeout>30</session-timeout>
    </session-config>
③. 关闭当前 WEB 应用. (这种其实不算)
注意: 关闭浏览器不会销毁 Session,因为session 存放在服务器上的;
---------------------------------------------------------


使用绝对路径：使用相对路径可能会有问题, 但使用绝对路径肯定没有问题(但项目后期修改,需要到处改). 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1). 绝对路径： 是从盘符开始的路径,如C:\windows\system32\cmd.exe

在当前 WEB 应用的所有的路径前都添加request或application.ContextPath()即可.
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>



2) / 什么时候代表站点的根目录, 什么时候代表当前 WEB 应用的根目录

http://zhidao.baidu.com 就是站点根目录

若 / 需要服务器进行内部解析, 则代表的就是 WEB 应用的根目录.就不需要加上 ContextPath;
若是交给浏览器了, 则/代表的就是站点的根目录
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
(站点根目录就是webapp下，web应用根目录就是该项目内的根目录)
----------------------------------------------------------------

表单的重复提交(工作中,居然大部分人都忽视了这么常用且重要的技术)

1). 重复提交的情况: 
①.  重复点击提交按钮 (fireFox无效)
②.  刷新成功页面(forward)
③.  通过回退再次点击提交按钮
表单重复提交的根本原因:
 没有进行完整的请求表单界面后 在提交表单的过程.
 
解决方案有两种:
1,让表单不能回退或失效(比如银行页面,一般不推荐)
2,和验证码的思路一样(只是token在隐藏字段中),每次在请求表单页面都带上一个token,
在提交时需要比对这个token,成功后先删除这token.然后做后面的逻辑; 如果失败什么都不做
+++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++
EL表达式 (Expression Language)


为什么会出现?
EL 的语法比传统 JSP表达式(<%= ....%>)与
          Jsp中的java代码(<% ....%>)操作属性更为方便简洁  
且在Jsp页面使用无需导入任何包,直接使用
+++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++
	
JSP
jsp页面会通过http将文件内容传到web服务器上的servlet,转为java文件,处理逻辑后通过response输出
静态的html展示给用户;这样来完成动态的

https://www.runoob.com/jsp/jsp-architecture.html

Java Server Page: Java服务器端网页.
JSP 是简Servlet编写的一种技术, 它将Java代码和HTML 语句混合在同一个文件中编写,
对网页中的要动态产生的内容采用 Java 代码来编写,而对固定不变的静态内容采用 HTML 方式编写. 
			

2). helloworld: 
新建一个 JSP 页面, 在body节点内的<% %> （尖括号加百分号）即可编写Java代码.
不需要服务器解析的代码就不要放在<%%>中
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<body>
	<% 
		Date date = new Date();
		System.out.print(date); 
	%>
</body>



4). JSP的运行原理: JSP 本质上是一个 Servlet,这个对象拥有一系列的方法来处理Http请求
	~~~~~~~~~~~~~~	~~~~~~~~~~~~~~~~~~~~~~~~~~
每个JSP 页面在第一次被访问时,JSP引擎将它翻译成一个Servlet源程序, 再把这个Servlet源程序编译成 class 类文件.
~~~~~~~~~~~~~~~~~~~~~~~~~~~  	~~~~~~~    
然后再由WEB容器像调用普通Servlet程序一样的方式来装载和解释执行（可以看出好慢）
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

5). JSP 页面的隐含变量: 没有声明就可以使用的对象. JSP页面一共有 9 个隐含对象

①. request: 实际是HttpServletRequest对象.非常常用;request.getHeaderNames();可以得到大部分主要信息
②. response: 实际是HttpServletResponse 对象(在 JSP 页面中几乎不会调用 response 的任何方法.因为这个是返回页面信息的)
③. pageContext: 页面的上下文,是 PageContext的一个对象.可以从该对象中获取到其他8个隐含对象.也可以从中获取到当前
页面的其他信息. (学习自定义标签时使用它) *
④. session: 代表浏览器和服务器的一次会话, 是 HttpSession 的一个对象.后面详细学习. *
⑤. application: 代表当前WEB应用.是ServletContext对象.*
⑥. config: ServletConfig 对象(几乎不使用).
⑦. out: JspWriter对象.调用 out.println()可以直接把字符串打印到浏览器上.*
⑧. page: 指向当前JSP对应的Servlet对象的引用,但为Object类型,只能调用Object类的方法(几乎不使用) 
⑨:
errorPage = "错误页面.jsp" 如果想跳转过去,必须在错误页面上申明为:
<%@ page isErrorPage="true" %>
所以说:这两个错误声明一对.

全局错误(web.xml文件中设置):
上面的错误声明是针对一个jsp的,如果要设置全部jsp页面的错误跳转

<error-page>
	<error-code>404</error-code>
	<location>/404Error.jsp</location>
</error-page>
<error-page>
	<error-code>500</error-code>
	<location>/500Error.jsp</location>
</error-page>
--------------------------

<%= date %>(注意和<%%>比对区别)
7). JSP表达式将一个java变量或表达式的计算结果输出到客户端的简化方式,									~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

8). JSP脚本片断(scriptlet)是指嵌套在<% 和 %>之中的一条或多条Java程序代码. 
多个脚本片断中的代码可以相互访问

<% 
	String ageStr = request.getParameter("age");//后面使用EL替换了这种方法
	Integer age = Integer.parseInt(ageStr);
	
	if(age >= 18){
%>
		成人...
<%
	}else{
%>
		未成人...
<%
	}
%>



10). JSP注释的格式：<%-- JSP 注释 --%>   <!-- HTML 注释 -->
区别: JSP 注释可以阻止 Java 代码的执行. 且客户看不见注释

------------------------------
6. 和属性相关的方法:

1). 方法

void setAttribute(String name, Object o): 设置属性  
Object getAttribute(String name): 获取指定的属性

Enumeration getAttributeNames(): 获取所有的属性的名字组成的 Enumeration 对象
removeAttribute(String name): 移除指定的属性 

2). pageContext, request, session, application 对象都有这些方法!这四个对象也称之为域对象. 
pageContext: 属性的作用范围仅限于当前 JSP 页面
request:  属性的作用范围仅限于同一个请求. 
session: 属性的作用范围限于一次会话: 浏览器打开直到关闭称之为一次会话(且在此期间会话没失效)
application: 属性的作用范围限于当前WEB应用.是范围最大的属性作用范围,
只要在一处设置属性,在其他各处的JSP或Servlet中都可以获取到.

pageContext, request, session, application(对属性的作用域的范围从小到大)
																						
+++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++
JSP 标准标签库（JSTL）
JSP标准标签库（JSTL）是一个JSP标签集合，它封装了JSP应用的通用核心功能。
作用:大大加快前端开发速度,和让编写前端代码更加优雅
https://www.runoob.com/jsp/jsp-jstl.html
如:
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>//核心标签,if,foreach等
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>//格式化,国际化,时间等
+++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++

FILTER 过滤器(了解,一般被springMvc的HandlerInterceptor代替)
(双向过滤,多个多滤器的路线如:进时1,2,3,回时3,2,1)

过滤器是一个实现了 javax.servlet.Filter 接口的 Java 类(在servlet下)

Filter 接口定义在 javax.servlet 包中，而接口 HandlerInterceptor 定义在org.springframework.web.servlet 包中
功能基本差不多，HandlerInterceptor更加强大点（fileter 主要用于对所有请求进行统一处理）

多种同时使用执行顺序(过滤器在最外层的2端,这是它的优势)
过滤前-拦截前-AOP-Action处理-aop-拦截后-过滤后

//过滤器（Filter）与拦截器（Interceptor )区别
https://www.cnblogs.com/junzi2099/p/8022058.html


JavaWEB 的一个重要组件, 可以对发送到 Servlet 的请求进行拦截, 并对响应也进行拦截. 
                                   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Filter 是实现了 Filter 接口的 Java 类.
Filter 需要在 web.xml 文件中进行配置和映射. 
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


Web中的过滤器 :web组件,在java中最小的组件,就是一个类(是双向过滤的,在客服端和服务端资源的中间 请求 返回都要经过它) 

过滤器在开发的常见应用场景:
1,可以对客户的提交进行重新编码
2,让浏览器不存缓存页面
3,对非法url过滤(推荐)


如何创建一个 Filter

①. 创建一个 Filter 类: 实现 javax.servlet.Filter接口:
 public class HelloFilter implements Filter
主要方法3个：init,doFilter,destroy
 
②. 在 web.xml 文件中配置并映射该 Filter. 其中 url-pattern 指定该 Filter 可以拦截哪些资源

<!-- 注册 Filter -->
<filter>
	<filter-name>helloFilter</filter-name>
	<filter-class>com.atguigu.javaweb.HelloFilter</filter-class>
</filter>

<!-- 映射 Filter -->
<filter-mapping>
	<filter-name>helloFilter</filter-name>
	<url-pattern>/test.jsp</url-pattern>
</filter-mapping>

------------------------------------------

public void init(FilterConfig filterConfig): Filter对象在 Servlet 容器加载时被创建立且被调用,且只被调用一次. 
该方法用于进行初始化操作.Filter 实例是单例的(init只会被调用一次).

*  FilterConfig 类似于 ServletConfig
* 可以在 web.xml 文件中配置当前 Filter 的初始化参数. 配置方式也和 Servlet 类似.	
<filter>
	<filter-name>helloFilter</filter-name>
	<filter-class>com.atguigu.javaweb.HelloFilter</filter-class>	
	<init-param>
		<param-name>name</param-name>
		<param-value>root</param-value>
	</init-param>
</filter>

------------------------------------------
//逻辑代码编写在该方法中. 每次拦截都会调用该方法.
public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain): 


/**
 * 防止页面有缓存加入下面3行代码,但是我没有测试出缓存的存在.
 */
public class cacheFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		response.setDateHeader("Expires",-1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");	
		filterChain.doFilter(request, response);
	}
}

--------------------

FilterChain: Filter 链,多个 Filter 构成一个 Filter 链. 		
	- doFilter(ServletRequest request, ServletResponse response): 把请求传给 Filter 链的下一个 Filter,
	最后一个 Filter, 将把请求给到目标 Serlvet(或 JSP)	
	
	- 多个 Filter 拦截的顺序和 <filter-mapping> 配置的顺序有关,靠前的先被调用.
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	如: before执行  1,2,3 ,after 就执行 3,2,1 ;(前进后出)

------------------------------------------

public void destroy(): 释放当前 Filter 所占用的资源的方法. 在 Filter 被销毁之前被调用, 且只被调用一次


<dispatcher> 元素: 指定过滤器所拦截的资源被 Servlet 容器调用的方式,
                       ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
推荐在web.xml中配置,不建议注解:@WebFilter(dispatcherType={DispatcherType.REQUEST,DispatcherType.Forward})
可以是REQUEST,FORWARD,INCLUDE,ERROR之一(后面2种少用),默认REQUEST

Filter 默认情况下,就是只能对一次请求做过滤
<dispatcher>REQUEST</dispatcher>

如果想请求转发做过滤:
<dispatcher>REQUEST</dispatcher>
<dispatcher>FORWARD</dispatcher>

很少使用:

<filter-mapping>
	<filter-name>secondFilter</filter-name>
	<url-pattern>/test.jsp</url-pattern>
	<dispatcher>INCLUDE</dispatcher> //对请求包含做过滤
	<dispatcher>ERROR</dispatcher> //去错误页面之前做过滤
</filter-mapping>
++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++
WEB 监听器(web组件,适用于Web开发)
支持xml配置和注解的方式配置

按监听类型可分3种:

1,作用域的生命周期监听器(创建和销毁,全是接口):
ServletRequestListener
HttpSessionListener
ServletContextListener(监听系统启动时,在初始化方法中编写初始化代码很常用,spring加载就是靠它);

2,作用域属性监听器(添加/删除/替换):
ServletRequestAttributeListener(接口,统一多了attribute)
HttpSessionActivationListener(接口)
ServletContextAttributeListener(接口)

servlet 和 Filter 都有局部的初始化参数,而监听器没有,监听器使用全局的的初始化参数
全局的:
<context-param>
	<param-name></param-name>
	<param-value></param-value>
</context-param>
局部的:
<init-param>
	<param-name>name</param-name>
	<param-value>root</param-value>
</init-param>

----------------------------
核心中的核心，逻辑中的逻辑

ServletContextListener:(最常用,其它2个都不怎么用)

//自定义类实现 ServletContextListener, 然后实现两个方法			
public class HelloListener implements ServletContextListener{

	//当WEB项目被加载时,Servlet容器调用该方法.(spring启动就是重写了这个方法，核心中的核心)
	public void contextInitialized(ServletContextEvent sce) {	
		ServletContext servletContext = sce.getServletContext();
		//ServletContext 对象中所有的方法就都可以使用了	
		String string = servletContext.getInitParameter("name");
		//然后将这个参数放到域中
		servletContext.setAttribute("string", string);		
	}	
	
	//SerlvetContext对象被销毁之前(只要编译后重新加载前就会先销毁)的时候, Servlet容器调用该方法. 
	public void contextDestroyed(ServletContextEvent sce) {	
		System.out.println(sce.getServletContext().getAttribute("string")+" --------- destrory");
	}
}
		
在 web.xml 文件中配置 Listener
	<listener>
		<listener-class>com.atguigu.javaweb.test.HelloListener</listener-class>
	</listener>

可以在WEB应用被加载时对一些资源进行初始化操作
如：创建数据库连接池,创建 Spring 的IOC容器,读取当前 WEB 应用的初始化参数等
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
在spring中如何使用监听器? 或则如何得到spring的上下文和servlet的上下文?
(现实下面的2个Aware接口,又简单,又实用;面试会问)

import javax.servlet.ServletContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

//必须要注解
@Component
public class SpringContextUtils implements ServletContextAware,ApplicationContextAware {
	
	//通过返回这2个变量引用就ok,里面什么都不需要做
	private static ApplicationContext applicationContext;
	private static ServletContext webServletContext;

	@Override
	public void setServletContext(ServletContext webServlet) {
		webServletContext = webServlet;
	}

	public static ServletContext getServletContext() {
		return webServletContext;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext app) throws BeansException {
		this.applicationContext = app;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
------------------------------------------------	
下面的2个了解:
7. HttpSessionBindingListener (该监听器较少被使用) 
监听实现了该接口的 Java 类的对象被绑定到 session 或从 session 中解除绑定的事件.
//当前对象被绑定到 session 时调用该方法
public void valueBound(HttpSessionBindingEvent event) 
//当前对象从 session 中解除绑定调用该方法
public void valueUnbound(HttpSessionBindingEvent event) 


8. HttpSessionActivationListener (该监听器较少被使用) 
必须配合Serializable使用,不然读不出来
监听实现了该接口和 Serializable 接口的 Java 类的对象随 session 钝化和活化事件
	> 活化: 从磁盘中读取 session 对象	
	> 钝化: 向磁盘中写入 session 对象	
	> session 对象存储在tomcat 服务器的 work\Catalina\localhost\contextPath 目录下. SESSION.SER	
//在活化之后被调用. 
public void sessionDidActivate(HttpSessionEvent se)
//在钝化之前被调用
public void sessionWillPassivate(HttpSessionEvent se)

总结:一共是8个Listener. 3个监听创建和销毁的 3个监听属性,另加Session绑定和还有Session活化钝化	

++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
AJAX

Asynchronous(异步) JavaScript and XML 
Ajax的就是不用刷新整个页面便可完成和服务器通信的技术,且整个过程是异步的
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

使用Ajax的主要方式是xmlHttprequest对象.

原生的javaScript Ajax,的hello,开发一般不用,但对我们理解有帮助.源码ajax工程下的index.jsp中

Ajax传输数据的3种方式:

XML :笨重,解析困难,但XML是通用的数据交换格式
HTML :不需要解析可以直接放到文档中,若仅更新一部分区域,可以使用.但传输的数据不是很方便,且HTML代码需要拼装完成
JSON : 小巧,有面向对象的特征,且有很多第三方的 Jar包可以把 Java对象或集合转为JSON 字符串(推荐)

这个三种方式都有源码:源码ajax工程下对应的包中 ,实际开发我们用下面的:
----------------------------------------------------------------
在jquery 中使用ajax load() get() post() getJSON
对于这 四种 方式源码在ajax工程下的2对应的包中 ,实际开发就用这4个:
----------------------------这4种方法都为了解----------------------------------
<script type="text/javascript" src="../scripts/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("a").click(function(){
			var url = this.href;
			var args = {"time":new Date()};//JSON 格式
			//function :回调函数,当响应结束时,回调函数被触发,响应结果 在 data 中
			$.post(url,args,function(data){
				var name = $(data).find("name").text();
				var email = $(data).find("email").text();
				var website = $(data).find("website").text();
				$("details").empty()
							.append("<h2><a href='mailto:" + email + "'>" + name +"</a></h2>")
							.append("<a href='" + website + "'>" + website +"</a>");
			});		
			return false;
		});		
	}); 
</script>
-----------------------------
JSON(JavaScript Object  Notation(标记))一种简单的数据格式,比xml更轻巧.
JSON是JavaScript原生格式,这意味着在JavaScript中处理JSON数据不需要任何特殊的API或工具包. 
json 支持下面3种写法:
<script type="text/javascript">
	var jsonObj = {
					"name":"huangjufei",
					"address":{"tity":"beijing"},
					"mothod":function(){
						alert("使用json方式调用方法!!!");}
					};
	
	alert(jsonObj.name);
	alert(jsonObj.address.tity);
	jsonObj.mothod();
</script>
+++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++
为什么会有DAO或那么多DAO?

//第一步(公共的抽取出来,这个的T就是下面的User)
public class BaseDAOImpl<T> implements BaseDao<T> {

}	

//第二步(独立的)
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

}

我们使用泛型后,所有的实体类可以共用一个BaseDaoImpl;我们传入什么实体类,里面一样通过一样的T变量传递
其实做这么多就是抽取代码,为了让程序有更大的重用性,和解耦性.
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
SPRING

学spring主要3样:ioc,aop,和spring在管理bean的生命周期，暴露了一些可以操作bean的接口；
比如容器加载时期，bean初始化和销毁时可以让用户加入自己的业务逻辑；

spring 是一个使用java语言编写的轻量级容器框架,目的解决企业应用开发的复杂性

我们主要使用的如:控制反转(IOC)和面向切面(AOP)

容器:装对象的,负责对象的生命周期

框架(framework): 就如同毛坯房,已经是个半成品;

Bean的生命周期包括: Bean的定义,Bean的初始化,Bean的使用,Bean的销毁.

IOC (inverse of control)控制反转 或叫 DI(depend injection)依赖注入 :不是什么技术,是一种设计思想(类似MVC).
由Spring容器来管理对象之间的依赖关系,最终作用就是:对象和对象之间解耦
精华
http://www.cnblogs.com/DebugLZQ/archive/2013/06/05/3107957.html

举例:淘宝中的支付宝,用户和卖家通过支付宝来完成交易
-----------------------------------
如果对这一核心概念还不理解这里找到的浅显易懂的答案：
IoC与DI

　　首先想说说IoC(Inversion of Control,控制倒转).所谓IoC,
就是获得依赖对象的过程或方式反转了.由spring来负责控制对象的生命周期和对象间的关系.
所有的类的创建、销毁都由 spring来控制

IoC动态的向某个对象提供它所需要的其他对象.如何实现的呢？ 
反射(reflection)
----------------------------------------
spring  的　HelloWrold

1,一个普通的java类
public class HelloWorld {	
	private String name;	
	public void setName(String name) {
		this.name = name;
	}
	public void showHello(){
		System.out.println("hello:"+name);		
	}
}

2,在applicationContext.xml 文件配置这个类

<bean name="helloWorld" class="com.entity.HelloWorld">
	<property name="name" value="Spring"></property>
</bean>

3,使用
@Test
public void test() {		
	//1,加载applicationContext.xml的配置文件,
	ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	//2,这步就会去调配置文件所有的 <bean> 配置对应的类的 空的那个构造器函数,	
	HelloWorld hw = (HelloWorld) appContext.getBean("helloWorld");	
	//3,并给对应的属性进行赋值(底层反射完成的)
	hw.showHello();
}


//再看一个例子,测试不需tomcat,打印结果说明已经拿到了对象了
public class SpringIoc {
	ApplicationContext appContext = null;
	//把上面的代码放到构造器中执行
	public SpringIoc() {
		super();
		//路径可以是D:\...绝对路径或classpath相对路径
		 appContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");		
	}
	@Test
	public void testIoc(){
		WeixinController weixin = appContext.getBean(WeixinController.class);
		System.out.println(weixin);
		//打印com.iyoubang.controller.WeixinController@56380231
	}
}

----------------------------------------------------
ApplicationContext ctx = new ClassPathXmlApplicationContext("ppliactionContext.xml");
得到容器中的bean,有常用有三种重载方法:
1,使用id
Person p = (Person) ctx.getBean("person");//这种也可以强转错误
2,类class
Person p = ctx.getBean(Person.class);但需要保证这个类在xml中只配置了一次.不然框架也不知道用那个
3,id+类的class
Person p = ctx.getBean("person", Person.class);	//如果有多个Person.class使用名字来区别
----------------------------------------------------
spring 的测试 是spring的一个重要功能:

//告诉spring容器运行在JVM中
@RunWith(SpingJUnit4ClassRunner.class)
//加载配置文件;配置文件名 = 当前测试类全类名-context.xml,就可以不写
@ContextConfiguration(locations={"spring-context.xml","spring-mybatis.xml"})
public class SpringTest{	
	@AutoWired
	private ApplicationContext factory;
	@Test
	public void testSpringtest(){
		HelloWord hello = factory.getBean("helloWrold");
		hello.sayHello();
	}	
}
-------------------------------------
Bean 的创建时机:
加载spring配置文件时会调用<bean>标签,对应的类的空的构造器函数,并给对应的属性进行赋值
ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
所以,每个类中空的构造器必须要有

我们得到一个bean后我们可能需在给类的属性赋值：
spring 属性 支持3种注入方式:
	   ~~~~		
1,构造器注入(实体类有对应的构造器)
2,属性注入(使用的setter 方法,推荐)
3,工厂方法注入(很少使用,不推荐)

构造器注入(不常用)
constructor 是构造器注入值 注入方式有3种:
<bean name="personList" class="com.entity.list.Person">
	<constructor-arg value="101" index="0"></constructor-arg>
	<constructor-arg value="黄举飞" type="String"></constructor-arg>	
</bean>
1,我们可以按默认的构造器顺序注入(只写value)
2,我们可以指定index 下标的形式注入
3,type选择类型注入. (默认按顺序匹配,但可能出现都能匹配,我们就需要用type区别) 
这下标和类型的方式作用就是为了让我们区别重载构造器

如果属性值－内容包含特殊字符可以用CDATA抱起来
<constructor-arg value="beijing" type="java.lang.String">
//这样<上海>这个<>就不会被解析!
	<value><![CDATA[<上海>]]></value>
<constructor-arg>


属性注入就是通过底层会调用setter()方法注入
<property name="name" value="spring"></property>
-------------------------------------
对于类中的属性是一个类怎么设置值?
<bean>
	//name 是属性名,ref 指向另一个bean
	<property name="car" ref="car2"/>
	<property name="age" ref="24"/>

	//或第二种写法;
	<property name="car">
		<ref bean="car2"/>
	</property>
<bean>
------------------------------
内部bean,不能被外部引用,只能内部使用
<bean>
	<property name="car">
		<bean id="car3" class="com.spring.car">
			<constructor-arg value="ford"/>
			<constructor-arg value="shanghai"/>
			<constructor-arg value="20000"/>
		</bean>		
	</property>
	<property name="car.maxSpeed" value="260"/>//这就是在内部引用
</bean>

------------------------------
如果属性是一个集合,赋值 使用<list>标签
<property name="cars">
	<list>//数组和set和list差不多
		<ref bean="Car"/>
		<ref bean="Car2"/>	
		<bean class="com.spring.car">//当然这里还可以赋值内部bean
			<constructor-arg value="ford"/>
			<constructor-arg value="shanghai"/>
			<constructor-arg value="20000"/>
		</bean>
	</list>
</property>
------------------------------
为Map属性赋值 使用标签<map>
//map中放的是一个个entry ,一个entry 中放着一个键值对
<property name="cars">
	<map>
		<entry key="AA" value-ref="Car"/>
		<entry key="BB" value-ref="Car"/>	
	</map>
</property>
------------------------------
配置独立集合bean,以供多个bean进行引用,需要导入 util命名空间(了解)
(作用:就是多个bean共享,其实就是一个再次封装)

<util:list id="cars">
	<ref bean="car"/>
	<ref bean="car2">
</util:list>

<bean id="person4" class="com.spring.Person4">
	<property name="name" value="jack"></properties>	
	<property name="cars" ref="cars"></properties>//这个ref 名字 对应util:list 的id名
</bean>
---------------------------------
abstract 属性来修饰一个bean是否是抽象类

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- abstract="true" 修饰后不能再实例化,变为一个模板来存在 -->	
	<bean name="car" p:brand="dazhong" p:price="300000.00" abstract="true"> 
	</bean>
	
	<!--parent :修饰继承那个baen 的name depends-on :依赖于那个bean,,配置这个就必须有这个值-->	
	<bean name="car2"  class="com.parent.Car"  p:price="188888.00" parent="car" >
	</bean>	
</beans>
------------------------------------
spring的bean默认是单例的,可以通过scope来修改

ApplicationContext ctx = new ClassPathXmlApplicationContext("ppliactionContext.xml");
Person p=(Person) ctx.getBean("person");
Person p2=(Person) ctx.getBean("person");
System.out.println(p == p2);//默认是true 只会调用一次构造器,在加载配置文件那时调用的

使用bean的 scope 属性来配置bean的作用域(作用范围):	
singleton:默认值,spring容器初始时就会创建bean实例,在整个的生命周期内之创建一个bean(单例).
prototype:原型的.容器初始化时不会创建实例.每次请求时创建一个新的bean实例.(不是单例)
另:还有其它两个参数值request（一次请求）,session（一次会话） 很少用
<bean scope="prototype" name="car2"  class="com.parent.Car"></bean>
-------------------------------------
读取配置属性文件,提供了xml和注解两种方式(常用)::

配置属性文件位置 <context:property-placeholder location="classpath:db.properties"/>
通过$(key),就可以得到值

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd">

	<!--导入外部属性文件 2.5版本以前方式看PPt  -->
	<context:property-placeholder location="classpath:c3p0.properties"/>
		
	<bean name="c3p0" class="com.mchange.v2.c3p0.ComboPooledDataSource">
		<!-- 通过value属性值,得到value值 -->
		<property name="user" value="${user}"></property>
		<property name="password" value="${password}"></property>
		<property name="driverClass" value="${driverClass}"></property>
		<property name="jdbcUrl" value="${jdbcUrl}"></property>
	</bean>
</beans>

还可以通过注解的方式(等同于上面xml配置的方式,常用;):

@Configuration//相当于这个类当做xml配置文件
@ImportResource("classpath:/com/dataBase.properties")//引用配置文件
public class Appconfig{	

	//使用@Value注解读取配置文件的值(上面xml也是通过value属性来读取的值)
	@Value("${jdbc.url}")
	private String url;
	//这里如果就些userName作为键,会取到当前用户登录的名字,所以我们会加一个jdbc.userName
	@Value("${jdbc.userName}")
	private String userName;
	@Value("${jdbc.password}")
	private String password;	
}
---------------------------------------------
//结合spring源码告诉你bean的初始化过程
http://www.cnblogs.com/digdeep/p/4518571.html
https://www.iteye.com/blog/uule-2094609
精华中的精华


spring容器接管了bean的实例化,通过依赖注入达到了松耦合的效果,同时也提供了各种的扩展接口，
在bean的生命周期的各个阶段可以插入我们需要的业务逻辑(意思动态时间点让我们扩展功能)：

启动阶段
1,BeanFactoryPostProcessor.postProcessBeanFactory()(比如替换配置文件的属性值占位符)
实例化阶段
初始化时：

属性注入（setter）
BeanNameAware.setBeanName() 
BeanFactoryAware.setBeanFactory() 
ApplicationContextAware.setApplicationContext()


BeanPostProcessor.postProcessBeforeInitialization()
InitializingBean.afterPropertiesSet()
init-method属性

BeanPostProcessor.postProcessAfterInitialization()
DiposibleBean.destory() 
destroy-method属性

在github上springboot-template项目中有bean加载流程例子;
-----------------------------------------------
后置Bean (我在pojo类上测试了,但没看见效果,因为我没在xml中配置)

作用:在init()前后做一些想做的动作

1,自定义类实现 BeanPostProcessor 接口

public class MyBeanPostProcessor implements BeanPostProcessor {
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
			System.out.println("Before" + bean +"-----" + beanName);	
		return bean;
	}	
	
	/**
	 * bean : bean 本身对象  == class="com.cycle.Car" 
	 * beanName : bean id == name="beanPostProcess"
	 * 返回值: 实际返回给用户的bean ,注意着两个方法我们都可以修改这个Bean ,这就是这个后置bean存在的意义
	 */
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("After" + bean +"-----" + beanName);	
		/**
		 * 默认是配置文件中所有的bean 都会过后置bean ,所以我们会在里面进行判断
		 * beanName.equals("beanPost") 然后在做改变或替换bean 然后返回这个修改后的bean
		 */	
		if ("beanPostProcess".equals(beanName)){
			Car car = new Car();
			car.setBrand("Bean偷梁换柱成功..");
			return car;		
		}
		return bean;
	}
}

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- 配置bean的后置处理器:不需要id ,IOC容器自动识别BeanPostProcessor -->
	<bean class="com.cycle.MyBeanPostProcessor"></bean>

	<bean name="beanPostProcess" class="com.cycle.Car" 
	    init-method="指定类中的方法名"//在类初始化的时候会调用一次,后面就不会调用了,我的思考:它晚于constructor,那我为什么还需要它
		destroy-method="指定类中的方法名">
		<property name="brand" value="Audi"></property>
	</bean>	
</beans>

@Test
public void test() {	
	ClassPathXmlApplicationContext cpac =new ClassPathXmlApplicationContext("cycle.xml");
	Car car = (Car) cpac.getBean("beanPostProcess");
	System.out.println(car);
	cpac.close();	
}

变为:在init 初始化的前后加入before 和after
1,最先还是构造函数
2,然后是对Bean的属性进行赋值,或其他Bean的引用
//加入before
3,调用Bean的初始化方法.
//加入After
4,Bean对象可以使用了
5,当容器调用关闭(close()函数)后,会调用destroy 

实际打印结果
constructor
setter
Before: Car [brand=Audi]-----beanPostProcess
init
After: Car [brand=Audi]-----beanPostProcess
constructor
setter
Car [brand=Bean偷梁换柱成功..]
destroy[?d?d??t] 
------------------------------------------------
IOC容器中Bean的生命周期(常用)

spring IOC容器管理Bean的生命周期,spring可以在每个Bean生命周期中执行定制任务
首先我们要在xml文件设置init 和destroy 
<bean id="car" class="com.spring.Car" init-method="指定类中的方法名" destroy-method="指定类中的方法名">
	<property name="brand" value="Audi"/>	
</bean>

默认生命周期:
1,最先还是构造函数
2,然后是对Bean的属性进行赋值,或其他Bean的引用
//上面2步其实就是加载配置文件时做的
3,调用Bean的初始化方法.(init)，Bean对象可以使用了
4,当容器调用关闭(close()函数)后,会调用(destroy) 
--------------------------------------------------
了解
在很多业务情况下可能我们都需要独立或全局的调用（作用不大）

Spring 全局init和destroy方法具体配置在application.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:aop="http://www.springframework.org/schema/aop" xmlns:tx="http://www.springframework.org/schema/tx"
	xmlns:util="http://www.springframework.org/schema/util" xmlns:cache="http://www.springframework.org/schema/cache"
	xmlns:task="http://www.springframework.org/schema/task" 	
	default-init-method="init" default-destroy-method="destroy"
</beans>

//任何一个被spring管理的类中写入下面2个方法(这是全局的)
//如果不想全局,可以在自己对一个独立的 bean进行配置init 和destroy 	

public void init(){
	System.out.println("init...................");
}

public void destroy(){
	System.out.println("destroy...................");
}
--------------------------------
另:独立的还可以实现2个接口达到和配置的一样的效果
@Controller
public class WeixinController implements InitializingBean,DisposableBean {
	
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");		
	}
	
}
//总结: 全局,独立Bean或实现接口3种方式都可以,如果3种同时使用:
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
1,现实的打印(找不到对应的init方法报错.)
2,全局的打印(全局的就算找不到对应的init也不会报错,因为它有默认的)
3,独立Bean不会执行(只会执行一个独立的)
----------------------------------------

在一个类的方法上注解:
@PostConstruct 相当于 init@PreDestroy 相当与 destroy
----------------------------------------------
@Resource 相当与 Autowired 推荐
下面是 JSR330 标准 ,需要用到javax.inject.jar这个包
@Inject 相当与 Autowired 推荐
@Named 相当与 Component (可以是类或成员变量)主要对名字有要求时使用
比如: 一个变量是一个接口,它同时有多个实现类,这里时我们就需要准确定位名字
---------------------------------------------------------------
---------------------------------------------------------------
配置Bean的方式:
1,前面都是基于全类名(反射) 
2,通过工厂方法 (分为静态工厂和实例工厂方法)
3,FactoryBean
------------------------------
先看静态工厂方法
通过静态工厂来配置bean,注意不是配置静态工厂方法实例,而是配置bean实例
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- 静态方法的创建Bean配置	
		class: 自定义的静态工厂全类名
		factory-method : 工厂中的静态静态方法
		constructor-arg :给静态方法传参数
	 -->	 
	<bean name="staticFactory" class="com.factory.StaticFatory" factory-method="getCar">
		<constructor-arg value="ford"></constructor-arg>
	</bean>
	
	<!-- 实例化得到bean分为两步:
		1,上配置自定义实例工厂
		2,在配置一个bean赋值参数和调用方法和指向这个bean
	 -->
	<bean name="instancespring" class="com.factory.InstancespringBean"></bean>
	
	<bean name="instanceCar" factory-bean="instancespring" factory-method="getCar">
		<constructor-arg value="audi"></constructor-arg>	
	</bean>
</beans>
------------------------------------------------
通过FactoryBean 来配置Bean的实例(常用)

首先要写一个类 实现 FactoryBean接口
public class MyFactory implements FactoryBean<Car> {
	private String brand;
	public void setBrand(String brand) {
		this.brand = brand;
	}
	@Override
	public Car getObject() throws Exception {	
		return new Car(brand,555555);
	}
	@Override
	public Class<?> getObjectType() {
		return null;
	}
	@Override
	public boolean isSingleton() {	
		return true;
	}
}

<!-- 
	通过实现接口FactoryBean 来配置Bean的实例
	class :指向 FactoryBean 的全类名
	property : 配置 FactoryBean的属性
	但实际返回的实例是 getObject() 返回的
 -->
<bean name="factoryBean" class="com.factory.MyFactory">
	<property name="brand" value="BMW"></property>
</bean>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
上面都是通过xml文件配置的.下面我们使用注解的方式来配置IOC容器
要使用注解要引入jar包:
1,%spring_home%\lib\j2ee\common-annotations.jar.
而且需要在配置文件中加入<context:annotation-config/>的命名空间,
如果引入了<context:component-scan>可以不需要这个
2,引入Spring的头文件
3,在类上@Controller

源码在spring1 工程下的annotation.xml
注解方式更为简洁,不需要配置每个类都要配置Bean

特定组件包括:
@component 基本注解,标识了一个受spring管理的组件
@Repository :标识持久层组件
@Service :标识服务层组件
@Controller :标识表现成组件

首先我们导入声明context 

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd">
	
	<!-- 指定spring Ioc 容器需要扫描的包 
		resource-pattern="repository/*.class" :只扫描这个包下面的类	
		<context:component-scan base-package="com.annotation"
		resource-pattern="repository/*.class"></context:component-scan>
	-->
	 <!-- 
		context:exclude-filter:排除那些
		context:include-filter:包含哪些,但需要设置 use-default-filters="false"
		type="assignable" 这个设置后就用设置 全类名和 spring 4个注解无关
	 -->	 
	<context:component-scan base-package="com.annotation" use-default-filters="false">
		<context:include-filter type="assignable" expression="com.annotation.repository.UserRepository"/>			
	</context:component-scan>	 	
</beans>
具体看ppt
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
@Autowired 注解用于自动配置Bean比如为属性赋值 ,没有对应的bean抛出异常
@Autowired(required=false) 没有对应的bean,返回null.

有时一个接口下有多个实现类,默认会按SetXXX名字比对,如果同时2个能匹配上,
会抛出异常,这时我们可能会使用到下面这个注解

@Qualifier("value值"):指定装配那个一个
-------------------------------------------------------
默认情况下的容器启动时会初始化Bean.但可以通过添加<bean>元素中的lazy-init="true"属性来延迟初始化Bean.
这样将会在第一次获取Bean的时候才初始化Bean

+++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++
AOP
Aspect Oriented programming 的缩写:面向切面编程
通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术
主要功能是 : 日记记录,性能统计,安全控制,事务处理,异常处理等等;

功能效果有点像init或destroy方法.只是我们定义了更细的规则才会执行我们配置的方法.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
如:只有在我们申明的切入点上才会有效 : 只有在异常后我们才会调用方法,只有在方法之后,方法之前等等
*************************************************************
AOP这个东西很常用，可以大量的减少代码量，减轻加入新的业务需求的难度；


如何使用,这是最关心的?
@Component
@Aspect//使用 AspectJ,只需在一个普通类上加一个注解即可
public class LoggingAspect {
	
	@Before("execution(* com.spring.aop.impl.arihmeticCalculator.*(*,*))")//aspectJ的表达式
	public void beforeMethod(JoinPoint joinPoint){
		//记录日志,安全控制,事务处理,异常处理等....	
	}
}


//使用方法后面有写

//AOP就是这样.已经学完了.已经帮我做到了我们需要的干的事情了
*************************************************************
Spring Aop 没有 Aspectj强大,也没有它全面,所以

我们学习的是AspectJ：Java 社区里最完整最流行的 AOP 框架.
( aspectj 更好的封装了动态代理,且编程更为简单)
我们用spring实现的事务,事务不是硬编码,而是通过 spring aop完成的

AspectJ 支持 5 种类型的通知注解: 

@Before: 前置通知, 在方法执行之前执行
@After: 后置通知, 在方法执行之后执行 (无论发生异常都会执行,不能得到返回值)
@AfterRetruning: 返回通知, 在方法返回结果之后执行
@AfterThrowing: 异常通知, 在方法抛出异常之后
@Around: 环绕通知, 围绕着方法执行

切面开发流程:

1,加入jar包
com.springsource.net.sf.cglib-2.2.0.jar
com.springsource.org.aopalliance-1.0.0.jar
com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
commons-logging-1.1.1.jar
spring-aop-4.0.0.RELEASE.jar
spring-aspects-4.0.0.RELEASE.jar
spring-beans-4.0.0.RELEASE.jar
spring-context-4.0.0.RELEASE.jar
spring-core-4.0.0.RELEASE.jar
spring-expression-4.0.0.RELEASE.jar

2,在配置文件中加入aop的命名空间
3,基于注解的方式:
<!-- 扫描那些包 -->
<context:component-scan base-package="com.spring.aop.impl"/>

<!-- 使用Aspectj注解,作用:自动为匹配的类生成代理对象 -->
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
3.2 ,把在实现接口类中加入注解,让IOC管理,如:Component
4,把横切关注点的代码抽象到切面的类中
4.1,切面首先加入IOC中的bean,如:@Component注解
4.2 切面还需要加入@Aspect注解
5, 在类中声明各种通知(有5种):
5.1 ,声明一个方法在方法头加入通知
5.2 ,如果想看见很多细节我们可以使用Joinpoint

@Before("execution(* com.spring.aop.impl.arihmeticCalculator.*(*,*))")//aspectJ的表达式
//JoinPoint 参数可以让我们得到很多连接细节()具体看ppt
public void beforeMethod(JoinPoint joinPoint){
	
}

多个@pointcut 注解的方法可以 使用 && 或 || 联合使用让功能增强
--------------------------------------------------------------	
源码spring-2 工程下的com.aop1包
package com.spring.aop.impl;
import java.util.Arrays;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component//首先加入IOC容器中,然后声明切面
@Aspect//把这个类声明为一个切面
public class LoggingAspect {
	
	//任意返回值,任何类,任何方法,任何参数类型
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//@Before("execution(* com.aop1.*.*(*, *))")
	//前置通知:声明在哪个目标方法开始之前执行
	@Before("execution(* com.spring.aop.impl.arihmeticCalculator.*(*,*))")//aspectJ的表达式	
	public void beforeMethod(JoinPoint joinPoint){//JoinPoint 参数可以让我们得到很多连接细节()具体看ppt
		//加入方法名
		String methodName = joinPoint.getSignature().getName();
		//得到参数
		List<Object> args=Arrays.asList(joinPoint.getArgs());
		System.out.println("before--"+"method--"+methodName+"--参数--"+args);	
	}
		
	//后置通知:声明在哪个目标方法之后执行
	//注意:1,结果就算出异常也会执行;2,在后置通知中还不能访问目标方法执行的结果
	@After("execution(* com.spring.aop.impl.arihmeticCalculator.*(*,*))")	
	public void afterMethod(JoinPoint joinPoint){//JoinPoint 参数可以让我们得到很多连接细节()具体看ppt
		//加入方法名
		String methodName = joinPoint.getSignature().getName();		
		System.out.println("after--"+"method--"+methodName);
	}	
}



当同时有多个切面通知时,我们需要设置优先级
@Order(1) 可以定义多个切面的优先级,值越小优先级却高
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


定义一个方法,用于声明切入点表达式,一般该方法中不需要添入其他代码
(作用就是方便修改 Aspectj 表达式,相当于成了一个变量,下面调用这个变量)

@Pointcut ("execution(public int com.spring.aop.arithmeticCalculator.*(..)))")
public void declareJoinPointExpression(){}


假如不在一个类: 类名.declareJoinPointExpression; 
假如不在一个包下在加: 包名.类名.declareJoinPointExpression;


上面都是基于注解的方式配置的AOP(推荐)
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
xml配置文件方式来 实现AOP

源码spring-2 工程下 com.atguigu.spring.aop.xml包下


<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.0.xsd">

	<!-- 配置 bean -->
	<bean id="arithmeticCalculator" class="com.atguigu.spring.aop.xml.ArithmeticCalculatorImpl"></bean>

	<!-- 配置切面的 bean. -->
	<bean id="loggingAspect" class="com.atguigu.spring.aop.xml.LoggingAspect"></bean>

	<bean id="vlidationAspect" class="com.atguigu.spring.aop.xml.VlidationAspect"></bean>


	<!-- 配置 AOP -->
	<aop:config>
		<!-- 配置切点表达式:告诉程序我们要在那些地方使用下面的通知,还可以直接配置到aspect内部 -->
		<aop:pointcut expression="execution(* com.atguigu.spring.aop.xml.ArithmeticCalculator.*(int, int))" id="pointcut"/>
			
			
		<!-- 配置切面及通知 -->
		<aop:aspect ref="loggingAspect" order="2">
			<!-- 这里配置一个前置通知 执行在ref(loggingAspect)类 的方法(beforeMethod)上.-->
			<aop:before method="beforeMethod" pointcut-ref="pointcut"/>
			<!-- finally知也叫,都会执行的通知-->
			<aop:after method="afterMethod" pointcut-ref="pointcut"/>
			<!--只有在代码抛出异常才会执行-->
			<aop:after-throwing method="afterThrowing" pointcut-ref="pointcut" throwing="e"/>
			<!--正常返回的通知-->
			<aop:after-returning method="afterReturning" pointcut-ref="pointcut" returning="result"/>
			
			<!--  环绕通知 
			<aop:around method="aroundMethod" pointcut-ref="pointcut"/>
			-->	
		</aop:aspect>	
		
		
		<!-- 第二个切面及通知 -->
		<aop:aspect ref="vlidationAspect" order="1">
			<aop:before method="validateArgs" pointcut-ref="pointcut"/>
		</aop:aspect>
		
	</aop:config>
	
</beans>

-------------------------------------------------
Spring的Aop(面向切面编程)使用的jdk动态代理或CGlib实现(前面反射有源码)

Aop当中的概念:
1,切入点Pointcut : 在哪些类的哪些方法上切
2,通知Advice(增强) : 在方法的什么时机做什么
3,切面Aspect : 切入点 + 通知 (什么时间什么地点干什么事)
4,织入Weaving : 把切面加入到对象,并创建出代理对象的过程 (Spring干的事)

-------------------------------------------------
过滤器，拦截器，aop同时使用执行顺序
精华（以打不开页面）
https://blog.csdn.net/w1219401160/article/details/81101641

执行顺序并不是想象中那样,进链接5分钟看完.有用
++++++++++++++++++++++++++++++++++++++++++++++++++++
实际开发我们怎么使用Template?
直接做成成员变量,加上自动装配.
举例(配置文件):
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
    <!--阿里巴巴连接池只需要3个核心参数-->
    <bean class="com.alibaba.druid.pool.DruidDataSource" id="dataSource">
        <property name="url" value="jdbc:mysql://localhost:3306/shiro" />
        <property name="username" value="root" />
        <property name="password" value="hjf,.123" />
    </bean>
    <!--JdbcTemplate只要一个dataSource-->
    <bean class="org.springframework.jdbc.core.JdbcTemplate" id="jdbcTemplate">
        <property name="dataSource" ref="dataSource" />
    </bean>  
</beans>
-----------
@Repository
public class EmployeeDao {	
	@Autowired
	private JdbcTemplate jdbcTemplate;//只要一个dataSource就可以使用jdbcTemplate
	
	public Employee get(Integer id){
		String sql = "SELECT id, last_name lastName, email FROM employees WHERE id = ?";
		RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, id);	
		return employee;
	}
}
------------------------------------------------------
事务和锁引发的思考.

事务为保证一个操作的原子性而设置的,一个事务必定包含多个操作,多个操作再逻辑上要保证完整一致,
如果中间只要有一个操作失败,那么事务必须回滚,必须回到整个操作的初始状态

同步是为了解决多线程使用过程中,使用相同资源导致数据不一致而引入的,使用了同步机制,那么多个线程在访问同一资源时,
必须等到另一个线程使用完毕,释放了这个资源,其它的线程才有机会使用.

---------------------------------------------------------------
精华
基于注解的Transactional的类

package com.bookShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService{
	
	@Autowired
	private BookShopDao bookShopDao;	


	@Transactional(
			propagation=Propagation.REQUIRES_NEW,//指定事务的传播行为
			isolation= Isolation.READ_COMMITTED,//指定事务的隔离级别
			
			readOnly=false,//设置为只读,有些数据设置只读可以提高服务器的效率
			timeout=2,//指定强制回滚之前事务可以占用的时间
			rollbackFor=Exception.class,//指定回滚的异常
			noRollbackFor=Exception.class),//默认情况下spring的声明事务对所有的运行异常都会进行回滚;可以设置不回滚的
			)
	@Override
	public void bookService(String username, String isbn) {
		try {
			//睡3秒
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		bookShopDao.updateBookStock(isbn);	
		bookShopDao.updateUserAccount(username, price);		
	}
}




Spring共支持7种传播行为Propagation传播性取值：

required(默认值）:在有事务状态下执行；如当前没有事务,则创建新的事务；
requires_new:创建新的事务并执行（原来的挂起）

supports(支持):如当前有事务,则在事务状态下执行；如果当前没有,在无事务状态下执行；
not_supports:在无事务状态下执行（如果当前已有事务,则挂起）

mandatory(强制):必须在有事务如果没有抛出异常IllegalTransactionStateException；
never:在无事务状态下执行；如果当前有事务也抛出异常IllegalTransactionStateException。

nested (嵌套):如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则创建一个事务
嵌套事务一个非常重要的概念就是内层事务依赖于外层事务。外层事务失败时，会回滚内层事务所做的动作。而内层事务操作失败并不会引起外层事务的回滚
https://blog.csdn.net/weixin_39625809/article/details/80707695
----------------------------------------

isolation 5种事务隔离级别(和数据库有关系):
1 ISOLATION_DEFAULT     这是个 PlatfromTransactionManager 默认的隔离级别，使用数据库默认的事务隔离级别。另外四个与 JDBC 的隔离级别相对应。
2 ISOLATION_READ_UNCOMMITTED     这是事务最低的隔离级别，它充许另外一个事务可以看到这个事务未提交的数据。这种隔离级别会产生脏读，不可重复读和幻像读。
3 ISOLATION_READ_COMMITTED     保证一个事务修改的数据提交后才能被另外一个事务读取。另外一个事务不能读取该事务未提交的数据。
4 ISOLATION_REPEATABLE_READ     这种事务隔离级别可以防止脏读，不可重复读。但是可能出现幻像读。
5 ISOLATION_SERIALIZABLE     这是花费最高代价但是最可靠的事务隔离级别。事务被处理为顺序执行。


spring的隔离级别一定是要数据库锁机制支持的，
比如上面第三点，肯定是使用了数据库的行级排他锁，别人都看不到了。
------------------------------------------------
spring 中的事务
基于注解配置方式的transaction 
源码spring2工程下的 template.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.0.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.0.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd">
	
	<!-- 设置注解需要扫描的包 -->
	<context:component-scan base-package="com.bookShop"></context:component-scan>	
	<!-- 导入资源文件 -->
	<context:property-placeholder location="classpath:db.properties"/>
	
	<!-- 配置c3p0数据源 -->
	<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
		<property name="user" value="${user}"></property>
		<property name="password" value="${password}"></property>
		<property name="driverClass" value="${driverClass}"></property>
		<property name="jdbcUrl" value="${jdbcUrl}"></property>
		<property name="initialPoolSize" value="${initialPoolSize}"></property>
		<property name="maxPoolSize" value="${maxPoolSize}"></property>
	</bean>
	
	
	<!-- 配置spring的 jdbc的模板  -->
	<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
		<!-- 配置spring template的模板基本数据源 -->
		<property name="dataSource" ref="dataSource"></property>
	
	</bean>
	
	<!-- 配置 NamedParameterJdbcTemplate, 该配置是上面一个的升级版,
	对象可以使用具名参数, 其没有无参数的构造器, 所以必须为其构造器指定参数,参数就是数据源
	<bean id ="namedParameterJdbcTemplate" 
		class="org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate">		
		<constructor-arg ref="dataSource"></constructor-arg>
	</bean>
	 -->
	
	<!-- 如果一个类要加入事物 
		1,配置一个事务管理器 DataSourceTransactionManager
		2,启动注解事务管理tx:annotation-driven 
	-->
	<bean id="transactionManager" 
		class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"></property>
	</bean>
	
	<tx:annotation-driven  transaction-manager="transactionManager"/>	
</beans>

-------------------------------------------------------------------
-------------------------------------------------------------------

@Resource标签:
1,@Resource标签是JavaEE规范的标签
2,@Resource标签也可以用于字段或则setter方法
3,也可以使用@Resource标签注入一些Spring内置的重要对象 如ApplicationContext
4,@Resource标签必须要求有匹配的对象;不能设置required = false
5,<context:annotation-config>既引入了@Autowired 的解析器也引入了@Resource标签的解析器;
如果引入了<context:component-scan>可以不需要这个

6,@Resource标签找bean的方式:
①:首先按照名字去找,如果找到就使用setter或则字段注入
②:如果名字找不到,在按照类型去找,如果找到多个匹配类型会报错
③:如果指定的name就只能按照name去找.就不会再按类型去找.
-----------------------
@Autowired 找bean的方式:
1,首先按照依赖对象的类型找:如果找到就用setter或则是字段直接注入
2,如果Spring上下文中找到多个匹配的类型,再按照名字去找,如果没有匹配,报错
3,可以通过再添加使用@Qualifier("id名")标签规定对象按照bean的id + 类型去找;
----------------------------------
@Component 用来标注Bean的注解,比较中立的Bean使用

@Component默认情况下直接使用类名字首字母小写作为Bean的名字
如果要修改bean的名称,可以使用value属性来重新定义bean的名称

@Component("重新定义Bean的名字")
@Scope("prototype")
public class OtherBean{		
}

通过注解的方法注入默认也是单例的,可以通过@Scope("prototype")来修改为不是单例的.
------------------------------------------

@Service 用于标注服务层
@Controller 用于标注控制层
@Repository 用于表示Dao层
@Component 当都不属于上面几种情况下就可以用它

-------------------------------------------------
注解的初始化和销毁方法(javaee的规范)
@PostConstruct
public void init()
相当于<bean destory-method=“init”/>

@PreDestroy
public void destroy()
相当于<bean destroy-method="destory"/>
--------------------------------------------------
定时器主要分3种:
1,jdk的Timer（单线程执行，如果中途异常无法重新开始，不用）
2,spring的Scheduled
不是太复杂时使用，默认单线程，中途异常可以继续，支持多线程加这个注解@Async，实现SchedulingConfigurer 接口可以配置线程数量）
3,quartz
另springboot整合了quartz,使用更加简单,github上的SpringBootHello项目有例子
-----------------------------------

Spring3。0后的注解定时器（算第2种）
首先在applicationContext.xml中增加 

文件头中增加
一:
 xmlns:task="http://www.springframework.org/schema/task" 
 http://www.springframework.org/schema/task
 http://www.springframework.org/schema/task/spring-task.xsd"

二:
<!-- 定义使用注解自动扫描的包 -->
<context:component-scan base-package="xxx" /> 定时器必须属于扫描的包中

<!-- 打开定时器开关,注意这里已task开发的-->
<task:annotation-driven/>

三:
//不可以是在Controller层
@Component  
public class TestJob {
    @Scheduled(fixedDelay = 5000) 
    public void test(){
        System.out.println("job 开始执行"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    } 
}

---------------------------------
springboot的schedule和quartz到底怎么选以及如何支持并发和避坑
https://www.jianshu.com/p/61e3abc22fbd
---------------------------------
复杂定时器
quartz

http://www.yiibai.com/quartz/
http://www.quartz-scheduler.org/documentation/quartz-2.2.x/examples/Example6.html
另外还是结合官网操作(还在不断的更新中),提供10几种例子;百度云有源码;

为什么需要quartz?
想每月25号，信用卡自动还款
想每年4月1日自己给当年暗恋女神发一封匿名贺卡
想每隔1小时，备份一下自己的爱情动作片 学习笔记到云盘
或则更为复杂的触发



cron 表达式
 格式 : 秒 分 小时 日 月 周 年
 秒 0-59 , - * / 
分 0-59 , - * / 
小时 0-23 , - * / 
日期 1-31 , - * ? / L W C 
月份 1-12 或者 JAN-DEC , - * / 
星期 1-7 或者 SUN-SAT , - * ? / L C # 
年（可选） 留空, 1970-2099 , - * /
逗号表示或的关系
-号表示between的关系
*号表示每(秒,分)的关系
?号 表示不关心,和*意思差不多
#号 表示第的意思
/ 用于递增触发,如在秒上面设置"5/15"表示从5秒开始,每增15秒触发
(5,20,35,50);在月字段上设置1/3 表示每月1号开始,每隔3天触发一次


例子:
0 15 10 ? * * 每天10点15分触发
0 0/5 14 * * ? 每天下午2点到2点59分(整点开始每隔5分钟触发)
0 15 10 ? * MON-FRI 从周一到周五每天上午10点15分触发
0 15 10 ? 6#3 每月的第三周的周五开始触发
0 15 10 ? 6L 2016-2017 从2016-2016-2017每月最后一周的周五10点15触发

另 :我们可以通过在线cron ,生成各种表达式;
--------------------------------------
1. Spring 整合 Hibernate 整合什么 ?
源码spring-4工程下
1). 有 IOC 容器来管理 Hibernate 的 SessionFactory
2). 让 Hibernate 使用上 Spring 的声明式事务

2. 整合步骤:
1). 加入 hibernate
	①. jar 包
	②. 添加 hibernate 的配置文件: hibernate.cfg.xml
	③. 编写了持久化类对应的 .hbm.xml 文件. 
2). 加入 Spring
	①. jar 包
	②. 加入 Spring 的配置文件

----------------------------------------
1. Spring 到底如何在 WEB 应用中使用 ?(必须会)
源码 spring5工程下 index.jsp 
①. 需要额外加入的 jar 包:
spring-web-4.0.0.RELEASE.jar
spring-webmvc-4.0.0.RELEASE.jar
②. Spring 的配置文件, 和非 WEB 环境没有什么不同
③. 需要在 web.xml 文件中加入如下配置:
<!-- 配置 Spring 配置文件的名称和位置 -->
<context-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>classpath:applicationContext.xml</param-value>
</context-param>

<!-- 启动 IOC 容器的 ServletContextListener -->
<listener>
	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
------------------------------------------
1, src路径下的文件在编译后会放到WEB-INF/clases路径下吧。默认的classpath是在这里。直接放到WEB-INF下的话,是不在classpath下的。用ClassPathXmlApplicationContext当然获取
2,如果单元测试的话,可以在启动或者运行的选项里指定classpath的路径的。用maven构建项目时候resource目录就是默认的classpath
3,classPath即为java文件编译之后的class文件的编译目录一般为web-inf/classes,src下的xml在编译时也会复制到classPath下
//读取classPath下的spring.xml配置文件
(1)ApplicationContext ctx = new ClassPathXmlApplicationContext("xxxx.xml");
//读取WEB-INF 下的spring.xml文件.
(2)ApplicationContext ctx = new FileSystemXmlApplicationContext("WebRoot/WEB-INF/xxxx.xml");

classpath 和 classpath* 区别:
classpath:只会到你的class路径中查找找文件;
classpath*:不仅包含class路径,还包括jar文件中(class路径)进行查找.


++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
SPRINGMVC

springMVC的Hello

1,加入jar包
2,配置 web.xml 中dispatcherServlet,主要设置就是设置spring配置文件的路径

<servlet>
	<servlet-name>SpringMVC</servlet-name>
	
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<!-- 局部初始化参数,当web容器加载时会加载springMvc的配置文件(spring-servlet.xml) -->
	
	<init-param> 
		 <param-name>contextConfigLocation</param-name>
		 <param-value>classpath:spring-servlet.xml</param-value> 
	 </init-param>	
	 
	 <!-- 创建的时机 0为最快 -->	 
	<load-on-startup>1</load-on-startup>	
</servlet>	

<servlet-mapping>
	<servlet-name>SpringMVC</servlet-name>
	<!-- dispatcherServlet是前端控制器,这里配置需要拦截的url
	被拦截的url会到controller找requestMapping中是否有访问的url匹配   -->
	<url-pattern>/</url-pattern>
</servlet-mapping>


3,springmvc 配置文件主要就是配置视图解析器
<!-- 只配置controller层,其他的排除-->
<context:component-scan base-package="com.springmvc"/>

<!-- 配置视图解析器: 如何把handler 方法返回值解析为实际的物理视图 -->
<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<!-- 返回视图的前缀 -->
	<property name="prefix" value="WEB-INF/views/"></property>
	<!-- 返回视图的后缀 -->
	<property name="suffix" value=".jsp"></property>
</bean>


----------------------------------------
可以使用了一个被@Controller注解的类
@Controller
public class HelloWorld {	
	@RequestMapping("/helloworld")
	public String index(){	
		System.out.println("HelloWorld类的index方法被调用");
		return "hello";
	}
}
springMVC 的运行流程(精华,必须会):
~~~~~~~~~~~~~~~~~~~~~~~
1,请求url会被DispatcherServlet拦截,因为我们一般都是配置拦截全部url(web.xml配置文件中配置)
2,然后去查找所有的@Controller类的方法的有没有对应的url名字 @RequestMapping("/helloworld")
3,有就执行方法体,后返回值会通过视图解析器解析为实际的物理视图InternalResourceViewResolver
4,根据配置文件prefix + 方法返回字符串 + suffix 去找对应的jsp页面
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/**
 * Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配, 自动为该对象填充属性值.
 * 支持级联属性 : 在java实体类没有变化 ,只是前端页面name 名字需要是.的方式定义name (很重要对类中实体进行赋值	
	如:dept.deptId等(dept指向一个类,这里是User类中的一个属性)
 */
@RequestMapping("/testPojo")
public String testPojo(User user) {
	System.out.println("testPojo: " + user);
	return SUCCESS;
}
------------------------------------------
/**
 * 可以使用 Serlvet 原生的 API 作为目标方法的参数 具体支持以下类型
 * HttpServletRequest 
 * HttpServletResponse 
 * HttpSession
 * java.security.Principal 
 * Locale 
   InputStream 
 * OutputStream 
 * Reader 
 * Writer
 */
@RequestMapping("/testServletAPI")
public void testServletAPI(HttpServletRequest request,
		HttpServletResponse response, Writer out) throws IOException {
	System.out.println("testServletAPI, " + request + ", " + response);
	out.write("hello springmvc");
//		return SUCCESS;
}
-----------------------------------
ModelAndView 作用: 返回页面数据(如数据库的数据)
					~~~~~~~~~~~~~~~~~~
目标方法的返回值可以是 ModelAndView 类型. 其中可以包含视图 和 数据
//其实查看底层源码可以看见:
SpringMVC 会把 ModelAndView 的 model 中数据放入到 request 域对象中. 
request.setAttribute("","")这样的方式赋值的

@RequestMapping("/testModelAndView")
public ModelAndView testModelAndView(){
	String viewName = SUCCESS;
	ModelAndView modelAndView = new ModelAndView(viewName);	
	//添加模型数据到 ModelAndView 中.
	modelAndView.addObject("time", new Date());	
	return modelAndView;
}
--------------------------------------------------------
Map 类型(实际上也可以是 Model 类型或 ModelMap 类型)的参数 :
作用也是向页面传递参数
@RequestMapping("/testMap")
public String testMap(Map<String, Object> map){	
	System.out.println(map.getClass().getName()); 
	map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
	return SUCCESS;
}
---------------------------------------------------------
(了解,开发没用过)
ModelAndView ,Map(或不常用的Model和ModelMap)默认放在request域中,如果想放到session域中.
我们可以使用@sessionAttributes注解,这个注解只能使用在类上request和session两个域中都会放入 
@SessionAttributes(value={"user"},types={string.class})
types:这样一修饰,只要是字符串(值)都会放到session中

/**
 * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(使用的是 value 属性值),
 * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(使用的是types属性值)
 * 注意: 该注解只能放在类的上面. 而不能修饰放方法. 
 */
@RequestMapping("/testSessionAttributes")
public String testSessionAttributes(Map<String, Object> map){
	User user = new User("Tom", "123456", "tom@atguigu.com", 15);
	map.put("user", user);
	map.put("school", "atguigu");
	return SUCCESS;
}
---------------------------------------------------------
//精华
@ModelAttribute//注解的方法,会在每个方法执行之前被SpringMVC调用,常用
public void getUser(@RequestParam(value="id",required=false) Integer id, 
		Map<String, Object> map){
	if(id != null){                                 
		//模拟从数据库中获取对象
		User user = new User(1, "Tom", "123456", "tom@atguigu.com", 12);
		System.out.println("从数据库中获取一个对象: " + user);	
		map.put("user", user);
	}
}
---------------------------------------------------------
@PathVariable (url传参且不写key使用)和 @Requestparam  @RequestHader 等都可以用于接受参数
返回参数可以ModelAndView,Map<String ,Object> ,@SessionAttributes ,@Model
------------------------------------------
精华:
如果我们有的页面不想经过handler 那么就如下配置

<!-- 在实际开发中通常都需配置(不然报错) mvc:annotation-driven 标签 -->
<mvc:annotation-driven></mvc:annotation-driven>

1.使用tomcat的默认的Servlet解决
     在web.xml中配置映射文件，<url-pattern>标签中为静态资源的类型：

<servlet-mapping>
	<servlet-name>default</servlet-name>
	<url-pattern>*.jpg</url-pattern>
</servlet-mapping>
<servlet-mapping>
	<servlet-name>default</servlet-name>
	<url-pattern>*.png</url-pattern>
</servlet-mapping> 

2.使用MVC的default-Servlet-handler解决
    在springmvc.xml配置文件中进行配置：

<mvc:default-servlet-handler />
3.使用MVC的resources解决：
   在springmvc.xml配置文件中进行配置：
   location:资源位置  mapping：表示对该资源的请求(由处理器ResourceHttpRequestHandler)

<mvc:resources location="/image/" mapping="/image/**"/>
------------------------

转发 与 重定向
return "forward:index.jsp"; //转发 
return "forward:user.do?method=reg5"; //转发
return new ModelAndView("/toList");//转发
return "redirect:user.do?method=reg5"; //重定向
return "redirect:http://www.baidu.com"; //重定向
return new ModelAndView("redirect:/toList"); //重定向

重定向都有redirect关键字
----------------------------------------------------------
如何自定义springMVC的转换器(了解)
源码在springMVC-crud工程下views包下input.jsp中

自定义类实现Converter接口

@Component
public class EmployeeConverter implements  Converter<原类型,目标类型>{
	//具体怎么将字符串转为Employee 对象,代码在这方法体中
}

<mvc:annotation-driven conversion-service="conversionService"/>
<!-- 自定义转换器的配置 FormattingConversionServiceFactoryBean 这个类更强大-->
<bean id="conversionService" 
class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
	<property name="converters">
		<set>
			<!-- 自定义转换器类名第一个字母小写 -->
			<ref bean="employeeConverter"/>	
		</set>
	</property>
</bean>		
——————————————————————
springMVC 中如何使用JSON

其内部原理就是HttpMessageConverter这个类实现的:主要就是对HttpInputMessage,
HttpOutputMessage输入输出的中间层的转换.


返回对象只需添加一个ResponseBody的注解就可以转为json
@ResponseBody
@RequestMapping("/testJson")
public Collection testJson(){
	System.out.println("JSON Hello World! ");
	return employeeDao.getAll();
}

<mvc:annotation-driven>//需要配置这个
注解原来我们一般都是把值放入到map中,然后在页面取出,但这样需要有页面刷新才可以,
现在我们使用
@ResponseBody 注解后无需刷新.
function requestJson(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath}/requestJson.action'
		contextType:'application/json;charset=utf-8', //默认key value 哪种不需要这行
		data:{"name":"手机","price","999"},
		success:function(data){
			alert(data);//可能只能在页面跟踪可以看见.
		}	
	});	
}


-------------------------------------
springMVC 下载（推荐）

@RequestMapping("/testResponseEntity")
public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException{
	byte [] body = null;
	ServletContext servletContext = session.getServletContext();
	InputStream in = servletContext.getResourceAsStream("/files/abc.txt");
	body = new byte[in.available()];
	in.read(body);
	HttpHeaders headers = new HttpHeaders();
	//文件内容通过附件方式处理,文件名叫abc.txt
	headers.add("Content-Disposition", "attachment;filename=abc.txt");	
	HttpStatus statusCode = HttpStatus.OK;
	//上面 操作只用为这准备3个参数(2进制数据流,头信息,返回状态值)
	ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(body, headers, statusCode);
	return response;
}
-------------------------------------------
文件上传步骤:
源码在springMVC-crud工程下index.jsp中

1,加入jar包 commons 和io包

2,在springMVC.xml文件中配置CommonsMultipartResolver

<!-- 配置上传文件需要的类  配置 MultipartResolver,不配id 就是不行,搞不懂 -->
<bean id="multipartResolver"
	class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
	<property name="defaultEncoding" value="UTF-8"></property>
	<property name="maxUploadSize" value="1024000"></property>	
</bean>	

3,页面
<form action="testFileUpload" method="post" enctype="multipart/form-data">
	file:<input type="file" name="file"/>
	desc:<input type="text" name="desc"/><br>	
	<input type="submit" value="submit"/>
</form>

//如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解  
//如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且还要指定@RequestParam注解  
//并且上传多个文件时,前台表单中的所有<input type="file"/>的name属性都应该是统一的值,
否则无法获取到所有上传的文件 
4,目标方法:
@RequestMapping("/testFileUpload")
	public String testFileUpload(@RequestParam("desc") String desc,@RequestParam("file") MultipartFile file) throws IllegalStateException, IOException{
		String sourceFilePath;		
		if(file != null){
			//得到原始的文件名__________
			String fileName = file.getOriginalFilename();				
			//取得文件名的后缀___________
			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
			//得到一个唯一值UUID
			String randomString = DataTool.getUUID();				
			SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");	
			String folder = df.format(new Date());						
			//sourceFilePath  =  年/月/日/ + UUID + 后缀的字符串______________________
			sourceFilePath = folder+ "/" + randomString + "." + suffix;		
			String path = StaticValue.FILE_UPLOAD_URL + sourceFilePath; 				
			File fileFolder = new File(path);//上传的资源保存的最后路径,封装为文件				
			if(!fileFolder.exists()){//文件或目录是否存在
				fileFolder.mkdirs();//创建目录,会自动创建没有的父目录
			} 				
			file.transferTo(fileFolder);//这句就是上传操作.				
			return sourceFilePath;//这个返回值 一般就会设置到类的图片指向属性中				
		}	
		return "这里提示错误";	
}	
++++++++++++++++++++++++++++++++++++++++++++++++++++++
关于国际化(了解):

源码在springMVC-crud工程下index.jsp中

1,在页面上能够根据浏览器语言设置 对页面进行本地化处理
2,可以在Bean 中获取国际化资源文件 locale 对应的消息
3,可以通过超链接切换 locale ,而不在依赖浏览器语言设置情况

解决:
1,使用JSTL 的 fmt 标签 <fmt:message key="i18n.user"></fmt:message><br>
2,在 Bean 中注入 ResourceBundleMessageSource 的式例,使用其对应的 getMessage 方法即可

@RequestMapping("/i18n")
public String i18n(Locale locale){
	System.out.println(locale);
	String val = messageSource.getMessage("i18n.user", null, locale);
	//System.out.println(val);	
	return "i18n";
}

3,配置LocalResolver 和 LocaleChangeInterceptor
页面
<a href="i18n?locale=en_US">英文</a><br>
<a href="i18n?locale=zh_CN">中文</a><br>

然后在springMVC.xml文件中配置


<!-- 配置国际化资源文件 -->
<bean id="messageSource"
	class="org.springframework.context.support.ResourceBundleMessageSource">
	<property name="basename" value="i18n"></property>
</bean>

<!-- 默认是在request中去取,不是在Session中去取,配置后才会-->
<bean id="localeResolver" class="org.springframework.web.servlet.i18n.SessionLocaleResolver"></bean>

<mvc:interceptors>	
	<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor"></bean>	
</mvc:interceptors>
---------------------------------------------------------------------------
/**
 * 根据本地输出对应的日期格式(动态国际化)
 */
@Test
public void dateFormatTest(){
	//Locale locale = Locale.US; //美国
	Locale locale = Locale.CHINA; //中国
	//获取 DateFormat 对象(下面的2个常量可以选择其他变换输出)
	DateFormat dateFormat = 
			DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);			
	String str = dateFormat.format(new Date());
	System.out.println(str); 		
}
-------------------------------------------------
也可以通过普通的httpServletRequst 来转换为上传的MultipartHttpServletRequest;
MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
MultipartFile file = multipartRequest.getFile("fileName");	


-------------------------------------------
精华
springMVC 拦截器 


1,一个普通类实现 HandlerInterceptor接口就可以成了一个拦截器
/**
	 * 该方法在目标方法之前被调用.
	 * 若返回值为 true, 则继续调用后续的拦截器和目标方法. 
	 * 若返回值为 false, 则不会再调用后续的拦截器和目标方法.  
	 * 可以考虑做身份权限(认证或授权). 日志, 事务等. 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("preHandle1");		
		//这里就是拦截器需要拦截的内容.开发中我就是要在这里编写代码
		return true;
	}

	/**
	 * 调用目标方法之后, 但渲染视图之前. 
	 * 将公共的模型数据在这里进行赋值,可以对请求域中的属性或视图做出修改. 
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle1");
	}

	/**
	 * 渲染视图之后被调用. 
		统一的释放资源 和 异常的处理 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion1");
	}
}

2,在springMVC.xml文件中配置一下:

<!-- 单个拦截器>
<mvc:interceptors>	
	<bean class="全类名"></bean>	
</mvc:interceptors>

第二种配置方式:

<!-- 这种属于全局拦截器,还有一种基于一个bean的(不推荐),多个拦截器按配置的先后顺序执行 -->
<mvc:interceptors>	
	<mvc:interceptor >
		<mvc:mapping path="/**"/>
		<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor"></bean>	
	</mvc:interceptor>
	
	<!-- 下面还可以继续配更多的拦截器 -->	
	<mvc:interceptor >
		<mvc:mapping path="/**"/>
		<bean class="org.springframework.web.servlet.i18n.LocaleChangeInterceptor2"></bean>	
	</mvc:interceptor>
</mvc:interceptors>	


多个拦截器的执行顺序(这个假设2个):

第一种: 两个拦截器都放行,执行结果:
prefix1
prefix2

pso2//业务接口
pso1//业务接口

after2
after1

说明:prefix 按配置顺序执行, 下面2个逆向执行

第二种: 第一个拦截放行,第二个不放行,执行结果:
prefix1
prefix2

after1

说明:第二个方法后面的不会执行,第一个Handler没有进入,但会执行after1,结论只要有一个拦截器不放行,就不会返回
进入handler,不会返回 ModelAndView


第三种: 两个拦截器都不放行,执行结果:
prefix1

说明:只会执行prefix .

小结:根据上面的测试,我们得到的结论是:

比如统一日志拦截器我们应该放在配置拦截器顺序的第一个位置,且 放行,在after中一定会打印日志消息

对于登录验证在日志后面,对于权限验证在登录后面.
+++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++
springMVC 处理异常流程

源码在springMVC-crud工程下index.jsp中

1,在@ExceptionHandler 方法的入参中可以加入Exception 类型的参数,只有符合该类型的异常才会进来

2,@ExceptionHandler 方法的入参中不能传入Map ,若希望异常信息传到页面上,
需要使用ModelAndView 作为返回值
 
//存在的意义就是异常处理和业务逻辑处理分离 
@ExceptionHandler 多个方法标记的异常有优先级问题: 根据类精确匹配 .


4,如果在当前Handler 中找不到@ExceptionHandler对应的异常,则去@ConterollerAdvice 标记的自定义
异常（推荐，统一一个类处理异常）类中查找 @ExceptionHandler 标记的方法来处理异常
----------------------------------

关于springMVC 的 异常进行统一处理:

/**
 * 功能描述:全局异常处理
 * 思路:不管是service,controller层都向外抛出异常,然后在统一一个类来处理（@ControllerAdvice被它标记的类）
 * 好处:1,代码减少判断减少;2,让代码可读取性变高;流程清晰且;且返回出前端的异常很清晰;3,日志可以在这里统一处理
 * 
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);

    //统一的异常处理
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
	
		//判断是否是我们的自定义的异常类
        if(e instanceof GirlException){
            GirlException girlException= (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.error("系统异常{}",e);
            return ResultUtil.error(-1, "未知错误");
        }
    }

}

/**
 * 自定义异常类,
 * 知识点: 在构造器中接受的是自定义的枚举类;
 * 因为 Exception参数只能接受一个
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

/**
 * 
 *自定义统一返回给前端的键值对;好处统一维护
 */
public enum ResultEnum {

    UNKOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "你可能在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),
    HIGHT_SCHOOL(102, "你可能在上大学");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
------------------------------------------------------
springMVC和Struts2 的区别:
1,springMVC 基于方法的开发,struts2 基于类的开发.
2 springMVC 将url 和controller方法映射.映射成功后springMVC生成一个Handler 对象 ,
对象中包含一个Method; 方法执行结束,形参数据销毁.
springMVC的Controller开发类似service开发.
3,springMVC可以进行单例开发,并且建议使用单利开发,struts2通过类的成员变量接收参数,无法使用单例.
4,经过实际测试,struts2速度慢,在与使用struts标签,如果使用struts建议使用jstl.
-----------------------------------------------------
DispatcherServlet 前端控制器 : 接收request,返回response
HandlerMapping 处理器映射器 : 根据url 查找Handler (可以通过xml和注解方式)
HandlerAdapter 处理器适配器 : 根据特定规则执行 Handler,编写 Handler 时需要按照 HandlerAdapter的要求去编写
Handler 处理器(后端控制器) : 需要程序员去编写,常用注解开发方式.
	Handler处理器执行后结果是ModelAndView ,具体开发时Handler 返回方法值类型包括 :ModelAndView,string
(逻辑视图名) void (通过Handler形参添加request和response,类型原始servlet开发方式,注意:可以通过指定
response相应结果类型实现JSON 数据输出)

View resolver 视图解析器 :根据逻辑视图名生成真正的视图 (在springMVC中使用View 对象表示)
View 视图:jsp 页面,仅是数据展示,没有业务逻辑.


requestMappingHandlerMapping 注解映射器 
requestMappingHandlerAdapter 注解适配器
使用<mvc:anntation-driven>代替上边处理器映射器和适配器配置.

@Controller 必须加,作用标示类是一个Handler处理器
@requestMapping 必须加3个作用:
1,对url和Handler的方法进行映射
2,可以窄化请求映射.添加在类上
3,可以限制http的请求方式
映射成功后,springMVC框架生成一个Handler对象,对象中包含一个映射成功的method
	
---------------------------------------------
Spring和SpringMVC 的父子容器关系

Spring是父容器,SpringMVC是子容器,子容器可以使用父容器的对象，但是父容器是不能使用子容器的对象的。注意，这里是对象。
归根结底也是由于2个容器的可见性问题导致

那么代码如何操作：
 
1,Spring容器配置,排除所有@controller的Bean

<context:component-scan base-package="com.fsnip.open">
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
 
2,SpringMVC容器配置,让其只包括@controller的Bean

<context:component-scan base-package="com.fsnip.open" use-default-filters="false">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller" />
</context:component-scan>


+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++
REST，即Representational State Transfer的缩写.我对这个词组的翻译是"表现层状态转化"。
如果一个架构符合REST原则，就称它为RESTful架构。

RESTful
一种软件架构风格，设计风格而不是标准，只是提供了一组设计原则和约束条件。
它主要用于客户端和服务器交互类的软件。基于这个风格设计的软件可以更简洁，更有层次，
更易于实现缓存等机制。

差的:
/getProducts
/listOrders
/retrieveClientByOrder?orderId=1

rest风格:
GET /products : will return the list of all products
POST /products : will add a product to the collection
GET /products/4 : will retrieve product #4
PATCH/PUT /products/4 : will update product #4

总结 :接口方法名一样,接口上明确接受http的动词;参数在url上不指明key;
-----------------------------
@PathVariable :可以URL中的传递参数(但一般不使用它使用RequestParam),
就是因为它的存在 才有了下面的REST风格.

URL 如: testRest?1//不需要写id=1 
@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
public String testRestPut(@PathVariable Integer id) {
	System.out.println("testRest Put: " + id);
	return SUCCESS;
}
--------------------------------------------------------------------
且不推荐使用对象接收参数
/**
 * @RequestParam 可以使用它来接受页面请求参数
	 value 值即请求参数的参数名 和 前端 name 名字一致
	 method 可以约束方法的提交方式. 
	 required 该参数是否必须.默认true,没有对应的参数会报错
	defaultValue ,假如没有对应的传值,就使用这个默认值 
	对于 int 类型如果不传值是会出错的,这时我们可以使用这个参数设置默认为 0 或使用 Integer 默认不传值为null
 */
@RequestMapping(value = "/testRequestParam")
public String testRequestParam(
		@RequestParam(value = "username") String un, 
		@RequestParam(value = "age", required = false, defaultValue = "0") int age) {			
	System.out.println("testRequestParam, username: " + un + ", age: " + age);		
	return SUCCESS;
}
--------------------------------------------------------------------------
/**
 * 映射请求头信息 @RequestHeader:有时可能需要改变那个值
	 用法参考 @RequestParam
	 value ="这里值可以在浏览器工具上复制"
 */
@RequestMapping("/testRequestHeader")//不常用但必须会的
public String testRequestHeader(@RequestHeader(value = "Accept-Language") String al) {
	System.out.println("testRequestHeader, Accept-Language: " + al);
}
-----------------------------------------
/**
 * @CookieValue: 映射一个 Cookie 值. 用法参考 @RequestParam 
 */
@RequestMapping("/testCookieValue")
public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
	System.out.println("testCookieValue: sessionId: " + sessionId);
	return SUCCESS;
}
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

mysql

正确使用join 字句:

1,inner join（join）: (内连接)查出两个圈重叠的部分

2,left outer join :(左外连接)查出左表的全部字段,如果右表中没有和左表数据对应的显示NULL
；如果再右表条件后追加 is not null 将查出全匹配的（这时结果和内连接效果一样）

3,right join : (右外连接)以右表为基础,会包含右表的全部记录,包含重复部分,左表没有的字段使用NULL填充
；如果再左表条件后追加 is not null 将查出全匹配的（这时结果和内连接效果一样）

其实左,右外连接是一个东西,只是看你站在以哪个表为基础上写的sql.

4,full join :(全连接)其实就是左右连接的合集,得到全部字段.但mysql不支持,oracle支持;mysql使用union代替

5.,cross Join :(交叉连接又称笛卡尔连接) 假如a表是4条记录,b表是5表,最后查出20条记录;

UNION 操作符用于合并两个或多个 SELECT 语句的结果集。UNION 内部的 SELECT 语句必须拥有相同数量的列。列也必须拥有相似的数据类型。

union 是对数据进行并集操作，不包括重复行，同时进行默认排序
Union all 是对数据进行并集操作，包括重复行，不进行排序

http://www.w3school.com.cn/sql/sql_union.asp

---------------------------
首先创建2张表,表结构完全一样;只是数据已有孙悟空在两个表中都有数据

create table user1(
	id int primary key,
	user_name char(20),
	over char(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user1 (id,user_name,over) values (1,'唐僧','功德佛');
insert into user1 (id,user_name,over) values (2,'猪八戒','净坛使者');
insert into user1 (id,user_name,over) values (3,'孙悟空','斗战圣佛');
insert into user1 (id,user_name,over) values (4,'沙僧','金身罗汉');

create table user2(
	id int primary key,
	user_name char(20),
	over char(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user2 (id,user_name,over) values (1,'孙悟空','成佛');
insert into user2 (id,user_name,over) values (2,'牛魔王','被降服');
insert into user2 (id,user_name,over) values (3,'蛟魔王','被降服');
insert into user2 (id,user_name,over) values (4,'鹏魔王','被降服');
insert into user2 (id,user_name,over) values (5,'狮驼王','被降服');


--内连接(只会查出2个表重叠的数据)
select * from user1 a inner join user2 b on a.user_name = b.user_name; -- 推荐这种速度快
select * from user1,user2 where user1.user_name = user2.user_name; -- 老式方式
-- 结果一模一样
+----+-----------+----------+----+-----------+------+
| id | user_name | over     | id | user_name | over |
+----+-----------+----------+----+-----------+------+
|  3 | 孙悟空    | 斗战圣佛 |  1 | 孙悟空    | 成佛 |
+----+-----------+----------+----+-----------+------+

-- 选择显示字段
select a.id,a.user_name,a.over from user1 a inner join user2 b on a.user_name = b.user_name;
+----+-----------+----------+
| id | user_name | over     |
+----+-----------+----------+
|  3 | 孙悟空    | 斗战圣佛 |
+----+-----------+----------+



-- 左外连接(查出左表全部字段,右表只显示和where条件对应的那条记录,不匹配的用NULL填充)
 select * from user1 a left join user2 b on a.user_name = b.user_name;
//开发用id关联,你会发现要么是1对1,要么是1对多数量不会大;左表全部数据,右表只有id匹配的那几条
+----+-----------+----------+------+-----------+------+
| id | user_name | over     | id   | user_name | over |
+----+-----------+----------+------+-----------+------+
|  1 | 唐僧      | 功德佛   | NULL | NULL      | NULL |
|  2 | 猪八戒    | 净坛使者 | NULL | NULL      | NULL |
|  3 | 孙悟空    | 斗战圣佛 |    1 | 孙悟空    | 成佛 |
|  4 | 沙僧      | 金身罗汉 | NULL | NULL      | NULL |
+----+-----------+----------+------+-----------+------+


select * from user1 a left join user2 b on a.user_name = b.user_name where b.user_name is not null;
//这尼玛不知道数度快好多,但还是要多测试实际业务
+----+-----------+----------+------+-----------+------+
| id | user_name | over     | id   | user_name | over |
+----+-----------+----------+------+-----------+------+
|  3 | 孙悟空    | 斗战圣佛 |    1 | 孙悟空    | 成佛 |
+----+-----------+----------+------+-----------+------+
结论 : 其实主要看 is not null 作用于那个表的字段上;

select * from  user1 LEFT join user2 on user1.`user_name` = user2.`user_name` where user2.user_name is NULL
//去除左右表重复的,只保留左表独有的
1	唐僧		功德佛	NULL	NULL	NULL
2	猪八戒	净坛使者	NULL	NULL	NULL
4	沙僧		金身罗汉	NULL	NULL	NULL


-- 右外连接(和左连接一摸一样,只是站的角度不同,完全可以使用左连接代替右连接)
select * from user1 a right join user2 b on a.user_name = b.user_name

+------+-----------+----------+----+-----------+--------+
| id   | user_name | over     | id | user_name | over   |
+------+-----------+----------+----+-----------+--------+
|    3 | 孙悟空    | 斗战圣佛 |  1 | 孙悟空    | 成佛   |
| NULL | NULL      | NULL     |  2 | 牛魔王    | 被降服 |
| NULL | NULL      | NULL     |  3 | 蛟魔王    | 被降服 |
| NULL | NULL      | NULL     |  4 | 鹏魔王    | 被降服 |
| NULL | NULL      | NULL     |  5 | 狮驼王    | 被降服 |
+------+-----------+----------+----+-----------+--------+

结论: 右表全部字段显示,左表只显示 on 后面 条件相对应的记录,不对应的使用NULL填充.




-- 全连接(就是左右外连接的集合),查询出全部数据.使用union 可以去重复数据(每个字段都是一样,才算重复),使用union all 不去重复数据
select * from user1 a left join user2 b
on a.user_name = b.user_name
union
select * from user1 a right join user2 b
on a.user_name = b.user_name

+------+-----------+----------+------+-----------+--------+
| id   | user_name | over     | id   | user_name | over   |
+------+-----------+----------+------+-----------+--------+
|    1 | 唐僧      | 功德佛   | NULL | NULL      | NULL   |
|    2 | 猪八戒    | 净坛使者 | NULL | NULL      | NULL   |
|    3 | 孙悟空    | 斗战圣佛 |    1 | 孙悟空    | 成佛   |
|    4 | 沙僧      | 金身罗汉 | NULL | NULL      | NULL   |
| NULL | NULL      | NULL     |    2 | 牛魔王    | 被降服 |
| NULL | NULL      | NULL     |    3 | 蛟魔王    | 被降服 |
| NULL | NULL      | NULL     |    4 | 鹏魔王    | 被降服 |
| NULL | NULL      | NULL     |    5 | 狮驼王    | 被降服 |
+------+-----------+----------+------+-----------+--------+

--使用 union all 孙悟空会出现两次
+------+-----------+----------+------+-----------+--------+
| id   | user_name | over     | id   | user_name | over   |
+------+-----------+----------+------+-----------+--------+
|    1 | 唐僧      | 功德佛   | NULL | NULL      | NULL   |
|    2 | 猪八戒    | 净坛使者 | NULL | NULL      | NULL   |
|    3 | 孙悟空    | 斗战圣佛 |    1 | 孙悟空    | 成佛   |
|    4 | 沙僧      | 金身罗汉 | NULL | NULL      | NULL   |
|    3 | 孙悟空    | 斗战圣佛 |    1 | 孙悟空    | 成佛   |
| NULL | NULL      | NULL     |    2 | 牛魔王    | 被降服 |
| NULL | NULL      | NULL     |    3 | 蛟魔王    | 被降服 |
| NULL | NULL      | NULL     |    4 | 鹏魔王    | 被降服 |
| NULL | NULL      | NULL     |    5 | 狮驼王    | 被降服 |
+------+-----------+----------+------+-----------+--------+




-- 交叉连接:
select * from user1 a cross join user2 b
+----+-----------+----------+----+-----------+--------+
| id | user_name | over     | id | user_name | over   |
+----+-----------+----------+----+-----------+--------+
|  1 | 唐僧      | 功德佛   |  1 | 孙悟空    | 成佛   |
|  2 | 猪八戒    | 净坛使者 |  1 | 孙悟空    | 成佛   |
|  3 | 孙悟空    | 斗战圣佛 |  1 | 孙悟空    | 成佛   |
|  4 | 沙僧      | 金身罗汉 |  1 | 孙悟空    | 成佛   |
|  1 | 唐僧      | 功德佛   |  2 | 牛魔王    | 被降服 |
|  2 | 猪八戒    | 净坛使者 |  2 | 牛魔王    | 被降服 |
|  3 | 孙悟空    | 斗战圣佛 |  2 | 牛魔王    | 被降服 |
|  4 | 沙僧      | 金身罗汉 |  2 | 牛魔王    | 被降服 |
|  1 | 唐僧      | 功德佛   |  3 | 蛟魔王    | 被降服 |
|  2 | 猪八戒    | 净坛使者 |  3 | 蛟魔王    | 被降服 |
|  3 | 孙悟空    | 斗战圣佛 |  3 | 蛟魔王    | 被降服 |
|  4 | 沙僧      | 金身罗汉 |  3 | 蛟魔王    | 被降服 |
|  1 | 唐僧      | 功德佛   |  4 | 鹏魔王    | 被降服 |
|  2 | 猪八戒    | 净坛使者 |  4 | 鹏魔王    | 被降服 |
|  3 | 孙悟空    | 斗战圣佛 |  4 | 鹏魔王    | 被降服 |
|  4 | 沙僧      | 金身罗汉 |  4 | 鹏魔王    | 被降服 |
|  1 | 唐僧      | 功德佛   |  5 | 狮驼王    | 被降服 |
|  2 | 猪八戒    | 净坛使者 |  5 | 狮驼王    | 被降服 |
|  3 | 孙悟空    | 斗战圣佛 |  5 | 狮驼王    | 被降服 |
|  4 | 沙僧      | 金身罗汉 |  5 | 狮驼王    | 被降服 |
+----+-----------+----------+----+-----------+--------+

select * from user1 a cross join user2 b -- 交叉连接,就是2个表的条数相乘
+----------+
| count(*) |
+----------+
|       20 |
+----------+


-- 比如对战游戏中,就会使用到下面这样的组合(刚好是20组)
select a.user_name,b.user_name from user1 a cross join user2 b;
+-----------+-----------+
| user_name | user_name |
+-----------+-----------+
| 唐僧      | 孙悟空    |
| 猪八戒    | 孙悟空    |
| 孙悟空    | 孙悟空    |
| 沙僧      | 孙悟空    |
| 唐僧      | 牛魔王    |
| 猪八戒    | 牛魔王    |
| 孙悟空    | 牛魔王    |
| 沙僧      | 牛魔王    |
| 唐僧      | 蛟魔王    |
| 猪八戒    | 蛟魔王    |
| 孙悟空    | 蛟魔王    |
| 沙僧      | 蛟魔王    |
| 唐僧      | 鹏魔王    |
| 猪八戒    | 鹏魔王    |
| 孙悟空    | 鹏魔王    |
| 沙僧      | 鹏魔王    |
| 唐僧      | 狮驼王    |
| 猪八戒    | 狮驼王    |
| 孙悟空    | 狮驼王    |
| 沙僧      | 狮驼王    |
+-----------+-----------+



-- 上面 5种join从句就已经学完了
=======================================================================

需求: 想找出2张表名字的字段相同的记录,然后修改a 表的over字段为齐天大圣;
update user1 a inner join user2 b on a.user_name = b.user_name set a.over = '齐天大圣';

+----+-----------+----------+
| id | user_name | over     |
+----+-----------+----------+
|  1 | 唐僧      | 功德佛   |
|  2 | 猪八戒    | 净坛使者 |
|  3 | 孙悟空    | 齐天大圣 |
|  4 | 沙僧      | 金身罗汉 |
+----+-----------+----------+

---------------------------------------------------------------------------------

on和where条件的区别如下(十分重要)：

1,on条件是在生成临时表时使用的条件，它不管on中的条件是否为真，都会返回左边表中的记录。
										~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
2,where条件是在临时表生成好后，再对临时表进行过滤的条件。这时已经没有left join的含义
				~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
结论: on 的作用是在生成临时表时的条件,where是在临时表后的条件;所以on的性能比where高;
				
select * from user1 a left join user2 b on a.user_name = b.user_name;
+----+-----------+--------------+------+-----------+--------+
| id | user_name | over         | id   | user_name | over   |
+----+-----------+--------------+------+-----------+--------+
|  3 | 孙悟空    | 斗战圣佛     |    1 | 孙悟空    | 成佛   |
|  1 | 唐僧      | 功德佛       | NULL | NULL      | NULL   |
|  2 | 猪八戒    | 净坛使者     | NULL | NULL      | NULL   |
|  4 | 沙僧      | 金身罗汉     | NULL | NULL      | NULL   |
+----+-----------+--------------+------+-----------+--------+

select * from user1 a left join user2 b on a.user_name = b.user_name where a.user_name = b.user_name;
+----+-----------+--------------+------+-----------+--------+
| id | user_name | over         | id   | user_name | over   |
+----+-----------+--------------+------+-----------+--------+
|  3 | 孙悟空    | 斗战圣佛     |    1 | 孙悟空    | 成佛   |
+----+-----------+--------------+------+-----------+--------+

------------------------------------------------------------------

//功能描述: 根据订单id,得到购物表中的数量,得到商品表的名字
-- 老式的3表联合查询,容易理解点;但性能没on快.
select sg.name as '名称',sc.quantity as '数量'
from yanyu_shopping_cart as sc , yanyu_system_goods as sg , yanyu_order as o 
where sc.goods_id = sg.id and o.shopping_cart = sc.id 
and o.id = '402887e45a7e81af015a7f82a69c01a0'


//功能描述: 根据订单id,得到购物表中的数量,得到商品表的名字
-- 推荐3表联合查询,推荐
select sg.name as '名称',sc.quantity as '数量' 
from yanyu_shopping_cart as sc LEFT JOIN yanyu_system_goods as sg 
on sc.goods_id = sg.id LEFT JOIN yanyu_order as o on o.shopping_cart = sc.id 
where o.id = '402887e45a7e81af015a7f82a69c01a0' 



//得到左表和右表独有的数据;因为mysql不支持全连接;通过union all 来迂回得到;
select * from user1 a left join user2 b on a.user_name = b.user_name where b.user_name is NULL —－得到左表且排除左表和右表相同的数据
union all
select * from user1 a right join user2 b on a.user_name = b.user_name where a.user_name is NULl —-得到右表且排除右和左表相同的数据
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
MYBATIS

于其他的ORM框架对比,即解决输入参数和返回结果集的映射,还能让用户方便的书写sql
MyBatis 最大的特点就是:程序员可以更加灵活的操作sql语句.不关注其他
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
重要：mybatis和spring整合配置一般分为3步：
	1,需要一个dataSource;2,配置sqlSessionFactoryBean;3,MapperScannerConfigurer
	
http://www.mybatis.org/spring/zh/index.html //mybatis-spring 结合
http://www.mybatis.org/mybatis-3/zh/getting-started.html 官网支持中文,超给力
http://www.cnblogs.com/xdp-gacl/p/4261895.html //这人的博客入门到缓存很易懂

首先我们来看看JDBC中操作有什么问题,为什么需要Mybatis.
1,数据库连接,使用时创建,不使用立即释放,对数据库进行频繁的连接和关闭,造成数据库资源的浪费.
设想:使用数据库连接池管理数据库链接

2,将sql语句硬编码到java代码中,如果sql语句修改,需要重新编译java代码,不利于系统维护.
设想:将sql语句配置到xml配置文件中,即使sql变化,不需要对java代码进行重新编译.

3,在向preparedStatement中设置参数,对占位符号位置和设置参数值,硬编码在java代码中.
设想:将sql语句及占位符号和参数全部配置在xml中

4,对于resultSet 结果集的输出也是硬编码
设想:在结果集自动映射对java实体对象.


SqlSessionFactory :会话工厂,作用 :创建SqlSession.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
SqlSession 的作用 :使用它来操作数据库的CRUD.但是通过内部Execute(执行器)来完成的
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Execute 下面还有一个mapped statement (底层封装对象) 作用: 对操作数据库存储,包括sql语句,输入
参数,输出结果类型.
------------------------------------------------------------
普通的模糊查询
<!-- 查询学生list,like姓名 -->     
<select id=" getStudentListLikeName " parameterType="StudentEntity" resultMap="studentResultMap">     
	SELECT * from STUDENT_TBL ST      
	<if test="studentName!=null and studentName!='' ">     
		WHERE ST.STUDENT_NAME LIKE CONCAT(CONCAT('%', #{studentName}),'%')      
	</if>     
</select>     


多个 if 使用它就插入一个‘where’
此外,如果标签返回的内容是以AND 或OR 开头的,则它会剔除掉.
<!-- 查询学生list,like姓名,=性别 -->     
<select id="getStudentListWhere" parameterType="StudentEntity" resultMap="studentResultMap">     
	SELECT * from STUDENT_TBL ST      
	<where>     
		<if test="studentName!=null and studentName!='' ">     
			ST.STUDENT_NAME LIKE CONCAT(CONCAT('%', #{studentName}),'%')      
		</if>     
		<if test="studentSex!= null and studentSex!= '' ">     
			AND ST.STUDENT_SEX = #{studentSex}      
		</if>     
	</where>     
</select>     

set
当在update语句中使用if标签时,如果前面的if没有执行,则或导致逗号多余错误.使用set标签可以将动态的配置SET 关键字,
和剔除追加到条件末尾的任何不相关的逗号
    <!-- 更新学生信息 -->     
    <update id="updateStudent" parameterType="StudentEntity">     
        UPDATE STUDENT_TBL      
        <set>     
            <if test="studentName!=null and studentName!='' ">     
                STUDENT_TBL.STUDENT_NAME = #{studentName},      
            </if>     
            <if test="studentSex!=null and studentSex!='' ">     
                STUDENT_TBL.STUDENT_SEX = #{studentSex},      
            </if>     
            <if test="studentBirthday!=null ">     
                STUDENT_TBL.STUDENT_BIRTHDAY = #{studentBirthday},      
            </if>     
            <if test="classEntity!=null and classEntity.classID!=null and classEntity.classID!='' ">     
                STUDENT_TBL.CLASS_ID = #{classEntity.classID}      
            </if>     
        </set>     
        WHERE STUDENT_TBL.STUDENT_ID = #{studentID};      
    </update>     

trim是更灵活的去处多余关键字的标签,他可以完成where和set的效果.
where例子的等效trim语句:
<!-- 查询学生list,like姓名,=性别 -->     
<select id="getStudentListWhere" parameterType="StudentEntity" resultMap="studentResultMap">     
	SELECT * from STUDENT_TBL ST      
		<trim prefix="WHERE" prefixOverrides="AND|OR">    
	
		<if test="studentName!=null and studentName!='' ">     
			ST.STUDENT_NAME LIKE CONCAT(CONCAT('%', #{studentName}),'%')      
		</if>     
		
		<if test="studentSex!= null and studentSex!= '' ">     
			AND ST.STUDENT_SEX = #{studentSex}      
		</if>     	
	</trim>     
</select>     

set例子的等效trim语句:
Xml代码  
<!-- 更新学生信息 -->     
<update id="updateStudent" parameterType="StudentEntity">     
	UPDATE STUDENT_TBL      
	<trim prefix="SET" suffixOverrides=",">     
		<if test="studentName!=null and studentName!='' ">     
			STUDENT_TBL.STUDENT_NAME = #{studentName},      
		</if>     	
		<if test="studentSex!=null and studentSex!='' ">     
			STUDENT_TBL.STUDENT_SEX = #{studentSex},      
		</if>    
		<if test="studentBirthday!=null ">     
			STUDENT_TBL.STUDENT_BIRTHDAY = #{studentBirthday},      
		</if>    
		<if test="classEntity!=null and classEntity.classID!=null and classEntity.classID!='' ">     
			STUDENT_TBL.CLASS_ID = #{classEntity.classID}      
		</if>   	
	</trim>    
	WHERE STUDENT_TBL.STUDENT_ID = #{studentID};      
</update>     

3.3 choose (when, otherwise)
有时候我们并不想应用所有的条件,而只是想从多个选项中选择一个.
MyBatis提供了choose 元素,按顺序判断when中的条件是否成立,
如果有一个成立,则choose结束.
当choose中所有when的条件都不满则时,则执行 otherwise中的sql.

例如下面例子,同样把所有可以限制的条件都写上,方面使用.选择条件顺序,when标签的从上到下的书写顺序:
 
 
<!-- 查询学生list,like姓名、或=性别、或=生日、或=班级,使用choose -->     
<select id="getStudentListChooseEntity" parameterType="StudentEntity" resultMap="studentResultMap">     
	SELECT * from STUDENT_TBL ST      
	<where>     
		<choose>     
			<when test="studentName!=null and studentName!='' ">     
					ST.STUDENT_NAME LIKE CONCAT(CONCAT('%', #{studentName}),'%')      
			</when>  		
			<when test="studentSex!= null and studentSex!= '' ">     
					AND ST.STUDENT_SEX = #{studentSex}      
			</when>   		
			<when test="studentBirthday!=null">     
				AND ST.STUDENT_BIRTHDAY = #{studentBirthday}      
			</when>   	
			<when test="classEntity!=null and classEntity.classID !=null and classEntity.classID!='' ">     
				AND ST.CLASS_ID = #{classEntity.classID}      
			</when>   		
			<otherwise>     				  
			</otherwise>     
		</choose>     
	</where>     
</select>     

3.4 foreach
主是要迭代一个集合,通常是用于IN 条件.
foreach :
collection :指定输入对象集合属性
item: 每次循环的对象
open : 总循环开始时拼接的字符
close : 总循环结束时拼接的字符
separator : 使用什么分割符连接

<select id="getStudentListByClassIDs" resultMap="studentResultMap">     
	SELECT * FROM STUDENT_TBL ST      
	 WHERE ST.CLASS_ID IN  
	<!--list 固定不变的不是和dao的参数名一致的,item也和dao参数名不一致,只是和循环体名对应-->     
	 <foreach collection="list" item="classList"  open="(" separator="," close=")">     
		#{classList.id}      
	 </foreach>         
</select>     

<select id="getStudentListByClassIDs" resultMap="studentResultMap">     
	SELECT * FROM STUDENT_TBL ST      
	 WHERE ST.CLASS_ID IN   
	<!--array 固定不变的不是和dao的参数名一致的,item也和dao参数名不一致,只是和循环体名对应-->	 
	 <foreach collection="array" item="ids"  open="(" separator="," close=")">     
		#{ids}      
	 </foreach>     
</select>     
---------------------------------------------------------------------------
Mybatis 的原生分页:
LIMIT #{pageFrom},#{pageSize}
++++++++++++++++++++++++++++++++++++++++++++++++++++++
Hibernate 和 Mybatis的对比

Mybatis优势
MyBatis可以进行更为细致的SQL优化,可以减少查询字段.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
MyBatis容易掌握,而Hibernate门槛较高.

Hibernate优势
Hibernate的DAO层开发比MyBatis简单,Mybatis需要维护SQL和结果映射.
Hibernate对对象的维护和缓存要比MyBatis好,对增删改查的对象的维护要方便.
Hibernate数据库移植性很好,MyBatis的数据库移植性不好,不同的数据库需要写不同SQL.
Hibernate有更好的二级缓存机制,可以使用第三方缓存.MyBatis本身提供的缓存机制不佳.
最后结论 : Hibernate大牛使用

//如果有时我们要返回数据库里没有的数据,这时mybatis的优势就可以提现出来,可以的自由的组合返回结果；
//只需要在实体类对加入一个类类型,然后给这个类类型赋值
<select id="queryByIdWithSeckill" resultType="SuccessKilled">
	<!-- 功能 :根据id查询SuccessKilled并携带Seckill实体 -->
	<!-- 告诉MyBatis把结果映射到SuccessKilled同时映射seckill(类)属性 -->
	<!-- Mybatis最大的特点就是:可以自由控制SQL -->
	select
	  sk.seckill_id,
	  sk.user_phone,
	  sk.create_time,
	  sk.state,
	  s.seckill_id "seckill.seckill_id", -- 这里相当于是给类中seckill的属性进行赋值,最好加上“”抱进来
	  s.name "seckill.name",
	  s.number "seckill.number",
	  s.start_time "seckill.start_time",
	  s.end_time "seckill.end_time",
	  s.create_time "seckill.create_time"
	from success_killed sk
	inner join seckill s on sk.seckill_id = s.seckill_id
	where sk.seckill_id=#{seckillId} and sk.user_phone=#{userPhone}
</select>

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

存储过程
有收藏csdn博文: MYSQL存储过程和存储函数入门,(很牛逼,下面大部门来至哪里)


存储过程最大的最用有2个:
1,就是分装业务逻辑,在存储过程中,可以通程序逻辑if-else,循环while,临时表,等,功能非常强大.
//就是可以一次执行很多条SQL语句..
2,主要是性能上的,编译一次,多次执行,每次执行的时候,不用重新生成执行计划,效率相对于一般的sql语句,提高很多倍.


// 存储过程入门
drop procedure if exists pr_add;//如果存储过程pr_add存在,则删去；如果不存在,则什么事也不做
create PROCEDURE pr_add(in a int,in b int) -- 就算是没有参数要传也要有()
BEGIN
	DECLARE c int; -- declare 是声明变量的关键字
	-- 存储过程里面可以进行大量的逻辑判断,可以可以理解为多条sql可以融合到一条执行;
	if a is NULL THEN 
		set a = 1;
	end if;
	if b is null THEN
		set b = 1;
	end if;
	set c = a + b;
	SELECT c as sum;
END;
call pr_add(null,null); -- 调用过程

----------------------------------------------------------------

存储过程的传入参数有3种类型: in,out,inout下面就来看看区别:

//1,测试 in 类型是怎么一个输出样式(复制代码去mysql中执行)
drop procedure if exists suibian; -- 如果suibian存在就删除
create procedure suibian(in p_in int)
BEGIN
	SELECT p_in; -- 结果1,这里会打印一次结果
	SET p_in=2;  -- 方法体中赋值
	SELECT p_in; -- 结果2,这里还会打印一次结果
END;
set @p_in=1; -- 设置变量
call suibian(@p_in); 
// 总结一次select 就会出现一次结果,这个存储过程会有2个结果
select @p_in; -- 打印的1;虽然我们在 过程体中修改了值,但不起作用.这就是in 参数.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

--  下面这个过程是测试通过没有问题的
drop procedure school_proc
create procedure school_proc(
	in p_schoolId 					   varchar(50),-- id
	in p_schoolLogo                     varchar(255),-- 商家商标图片地址
	in p_schoolName                     varchar(50),-- 驾校名称(索引schoolName_index)
	in p_contactPerson                  varchar(100),-- 联系人
	in p_contactPhone                   varchar(100),-- 联系电话
	in p_schoolInfo                     text,-- 驾校简介
	in p_schoolAddress                  varchar(255), -- 地址
	in p_schoolImage                    varchar(255),-- 驾校图片
	in p_schoolVideo                    varchar(255), -- 驾校视频
	in p_schoolGrade                    int,  -- 驾校等级
	in p_schoolLat                      varchar(255), -- 驾校纬度(索引schoolLat_index)
	in p_schoolLng                      varchar(255), -- 驾校经度 (索引schoolLng_index)
	in p_driverInfo                     varchar(255),-- 驾校教练信息
	in p_insertTimeStamp                timestamp(6) -- 插入时间戳	
)

begin
    declare var int;
    set var = 0;
    start transaction; -- 开启事务
		select count(*) into var from tb_school where schoolName = p_schoolName;
		if var = 0 then -- 等于0,说明数据库没有这用户,那就添加一条数据
			insert into tb_school
			(schoolId,schoolLogo,schoolName,contactPerson,contactPhone,schoolInfo,schoolAddress,schoolImage,schoolVideo,schoolGrade,schoolLat,schoolLng,driverInfo,insertTimeStamp)
			values
			(p_schoolId,p_schoolLogo,p_schoolName,p_contactPerson,p_contactPhone,p_schoolInfo,p_schoolAddress,p_schoolImage,p_schoolVideo,p_schoolGrade,p_schoolLat,p_schoolLng,p_driverInfo,p_insertTimeStamp);
		else -- 有就 修改这段
			update tb_school
			set schoolLat = p_schoolLat, schoolLng = p_schoolLng
			where schoolName = p_schoolName;
		end if;
		set var = 0; 
	commit; -- 提交事务
end;




DDL—数据定义语言(Create，Alter，Drop，DECLARE)
DML—数据操纵语言(Select，Delete，Update，Insert)
DCL—数据控制语言(GRANT，REVOKE，COMMIT，ROLLBACK)

首先,简要介绍基础语句：
set names gbk;有时我们在编写时可能要输入中文,就需要设置,不影响数据库
delimiter 自定义 然后我们就只能用这个符号才会提交
------------------------------
怎么进数据库?
1,show databases;查看数据库
2,use 需要进的数据库; 进其中一个数据库
3,show tables;查看表
4,select *from 表名 查表
5,desc 表名可以查看字段类型
-----------------------------------
1、说明：创建数据库
CREATE DATABASE 数据库名 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci；
查看数据库字符集：show variables like '%char%';

2、说明：删除数据库
drop database dbname

3、说明：备份sql server
--- 创建 备份数据的 device
USE master
EXEC sp_addumpdevice 'disk', 'testBack', 'c:\mssql7backup\MyNwind_1.dat'
--- 开始 备份
BACKUP DATABASE pubs TO testBack

4、说明：创建新表
create table tabname(
col1 type1 [not null] [primary key],
col2 type2 [not null],
..)

-- 举例
CREATE TABLE `girl` (
  `id` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


根据已有的表创建新表：
A：create table tab_new like tab_old (使用旧表创建新表)
B：create table tab_new as select col1,col2… from tab_old definition only

5、说明：删除表
drop table tabname

6、说明：增加一个列
Alter table tabname add column col type
注：列增加后将不能删除。DB2中列加上后数据类型也不能改变，唯一能改变的是增加varchar类型
的长度。

7、说明：添加主键： Alter table tabname add primary key(col)
说明：删除主键： Alter table tabname drop primary key(col)

8、说明：创建索引：create [unique] index idxname on tabname(col….)
删除索引：drop index idxname
注：索引是不可更改的，想更改必须删除重新建。

9、说明：创建视图：create view viewname as select statement
删除视图：drop view viewname

10、说明：几个简单的基本的sql语句
选择：select * from table1 where 范围
插入：insert into table1(field1,field2) values(value1,value2)
-- 举例
insert into userinfo(name,age,sex) values('张三',24,'男')
删除：delete from table1 where 范围
更新：update table1 set field1=value1 where 范围
查找：select * from table1 where field1 like '%value1%' 
排序：select * from table1 order by field1,field2 [desc]
总数：select count as totalcount from table1
求和：select sum(field1) as sumvalue from table1
平均：select avg(field1) as avgvalue from table1
最大：select max(field1) as maxvalue from table1
最小：select min(field1) as minvalue from table1

11、说明：几个高级查询运算词
A： UNION 运算符
UNION 运算符通过组合其他两个结果表（例如 TABLE1 和 TABLE2）并消去表中任何重复行而派生
出一个结果表。当 ALL 随 UNION 一起使用时（即 UNION ALL），不消除重复行。两种情况下，派
生表的每一行不是来自 TABLE1 就是来自 TABLE2。
B： EXCEPT 运算符
EXCEPT 运算符通过包括所有在 TABLE1 中但不在 TABLE2 中的行并消除所有重复行而派生出一个
结果表。当 ALL 随 EXCEPT 一起使用时 (EXCEPT ALL)，不消除重复行。
C： INTERSECT 运算符
INTERSECT 运算符通过只包括 TABLE1 和 TABLE2 中都有的行并消除所有重复行而派生出一个结果
表。当 ALL 随 INTERSECT 一起使用时 (INTERSECT ALL)，不消除重复行。
注：使用运算词的几个查询结果行必须是一致的。

12、说明：使用外连接
A、left outer join：
左外连接（左连接）：结果集几包括连接表的匹配行，也包括左连接表的所有行。
sql: select a.a, a.b, a.c, b.c, b.d, b.f from a LEFT OUT JOIN b ON a.a = b.c
B：right outer join:
右外连接(右连接)：结果集既包括连接表的匹配连接行，也包括右连接表的所有行。
C：full outer join：
全外连接：不仅包括符号连接表的匹配行，还包括两个连接表中的所有记录。

13、说明：复制表(只复制结构,源表名：a 新表名：b) (Access可用)
法一：select * into b from a where 1<>1
法二：select top 0 * into b from a

14、说明：拷贝表(拷贝数据,源表名：a 目标表名：b) (Access可用)
insert into b(a, b, c) select d,e,f from b;

15、说明：跨数据库之间表的拷贝(具体数据使用绝对路径) (Access可用)
insert into b(a, b, c) select d,e,f from b in ‘具体数据库' where 条件
例子：..from b in '"&Server.MapPath(".")&"\data.mdb" &"' where..

16、说明：子查询(表名1：a 表名2：b)
select a,b,c from a where a IN (select d from b ) 或者: select a,b,c from a where a IN
(1,2,3)

17、说明：显示文章、提交人和最后回复时间
select a.title,a.username,b.adddate from table a,(select max(adddate) adddate from
table where table.title=a.title) b

18.说明：外连接查询(表名1：a 表名2：b)
select a.a, a.b, a.c, b.c, b.d, b.f from a LEFT OUT JOIN b ON a.a = b.c

19、说明：在线视图查询(表名1：a )
select * from (Select a,b,c FROM a) T where t.a > 1;

20、说明：between的用法,between限制查询数据范围时包括了边界值,not between不包括
select * from table1 where time between time1 and time2
select a,b,c, from table1 where a not between 数值1 and 数值2

21、说明：in 的使用方法
select * from table1 where a [not] in (‘值1','值2','值4','值6')

22、说明：两张关联表，删除主表中在副表中没有的信息
delete from table1 where not exists ( select * from table2 where
table1.field1=table2.field1 )

23、说明：四表联查问题：
select * from a left inner join b on a.a=b.b right inner join c on a.a=c.c inner join
d on a.a=d.d where .....

24、说明：日程安排提前五分钟提醒
sql: select * from 日程安排 where datediff('minute',f开始时间,getdate())>5

25、说明：一条sql 语句搞定数据库分页
select top 10 b.* from (select top 20 主键字段,排序字段 from 表名 order by 排序字段
desc) a,表名 b where b.主键字段 = a.主键字段 order by a.排序字段

26、说明：前10条记录
select top 10 * form table1 where 范围

27、说明：选择在每一组b值相同的数据中对应的a最大的记录的所有信息(类似这样的用法可以用
于论坛每月排行榜,每月热销产品分析,按科目成绩排名,等等.)
select a,b,c from tablename ta where a=(select max(a) from tablename tb where
tb.b=ta.b)

28、说明：包括所有在 TableA 中但不在 TableB和TableC 中的行并消除所有重复行而派生出一个
结果表
(select a from tableA ) except (select a from tableB) except (select a from tableC)

29、说明：随机取出10条数据
select top 10 * from tablename order by newid()

30、说明：随机选择记录
select newid()

31、说明：删除重复记录
Delete from tablename where id not in (select max(id) from tablename group by
col1,col2,...)

32、说明：列出数据库里所有的表名
select name from sysobjects where type='U'

33、说明：列出表里的所有的
select name from syscolumns where id=object_id('TableName')

34、说明：列示type、vender、pcs字段，以type字段排列，case可以方便地实现多重选择，类似
select 中的case。
select type,sum(case vender when 'A' then pcs else 0 end),sum(case vender when 'C'
then pcs else 0 end),sum(case vender when 'B' then pcs else 0 end) FROM tablename
group by type
显示结果：
type vender pcs
电脑 A 1
电脑 A 1
光盘 B 2
光盘 A 2
手机 B 3
手机 C 3

35、说明：初始化表table1
TRUNCATE TABLE table1


36、说明：选择从10到15的记录
select top 5 * from (select top 15 * from table order by id asc) table_别名 order by
id desc
　　
37、一道SQL语句面试题，关于group by
表内容：
2005-05-09 胜
2005-05-09 胜
2005-05-09 负
2005-05-09 负
2005-05-10 胜
2005-05-10 负
2005-05-10 负
如果要生成下列结果, 该如何写sql语句?
胜 负
2005-05-09 2 2
2005-05-10 1 2
答：代码如下：
create table #tmp(rq varchar(10),shengfu nchar(1))
insert into #tmp values('2005-05-09','胜')
insert into #tmp values('2005-05-09','胜')
insert into #tmp values('2005-05-09','负')
insert into #tmp values('2005-05-09','负')
insert into #tmp values('2005-05-10','胜')
insert into #tmp values('2005-05-10','负')
insert into #tmp values('2005-05-10','负')
1)select rq, sum(case when shengfu='胜' then 1 else 0 end)'胜',sum(case when shengfu='
负' then 1 else 0 end)'负' from #tmp group by rq
2) select N.rq,N.勝,M.負 from (
select rq,勝=count(*) from #tmp where shengfu='胜'group by rq)N inner join
(select rq,負=count(*) from #tmp where shengfu='负'group by rq)M on N.rq=M.rq
3)select a.col001,a.a1 胜,b.b1 负 from
(select col001,count(col001) a1 from temp1 where col002='胜' group by col001) a,
(select col001,count(col001) b1 from temp1 where col002='负' group by col001) b
where a.col001=b.col001

38、请教一个面试中遇到的SQL语句的查询问题
表中有A B C三列,用SQL语句实现：当A列大于B列时选择A列否则选择B列，当B列大于C列时选择B列
否则选择C列。
示例如下:
select (case when a>b then a else b end ),
(case when b>c then b esle c end)
from table_name

39、一个日期判断的sql语句？
请取出tb_send表中日期(SendTime字段)为当天的所有记录?(SendTime字段为datetime型，包含日
期与时间)
示例如下:
select * from tb where datediff(dd,SendTime,getdate())=0

40、有一张表，里面有3个字段：语文，数学，英语。其中有3条记录分别表示语文70分，数学80分
，英语58分，请用一条sql语句查询出这三条记录并按以下条件显示出来（并写出您的思路）：
大于或等于80表示优秀，大于或等于60表示及格，小于60分表示不及格。
显示格式：
语文 数学 英语
及格 优秀 不及格
示例如下：
select
(case when 语文>=80 then '优秀'
when 语文>=60 then '及格'
else '不及格') as 语文,
(case when 数学>=80 then '优秀'
when 数学>=60 then '及格'
else '不及格') as 数学,
(case when 英语>=80 then '优秀'
when 英语>=60 then '及格'
else '不及格') as 英语,
from table
41、在sqlserver2000中请用sql创建一张用户临时表和系统临时表，里面包含两个字段ID和
IDValues,类型都是int型，并解释下两者的区别?
用户临时表:create table #xx(ID int, IDValues int)
系统临时表:create table ##xx(ID int, IDValues int)
区别:
用户临时表只对创建这个表的用户的Session可见,对其他进程是不可见的.
当创建它的进程消失时这个临时表就自动删除.
全局临时表对整个SQL Server实例都可见,但是所有访问它的Session都消失的时候,它也自动删除.
42、sqlserver2000是一种大型数据库，他的存储容量只受存储介质的限制，请问它是通过什么方
式实现这种无限容量机制的。
它的所有数据都存储在数据文件中(*.dbf),所以只要文件够大,SQL Server的存储容量是可以扩
大的.
SQL Server 2000 数据库有三种类型的文件：
主要数据文件
主要数据文件是数据库的起点，指向数据库中文件的其它部分。每个数据库都有一个主要数据文件
。主要数据文件的推荐文件扩展名是 .mdf。
次要数据文件
次要数据文件包含除主要数据文件外的所有数据文件。有些数据库可能没有次要数据文件，而有些
数据库则有多个次要数据文件。次要数据文件的推荐文件扩展名是 .ndf。
日志文件
日志文件包含恢复数据库所需的所有日志信息。每个数据库必须至少有一个日志文件，但可以不止
一个。日志文件的推荐文件扩展名是 .ldf。
43、请用一个sql语句得出结果
从table1,table2中取出如table3所列格式数据，注意提供的数据及结果不准确，只是作为一个格
式向大家请教。
如使用存储过程也可以。
table1
月份mon 部门dep 业绩yj
一月份 01 10
一月份 02 10
一月份 03 5
二月份 02 8
二月份 04 9
三月份 03 8
table2
部门dep 部门名称dname
--------------------------------
01 国内业务一部
02 国内业务二部
03 国内业务三部
04 国际业务部
table3 （result）
部门dep 一月份 二月份 三月份
--------------------------------------
01 10 null null
02 10 8 null
03 null 5 8
04 null null 9
------------------------------------------
1)
select a.部门名称dname,b.业绩yj as '一月份',c.业绩yj as '二月份',d.业绩yj as '三月份'
from table1 a,table2 b,table2 c,table2 d
where a.部门dep = b.部门dep and b.月份mon = '一月份' and
a.部门dep = c.部门dep and c.月份mon = '二月份' and
a.部门dep = d.部门dep and d.月份mon = '三月份' and
2)
select a.dep,
sum(case when b.mon=1 then b.yj else 0 end) as '一月份',
sum(case when b.mon=2 then b.yj else 0 end) as '二月份',
sum(case when b.mon=3 then b.yj else 0 end) as '三月份',
sum(case when b.mon=4 then b.yj else 0 end) as '四月份',
sum(case when b.mon=5 then b.yj else 0 end) as '五月份',
sum(case when b.mon=6 then b.yj else 0 end) as '六月份',
sum(case when b.mon=7 then b.yj else 0 end) as '七月份',
sum(case when b.mon=8 then b.yj else 0 end) as '八月份',
sum(case when b.mon=9 then b.yj else 0 end) as '九月份',
sum(case when b.mon=10 then b.yj else 0 end) as '十月份',
sum(case when b.mon=11 then b.yj else 0 end) as '十一月份',
sum(case when b.mon=12 then b.yj else 0 end) as '十二月份',
from table2 a left join table1 b on a.dep=b.dep

44、华为一道面试题
一个表中的Id有多个记录，把所有这个id的记录查出来，并显示有多少条记录。
-------------------------------------------------
select id, Count(*) from tb group by id having count(*)>1
select*from(select count(ID) as count from table group by ID)T where T.count>1 
-------------------------------
基本日期函数
select now()返回日期时间
select curdate()返回日期
select curtime()返回时间
select date_add('2013-3-12',interval 365 day);加减时间
select datediff('2013-3-12','2014-3-12');2个参数时间差
select date_format('2014-3-2 16-55-8','%Y-%d-%m %H:%i:%s');日期格式化
year 年
day 天
----------------------------------------------------
存储过程
delimiter //
create procedure removeUserById(in p_id int unsigned)
begin
delete from users where id = p_id;
end
//
delimiter ;
调用 call 过程名(参数);

删除过程 我们在定义参数时,不要和表的字段名一样,不然会全部删除
drop procedure removerUserById;

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

SVN(了解)

https://wenku.baidu.com/view/f991921110a6f524ccbf8580.html#

主要就是实现团队共同开发的问题,都更新的一个服务器上的项目.


安装流程:

1,安装subversion 后配置bin目录到环境变量
2,创建一个SvnRepository 文件夹保存数据
3,cmd中svnadmin create D:\SvnRepository\OA
后在D:\SvnRepository\OA会生成一些文件

给windows创建一个服务启动,这样不用每次去使用cmd去启动服务,以管理员运行下面:

sc create MySVNService binpath= "D:\Subversion\bin\svnserve.exe --service -r D:\SvnRepository" start= auto depend= Tcpip

具体可以参看 dos 文档 [6]最终命令举例.只是改个2个文件地址.

在Windows服务中设置为手动,然后启动,在cmd 输入netstat -an 查看3690端口有就成功了

5,现在等于服务器带着仓库启动起来了.

6,在Eclipse中加入SVN插件,没加之前在Team中是没有SVN这个选项的

7,复制eclipse_svn_site-1.10.5.zip在Eclipse安装文件夹的dropins目录下解压出来就OK

8,修改OA目录下的conf文件价下的svnservice.conf 的参数为anon-access = write

9,在Eclipse需要分享的项目右键 Share分享输入svn://localhost/OA 一直下一步就完成了部署了

10,就是checkOut ,在Eclipse中选择Import 从SVN中 检出 ,同样svn://localhost/OA就可以看见分享的项目

11,然后就是修改 提交 另一边 更新 修改 提交这样重复的操作了

-----------------------------------
12,在使用中可能出现过期操作,这是由于,一方已经提交,另一方修改前没有更新,对于服务器是过时的版本,
我们在冲突文件发生文件上使用解决冲突选项,找到冲突位置.并修改后提交. 

所有我们一般要修改公共代码要先更新后在修改.防止出现这样的问题.

权限设置:一般组长干的事
1,在svnserve.conf 关闭匿名的 ,
开启:
auth-access = write
password-db = passwd
authz-db = authz

2,在passwd 文件中设置登录名和密码
3,在authz文件中设置

[groups]
# harry_and_sally = harry,sally
# harry_sally_and_joe = harry,sally,&joe
kaifa = tom,jey//分组给权限

# [/foo/bar]
# harry = rw
# &joe = r
# * =
[/]//根目录
@kaifa = rw //使用@引用组
ceshi = r 
* =   //其他没有权限

---------------------

最后我们还可以使用乌龟的的图形化界面来checkout update 项目,有中文jar包,最终还是没有我们直接在
Eclipse 直接使用更为方便.

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

GIT

官网上面有中文文档:https://git-scm.com

是linux 这帮人很短的时间研发的.

作用:
1,备份像U盘一样且记录历史备份(可以拉取随意一次时间历史备份)
2,云端存储
3,更好的解决团队开发带来的冲突;

git 和 svn 的主要区别就是git 是分布式的(可以独立的上传，不依赖服务器),svn 是集中式管理(提交依赖服务器)

发展历史：
cvs(集中式 网络环境)->svn（集中式  网络环境）->git（分布式 无网环境）->github（程序猿托管网站）


发布到网上一个项目可以通过下面3种协议让别人下载:
1,ssh (elipse 上可以选择ssh也可以选择https等)
2,https (linux 使用git clone 下载)
3,git(只读,很少用)

上面3种有点类似于就是普通下载,但还是不同的


git 在centos7 上的安装
yum install git
等待安装,安装完毕后
git --version
git version 1.8.3.1 #这次我安装的这个版本
git --help #可以查看命令帮助,下面就是内容

最常用的 git 命令有：
   add        添加文件内容至索引
   bisect     通过二分查找定位引入 bug 的变更
   branch     列出、创建或删除分支
   checkout   检出一个分支或路径到工作区
   clone      克隆一个版本库到一个新目录
   commit     记录变更到版本库
   diff       显示提交之间、提交和工作区之间等的差异
   fetch      从另外一个版本库下载对象和引用
   grep       输出和模式匹配的行
   init       创建一个空的 Git 版本库或重新初始化一个已存在的版本库
   log        显示提交日志
   merge      合并两个或更多开发历史
   mv         移动或重命名一个文件、目录或符号链接
   pull       获取并合并另外的版本库或一个本地分支
   push       更新远程引用和相关的对象
   rebase     本地提交转移至更新后的上游分支中
   reset      重置当前HEAD到指定状态
   rm         从工作区和索引中删除文件
   show       显示各种类型的对象
   status     显示工作区状态
   tag        创建、列出、删除或校验一个GPG签名的 tag 对象
   
-------------------------------
如何 从github 克隆项目

$ git clone git@github.com:huangjufei/moBan.git -- ssh的url
cd moBan
git status
$ echo "我来得了" >> wuyong.txt -- 随便创建一个文件来测试能推到github上去不
git status
$git add wuyong.txt -- 加入缓存区
$git commit -m "克隆测试" --本地版本库已经可以了
$git push -- 推到gitgub上面，现在github可以看见有了这个文件

--------------------------
分支管理：
git branch wodefenzi -- 创建分支
git branch -- 查看分支

git checkout wodefenzi -- 切换到这个分支
现在我们就是分支上写代码如：
$ echo "我来得了" >> fenzhi.txt
$git add fenzhi.txt -- 加入缓存区
$git commit -m "分支测试" --本地版本库已经可以了
$git status 
假如这时我们在分支任务完成，需要把代码合并到主分支来
$git checkout master -- 切换到分支，可以是其他分支也可以是主分支
$git merge wodefenzi -- 合并分支

这时如果我们不需要再在这个分支上开发了，我们需要删除这个分支
$git branch -d wodefenzi
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

MAVEN

//官方对pom文件内容的解释,地址
http://maven.apache.org/pom.html

//eclipse 中如何创建一个maven项目
http://www.cnblogs.com/xing901022/p/4170248.html


Maven是一个用于 项目构建的工具
通过它便捷的管理项目项目的jar包依赖,开发,测试,发布打包

jar包依赖

　　这个也许会maven最突出的特点了使用maven不需要上网单独下载jar包,只需要在配置文件pom.xml中配置
jar包的依赖关系,就可以自动的下载jar包到我们的项目中.这样,别人开发或者使用这个工程时,不需要来回
的拷贝jar包,只需要复制这个pom.xml就可以自动的下载这些jar包.
　　而且,我们自己下载jar包,还有可能造成版本的不一致,这样在协同开发的过程中就有可能造成代码运行
的不一致.通过使用maven精确的匹配jar包,就不会出现这种问题了.


Maven通过xml格式,来标示唯一jar包
<dependency>
	<groupId>com.test</groupId>
	<artifactId>maventest</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>
<dependency>
	
上面最后生成的:mavensest-0.0.1-SNAPSHOT.jar

maven工程是什么样子的？

maven的工程一般都是如下的结构:
first_maven  
|-- pom.xml  
`-- src  
    |-- main  
    |   |-- java  
    |   |   `-- com  
    |   |       `-- test  
    |   |           `-- App.java  
    |   `-- resources  
    |       `-- META-INF  
    |           `-- application.properties  
    `-- test  
        `-- java  
            `-- com  
                `-- test  
                    `-- AppTest.java  
--------------
eclipse 中点击运行 Maven Build 然后在goals 中输入(相当与cmd的mvn命令):
clean //删除target 下面的全部文件
compile //编译,会target 下生成一些文件
test //测试
package // 会先编译再test再打包
install //和直接在外面点击install效果一样,比complie多生成jar包


什么是POM？
POM是项目对象模型(Project Object Model)的简称,它是Maven项目中的文件,使用XML表示,名称叫做pom.xml.

作用:
1,依赖管理,jar包,工程之间的依赖
2,项目构建.实现项目的一步构建
3,工程聚合,继承,依赖.

------------------------
maven jar版本冲突,解决有2个原则:
1,短路优先(使用离我最近的依赖)
2,先声明,就使用哪个(使用pom文件中靠前的)
-------------------------
<!--一般由3个数表示;第一个0大版本号,第二个0表示分支版本号,第三个0表示小版本号
snapshot 快照,alpha 内部测试,beta 公测,Release 稳定,GA 正式发布  -->
<version>0.0.1-SNAPSHOT</version>
-----------------------

maven 的工程类型:
1,war 包工程 (web项目)
2,jar 包工程(java)
3,pom 工程(聚合)
-------------------------------
无论是 svn 还是 git 的工作流,都是在本地解决冲突再提交,而不是在提交时解决冲突的.所以:

svn 的模式是:
1,写代码.
3,从服务器拉回服务器的当前版本库,并解决服务器版本库与本地代码的冲突.
5,将本地代码提交到服务器.

分布式版本管理的模式是:
1,写代码.
2,提交到本地版本库.
3,从服务器拉回服务器的当前版本库,并解决服务器版本库与本地代码的冲突.
4,将远程库与本地代码合并结果提交到本地版本库.
5,将本地版本库推到服务器.

所以,分布式版本管理仅仅是增加了本地库这个概念(这样加快了所有操作的速度),
其余的概念与集中管理并无区别.

----------------------------------------
mvn archetype:create :创建 Maven 项目
mvn compile :编译源代码(编译到target文件夹中)
mvn test-compile :编译测试代码
mvn test : 运行应用程序中的单元测试
mvn site : 生成项目相关信息的网站
mvn clean :清除目标目录中的生成结果(把默认target文件夹中的数据清理)
mvn package : 项目打包
mvn install :将打包好的包安装到本地仓库中,以使其塔项目能够调用
mvn eclipse:eclipse :生成 Eclipse 项目文件
mvn -Dmaven.test.skip=true : 忽略测试文档编译
cargo:deploy    :部署到私有服务器上

当然这些命令可以一起使用比如下
	打jar包并且安装到别的应用  clean compile package install  (清理,编译,打包,安装jar)
	打war包并部署  clean compile package cargo:deploy(清理,编译,打包,安装war)	 
---------------------------------------
创建maven Web项目时出错:

给你个创建java web项目的指令；
mvn archetype:create -DgroupId=easitech.test -DartifactId=test-all -DarchetypeArtifactId=maven-archetype-webapp    

groupId:项目属于哪一个组；一般是公司名+项目名
DartifactId:定义当前Maven项目在组中唯一的ID(即是你的项目名)
-DarchetypeArtifactId=maven-archetype-webapp    代表创建的是一个web项目 
----------------------------------------------

如果你是maven项目,tomcat在发布项目的时候没有同时发布maven依赖所添加的jar包, 
你需要设置一下eclipse: 项目 —> 属性 -> Deployment Assembly -> Add -> Java Build Path Entries -> 
选择Maven Dependencies -> Finish -> OK 把对应的Maven依赖包也发布到tomcat

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

GRABLE(gradle)
是项目自动化构建工具
//简单明了实用的讲解gradle(推荐)
http://www.cnblogs.com/woms/p/7040771.html
//官网(页面翻译后,还是有很多问题)
https://docs.gradle.org/current/userguide/tutorial_using_tasks.html

可以帮助我们:项目jar依赖管理,测试,打包,发布4个主要功能

目前主流的:
ant :编译,测试,打包
maven : 依赖管理,发布
grable : 不在使用xml形式管理构建脚本;


安装: 
1,官网下载,依赖jdk
验证java -version
2,解压
3,配置环境变量:GRADLE_HOME
4,添加到path: %GRADLE_HOME%\bin;
5,验证 grable -v
-------------------------


window 下 使用gradle 

1，下载解压
2,配置环境变量（百度）
3，检查是否配置成功
4，gradle是通过groovy实现的，底层就是java；所以需要了解groovy 和Java的区别
5，在idea中创建一个gradle项目来感觉一下groovy 的特性
6，去github下载我的项目看看实例
7，gradle构建中的两个基本概念是项目（project）和任务（task）每个构建至少包含一个项目，项目中包含一个或多个任务（也可以没有）；
在多项目构建中，一个项目可以依赖其它项目；任务也是；



+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Linux
注意下面演示使用的Ctenos6.3版本;
Linux(1994年问世)
继承与unix(1973年样子)百分之70命令一样.
特点:
1,免费/开源
2,支持多线程/多用户
3,安全性好(因为开源,一旦bug网络雷锋会帮修复)
4,对内存和文件管理优越(linux最小只需要4M)
5,linux 中一切皆文件,包括硬件,用户等(windows不一样)
6,linux不靠扩展名区别文件类型,只靠权限来管理
但 我们一般约定:
压缩包 :.gz,.bz2,tar.bz2,.tgz等
*.rpm（Red-Hat Package Manager）
~~~~~~~~~~~~~~~~~~
网页文件:.html,.php
脚本文件: .sh
配置文件: .conf
有了约定我们更方便的使用而已.

7,windows下的程序不能直接在linux中直接安装和运行(这样更为安全)

查看链接对应服务器是什么:  www.netcraft.com
+++++++++++++++++++++++++++++++++++++++++++++++++++

格式化的作用是写入文件系统(FAT16,FAT32,NTFS,Ext2,Ext3,Ext4),
写入文件系统时,会对硬盘重新进行分块(默认一个块是4kb),这样就会清空磁盘中的数据,同时会有一部分块记录着磁盘其他块的Id号,
数据写入不一定是连续块中,而是一个通过一串id号把数据窜接起来的;

+++++++++++++++++++++++++++++++++++++++++++++++++++
分区设备文件名
首先linux 一切皆文件,硬件能使用也必须要有一个文件名(文件名不要使用中文)和它对应
linux所有硬件文件名都放在/dev/下
如:
/dev/hda1 -- ide硬盘hd开头,a标识第一个硬盘,1表示第一个分区
/dev/sdb1 -- SCSI,SATA; sd标识这种接口的硬盘 sata比scsi快,b是第二块硬盘
+++++++++++++++++++++++++++++++++++++++++++++++++++
挂载:

挂载如同windown系统中的盘符(C,D,E)

linux 分区必须挂载后才可以使用,挂载就把分区挂载一个目录或文件下(任何目录或文件),
挂在哪个目录(或文件)下的哪个位置就叫挂载点;
+++++++++++++++++++++++++++++++++++++++++++++++++++
分区的作用就是方便管理,主要作用就是这个其中一个分区写满了,不会影响其他分区,这点很重要

必须分区:
/ 根分区 (分了其他分区大小后全部容量都给它)
swap 分区 (交换分区,内存小于4G是内存2倍,大于则等于内存大小),作用是虚拟内存;
推荐分区:
/boot (启动分区,200MB),分了后好处是:/分区就算写满了,也不会影响启动;
+++++++++++++++++++++++++++++++++++++++++++++++++++

linux 的最高层/目录,其他所有目录都在它之下,但并不是所有的目录都在一块硬盘下;
/home 我们可以设置它的挂载点/dev/sda2
/boot 我们可以设置它的挂载点/dev/sdb1
上面2个目录在一个在a硬盘第二分区中,一个在b硬盘的第一分区中;
/dev/sdb2 :sd表示sata或scsi(老式服务器接口,速度大概在200每秒)接口的硬盘,b表示第二个硬盘,2表示第二个分区
---------------
分区 :把硬盘分为小的逻辑分区
分区设备文件名:给每个分区定义设备文件名
挂载:给每个分区分配挂载点(把盘符和分区连接起来)
挂载点就是挂在那个文件或目录的位置；(相当于windows中的盘符)
-------------------------------
初始化安装后linux就会生成这3个文件:
安装日志:
/root/install.log:存储了安装在系统中的软件包及其版本信息；
/root/install.log.syslog:存储了安装过程中留下的事件记录；
/root/anaconda-ks.cfg:以Kickstart配置文件的格式记录安装过程中设置的选项信息.(批量安装使用它)

--------------------------------------------
一,linux的基本格式
[root@localhost ~]# 详情
root : 当前登录的用户名
localhost: 主机名
~: 代表我当前所在的目录(家目录) 提示:可以输入pwd看到当前所在目录

#: 超级用户提示符
$: 普通用户的提示符

root 目录是root用户的家目录,普通用户的家目录是home; root不是根目录
-------------------
命令格式:

命令 [选项] [参数]
多个选项或多个参数可以写在一起
注意:个别命令使用不遵循这个原则,极少;

如: 
ls [选项] [文件目录]
选项: 
-a 显示所有的文件,包括影藏的(以.开头一般为系统文件,不是为了让人看不见)
-l 显示详细信息
-d 查看目录属性
-h 人性化显示文件大小
-i 显示inode
如果我们没有选择文件目录就是当前的文件目录

在输入ls后我们可以看见如:
-rw-r--r--.
drwxr-xr-x.
等这样的文件,一共是10位,第一位为权限,后面的每3位为一组
linux中没有文件后缀名,用第一位来作为权限,来区分文件,有7种:
我们需要掌握的就3种:-文件,d目录,l软链接文件
后面3位一组 :
rw-                       r--                    r--       
前3位为所有者(主人);中间3位所属组(分配一些人);最后3位为其他人(其他)
r读w写x执行

用户登录使用su- 切换管理员身份


shutdown -h now 关机
shutdown -r now 重启
reboot 重启
logout 用户注销
ls 显示文件
ls -l 显示文件的详细信息
-a 显示影藏文件 -l 显示长列表格式 ....其实有很多很多需要网上查;支持 组合 -al 

没有消息就是最好的消息,好事不出门,坏事传千里
cd 就是切换目录的
cd / 到根目录
dir 和is一样都可以显示当前目录
pwd 显示当前在哪个目录下
useradd 添加用户
passwd 设置密码 ,注意后面要是不写用户名,就是给当前用户设置.
userdel xiaoming 删除但保留文件夹
userdel -r xiaoming 删除及用户的文件夹(目录)
vi 编辑文件内容
cat 查看文件内容
wq 保存
cp a.out /home/xiaoming/ 复制a.out到后面这个目录
tab 可以补全代码
more 可以分页显示 
ls l /est/ | more
在linux 和unix 系统中 | 就是管道命令; 那上一个命令的结果交给 | 的后面的命令处理

grep -n "shunping" aaa.java 在aaa文件中 查找有没有shunping这个字符串 有提示在第几行
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
find  /root/ -name aaa.java 在root 下查名字 叫aaa.java 的文件
ls -l > a.txt 列表的内容写入到a.txt 中(没有自动创建,有覆盖)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
>> 是追加


++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++
linux 的权限机制到底是怎么回事?
http://blog.csdn.net/vvcumt/article/details/38534379

Linux下权限有三种，用户权限，组权限，其他用户。
可以使用ls -l filename 会列出改文件的权限。
分别用rwx表示读，写和可执行三种权限，
一个文件从左至右依次用这三个符合表示上面所说相对应的权限。
比如-rwx-rw-r--代表用户有读，写和可执行，组有读和写权限;其他只有读

3个为一组,刚好3组对应上面的用户,组,其他;
一个文件被谁创建,那个用户就拥有用户权限;
我们可以通过修改文件权限,来完成对某些用户进行屏蔽,因为另一个用户属于其他用户
(对应上面的其他用户),当然我们可以让那个用户拥有和当前创建用户的组权限,从而达到
让其他用户也可以操作这个文件;多个用户可以来至一个组;


可以使用chmod filename 改变文件的权限。
可以使用chown filename 改变文件所属的用户和组
++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++


Linux 上到底如何创建一个用户?

http://www.runoob.com/linux/linux-user-manage.html 
添加一个用户
useradd –d /usr/huang -m huang--新增一个huang的用户,自动创建目录;指定了该用户的家目录
把这个用户添加到一个组里
groupadd huang -- huang是组名

新建的用户,不修改密码是不能使用的
passwd huang -- 修改huang这个用户的密码

可能还使用了useradd -s huang;
经过了上面几步操作后,是远程可以使用这个用户登录的;且可以使用su huang 切换的
++++++++++++++++++++++++++++++++++++++++++
第二种方式:
groupadd users
建立一个新用户账户testuser1,并设置UID为544(1-500系统保留),
主目录为/usr/testuser1,属于users组：
代码如下
useradd -u 544 -d /usr/testuser1  -g users -m  testuser1
然后记得修改密码
++++++++++++++++++++++++++++++++++++++++++
chmod 777 用户名 //修改这个文件用户权限
chmod 777 文件名  //修改文件权限
777分别表示user,group及other的权限r=4，w=2，x=1

cat /etc/group //查看 linux中所有的组
cat /etc/passwd //查看linux 中所有用户信息
source /etc/group //刷新这个文件
----------------------------
linux 如果对某个用户的某个文件进行权限管理:
http://blog.csdn.net/qwq_qaq/article/details/54882203

setfacl -x u:userA -R /   #删除userA的所有权限
setfacl -m u:userA:rwx /dir1  #赋予userA对dir1的读写执行权限
setfacl -m u:userB:rwx /dir1  #赋予userB对dir1的rwx权限，
同理可以设置userB C D对dir2，3，4等等其它目录的权限
----------------------------------
-R : 递归设置子目录下的权限
setfacl -x u:username dir/file #删除用户的权限
setfacl -x g:groupname dir/file #删除组的权限
setfacl -b dir/file  #删除该目录的全部acl权限

------------------------------
# 安装yum包
yum install <package_name>
# 卸载yum包
yum remove <package_name>
# 安装rpm包
rpm -ivh <package_name>
# 卸载rpm包
rpm -e <package_name>
---------------------------
文件处理命令:
#创建目录:

创建目录: mkdir hjf; 创建多层目录:mkdir -p  hjf/ju/fei
创建文件: touch huang.txt //创建huang.txt一个文件
切换目录 : cd 路径;
可以通过cd ../或cd /root/或cd ~或cd 回到根目录
切换到上一次操作的目录 : cd -
切换到上一级目录 : cd ..
清屏快捷键: ctr + l;
命令补全(忘记单词怎么拼全):ip 按两下tab键会自动提示全部关于ip开头的命名
pwd : 打印当前工作目录 ping word directory 的简写

#删除目录 :

rmdir :只能删除空目录(极少使用),且只能删除目录;
rm (remove): 删除文件; rm -r :删除目录; rm -rf :删除目录且不询问;
使用特别小心,删除后找不回; 
rm -rf / 非常危险,相当删除c磁盘;
 
#复制命令: cp
 
-r :赋值目录
-p : 连带文件属性复制
-d : 若源文件是连接文件,则复制连接属性
-a : 相当于pdr
#举例
cp -a install.zip /opt 
#将当前文件的install.zip 文件复制到根目录下的opt目录下;


#剪切改名:
mv : 就算移动目录也不需要 -r参数
对于改名 : mv test.log  newTest.log ,如果剪切都是在同一个目录下就是改名


#链接命令:
ln :硬链接
ln -s :软链接(推荐)
硬链接特征 :
1,拥有相同i节点和存储block块,可以看做为同一个文件
2,只能通过i节点识别(可以理解为指针值);ls -i可以看到i节点
3,不能跨分区
4,不能针对目录使用

举例:
[root@localhost huang]# ls -il
总用量 56
267498 -rw-r--r--. 2 root root 24772 10月 16 2016 install.log
267498 -rw-r--r--. 2 root root 24772 10月 16 2016 newInstall.log

2 表示链接数; 267498 i节点号

软链接特征:
1,和windows快捷方式一样;使用使用创建软链接一定要写绝对路径
2,可以跨分区

[root@localhost ju]# ll -i
总用量 28
276265 -rw-r--r--. 2 root root 24788 4月  23 06:18 newInstall.log
276236 lrwxrwxrwx. 1 root root    14 4月  23 06:26 one.log -> newInstall.log

软链接以l开头, 且后面会指向源文件; i节点值和源文件不一样
-------------------------------
linux 环境变量

[root@huangjufei-Linux ~]# lll
-bash: lll: command not found -- 没有找到这个变量;linux去环境变量中逐个查找,如果都没找到就报错


[root@huangjufei-Linux ~]# echo $PATH -- 输出环境变量;
/usr/local/sbin:/usr/local/bin:/sbin:/bin:/usr/sbin:/usr/bin:/root/bin

结论: 
所以我们自己安装的程序,需要到绝对路径下去执行;不然我们需要配置环境变量;
--------------------------------
#搜索功能:

1,locate :特点:数度快,只能按文件名搜索;不是实时更新(默认1天更新一次);
举例:
[root@huangjufei-Linux ~]# updatedb --手动强制更新
[root@huangjufei-Linux ~]# locate install.log.syslog 
/root/install.log.syslog

了解:搜索功能和一个/etc/updatedb.conf 配置文件密切相关;比如很多目录下不搜如:/temp,或很多后缀名不搜;


2,whereis :搜索命令搜索;
举例:
[root@localhost tmp]# whereis ls
ls: /bin/ls /usr/share/man/man1p/ls.1p.gz /usr/share/man/man1/ls.1.gz

后面是帮助文档所在位置;
whereis -b;不查看帮助文档位置 ;whereis -m;只查看帮助文档位置

[root@localhost tmp]# whatis ls --告诉你这个命令的作用
ls                   (1)  - list directory contents
ls                   (1p)  - list directory contents

3,which 搜索命令搜索;,可以查看到命令的别名;和whereis类似;
另 比如:liunx中@path来指定环境变量 和windows一样;
比如cmd 中执行mysql会在环境变量去找,找不到就报没有发现该命令!


4,find 非常,非常强大;参数多;
find [搜索范围] [搜索条件]
举例 : 
[root@huangjufei-Linux ~]# find / -name install.log -- 在根路径开始按 名字 搜索 install.log这个文件;
/root/install.log
--------------------------------------
通过*搜索
[root@huangjufei-Linux ~]# find /root -name "install.log*" --通过/root缩小范围,我们还可以使用通配符;*任意;注意引号抱起来
/root/install.log.syslog
/root/install.log
--------------------------------------
通过?号匹配一个任意字符
[root@huangjufei-Linux usr]# touch adaa -- 创建一个文件名字叫adaa
[root@huangjufei-Linux usr]# ls -- 我创建了adaa,adb,adc 这样3个文件
adaa  adb  adc  bin  etc  games  include  lib  libexec  local  sbin  share  src  tmp
[root@huangjufei-Linux usr]# find /usr -name "ad?" -- 通过?号只匹配ad后面一个字母,adaa这个就是搜索不出来的
/usr/share/locale/ada
/usr/share/locale/ady
/usr/adb
/usr/adc
--------------------------------------
通过[],更为精确的搜索
[root@huangjufei-Linux usr]# find /usr -name "ad[a,b]" -- 只会匹配一个字母所以 adaa也是搜索不出来的;ady也是不会搜出来的
/usr/share/locale/ada
/usr/adb
---------------------------------------
[root@huangjufei-Linux usr]# find /usr -name "*aa" -- 常用,以aa结尾的文件;
/usr/share/locale/paa
/usr/adaa
---------------------------------------
-iname 不区分大小写;
find /root -user root;按照所有者搜索
find /root -nouser; 查到没有所有者的文件(即为垃圾文件);但proc和sys和内存相关的文件夹内容不要删除;
----------------------------------------

搜时间(了解):
find /var/log/ -mtime +10;查找10天前修改的文件;
atime 文件访问时间;ctime改变文件属性时间; mtime 修改文件内容;
-10 天内修改的文件;
10 10天当前修改的文件;

按文件大小(搜)(了解):
find /root -size 25k ;在root目录下搜索25M:注意大写,k是小写M是大写

还支持and,or(了解) 
find /etc -size +20k -a -size -50k;查找大于20且小于50k的文件;+是大于-是小于
o 是或;
但上面查出来看不到文件的大小,我们还用通过ls - lh 查看;所有我们可以使用下面语句:
find /etc -size +20k -a -size +50k -exec ls -lh {} \;
find -inum -exec rm -rf {} \; 找到后直接删除;
说明:-exec 相当于前面语句结果后的第二条语句;十分强大;


按i节点(就是文件id号)搜索(了解):
举例:
[root@huangjufei-Linux usr]# ls -i -- 查看i节点值
138176 adaa  138175 adc  131082 etc    131084 include  131095 libexec  131128 sbin   131682 src
138155 adb   131081 bin  131083 games  131085 lib      131096 local    131076 share  131685 tmp
[root@huangjufei-Linux usr]# find /usr -inum 138176 -- 按i节点搜索
/usr/adaa
--------------------------
搜索文件里的内容:
举例:
[root@huangjufei-Linux ~]# grep -i "attr-2*" install.log -- 在install.log这个文件中去查找attr-2的字符串;
Installing libattr-2.4.44-7.el6.i686
Installing attr-2.4.44-7.el6.i686
-----------------------
-i,不区分大小写 ; -v 就是结果取反;不支持通配符,需要正则表达式;
--------------------------------
ps -le|grep java -- 查看全部进程,再通过管道符给grep,再找出有java的记录,我们常用来查tomcat
rpm -qal |grep mysql 查看mysql所有安装包的文件存储位置
--------------------------
#帮助命令:
man (manual手册,指南的简写)
man ls;
man -f 相当于 whatis 命令;查看命令有哪些等级;
举例:
man -5 passwd;
man -4 null;
man -8 ifconfig;
默认打印等级1;一共有9个等级

#其他帮助:
ls --help 在xshell上可以看到中文帮助;
如何查看一个命令是内置命令还是后面添加的?
可以通过whereis 命令 如果有路径就是后来添加的;
如whereis ls 在/bin/ls 下而 whereis cd 看不到说明cd是shell内部命令;
shell就是壳和内核交互的软件;可以把字母命令翻译为2进制机器语言;
这时就有一个help cd 专门查看内部命令帮助文档; man 是看不到内部命令的帮助文档的;


详细帮组命令info(太详细不推荐,推荐man或 ls --help):
- 回车: 在进入帮助页面带*号标记处回车
-u :进入上层页面
-n :进入下一个帮组小节
-q :退出
---------------------------------------

#压缩和解压
zip格式可以在windows和linux上可以交互转换
#压缩文件格式(压解文件名需要跟上对应的压缩后缀,好维护):
zip 压缩文件名 源文件

#压缩目录格式:
zip -r 压缩文件名 源目录

#解压缩格式
unzip 文件名/或文件夹名


.gzip格式
#文件格式: 
gzip 源文件
注意:gzip压缩后源文件会消失;
#文件夹格式:
gzip -r 目录
注意:只会压缩子目录中,顶级没压缩
#我们可以通过这种复制方式来保留原文件(一般不用)
gzip -c 源文件 > 压缩文件

#解压
gzip -d 被压缩的文件名
gunzip 压缩的文件名

.bz2格式(不能压缩目录):
格式:
bzip2 源文件 #默认不保留源文件
bzip2 -k 源文件 保留源文件

#解压
bzip2 -d 压缩文件
bunzip2 -k 保留压缩文件


#打包命令tar
tar -cvf 打包文件名 源文件
-c : 打包
-v : 显示过程
-f : 指定打包后的文件名
#上面的.gzip和bzip2对目录的压缩都不友好,这时我们可以通过先tar才压缩;

#解压
tar -xvf 源tar包名;


注意:tar支持一次性打包并压缩;
j :对应的 bzip2 格式
z :对应的 gzip格式

tar -jcvf 新的文件名.tar.bzip2 源文件
tar -zcvf 新的文件名.tar.gzip 源文件

同时对多个文件压缩且到指定目录下举例:
tar -zcvf /opt/新的文件名.tar.gzip 源文件1 源文件2

#解压:
tar -jxvf 文件名.tar.bzip2
tar -zxvf 文件名.tar.gzip
#还可以指定压解路径
tar -zxvf 文件名.tar.gzip -C /opt 
通过-C 指定目录

-------------------------------------------
#开关机:
服务器最好不要高峰期关机;
shutdown [选项] 时间
-c :取消前一个关机命令
-h :关机
-r :重启

另外还有几个关机和重启命令,但没有shutdown安全
系统运行级别:
0关机;
1单用户;(和window中的安全模式)
2不完全多用户,不含nfs服务;
3完成多用户;(默认就是)
4未分配;
5图形界面;
6重启

使用:
init 0 就是关机;
init 6 就是重启;

可以通过runlevel查看当前的运行级别

#cat 命令查看文件内容,下面是查看当前用户启动时使用什么级别;
如果想启动默认到图形界面就修改配置文件中的值;但千万不要写0和6
cat /etc/inittab 

linux默认允许远程用户是256个,最大可以6W多个


#退出登录用户(好习惯)
logout

----------------------------------------
#挂载
挂载就是分配盘符,必须分配盘符后才可以使用;windows只是自动的;
#查看系统中已经挂载的设备
mount 
#依据配置文件/etc/fstab的内容,自动挂载
mount -a
--------------
#查看系统中登录了那些用户
w
jcpu :指和终端连接所有进程占用时间
pcpu : 当前进程占用时间;
what :当前运行的命令

#who 比w查看的功能少

#查看历史登录的用户,可以看到有黑客来过没
last

#查看所有用户的最后一次登录的时间
lastlog 

#查看当前使用的sell
echo $SHELL

linux(sh,ksh,bash,psh,zsh主要是bash)和unix(csh,tcsh)不同在与shell不同,但很多相通

-----------------------
#输出语句
echo 
#输出 hell回车o
echo -e "hell\no" 
使用 -e 支持转义;支持ASCII码
如 : echo -e "\x68" 输出 h字母

--------------------------
liunx的第一个脚本
vim hello.sh
#!/bin/bash
#注释 :这是我的第一个shell脚本
echo -e "\e[1m;36m 天上掉下个林妹妹 \e[0m"

调用:
bash hello.sh

赋予执行权限,直接运行
chmod 775 hello.sh
./hello.sh
通过
---------------
查看系统中以有的别名
alias 

#自定义别名(但只是写到内存中,如果长期要写到环境变量中)
alias lll='ls -lh --color=auto'

#写入环境变量配置文件
vi ~/.bashrc 

#删除别名
unalias

#不用重启让配置文件直接生效
source bashrc

#清屏
clear
ctrl + u 删除到首行
ctrl + z 把命令放入后台(不要随便用)
ctrl + a 光标移动到首行
ctrl + e 光标移动到尾行
ctrl + c 强制终止当前命令
-------------------------------------
#查看历史命令
history
保存在在家目录下 ls -a .bash_history可以看到这个文件,文件中的命令没有直接
使用history看到的全;
history -w 缓存和文件同步
history -c 清除历史操作

-----------------------
#查看文件
vi
vim --升级版
cat 
more 查看文件
tail -n 50 catalina.out -- 查看最后50行
-------------------------------------
#输出重定向(把本身输出到显示器重定向到文件中)

#会覆盖原有的
命令 > 文件 
#追加
命令 >> 文件

#会覆盖原有的错误的信息(注意没有空格)
命令 2>文件 
#追加错误(注意没有空格)
命令 2>>文件
sd 
#正常和错误都写到文件中
命令 >> 文件名 2>&1

#还有简洁的(推荐)
命令 &>>文件

#正确和错误分开存放(推荐)
命令>>文件1 2>>文件2

------------------
可以用来判断执行语句到底正确执行没
sdfs && echo yes || echo no

管道符
# |号前面的作为后面执行的对象;注意的后面的命令必须能操作命令1;
ls -l /etc | more 
#查看有哪些用户连接到linux上
netstat -an | grep ESTABLISHED
# 统计linux 上的在线人数
netstat -an | grep established | wc -l

established [??'st??bl????t] 确定的
+++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++


linux 只有两种包:
1,源码包,
2,rpm(二进制包);原Red Hat Package Manager，现在是一个递归缩写

概念区别:
源码包开源的,免费的,可以自定义安装,效率高;
rpm是经过编译的,安装简单,数度快,可能收费

安装后的的区别:
源码包和rpm包最大区别:安装位置不同；rpm包不建议指定安装位置,安装目录到处都是；
源码包建议安装目录:/user/local/软件名,没有卸载命令,直接删除安装目录


#RPM安装(因为太麻烦一般通过yum自动安装)
rpm -ivh 包全名
选项:
-i (install) 安装
-v (verbose) 显示详细信息
-h (hash) 显示进度
-- nodeps 不检测依赖性(骗自己)

-q 查询
-p 查询未安装包的信息
-i 查询软件信息
#RPM包升级
rpm -Uvh 包全名
-U (upgrade) 升级
#RRM包卸载
rpm -e 包全名
#rmp 查询是否安装了包
rpm -q 包名
#查系统中安装了java没(是否使用rpm安装过)
rpm -qa | grep java 
#查询一个文件属于哪个包(但必须确实存在)
rpm -qf abc.conf
举例(记得使用绝对路径):
rpm -qf /bin/ls 
#检测文件 是否被修改(没有修改不会有提示)
rpm -V httped -- 这个命令一般是下载后立即使用,判断是否被人动了手脚
#如果linux下某个命令被删除了,可以通过源包中只提取需要的那个命令

rpm2cpio 包全名 | cpio -idv .文件绝对路径
举例:
rpm2cpio /mnt/cdrom/Packages/coreutils-8.4-19.e16.i686.rpm | cpio -idv ./bin/ls

--------------------------------------------
yum 在线安装,作用为了解决rpm依赖性
缺点 :redhat要收费,centos不收费

------------------------------
yum 源文件位置(常用)
vi /etc/yum.repos.d/CentOs-Base.repo
现在来看看里面内容的基本含义:
[base] : 容器名称一定要放在[]中
name : 容器说明,随便写
mirrorlist :镜像站点
baseurl : 我们的yum源服务器地址.默认是CentOs官方的yum源服务器,
可以使用;但你要是觉得慢,可以改为你喜欢的yum源地址 百度:国内yum源的安装(163，阿里云，epel)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
enabled : 此容器是否生效,默认不写为生效;enable=0就是不生效;
gpgcheck : 如果是1指rpm数字证书生效,0不生效;
gppkey : 数字证书公钥文件保存位置.
---------------------------------
yum 在线安装,需要有网络,如果没有网yum 提供了光盘本地安装(了解)


#本地光盘就是这个linux安装光盘
G:\BaiduYunDownload\CentOS-6.3-i386-bin-DVD1.iso

1,挂载光盘
mount /dev/sr0 /mnt/cdrom


2,断开默认配置文件网络连接(使用本地光盘),可以修改配置文件enable=0;
但这种方式麻烦,可以使用修改文件名
mv CentOS-Base.repo CentOS-Base.repo.bak
#修改文件后缀,使其失效

3,让光盘的生效
vi /etc/yum.repos.d/CentOS-Media.repo
#进到光盘文件中,修改为:
name=CentOS-$releasever - Media
baseurl=file:///mnt/cdrom/
#        file:///media/cdrom/
#       file:///media/cdrecorder/
gpgcheck=1
enabled=1

#完成后使用
yum list
#看到使用的c6-media结尾的说明使用的本地光盘

优点: 安全性高,效率高,不需要网络
缺点: 版本旧;
--------------------------------------
#yum list 查询所有可用的软件包列表
#yum search 关键字(如:httped) 搜索服务器上关键字包

#安装(常用)
yum -y install 包名(yum命令,列外不需要包全名)
选项
-install 安装
-y 自动回答yes
例如:yum -y install gcc

#升级(常用)
yum -y update httpd
但一般不要去升级,升级可能会让你停止服务;
yum -y update 
升级linux全部软件包,包含内核,可能洗白linux;不要用
yum -y upgrade 
升级所有包,不改变软件设置和系统设置,系统版本升级,内核不改变
------------------------
#卸载
yum -y remove 包名
也是慎用;
----------------------------
#yum 提供了组包安装

#查看有哪些组包(在xshell中看到全是中文,直接在linux上是英文)
yum grouplist 

通过在xshell 上设置查看语言
#临时使用中文查看
LANG=zh_CN.utf8
#临时使用英文查看
LANG=en_US

#安装组包,组名由grouplist查询出来
yum groupinstall 软件组名

举例:
yum groupinstall "Chinese Support" --安装中文支持的组包

#卸载组包
yum groupremove 组名
----------------------------
rpm 包的安装位置由作者指定,用户一般不指定;源码包则不一样

一般是下面的规则(现实由作者决定):
/etc/ 配置文件安装目录
/usr/bin/ 可执行的命令安装目录
/usr/lib/ 程序使用的函数库保存位置
/usr/share/doc/ 基本的软件使用手册保存位置
/usr/share/man/ 帮助文件保存位置


源码包我们一定要指定目录(方便删除):
一般放在/usr/local/软件名


由于安装位置的不同带来的影响:
rpm 包可以使用系统服务管理命令(service)来管理:
例如启动apache:
/etc/rc.d/init.d/httpd start
service httpd start
#service 其实是找的/etc/rc.d/init.d 这个;

源码包只能在源目录下去启动;但我们可以去init.d文件中去配置后是可以的;
-------------------------
如何上传文件到linux上?
可以使用winSCP ,xshell
一台linux上可以同时安装源码包和rpm包,但只能启动一个,因为端口会冲突;
+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++
Nginx
强大的Nginx服务器
Nginx主要功能2个:反向代理和负载均衡
反向代理和正向代理的区别就是：正向代理代理客户端，反向代理代理服务器。
一般来说apache是2000并发而nginx是5W,最少是3倍以上;
学习网站:
https://www.cnblogs.com/ysocean/p/9392908.html
https://www.runoob.com/w3cnote/nginx-setup-intro.html

Nginx配置文件目录:
/usr/local/nginx/conf/目录下的nginx.conf

Nginx相关命令：
查看是否运行: ps –ef|grep nginx 
启动命令：./usr/local/nginx/sbin/nginx 
重启命令：./usr/local/nginx/sbin/nginx -s reload
关闭命令：kill -9 nginx


下面是工作中的配置(不包含负载均衡):
#user  nobody;
# nginx的注释符
worker_processes  2;#允许生成的进程数，默认为1
error_log  logs/error.log  info; #制定日志路径，级别。这个设置可以放入全局块，http块，server块，级别以此为：debug|info|notice|warn|error|crit|alert|emerg
pid        logs/nginx.pid;#指定nginx进程运行文件存放地址


# 上面是全局块;共有:全局,events,http,server,location(5块)
events {
    use epoll;#事件驱动模型，select|poll|kqueue|epoll|resig|/dev/poll|eventport
    worker_connections  1024; #最大连接数，默认为512
}

http {
    include mime.types;#文件扩展名与文件类型映射表
    default_type  application/octet-stream;#默认文件类型，默认为text/plain
    sendfile  on; #允许sendfile方式传输文件，默认为off，可以在http块，server块，location块。
    keepalive_timeout  65; #连接超时时间，默认为75s，可以在http，server，location块。

    #http 里面可以包含多个server块,一个server块里可以有多个location块
    server {
        listen 80;#监听端口
        server_name localhost; #监听地址


        location / {
            root   html;
            index  index.html index.htm;
        }

		#金猪贷,正则匹配，~为区分大小写，~*为不区分大小写;^~ 在请求字符串匹配度最高的location后立即使用此 location 处理请求,不在找其他正则location
		location ^~ /moblie/ {
			proxy_pass http://59.110.173.50:8899/moblie/;
		}
	
		#招财收量系统
		location ^~ /yield/ {
					client_max_body_size  500m;
					proxy_set_header Host $host;
					proxy_set_header X-Real-IP $remote_addr;
					proxy_set_header REMOTE-HOST $remote_addr;
					proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
					proxy_pass http://47.92.38.162:8081/yield/;  #请求转向mysvr 定义的服务器列表
		}

        error_page   500 502 503 504  /50x.html; #错误页
		
        location = /50x.html {
            root   html;
        }

    }
}

+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++

linux 查看进程的常用3个命令:
ps aux --查看全部进程
ps -le --查看全部进程,PRI值cpu线程优先级,数值越低优先级越高
pstree -- 查看进程树
top	-- 查看linux的健康状态,默认按cpu使用率排序;主要看内存,swap,cpu 使用和空闲buffer(作用于写),cached(作用于读)

linux 杀死进程:

kill -9 PID -- 杀死单个(-9标识不管任何情况杀死该进程)
pkill -9 -t 终端号 -- 按照终端号剔除用户,不会提到自己
w -- 查看当前linux一共登录了那些用户,可以看到终端号
killall 进程名 -- 只要名字带这个进程名的全部杀死

+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++
和后台相关:
为什么需要在后台运行?
因为会挡住界面,不能输入其他命令,注意后台运行是绑定终端的,(每个登录用户都有一个终端),
反过来说你关闭终端也会关闭后台程序,注意;除mysql外;
jobs -l -- 查看后台运行的程序;

如何让程序在后台运行,直接在命令后面加&即可;不要把和用户交互命令在后台运行,如vi

举例2种方式:
top & -- 后台运行ls;后台运行
通过jobs -l查看在后台运行的程序
如: 
[root@huangjufei-Linux /]# jobs -l
[1]-  1599 Stopped (tty output)    top
Stoped 说明程序是关闭的,因为top属于用户交互命令;工作中可以使用cp 这种命令可以放后台使用

另 : 执行top 运行后再执行ctrl+z,只是让程序暂停在后台,并不是后台执行;这样久而久之
后台会卡住很多程序,导致系统很卡;不建议使用;

如何让后台程序再回到前台运行?
fg %工作号 -- 工作号可以jobs -l 看到如上面的1
bg %1 -- 恢复到后台运行,%是可以不要的


nohup 命令 & -- 前面讲到后台程序和终端是绑定的,nohup的作用就是不绑定终端,
这样就算关闭终端,程序依然在运行

但这样我们每次开机都要手动去执行,还有开机就直接执行的方法;
vi /etc/rc.local --编译这个文件

+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++


查看系统资源使用情况
vmstat 1 3 查看cpu,内存,磁盘使用情况;每秒执行一次,一共执行3次

dmesg | grep CPU -- 查看系统内核的一些信息

free -m -- 专门看内存使用情况的命令

查看内核信息,2.6.32就是内核版本号,内核版本被各个企业包装为各种发行版本;
我的就是centos6.3发行版本
[root@huangjufei-Linux ~]#  uname -a
Linux huangjufei-Linux 2.6.32-279.el6.i686 #1 SMP Fri Jun 22 10:59:55 UTC 2012 i686 i686 i386 GNU/Linux

查看操作系统的位数
[root@huangjufei-Linux ~]# file /bin/ls
/bin/ls: ELF 32-bit LSB executable, Intel 80386, version 1 (SYSV), dynamically linked (uses shared libs), for GNU/Linux 2.6.18, stripped

+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++

搭建java 服务器

一,安装jdk

1,下载jdk,记得和查看linux 是32还是64位
(2)下载完成后放到自定义的目录下面并解压:tar -xvf jdk-8u91-linux-x64.gz
(3)然后可以删掉下载的压缩包:rm -rf jdk-8u91-linux-x64.gz
(4)进入jdk目录,记下当前目录:pwd
(5)添加环境变量:vim /etc/profile
export JAVA_HOME=/usr/local/software/jdk/jdk1.8.0_131
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar 
#保存退出命令 
java -version
#查看jdk 安装好没

-------------------------------------------
二,然后安装tomcat,不分32位

直接压解就可以访问
http://192.168.1.105:8080/

三,linux下使用yum安装mysql
 http://blog.csdn.net/a695017449/article/details/37900131
1、安装
查看有没有安装过:
          yum list installed mysql*
          rpm -qa | grep mysql*
 
查看有没有安装包:
          yum list mysql*
 
安装mysql客户端:
          yum install mysql
 
安装mysql 服务器端:
          yum install mysql-server
 
          yum install mysql-devel
  www.2cto.com  
2、启动&&停止
 
数据库字符集设置
          mysql配置文件/etc/my.cnf中加入default-character-set=utf8
 
启动mysql服务:
          service mysqld start或者/etc/init.d/mysqld start
开机启动:
          chkconfig -add mysqld,查看开机启动设置是否成功chkconfig --list | grep mysql*
 
          mysqld             0:关闭    1:关闭    2:启用    3:启用    4:启用    5:启用    6:关闭
停止:
          service mysqld stop
2、登录
 
创建root管理员:
          mysqladmin -u root password 123456
  www.2cto.com  
登录:
          mysql -u root -p输入密码即可.
忘记密码:
          service mysqld stop
 
          mysqld_safe --user=root --skip-grant-tables
 
          mysql -u root
 
          use mysql
 
          update user set password=password("new_pass") where user="root";
 
          flush privileges;  
 
3、远程访问
 
开放防火墙的端口号
mysql增加权限:mysql库中的user表新增一条记录host为“%”,user为“root”.
4、Linux MySQL的几个重要目录
  www.2cto.com  
数据库目录
         /var/lib/mysql/
配置文件
         /usr/share /mysql(mysql.server命令及配置文件)
相关命令
         /usr/bin(mysqladmin mysqldump等命令)
启动脚本
         /etc/rc.d/init.d/(启动脚本文件MySQL的目录)
卸载mysql
yum -y remove mysql*
如果是rpm安装的话:
rpm -e mysql
-------------------navicat 连接权限错误提示1130------------
mysql -u root -p  
mysql;use mysql;  
mysql;select 'host' from user where user='root';  
mysql;update user set host = '%' where user ='root';  
mysql;flush privileges;  
mysql;select 'host'   from user where user='root'; 

------------------------------------------------------

如何查看liunx下桥接ip
1,首先确定连接必须设置为桥接的方式.
2,键入ifup eth0
3,重启一下系统或者过一段时间等系统更新
4,键入ifconfig 看到inet Address发生改变了,不在是127.0.0.1
5,再使用Xshell连接即可
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
linux 下 ifcfg-eth0 配置 

网络接口配置文件 [root@localhost ~]# cat /etc/sysconfig/network-scripts/ifcfg-eth0 
# Intel Corporation 82545EM Gigabit Ethernet Controller (Copper) 
TYPE=Ethernet #网卡类型 
DEVICE=eth0 #网卡接口名称 
ONBOOT=yes #系统启动时是否自动加载 
BOOTPROTO=static #启用地址协议 --static:静态协议 --bootp协议 --dhcp协议 
IPADDR=192.168.1.11 #网卡IP地址 
NETMASK=255.255.255.0 #网卡网络地址 
GATEWAY=192.168.1.1 #网卡网关地址 
DNS1=10.203.104.41 #网卡DNS地址 
HWADDR=00:0C:29:13:5D:74 #网卡设备MAC地址 
BROADCAST=192.168.1.255 #网卡广播地址 
重新导入ifcfg-eth0网络配置文件 
[root@localhost ~]# /etc/init.d/network reload 
Shutting down interface eth0: [ OK ] 
Shutting down loopback interface: [ OK ] 
Bringing up loopback interface: [ OK ] 
Bringing up interface eth0: [ OK ] 
网卡接口关闭与激活 
[root@localhost ~]# ifdown eth0 #关闭网络 
[root@localhost ~]# ifup eth0 #启动网络 
网络服务启动与关闭 
方法一: [root@localhost ~]# service network stop #关闭网络服务 
[root@localhost ~]# service network start #启动网络服务 
[root@localhost ~]# service network restart #重启网络服务 
方法二: [root@localhost ~]# /etc/init.d/network stop 
[root@localhost ~]# /etc/init.d/network start 
[root@localhost ~]# /etc/init.d/network restart 网卡状态查询 
[root@localhost ~]# service network status 
Configured devices: lo eth0 
Currently active devices: lo eth0 
临时配置网卡信息,无需重启. 
[root@localhost ~]# ifconfig eth0 10.1.1.10 netmask 255.0.0.0 
查看网卡接口信息,默认列出所有接口 
[root@localhost ~]# ifconfig 
eth0 Link encap:Ethernet HWaddr 00:0C:29:13:5D:74 
inet addr:192.168.1.11 Bcast:192.168.1.255 Mask:255.255.255.0 
inet6 addr: fe80::20c:29ff:fe13:5d74/64 Scope:Link 
UP BROADCAST RUNNING MULTICAST MTU:1500 Metric:1 
RX packets:413 errors:0 dropped:0 overruns:0 frame:0 
TX packets:572 errors:0 dropped:0 overruns:0 carrier:0 
collisions:0 txqueuelen:1000 RX bytes:47701 (46.5 KiB) 
TX bytes:64842 (63.3 KiB) Base address:0x2000
Memory:d8920000-d8940000 
lo 
Link encap:Local Loopback 
inet addr:127.0.0.1 
Mask:255.0.0.0 
inet6 addr: ::1/128 Scope:Host UP LOOPBACK RUNNING MTU:16436 Metric:1 
RX packets:407 errors:0 dropped:0 overruns:0 frame:0 
TX packets:407 errors:0 dropped:0 overruns:0 carrier:0 
collisions:0 txqueuelen:0 RX bytes:70759 (69.1 KiB) 
TX bytes:70759 (69.1 KiB) 
查看当前路由及网关信息 
[root@localhost ~]# netstat -r 
Kernel IP routing table 
Destination Gateway Genmask Flags MSS Window irtt Iface 
192.168.1.0 * 255.255.255.0 U 0 0 0 eth0 
169.254.0.0 * 255.255.0.0 U 0 0 0 eth0 default 192.168.1.1 0.0.0.0 UG 0 0 0 eth0

DNS:
主机名:CentOS
主DNS:202.106.46.151
第二DNS:202.106.0.20
第三DNS:8.8.8.8

网络配置:
eth0
静态ip:192.168.1.106
子网掩码        255.255.255.0
默认网关 IP     192.168.1.1


DEVICE=eth0
IPADDR=192.168.1.106
NETMASK=255.255.255.0
BROADCAST=192.168.1.255
ONBOOT=yes
BOOTPROTO=none
GATEWAY=192.168.1.1
TYPE=Ethernet
"/etc/sysconfig/network-scripts/ifcfg-eth0" 11L, 187C

--------------------------------------------------------------------------

linux 下配置jdk 环境变量:
vim /etc/profile

export JAVA_HOME=/usr/local/software/jdk/jdk1.8.0_131
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

让配置文件生效:
source /etc/profile

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
MD5 防篡改

数据库保存的是加密后的密码,
直接将页面来的密码经过加密后在和数据库进行比较
//String org.apache.commons.codec.digest.DigestUtils.md5Hex(String data)

// 2,设置要修改的属性(要使用MD5摘要)
String md5Digest = DigestUtils.md5Hex("1234");

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

权限:
	控制功能的使用

Web应用中的权限:
	每个功能都有相应URL地址.
	对功能的控制就是对URL地址的访问控制.

权限方案:
	用户 *----* 角色 *----* 权限
	用户拥有一个或多个角色(最好设计为一个角色),然后一个角色对应权限的集合;
	
	角色表: 主键id,用户主键id,权限主键id(可以说基本没什么用,只是关连用户和权限的中间表),
	但可以设置成用户表里有多个角色id的关连字段. 
	
	角色表中关连url
	
	权限 : 主键id,功能描述,url	
	
	总结: 可以是2层,可以是3层(可以解耦),最后都是使用用户id查是否拥访问的url的权限,所以在数据库中
必须有每一个id对应的url的集合.



+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

页面微信扫码支付流程(jiaxiao项目)

此接口:wechantpay

总结: 商家一些认证和微信接口URl和自己回调URl还有订单的一些信息,
以XML的方式发送给微信,微信返回XML,(比对信息是否被串改)里面带有可以转为2维码的参数.后台生
成2维码返回前端
,用户结算后,微信回调回调地址,修改订单表支付相关的一些状态.(其中可能包含XML和map的之
间的转换,一些加密解密,大写,排序,核对安全的一些操作)
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

如何将java web上线


1.在myeclipse中开发好项目,打包成war格式,不会的同学参考以下
http://zhidao.baidu.com/link?url=Gb0OV9pHiDtJr8nyjPrnSA65g49I4TEAn2N3pwXsxzVsCaX0gJ8RQZHQ2GmDrmdM0ltoBdCPYEtT1iSawcedcK

2.购买云服务器,建议去阿里云购买(ecs),教程如下
http://jingyan.baidu.com/article/4e5b3e195ae68a91901e2402.html
以上教程的最后一步远程连接不用看,下面再说远程连接的事,只需买到一个阿里云服务器就行了
注:解释一下什么是云服务器.就是另一台电脑,该电脑永不关机,永不断网.
3.登录你的阿里云服务器,以下是教程
购买linux系统的阿里云服务器:http://jingyan.baidu.com/article/84b4f565f3d99260f7da3271.html
购买windows(win2012为例)的阿里云服务器:http://www.imaoye.com/article/aliyunECS.html(该教程说的是远程连接的问题,但是登录包含在内,可不理会前两个图)
4.远程连接(以windows为例,因为windows相对比较适合新手)
http://jingyan.baidu.com/article/cd4c297914be1e756e6e60c3.html
5.配置java web环境(以windows为例,因为windows相对比较适合新手)
在你成功连接阿里云服务器后,windows系统有个图形界面,他已经有一个ie,你可以下载jdk,tomcat和mysql,然后安装和配置环境变量(安装就不说了,对学java web的同学太简单)期间你可能遇到一些问题,比如ie跟你电脑的ie不一样,服务器的ie收到安全的防护,很多东西(链接)都不能下载,这个没办法,只能一个一个试.
当然如果想偷懒,可以不下载,直接将你电脑的jdk,tomcat,mysql复制粘贴到服务器,没错！这就是远程连接的好处,可以直接操作(小编也不知道为什么)
注意:mysql数据库的数据可以自己再敲一遍,也可以从本地的mysql导出来,复制到服务器里面,再导进服务器的mysql.
6.发布项目
在你的本地电脑的浏览器打开,输入http://ip:8080/,其中http://是固定写法,ip为你买的阿里云服务器的外网ip,8080是你tomcat的端口号.回车,会看到tomcat的界面,其中有个tomcat Manager点以下,界面会提示输入你服务器t的omcat的用户和密码(在安装时会提示创建用户,没创建的卸载重装再创建,一定要有一个用户),输入后进入tomcat的另一个界面,点击一个“浏览”的按钮(该界面只有一个中文按钮),选中第一步的war文件,然后点击按钮下的“Deploy”按钮,几秒后,界面会刷新.
刷新后,你可以在任何有网络的电脑输入:http://ip:8080/application/.....(该url跟你在开发项目是的url是一样的,只是把localhost换成服务器的ip),就可以访问你的项目了.
7.此时,你可以访问,但是访问路径不像人家:www.baidu.com的酷,.com/.cn/.net/...的叫域名,你需要一个域名来代替你的http://ip:8080/......
7.1买域名,还在阿里云买.教程:http://jingyan.baidu.com/article/ab69b270dc91492ca7189f03.html
7.2域名备案.教程:http://jingyan.baidu.com/article/925f8cb8176a49c0dde056c6.html
7.3域名解析.教程:http://jingyan.baidu.com/article/676629973f96f454d51b849b.html
解析后就玩完了
8.至此,你就可以在有网络下访问你的网站(项目)


+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
idea 的常用快捷键
shift+ctrl+F 字符串搜索；find in path
ctrl+alt+shift+上下箭头 查看当前文件那些代码被改动了；previous change
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

base64
base64 主要功能不是加密(很容易被破解,几种包下base64加密得到一样的结果),
而是把 2进制数据 转为 普通字符,方便网络传输

//一个简单例子,说明:
BASE64Encoder encoder = new BASE64Encoder();//编码
String eS = encoder.encode("受到法律".getBytes());
BASE64Decoder decoder = new BASE64Decoder();//解码
try {
	byte[] bS = decoder.decodeBuffer(eS);
	String bs1 = new String(bS);
	System.out.println(eS);
	System.out.println(bs1);
} catch (IOException e) {
	e.printStackTrace();
}

@Test
public void base64(){
	//通过java.util.Base64包;加密
	byte[] en = Base64.getEncoder().encode("受到法律".getBytes());	
	System.out.println(new String(en));
	//通过java.util.Base64包;解密
	byte[] en2 =Base64.getDecoder().decode(en);
	System.out.println(new String(en2));
}
--------------------------------------

//把图片转为base64的字符串,但是没有压缩(字符串转图片方法和下面一样)
public static String getImgStr(String imgFile) {
	//将图片文件转化为字节数组字符串,并对其进行Base64编码处理
	InputStream in = null;
	byte[] data = null;
	//读取图片字节数组
	try {
		in = new FileInputStream(imgFile);
		data = new byte[in.available()];
		in.read(data);
		in.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	BASE64Encoder encoder = new BASE64Encoder();
	return encoder.encode(data);	
	//return new String(Base64.encodeBase64(data));
}

main{
//可能需要替换一下
 String s = getImgStr(“d:\\User\\Desktop\\ok.jpg”).replace(“\r\n”,””);
	s = “‘data:image/png;base64,+s+”’”;

}

-------------------------------

使用base64压缩图片看百度云盘之前端文件夹中有源码;

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



--------------------------------------------

http://www.cnblogs.com/lonelyxmas/p/5667557.html 这个的人博文很多

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

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

HESSIAN(了解)
hessian入门文章
http://www.cnblogs.com/yjmyzz/p/hessian-helloworld.html
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

你懂的
18580776548jl@lxj
http://www.llxinxi.com/
http://www.92belle.com/kanpian/ 

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

微信支付

首先微信支付就是调用微信的一个接口而已,使用xml格式传递参数而已.

微信支付分 :扫码支付和公共平台支付还有app支付

扫码支付 又有两种模式:
【模式一】:商户后台系统根据微信支付规则链接生成二维码,链接中带固定参数productid(可定义为产品标识或订单号).
用户扫码后,微信支付系统将productid和用户唯一标识(openid)回调商户后台系统(需要设置支付回调URL),
商户后台系统根据productid生成支付交易,最后微信支付系统发起用户支付流程.

【模式二】-- 驾校项目扫描就是用的模式二
商户后台系统调用微信支付【统一下单API】生成预付交易,将接口返回的链接生成二维码,用户扫码后输入密码完成支付交易.
注意:该模式的预付单有效期为2小时,过期后无法支付.

模式二与模式一相比,流程更为简单,不依赖设置的回调支付URL


公共平台支付就比扫码多了个openid参数.
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

JUNIT(百度云后台Junit项目)
(java unit)java单元,junit属于xunit下面的一部分还包含CUnit等.也称为白盒测试

1,测试方法必须使用@Test进行修饰
2,测试方法必须使用 public void 进行修饰,且不能带参数
3,测试单元的每个方法不能有任何依赖,必须独立
下面是几点建议:
1,测试方法最好放在test包下,最好和测试类的包名一致
2,测试类的以Test结尾
3,测试方法以test前缀开始
--------------------
测试只能证明断言是对的,不能代表的结果是对的.逻辑错误不能测试
---------------------
测试失败分为2种:
1,Error : 说明你的报错不是值对不上
2,failure : 说明现实值和断言值不一样
----------------------
常用的注解如:
@Test : 让一个普通方法变为测试方法
 @Test(expected=xxx.class) :测试方法中出现该异常不会报错
 @Test(timeout = 2000) :测试方法如果运行时间超过2000毫秒,报错
@BeforeClass : 所有方法运行前执行的方法(主要用于加载配置文件)且只运行一次,静态方法
@AfterClass : 所有方法运行完后执行的方法(主要用于释放资源)且只运行一次,静态方法
@before : 每个方法 前 都会执行的方法(公共代码可以放里面)
@after  : 每个方法 后 都会执行的方法(公共代码可以放里面)
@Ignore : 注解后不会执行该方法
@RunWith :可以更改测试运行器
-------------------------
@RunWith(Suite.class)
@Suite.SuiteClasses({ArithmeticTest.class,ProcessTest.class})
public class SuiteTest {
	/**
	 * 套件的作用:可以一次测试多个测试类
	 * 套件的使用:
	 * 1,修改测试运行器
	 * 2,多个测试类也数组的格式放入,该方法不能有其他方法
	 */
}
-----------------------------------------
junit4测试mybatis的Dao层的接口,还有其他至少2中更为简单的方式

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件(可能还要引入springmvc等配置文件)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringTestDemo extends TestCase {		
	//这里我们这个dao层和mapper.xml名字不对应是错误的.
	@Resource
	private SchoolDAO schoolDao;	
	@Test
	public void selectSchoolById() throws Exception{		
		School school = schoolDao.selectSchoolById("0683c7ead01646b09e4325291ca8c1ad");
		System.out.println(school);//成功打印
	}
}


+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


如何优化数据库:
1,适当的索引
2,有些可以使用存储过程
3,查出结果明确化,不用 select *
4,优化查询语句,将限定性强的where条件放前面
5,不要使用for循环得到一个连续的查询,使用in或or
6,对于数据上千万的表,可以分割多张表,如果要联合使用 union ;
如一个公司下有10家子公司都是使用这个表,分为10个,或按年按月建分表

7,使用redies 这样缓存机制,减少对数据库的访问
8,硬件提升.

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

servlet/filter/listener/interceptor区别与联系,其实没什么联系

http://blog.csdn.net/sundenskyqq/article/details/8549932
下面就是这个链接的复制

下面从几个方面阐述一下题目中四个概念的区别与联系:
1、概念
2、生命周期
3、职责
4、执行过程

一、概念:
1、servlet:servlet是一种运行服务器端的Java应用程序,主要作用就是接受http请求,然后响应

2、filter:filter是一个可以复用的代码片段,可以用来转换HTTP请求、响应和头信息.Filter不像Servlet,
它不能产生一个请求或者响应,它只是修改对某一资源的请求,或者修改从某一的响应.

3、listener:监听器,通过listener可以监听web服务器中
某一个执行动作,并根据其要求作出相应的响应.通俗的语言说就是在application,session,request
三个对象创建消亡或者增删改查时自定义业务反应.

4、interceptor(一般是指SpringMvc下的HandlerInterceptor):底层通过动态代理实现;常做登录拦截器

5、servlet、filter、listener是配置到web.xml中,interceptor不配置到web.xml中,struts的拦截器配
置到struts.xml中.spring的拦截器配置到spring.xml中. 

二、生命周期:
1、servlet:servlet的生命周期始于它被装入web服务器的内存时,并在web服务器终止或重新装入
servlet时结束.servlet一旦被装入web服务器,一般不会从web服务器内存中删除,直至web服务器关闭
或重新结束.

(1)、装入:启动服务器时加载Servlet的实例； 
(2)、初始化:web服务器启动时或web服务器接收到请求时,或者两者之间的某个时刻启动.
初始化工作有init()方法负责执行完成； 
(3)、调用:从第一次到以后的多次访问,都是只调用doGet()或doPost()方法； 
(4)、销毁:停止服务器时调用destroy()方法,销毁实例. 

2、filter:(一定要实现javax.servlet包的Filter接口的三个方法init()、doFilter()、destroy(),
空实现也行) 

(1)、启动服务器时加载过滤器的实例,并调用init()方法来初始化实例； 
(2)、每一次请求时都只调用方法doFilter()进行处理； 
(3)、停止服务器时调用destroy()方法,销毁实例.

3、listener:类似于servlet和filter
web.xml 的加载顺序是:context- param -> listener -> filter -> servlet 

4、interceptor:以struts的拦截器为例,加载了struts.xml以后,初始化相应拦截器.当action请求
来时调用intercept方法,服务器停止销毁interceptor.

三、职责
1、servlet:
主要作用就是接受http请求,然后响应
2、filter:
filter能够在一个请求到达servlet之前预处理用户请求,也可以在离开servlet时处理http响应:
在执行servlet之前,首先执行filter程序,并为之做一些预处理工作；
根据程序需要修改请求和响应；
在servlet被调用之后截获servlet的执行
3、listener:职责如概念.
servlet2.4规范中提供了8个listener接口,可以将其分为三类,分别如下:
第一类:与servletContext有关的listner接口.包括:ServletContextListener、ServletContextAttributeListener
第二类:与HttpSession有关的Listner接口.包括:HttpSessionListner、HttpSessionAttributeListener、HttpSessionBindingListener、                      HttpSessionActivationListener；
第三类:与ServletRequest有关的Listener接口,包括:ServletRequestListner、ServletRequestAttributeListener
4、interceptor:与过滤器十分相似,通过层层拦截,处理用户的请求和响应.

备注:web.xml 的加载顺序是:context-param -> listener -> filter -> servlet .了解了这几个概念的区别以后,不难理论这个加载顺序了.

四、几个区别:
 
1,servlet 流程是短的,url传来之后,就对其进行处理,之后返回或转向到某一自己指定的页面.
它主要用来在 业务处理之前进行控制.
2,filter 流程是线性的, url传来之后,检查之后,可保持原来的流程继续向下执行,
被下一个filter, servlet接收等,而servlet 处理之后,不会继续向下传递.
filter功能可用来保持流程继续按照原来的方式进行下去,或者主导流程,而servlet的功能主要用来主导流程.

 filter可用来进行字符编码的过滤,检测用户是否登陆的过滤,禁止页面缓存等
 
3, servlet,filter都是针对url之类的,而listener是针对对象的操作的,如session的创建,session.setAttribute的发生,
在这样的事件发生时做一些事情.
可用来进行:Spring整合Struts,为Struts的action注入属性,web应用定时任务的实现,在线人数的统计等

4,interceptor 拦截器,类似于filter,不过在struts.xml中配置,不是在web.xml,并且不是针对URL的,而是针对action,当页面提交action时,进行过滤操作,相当于struts1.x提供的plug-in机制,可以看作,前者是struts1.x自带的filter,而interceptor 是struts2 提供的filter.
与filter不同点:(１)不在web.xml中配置,而是在struts.xml中完成配置,与action在一起
					( 2  ) 可由action自己指定用哪个interceptor 来在接收之前做事   
					

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

1,非持久化存储,对数据存储持久要求不高
2,分布式存储:不适合单机使用,非常消耗内存
3,以key/Value的方式存储,（只能是字符串）不能是Array和List数据格式

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

RIDIS redis(接收用户命令是单线程的)

NOSQL 指not only sql 非关系型数据库(如:redis和mongo DB 等都是)

为什么需要nosql?
1,到web 2.0(用户可以和浏览页面互动),这时就出现高并发读写;关系数据库这时就不行了;

2,海量数据的存储和访问;

notsql 的特点:
1,易扩展(因为数据表之间没有了关系)
2,灵活的数据模型(无需提交建立数据库字段)
3,大数据量,高性能


redis 是用C语言编写的,支持键值对类型存储读写数据:
主要类型有 :
1,字符串类型string
2,列表类型list
3,集合类型等set
4,有序集合类型ZSet
5,散列类型hash

redis 的应用场景(都是缓存数据):
1,缓存
2,任务队列(商品秒杀,因为是单线程的天然线程安全)
3,网站访问统计
4,数据过期处理
5,应用排行榜
6,分布式集群架构中的session分离


安装redis 
$ wget http://download.redis.io/releases/redis-3.2.9.tar.gz
$ tar xzf redis-3.2.9.tar.gz
$ cd redis-3.2.9
这里最好先安装一次 gcc
$ make

1,下载并解压到local目录下
2,yum -y install gcc(redis内部依赖)
3,解压完成后进到安装目录 make 
4,等待安装
5,make PREFIX=/usr/local/software/redis install 
6,进到这个目录可以看到bin目录
7,进到redis-3.2.9 目录下
8,cp redis.conf /usr/local/software/redis
9,目前就可以启动bin 下redis-service 了;但这是前端启动(可以不运行这行);
10,我们可以修改配置文件daemonize yes改为后端启动
11,./bin/redis-server ./redis.conf 
12,注意上面的目录层级位置在bin外层
13,ps -ef | grep -i redis
root      5199     1  0 10:34 ?        00:00:00 ./bin/redis-server 127.0.0.1:6379
14,redis 默认端口是6379
15,退出redis ./bin/redis-cli shutdown ;也不可以kill(不推荐)

16,感受redis:
17,./bin/redis-cli
启动后我们可以输入这些命令
set name huangjufei
get name
keys * //查看全部
keys my? //查看以没有开头的
del name //删除
type name //查看类型
expire("key",秒值) //设置过期时间
tll("key") //还剩好久过期,没有设置返回-1,过期-2;没有过期返回剩余时间
exsit("key") //判断一个key是否存在
jedis.select(数据库值) //redis支持16个数据库,默认是0 
jedis.move(key, dbIndex) //移动当前数据库的key到指定的数据库
redis 是支持事务的: 
事务过程的操作会放到消息队列中,在commit的时候才会提交

public static void main(String[] args) {
	Jedis jedis = new Jedis("192.168.1.105", 6379);
	Transaction t =  jedis.multi();//开启事务
	try {
		//业务逻辑代码
		t.exec();//提交
	} catch (Exception e) {
		t.discard();//回滚
	}
}
//另 还whtch 这个命令可以查看值是否被串改
----------------------------------------
Jedis 入门
jedis 是官方首选的java客户端开发包
需要下载1个包:
jedis-*.jar包

public static void main(String[] args) {
	Jedis jedis = new Jedis("192.168.1.105", 6379);
	String value = jedis.get("name");
	System.out.println(value);
}

//如果报错
java.net.ConnectException: Connection refused: connect

修改linux的防火墙
vim /etc/sysconfig/iptables
中的加入redis 的端口号
-A INPUT -m state --state NEW -m tcp -p tcp --dport 22 -j ACCEPT
-A INPUT -m state --state NEW -m tcp -p tcp --dport 6379 -j ACCEPT

如果是vm ,需要设置redis-conf文件的ip

然后重启防火墙
service iptables restart
-----------------------------------------------

redis 对hash的支持
hset myhash username jack
hset myhash username2 mom
hget myhash username

--------------
public static void main(String[] args) {
	Jedis jedis = new Jedis("192.168.1.105", 6379);
	Map map = new HashMap<String,String>();
	map.put("age", "12");
	map.put("name", "hjf");
	jedis.hmset("maps", map);
	System.out.println(jedis.hgetAll("maps"));
	//打印:{name=hjf, age=12}
}
-----------------

redis 持久化(这个持久化就是指从内存到文件):
分两种: rdb 和 aof

RDB(也叫快照) :默认,以一段时间规则自动持久化数据,redis-conf配置文件中,可以修改规则,
默认数据保存在bin路径下dump.rdp文件中;
优势:数据更快,劣势:数据可能不在时间规则内就保存不进去;

AOF:
优势:数据更为安全,且数据恢复性可读性更好; 劣势:速度慢些
修改redis-conf配置文件:
appendonly yes//默认是no
选择下面3中策略:
appendfsync always //马上持久化
第二种 : 按秒持久化
第三种 : 不持久化


如果开启了aof ,会把数据持久到appendonly.aof文件中;那么pdb就失效,配置文件也不会记录
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
分布式锁的常用3种实现：

0. 数据库乐观锁实现(表加一个version字段,每次修改增加,修改时version作为条件带入判断)
1. Redis实现  --- 使用redis的setnx()、get()、getset()方法，用于分布式锁，解决死锁问题
nx 是 not exist 的意思(其实和数据一样都是靠存 标示 来完成) 解锁使用Lua代码;
2. Zookeeper实现


redis分布式锁
public class RedisTool {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }
}

https://www.cnblogs.com/linjiqin/p/8003838.html
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

SLF4J
网盘有源代码
http://www.cnblogs.com/Sinte-Beuve/p/5758971.html

SLF4J,即简单日志门面(Simple Logging Facade for Java)不是具体的日志解决方案,它只服务于各种
各样的日志系统,现在SLF4J正迅速成为Java世界的日志标准.

总结这次说的,我建议使用SLF4J的而不是直接使用 Log4j, commons logging, logback 


SLF4J提供了基于占位符的日志方法,这通过去除检查isDebugEnabled(), isInfoEnabled()等等,提高了代码可读性.
通过使用SLF4J的日志方法,你可以延迟构建日志信息(Srting)的开销,直到你真正需要,这对于内存和CPU
都是高效的.作为附注,更少的暂时的字符串意味着垃圾回收器(Garbage Collector)需要做更好的工作,
这意味着你的应用程序有为更好的吞吐量和性能.

++++++++++++++++++++++++++++++

log4j和logback呢？

而log4j和logback就是两个受欢迎的日志框架.但两者又有不同.

log4j是apache实现的一个开源日志组件.(Wrapped implementations)
logback同样是由log4j的作者设计完成的,拥有更好的特性,用来取代log4j的一个日志框架.
是slf4j的原生实现.(Native implementations)


可以看到logback是直接实现了slf4j的接口,是不消耗内存和计算开销的.
而log4j不是对slf4j的原生实现,所以slf4j api在调用log4j时需要一个适配层.

总结:
slf4j是java的一个日志门面,实现了日志框架一些通用的api,log4j和logback是具体的日志框架.

+++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++

JDK源码跟踪


Class 类
Class 没有公共构造方法,有私有的构造方法
Class 对象是在加载类时由Java虚拟机以及通过调用类加载器中的defineClass 方法自动构造的.


1,Object
hashCode的意义:
http://www.cnblogs.com/szlbm/p/5504623.html\

1,HashCode的存在主要是为了查找的快速，HashCode是用来在散列存储结构中确定对象的存储地址的
2,如果两个对象equals相等，那么这两个对象的HashCode一定也相同,但反过来就不一定了
3,如果对象的equals方法被重写，那么对象的HashCode方法也尽量重写


2,Array(全是 native修饰)

3,java.io.serializable 
首先它是一个空接口,意义可能就是标示,就是标记这个类可以被序列化;
作用就是将内存中的对象保存到硬盘上;
使用场景:①:游戏存档,网络通信,将这台机上的对象通过文件的方式传给另一台计算机


4,Comparable(可比较)接口
作用:让自定义类具有可比较性,比较后就可以排序;和equals 和 == 没有关系;

http://blog.csdn.net/nvd11/article/details/27393445
如果你想1个自定义类的对象支持比较(如:排序), 就必须实现Comparable接口.

public class Classis implements Serializable,Comparable<Classis> {
	@Override
	public int compareTo(Classis o) {	
	//String 重写了comparable,假如id是int类型可以直接减;
		return this.classId.compareTo(o.getClassId());
	}
	private String classId;
	//toString 方法没有复制
}



5,String类重写了comparable方法:
先看看 char 类型 可以直接运算;
int i = 'a' - 'c'; // 打印-2

//main 代码
int q = "1a".compareTo("1ac");
//源码
//循环短的数组次数,每次取一位和长数组比较;如果不相当等直接减了返回;
//如果相当一直循环,最后长度相减
public int compareTo(String anotherString) {
	int len1 = value.length;//2
	int len2 = anotherString.value.length;//3
	int lim = Math.min(len1, len2);//2
	char v1[] = value;//[1,a]
	char v2[] = anotherString.value;//[1,a,c]
	
	int k = 0;
	while (k < lim) {
		char c1 = v1[k];
		char c2 = v2[k];
		if (c1 != c2) {
			return c1 - c2;
		}
		k++;
	}
	return len1 - len2;
}
//疑问:长度都不一致为什么还需要比较?
//答: 因为compareable解决的排序的问题
另 :Comparator 好处是不需要修改源代码;

对String 的部分方法进行自实现
public static boolean contains(String oldString,String newString){
	boolean tag = false;
	char[] oldChar = oldString.toCharArray();
	char[] newChar = newString.toCharArray();
	int oldLen = oldChar.length;
	int newLen = newChar.length;		
	int totolLen = oldLen - newLen;
	int startOld = 0;	
	if(newLen == 0 || oldLen == 0){
		return tag;
	}
	while(totolLen -- >= 0){		
		while(startOld < oldLen){
			if(oldChar[startOld++] == newChar[0]){
				startOld--;
				break;
			}
		}			
		if(startOld >= oldLen){
			return tag;
		}
		int temp = startOld;//临时变量记录卡点
		int startNew = 0;
		//循环新字符串的长度,一旦不相等就结束循环
		while(startNew < newLen && temp < oldLen){
			if(oldChar[temp++] != newChar[startNew++]){
				startOld++;startNew--;
				break;
			}
		}		
		if(startNew == newLen){
			return tag =true;
		}		
	}
	return tag ;
}

public static String replace(String oldString, char oldChar, char newChar) {
	if (oldChar != newChar) {
		int len = oldString.length();
		int i = -1;
		char[] val = oldString.toCharArray(); 
		while (++i < len) {
			if (val[i] == oldChar) {
				break;
			}
		}
		if(i >= val.length){
			return oldString;
		}
		val[i] = newChar;
		return new String(val);
	}
	return oldString;
}

public static boolean endWith(String oldString, String newString) {
	boolean tag = false;
	char[] oldChar = oldString.toCharArray();
	char[] newChar = newString.toCharArray();
	int oldSLen = oldString.length();
	int newSLen = newString.length();
	if (newChar.length == 0) {
		return tag;
	}
	if (newSLen > oldSLen) {
		return tag;
	}
	int startOld = oldSLen - newSLen;
	int startNew = 0;
	while (--newSLen >= 0) {
		if (oldChar[startOld] != newChar[startNew]) {
			return tag;
		}
		startOld++;
		startNew++;
	}
	return tag = true;
}


6,System类,不能被实例化,构造器被私有化了;

①:得到系统相关的值;
Properties p = System.getProperties();
Enumeration<String> s = (Enumeration<String>) p.propertyNames();
String key = "";
while((key = s.nextElement()) != null){
	System.out.println(key+ "=="+p.get(key));
	
}


②:有标准输入、标准输出和错误输出流；
System.out.println("123");//标准的,这里就是控制台
System.err.println("123");//红色字体输出
System.in.read("a".getBytes());//会阻塞运行

7,public abstract class Number 一个抽象的类,大部分的包装类型都继承了它,
目的就是一个标准,让继承的它的类都有这些抽象方法.

8,基本类型的包装类型
Boolean,

Byte

源代码有这样2个初始常量:
public static final byte   MIN_VALUE = -128;
public static final byte   MAX_VALUE = 127;

计算机以补码的形式保存所有的整数.正数的原码、反码、补码都相同;负数的补码是其反码加1.

①:byte为一字节,8位;最高位是符号位,最大值是0111 1111,因正数的补码就是本身,最大值即为127
1+2+4+8+16+32+64 = 127
②:最小值
源码: 1111 1111
反码: 1000 0000
补码: 1000 0001
减一: 1000 0000 
结果: 2^7 = 1*2*2*2*2*2*2*2 = -128(1乘7个2)
总结 : 最大值和最小值是由位数决定的;


②: byte 的toString源码可以看出就是把byte 转为int类型,按10进制输出;
public static String toString(byte b) {
	return Integer.toString((int)b, 10);
}

③:hashCode值就是本身byte值,-128-127之间的一个10进制的数
public int hashCode() {
	return Byte.hashCode(value);
}

④: equals 就是值得比较,就是地址比较
public boolean equals(Object obj) {
	if (obj instanceof Byte) {
		return value == ((Byte)obj).byteValue();
	}
	return false;
}

⑤:就算是值得比较,通过返回0表示相等
public static int compare(byte x, byte y) {
	return x - y;
}
--------------------
Integer 

首先看一源码:
@Native public static final int   MIN_VALUE = 0x80000000;
@Native public static final int   MAX_VALUE = 0x7fffffff;
使用计算机可以转为十进制 为 : 2147483647 (二十一亿多的数)
为什么是这个数?
java 中int 占4个字节,就是32位(最高位为符号位);
0111 1111 1111 1111 1111 1111 1111 1111
通过十进制转换 得到的结果也是 : 2147483647



①: 无符号转换为Long型值
public static long toUnsignedLong(int x) {
	return ((long) x) & 0xffffffffL;
}

首先接收的参数是int类型;int为4个字节;

0xffffffff 转为2进制(32个1):
1111 1111 1111 1111 1111 1111 1111 1111
如果我int参数传进来12,我们转为2进制;
0000 0000 0000 0000 0000 0000 0000 1100
使用 位运算符得到的结果 就是 12;
总结 :就是你传进来参数是好多返回的就是好多;
知识点: 就是& 怎么运算,为什么使用int类型和为什么是0xffffffffL这样一个值做位运算;

再举一个例子;参数-2;
-2 转为2进制:
1111 1111 1111 1111 1111 1111 1111 1110; -2
1111 1111 1111 1111 1111 1111 1111 1111; 0xffffffff
1111 1111 1111 1111 1111 1111 1111 1110; &后的结果; 10进制为:4294967294

②: += 和 =+的区别:
int i = 1;
i =+ 2;//打印2

int i = 1;
i += 2;//打印3
-2147483647
-214748364

③:parseInt()方法中最后的返回值;负负得正;
int i = -1;
System.out.println(	false ? i : -i);//打印1;

④:Integer 是怎么把一个字符串转为int类型的;可以是2进制到36进制之间
public static int parseInt(String s, int radix)


该方法会把字符串转为char数组,取左边第一位char,判断是是否小于0,(0在ASCII表中是48,1是49,-号是45)
如果小于0 判断是不是-号,如果是说明是负数; true ? i : -i;

代码会根据循环下标*10 ;依次叠加;如果"12" 循环2次 第一次 0*10 +1 =1 (1);第二次就是1 * 10 +2 = 12;
最后返回12;


⑤:Integer 转2,8,16进制怎么转换的?

Integer.toBinaryString(12) 转2进制 >>>1; (位移1位)
toOctalString(12) 转 8进制 >>> 3;
Integer.toHexString(12) 转16进制是>>>4;
具体实现不只是是这么简单,可以看源代码

---------------------
Character

源码代码中的:
// 静态不可改变的 最小进制是2进制最大进制是36进制
public static final int MIN_RADIX = 2;
public static final int MAX_RADIX = 36;
// char 值的取值范围 最小 0000 最大 65535 ;
// 从源码上看char 占2个字节,8位;而不是1个字节;但中文在utf-8编码时用3个字节表示;又是怎么回事
//代码点大于 U+FFFF 的字符称为增补字符.Unicode编码是支持变长的;
public static final char MIN_VALUE = '\u0000';
public static final char MAX_VALUE = '\uFFFF';

①:源代码中提供了很多底层的方法,和一般的业务逻辑需求无关;和算法有关;

②:comparable 在char类型中的比较依然是 直接相当比较的;
public static int compare(char x, char y) {
	return x - y;
}

************************************************************************
************************************************************************

字符编码与字符集在本质上就是不同的东西.

字符(Character)>
　　一个文字就是一个字符.在计算机中,字符是用数字来表示的,不同的文字用不同的数字表示.存储时,或传输时是使用的数字;

字符集(Character Set) 如:gb2312,utf-8
　既然是“集”,也就是“集合”,“字符集”自然就是“一定量字符的集合”.
一个字符集包含了固定数量的字符,如ASCII字符集包含A-Z、a-z、0-9、半角标点符号和特殊控制符号
(如换行符)在内的128个字符.

字符编码(Encode)
　编码,意思是指将数据通过一定方式表达或储存,这个方式就叫编码.所以字符编码就是字符的表现、储存方式,
也就是字符集的实现方式.但需要注意的是:有的字符编码和字符集的名称是一致的.



Accept-Charset:浏览器申明自己接收的字符集,这就是本文前面介绍的各种字符集和字符编码,如gb2312,utf-8
(通常我们说Charset包括了相应的字符编码方案)；


Content-Type:WEB服务器告诉浏览器自己响应的对象的类型和字符集.例如:Content-Type: text/html; charset='gb2312'

Content-Encoding:WEB服务器表明自己使用了什么压缩方法(gzip,deflate)压缩响应中的对象.例如:Content-Encoding:gzip
Accept-Encoding:浏览器申明自己接收的编码方法,通常指定压缩方法,是否支持压缩,支持什么压缩方法(gzip,deflate),
(注意:这不是只字符编码)；

-------------------------------------------------------------
HADOOP
http://blog.csdn.net/roy_88/article/details/54944672

hadoop 模仿了google大数据技术的开源实现;
hadoop 是什么?
是apache下顶级项目且开源的,分布式存储加分布式计算的平台;
包括两个核心组成:
HDFS :　分布式文件系统,存储海量数据;
MapReduce : 并行处理框架,实现任务分解和调度;
hadoop可以用来做什么?
搭建大型数据仓库,PB级数据的存储,处理,分析,统计等业务;
然后为搜索引擎,日志分析,数据挖机,商业智能等提供支持;
hadoop 的优势?
1,高扩展,理论无限
2,廉价,pc机就可以
3,成熟的生态圈;开源能多大神
关于hadoop 生态圈中有大量的插件:
如HIVE : 使用简单的sql语句,完成hadoop 任务;
Hbase : 放弃了事务的特性,追求更高的扩展,和hdfs的区别,hbase提供数据随机读写和实时访问,
实现对表数据读写功能
zookeeper : 动物管理员;

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
vm 安装centos7 踩过的坑(最好不要按7,按6.X多方便)
[root@localhost /]# cat /etc/redhat-release
CentOS Linux release 7.4.1708 (Core) 

1,vm怎么都运行不了centos7.iso 文件,后来发现调整cpu支持vm后安装上好了系统
2,使用vm8 (nat方式怎么都连接不上网)网卡,本地cmd 中可以ping通vm8网卡,但就是连接不虚拟机
系统,在centos中使用ifconfig看不到ip,解决:
cd /etc/sysconfig/network-scripts/ 
vi ifcfg-ens33
修改里面的一个参数:
onboot=yes
保存退出
service network restart
经测试，就可以顺利的联网拉
-------------------------
安装 其他

yum install gcc 
yum -y install vim
yum -y install wget
安装 jdk(下载,压解不说了),配置环境变量
vi /etc/profile
输入i
加入内容如下：
export JAVA_HOME=/usr/local/jdk1.7.0_71
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
export PATH=$JAVA_HOME/bin:$PATH
加载刚设置的变量
source /etc/profile
测试是否安装成功
java -version
----------------------
安装mysql最新版本,这里是5.7+
http://www.linuxidc.com/Linux/2016-09/135288.htm -- 下面内容来至这个链接;

1、配置YUM源

在MySQL官网社区下载YUM源rpm安装包：http://dev.mysql.com/downloads/repo/yum/ 
MySQL YUM源下载地址

# 下载mysql源安装包
shell> wget http://dev.mysql.com/get/mysql57-community-release-el7-8.noarch.rpm
# 安装mysql源
shell> yum localinstall mysql57-community-release-el7-8.noarch.rpm
检查mysql源是否安装成功

shell> yum repolist enabled | grep "mysql.*-community.*"
检查mysql源安装是否正确 
看到上图所示表示安装成功。 
可以修改vim /etc/yum.repos.d/mysql-community.repo源，改变默认安装的mysql版本。
比如要安装5.6版本，将5.7源的enabled=1改成enabled=0。
然后再将5.6源的enabled=0改成enabled=1即可。改完之后的效果如下所示： 
这里写图片描述

2、安装MySQL

shell> yum install mysql-community-server
3、启动MySQL服务

shell> systemctl start mysqld
查看MySQL的启动状态
shell> systemctl status mysqld

4、开机启动
shell> systemctl enable mysqld
shell> systemctl daemon-reload
5、修改root本地登录密码

mysql安装完成之后，在/var/log/mysqld.log文件中给root生成了一个默认密码。
通过下面的方式找到root默认密码，然后登录mysql进行修改：

shell> grep 'temporary password' /var/log/mysqld.log
root默认密码

shell> mysql -uroot -p
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'MyNewPass4!'; 
或者

mysql> set password for 'root'@'localhost'=password('MyNewPass4!'); 
注意：mysql5.7默认安装了密码安全检查插件（validate_password），默认密码检查策略
要求密码必须包含：大小写字母、数字和特殊符号，并且长度不能少于8位。
否则会提示ERROR 1819 (HY000): Your password does not satisfy the current 
policy requirements错误，如下图所示： 
密码策略提示

通过msyql环境变量可以查看密码策略的相关信息：

mysql> show variables like '%password%';
mysql密码策略 
validate_password_policy：密码策略，默认为MEDIUM策略 
validate_password_dictionary_file：密码策略文件，策略为STRONG才需要 
validate_password_length：密码最少长度 
validate_password_mixed_case_count：大小写字符长度，至少1个 
validate_password_number_count ：数字至少1个 
validate_password_special_char_count：特殊字符至少1个 
上述参数是默认策略MEDIUM的密码检查规则。


6、配置默认编码为utf8
修改/etc/my.cnf配置文件，在[mysqld]下添加编码配置，如下所示：
character_set_server=utf8
init_connect='SET NAMES utf8'
重新启动mysql服务，查看数据库默认编码：
show variables like '%char%'; 

退出masql 命令:
exit;
默认配置文件路径： 
配置文件：/etc/my.cnf 
日志文件：/var/log//var/log/mysqld.log 
服务启动脚本：/usr/lib/systemd/system/mysqld.service 
socket文件：/var/run/mysqld/mysqld.pid



7,mysql远程登录:

安装iptables防火墙 
yum install iptables-services
启动防火墙 
systemctl start iptables 
systemctl enable iptables 
touch /etc/sysconfig/iptables
systemctl start ip6tables 
systemctl enable ip6tables 
信息来自http://www.centoscn.com/CentOS/Intermediate/2015/0911/6160.html
开启3306端口

[root@localhost sbin]# iptables -I INPUT -p tcp --dport 3306 -j ACCEPT
[root@localhost sbin]# service iptables save
iptables: Saving firewall rules to /etc/sysconfig/iptables:[  确定  ]


systemctl restart iptables.service #重启防火墙使配置生效
systemctl enable iptables.service #设置防火墙开机启动

mysql的设置 将user表中的host设置为%可以实现任意ip远程访问数据库

select Host,User from mysql.user; --查看目前有哪些用户
create user test identified by 'huagnJufei,.123'; --创建一个用户
-- 给权限
grant all privileges on *.* to 'test'@'%'identified by '123456' with grant option;
flush privileges ; --刷新
这样我们就可以访问数据库了
重启永久生效 
开启：chkconfig iptables on 
关闭：chkconfig iptables off 




8,忘记密码
1、修改配置文件my.cnf 按i编辑
[root@iZ2ze14tbj23jllo85kuh1Z ~]# vim /etc/my.cnf
在[mysqld]中添加
skip-grant-tables

[mysqld]
**skip-grant-tables**
datadir=/var/lib/mysql
socket=/var/lib/mysql/mysql.sock
键盘 Esc 保存修改  :wq退出
2、重启mysql服务
service mysqld restart
3、用户登录
mysql -uroot -p (直接点击回车，密码为空)
选择数据库
use mysql;
下面我们就要修改密码了
以前的版本我们用的是以下修改
update user set password=password('root') where user='root';
但是在5.7版本中不存在password字段，所有我们要用以下修改进行重置密码
update user set authentication_string=password('123456') where user='root';
执行
flush privileges;
4、退出mysql
quit;

----------------------------------
tomcat9 安装:
去tomcat官网找到Core的
tar.gz (pgp, md5, sha1),复制地址使用wget下载

2,然后解压 tar -xvf apache-tomcat-9.0.0.M26.tar.gz 
3,./bin/startup.sh #启动
4,在浏览器上输入 http://192.168.142.128:8080/
5,成功;(不需要配环境变量)
-------------------------------------
本地这次使用的版本为 :elasticsearch-5.6.1.tar.gz

1,进入www.elastic.co 官网,点击download
2,选择tar.gz下载,可以使用linux wget 直接下载也可以其他
我下载的5.6版本的
3,tar -xvf elasticsearch-5.6.1.tar.gz
4,启动es之前jdk ,tomcat必须先安装好
5,
然后 vim config/elasticsearch.yml 
如果是虚拟机修改为 :
network.host: 0.0.0.0
http.port: 9200
#下面2行可以不要
discovery.zen.ping.unicast.hosts: ["192.168.142.128"]
discovery.zen.minimum_master_nodes: 3

6.es 不能使用root用户启动,所以百度添加用户
7,然后启动,根据错误提示百度,一个一个的修改;
8,直到在页面 192.168.142.128:9200看到效果为止;

-----------------------------------
安装 head 插件,能更加简单对Es进行增删改查
下载这个管理插件:
https://github.com/mobz/elasticsearch-head
然后根据github 上的提示安装,中间会安装一些插件
需要安装node.js 
我的版本:node-v6.11.3-linux-x64.tar.xz

下载下来的jar包是xz格式的，一般的linux可能不识别，还需要安装xz.
yum -y install xz
然后解压nodejs的安装包:

xz -d node*.tar.xz
tar -xvf node*.tar
解压完node的安装文件后，需要配置下环境变量,编辑/etc/profile，添加

# set node environment
export NODE_HOME=/usr/elk/node-v6.9.1-linux-x64
export PATH=$PATH:$NODE_HOME/bin
别忘记立即执行以下

source /etc/profile
这个时候可以测试一下node是否生效:
[root@localnode1 node-v6.9.1-linux-x64]# node -v
v6.9.1
[root@localnode1 node-v6.9.1-linux-x64]# npm -v
3.10.8

使用npm start 启动 head插件
直到看到(中间ERR 不用管,一样的可以访问到,/etc/sysconfig/iptables 加入9100)
Started connect web server on http://localhost:9100
-----------------------------------
elasticsearch-head 和 elastic 的 整合 出现的坑?

http://www.cnblogs.com/zklidd/p/6433123.html
vim config/elasticsearch.yml 
中加入下面2行代码:(一个空格都不能少)
#默认false,不允许
http.cors.enabled: true
#允许任何地址访问
http.cors.allow-origin: "*"

----------------------
elsatic 的集群:

再次解压到elastic.tar包,并给原来用户重新赋予权限
注意,让 主从都在elastic目录下;
# es角色:es组 分配那个目录权限
chown -R es:es  elastic
主节点配置:
http.cors.enabled: true
##允许任何地址访问
http.cors.allow-origin: "*"
## 主节点名字(主从统一)
cluster.name: huangjufei
##当前节点名字
node.name: master
##当前节点ip
network.host: 192.168.142.128
##当前端口号
http.port: 9200
## 主节点开关(注意)
node.master: true
------------------------
从节点配置:
#默认false,不允许
http.cors.enabled: true
#允许任何地址访问
http.cors.allow-origin: "*"
# 主节点名字(主从统一)
cluster.name: huangjufei
#当前节点名字
node.name: slave1
#当前节点ip
network.host: 192.168.142.128
#当前端口号
http.port: 9201
# 主节点的ip
discovery.zen.ping.unicast.hosts: ["192.168.142.128"]
++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++
ES 的使用:

java中如何连接es,并完成增删改查;百度云项目Elastic-Client

官方中文文档
https://www.elastic.co/guide/index.html

Elasticsearch 是一个实时的分布式搜索分析引擎(工作中主要就是crud操作,主要是查询)它能让你以一个之前从未有过的速度和规模，
去探索你的数据。 它被用作全文检索、结构化搜索、分析以及这三个功能的组合：

基本格式:
http://{ip}:{port}/{索引}/{类型}/{文档id}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
精华
索引相当于数据库，类型相当于数据库中的表，文档类比于表中一行记录
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

分片 :每个索引都有多个分片,每个分片是一个Lucene索引
分片的越多,查询越快;默认5;后期不能修改
备份: 拷贝一份分片就完成了分片的备份;后期可以修改
索引: 需要小写

索引分为结构化和非结构化的,通过关键字mappings来判断;
如果为空就是非结构化的

仔细看看Es 的结构
http://192.168.142.128:9200/person/ 
使用上面链接提交下面数据(建表语句),索引为person(数据库的名字),方式PUT

//1,首先以{}开头,和json格式一样
{
	//settings 可以设置分片数,备份数
	"settings":{
		"number_of_shards":3,//分片数
		"number_of_replicas":1//复制数
	},
	
	//mappings是固定格式,里面都是结构也是固定格式
	"mappings":{
	
		"man":{//man就是表名
		
			"properties" :{//man 表的所有字段先需要properties包一次
			
				"name":{ //name 可以就是字段
					"type":"string"//type的value设置字段的类型
				},
				"country":{
					"type":"keyword"//关键字
				},
				"age":{
					"type":"integer"
				},
				"date":{
					"type":"date",//日期支持格式化				
					"format":"yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis"
				}		
			}	
		},
		
		"woman":{//第二个索引		
		}
	}
}

-------------------------
ES的增删查改(ES全程使用restfull风格)

增分为指定文档id插入,和自动生成id插入
id为唯一索引值;

指定id就是在路径上写入id即可:
192.168.142.128:9200/person/man/1
内容体一样的:
{
	"name":"黄举飞",
	"country":"中国",
	"age":32,
	"date":"1985-09-09 22:10:06"	
}

--------------
修改:
方式一:
192.168.142.128:9200/person/man/1/_update
//_update 为修改关键字
{
	"doc":{ //doc 关键字包裹需要修改的参数和值
		"name":"huang",
		"country":"中国"
	}
}
-----------------------
方式二:
Es还支持脚本语言修改(使用脚本语言计算后,然后赋值):
192.168.142.128:9200/person/man/1/_update
//下面这段脚本,让原有age值上加10
{
	"script":{//脚本
		"lang":"painless",//ES支持很多语言,这里选的内置语言
		"inline":"ctx._source.age += 10"	//ctx.为es的上下文
	}
}


------------------
删除:
删除分删除文档 和删除索引(非常危险)

删除文档:
使用delete方式:
//删除id为1的一条记录
192.168.142.128:9200/person/man/1
---------
删除索引:
//删除person这个索引,全部数据删除,危险操作
使用delete方式:
192.168.142.128:9200/person
---------------------------
查询:
普通查询:

//可以拉取到person 索引的全部信息,如有哪些字段,字段类型(常用)
192.168.142.128:9200/person

//使用关键字_search,查询全部数据;方式get(不常用)
192.168.142.128:9200/person/man/_search

//方式post,查询全部数据
192.168.142.128:9200/person/man/_search
{
	"query":{
		"match_all":{}
	}
}

//根据id 查询,方式就get(常用)
192.168.142.128:9200/person/man/AV7h8JxDw1jSqaYzfa9I


//根据某个字段查询,es默认是模糊查询,但keyword 不会模糊查询
192.168.142.128:9200/person/man/_search
{
	"query":{
		"match":{
			"name":"黄举飞9"
		}
	},
	"from":1,//设置从那条开始
	"size":2//设置一共查询几条数据
}

//根据某个字段精确查询
{
	"query":{
		"match_phrase":{//match_phrase也可以精确查询
			"name":"黄举飞6"
		}
	}
}

//根据多个字段查询
{
	"query":{
		"multi_match":{//multi_match修改为多个条件查询
			"query":"9", //需要查找的9这个字符串
			"fields":["name","age"] //在name 和age 这2个字段中查找,注意必须是字符串才可以
		}
	}
}

//只要字符串类型中包含9和6都会被查询出来,可以加入fields过滤字段
{
	"query":{
		"query_string":{
			"query":"9 or 6"	
		}
	}
}


//排序
192.168.142.128:9200/person/man/_search
{
	"query":{
		"match_all":{}
	},
	"sort":[{//排序
		//date 文档字段,asc
		"date":{"order":"desc"}
	}]
}

//Es 支持非常强大的聚合查询,数度还很快
//功能:对年龄就行分类统计聚合
192.168.142.128:9200/person/man/_search
{
	"aggs":{//聚合查询通过关键字aggs修饰
		"group_by_age":{ //group_by_age随便定义
			"terms":{ //关键字
				"field":"age"//字段名
			}
		}
	}
}

//聚合之统计
192.168.142.128:9200/person/man/_search
{
	"aggs":{
		"group_by_age":{
			"stats":{//使用统计关键字,也可以直接使用min,max,avg,sum,count
				"field":"age"
			}
		}
	}
}
//返回结果:
  "aggregations": {
    "group_by_age": {
      "count": 11,
      "min": 10,
      "max": 39,
      "avg": 32.54545454545455,
      "sum": 358
    }
  }

  
//查询age 大于等于37且小于69的,结果按age排序,对数字和日期格式有效
192.168.142.128:9200/person/man/_search 
{
	"query":{
		"range":{//range关键字修饰范围
			"age":{
				"gte":37,//大于等于
				"lt":69//小于
			}	
		}
	},
	"sort":[{
		"age":{"order":"desc"}
	}]
}

//精确查询年龄为36的
{
	"query":{
		"bool":{//boolean
			"filter":{//filter过滤查询,内部会缓存,需要结合bool使用
				"term":{
					"age":36
				}	
			}	
		}
	}
}

//查询名字中不包含黄这个字符串的,结果只有一条,但查询黄举结果有很多条,
//所以这个内部,怎么一个查询机制还需要在次研究
192.168.142.128:9200/person/man/_search
{
	"query":{
		"bool":{
			"must_not":{//must_not关键字,来排除
				"term":{
					"name":"黄"
				}
			}	
		}
	}
}


//es的复合查询,用时多百度

++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++

Spring-data-jpa的介绍 推荐链接:
http://www.cnblogs.com/dreamroute/p/5173896.html
另百度云有基于SpringBoot框架,写了一个关于

Spring-data-jpa(SpringBootHello-2)的增删改查,带参数的分页;
分页如何使用:
https://github.com/wenhao/jpa-spec
++++++++++++++++++++++++++++++++++++++++++++++

SpringBoot 的基础使用百度云 SpringBootHello-2项目

@configuration 注解如何使用,下面这个链接写的很好:
http://blog.csdn.net/javaloveiphone/article/details/52182899

springBoot 有基于类替换配置文件管理拦截器的方法,可以看看
http://lihao312.iteye.com/blog/2078139

++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++

java 消息队列也叫中间件(JMS java message service)

原代码百度云,项目中间件(包含下面3种现实)

作用:解耦,异步,横向扩展,安全,顺序保证
举例: 用户登录,我们可能会发短信,送积分等很多和登录相关的服务,
这些服务我们应该异步完成,就算这些步骤失败也不能影响到用户登录;这时我们使用中间件完成;
好处:加快了用户登录体验,还不会出错;
总结:就是和主流程无关的业务,可以考虑单独抽离出来,使用中间件来完成

市面主流中间件对比:
ActiveMQ:适合小企业,不适合上千队列应用;
QabbitMq:适合稳定性要求高的金融企业
Kafka:数度快,超大数据,无限扩展;可靠性要求不是很高的企业;(如kafka,主要作用对消息进行存储)


++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++

java 中如何发送http请求或后端到后端的上传
可以选择 httpClinentDemo
http://www.cnblogs.com/Scott007/p/3817285.html
百度云项目 httpClinentDemo

此处HttpClient是org.apache.commons.httpclient.HttpClient。
到2007年就没有更新了

另:
Apache HttpComponents Client
这个包一直在维护,推荐使用它
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++

防止java反编译;
http://blog.csdn.net/rulon147/article/details/42550901
思路:
针对每一个用户生成UUID作为加密的key,可以直接使用自定义MD5加密方式对文件进行加密,
然后给用户加密后文件;
程序会运行时调用服务器根据用户名,密码得到key ,然后解密;

疑问怎么防止解密的流,不被用户写到本地;不管怎么样都会有这一步?

++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
Camel的Helloworld,参数看官方文档
process 中文件只会有一个不能是多个;
public static void copy(){
	DefaultCamelContext camelContext = new DefaultCamelContext();
	camelContext.addRoutes(new RouteBuilder(){
		int count = 0;
		public void configure() throws Exception{		
			//recursive 递归遍历目录下的文件
			//readLock 加锁;
			//readLockMinLeng 0kb文件不读取使用;
			this.from("file:d:/aa?recursive=true&delay=5&readLock=changed&readLockMinLeng=0")
			.process(new Process(){
				public void process(Exchange e)throws Exception{
					count++;
					system.out.println(count);
					GenericFile<File> gf = e.getIn().getBody(GenericFile.class);
					File file = gf.getFile();
					//永远不会爆io异常;
					PrintStream ps = new PrintStream(System.out,true,"UTF-8");
					BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
					String line = null;
					while(null !=(line = br.readLine())){
						ps.println(line);	
						ps.flush();//必须	
					}
					ps.close();
					br.close();
				}
			}).to("file:d:/bb")
		}	
	});
	camelContext.start();
	boolean tag = true;
	while(tag){
		system.out.println("-")
		Thread.sleep(10001L);
	}
	camelContext.shop;
	
}
------------------------------------
camel 中使用https转发,如何带KeyStore

1,发送前需要先把jks装入camel的上下文中;
KeyStoreParameters keyStoreParameters = new KeyStoreParameters();
keyStoreParameters.setResoure("/opt/pre_conf/server.jks");
keyStoreParameters.setPassword("jks的密码");
TrustManagersParameters tmp = TrustManagersParameters();
tmp.setKeyStore(keyStoreParameters);
SSLContextParameters sSLContextParameters = new SSLContextParameters();
SSLContextParameters.setTrustManagers(tmp);
HttpComponent h = getContext().getComponent("http4",HttpCompoent.class);
h.setSslContextParameters(sSLContextParameters);

2,注意在camel在to时使用 https4 协议

3,服务端需要在百度一下,忘记了;需要在tomcat中配置;
 <Connector 
		SSLEnabled="true"
		clientAuth="false"
		secure="true"
		port="8443"
		maxThreads="150"
		sslProtocol="TLS"
		scheme="https"
		keyStorePass="123456"
		truststorePass="123456"
		keystoreFile="d:/key/tomcat.keystore"
		truststoreFile="d:/key/tomcat.keystore"
		protocol="org.apache.coyote.http11.Http11NioProtocol"
    </>
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
DOCKER docker
(腾讯,京东,阿里都是使用)

这个网站有各种系统的安装和使用
http://www.runoob.com/docker/docker-tutorial.html

解决什么问题?
1,程序运行时,环境不一致问题;
2,快速服务器扩容问题;
上面都是因为docker 标准化打包,传输等带来的结果
Docker 可以让开发者打包他们的应用以及依赖包到一个轻量级、可移植的容器中，
然后发布到任何流行的 Linux 机器上，也可以实现虚拟化


docker 会把程序打包成镜像(镜像就是一堆文件);
build 创建镜像
ship 传输镜像
run 运行镜像
docker ps //查看已经运行的容器 
docker shop 容器id(可以简写) //关闭容器

docker 中有分层文件的思想,只有最上层容器层可以写,容器下的文件
只有只读功能;docker默认会从顶层开始查找,这样就保证容器下层的文件在
任何一个服务中都不会被修改;从而保证每个服务器上运行的程序结果都一样;

------------------
docker安装流程:
1.检查内核版本，返回的值大于3.10即可。
$ uname -r
2.使用 sudo 或 root 权限的用户登入终端。
3.确保yum是最新的
$ yum update //谨慎使用
4.添加 yum 仓库
$ tee /etc/yum.repos.d/docker.repo <<-'EOF'
[dockerrepo]
name=Docker Repository
baseurl=https://yum.dockerproject.org/repo/main/centos/$releasever/
enabled=1
gpgcheck=1
gpgkey=https://yum.dockerproject.org/gpg
EOF
5.安装 Docker
$ yum install -y docker-engine
6.启动docker
$ systemctl start docker.service
7.验证安装是否成功(有client和service两部分表示docker安装启动都成功了)
//下面是我安装的信息
[root@localhost yum.repos.d]# docker version
Client:
 Version:      17.05.0-ce
 API version:  1.29
 Go version:   go1.7.5
 Git commit:   89658be
 Built:        Thu May  4 22:06:25 2017
 OS/Arch:      linux/amd64

Server:
 Version:      17.05.0-ce
 API version:  1.29 (minimum version 1.12)
 Go version:   go1.7.5
 Git commit:   89658be
 Built:        Thu May  4 22:06:25 2017
 OS/Arch:      linux/amd64
 Experimental: false

------------------------------
docker 的执行流程:

docker pull hello-world 执行后被docker daemon 接收到,会在本地找到有没有
hello-world 这个镜像,如果有什么都不做;如果没有去配置的远端仓库查找并下载;

docker run hello-world 执行后被docker daemon 接收到,现在本地查询,如果没有
去远端仓库下载,交由container加载后运行;
------------------------------

HelloWorld

docker images -- 查看镜像文件

docker pull hello-world -- 拉取名字叫hello-world的镜像(去上面的配置文件中的路径仓库中下载)

docker images; --下面是执行后的结果
REPOSITORY          TAG                 IMAGE ID            CREATED             SIZE
hello-world         latest              05a3bd381fc2        5 weeks ago         1.84kB

docker run hello-world -- 运行 
-----------------------------

上面的hello-world镜像属于前台镜像,下面我们下载一个Nginx镜像来看看docker 在管理真实的镜像是怎么个情况.

1,首先去网易蜂巢得到Nginx的地址 -- 有鲸鱼的是从docker官网下载的版本,更安全
-- 登录账号手机号,密码hjf,.123(这个pull 直接指向一个绝对地址是163的,不指定默认是官方仓库)
docker pull hub.c.163.com/library/nginx:latest

docker images -- 可以看见下载下来了

2,docker run 名字 --复制images中看到的镜像名字(可以看见现在被阻塞了现在Nginx 运行在前台,Crtl+c 结束前台程序)

-- 可以通过帮助查看我们需要的参数 docker run --help (参数-d -p 可以写成-dp)

docker run -d -p 8080:80 hub.c.163.com/library/nginx -- 后台启动nginx;本地访问8080,会转发到虚拟机的80端口上

docker ps -- 可以查看你启动了几个docker容器

-------------------------------
核心知识:
一,如何进入一个容器?
docker exec --help
Usage:  docker exec [OPTIONS] CONTAINER COMMAND [ARG...]

从上面的帮助我们可以看到-it 是options 后面是要进入容器的id,后面是已bash命令进入
C:\Users\Administrator>docker exec -it 9c97 bash
root@9c9712562f58:/# -- 这里可以看到已我容器的id开头的root;

发现没?多了台linux机子;一个容器就是一个虚拟机;里面内容和外面隔离的;

退出exit;

二,容器和主机的环境是隔离的,且网络也是隔离的;
我们想通过访问主机来访问容器就需要IP端口映射(bridge模式)
如下面 -p发布一个容器的端口到主机上8080指主机80指容器,只有这样映射后页面访问8080才会到容器的80端口
docker run -d -p 8080:80 hub.c.163.com/library/nginx 

如何验证?
[root@localhost ~]# netstat -na |grep 8080 //发现linux 电脑正在监听8080端口
tcp6       0      0 :::8080                 :::*                    LISTEN  
然后在页面输入,发现nginx 首页可以看见了
http://192.168.142.128:8080/

意思在我们没执行-p 8080:80 这条命令时页面是看不见的,8080端口也不会给监听

关闭一个容器
docker stop 名字/id

了解:docker提供了两种配置端口的方式
docker run -d -p HostPort:DockerPort 镜像名 (手动)
docker run -d -P 镜像名 (自动分配一个端口和80对应)

-----------------------------

如何把自己的项目,做成镜像?

1,首先去网易蜂巢下载一个tomcat(这个tomcat自带jdk)

docker pull hub.c.163.com/library/tomcat:latest
2,复制地址,下载完成后
docker images //可以看见我们镜像里又多了一个镜像

3,随便找个web项目war包准备好

4,创建一个Dockerfile的文件,文件需要一样;内容如下
from hub.c.163.com/library/tomcat -- 依赖tomcat镜像
MAINTAINER huangjufei 28160997@qq.com -- 可以不写
copy MyWeb.war /usr/local/tomcat/webapps -- 将war放入tomcat

5,使用命令封装为一个镜像文件
[root@localhost docker-store]# docker build -t mydocker:latest .

6,使用 docker images 可以看见你是否创建成功你的镜像没

7,docker run -d -p 8888:8080 mydocker //linux 监听8888端口,然后转发到8080

8,现在就可以在页面去访问了
http://192.168.142.128:8888/MyWeb/

9,完美访问到了;

10,netstat -na | grep 8888 //查看8888端口的状态
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
Excel 文件和对象的互转
现在推荐阿里EasyExcle

百度云有源码

总体来说，对于简单的单表excel导入导出的需求，建议使用JXL。数据量稍微小点，
占用内存少，速度快。 对于报表类的，涉及月份数据量，
多表数据聚合在一起建议使用POI(推荐)。


下面简要介绍一下POI的两种读写模式。 
首先要知道poi中的几个概念与excel是什么关系 
WorkBook:一个excel文件 
Sheet：页签，工作表，代表一个excel文件的一张表 
Row:excel表中的一行 
Cell:一张表中的一个单元格 
CellStyle:单元格的样式 

上面的每个抽象出来的对象都被POI封装好了，声明了接口，有不同的实现方式。

有三种实现方式: 
XSSFCell:基于内存 
SXSSFCell:基于内存+磁盘的写入方式 
HSSFCell:高水平的写入方式，对于单元格的数据类型有很高的限制，
比如:字符串格式只有字符，不能有数字

++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
http://blog.csdn.net/jia20003/article/details/50425061
java 图像处理

++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
java JVM(虚拟机)
http://blog.csdn.net/column/details/zhangjg-java-blog.html//只看第一节404
http://blog.csdn.net/witsmakemen/article/details/28600127/
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
java本地方法详解:
https://www.cnblogs.com/langtianya/p/3459647.html
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
springCloud

//我项目搭建前8节都实现了
https://blog.csdn.net/forezp/article/details/70148833/

//百度(学习资源2)
崔永超 springcloud
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
工作流
工作流的最大的好处是可以图形化看到流程的全部节点，目前在那个节点

百度网盘有学习视频


//入门
https://www.jianshu.com/p/bdc9c9fa719d
//activiti5 视频教程
https://www.iqiyi.com/v_19rrablwi0.html#curid=625556900_2e1180dabbeb53b8a3da680aa32f28e8

++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
SSO 单点登录
功能: 多个应用一处登录,其他无需再次登录
好处: 提高了用户的体验,增强公司的形象
坏处: 存在木桶效应;

分为 3种:同在一个域下;同一父域不同子域;完全不同域;


第一种多设置共同父域cookie.setDomain(".helloweenvsfei.com");
第二种:都去一个地方验证登录;平安就是

+++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++
SpringbootSecurity 中如何使用?

代码在github 上

/**
 * SpringbootSecurity 的helloWorld 程序
 * 如何玩?
 * 启动后访问controller层
 *
 * 主要思想:
 * SpringbootSecurity 分为认证和授权
 * 认证可以理解为就是账号密码检查
 * 授权可以理解为对资源访问的检查
 *
   认证通过不等于就可以访问资源,也不是全部资源都需要授权.根据实际业务区别对待
   
 * 对于认证,我们主要要学习的就是:
 * 1,定义密码规则 PasswordEncoder
 * 2,实现 UserDetailsService 重写得到用户信息方法(用户名,密码,权限,角色等)
 * 3,主要类有 DaoAuthenticationProvider 这里会调 2 得到用户信息,然后进行密码比对
 *
 * 对授权 主要就是 :
 * 1, 继承 WebSecurityConfigurerAdapter 重写  protected void configure(HttpSecurity http) 方法
 * 2, 主要就是在方法内部定义如果拦截url,那些url需要被检查,如何检查,是检查角色还是权限(推荐)
 * 3, 对登陆和退出的重定义(接口),对页面的重定义
 * 4, 当然我们还可以基于注解在Controller方法上拦截,就当前我觉得不是很好(用不到这么细的粒度)
 *
 * 5, 主要类有 AccessDecisionManager 的 decide 方法被3个类实现(都是通过投票确定,机制不一样)默认是AffirmativeBased
 * 所以这个方法我们会常常在这里打断点,排查授权无效等问题
 *
 *
 * 自定义登陆:
 * 1, .loginPage("/login-view")//自定义登陆controller层方法上,默认login;
 *    .loginProcessingUrl("/login")//这是地址和login.jsp页面,点击登陆按钮发出的请求地址一致
 * 2. 可能login.jsp报404,看哈pom的插件和2个依赖是否有
 * 3,需要关闭security的跨域拦截
 *
 * 自定义退出,和上面一样我代码里就没做了
 *
 * 连接数据,只需配置数据源,然后从数据得到用户信息赋值给UserDetails
 *
 * 会话信息只要用户授权成功后就可以从SecurityContextHolder.getContext().getAuthentication();得到
 *
 * 参考
 * https://www.cnblogs.com/zhengqing/p/11612654.html
	https://www.bilibili.com/video/BV1CJ411H7Wx?p=35
 * 还有黑马文档
 
   该项目不包含oauth2 的内容,且授权和资源服务混在一个项目中,且基于session,不适用于分布式系统:
 * oauth2 主要讲是用户允许第三方授权,简单点就是用户允许如微信将自己的本人的用户信息或其他信息,授权给第3方(如慕课网)
 *
 */

++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
springSecurityOauth2

32课不听,该服务该建立在uaa项目上

Oauth2 主要讲是用户允许第三方授权,其实它是依赖于用户认证(就是账号密码验证,就是SpringbootSecurity 的helloWorld 项目的全部内容)
,只有在认证完成后,才会走授权流程;

自定义类加 @EnableAuthorizationServer 注解并继承AuthorizationServerConfigurerAdapter来配置OAuth2.0 授权 服务器。
作用:告诉程序这个类是一个授权服务器

授权服务器主要包含3个内容
ClientDetailsServiceConfigurer：客户端 访问授权服务器需要带上授权服务器发的id和密钥才可以访问授权服务器
AuthorizationServerEndpointsConfigurer：用来配置令牌（token）的访问端点(暴露url)和令牌服务(token services,生成令牌的规则)。 
AuthorizationServerSecurityConfigurer：用来配置令牌端点的安全约束(拦截url的规则)

uaa 项目上要把上面3个都实现后(里面配置还是有点多的)就可以访问默认的接口了:
1,如获取授权码
2,根据授权码得到令牌
3,根据令牌得到用户信息
上面是其中授权码方式(适用于第3方来调自己的服务),还有其它3种方式:
简化模式(少了获取授权码步骤),
密码模式(适用于前端页面也是自己开发的),
客户端模式(适用于自己的后端服务于后端服务通信)


上面我们都是讲的授权,当客服端(调用方)拿到令牌后,就会来访问我们的资源服务

在ClientDetailsServiceConfigurer 配置中我们配置了下面部分内容,将调用方,授权方,资源服务方联系起来了
.withClient("c1")// 只有是c1的调用方可以被访问 
.secret(new BCryptPasswordEncoder().encode("secret")) //调用方需要带的密钥
.resourceIds("res1") // 这个就是资源服务方,c1 调用方拿到令牌后只能访问res1这个资源服务方

资源服务如何验证令牌?
1,资源服务远程调用 授权服务来验证
2,JTW(它就是带用户信息的令牌,只是被加密了,防篡改;缺点就是有点长,需要解密)
资源服务自己解析令牌,和授权服务的生成令牌的方式一样

++++++++++++++++++++++++++++++++++++++++++++++
分布式 如何使用?

请求都会走网关后转发

方案2种:
1,网关初步检查客户端是否是合法的请求
2,另一种只做简单转发

推荐1网关做合法检查后并解析授权的令牌为明文(只做简单的base64)然后转发到资源服务上
这样的好处安全且资源服务计算压力减少

如果访问认证服务网关转发包含uaa的请求;
如果访问的是资源服务,网关会在filter中拦截,解析JTW转为明文(网关会保存一套和授权服务一致的JTW来解析 JTW令牌)后在转发到资源服务器上


其实资源服务上是不需要存或去查用户的信息的,因为我们走了JTW后(包含了用户的信息),用户信息都是网关会一路转下来,资源服务只需判断带来的JTW的权限是否足够
请求需要的资源; 还有网关通过filter解析明文后,会将用户信息放request头(json-token),资源服务也用filter拦截后取出,然后放入
SecurityContextHolder.getContext().SetAuthentication((Authentication)json-token) //伪代码
这样资源服务就可以做权限判断了

++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
shiro

学习视频慕课网,学习链接下面这个(跟着涛哥学shiro),重点放在1,2,3,7章节
https://www.iteye.com/blog/jinnianshilongnian-2049092


shiro 认证流程:
创建securityManager-主体提交认证(subject)-securityManager认证-Authenticator认证-Realm验证

shiro 授权流程
创建securityManager-主体提交授权(subject)-securityManager授权-Authenticator授权-Realm获取角色权限数据


shiro 访问默认会先判断用户是否登录,如果没有默认是login.jsp,可以通过下面键值对修改
authc.loginUrl=login




举例:
github有源码(该项目的配置文件架构都是值得学习的,清晰简单明了)
/**
 * 第1天
 *shiro的helloWorld
 * 模拟用户登录账号和密码和数据库进行对比(这里是缓存)
 * 包含认证(账号密码)和授权(角色权限)
 * 请运行下面代码,并跟踪断点
 *
 * 抽象:Subject中既有数据库的信息,也有用户登录的信息,两边数据都会集中到这里,就可以比对了
 */
public class AuthenticationTest {

    private SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
    //模拟数据库获取的信息
    @Before
    public void addUser() {
        //账号,密码,多个角色
        simpleAccountRealm.addAccount("huangjufei", "123", "admin", "user");
    }
    @Test
    public void test() {
        //1 创建securityManager
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //可以是数据库,缓存,或文件,这里用的是模拟缓存
        defaultSecurityManager.setRealm(simpleAccountRealm);

        SecurityUtils.setSecurityManager(defaultSecurityManager);
        //2,从静态类得到subject
        Subject subject = SecurityUtils.getSubject();
        //3,模拟用户登录的信息
        UsernamePasswordToken token = new UsernamePasswordToken("huangjufei", "123");
        /**
         * token 代码当前登录用户信息,subject有数据库中的用户信息,最好去test4跟踪断点
         */
        subject.login(token);//登录提交,这里打断点,这里就是判断逻辑的地方
        //对用户认证信息进行比对(数据库和登录的的账号密码进行对比)
        System.out.println("是否认证通过(isAuthenticated): " + subject.isAuthenticated());
        //授权检查,多个需要全部通过才通过,和SpringSecurity框架思想差不多
        subject.checkRoles("admin", "user1");
    }
}
-------------

Realm 的数据可以是缓存,可以是文件,可以数据库,helloWorld模拟的是缓存;
IniRealmTest 模拟文件中读取账号密码,了解;
-----------------------------

项目二:shiro-example-chapter16(github)

前置知识:
shiro 访问默认会先判断用户是否登录,如果没有默认是login.jsp,可以通过下面键值对修改
authc.loginUrl=login

如果shiro登录成功默认会访问"/"接口

shiro如何流转的:
1,启动tmcat,tomcat 的conf文件夹下的web.xml文件中,标识tomcat 启动后默认访问的jsp
<welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
</welcome-file-list>

2,这时马上就被shiroFilter拦截----->formAuthenticationFilter(任何请求都会先到这里来校验用户是否登录,
如果没有就会跳转到login.jsp页面),发现没有登录,然后就到了login.jsp页面

3,在web.xml配置文件中 org.springframework.web.filter.DelegatingFilterProxy(启动的时就会进入该类)
的DelegatingFilterProxy作用是自动到spring容器查找名字为shiroFilter（filter-name）
的bean并把所有Filter的操作委托给它。然后将ShiroFilter配置到spring容器即可

4,上面相当于从web.xml 的配置关联到spring-config-shiro.xml 文件中的shiroFilter的Bean了

5,如果用户在登录页面点击登录按钮-->formAuthenticationFilter(进行密码比对,如果密码错误是直接回到login方法
,提示用户密码错误;
如果密码正确会到SysUserFilter类中,然后来到"/"接口跳转到index.jsp页面(如果shiro登录成功默认会访问"/"接口))

6,然后根据用户得到该用户所拥有的菜单
(注意通配符匹配,进来的permission和resource不是对应数据库中的同一行数据)

7,然后用户点击菜单中的如用户管理,来到userController的默认接口;返回用户列表;
前端user/list.jsp中通过shiro标签控制着按钮是否显示;
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
提高篇
hashMap和红黑树
https://www.cnblogs.com/mfrank/p/9165250.html
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
设计模式

OO设计就是面向对象编程,面向对象的特征如:
封装:隐藏内部实现或抽取代码复用
继承:复用父类代码,但必须是公共统一存在的才放父类再继承
多态:父类引用指向子类,同一操作作用不同对象可以产生不同的效果;延迟运行时决定
抽象:先不考虑细节,如抽象类或接口
设计模式的六大原则:
1,里氏替换:如果用了继承就不要重写父类;要重写时说明就不该放到父类不是共性的是会改变的.变的放接口
2,依赖倒置:使用抽象代替实际,主要说的多态
3,接口隔离:一个接口只做一件事
4,合成复用:使用组合或聚合代替继承;组合比聚合耦合性更高,在Java代码中看不出区别;组合has-a,聚合part-of
5,迪米特:最少知道原则;不是直接朋友就不该出现在方法中
6,开闭原则:对扩展开发对修改关闭;不允许修改原有代码,可以提供plus版

设计模式不管是23种还是N种其实都是围绕这个6点在做文章,说白了最后不需要记住任何一种模式,而是在学习了很多设计模式后让我们更好的理解这6点原则.达到无招胜有招;当然对于常用设计模式还是要知道它的类图关系或者叫核心思路,因为每种设计模式对应特定的问题而生,
这样让我们在生产中遇到类似问题,可以快速匹配
小结:我们在写代码或任何时候看是否违反了这6点原则

一,策略模式:
解释:定义算法族,分别封装起来,让他们之间可以替换;
举例:鸭子的飞和叫不应该放父类通过继承来覆盖;这会让父类的方法越来越多,从而导致每加一个都会影响现有子类的修改,
主要违反里氏替换;
优化:对于变化的我们应该抽取成接口,通过父类和接口的组合或聚合方式来关联起来;
设计原则:接口隔离(通过将鸭子特有的飞或叫通过接口来单独封装,而不是通过继承重写),合成复用原则,使用组合代替继承
鸭子项目最后感想:
1,找出变化的通过接口抽象在原父类中通过组合代替继承.这样的好处运行时才动态的传入具体实现,随时可以切换实现
2,父类提供set方式传入实际的接口引用方法,比构造器传入好;耦合性降低
3,可以提供基础算法实现,让用户有基础的版本可以先上手使用,提高可用性.后可以通过运行时set.实际的再替换;
另:最后架构图22页,代码使用18,19,


二,观察者模式:
解释:定义了对象一对多的依赖,当一个改变时,它的依赖者都会收到通知
举例:气象台需要在气象变化时通知软件服务商,软件服务商提供不同的界面展示给注册用户.
抽象:一方的变化会通知监听者,或者被通知者监听着一方的变化;一对多的关系
一般做法:在气象变化时,写死需要被通知的方法;如果后续新增会引发修改了原代码在添加新的;主要违反了开闭原则和依赖倒置,耦合性高;
优化:通过观察者模式,通过订阅者observer注册到主题subject中,主题是持有数据的一方,订阅者是监听的一方;两边的依赖
都是通过接口来松耦合的;主题有一个list<observer>集合对象,一旦气象变化,会遍历触发observer.update接口方法,订阅者
在update实现中,添加自己的后续业务逻辑比如display()方法;display最好也是一个单独的接口;每一个订阅者对象都持有同一个公共的主题对象,这样才是一对多的关系;
设计原则:依赖倒置,接口隔离,开闭原则,合成复用原则
气象台项目最后感想:
1,特别是2个对象或多个对象或方法间的调用我们选择直接调用,如果有新增我们又找到原代码修改;这种方式是紧耦合的,
优化就是,两边都通过依赖接口的方式来产生关系,达到低耦合;
2,如果是多方的变化依赖一方,我们可以考虑观察者模式
3,接口即是变化的,又是不变化的;在策略模式中我们将变化的抽取到接口中,在观察者模式我们通过依赖不变的接口产生关系;不变的接口定义,变化的是接口实现不一样
4,接口隔离,display方法被单独抽取到一个接口类中,没有放在Observer接口中
5,jdk1.0,版就推出Observable类来简化主题类,但它是一个类不是接口不算很好,触发通知需要先调setChanged()方法;
另:架构图52页,代码实现在57,58,59;
已知使用:swing,SringMvc,等大量使用

三,装饰模式
解释:动态的将责任附加到对象上,扩展功能,装饰者提供比继承更有弹性的替代方案
举例:星巴兹咖啡,各种配料的搭配后计算总价给用户
抽象:都有价格,且需要累加;
一般做法:就是通过一个抽象类中有个cost()抽象方法,让子类都实现这个方法;然后new出好多子类就累计起来
优化:装饰者和被装饰者都有相同的超类型,动态的通过装饰模式来赋予新的功能
设计原则:开闭原则,依赖倒置
代码主要逻辑:
1,装饰和被装饰者都实现同一个抽象类(接口);
2,装饰者中持有被装饰者的引用,构造函数时传入
3,装饰者的cost会调用被装饰的cost(),这样完成价格累加
星巴兹咖啡最后感想:
1,装饰模式使用了继承,来让父子类强耦合;但其实也是可以使用接口,但不推荐,因为还是要看是否需要一些变量来和实现
关联;比如说抽象类和接口的区别;装饰类利用继承主要是达到类型匹配,而不是利用继承获得行为;
2,因为装饰和被装饰者都实现同一个抽象类(接口),所以可以相互替换;也是代码实现的关键点
另:架构图91页,代码实现在95,96,97;
已知使用:BufferedInputStream都扩展自FilterInputStream(它就是一个装饰器类)


四,简单工厂,工厂模式,抽象工厂
工厂模式解释:定义了一个创建对象的接口,由子类自我发挥,只要返回类型满足.工厂方法让类的实例化延迟到子类,运行时;
举例:加工Piazz项目,pizza各种各样做法,但什么最后都有烤,切,打包等共同环节;
抽象:变化的是不同的pizza,不变的是统一步骤;变化的由使用者决定,不变的进行封装;
由来:工厂模式由简单工厂模式转化而来,简单工厂模式违反了开闭原则,依赖倒置原则;
优化:通过工厂模式来完成,工厂模式就是一个抽象类中有一个抽象方法,作用就是创建对象,返回类型是一个抽象对象;由实现者
在运行时延迟实现;
简单工厂:通过参数变量不同,判断后new返回不同的对象,写死;新增修改会动源代码;
工厂模式:通过抽象类的抽象方法,返回值是一个抽象对象;用户实现这个方法,至于如何实现,内部逻辑不关心,
只要返回对象是抽象对象的实现类;
设计原则:依赖倒置,开闭原则
抽象工厂:就是工厂模式的抽象,没有指明具体的返回类
加工Piazz项目最后感想:
1,你要知道抽象工厂,你需要先知道工厂模式是什么,你要知道工厂模式是什么你要先知道简单工厂模式,你要知道简单工厂,你要知道工厂模式是什么你要先知道简单工厂模式new有什么不好的点;
2,目的:简单工厂是为了影藏new的过程,工厂模式让用户定义new的过程;一般使用工厂模式会开放变化部分让用户自我决定,而其它不变部分提前封装好;
3,工厂模式和模板方法模式有点类似
4,找出变化的,找出不变的.变化的让使用者去实现,延迟到运行时.不变的封装起来;关联起来时使用抽象或接口
另:架构图131,133页,代码实现在125,128,129,130;


五,单例模式
解释:一个类只有一个实例,并提供一个全局访问点
由来:比方说线程池,注册表,缓存,日志对象等都是公共一个实例,不然就会出现重复,混乱局面;我们可以通过全局变量来做到,但是这意味着这个实例不管后面是否会真正的使用都要提前创建好,会造成资源浪费.但这里也要看jvm是否在使用时才创建实例;
代码实现主要逻辑:
1,创建一个类,私有该类构造函数
2,private volatile static Singleton uniqueInstance; //创建一个变量来接收实例
3,通过双检索的方式给uniqueInstance赋值
4,提供全局访问点

单例模式最后感想:
1,如果使用静态初始化,控制权在java手上,和jvm有关,可能造成一些微妙.
2,在jdk1.2之前,单例模式实例可能被垃圾回收;
另:代码实现182页

/**
 * 单例模式就是只能有一个实例
 * 如何创建一个单例模式?
 
	想保证对象唯一需要下面3步:
	1,私有化构造函数.(其实就是类名使用private修饰)
	2,在类中先new本类对象私有并静态的.
	3,提供一个public方法可以获取到该对象.(把new对象的变量对外提供)
	
 * 单利模式分为饿汉式,和懒汉式
 * 考点:对构造器 static 方法  private public 线程 的理解
	static 在类加载到虚拟机就初始化了,和创建一个类的实例无关
	private 只能在本类中使用
	public 对外提供访问,权限一定要足够大
 
 * 懒汉只是需要的用的时候new ,但可能出现线程问题,所以加锁机制
 */
public class Danli {
	public static void main(String[] args) {
		//注意这里不能new 不能用().的方式
		Bank b = Bank.getBank();
		System.out.println(b);
		Bank2 b2 = Bank2.getBank2();
		System.out.println(b2);	
	}
}

/**
 * 饿汉式(推荐，为什么一定要选择复杂还不安全的;2个pulbic一个private)
 */
class Bank{
	//1,单例模式目的就是只能有一个实例,所以我们在把构造器私有化,这样外面就不能 new
 	private Bank(){} 		
 	//因为是饿汉式 要先new 私有话变量,static 在类加载到虚拟机就初始化了,和创建一个类的实例无关
 	private static Bank bank = new Bank();	
 	//2,然后提供一个外界可以访问的得到实例的对象引用
 	public static Bank getBank(){		
 		return bank;
 	}
}

/**
 * 懒汉式(推荐)
 */
class Bank2{
	//1,单例模式目的就是只能有一个实例,所以我们在把构造器私有化,这样外面就不能 new
 	private Bank2(){} 	
 	//因为是懒汉式调用时候在会去创建实例 ; 私有话变量,因为方法是静态,变量定义也必须静态	
 	private  volatile static Bank2 bank2;
 	//2,然后提供一个外界可以访问的得到实例的对象引用
 	public static Bank2 getBank2(){	
 		if (bank2 == null){//这里是优化数度,只有在第一次会使用到锁,锁机制很费资源和时间
 			synchronized (Bank2.class) {//可能出现线程问题					
 				if (bank2==null){
 					return bank2 = new Bank2();
 				}	
			}
 		}
 		return bank2;		
 	}
}


六,命令模式
解释:将请求封装成对象,这可以让使用不同请求,队列或者日志请求来参数化其它对象.命令模式可支持撤销
抽象:当需要发起命令者和执行者解耦时使用
举例:遥控器项目,一个万能遥控器可以添加不同的家用设备,然后控制设备的开关操作,支持后退功能;
代码实现主要逻辑:
1,抽象一个接口类Command,有一个抽象方法execute()方法;
2,发起命令类中有一个集合List<Command>类,通过遍历或者下标执行execute();
3,家用设备(执行者)实现Command的execute()方法;
4,撤销在每个执行中自我实现,在发起命令中提供一个公共方法而已,通过内部引用调用该设备的自我实现
设计原则:依赖倒置,开闭原则,针对接口编程
遥控器项目的最后感想:
1,发起命令和执行命令解耦
2,和观察者模式很像,区别在于观察者模式的订阅者依赖主题的内容;而命令模式只是触发;相对简单些
3,面向接口(抽象)编程
已知使用:多线程的执行就是一个队列执行execute(),数据库的日志记录,为了宕机时追溯
另:主要代码217,218


七,适配器模式
解释:将一个类接口转换成用户期望的另一个接口,让原本不兼容的类合作无间
抽象:转接头,usb一拖三,目的让原本不兼容的边兼容
举例:火鸡换鸭子叫声
代码实现主要逻辑:
1,定义一个接口,让被适配者实现该接口
2,适配器中拥有接口实例引用,当真正操作时适配器会调用被适配者;
设计模式:依赖倒置,合成复用原则
火鸡转鸭子项目最后感想:
1,因为适配者中有被适配者的实例引用,所以当需要时可以操作被适配者
2,适配者和被适配通过接口是松耦合的
区别对比:
装饰者意图:不改变接口,但添加功能或增强
适配器:让原本不兼容的接口,通过适配器兼容
外观:让接口操作更为简单,(迪米特原则)
已知使用:Enumeration被Itetor适配,前者是老式方式,其实最后还是调的被适配者,这样让方法名统一
另:主要架构图243,249页,代码看250即可

外观模式解释:
提供一个统一访问的接口,访问子系统的一群接口.让操作变得更加简单,也叫门面模式
抽象:比如我们按下一个电视开关按钮,但背后是复杂的流程在运行;汽车转动钥匙
设计原则:最少知道原则也叫迪米特原则


八,模板方法模式
解释:一个方法中定义一个算法的骨架,而将一些步骤延迟到子类中.模板方法可以在不改变算法的结构下,重新定义算法的某些步骤
抽象:模板方法封装不变的主流程,但让子类定义部分算法;如果使用钩子方法可以改变部分步骤
举例:泡茶或咖啡项目,它们有共同的步骤如烧水,冲泡
代码实现的主要逻辑:
1,创建一个抽象模板类,里面有需要子类自我实现的抽象方法
2,在一个final修饰的主流程方法中包含了抽象方法
3,在主流程方法中包含钩子方法,钩子方法子类根据自己的需要决定是否需要覆盖,或就是一个boolean变量,主流程会根据钩子返回的
boolean值来修改部分步骤;
茶和咖啡项目的最后感想:
1,模板方法和工厂方法差不多,既要封住不变或复杂的,又让放开变化的让使用者自定义
2,钩子有两种功能:1,当一个覆盖方法来新增逻辑;2,返回一个boolean值来改变模板流程的部分步骤
3,底层不要依赖高层,高层可以依赖底层
区别:
工厂方法:有子类决定实例化那个具体的类
模板方法:子类决定部分步骤的逻辑,和部分步骤的流程
策略:子类可以互换算法
已知使用:compareTo()方法,springJdbcTemplate等spring提供各种出来的模板方法
另:代码283,292,293,架构图289


九,迭代器设计模式
解释:提供一种方法顺序访问集合对象,而不暴露内部;
https://blog.csdn.net/wannuoge4766/article/details/90346675
举例:直接看上面这个链接;这个模式没看书,最好的例子就是java中的ArrayList
代码实现的主要逻辑:
1,如ArrayList中有一个iterator方法,这个方法返回值是一个统一Iterator接口
2,而这个方法为什么需要实现,又是因为List接口,ArrayList实现List接口,其中一个方法就是iterator()
3,而Iterator接口内的几个方法,具体实现有是ArrayList中的Itr类实现的
设计原则:依赖倒置,接口隔离,迪米特法则,合成复用
迭代模式最后感想:
1,主要是不管是什么集合都会需要循环遍历需求,如果每个集合都自己取不同的名字,使用者会难记住,导致出现迭代器
2,迭代器的好处就是统一的方法名,不同的实现.各集合通过都实现接口Iterator接口来达到统一
3,对于List,Set它们在ArrayList,HashSet的更上一层提供统一的public Iterator createIterator()方法,让它的子类
各自返回Iterator 方法;
4,用户通过调用iterator()方法会返回统一的Iterator对象,然后在可以迭代了.这里和其它设计模式不同的一点就是会返回一个
统一的接口对象;
5,和适配器不同的是,适配器主要是类型接口适配,迭代器是内部使用的方法名统一
6,结合AraayList源代码查看

十,组合模式
解释:将对象组合成树结构来表现整体/部分的层级关系.组合能让用户用一致方式处理整体和部分.
抽象:组合模式就是针对如菜单这种树形结构,统一方式处理叶子(无子元素)或节点(有子元素)
举例:菜单遍历,菜单中包含集合菜单,或叶子菜单
代码实现逻辑:
1,创建抽象类MenuComponent,含有方法如add,remove,getChild,getName,print等方法
2,节点和叶子节点都必须实现或继承它,但各自重写的方法不同;比如叶子不需要add,remove,getChild等方法
3,节点节点中包含一个ArrayList MenuComponents = new ArrayList();的儿子集合,且重写add,remove,getChild方法
.在print打印方法中先打印自己的name后又通过迭代循环打印儿子节点
4,服务员接收一个MenuComponent抽象类,然后调用print()就可以输出整树菜单
设计原则:依赖倒置,合成复用
组合模式最后感性:
1,先学会了迭代模式在来看组合模式,迭代模式就是循环一个集合,组合模式就循环多个集合(包含多个节点和叶子元素)
2,组合模式统一的方法来输出节点和叶子;方法名都一致
3,组合模式如果使用抽象类来重写违反了里氏替换原则和接口单一原则,但换取统一透明
4,组合模式就是在解决树形结构这种工作中常遇到的问题
另:架构图359页,代码360-365;










tomcat 使用到的设计模式有:
门面模式,观察模式(也叫发布订阅模式),命令模式,责任链模式
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
小算法：
需求：一个list，根据专家名字分组成多个list；
（自己可以创建一个简单对象就可以测试包含name，code）有的人要循环3次，有的人2次；
Map map = new HashMap<Person>();
lists.forEash(l->{
	if(map.containsKey(l.getName()))
		map.put(l.getName(),new ArrayList<Person>());
		map.get(l.getName).add(l);//这里其实是两步
});


++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++

微信授权
https://open.weixin.qq.com/cgi-bin/index?t=home/index&lang=zh_CN
1,通过qq邮箱注册账号

++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++

document.getElementById("some id")。这个方法是 HTML DOM 中定义的。
DOM (Document Object Model)（文档对象模型）是用于访问 HTML 元素的正式 W3C 标准。

------------
如需使用外部文件，请在 <script> 标签的 "src" 属性中设置该 .js 文件：
<script src="myScript.js"></script>
-----------
js变量需要通过var 申明,但在function()函数中就可以不用申明,这时就变为全局变量
-----------
JavaScript 数据类型
值类型(基本类型)：字符串（String）、数字(Number)、布尔(Boolean)、对空（Null）、未定义（Undefined）、Symbol。
引用数据类型：对象(Object)、数组(Array)、函数(Function)。
-----------
JavaScript 对象
对象由花括号分隔。在括号内部，对象的属性以名称和值对的形式 (name : value) 来定义。属性由逗号分隔
var person={firstname:"John", lastname:"Doe", id:5566};
-----------
对象属性有两种寻址方式：
实例
name=person.lastname;
name=person["lastname"];
------------------
js 的函数参数,可以和调用的个数不一致;
------------
全局 JavaScript 变量
在函数外声明的变量是全局变量，网页上的所有脚本和函数都能访问它。
---------------
$(function(){
// do something
});
其实这个bai就是jq ready()的简写，他等价du于：
$(document).ready(function(){
//do something
})
//或者下面这个方法，jQuer的默认参数是：“document”；
$().ready(function(){
//do something
})
这个就是jq ready()的方法就是Dom Ready，他的作用或者意义就是:在DOM加载完成后就可以可以对DOM进行操作。
-------------
JS中的window对象

所有浏览器都支持window对象。他表示浏览器窗口。
$(function){
	window.rolleId = "123";
	var na = "a";//它们两个都是全局变量;
}


所有JavaScript全局对象、函数以及变量均自动成为window对象的成员。
全局变量是window对象的属性
全局函数是window对象的方法
--------------------
在 JavaScript 中对象 使用 名字作为索引。(本身是不支持数组名字索引的只是转为了对象)

如果你使用名字作为索引，当访问数组时，JavaScript 会把数组重新定义为标准对象。

执行这样操作后，数组的方法及属性将不能再使用，否则会产生错误:

实例
var person = [];
person["firstName"] = "John";
person["lastName"] = "Doe";
person["age"] = 46;
var x = person.length;         // person.length 返回 0
var y = person[0];             // person[0] 返回 undefined
--------------------

if (myObj !== null && typeof myObj !== "undefined") //错误的判断方式
	
正确的方式是我们需要先使用 typeof 来检测对象是否已定义：

if (typeof myObj !== "undefined" && myObj !== null) 
--------------------
程序块作用域
在每个代码块中 JavaScript 不会创建一个新的作用域，一般各个代码块的作用域都是全局的。

以下代码的的变量 i 返回 10，而不是 undefined：

实例
for (var i = 0; i < 10; i++) {
    // some code
}
return i;//返回10
--------------------
--------------------
jQuery 语法

//jquery 中文手册
https://jquery.cuishifeng.cn/
主要分 基本 - 层级 - 基本筛选器 等这样来得到想到dom元素

jquery 本质就是一个函数,得到的就是dom数组

$ == window.$ == jQuery //源码可以看到

基础语法： $(selector).action()

美元符号定义 jQuery
选择符（selector）"查询"和"查找" HTML 元素
jQuery 的 action() 执行对元素的操作
--------------------
jQuery 入口函数:
为了防止文档在完全加载（就绪）之前运行 jQuery 代码即在 DOM 加载完成后才可以对 DOM 进行操作。
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
jQuery 入口函数与 JavaScript 入口函数的区别：

 jQuery 的入口函数是在 html 所有标签(DOM)都加载之后，就会去执行。
 JavaScript 的 window.onload 事件是等到所有内容，包括外部图片之类的文件加载完后，才会执行。
--------------------
jQuery load() 方法是简单但强大的 AJAX 方法。

load() 方法从服务器(本地)加载数据，并把返回的数据放入被选元素中(页面会被直接回填数据)。

语法:
$(selector).load(URL,data,callback);
必需的 URL 参数规定您希望加载的 URL。
可选的 data 参数规定与请求一同发送的查询字符串键/值对集合。
可选的 callback 参数是 load() 方法完成后所执行的函数名称。
--------------------
语法:
$.post(URL,data,callback);
必需的 URL 参数规定您希望请求的 URL。
可选的 data 参数规定连同请求发送的数据。
可选的 callback 参数是请求成功后所执行的函数名。

下面的例子使用 $.post() 连同请求一起发送数据：
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
--------------------
软件评测师
软件设计师
软件过程能力评估师
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
google 邮箱账号,密码就是google登录账号
feijuhuang@gwmail.com
28160997@qq.com
++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
编程 = 数据结构 + 算法 + 设计模式
巧妇难为无米之炊的米就是数据
数据:描述客观事物的符号,可以被计算机识别和操作;
数据元素就是客观的事物,独立的单元,如人,牛;
数据类型就是对数据元素的抽象,作用是让计算对数据元素进行分类处理
比如int,char
数据结构是数据元素相互之间存在一种或多种特定关系
数据结构从不同的角度有不同的分类:
我们先从逻辑和物理进行分:
逻辑分为:集合,线性,树形,图形;
物理分为:顺序存储结构和链接存储结构
算法就是解决问特定问题的步骤,是一个抽象提取的过程;在计算机中表现为指令的有限序列
设计模式是解决复杂问题的特定的架构,引用这些模式让解决问题清晰化,简单化;
算法好比战术,设计模式好比战略;小问题算法足以,大项目需要有设计模式才能健壮
线性表:零个或多个数据元素的有限序列
线性存储的适用于查多,删除和添加少的场景;因为会全部移动位置;支持任意位置查询
有点类似数组
线性链式存储就是在线性存储基础上多了指向下一个节点的指针区域,双链式包含指向上一个和下一个的指针的区域
链表的优势在于不会因为插入或删除移动后面的整体元素
顺序存储和删除单链表储存(O(n),O(1)),查询时反之
环形链表就是尾节点的指针指向头节点,这样就形成成一个回路;判断时需要先判断下一个不为null且不等于头节点,才next
;两个环形节点合并也是比较方便的,只需将一个环形链表的尾指针指向另一个环形链表的头结点,尾结点指向另一个头结点;
队列 :先进先出,尾端进,头端出;有2个口
栈 : 后进先出,尾部进尾部出,只有一个口
链式存储 : 就是链表,有数据区和指针区,数据区存数据,指针区存在一个节点的位置
可能有头节点(放公共的内容),最后一个节点的指针区是null
栈的链式存储叫栈链,栈链没有头结点,直接就是top指向栈顶,不存在溢出情况,除非物理内存吃完
栈链和顺序栈的存和取都是O(1),顺序栈和需要事前确定一个固定的长度,栈链不需要,
栈链还多了一个指向下一个节点的指针域;
在数据结构中只要是顺序存储就是一段联系的储存单元,且需要事前定义固定的长度;固定长度可能导致比如短信固定70个字;
栈的作用比如递归,就是一个进栈,出栈的过程;比如计算器就是,中继表达式转后继表达式
遇到符号弹出2个数字就计算
队列的链式储存就是线性表的单链表,只不过它只能尾进,头出而已;

串
就是字符串,就是一个或多个字符的集;
串也分顺序存储和链式存储
顺序存储速度快,但长度固定;链式存储可以很轻松的连接多个字符串

树

树是n个结点的有限集.n=0称为空树,在任意一个非空树有且只有一个根root结点;
n>1时,分为互相不相交的子节点,其中每一个集合本身又是一棵树称为根子树;
根,双亲(子根),兄弟,堂兄;树的高度就是树的深度,

二叉树的特点:
1,每个节点最多有两棵子树,没有子树或只有一个子树是可以的
2,左右子树有顺序的

满二叉树,是最完美的2叉树,其次是完全2叉树,完全2叉树空节点也必须有节点站位,且叶子节点从左开始

二叉树的存储也分顺序存储和链表储存
顺序存储如果是偏树需要大量null节点站位,十分消耗空间;
链表存储格式为 lchild data rchild 每个节点有左右两个指针,指向左右两个儿子,这样大大减少空节点

二叉树的遍历:

是指从根节点出发,按照某种次序依次访问二叉树,每个节点都被访问一次,且仅为一次
如果按从左到右的习惯主要分4种:
1,前序,2,中序,3,后序,4,层级
前序和中序的区别:
前序和中序的区别就是打印时机不一样
前序立即打印,中序返回后才打印;前序从根节点开始打印,中序从左叶开始打印
中序和后序的区别:
后序也从左叶开始打印,然后打印兄弟节点,而中序是打完左叶子后打印父节点在到兄弟
二叉树的遍历总结:都是转为线性转换遍历

二叉树的创建:
二叉树的创建就是补全空节点,然后通过如前序递归成线性链

树,森林和2叉树的互转:
1,加线2,去线3,转角度
比如说树转2叉
1,在所有兄弟间加线
2,保留第一个孩子的连线,删除其他孩子的线
3,以树的根为轴心,调整角度;注意第一个孩子是二叉树的左孩子,兄弟转转换过来的孩子是节点的右孩子,最后一句容易错
反转的就是一个逆向的过程

++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
oracle

表--segment--区--连续的块
share pool -- data buffer -- 磁盘(非常慢)



++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++
三国演义
第一集
黄巾起义,当时皇帝兵力不足,让各个区自己守城;这样的结果就是后期各个区会自立
为王,群雄争霸的局面马上就会出现;刘备看到了这种局面才有了召集关羽和张飞后续之事;
乱世造英雄,古代一个甲子60年一般就是最有可能出现乱世的局面
----
关羽取肉,自己不要一份,全部分给老百姓;这种品质最后导致关羽一直被祭拜的原因.
---
刘备卖草席,关羽卖绿豆,天空突然下雨的情况下才把他们聚到张飞家中;天时很重要
所以有时,你需要创造这种天时
---
张飞试探关羽功夫,故意捏碎关羽绿豆激怒关羽后,才知道关羽是否有真功夫!
如果不用这种方法,关羽是不会给张飞交手的
---
刘备劝架时第一句话就是先夸奖两位,这样才同时打消张飞和关羽的对刘备的防范;
中国人不管你做什么,主要看你的立场是否和我一致;
---
刘备故意说话慢吞吞,就是为了让关羽和张飞相信,如果一来就开口说出身份,别人
会怀疑,且别人会解决你神经病;中国人不会对不熟的人敞开心扉,所以为什么很多事情要
在酒桌上谈;
---
　　“谋定而后动，知止而有得”意即：在做事之前，先考虑清楚做这件事的后果和过程，
然后再去做；懂得何时停止行动,会有不错的收获或者所得。
-------
刘备刚得到的县令,督邮就来索要钱财被张飞毒打后辞职了.
---
督邮对刘备说大树底下好乘凉等一些话暗示刘备出钱,从中开出中国从古到今都是
腐败问题都存在;官比老百姓有钱;当官要找靠山,打工要找大公司,这样相对来说没
那么累;
---
由于刘备说没钱,督邮通过 ”贼咬一口，入骨三分“，意思是指被坏人诬陷，难以辩白，受害极深。
在城中贴告示,让百姓举报刘备;这样的目的就是为了敛财;有些官员被起底都和这种有关
---
张飞在家中要去打督邮但被关羽拦住,但最后张飞在外面还是打了督邮;
关羽在外面没有说张飞是一致对外的;兄弟之间在外面要一致对外,什么事回家里在说
---
当他们3人结义后,在外面时都是由大哥先发话
+++++++++++++++++++++++++++++++++++++++++
第二集
汉灵帝刘宏死后留下两个儿子刘辩和刘协,刘辩大5岁;还有一个妻子何皇后和董太后;
古代女人要么依赖儿子要么依赖丈夫,何太后想让自己的儿子做皇帝,董太后想刘协
做皇帝,两个女人有相同的处境却有不同的目标这时就出现2个婆媳对干的局面;
婆媳两个女人都是没有血缘关系的人,他们的存在都是通过丈夫或儿子产生的关系,所以
当儿子和丈夫死后他们的关系基本就不复存在了;
后宫大部分事情都需要宦官打理,这时就出现10常侍在2个女人之间的选择.何皇后把自己的
哥哥大将军何进安排进宫顺利的让刘辩上位做了皇帝;何进性格非常鲁莽,不停曹操的建议
独自入宫结果被10常侍杀了;说明当时宦官直接干于朝政;
曹操建议何进意见时,何进反而说曹操是宦官之后,这种狠话都是一把回头箭,早晚会伤到自己,
所以无关怎么样别人最痛的点不要要提及;就算别人的建议你不采纳也不要马上回怼;何进死就在于
狂妄自大;

何皇后找董太后协商时,董太后说"难道你还刚杀我不成"这种话是不能说的,这种话可能让对方原本没有这个
想法的人就又了这样的想法,最后让董太后心想事成;
何皇后先是让董太后还乡然后通过赏识毒酒赐死董太后;这样2步走作用非常大;首先让你实力大减,
(其实一般出皇宫就意味着死,一般都会派人监视,就是所谓的软禁)然后在乡下了,没人知道;
中国历来都是斩草除根;不然后人一定毕生目标就是报仇;

最后10常侍杀死何进之后相当于就是挟持皇帝谋反,皇帝外逃被董卓救后;董卓为了让自己的势力提升,就
需要改变原有路线,所以又让刘协做了皇帝;这个法则也是从古到今没变的;

何太后和何进2个人最后都没好下场,就是因为何太后简单的认为外面的事,和何进简单的认为后宫的事,
所以家庭还是需要分工合作,女人往往主内比男人更好;不适合处理外面的事情,因为外面的世界她往往接触得
太少;
+++++++++++++++++++++++++++++++++++++++++
第三集


李肃通过分析武将吕布差一坐骑,武将3样装备不能少(兵器盔甲坐骑);然后带上赤兔马和财物去策反吕布,
把董卓说得是顺先帝之意,刘辩无能;众臣不敢说,只是为了自己官职,而董卓敢于说出来了,还说何皇后杀死
皇太后等一些话让吕布动心;吕布动心后自己主动杀自己第一个义父丁原,后投靠董卓又拜董卓为义父;
这种无德之人董卓也敢要,最后下场何丁原一样;现在公司只看中能力,不看重品德;最后这些有能力的人
就可以是公司被策反之人;

董卓得到吕布后又找群臣吃饭,说要让刘协当皇帝之事;这种饭,说完你不反对就是同意的意思;中国人不需要说
太多,各个心知肚明;如果当时反对可能会被杀,如果事后反对也是很不好的.这种饭就是很难吃的;
董卓成功的让刘协登基后,刘辩被贬为藩王;何皇后自杀;

董卓通过废旧立新让刘协登基,主要目的就是让自己官职高升;但这种人往往后面都会暴死,因为群臣都不喜欢他.

一件事情可以顺取也可以逆取,但最后都必须顺守;董卓就属于后者但往往得到权力的人都会为所欲为,不知道顺守;

+++++++++++++++++++++++++++++++++++++++++
第四集

王允假做寿邀请众臣商量讨伐董卓,这样才可以避开董卓的眼线,是为了保护自己和众臣.
曹操献计"亲信之人防不胜防"

曹操正在刺杀董卓时还是被卢布岔开了,曹操马上随机应变说自己是来献七星宝刀给董卓的,然后保持镇定
得骑试宝马逃跑了;

吕布和董卓等曹操逃跑后才觉得不对,李儒献计董卓 "请曹操在来府上,如果来就是真献宝刀,不然就是刺杀";

曹操跑到陈宫县内,被手下的人捉住;陈宫说"此人确有几分相识",没有选择上交曹操换取大量财物,
或直接放走曹操,而是选择了暂时关押曹操;然后在夜里突然喊曹操当时把曹操吓了一跳,这样陈宫肯定他就是曹操
,陈宫想跟一个明主做大事,和曹操几番交谈后弃官随曹操一起逃跑,后来到曹操爹的熟人吕伯奢家中.

吕伯奢说"现在到处都在抓你,你犯了什么事",后又说出门去打好酒,曹操在梦里被
外面的磨刀声音惊醒后想起吕伯奢白天的举动,就杀了全家包含妇女小孩;后进入厨房才发现是杀猪要款待曹操
,曹操又继续逃跑,在路上又遇到买酒回家的吕伯奢,本来曹操不打算杀他的,但吕伯奢说"你身上怎么有血"这样曹操
知道以后无法隐瞒了又把吕伯奢杀了,陈宫心情低入谷底问曹操为何;曹操说"宁教我负天下人，休教天下人负我",
后陈宫决定不再跟随曹操,他们分开逃跑了.从这里可以看出在很敏感的话题要小心,不然就引来大祸.

+++++++++++++++++++++++++++++++++++++++++
第五集
团结就是力量
袁绍召集的18路兵马进攻洛阳,准备讨伐董卓;但这种临时召集的团队,虽然人多但各个心怀鬼胎;
比如孙坚就要拿下洛阳时,袁术怕他独自得到功绩就不发粮草,导致孙坚失败;

华雄再连斩袁绍多名大将的情况下,关羽温酒斩华雄;曹操当时就看上了关羽;
吕布一人同时战张飞,关羽,刘备3人都没分出胜负,可见吕布功夫了得,董卓怕吕布吃亏,鸣金收兵保
吕布;因为吕布是董卓手下的核心武将;后李儒建议董卓迁都长安;因为长安之地西汉东汉延续了很多代.
在董卓迁都时,曹操要袁绍追击董卓;袁绍没有同意,把曹操气惨了;
+++++++++++++++++++++++++++++++++++++++++
第六集

人与人之间平时最好有些交情,不然有事之时就吃亏;
比如曹操带兵去追击董卓结果被埋伏,打了败仗;但袁绍还摆酒席给曹操压压惊,说"胜败乃兵家常事"
还有一般是常常打败仗的人,会取得最后的胜利;曹操就是一个例子;

王允有个养女叫貂蝉,芳年16;王允先是表现出焦虑后被貂蝉发现,在貂蝉叹气时,王允责骂貂蝉,貂蝉解释,
说愿为主人献出生命,这种情况下;王允才告诉貂蝉连环计;"先许配貂蝉给吕布,然后在嫁给董卓,离间他们",
让吕布杀董卓;王允当时叩拜貂蝉几次;貂蝉也保证不说出王允的计策,因为这是灭门之灾;王允邀董卓到家中
商量国事,又献歌妓貂蝉28岁给董卓;

演戏和撒谎是不一样的;
王允演戏告诉吕布,是董卓说事今晚要去王允家做客,然后问家中有一女要许配给自己的义子;让此女出来看看,
然后说今日就是良日先把此女接回府上准备给自己义子;这样一说让吕布还以为董卓也在为自己着想;结果后来
发现董卓已和貂蝉睡一起了;所以非常生气;后吕布又找貂蝉核对事情,貂蝉又选后园和吕布约见,又诉苦,还要
已死来证明自己的清白;在亲热之时又让董卓看见;一系列的连环计让吕布和董卓都想杀了对方;貂蝉在两边都
以死来欺骗吕布和董卓;

但当时李儒告诉董卓"貂蝉只是一个普通女子,而吕布是董卓称王的必要因数",董卓还是恍然大悟,准备许配貂蝉
给吕布,好让吕布对自己死心塌地;问貂蝉意见时,貂蝉又已死不愿意;


++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

平穷的本质:
1,没有长远打算,没有一技之长;(很容易的学习的技能都是不值钱的技能,要找一个很难掌握且需要不断学习的技能)
2,只顾眼前利益,或看中小利益;(很多小单位没有五险一金,或有些工作马上上手就可以找到钱,但随着时间的增长却没有工资提升)
3,不善于总结(所有知识都是可以被归类总结,这样的好处你可以看清整体和局部这样全面掌握它,整理总结就是画金字塔的过程)
4,爱好广泛(如爱好游戏,爱好看小说,爱好看电视剧,无关紧要的人际交往有了这样,哪有时间学习)
5,不会独处,个性不够坚韧(学习和思考的前提)
总结举例:
一技之长 -- 需要大量学习 -- 学习又学习能力(包含学习方法)有关-- 学习能力的强弱和学校所学的基础知识,付出时间,坚韧度有关;




      9.7
2020.1.26 最后一次月经
	 11.5 预产期
2020年2月7号怀上,周日
	 
