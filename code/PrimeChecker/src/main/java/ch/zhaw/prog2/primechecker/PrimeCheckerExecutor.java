package ch.zhaw.prog2.primechecker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PrimeCheckerExecutor
{
  private static final long LOWER_LIMIT = 10000L;
  private static final long UPPER_LIMIT = 1000000000L;
  private static final int NUM_PRIME = 500;

  private static final ExecutorService primeService = Executors.newFixedThreadPool(20);

  public static void main(String[] args)
  {
    long starttime = System.currentTimeMillis();
    long duration;

    try
    {
      checkPrimes(NUM_PRIME);
    }
    catch (InterruptedException e)
    {
      System.out.printf("Interrupted - %s%n", e.getMessage());
    }
    finally
    {
      duration = System.currentTimeMillis() - starttime;
    }

    System.out.printf("Finished in %d ms%n", duration);
  }

  private static void checkPrimes(int numPrimes) throws InterruptedException
  {
    // TODO: create ExecutorService - What ThreadPool-Type/-Size fits best?

    for (int i = 0; i < numPrimes; i++)
    {
      // TODO: execute the runnable using the executor service
      primeService.execute(new PrimeTask(nextRandom()));
    }
    // stop ExecutorService
    primeService.shutdown();

    // wait for termination with timeout of 1 minute
    primeService.awaitTermination(1, TimeUnit.MINUTES);
  }

  private static long nextRandom()
  {
    return LOWER_LIMIT + (long)(Math.random() * (UPPER_LIMIT - LOWER_LIMIT));
  }
}
