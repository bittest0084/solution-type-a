package problem04;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		int count = 1;
		
		int[] randomNum = new int[3];
		for(int i=0; i<3; i++) {
			randomNum[i] = (int)(Math.random() * 10.0);
			if(i == 1) {
				if(randomNum[i] == randomNum[0]) randomNum[i] = (int)(Math.random() * 10.0);
			}
			else if(i == 2) {
				if(randomNum[i] == randomNum[0] || randomNum[i] == randomNum[1]) randomNum[i] = (int)(Math.random() * 10.0);
			}
		}
		int[] inputNum = new int[3];
		
		Scanner sc = new Scanner(System.in);
		while(!(inputNum[0] == randomNum[0] && inputNum[1] == randomNum[1] && inputNum[2] == randomNum[2])) {
			int input = sc.nextInt();
			
			System.out.println(input);
			for(int i=2; i>=0; i--) {
				inputNum[i] = input % 10;
				input /= 10;
			}
			
			for(int i=0; i<3; i++) {
				System.out.println(inputNum[i]);
			}
	
			int strike = 0;
			int ball = 0;
			int out = 0;
			for(int i=0; i<3; i++) {
				boolean isOut = true;
				for(int j=0; j<3; j++) {
					if(i == j) {
						if(randomNum[i] == inputNum[j]) {
							strike++;
							isOut = false;
						}
					} else if(randomNum[i] == inputNum[j]) {
						ball++;
						isOut = false;
					}
				}
				if(isOut) out++;
			}
			System.out.println(count + " - S:" + strike + ", B:" + ball + ", O:" + out);
			count++;
		}
		
		OutputStream os = new FileOutputStream("file.txt");
		os.write(("" + randomNum[0] + randomNum[1] + randomNum[2] + "/" + count).getBytes(StandardCharsets.UTF_8));
		os.flush();
		
		os.close();
	}
}