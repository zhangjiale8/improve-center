package com.zjl.javase.notion;

public class javaSentence {
	/**
	 * 
		5.语句：

			If  switch  do while   while  for

		这些语句什么时候用？

			1）、当判断固定个数的值的时候，可以使用if，也可以使用switch。

			但是建议使用switch，效率相对较高。

			switch(变量){

 				case 值:要执行的语句;break;

 					…

 				default:要执行的语句;

			}

 			工作原理：用小括号中的变量的值依次和case后面的值进行对比，和哪个case后面的值相同了

           	就执行哪个case后面的语句，如果没有相同的则执行default后面的语句；

 			细节：
 				1）：break是可以省略的，如果省略了就一直执行到遇到break为止；

   				2）：switch 后面的小括号中的变量应该是byte,char,short,int四种类型中的一种；

   				3）：default可以写在switch结构中的任意位置；如果将default语句放在了第一行，则不管expression与case中的value是否匹配，程序会从default开始执行直到第一个break出现。

			2）、当判断数据范围，获取判断运算结果boolean类型时，需要使用if。

			3）、当某些语句需要执行很多次时，就用循环结构。

			while和for可以进行互换。

				区别在于：如果需要定义变量控制循环次数。建议使用for。因为for循环完毕，变量在内存中释放。

 

			break:作用于switch ，和循环语句，用于跳出，或者称为结束。

			break语句单独存在时，下面不要定义其他语句，因为执行不到，编译会失败。当循环嵌套时，break只跳出当前所在循环。要跳出嵌套中的外部循环，只要给循环起名字即可，这个名字称之为标号。

			continue:只作用于循环结构，继续循环用的。

			作用：结束本次循环，继续下次循环。该语句单独存在时，下面不可以定义语句，执行不到。
			
	 */
}
