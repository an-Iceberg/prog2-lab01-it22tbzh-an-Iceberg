package ch.zhaw.prog2.primechecker;

import java.util.concurrent.Callable;

public class PrimeTaskCallable implements Callable<PrimeTaskCallable.Result>
{
  private final long primeCandidate;

  public PrimeTaskCallable(long primeCandidate)
  {
    this.primeCandidate = primeCandidate;
  }

  public Result call()
  {
    return new Result(this.getPrimeCandidate(), findSmallestFactor(this.primeCandidate));
  }

  public long getPrimeCandidate()
  {
    return primeCandidate;
  }

  /**
   * Brute force check if submitted candidate is a prime number.
   *
   * @param primeCandidate Number to check if it is a
   * @return 0 if prime number, smallest factor otherwise
   */
  private long findSmallestFactor(long n)
  {
    if (n == 2 || n % 2 == 0)
    {
      return 2;
    }

    if (n == 3 || n % 3 == 0)
    {
      return 3;
    }

    for (int factor = 5; factor * factor <= n; factor += 6)
    {
      if (n % factor == 0)
      {
        return factor;
      }

      if (n % (factor + 2) == 0) {
        return factor + 2;
      }
    }

    return 0;
  }

  /**
   * Small static helper class serving as a container to return the result.
   * No accessor methods. Use direct access to fields to read values.
   * (Starting from Java14, we could use Java Records for this)
   */
  public static class Result
  {
    public final long candidate;
    public final long factor;
    public final boolean isPrime;

    public Result(long candidate, long factor)
    {
      this.candidate = candidate;
      this.factor = factor;
      this.isPrime = factor == 0;
    }
  }
}
