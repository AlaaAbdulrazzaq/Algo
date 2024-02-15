package NB14;

public class Myntmaskinen {
   public static int myntMaskin(int targetPoints){
      return myntMaskin(targetPoints, 1, 0); // Start with 1 point and 0 kronor
   }

   private static int myntMaskin(int targetPoints, int currentPoints, int currentKronor) {
      if (currentPoints >= targetPoints) {
         return currentKronor;
      }

      int costWith5Krona = Integer.MAX_VALUE;
      int costWith10Krona = Integer.MAX_VALUE;

      // Check if adding 4 points is a viable option
      if (currentPoints + 4 <= targetPoints) {
         costWith5Krona = myntMaskin(targetPoints, currentPoints + 4, currentKronor + 5);
      }

      // Check if tripling the points is a viable option
      if (currentPoints * 3 <= targetPoints) {
         costWith10Krona = myntMaskin(targetPoints, currentPoints * 3, currentKronor + 10);
      }

      // Find the minimum cost among the two options
      return Math.min(costWith5Krona, costWith10Krona);
   }
}

