
package validaciones;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Validator<T> {

    // M	odo plantilla que define el esqueleto del algoritmo de validaci

    public final validationResult validate(T data) {
        boolean valid = isValid(data);
        String error = valid ? null : getErrorMessage();
        List<String> warnings = getWarnings(data);
        return new validationResult(valid, error, warnings);
    }

    // M	odos abstractos que las subclases deben implementar
    protected abstract boolean isValid(T data);
    protected abstract String getErrorMessage();

    // M	odo hook que las subclases pueden anular para proporcionar advertencias
    protected List<String> getWarnings(T data) {
        return new ArrayList<>();
    }
    
    // Email
    public static class EmailValidator extends Validator<String> {
        private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$"
        );

        @Override
        protected boolean isValid(String email) {
            return email != null && EMAIL_PATTERN.matcher(email).matches();
        }

        @Override
        protected String getErrorMessage() {
            return "El formato del email es inválido. Debe ser como 'usuario@dominio.com'.";
        }

        @Override
        protected List<String> getWarnings(String email) {
            List<String> warnings = new ArrayList<>();
            if (email != null && (email.endsWith("@mailinator.com") || email.endsWith("@temp-mail.org"))) {
                warnings.add("Se está utilizando un proveedor de correo electrónico temporal.");
            }
            return warnings;
        }
    }

    //  Contraseña
    public static class PasswordValidator extends Validator<String> {
        @Override
        protected boolean isValid(String password) {
            return password != null && password.length() >= 8;
        }

        @Override
        protected String getErrorMessage() {
            return "La contraseña es demasiado corta. Debe tener al menos 8 caracteres.";
        }

        @Override
        protected List<String> getWarnings(String password) {
            List<String> warnings = new ArrayList<>();
            if (password == null) return warnings;

            boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
            for (char c : password.toCharArray()) {
                if (Character.isLowerCase(c)) hasLower = true;
                else if (Character.isUpperCase(c)) hasUpper = true;
                else if (Character.isDigit(c)) hasDigit = true;
                else hasSpecial = true;
            }

            if (!hasLower || !hasUpper || !hasDigit || !hasSpecial) {
                warnings.add("La contraseña es débil. Se recomienda incluir mayúsculas, minúsculas, números y símbolos.");
            }
            return warnings;
        }
    }

    // Tarjeta de Crédito
    public static class CreditCardValidator extends Validator<String> {
        @Override
        protected boolean isValid(String cardNumber) {
            if (cardNumber == null) return false;
            String cleanedNumber = cardNumber.replaceAll("[\\s-]+", "");
            return cleanedNumber.matches("^[0-9]{16}$");
        }

        @Override
        protected String getErrorMessage() {
            return "El número de tarjeta de crédito es inválido. Debe contener 16 dígitos.";
        }
    }

    // Número de Teléfono
    public static class PhoneNumberValidator extends Validator<String> {
        @Override
        protected boolean isValid(String phoneNumber) {
            if (phoneNumber == null) return false;
            String cleanedNumber = phoneNumber.replaceAll("[\\s()-]+", "");
            return cleanedNumber.matches("^\\+?[0-9]{10,15}$");
        }

        @Override
        protected String getErrorMessage() {
            return "El número de teléfono es inválido. Debe contener entre 10 y 15 dígitos.";
        }

        @Override
        protected List<String> getWarnings(String phoneNumber) {
            List<String> warnings = new ArrayList<>();
            if (phoneNumber != null && !phoneNumber.trim().startsWith("+")) {
                warnings.add("El número no incluye un código de país (ej. +1, +52).");
            }
            return warnings;
        }
    }
}
    

