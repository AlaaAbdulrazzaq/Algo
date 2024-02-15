package U4;
public class main {
    public static void main(String[] args) {
        Airport arn = new Airport();
        arn.runSimulation(10);
        System.out.println("incoming avg wait time: " + arn.getAverageArrWaitTime());
        System.out.println("outgoing avg wait time: " + arn.getAverageDepWaitTime());
        System.out.println("incoming max wait time: " + arn.getMaxArrWaitTime());
        System.out.println("outgoing max wait time: " + arn.getMaxDepWaitTime());
    }
}

