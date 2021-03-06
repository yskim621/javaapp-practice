package algorithm.shape;

import java.util.Scanner;

public class OptionalPascalTriangle {

	public static void main(String[] args) {
		// Scanner 사용 시 예외 처리 필수(Try/Catch)
		Scanner sc = new Scanner(System.in);
		System.out.print("삼각형의 높이로 사용할 자연수(1이상, 30아하)를 입력하시오: ");
		int n = sc.nextInt();
		while(n < 1 || n > 30 ) {
			System.out.println("INPUT ERROR!");
			System.out.print("삼각형의 높이로 사용할 자연수(1이상, 30아하)를 입력하시오: ");
			n = sc.nextInt();
		}
		
		System.out.print("종류를 선택할 숫자(4아하)를 입력하시오: ");
		int m = sc.nextInt();
	
		while(m > 4) {
			System.out.println("4이하의 자연수를 입력하세요!");
			System.out.print("종류를 선택할 숫자(4아하)를 입력하시오: ");
			m = sc.nextInt();
		}
		int a, b, c, d;
		
		switch(m) {
		case 1:
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(j == 0 || i == j) {
						arr[i][j] = 1;
					} else if(i>=2 && j>=1){
						arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
					}
				}			
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) { // 대각선 기준 좌하단만 출력
					System.out.printf("%d ", arr[i][j]);
				}
				System.out.println();
			}
			break;
		case 2:
			arr = new int[n][2*n];
			for(int i=0; i<(int) Math.ceil(n/2)+1; i++) {
				a = n;
				b = n;
				c = n;
				d = n;
				for(int j=0; j<n; j++) {
					if(i == 0) {
						arr[--a][--b] = 1;
						arr[--c][(++d)-2] = 1; 
					} 
				} // a=0, b=0, c=0, d=8
				a = n-2*i;
				b = n;
				c = n-2*i;
				d = n-2;
				for(int j=0; j<n-2*i; j++) {
					if(i>= 1) {	
						arr[--a][--b] = arr[a+1][b-1] + arr[a+1][b+1];
						arr[--c][++d] = arr[c+1][d-1] + arr[c+1][d+1];
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <2*n-1; j++) {
					if( arr[i][j] != 0) {
						System.out.printf("%d", arr[i][j]);
					} else {
						System.out.printf("%s", " ");
					}
				}
				System.out.println();
			}
			break;
		case 3:
			arr = new int[n][n];
			for(int i=0; i<(int) Math.ceil(n/2)+1; i++) {
				a = n-1;
				b = n;
				c = n;
				d = n;
				for(int j=0; j<n; j++) {
					if(i == 0) {
						arr[a][--b] = 1;
						arr[--c][--d] = 1; 
					} 
				}
				a = n-i-1;
				b = n-2*i;
				c = n-i;
				d = n-2*i;
				for(int j=0; j<n-2*i; j++) {
					if(i >= 1) {
						arr[a][--b] = arr[a][b+1] + arr[a+1][b+1];
						arr[--c][--d] = arr[c][d+1] + arr[c+1][d+1]; 
					}
				}
				
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <=i; j++) {
					if( arr[i][j] != 0) {
						System.out.printf("%d ", arr[i][j]);
					}
				}
				System.out.println();
			}
			break;
		}
		// OS 자원 반납
		sc.close();
	}

}
