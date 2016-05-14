
//Answer 32

public class MinimumCoinChange {
  public int minimumChange(int total, int[] coins) {
    int[] counts = new int[total+1];
    for (int partial=1; partial<=total; partial++) {
      int min = Integer.MAX_VALUE;
      for (int c=0; c<coins.length && partial<=coins[c]; c++) {
        int currentCount = 1+counts[partial-coins[c]];
        if (currentCount < min)
          min = currentCount;
      }
      counts[partial] = min;
    }
    return counts[total];
  }
}
