/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleadojunit;

import java.util.Scanner;

/**
 *
 * @author Alex'sCucumbah
 */
public class EmpleadoJUnit {

    /**
     * @param args the command line arguments
     */
     public static String asignarSueldo(String empleado, String departamento, String oficio){
            
            
            
            if (empleado.length()>3 || empleado.length()==0) {
                return("ER1");
            }else if (empleado.charAt(0) != '0') {
                return("ER1");
            }else if (Integer.parseInt(empleado) > 99 || Integer.parseInt(empleado) < 0) {
               return("ER1"); 

                }else if (departamento.length()>2){
                    return("ER2");
                }else if (Integer.parseInt(departamento) > 99 || Integer.parseInt(departamento) < 0) {
                    return("ER2");

                    }else if (oficio.toLowerCase().compareTo("analista") == 0) {
                            return("2500");
                    }else if (oficio.toLowerCase().compareTo("diseñador") == 0) {
                            return("1500");
                    }else if (oficio.toLowerCase().compareTo("programador") == 0) {
                            return("2000");
                    }else{
                            return("ER3");
                        }

        
        }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        String empleado, departamento, oficio;
     
        String ER1 ="Empleado no es correcto";
        String ER2="Departamento no es correcto";
        String ER3="No se ha elegido oficio";
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Inserte el campo Empleado");
        empleado=sc.nextLine();
        System.out.println("Inserte el campo Departamento");
        departamento=sc.nextLine();
        System.out.println("Inserte el campo Oficio");
        oficio=sc.nextLine();
        
        System.out.println(asignarSueldo(empleado, departamento, oficio));
       
        
    }
    
}
