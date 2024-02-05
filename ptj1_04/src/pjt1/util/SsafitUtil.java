package pjt1.util;

import java.util.Scanner;

public class SsafitUtil {
	private static Scanner sc = new Scanner(System.in);
	private SsafitUtil() {}
	public static String input(String msg) {
		System.out.print(msg+" "+":"+" ");
		return sc.nextLine();
	}
	
	public static int inputint(String msg) {
		System.out.print(msg+" "+":"+" ");
		int tmp = sc.nextInt();
		sc.nextLine();
		return tmp;
	}
	
	public static void printLine() {
		System.out.print("-".repeat(80));
		System.out.println();
	}
	
	public static void printLine(char ch) {
		
	}
	
	public static void printLine(char ch, int len) {
		
	}
	
	public static void pass() {
		sc.nextLine();
	}
	
	public static void screenClear() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}
		
		
		
}
