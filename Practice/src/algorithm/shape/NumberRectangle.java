package algorithm.shape;

import java.util.Scanner;

public class NumberRectangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자사각형의 높이로 사용할 숫자(100아하)를 입력하시오: ");
		int n = sc.nextInt();
		System.out.print("숫자사각형의 너비로 사용할 숫자(100이하)를 입력하시오: ");
		int m = sc.nextInt();
		
		while(n > 100) {
			System.out.println("100이하의 정수를 입력하세요!");
			System.out.print("숫자사각형의 높이로 사용할 숫자(100아하)를 입력하시오: ");
			n = sc.nextInt();
		}
		
		while(m > 100) {
			System.out.println("100이하의 정수를 입력하세요!");
			System.out.print("숫자사각형의 너비로 사용할 숫자(100아하)를 입력하시오: ");
			m = sc.nextInt();
		}
		
		int sum = 1;
		for(int i=0; i < n; i++){
		    for(int j = 0; j < m; j++){
		    	System.out.printf("%d ", sum++);
		    }
		    System.out.println();
		}
		sc.close();
	}

}
