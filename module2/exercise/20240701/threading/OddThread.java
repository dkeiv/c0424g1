public class OddThread implements Runnable {
    public OddThread() {
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(10);
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
