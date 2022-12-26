import java.util.Scanner;

public class Digits {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		Integer sum=0;
		
		System.out.println("enter the sentence");
		String input=scanner.next();
		
		for (int i = 0; i<input.length(); i++) {
			Character ch=input.charAt(i);
			if (ch.isDigit(ch)) {
				sum=sum+Integer.parseInt(ch.toString());
			}
			
			
		}
		
		System.out.println(sum);
		
		
	}

}
