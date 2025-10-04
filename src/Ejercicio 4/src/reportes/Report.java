package reportes;
import java.util.Date;

public class Report {
    private String title;
    private Date date;
    private String message;

    public Report(String title, Date date, String message) {
        this.title = title;
        this.date = date;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    String getFormat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

