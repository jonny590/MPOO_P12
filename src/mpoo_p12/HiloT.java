package mpoo_p12;
/**
 * @author Brigada A
 */
public class HiloT extends Thread{
    /**
     * @param name Nombre del hilo
     */
    public HiloT(String name) {
        super(name);
    }
    
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteración "+i+" de "+getName());
        }
        System.out.println("Termina el "+getName());
    }
}
