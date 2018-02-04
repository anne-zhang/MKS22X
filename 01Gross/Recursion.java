public class Recursion{
	public static int fact(int n){
		if(n == 0){
			return 1;
		}
		return n * fact(n-1);
	}
	 public static int fib(int n){
		return fibHelp(0, n, 0, 1);
    }

    public static int fibHelp(int count, int n, int prevsum, int sum){
		if(count == n){
	    	return prevsum;
		}
		return fibHelp(count + 1, n, sum, prevsum + sum);
	}
	
	public static void main(String[] args){
		System.out.println(fact(5));
		System.out.println(fact(6));
		System.out.println(fact(0));
		System.out.println(fact(11));
		System.out.println(fact(19)); //eek20istoobig
		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(2));
		System.out.println(fib(3));
		System.out.println(fib(10));
		
}
}