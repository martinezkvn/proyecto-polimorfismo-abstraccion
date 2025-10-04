package AppDocumentos;

import documentos.DocumentProcessor;
import documentos.DocumentProcessor.ExcelProcessor;
import documentos.DocumentProcessor.PDFProcessor;
import documentos.DocumentProcessor.WordProcessor;

/**
 *
 * @author AGENCIA NORTE SAN
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
         System.out.println("--- Iniciando el Procesamiento de Documentos ---\n");

        // Crear instancias de los diferentes procesadores
        DocumentProcessor pdfProcessor = new PDFProcessor();
        DocumentProcessor wordProcessor = new WordProcessor();
        DocumentProcessor excelProcessor = new ExcelProcessor();

        // Procesar diferentes tipos de documentos
        pdfProcessor.processDocument("reporte_anual.pdf");
        wordProcessor.processDocument("especificaciones_tecnicas.docx");
        excelProcessor.processDocument("datos_financieros.xlsx");

        // Intentar procesar un formato no soportado para demostrar la validación
        System.out.println("--- Intentando procesar un formato no válido ---");
        pdfProcessor.processDocument("imagen_logo.png");
    }
}
        
        
