import java.util.Scanner;


public class ArrayOfStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] towns = new String[n];

		for (int i = 0; i <towns.length; i++) {
			towns[i]= sc.next();
		}
		for (int  j= n-1; j >=0; j--) {
			System.out.println(towns[j]);
		}

	}

}
