import java.util.*;
import java.io.*;

public class Calculator{
    
    public static double eval(String s){
	String[] list = s.split("\\s+");
	@SuppressWarnings("unchecked")
	LinkedList<String> stack = new LinkedList();
	for (int x = 0; x < list.length; x++){
	    try{
		double temp = Double.parseDouble(list[x]);
		stack.push(temp+"");
	    }
	    catch (NumberFormatException e){
		double num2= Double.parseDouble(stack.pop());
		double num1= Double.parseDouble(stack.pop());
		if (list[x].equals("*")){
		    stack.push(num1* num2+ "");
		}
		if (list[x].equals("/")){
		    stack.push(num1/ num2+ "");
		}
		if (list[x].equals("%")){
		    stack.push(num1% num2+ "");
		}
		if (list[x].equals("+")){
		    stack.push(num1+ num2+ "");
		}
		if (list[x].equals("-")){
		    stack.push(num1- num2+ "");
		}
	    }
	}
	return Double.parseDouble(stack.pop());
    }
        public static void main(String[] args){
	System.out.println(eval("10 6 +"));
	System.out.println(eval("3 3 - 4 * 3 3 -"));
	System.out.println(eval("2 3 * 4 + 1 1 -"));
	System.out.println(eval("2 10 /"));
	System.out.println(eval("5 10 %"));
	System.out.println(eval("0"));
    }


}