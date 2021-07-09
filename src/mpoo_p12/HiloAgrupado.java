package mpoo_p12;
/**
 * @author Brigada A
 */
public class HiloAgrupado extends Thread{
/**
 * @param name Nombre del grupo de hilos
 * @param group Nombre del grupo de hilos donde se agruparan los hilos
 */
    public HiloAgrupado(ThreadGroup group, String name) {
        super(group, name);
    }
    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteración "+i+" de "+getName());
        }
        System.out.println("Ha terminado el hilo "+getName());
    }
}
