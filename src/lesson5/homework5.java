package lesson5;


import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class homework5 {
	static HashMap<Integer,Double> factorialArr = new HashMap<Integer,Double>();
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
	System.out.println("8:  *Задано три числа, которые указывают положения часов, например, 12, 30, 45 означает 12 часов 30 минут 45 секунд. \nОпределить, совпадают ли часовая и минутная стрелки.");
	System.out.println("9:  *Задано три числа, которые указывают положения часов, например, 12, 30, 45 означает 12 часов 30 минут 45 секунд. \nОпределить, через какое минимальное время совпадут эти стрелки.");
	System.out.println("10: Задано число. Посчитать факториал этого числа.");
	System.out.println("11: Задать число. Посчитать ближайший факториал числа, который находится ближе всего к этому числу. ");
	System.out.println("12: Задано строку. Написать метод, которое проверяет,  есть ли заданная строка числом (без использования механизма ошибок).");
	System.out.println("13: Задана строка. Выделить число из строки, если строка является числом (превратить символ в число - Character.getNumericValue()");
	System.out.println("14: Задано строка. Выделить все цифры из этой строки и соединить в число. ");
	System.out.println("15: Задан и заполнен массив. Скопировать часть заданного массива в другой.");
	System.out.println("16: Задано два числа. Найти все числа между заданными, у которых цифры четные. Выполнить это задание через массивы.");
	System.out.println("17: Задано два числа. Найти все числа между заданными (включая заданные), которые создают арифметическую  прогрессию.");
	System.out.println("18: Задано натуральное число. Проверить, является ли сумма его максимальной цифры и его минимальной цифры парным числом.");
	System.out.println("19: Задано число. Полностью удалить из заданного числа максимальную цифру. Проверить, является ли полученное число палиндромом.");
	System.out.println("20: Написать метод вычисления двоичного представления натурального числа. ");
	
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
     case 8:  gettest8();break;
     case 9:  gettest9();break;
     case 10:  gettest10();break;
     case 11:  gettest11();break;
     case 12:  gettest12();break;
     case 13:  gettest13();break;
     case 14:  gettest14();break;
     case 15:  gettest15();break;
     
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
		
		
		if (hasRightTriangle(arr[0],arr[1],arr[2])) {
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
		
		if (hasIsoscelesTriangle(arr[0],arr[1],arr[2])) {
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
		if (hasIsosceles2Triangle(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]) ){
			System.out.println("Тут есть два равносторонних треугольника (Вариант2)");
		
		/*// (Вариант1) все значения в перемешку
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
		*/
		}
	}
	public static boolean hasIsosceles2Triangle(double arr0,double arr1, double arr2,double arr3,double arr4, double arr5  ){
		
		return (hasIsoscelesTriangle(arr0,arr1,arr2) & hasIsoscelesTriangle(arr3,arr4,arr5));
	}
	
	public static void gettest4(){
		int a = input4sybol(); 
		int sum =0;
		
		sum = summaVsehChisel(a);
		
		System.out.print("Сумма цифр этого числа - "+sum);
		System.out.println(" она - "+ (sum%2 ==0 ? "четная":"не четная"));
	}
		
	public static void gettest5(){
		int a = input4sybol(); 
		
		if (polindrom(a)) {
			System.out.println(""+a+ " это полиндром " );
		}else{
			System.out.println(""+a+ " это не полиндром ");
		}
	}
		
	public static void gettest6(){
		int a = input4sybol(); 

		if (summaPolovin(a)){
			System.out.println("Cумма одной половины цифр числа "+a+" равна сумме другой половины цифр.");
		}else{
			System.out.println("Cумма одной половины цифр числа "+a+" НЕ равна сумме другой половины цифр.");
		}
	}
		
  	public static void gettest7(){
		int a = input4sybol(); 
		if (kajdaiaNeMensheSleduyshei(a)){
			System.out.println("В числе "+a+" (не каждая/а может, и не одна) цифра  меньше следующей цифры в этом числе.");	
		}else{
			System.out.println("В числе "+a+" каждая цифра  меньше или равна следующей цифры в этом числе.");
		}
	}
	
  	public static void gettest8(){
		double strelkaChs = 0;
		double strelkaMin = 0;
		double strelkaSek = 0;
		int[] arr = new int[3];
		arr = inputTime();
		if (arr[0] > 12) arr[0] -= 12;
		// перенесем часовую стрелку на шкалу 0-100 (%всего круга) можно и на 0-360(отклонение в град)
		strelkaChs = (double)arr[0]/12*100+(double)arr[1]/720*100+(double)arr[2]/43200*100;
		strelkaMin = (double)arr[1]/60*100+(double)arr[2]/3600*100;
		strelkaSek = (double)arr[2]/60*100;
		
		
		if (strelkaChs == strelkaMin){
			System.out.println("Минутная и часовая стрелка совпадает");
		}else{
			System.out.println("Минутная и часовая стрелка НЕ совпадает на" +(strelkaChs-strelkaMin)*3.6 + " градуса)");
		}
	}
	
	public static void gettest9(){
			double strelkaChs = 0;
			double strelkaMin = 0;
			double strelkaSek = 0;
			int[] arr = new int[3];
			arr = inputTime();
			int[] arrFin = (int[])arr.clone();
			
			if (arr[0] > 12) arr[0]-= 12;
			
			do {
				strelkaChs = (double)arrFin[0]/12*100+(double)arrFin[1]/720*100+(double)arrFin[2]/43200*100;
				strelkaMin = (double)arrFin[1]/60*100+(double)arrFin[2]/3600*100;
				strelkaSek = (double)arrFin[2]/60*100;
				
				arrFin[2]++;
				if(arrFin[2]>59){
					arrFin[2] = 0;
					arrFin[1]++;
				}
				if(arrFin[1]>59){
					arrFin[1] = 0;
					arrFin[0]++;
				}
				if (arr[0] > 12) arr[0]-= 12;
							
			} while ((int)strelkaChs != (int)strelkaMin);
			System.out.println("Стрелки совпали на "+arrFin[0]+" часе "+arrFin[1]+" минуте "+arrFin[2]+" секунде");
			int proshloSekundSNulaRes = arrFin[0]*60*60+arrFin[1]*60+arrFin[2];
			int proshloSekundSNula = arr[0]*3600+arr[1]*60+arr[2];
			int delta = proshloSekundSNulaRes - proshloSekundSNula;
			System.out.print("через " +delta+ " секунд");
			System.out.println("( "+delta/3600+" часов "+(delta%3600)/60+" минут "+(delta%3600)%60+" секунд)");
			
		
		
	}
		
	public static void gettest10(){
		int a = inputInt();
		System.out.println("Факториал числв "+a +" равен " +faktorial(a));
		//http://www.luschny.de/math/factorial/index.html
	}
		
	public static void gettest11(){
		int a = inputInt();
		System.out.println("Ближайший факториал числа, который находится ближе всего к заданому числу. - "
				+ "" + faktorial(nearFactorial(a)));
	}
	
	public static void gettest12(){
		String inputStr = inputString();
		System.out.println(inputStr); 
		if (isNumber(inputStr)){
			System.out.println("Заданная строка  число");
		}else{
			System.out.println("Заданная строка не число");
		} 
	}
	
	
	
	public static void gettest13(){}
	
	public static void gettest14(){}
	
	public static void gettest15(){}
	
	public static void gettest16(){}
	
	public static void gettest17(){}
	
	public static void gettest18(){}
	
	public static void gettest19(){}
	
	public static void gettest20(){}
	
	public static double[] inputString(String outputText, String resultText, int kolvoZnach){
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
	
	public static int[] inputTime(){
		int[] input = new int[3];
		String[] text = {"часы (0-23)","минуты (0-59) ","секунды (0-59)"};
		boolean flag = false;
		for (int i = 0; i <input.length; i++) {
			do {
				System.out.print("Введите "+text[i]);
				flag = false;
				try {
					input[i]  = new Scanner(System.in).nextInt();
					if (i == 0 && (input[i]>=0 && input[i]<24)) {
						flag = true;	
					}
					if (i != 0 && (input[i]>=0 && input[i]<60)) {
						flag = true;	
					}
					
				} catch (Exception e) {
					System.out.print("Ошибка. Повторите ввод. ");
				}			
			} while (!flag);
			
		}
		System.out.println("Вы ввели "+input[0]+" часов  " +input[1]+ " минут  " +input[2]+ " секунд");
		return input;
		
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
	
	public static int inputInt(){
		int result =0;
		boolean flag;
		System.out.print("Введите число:");
		do {
			flag = false;
			try {
				result  = new Scanner(System.in).nextInt();
				if (result>0) flag = true;
			} catch (Exception e){
			}
			if (!flag) System.out.print("Ошибка.Повторите ввод:");
		} while (!flag);
		return result;
	}
	
	public static String inputString(){
		System.out.print("Введите строку :");
		return new Scanner(System.in).nextLine();
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
	
	public static boolean hasRightTriangle(double st0,double st1, double st2 ){
		if (st0 == Math.sqrt (st1*st1 + st2*st2) ||
			st1 == Math.sqrt (st0*st0 + st2*st2) ||
			st2 == Math.sqrt (st0*st0 + st1*st1)) return true;
		return false;	
	}
	
	public static boolean hasIsoscelesTriangle(double[] st){
		if (st[0] == st[1] || st[1] == st[2] ||	st[2] == st[0]) return true;
		return false;	
	}
	public static boolean hasIsoscelesTriangle(double st1,double st2, double st3 ){
		if (st1 == st2 || st2 == st3||	st3 == st1) return true;
		return false;	
	}
	
	
	public static int summaVsehChisel(int a){
		int suma = 0;
		while(a>0){
			suma = suma + (a % 10);
			a/=10;
		}
		return suma;
		}
	
	public static boolean polindrom(int a){
		int b = 0;
		int temp = a;
		
		while(temp>0){
			b = b*10 + (temp% 10);
			temp/=10;			
		}
		return (b == a); 
	}
	
	public static boolean summaPolovin(int a){
		int temp = a;
		int[] s = new int[4];
		for (int i = 0; i < 4; i++) {
			s[i] = temp%10;
			temp/=10;
		}
		return (s[0]+s[1] == s[2]+s[3]);
	}

  	public static boolean kajdaiaNeMensheSleduyshei(int a){
  		int temp = a;
		int[] s = new int[4];
		for (int i = 0; i < 4; i++) {
			s[i] = temp%10;
			temp/=10;
		}
		for (int i = 0; i < s.length-1; i++)if(s[i]<s[i+1])return true; 
  		return false;
			
  	}
  	
  	public static Double faktorial(int x){
		Double resultat;
		
		if (x <= 0) return 1.0;
	    resultat = factorialArr.get(x);
	    if (factorialArr.get(x) != null) return factorialArr.get(x);
	    resultat = faktorial(x-1)*x;
	    factorialArr.put(x,resultat);
	    
	    System.out.println("factorial("+x+") = "+resultat);
	    return resultat;
	}	

  	public static int nearFactorial(int a){
		boolean flag = false;
		Double factoricalMin=.0, factoricalMax=.0;
		Double deltaMin=.0, deltaMax=.0;
		int result=0;
		
		while (!flag) {
			result++;
			factoricalMin = faktorial(result);
			factoricalMax = faktorial(result+1);
			deltaMin = a - factoricalMin;
			deltaMax = factoricalMax - a;
			if (factoricalMin.compareTo((double)a) <= 0 && factoricalMax.compareTo((double)a) >= 0) flag=true;
		}

		return (deltaMin>=deltaMax? result+1:result) ;
	
	}
	
  	private static boolean isNumber(String str) {
        for (char c: str.toCharArray()) if (!Character.isDigit(c)) return false;
        return true;
    }

}