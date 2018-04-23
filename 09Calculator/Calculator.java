import java.util.*;
public class Calculator{

	public static double eval(String n){
		LinkedList<String> Stack = new LinkedList<>();
		String[] splitN = n.split(" ");
		double finalAns = 0;
		
		for (int i = 0; i < splitN.length; i++){
			double numOne = 0 ;
			double numTwo = 0;
			
				if(splitN[i].equals("+")){
					numOne = Double.parseDouble(Stack.pop());
					numTwo = Double.parseDouble(Stack.pop());
					finalAns = numOne + numTwo;
					Stack.push(finalAns + "");
				}
				else if(splitN[i].equals("-")){
					numOne = Double.parseDouble(Stack.pop());
					numTwo = Double.parseDouble(Stack.pop());
					finalAns = numOne - numTwo;
					Stack.push(finalAns + "");
				}
				else if(splitN[i].equals("/")){
					numOne = Double.parseDouble(Stack.pop());
					numTwo = Double.parseDouble(Stack.pop());
					finalAns = numOne / numTwo;
					Stack.push(finalAns + "");
				}
				else if(splitN[i].equals("*")){
					numOne = Double.parseDouble(Stack.pop());
					numTwo = Double.parseDouble(Stack.pop());
					finalAns = numOne * numTwo;
					Stack.push(finalAns + "");
				}
				else if(splitN[i].equals("%")){
					numOne = Double.parseDouble(Stack.pop());
					numTwo = Double.parseDouble(Stack.pop());
					finalAns = numOne % numTwo;
					Stack.push(finalAns + "");
				}
				else{
					Stack.push(splitN[i]);
				}
			}
			return finalAns;
		}	

}