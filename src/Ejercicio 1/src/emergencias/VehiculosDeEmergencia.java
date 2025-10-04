
package emergencias;

import java.util.ArrayList;
import java.util.List;

public interface VehiculosDeEmergencia {
   
    interface VehiculosEmergencia {
    void activarSirena();
    void responderEmergencia();
    String getTipoVehiculo();
    }
    
    // clase ambulancia
    
    class ambulancia implements VehiculosEmergencia{

   @Override
    public void activarSirena() {
    System.out.println("sirena activa"); 
     }

    @Override
     public void responderEmergencia() {
    System.out.println("atendiendo llamado de emergencia");      }

     @Override
     public String getTipoVehiculo() {     
       return "ambulacia";
    }
        
    }
    
    //clase Bomberos
    
    class BomberosVehiculo implements VehiculosEmergencia {

    @Override
    public void activarSirena() {
        System.out.println("Sirena de incendio activada.");
    }

    @Override
    public void responderEmergencia() {
        System.out.println("Acudiendo al incendio.");
    }

    @Override
    public String getTipoVehiculo() {
        return "Camión de Bomberos";
    }
}
    // calse patrulla

    class PatrullaPolicia implements VehiculosEmergencia {

    @Override
    public void activarSirena() {
        System.out.println("Sirena policial activada.");
    }

    @Override
    public void responderEmergencia() {
        System.out.println("acuduendo a la situación .");
    }

    @Override
    public String getTipoVehiculo() {
        return "Patrulla de Policía";
    }
}
    // central de emergencias
    
    class centralEmergencias{
        private List <VehiculosEmergencia> vehiculos;
        private VehiculosEmergencia vehiculo;
        
        public centralEmergencias(){
            vehiculos = new ArrayList<>();
        }
       
        public void agregarVehiculo(VehiculosEmergencia Vehiculo){
            vehiculos.add(vehiculo);
        }
        //despachar vehiculo
        public void despacharVehiculos() {
        System.out.println("Despachando vehículos de emergencia");
        for (VehiculosEmergencia v : vehiculos) {
            System.out.println("Tipo:" + v.getTipoVehiculo());
            v.activarSirena();
            v.responderEmergencia();
            System.out.println();
        }
    }

        
    }
    
}
