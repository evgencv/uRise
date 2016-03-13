package lesson5;


import java.io.IOException;
import java.util.Scanner;

public class homework5 {
	
	private static Scanner in;
	public static void main(String[] arg) throws IOException {
		
	
	Scanner inw = new Scanner(System.in);
	System.out.println("1: Задано три значения. Написать условие того, что три заданных значения задают стороны прямоугольного треугольника. \n(третья сторона равна корню из суммы квадратов остальных сторон, теорема пифагора,");
	System.out.println("2: Задано три значения. Написать условие того, что три заданных значения задают стороны равнобедренного треугольника");
	System.out.println("3: Задано шесть значений. Написать условие того, что шесть заданных чисел являются сторонами двух равносторонних \nтреугольника (не найти среди них два равносторонних треугольника, а проверить, что эти шесть чисел соответствуют заданному условию).");
	System.out.println("4: Задано четырехцифровое число. Определить, является ли его сумма цифр четной. ");
	System.out.println("5: Задано четырехцифровое число. Определить, является ли оно палиндромом (читается справа налево и обратно \nодинаково, например, 3993).");
	System.out.println("6: Задано четырехцифровое число. Определить, являются ли сумма одной половины цифр этого числа равна сумме \nдругой половины цифр.");
	System.out.println("7: Задано четырехцифровое число. Определить, является ли каждая цифра не меньше следующей цифры в этом числе.");
	
	System.out.print("\n Ваш выбор?");
	int numbertest = inw.nextInt();
	System.out.println("Вы выбрали:  " +numbertest);
	
	 switch (numbertest) {
     case 1:  gettest1();break;
     case 2:  gettest2();break;
     case 3:  gettest3();break;
     case 4:  gettest4();break;
     case 5:  gettest5();break;
     case 6:  gettest6();break;
     case 7:  gettest7();break;
     default: 
    	 System.out.println(numbertest+" не корректный ввод. " );
    	 break;
	 }
	 inw.close(); 
	}
	
	
	public static void gettest1(){
		double[] arr = new double[3];
		arr = inputString("Введите размеры 3х сторон треугольника","Вы ввели стороны:",3);
		
		if (!hasTriangle(arr)){
			System.out.println("\nТаких треугольников никто не видел");
			return;
		}
		
		if (hasRightTriangle(arr)) {
			System.out.println("\nТреугольник прямоугольный");
		}else{
			System.out.println("\nТреугольник НЕ прямоугольный");
		}
		
		
	}
	
	public static void gettest2(){   
		double[] arr = new double[3];
		arr = inputString("Введите размеры 3х сторон треугольника","Вы ввели стороны:",3);
		
		if (!hasTriangle(arr)){
			System.out.println("\nТаких треугольников никто не видел");
			return;
		}
		
		if (hasIsoscelesTriangle(arr)) {
			System.out.println("\nТреугольник равнобедренный");
		}else{
			System.out.println("\nТреугольник НЕ равнобедренный");
		}
	}
		
	public static void gettest3(){
		double[] arr = new double[6];
		int kolvoOdinakovihPar = 0;
		
		arr = inputString("Введите размеры сторон двух треугольников","Вы ввели стороны:",6);
		
		if (!hasTriangle(arr)){
			System.out.println("\nТаких треугольников никто не видел");
			return;
		}
				
		// (Вариант1) все значения в перемешку
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]){
					kolvoOdinakovihPar ++;
					System.out.print("\nНашли "+kolvoOdinakovihPar+"-ю пару чисел. Это : " + (i+1) +" и " +(j+1)+ " сторона." );
				}
			}
		}
		if (kolvoOdinakovihPar >=2) {
			System.out.println("\nТут есть два равносторонних треугольника (Вариант1)");
		}
		
		// (Вариант2) сначала стороны 1 потом 2 треугольника
		double[] Triangle1 = {arr[0],arr[1],arr[2]};
		double[] Triangle2 = {arr[3],arr[4],arr[5]};
		
		if (hasIsoscelesTriangle(Triangle1) & hasIsoscelesTriangle(Triangle1) ){
			System.out.println("Тут есть два равносторонних треугольника (Вариант2)");
		}
		
	}
	
	public static void gettest4(){
		int suma = 0;
		int a = input4sybol(); 
		
		while(a>0){
			suma = suma + (a % 10);
			a/=10;			
		}
		System.out.print("Сумма цифр этого числа - "+suma);
		System.out.println(" она - "+ (suma%2 ==0 ? "четная":"не четная"));
	}
	
	public static void gettest5(){
		int a = input4sybol(); 
		int b = 0;
		int temp = a;
		
		while(temp>0){
			b = b*10 + (temp% 10);
			temp/=10;			
		}
		if (b == a) {
			System.out.println("Это полиндром "+b+" == "+a );
		}else{
			System.out.println("Это не полиндром "+b+" != "+a );
		}
	}
	
	public static void gettest6(){
		int a = input4sybol(); 
		int temp = a;
		int[] s = new int[4];
		for (int i = 0; i < 4; i++) {
			s[i] = temp%10;
			temp/=10;
		}
		if (s[0]+s[1] == s[2]+s[3]){
			System.out.println("Cумма одной половины цифр числа "+a+" равна сумме другой половины цифр.");
		}else{
			System.out.println("Cумма одной половины цифр числа "+a+" НЕ равна сумме другой половины цифр.");
		}
	}
	
	public static void gettest7(){
		int a = input4sybol(); 
		int temp = a;
		int[] s = new int[4];
		for (int i = 0; i < 4; i++) {
			s[i] = temp%10;
			temp/=10;
		}
		
		for (int i = 0; i < s.length-1; i++) {
			if(s[i+1]<s[i]){
				System.out.println("В числе "+a+" каждая цифра  меньше следующей цифры в этом числе.");
                return;                     
            }	
		}
		System.out.println("В числе "+a+" каждая цифра не меньше следующей цифры в этом числе.");
		
	}
	
	public static  double[] inputString(String outputText, String resultText, int kolvoZnach){
		/* Вывод сообщения outputText и  ввод с консоли kolvoZnach значений типа double*/ 
		double[] input = new double[kolvoZnach];
		boolean flag = false;
		System.out.println(outputText);
		for (int i = 0; i <input.length; i++) {
			System.out.print("Введите "+(i+1)+ " знач: ");
			do {
				flag = false;
				try {
					input[i]  = new Scanner(System.in).nextDouble();
					flag = true;
				} catch (Exception e) {
					System.out.print("Ошибка. Введите число. Повторите ввод. ");
				}			
			} while (flag != true);
			
		}
		System.out.print(resultText);
		for (int i = 0; i < input.length; i++) {
			System.out.print(" "+input[i]);  
		}
		return input;
		
	}
	
	public static boolean hasTriangle(double[] st){
		// если одна из сторон <0 -это не треугольник
		for (int i = 0; i < st.length; i++) if (st[0]<=0) return false;
		return true;	
	}
	
	public static boolean hasRightTriangle(double[] st){
		if (st[0] == Math.sqrt (st[1]*st[1] + st[2]*st[2]) ||
			st[1] == Math.sqrt (st[0]*st[0] + st[2]*st[2]) ||
			st[2] == Math.sqrt (st[0]*st[0] + st[1]*st[1])) return true;
		return false;	
	}
	
	public static boolean hasIsoscelesTriangle(double[] st){
		if (st[0] == st[1] || st[1] == st[2] ||	st[2] == st[0]) return true;
		return false;	
	}
	
	public static int input4sybol(){
		int result =0;
		boolean flag;
		System.out.print("Введите четырехцифровое число:");
		do {
			flag = false;
			try {
				result  = new Scanner(System.in).nextInt();
				if (result<9999 & result>999 ) flag = true;
			} catch (Exception e){
			}
			if (!flag) System.out.print("Ошибка.Повторите ввод:");
		} while (!flag);
		return result;
	}
	
	}