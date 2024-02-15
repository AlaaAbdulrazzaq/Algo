package U4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Airport {

    public class Airplane{
        private int timestamp;
        public Airplane(int timestamp){
            this.timestamp = timestamp;
        }

    }

    private int tickrate, timestamp, queueTimeLeft;
    private int maxArrWaitTime, maxDepWaitTime, totalArrWaitTime, totalDepWaitTime;
    private int totalArrPlanes, totalDepPlanes;
    private final Queue<Airplane> incoming, departing;
    private final Random random;
    public Airport(){
        tickrate = 5;
        queueTimeLeft = 0;
        timestamp = 0;
        incoming = new LinkedList<>();
        departing = new LinkedList<>();
        random = new Random();

        maxArrWaitTime = 0;
        maxDepWaitTime = 0;
        totalArrWaitTime = 0;
        totalDepWaitTime = 0;
        totalArrPlanes = 0;
        totalDepPlanes = 0;
    }
    public void runSimulation(float years){
        runSimulation(5, years);
    }

    private void runSimulation(int tickrate, float years){
        this.tickrate = tickrate;
        int ticksPerHour = 60/tickrate;
        int loopCount = (int) (ticksPerHour * 24 * 365 * years);

        for (int i = 0; i <= loopCount; i++) {
            playTick();
        }
    }

    private void playTick(){
        if(random.nextFloat() <= 0.05){
            incoming.offer(new Airplane(timestamp));
            totalArrPlanes++;
        }
        if(random.nextFloat() <= 0.05){
            departing.offer(new Airplane(timestamp));
            totalDepPlanes++;
        }

        if(queueTimeLeft > 0) {
            queueTimeLeft = queueTimeLeft - tickrate;
        }
        if(queueTimeLeft <= 0) {
            if (!handleArrival()) {
                handleDeparture();
            }
        }

        totalArrWaitTime += tickrate * incoming.size();
        totalDepWaitTime += tickrate * departing.size();
        timestamp += tickrate;
    }

    private boolean handleArrival(){
        if(incoming.peek() != null){
            var plane = incoming.poll();
            var wait = timestamp - plane.timestamp;
            if(wait > maxArrWaitTime)
                maxArrWaitTime = wait;
            queueTimeLeft = 20;
            return true;
        }
        return false;
    }

    private void handleDeparture(){
        if(departing.peek() != null){
            var plane = departing.poll();
            var wait = timestamp - plane.timestamp;
            if(wait > maxDepWaitTime)
                maxDepWaitTime = wait;
            queueTimeLeft = 20;
        }
    }

    public float getAverageArrWaitTime(){
        return  (float) totalArrWaitTime / (float) totalArrPlanes;
    }

    public float getAverageDepWaitTime(){
        return (float) totalDepWaitTime / (float) totalDepPlanes;
    }

    public int getMaxArrWaitTime() {
        return maxArrWaitTime;
    }

    public int getMaxDepWaitTime() {
        return maxDepWaitTime;
    }
}
