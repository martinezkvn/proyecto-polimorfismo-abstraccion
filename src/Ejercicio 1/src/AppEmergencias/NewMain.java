
package AppEmergencias;

import emergencias.VehiculosDeEmergencia;
import emergencias.VehiculosDeEmergencia.BomberosVehiculo;
import emergencias.VehiculosDeEmergencia.PatrullaPolicia;
import emergencias.VehiculosDeEmergencia.ambulancia;
import emergencias.VehiculosDeEmergencia.centralEmergencias;

public class NewMain {

    public static void main(String[] args) {
        
        centralEmergencias central = new centralEmergencias();

        // Crear instancias de los diferentes vehículos de emergencia
        VehiculosDeEmergencia ambulancia = (VehiculosDeEmergencia) new ambulancia();
        VehiculosDeEmergencia bomberos = (VehiculosDeEmergencia) new BomberosVehiculo();
        VehiculosDeEmergencia patrulla = (VehiculosDeEmergencia) new PatrullaPolicia();

        // Agregar los vehículos a la central de emergencias
        central.agregarVehiculo((VehiculosDeEmergencia.VehiculosEmergencia) ambulancia);
        central.agregarVehiculo((VehiculosDeEmergencia.VehiculosEmergencia) bomberos);
        central.agregarVehiculo((VehiculosDeEmergencia.VehiculosEmergencia) patrulla);

        // Despachar todos los vehículos de la central
        central.despacharVehiculos();
    }
}
    
    

