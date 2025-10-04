/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validaciones;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AGENCIA NORTE SAN
 */
public class validationResult {
    private final boolean isValid;
    private final String errorMessage;
    private final List<String> warnings;

    public validationResult(boolean isValid, String errorMessage, List<String> warnings) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
        this.warnings = warnings != null ? new ArrayList<>(warnings) : new ArrayList<>();
    }

    public boolean isValid() {
        return isValid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public List<String> getWarnings() {
        return new ArrayList<>(warnings);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Resultado de la Validación: ");
        if (isValid) {
            sb.append("ÉXITO");
        } else {
            sb.append("FALLO");
        }
        if (errorMessage != null && !errorMessage.isEmpty()) {
            sb.append("\n  - Error: ").append(errorMessage);
        }
        if (!warnings.isEmpty()) {
            sb.append("\n  - Advertencias:");
            for (String warning : warnings) {
                sb.append("\n    - ").append(warning);
            }
        }
        return sb.toString();
    }
}

