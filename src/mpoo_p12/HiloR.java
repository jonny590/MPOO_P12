package mpoo_p12;
/**
 * @author Brigada A
 */
public class HiloR implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteración "+i+" de "
                    +Thread.currentThread().getName());   
        }
        System.out.println("Termina el "+Thread.currentThread().getName());
    }
}
