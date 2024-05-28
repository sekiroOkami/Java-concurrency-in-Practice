package ch01.recipe01.task;

public class Calculator implements Runnable {
    @Override
    public void run() {
        long current = 1L;
        long max = 20000L;
        long numPrimes = 0L;

        System.out.println("Thread name: " + Thread.currentThread().getName());

        while (current <= max) {
            if (isPrime(current)) {
                numPrimes++;
            }
            current++;
        }
        System.out.printf("Thread '%s': End. Number of Primes: %d\n", Thread.currentThread().getName(), numPrimes);;
    }

    private boolean isPrime(long current) {
        if (current <= 2) {
            return true;
        }
        for (long i = 2; i < current; i++) {
            if ((current % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
