package ch.zhaw.prog2.printer;

public class PrinterB
{
  // test program
  public static void main(String[] arg)
  {
    new Thread(new PrinterRunnable("PrinterA", '.', 10)).start();
    new Thread(new PrinterRunnable("PrinterB", '*', 20)).start();
  }

  private static class PrinterRunnable implements Runnable
  {
    private String name;
    private char symbol;
    private int sleepTime;

    public PrinterRunnable(String name, char symbol, int sleepTime)
    {
      this.name = name;
      this.symbol = symbol;
      this.sleepTime = sleepTime;
    }

    public String getName() {
      return this.name;
    }

    public void run()
    {
      // Apparently, the current thread must be stored as an object to get the name

      System.out.printf("%s run started...%n", this.getName());

      // Printing a symbol and then sleeping for the specified amount of time
      for (int i = 1; i < 100; i++)
      {
        System.out.print(this.symbol);

        try
        {
          Thread.sleep(this.sleepTime);
        }
        catch (InterruptedException e)
        {
          System.out.println(e.getMessage());
        }
      }

      System.out.printf("%n%s run ended.%n", this.getName());
    }
  }
}
