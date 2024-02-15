package NB13;

public class SquareRoot {

    public static double doublesqrt(double n){
        return calcSqrt(n, 1, 0.001);
    }
    private static double calcSqrt(double n, double a, double e) {
        if((Math.abs((a*a)-n)) < e) {
            return a;
        }else {
            double result = (((a*a)+n)/(2*a));
            return calcSqrt(n, result, e);
        }
    }
}
