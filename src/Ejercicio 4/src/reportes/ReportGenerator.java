
package reportes;

import java.util.Date;

public abstract class ReportGenerator {
    protected String title;
    protected Date generationDate;

    // Método plantilla 
    public final Report ReportGenerator(Report config) {
        this.title = config.getTitle();
        this.generationDate = new Date();

        return new Report(title, generationDate, "Reporte generado correctamente en formato: " + config.getFormat());
    }   
    // Métodos abstractos que cada tipo de reporte implementará
    protected abstract void validateData();
    protected abstract void processData();
    protected abstract void formatOutput();
    // Métodos concretos compartidos
    protected void addHeader() { 
    System.out.println(title);
        System.out.println("Fecha de generación:" + generationDate);
    }
    protected void addFooter() { 
    System.out.println("Fin del Reporte");
    }
    
    public static  class SalesReport extends ReportGenerator{

        @Override
        protected void validateData() {
            System.out.println(" Validando datos de ventas");
        }

        @Override
        protected void processData() {
            System.out.println("Procesando datos de ventas y generando grafico");
           }

        @Override
        protected void formatOutput() {
            System.out.println("Generando formato en PDF");
            }  
    }
        public static class InventoryReport extends ReportGenerator{

        @Override
        protected void validateData() {
            System.out.println(" Validando inventario");
        }

        @Override
        protected void processData() {
            System.out.println("Procesando datos de inventario");
           }

        @Override
        protected void formatOutput() {
            System.out.println("Generando formato en Excel");
            }  
    }
         public static class FinancialReport extends ReportGenerator{

        @Override
        protected void validateData() {
            System.out.println(" Validando reporte financiero");
        }

        @Override
        protected void processData() {
            System.out.println("Procesando datos de reporte");
           }

        @Override
        protected void formatOutput() {
            System.out.println("Generando formato en PDF");
            }  
    }
        public static class EmpoyleReport extends ReportGenerator{

        @Override
        protected void validateData() {
            System.out.println(" Validando datos del empleado");
        }

        @Override
        protected void processData() {
            System.out.println("Procesando datos de RRHH");
           }

        @Override
        protected void formatOutput() {
            System.out.println("Generando formato en CSV");
            }  
    }
}
   

