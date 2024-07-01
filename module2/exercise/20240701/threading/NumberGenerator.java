public class NumberGenerator implements Runnable {
//    private final Thread thread;

    public NumberGenerator() {
//        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(this.hashCode()+ ": " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
