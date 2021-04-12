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
public class Contacto {  
    
    private String nombre;
    private String telefono;
    
    public Contacto(){
        nombre = "";
        telefono = "";
    }
    
    public Contacto(String nom, String tel){
        nombre = nom;
        telefono = tel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", telefono=" + telefono + '}';
    }
    
    public static boolean esValidoNombre(String nom){
        if (nom.length() == 0){
            //System.out.println("Error, el nombre debe contener algún carácter");
            return false;
        }
        
        for (int i = 0; i < nom.length(); ++i){
            if (!FuncionesSobreCaracteres.esCaracterAlfabetico(nom.charAt(i))){
               // System.out.println("Error, el nombre contine un carácter no alfabético en la posición " + (i+1));
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean esValidoTelefono(String tel){
        
          if (tel.length() != 9){
              //System.out.println("Error, el telefono debe tener 9 dígitos");
              return false;
          }
          
          if (tel.charAt(0) != '6' && tel.charAt(0) != '7' && tel.charAt(0) != '8' && tel.charAt(0) != '9'){
             //System.out.println("Error, el teléfono no comienza por 6, 7, 8 ó 9");
             return false;
          }
          
          // Si llegamos hasta aquí, significa que tel tiene longitud 9 y que comienza por 6 ó 7 ó 8 ó 9
          
          for (int i = 1; i < tel.length(); ++i){
              if (!FuncionesSobreCaracteres.esNumeroValido(tel.charAt(i))){ // (!Character.isDigit(tel.charAt(i))))
                  //System.out.println("Error, el digito de la posicion " + (i + 1) + " no es un número");
                  return false;
              }
          }
          
          return true;
    }
    
}
