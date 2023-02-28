package ch.zhaw.prog2.printer;

public class PrinterC
{
  // test program
  public static void main(String[] arg)
  {
    new Thread(new PrinterRunnable("PrinterA", '.')).start();
    new Thread(new PrinterRunnable("PrinterB", '*')).start();
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
      System.out.printf("%s run started...%n", this.getName());

      for (int i = 1; i < 100; i++)
      {
        System.out.print(this.symbol);
      }

      System.out.printf("%n%s run ended.%n", this.getName());
    }
  }
}
