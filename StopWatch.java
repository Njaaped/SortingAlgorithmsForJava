


public class StopWatch {
    private long startTime;
    private long stopTime;
    private boolean isRunning;

    public void start() {
        if (isRunning) {
            throw new IllegalStateException("Stopwatch is already running. Call stop() first.");
        }
        startTime = System.nanoTime();
        isRunning = true;
    }

    public void stop() {
        if (!isRunning) {
            throw new IllegalStateException("Stopwatch is not running. Call start() first.");
        }
        stopTime = System.nanoTime();
        isRunning = false;
    }

    public long getElapsedTime() {
        if (isRunning) {
            throw new IllegalStateException("Stopwatch is still running. Call stop() first.");
        }
        return stopTime - startTime;
    }

    public void reset() {
        startTime = 0;
        stopTime = 0;
        isRunning = false;
    }
}