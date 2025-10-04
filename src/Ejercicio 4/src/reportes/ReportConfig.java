/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportes;
import java.util.Date;
/**
 *
 * @author AGENCIA NORTE SAN
 */
public class ReportConfig {
    
    private String title;
    private Date generationDate;

    public ReportConfig(String title, Date generationDate) {
        this.title = title;
        this.generationDate = generationDate;
    }

    public String getTitle() {
        return title;
    }

    public Date getGenerationDate() {
        return generationDate;
    }
}


