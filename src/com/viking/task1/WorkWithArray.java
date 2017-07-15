package com.viking.task1;


import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.viking.exceptions.IndexOutInArrayException;
import com.viking.exceptions.NotCorrectAmountStringArgumentsException;
import com.viking.exceptions.NotCorrectInitSymbolException;


public class WorkWithArray {
	
	public static void main(String[] args) {
		System.out.println("Enter size of array space and symbol");
		Scanner scan=new Scanner(System.in);
		String datas="";
		if(scan.hasNext()) {
			datas=scan.nextLine();
		}
		try {
			initArray(datas);
		} catch (NotCorrectAmountStringArgumentsException | NotCorrectInitSymbolException | NumberFormatException e) {
			e.printStackTrace();
		}
		System.out.println("Enter size of random array:");
		int size=0;
		if(scan.hasNext()) {
			try {
				size=scan.nextInt();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("Enter number of element that must be deleted in random array");
		int index=0;
		if(scan.hasNext()) {
			try {
				index=scan.nextInt();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		int[] arr=null;
		try {
			arr = deleteElemInArray(initRandomArray(size), index);
		} catch (IndexOutInArrayException e) {
			e.printStackTrace();
		}
		System.out.println("Result array:");
		for(int numb:arr) {
			System.out.println(numb);
		}
		scan.close();
	}
	public static void initArray(String components) throws NotCorrectAmountStringArgumentsException, NotCorrectInitSymbolException, NumberFormatException {
		//delete spaces and count of arguments
		String[] twoStr=components.split(" ");
		if(twoStr.length!=2) {
			throw new NotCorrectAmountStringArgumentsException("Not correct amount of strings arguments !!! Please try again !!!");
		}
		int arrayLength=Integer.parseInt(twoStr[0]);
		//if symbol is digit initialized array of this digit and show him on consol 
		if(checkWithRegExp(twoStr[1], "[0-9]+")){
			int[] arr=new int[arrayLength];
			for(int i=0;i<arrayLength;i++) {
				arr[i]=Integer.parseInt(twoStr[1]);
			}
			System.out.println("Array of type int size of "+arrayLength+" to fill "+twoStr[1]);
			for(int j=0;j<arrayLength;j++) {
				System.out.println(arr[j]);
			}
			return;
		}
		//if symbol is char initialized array of this char and show him on consol 
		if(checkWithRegExp(twoStr[1], "[a-zA-Z]")){
			char[] charArray=new char[arrayLength];
			for(int i=0;i<arrayLength;i++) {
				charArray[i]=twoStr[1].charAt(0);
			}
			System.out.println("Array of type char size of "+arrayLength+" to fill "+twoStr[1]);
			for(int j=0;j<arrayLength;j++) {
				System.out.println(charArray[j]);
			}
			return;
		}
		//if symbol is string initialized array of this string and show him on consol 
		if(checkWithRegExp(twoStr[1], "[a-zA-Z]+")){
			String[] str=new String[arrayLength];
			for(int i=0;i<arrayLength;i++) {
				str[i]=twoStr[1];
			}
			System.out.println("Array of type String size of "+arrayLength+" to fill "+twoStr[1]);
			for(int j=0;j<arrayLength;j++) {
				System.out.println(str[j]);
			}
			return;
		}
		//if symbol not a digit not a char and not a string
		throw new NotCorrectInitSymbolException("Not correct symbol !!! Try again !!!");
	}
	//use regulat expression to authentication of string
	public static boolean checkWithRegExp(String exp, String pat) {
		 Pattern p = Pattern.compile(pat);  
	        Matcher m = p.matcher(exp);  
	        return m.matches();  
	}
	public static int[] initRandomArray(int size) {
		int[] arr=new int[size];
		Random rand=new Random();
		for(int i=0;i<arr.length;i++) {
			arr[i]=rand.nextInt();
		}
		return arr;
	}
	//initialization array of zero by index
	public static int[] deleteElemInArray(int[] arr,int index) throws IndexOutInArrayException {
		//if index out of borders
		if(index<0 | index>arr.length) {
			throw new IndexOutInArrayException("Index out of bound in array !!!");
		}
		if(index==0) {
			arr[index]=0;
		}else {
			arr[index-1]=0;
		}
		return arr;
	}
}
