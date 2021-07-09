package mpoo_p12;
/**
 * @author Brigada A
 */
public class MPOO_P12 {
    /**
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        System.out.println("******* Thread *******");
        HiloT hiloT1 = new HiloT("Primer Hilo");
        hiloT1.start();
        
        new HiloT("Segundo Hilo").start();
        System.out.println("Termina el hilo principal");
        
        System.out.println("******* Runnable *******");
        new Thread(new HiloR(), "Primer Hilo").start();
        new Thread(new HiloR(), "Segundo Hilo").start();
        System.out.println("Termina el hilo principal");
        
        System.out.println("******* ThreadGroup *******");
        ThreadGroup grupoHilos = new ThreadGroup("Grupo de hilos");
        Thread hilo1 = new HiloAgrupado(grupoHilos, "Hilo 1");
        Thread hilo2 = new HiloAgrupado(grupoHilos, "Hilo 2");
        Thread hilo3 = new HiloAgrupado(grupoHilos, "Hilo 3");
        Thread hilo4 = new HiloAgrupado(grupoHilos, "Hilo 4");
        Thread hilo5 = new HiloAgrupado(grupoHilos, "Hilo 5");
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        
        listarHilos(grupoHilos);
        
        System.out.println("******* Prioridades *******");
        System.out.println("Prioridad del grupo = "+grupoHilos.getMaxPriority());
        hilo3.setPriority(Thread.MAX_PRIORITY);
        grupoHilos.setMaxPriority(Thread.NORM_PRIORITY);
        System.out.println("Prioridad del grupo = "+grupoHilos.getMaxPriority());
        System.out.println("Prioridad del Thread 1 = "+hilo1.getPriority());
        System.out.println("Prioridad del Thread 2 = "+hilo2.getPriority());
        System.out.println("Prioridad del Thread 3 = "+hilo3.getPriority());
        System.out.println("Prioridad del Thread 4 = "+hilo4.getPriority());
        System.out.println("Prioridad del Thread 5 = "+hilo5.getPriority());
          
          new Cuenta("Acceso 1").start();
          new Cuenta("Acceso 2").start();
          new Cuenta("Deposito 1").start();
          new Cuenta("Deposito 2").start();
          System.out.println("Termina el hilo principal");
    }

    private static void listarHilos(ThreadGroup grupoHilos){
        System.out.println("Entrando en el método listarHilos");
        int numHilos;
        try{
            Thread[] listaDeHilos;

            numHilos = grupoHilos.activeCount();
            listaDeHilos = new Thread[numHilos];
            grupoHilos.enumerate(listaDeHilos);
            System.out.println("Hilos activos: "+numHilos);

            for (int i = 0; i < numHilos; i++) {
                System.out.println("Hilo activo en pos "+i
                        + " = "+listaDeHilos[i].getName());            
            }
        }catch(NullPointerException npex){
            System.out.println("ERROR. Los hilos terminaron antes de tiempo");
        }
    }
}
