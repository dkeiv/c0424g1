public class Main {
    public static void main(String[] args) {
        try {
            Thread odd = new Thread(new OddThread());
            Thread even = new Thread(new EvenThread());

            odd.start();
            odd.join();

            even.start();
            even.join();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}