package ch.zhaw.prog2.primechecker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import ch.zhaw.prog2.primechecker.PrimeTaskCallable.Result;

public class PrimeCheckerFuture
{
  private static final long LOWER_LIMIT = 10000L;
  private static final long UPPER_LIMIT = 1000000000L;
  private static final int NUM_PRIME = 500;

  static ExecutorService primes = Executors.newSingleThreadExecutor();

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
      System.out.println("Interrupted - " + e.getMessage());
    }
    finally
    {
      duration = System.currentTimeMillis() - starttime;
    }

    System.out.println("Finished in " + duration + " ms");
  }

  private static void checkPrimes(int numPrimes) throws InterruptedException
  {
    // TODO: create ExecutorService

    ArrayList<Future<Result>> primeResults = new ArrayList<>();

    // TODO: submit tasks to ExecutorService and collect the returned Futures in a List
    for (int i = 0; i < numPrimes; i++)
    {
      primeResults.add(primes.submit(new PrimeTaskCallable(nextRandom())));
    }
    // TODO: Loop through List, wait for completion and print results
    for (Future<Result> prime : primeResults) {
      try {
        Result result = prime.get();
        System.out.printf("Number:%9d\t%s%n", result.candidate, ( result.isPrime ? "Prime" : String.format("Factor:%5d", result.factor)));
      } catch (ExecutionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }

    // TODO: stop ExecutorService
    primes.shutdown();

    // TODO: await termination with timeout 1 minute

  }

  private static long nextRandom()
  {
    return LOWER_LIMIT + (long)(Math.random() * (UPPER_LIMIT - LOWER_LIMIT));
  }
}
