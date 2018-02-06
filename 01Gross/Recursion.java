public class Recursion{
	public static int fact(int n){
		if(n == 0){
			return 1;
		}
		return n * fact(n-1);
	}
	 public static int fib(int n){
	 	if (n < 0){
	 		throw new IllegalArgumentException();
	 	}
		return fibHelp(0, n, 0, 1);
    }

    public static int fibHelp(int count, int n, int prevsum, int sum){
		if(count == n){
	    	return prevsum;
		}
		return fibHelp(count + 1, n, sum, prevsum + sum);
	}
	public static double sqrt(double n){
    	if(n < 0){
      		throw new IllegalArgumentException();
    	}
    	return sqrtHelp(n, 1.0);
  	}

  	public static double sqrtHelp(double n, double guess){
    	if(n == 0){
      		return 0;
    	}
    	if(n == 1){
      		return 1;
    	}
    	if(100 * Math.abs((guess * guess - n)/n) <= .00001){
      		return guess;
    	}
    	return sqrtHelp(n, (n/guess + guess)/2);
  	}
	/*public static void main(String[] args){
		System.out.println(fact(5));
		System.out.println(fact(6));
		System.out.println(fact(0));
		System.out.println(fact(11));
		System.out.println(fact(19)); //eek20istoobig
		System.out.println(fib(0));
		System.out.println(fib(1));
		System.out.println(fib(-2));
		System.out.println(fib(3));
		System.out.println(fib(10));
		System.out.println(sqrt(100));
		System.out.println(sqrt(-1));
		System.out.println(sqrt(0));
		System.out.println(sqrt(1));
		
		
}*/
}