import java.util.Scanner;
import java.util.Stack;

class StockSpan {
  static int[] spanValues(int[] stockPrices, int n) {
    int[] spans = new int[n];
    Stack<Integer> stk = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!stk.isEmpty() && stockPrices[stk.peek()] <= stockPrices[i])
        stk.pop(); // case where current > previous, we remove previous from
                   // stack
                   //  to do next comparisons in stack
      spans[i] = stk.isEmpty() ? i + 1 : i - stk.peek();
      stk.push(i);
    }
    return spans;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] stockPrices = new int[n];
    for (int i = 0; i < n; i++) stockPrices[i] = sc.nextInt();
    sc.close();
    int[] span = spanValues(stockPrices, n);
    for (int i = 0; i < n; i++) System.out.print(span[i] + " ");
  }
}