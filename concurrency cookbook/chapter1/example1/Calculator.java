package chapter1.example1;


/**
 * Create and run 10 thread that would calculate the prime numbers within
 * the first 20_000 numbers.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calculator implements Runnable
{
    @Override
    public void run() {
        long current = 1L;
        long max = 20000L;
        long numPrimes = 0L;
        
        System.out.printf("Thread '%s': START\n", Thread.currentThread().getName());
        
        while (current <= max) {
            if (isPrime(current)) {
                numPrimes++;
            }
            current++;
        }
        
        System.out.printf("Thread '%s': END. Number of Primes: %d\n",
            Thread.currentThread().getName(), numPrimes);
    }
    
    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
