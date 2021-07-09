package mpoo_p12;
/**
 * @author Brigada A
 */
public class Cuenta extends Thread{
    private static long saldo = 0;
/**
 * @param name Nombre del Hilo (Cuenta)
 */
    public Cuenta(String name) {
        super(name);
    }

    @Override
    public void run(){
       if(getName().equals("Deposito 1") || getName().equals("Deposito 2")){
           this.depositarDinero(100);
       } else{
           this.extraerDinero(50);
       }
    }
    
    public synchronized void depositarDinero(int cantidad){
        saldo += cantidad;
        System.out.println("Se depositaron "+cantidad+" pesos");
        notifyAll();
    }
    
    public synchronized void extraerDinero(int cantidad){
        try{
            if(saldo <=0){
                System.out.println(getName()+" espera deposito"+"\nSaldo = "
                        +saldo);
                sleep(5000);
            }
        } catch(InterruptedException ie){
            System.out.println(ie);
        }
        saldo -= cantidad;
        System.out.println(getName()+" extrajo "+cantidad+" pesos"+
                "\nSaldo restante = "+saldo);
        notifyAll();
    }
}
