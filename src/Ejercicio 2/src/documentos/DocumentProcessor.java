package documentos;


public abstract class DocumentProcessor {

    public final void processDocument(String filePath) {
        System.out.println("Procesando documento " + filePath);

        if (!validateFormat(filePath)) {
            System.out.println("Formato inválido: " + filePath);
            System.out.println("Finalizado con error");
            return;
        }
        DocumentContent content = extractContent(filePath);  
        saveProcessedDocument(content);                      
         System.out.println("Procesamiento completado");
    }

    // Métodos abstractos
    protected abstract boolean validateFormat(String filePath);
    protected abstract DocumentContent extractContent(String filePath);
    protected abstract void saveProcessedDocument(DocumentContent content);

// Clase auxiliar
class DocumentContent {
    private String text;
    private String metadata;

    public DocumentContent(String text, String metadata) {
        this.text = text;
        this.metadata = metadata;
    }

    public String getText() {
        return text;
    }

    public String getMetadata() {
        return metadata;
    }
}

//  PDFProcessor
public static class PDFProcessor extends DocumentProcessor {

    @Override
    protected boolean validateFormat(String filePath) {
        return filePath.toLowerCase().endsWith(".pdf");
    }

    @Override
    protected DocumentContent extractContent(String filePath) {
        System.out.println("Extrayendo texto y metadatos del PDF");
        return new DocumentContent("Texto del PDF", "Metadatos PDF");
    }

    @Override
    protected void saveProcessedDocument(DocumentContent content) {
        System.out.println("Guardando PDF procesado con texto: " + content.getText());
    }
    }

    //  WordProcessor
    public static class WordProcessor extends DocumentProcessor {

    @Override
    protected boolean validateFormat(String filePath) {
        return filePath.toLowerCase().endsWith(".docx");
    }

    @Override
    protected DocumentContent extractContent(String filePath) {
        System.out.println("Extrayendo texto y estilos del word");
        return new DocumentContent("Texto del Word", "Estilos del Word");
    }

    @Override
    protected void saveProcessedDocument(DocumentContent content) {
        System.out.println("Guardando Word, procesanso estilos");
    }   
    }
    //  ExcelProcessor
    public static class ExcelProcessor extends DocumentProcessor {

    @Override
    protected boolean validateFormat(String filePath) {
        return filePath.toLowerCase().endsWith(".xlsx");
    }

    @Override
    protected DocumentContent extractContent(String filePath) {
        System.out.println("Extrayendo texto y estilos del word");
        return new DocumentContent("Texto del excel", "Formulas de Excel");
    }

    @Override
    protected void saveProcessedDocument(DocumentContent content) {
        System.out.println("Guardando excel");
    }   
    
}
}
