package src.main.java.arrays;

public class StringManipulation {

	public static void main(String[] args) {
		String output = "";
		int cursor = 0;
		
		output = "addThis";
		cursor += output.length();
		
		cursor -=2;
		
		//delete
		output = output.substring(0,cursor);
		
		System.out.println(output);
		
		//backspace
		output = output.substring(0,--cursor);
		
		System.out.println(output);

	}

}
