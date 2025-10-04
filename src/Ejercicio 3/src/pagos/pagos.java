package pagos;

import java.util.*;


   interface PaymentProcessor {
    boolean validate(String pais, double cantidad, String moneda);
    void processPayment(String pais, double cantidad, String moneda);
}
   public class pagos implements PaymentProcessor {
    @Override
    public boolean validate(String pais, double cantidad, String moneda) {
        System.out.println("Validando datos bancarios");
        //Transferencia debe ser mayor o igual a 100
        return cantidad >= 100;
    }

    @Override
    public void processPayment(String pais, double cantidad, String moneda) {
        if (validate(pais, cantidad, moneda)) {
            System.out.println("Transferencia exitosa: " + cantidad + " " + moneda + " desde " + pais);
        } else {
            System.out.println("Monto demasiado bajo.");
        }
    }
}
     public class Paypal implements PaymentProcessor {
    @Override
    public boolean validate(String pais, double cantidad, String moneda) {
        System.out.println("Validando datos");
        //solo se permite dollar
        return moneda.equals("USD") ;
    }

    @Override
    public void processPayment(String pais, double cantidad, String moneda) {
        if (validate(pais, cantidad, moneda)) {
            System.out.println("Pago realizado desde: " + cantidad + " " + moneda + " desde " + pais);
        } else {
            System.out.println("Pago no valido");
        }
    }
     public static class TarjetaCredito implements PaymentProcessor {
    @Override
    public boolean validate(String pais, double cantidad, String moneda) {
        System.out.println("Validando datos");
        //Solo se puede usar dollar o euro
        return (moneda.equals("USD"))||(moneda.equals("EUR")) && cantidad > 1;
    }

    @Override
    public void processPayment(String pais, double cantidad, String moneda) {
        if (validate(pais, cantidad, moneda)) {
            System.out.println("Pago realizado desde: " + cantidad + " " + moneda + " desde " + pais);
        } else {
            System.out.println("Pago rechazado");
        }
    
}
     }
     
      public static class Bitcoin implements PaymentProcessor {
    @Override
    public boolean validate(String pais, double cantidad, String moneda) {
        System.out.println("Validando datos");
        return (moneda.equals("BTC"))&& cantidad > 0.01;
    }

    @Override
    public void processPayment(String pais, double cantidad, String moneda) {
        if (validate(pais, cantidad, moneda)) {
            System.out.println("Transaccion realizada desde: " + cantidad + " " + moneda + " desde " + pais);
        } else {
            System.out.println("Transaccion rechazada");
        }
    
}
     }
     
     
     
    }




