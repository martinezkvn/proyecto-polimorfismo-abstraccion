/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import reportes.ReportGenerator;
import reportes.ReportGenerator.FinancialReport;
import reportes.ReportGenerator.InventoryReport;
import reportes.ReportGenerator.SalesReport;
import reportes.ReportGenerator.EmpoyleReport;

/**
 *
 * @author AGENCIA NORTE SAN
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

System.out.println("--- Iniciando la Generación de Reportes ---\n");

        // Crear instancias de los diferentes generadores de reportes
        ReportGenerator salesReportGenerator = new SalesReport();
        ReportGenerator inventoryReportGenerator = new InventoryReport();
        ReportGenerator financialReportGenerator = new FinancialReport();
        ReportGenerator empoyleReportGenerator = new EmpoyleReport();
    }
    
    
}
