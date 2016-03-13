package lesson2;

import java.util.Random;
/* тест1 Показать работу со всеми изученными операторами
 *  
 * тест2 Создать и запустить метод, который возвращает результат некоторой формулы. 
 * Вывести в консоль этот результат. Формулу выбрать на свое усмотрение.
 * 
 * тест3 Напишите метод, который выводит в консоль любую заданную строку, и запустите его.
 * 
 * тест4 Выполните первое домашнее задание с использованием методов.
 
 */
public class homework2 {

	public static void main(String[] args) {
		final char COMMA = ',';
		int all;
		double a,b;
		boolean istrue = false;
		final Random random = new Random();
		String	s1 = "There is ";
		String  s2 = COMMA +" that there are ";
		String 	s3 = " sucess with ";
		String 	s4 = " happiness.";
		istrue =  !(istrue);
		a = 0.48;
		b = ((0.11 + a*(20 /3)) % 5)*a-.4451999999999999;

		all = random.nextInt(100);
	
		System.out.println("Hello, U-Rise!");
		System.out.print(s1 + istrue + s2 );
		testMethod(all, " percent"+s3);
		System.out.println(b + s4);
		
		int[] arg = {1, 3, 4, 6};
		String[] oper = {"*","/","+","-"};
		get24(arg,oper);
		
		}
	
	public static void testMethod(int index, String str) {
		String howMorePeoples;
		while(index != 100){
			index++;	
		} 
		howMorePeoples = index + str;
		System.out.println(howMorePeoples);	
	}

	public static void get24(int[] a, String[] b ){
	/*Используя числа 1, 3, 4, 6, арифметические операции 
	 *(сложение, вычитание, умножение, деление) и скобки, 
	 *получить число 24. Разрешается использовать только 
	 *эти числа и только эти операции. Каждое число должно
	 * использоваться один и только один раз. Операции и 
	 * скобки можно использовать любое число раз. Нельзя 
	 * объединять числа как цифры, составляя например 13 
	 * или 146.
	 * http://nazva.net/902/
	 */
		String res="";
		double result;
	for (int  i1 : a ){
		for (int  i2 : a ){
			//if (i2==i1 ){
			//	continue;
			//	}
			
			for(int  i3 : a ){
				//if (i3==i2 || i3==i1){
				//	continue;
				//	}
				
				
				for(int  i4 : a ){
					//if (i4==i3 || i4==i2 || i4==i1){
					//continue;
					//}
					
					
					for(String b1 : b ){
						
						for(String b2 : b ){
							
							for(String b3 : b ){
								result = raschet(i1,i2,b1);
								res = ""+i1+b1+i2;
								result = raschet(result,i3,b2);
								res = raschetStr(res, i3,b2);
								result = raschet(result,i4,b3);
								res = raschetStr(res, i4,b3);
								if (result==24d){
									System.out.println(res +" = "+result);
		
								}
								
								res =""; result =0;
								}
							}			
						}	
					}
				}
			}
		
	} 	
	}
	public static String raschetStr (String a1, int a2, String b){
		String retur = "";
		
		if (b =="*"|| b=="/"){
			retur = "("+a1+")"+b+a2;
			}else{
			retur = ""+a1+""+b+a2;	
			}
		return retur;  
				
		
	}
	public static double raschet (double a1, int a2, String b){
		double ret=0;
		if (b == "*"){
			ret=  a1*a2;
		}
		if (b == "/"){
			ret=  a1/a2;
		}
		if (b == "+"){
			ret=  a1+a2;
		}
		if (b == "-"){
			ret=  a1-a2;
		}
		
		return ret;     
	}

}
