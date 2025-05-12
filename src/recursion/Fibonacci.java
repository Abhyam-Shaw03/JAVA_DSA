package recursion;

public class Fibonacci {
    public int fibonacci(int n){
        if(n <= 1) return n;
        /*
            ANOTHER WAY TO WRITE INSTEAD OF WRITNG IN ONE LINE

        int first = fibonacci(n-1);
        int last = fibonacci(n-2);
        return first + last;
         */
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
