package problem01;

public class Main {

	public static void main(String[] args) {
		for( int i = 1; i <= 100; i++ ) {
			int count = countClap(i);

			if( count == 0 ) {
				continue;
			}
			
			System.out.print( i + " " );
			
			for( int j = 0; j < count; j++ ) {
				System.out.print( "짝" );
			}
			
			System.out.println( "" );			
		}
	}
	
	public static int countClap(int number) {
		int count = 0;
		while(number != 0) {
			int checkNum = number - (number / 10) * 10;
			if(checkNum == 3 || checkNum == 6 || checkNum == 9) {
				count++;
			}
			number /= 10;
		}
		return count;
	}
}