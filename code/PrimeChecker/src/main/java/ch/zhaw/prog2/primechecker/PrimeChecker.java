package ch.zhaw.prog2.primechecker;

import java.sql.Time;

public class PrimeChecker
{
  private static final long LOWER_LIMIT = 10000L;
  private static final long UPPER_LIMIT = 1000000000L;
  private static final int NUM_PRIME = 500;

  public static void main(String[] args)
  {
    long start_time = System.currentTimeMillis();
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
      duration = System.currentTimeMillis() - start_time;
    }

    System.out.printf("Finished in %d ms", duration);
  }

  private static void checkPrimes(int numPrimes) throws InterruptedException
  {
    for (int i = 0; i < numPrimes; i++)
    {
      new PrimeTask(nextRandom()).run(); // runs sequential in current thread
      //Thread thread = new Thread(new PrimeTask(nextRandom()));
      //thread.start();
    }
  }

  private static long nextRandom()
  {
    return LOWER_LIMIT + (long)(Math.random() * (UPPER_LIMIT - LOWER_LIMIT));
  }
}
