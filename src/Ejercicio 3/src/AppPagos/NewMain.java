
package AppPagos;
import pagos.*;

import java.util.ArrayList;
import java.util.List;
import pagos.Paypal.Bitcoin;
import pagos.Paypal.TarjetaCredito;


public class NewMain {

    public static void main(String[] args) {
     
        List<PaymentProcessor> procesadores = new ArrayList<>();
        procesadores.add(new pagos());
        procesadores.add(new Paypal());
        procesadores.add(new TarjetaCredito());
        procesadores.add(new Bitcoin());

        System.out.println("--- PROCESANDO PAGOS VÁLIDOS ---");
        procesadores.get(0).processPayment("España", 250, "EUR"); 
        procesadores.get(1).processPayment("EEUU", 50, "USD");    
        procesadores.get(2).processPayment("Francia", 120, "EUR"); 
        procesadores.get(3).processPayment("Japón", 0.5, "BTC");   

        System.out.println("\n--- INTENTANDO PAGOS INVÁLIDOS ---");
        procesadores.get(0).processPayment("España", 50, "EUR");  
        procesadores.get(1).processPayment("México", 100, "MXN");  
        procesadores.get(2).processPayment("Canadá", 20, "CAD");  
        procesadores.get(3).processPayment("Corea", 0.005, "BTC"); 
    }
}
    
