/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicaconbdmodotexto;

/**
 *
 * @author Alberto
 */
public class FuncionesSobreCaracteres {
    
    
    public static boolean esNumeroValido(char car){
        return car >= '0' && car <= '9';
     
    }
    
    public static boolean esCaracterAlfabetico(char car){  // Character.isLetter(car)
        
        if (car >= 'A' && car <= 'Z'){
            return true;
        }
        return car >= 'a' && car <= 'z';
    }
}
