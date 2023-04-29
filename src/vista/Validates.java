package vista;

import java.util.Scanner;

public class Validates {
    
    public static boolean isValidatePass(String password) {
        
        if(password.length() > 8) {
            boolean capitalLetter = false;
            boolean number = false;
            boolean specialCharacter = false;
            char c;
            
            for(int i=0; i < password.length(); i++) {
                
                c = password.charAt(i);
                if(Character.isDigit(c))
                    number = true;
                if(Character.isUpperCase(c))
                    capitalLetter = true;
                if(!Character.isLetterOrDigit(c))
                    specialCharacter = true;
                
            }
            if (number && capitalLetter && specialCharacter)
                return true;
            
        } else {
            return false;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Ingresa tu contraseña: ");
        String pass = x.nextLine();
        
        if(isValidatePass(pass)) {
            System.out.println("La contraseña es segura");
        } else {
            System.out.println("La contraseña no es segura");
        }
        
    }
    
}
