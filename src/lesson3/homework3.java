package lesson3;

import java.util.Random;
import java.util.Scanner;

public class homework3 {

	public static void main(String[] args) {
		start();
		}
	
	public static void start() {
		
		Scanner inw = new Scanner(System.in);
		System.out.println("Input nuber test \n"
				+ "1: Вспомним про операторы. Показать примеры работы оставшихся операторов");
		System.out.println("2: Проверить результат формулы из второго теста ВТОРОЙ лекции. Если результат меньше 5,\n"
				+ "то вывести в консоль одну строку, если больше - другую. Строки могут быть любыми. Сделать с помощью \n"
				+ "условного и тернарного операторов.");
		System.out.println("3: В зависимости от аргумента, который передается в метод, \nдолжен отрабатывать один из тестов домашнего задания.");
		System.out.println("4: Вывести пять раз строку из четвертого теста ВТОРОЙ лекции. \nИспользовать код именно этого задания.");
		System.out.println("5: Вывести в консоль числа от 1 до 10 последовательно с новой строки. ");
		
		int numbertest = inw.nextInt();
		System.out.println("Good. Your choice is " +numbertest);
		
		 switch (numbertest) {
         case 1:  gettest1();break;
         case 2:  gettest2();break;
         case 3:  System.out.println("see above ;)");;break;
         case 4:  gettest4();break;
         case 5: int i =1; while (i<11) {System.out.println(i);i++;}break;
         default: 
        	 System.out.println(numbertest+" invalid number. " );
        	 break;
		 }
		 inw.close(); 
	}
	
	public static void testMethod(int index, String str) {
		System.out.println("Hello, "+str+"!");
		System.out.println("There is true, that there are "+index+" percent sucess with ");
		System.out.println("0.99 happiness.");
}
	
	public static double formulaHW2(double argument){
		double res;
		res = ((0.11 + argument*(20 /3)) % 5)*argument-.4451999999999999; 
		return res;
	}
	
	public static void gettest1(){
		// Arithmetic Operators + - - / % 
		double a, b;
		a = 0.48;
		b = ((0.11 + a*(20 /3)) % 5)*a-.4451999999999999; 
		System.out.println("a)Arithmetic Operators + - - / % ");
		System.out.println("\ta="+a);
		System.out.println("\tb=((0.11 + a*(20 /3)) % 5)*a-.4451999999999999 = " +b);
		
		// Unary Operators + - ++ -- !  
		boolean a1=true;
		int b1=5,c1=5,d1=5,e1=5;
		b1 += 1;
        c1 -= 2;
        d1++;
        e1--;
        System.out.println("\nb)Unary Operators + - ++ -- ! ");
		System.out.println("\tb1,c1,d1,e1 = 5");
		System.out.println("\tb1+=1 ==> b1="+b1);
		System.out.println("\tc1-=2 ==> c1="+c1);		
		System.out.println("\td1++ ==> d1="+d1);
		System.out.println("\te1-- ==> e1="+e1);
		System.out.println("\ttrue == !"+!a1);
		
		// Equality and Relational Operators == != > >= < <=
		 System.out.println("\nc)Equality and Relational Operators == != > >= < <= ");
		 System.out.println("5==5 its " + (b1==5));
		 System.out.println("5!=6 its " + (5!=6));
		 System.out.println("5> 6 its " + (5>6));
		 System.out.println("5>=5 its " + (5>=5));
		 System.out.println("5<=6 its " + (5<=6));
		 
		//Conditional Operators &&  ||  ?:
		 int a3=3,b3=4;
		 System.out.println("\nd)Conditional Operators &&  ||  ?");
		 System.out.println("true &&(and) false is " + (a1 && false));
		 System.out.println("true ||(or) false is " + (a1 || false));
		 System.out.println("Выберем меньшее из чисел: 3 или 4 (3 < 4 ? 3 : 4)  ==>" + (a3 < b3 ? a3 : b3)  );
	}
	
	public static void gettest2(){
		final Random random = new Random();
		int i = random.nextInt(10); 
		double res = formulaHW2(i);
			System.out.println("result = "+res);
			if(res<5){
				System.out.println("(if) result is less than 5");
			}else{
				System.out.println("(if) result is more or equal than 5");
			}
			System.out.println("(?:) result is "+(res < 5 ? "less" : "more or equal")+" than 5");
					
		
	}
	
	public static void gettest4(){
		String name = "U-Rise";
		int index = 100;
		for (int i = 1; i < 6; i++) {
			System.out.println("-------------- "+i+" --------------");
			testMethod( index, name);	
		}
	}
		
	

}
