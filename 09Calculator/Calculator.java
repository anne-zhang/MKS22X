import java.util.*;
public class Calculator{

	public static double eval(String n){
		LinkedList<Double> Stack = new LinkedList<>();
		String[] splitN = n.split(" ");
		
		for (int i = 0; i < splitN.length; i++){
			
				if(splitN[i].equals("+")){
					double numOne = Stack.pop();
					double numTwo = Stack.pop();
					Stack.push(numOne + numTwo);
				}
				else if(splitN[i].equals("-")){
					double numOne = Stack.pop();
					double numTwo = Stack.pop();
					Stack.push(numTwo - numOne);
				}
				else if(splitN[i].equals("*")){
					double numOne = Stack.pop();
					double numTwo = Stack.pop();
					Stack.push(numOne * numTwo);
				}
				else if(splitN[i].equals("/")){
					Stack.push(Stack.pop() / i);
				}
				else if(splitN[i].equals("%")){
					Stack.push(Stack.pop() % i);
				}
				else{
					Stack.push(Double.parseDouble(splitN[i]));
				}
			}
			return Stack.pop();
		}	

}