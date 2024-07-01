public class EvenThread implements Runnable {

    public EvenThread() {
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(15);
                if (i % 2 != 0) {
                    System.out.println(i);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
