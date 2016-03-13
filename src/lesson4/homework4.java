package lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
//import java.util.Random;

public class homework4 {
	
	private static Scanner in;
	public static void main(String[] arg) throws IOException {
		
	
	Scanner inw = new Scanner(System.in);
	System.out.println("1: Создать метод, входным параметром которого является массив целых чисел\n, и вернуть сумму всех значений массива.");
	System.out.println("2: Задано два числа. Написать условие того, что первое значение делится \nна второе без остатка.");
	System.out.println("3: Задано два числа. Написать условие того, что оба заданных значения \nодновременно четный  или нечетные.");
	System.out.println("4: Задано символ. Написать метод, которое проверяет,  есть ли заданный \nсимвол цифрой.");
	System.out.println("5: Написать метод, который  вычисляет корни квадратного уравнения \n(эта функция Вам понадобиться http://www.tutorialspoint.com/java/number_sqrt.htm).");
	System.out.println("\n Ваш выбор?");
	int numbertest = inw.nextInt();
	System.out.println("Good. Your choice is " +numbertest);
	
	 switch (numbertest) {
     case 1:  gettest1();break;
     case 2:  gettest2();break;
     case 3:  gettest3();break;
     case 4:  gettest4();break;
     case 5:  gettest5();break;
     default: 
    	 System.out.println(numbertest+" invalid number. " );
    	 break;
	 }
	 inw.close(); 
	}


	public static void gettest1(){
		int i =   (int) (Math.random()*10); 
		System.out.println(i);
		int arr[] = new int[i];
		for (int j = 0; j < arr.length; j++) {
			arr[j] = (int) (Math.random()*100);
			System.out.println("arr["+j+"] =" + arr[j]);
		}
		int summa = arrSum(arr);
		System.out.println("Total sum "+summa);
	}
	
	public static int arrSum(int[] arr){
		int sum =0;
		for (int j = 0; j < arr.length; j++) {
			arr[j] = (int) (Math.random()*100);
			sum += arr[j] ;
		}
		return sum;
	}
		
	public static void gettest2(){
		//  Согласно ТЗ нужно написать условие, а не метод  который возвращает bool. условие (i%j == 0) использовано ниже ;) 
		int ostatok;
		do {
			int i =   (int) (Math.random()*100); 
			int j =   (int) (Math.random()*10)+1;
			ostatok = i%j;
			if (i%j == 0) {
				System.out.println("Значение "+i+" делиться на "+j+" - без остатка");
			}else{
				System.out.println("Значение "+i+" делиться на "+j+" c остатом "+ ostatok);	
			}
		} while (ostatok > 0);
	}
	
	public static void gettest3(){
		int[] a = new int[2];
		in = new Scanner(System.in); 
	    System.out.printf("Введите 1 число:  ");
	    a[0] = in.nextInt();
	    System.out.printf("Введите 2 число:  ");
	    a[1] = in.nextInt();
		System.out.println("Вы ввели числа:"+a[0]+", "+a[1]);
		if (a[0]%2==0 & a[1]%2==0) {
			System.out.println("одновременно четные");
		}else if (!(a[0]%2==0) & !(a[1]%2==0)) {
			System.out.println("одновременно нечетные");
		}else{
			System.out.println("в данных числах одно четное другое не четное ;(");
		}
	}
	
	public static void gettest4() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Введите символ:"); 
		char c = (char) br.read();
		if(isChar(c)){
			System.out.println(c + " - это число");
		}else{
			System.out.println(c + " - это не число");
		}
	}
	
	public static boolean isChar(char c){
		return ((c >= '0' & c <= '9') ? true : false);
	}
	
	public static void gettest5(){
		double a,b,c;
		System.out.println("ax2 + bx + с = 0");
		a = input("Input a");	
		b = input("Input b");	
		c = input("Input c");	
		KvadratUravn kvadr = new KvadratUravn(a,b,c);
		if (kvadr.itHasSolution()){
			System.out.println("x1 = "+kvadr.x1 );
			System.out.println("x2 = "+kvadr.x2 );
		}else{
			System.out.println("no solutions");
		}
	}

	
	
	public static double input(String text){
		System.out.print(text + ":   ");
		in = new Scanner(System.in);
		String input;
		do {
			input = in.nextLine();	
			try {
				return (double) Double.parseDouble(input);
		    } catch (NumberFormatException e) {
		    	System.out.println("this no double. Pls reinput");
		    }
		} while (input!=null);
		return  0.0;
		
	}
}

class KvadratUravn{ 
	private double a,b,c;
	public double d, x1, x2;
	
	
	public KvadratUravn(double a2, double b2, double c2) {
		this.a = a2;
		this.b = b2;
		this.c = c2;
		System.out.println(""+a+"x2 + "+b+"x + "+c+" = 0");
	}
	public boolean itHasSolution (){
		//этот метод возращает решаемо ли уравнение. Если есть корни
		//то этот же метод их и вычисляет
		this.d = (b * b) - (4 * a * c);
		if(this.d < 0)
			return false;
	        else{
	        	if(this.d == 0)
	        		{
	        		this.x1 = (-b) / (2 * a);
	        		}
	        	else
	        		{
	        		this.x1 = (-b + Math.sqrt(d)) / (2 * a);
	        		this.x2 = (-b - Math.sqrt(d)) / (2 * a);
	        		}
	        return true;	
	        }
	}
	
	
	
}