package ch.zhaw.prog2.primechecker;

public class PrimeTask implements Runnable
{
  private final long primeCandidate;

  public PrimeTask(long primeCandidate)
  {
    this.primeCandidate = primeCandidate;
  }

  public void run()
  {
    long smallestFactor = findSmallestFactor(primeCandidate);

    System.out.printf("Number: %9d\t%s%n", this.primeCandidate, ( smallestFactor == 0 ? "PRIME" : String.format("Factor: %5d", smallestFactor) ));
    //System.out.printf("Number:%9d\t%s%n", result.candidate, ( result.isPrime ? "Prime" : String.format("Factor:%5d", result.factor)));
  }

  /**
   * Brute force check if submitted candidate is a prime number.
   *
   * @param primeCandidate Number to check if it is a
   * @return 0 if prime number, smallest factor otherwise
   */
  private long findSmallestFactor(long primeCandidate)
  {
    /*
    if (primeCandidate>3)
    {
      for(long factor = 2; factor <= Math.sqrt(primeCandidate); ++factor) // factor <= primeCandidate / 2
      {
        if (primeCandidate % factor == 0) //  primeCandidate / factor * factor == primeCandidate
        {
          return factor; // found a factor -> is no prime
        }
      }
    }

    return 0; // is prime number
    */

    if (primeCandidate>3)
    {
      for(long factor = 2; factor <= primeCandidate / 2; ++factor)
      {
        if (primeCandidate / factor * factor == primeCandidate)
        {
          return factor; // found a factor -> is no prime
        }
      }
    }

    return 0; // is prime number
  }
}
