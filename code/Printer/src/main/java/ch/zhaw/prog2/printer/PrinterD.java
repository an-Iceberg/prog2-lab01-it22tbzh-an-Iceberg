package ch.zhaw.prog2.printer;

public class PrinterD
{
  // test program
  public static void main(String[] arg)
  {
    System.out.println("Main thread started");

    Thread PrinterA = new Thread(new PrinterRunnable("PrinterA", '.'));
    Thread PrinterB = new Thread(new PrinterRunnable("PrinterB", '*'));
    PrinterA.start();
    PrinterB.start();

    try
    {
      PrinterA.join();
      PrinterB.join();
    }
    catch (Exception exception)
    {
      exception.printStackTrace();
    }

    System.out.println("Main thread ended");
  }

  private static class PrinterRunnable implements Runnable
  {
    private String name;
    private char symbol;

    public PrinterRunnable(String name, char symbol)
    {
      this.name = name;
      this.symbol = symbol;
    }

    public String getName() {
      return this.name;
    }

    public void run()
    {
      System.out.printf("%s run started%n", this.getName());

      // Printing a symbol and then sleeping for the specified amount of time
      for (int i = 1; i < 100; i++)
      {
        System.out.print(this.symbol);
        Thread.yield();
      }

      System.out.printf("%n%s run ended.%n", this.getName());
    }
  }
}
