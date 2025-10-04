
package main;

import validaciones.Validator;
import validaciones.Validator.CreditCardValidator;
import validaciones.Validator.EmailValidator;
import validaciones.Validator.PasswordValidator;
import validaciones.Validator.PhoneNumberValidator;

public class NewMain {

    public static void main(String[] args) {
    System.out.println("Framework de Validaciones");

        //  Validador de Email
        System.out.println("Pruebas de EmailValidator");
        Validator<String> emailValidator = new EmailValidator();
        // Caso válido
        System.out.println("Validando: 'usuario.valido@email.com'");
        System.out.println(emailValidator.validate("usuario.valido@email.com") + "\n");
        // Caso inválido
        System.out.println("Validando: 'email-invalido.com'");
        System.out.println(emailValidator.validate("email-invalido.com") + "\n");
        

        //Validador de Contraseña
        System.out.println("Pruebas de Password");
        Validator<String> passwordValidator = new PasswordValidator();
        // Caso válido y fuerte
        System.out.println("Validando: 'P@ssw0rdFuerte!'");
        System.out.println(passwordValidator.validate("P@ssw0rdFuerte!") + "\n");
        // Caso inválido (corto)
        System.out.println("Validando: 'corta'");
        System.out.println(passwordValidator.validate("corta") + "\n");
       

        // --- 3. Pruebas del Validador de Tarjeta de Crédito ---
        System.out.println("Pruebas de trajeta de credito ");
        Validator<String> ccValidator = new CreditCardValidator();
        // Caso válido
        System.out.println("Validando: '1234-5678-9012-3456'");
        System.out.println(ccValidator.validate("1234-5678-9012-3456") + "\n");
        // Caso inválido (dígitos insuficientes)
        System.out.println("Validando: '1234 5678'");
        System.out.println(ccValidator.validate("1234 5678") + "\n");
        

        // --- 4. Pruebas del Validador de Número de Teléfono ---
        System.out.println("Pruebas de numero de telefonorValidator");
        Validator<String> phoneValidator = new PhoneNumberValidator();
        // Caso válido con código de país
        System.out.println("Validando: '+1 (123) 456-7890'");
        System.out.println(phoneValidator.validate("+1 (123) 456-7890") + "\n");
        
    }
}
    

