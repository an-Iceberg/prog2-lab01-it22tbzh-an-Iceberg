package ch.zhaw.prog2.primechecker;

import java.util.HashMap;
import java.util.Map;

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
   * @param n Number to check if it is a prime
   * @return 0 if prime number, smallest factor otherwise
   */
  public long findSmallestFactor(long n) // private
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

  public static void main(String[] args)
  {
    PrimeTask primeTask = new PrimeTask(0);

    HashMap<Integer, Long> numbers = new HashMap<>();

    numbers.put((Integer)0, (Long)5L);
    numbers.put((Integer)0, (Long)131L);
    numbers.put((Integer)0, (Long)229L);
    numbers.put((Integer)0, (Long)1601L);
    numbers.put((Integer)0, (Long)2017L);
    numbers.put((Integer)0, (Long)3457L);
    numbers.put((Integer)0, (Long)4001L);
    numbers.put((Integer)0, (Long)4877L);
    numbers.put((Integer)0, (Long)5011L);
    numbers.put((Integer)0, (Long)5683L);
    numbers.put((Integer)0, (Long)7333L);
    numbers.put((Integer)0, (Long)7717L);
    numbers.put((Integer)0, (Long)7793L);
    numbers.put((Integer)0, (Long)7919L);

    numbers.put((Integer)2, (Long)10L);
    numbers.put((Integer)2, (Long)30L);
    numbers.put((Integer)2, (Long)50L);
    numbers.put((Integer)3, (Long)105L);
    numbers.put((Integer)3, (Long)243L);
    numbers.put((Integer)19, (Long)589L);
    numbers.put((Integer)31, (Long)1147L);
    numbers.put((Integer)3, (Long)1287L);
    numbers.put((Integer)2, (Long)2442L);
    numbers.put((Integer)13, (Long)3211L);
    numbers.put((Integer)3, (Long)4899L);
    numbers.put((Integer)2, (Long)5000L);
    numbers.put((Integer)13, (Long)7111L);
    numbers.put((Integer)61, (Long)9943L);
    numbers.put((Integer)239, (Long)57_599L);
    numbers.put((Integer)389, (Long)154_433L);
    numbers.put((Integer)499, (Long)250_997L);

    for (Map.Entry<Integer,Long> number : numbers.entrySet()) {
      test(number.getKey(), primeTask.findSmallestFactor(number.getValue()), number.getValue());
    }
  }

  private static void test(int i, long l, long n) {
    if (i != l)
    {
      System.out.printf("Number:%d, Should:%d, Is:%d%n", n, i, l);
    }
  }
}
