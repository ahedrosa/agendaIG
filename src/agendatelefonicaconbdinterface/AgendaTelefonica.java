/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendatelefonicaconbdinterface;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



/**
 *
 * @author Alberto
 */
public class AgendaTelefonica{
   
    private String nomBD;
    private String nomTabla;
    private Connection con;
   
    public AgendaTelefonica(String nomBD, String nomTabla)throws SQLException, ClassNotFoundException{
        this.nomBD = nomBD;
        this.nomTabla = nomTabla;
        con = obtener(this.nomBD);
    }

    public void reconectar() throws SQLException, ClassNotFoundException {
        con = obtener(this.nomBD);
    }
    
    
    public Connection obtener(String nomBD) throws SQLException, ClassNotFoundException {
      
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3310/" + nomBD, "root", "root");
            System.out.println("Conexion exitosa");
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      
     return con;
    }
     
   public void cerrar() throws SQLException {
      if (con != null) {
         con.close();
          System.out.println("Conexión cerrada con éxito");
      }
   }
          
    public static int menu(){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("----");
            System.out.println("1. Consulta");
            System.out.println("2. Alta");
            System.out.println("3. Baja");
            System.out.println("4. Modificación");
            System.out.println("5. Listar agenda");
            System.out.println("6. Terminar");
            
            System.out.println("Dame opcion:");
            opcion = entrada.nextInt();
            entrada.nextLine();
            if (opcion < 1 || opcion > 7){
                System.out.println("Opción incorrecta");
            }
        } while (opcion < 1 || opcion >6);
        
        return opcion;
        
    }
    
    
    public Contacto buscarPorNombre(String nombre) throws SQLException {
      Contacto contacto = null;
      try{
         PreparedStatement consulta = con.prepareStatement("SELECT nombre, telefono FROM " + this.nomTabla + " WHERE nombre = ?" );
         consulta.setString(1, nombre.toLowerCase());
         ResultSet resultado = consulta.executeQuery();
         
         while(resultado.next()){
            contacto = new Contacto(resultado.getString("nombre"), resultado.getString("telefono"));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return contacto;
   }
     
    public Contacto buscarPorTelefono(String tel) throws SQLException {
      Contacto contacto = null;
      try{
         PreparedStatement consulta = con.prepareStatement("SELECT nombre, telefono FROM " + this.nomTabla + " WHERE telefono = ?" );
         consulta.setString(1, tel);
         ResultSet resultado = consulta.executeQuery();
         
         while(resultado.next()){
            contacto = new Contacto(resultado.getString("nombre"), resultado.getString("telefono"));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return contacto;
   }
    
    public boolean seRepiteTelefono(String tel) throws SQLException {
      Contacto contacto = new Contacto();
      try{
         PreparedStatement consulta = con.prepareStatement("SELECT nombre, telefono FROM " + this.nomTabla + " WHERE telefono = ?" );
         consulta.setString(1, tel);
         ResultSet resultado = consulta.executeQuery();
         
         while(resultado.next()){
            contacto.setNombre(resultado.getString("nombre"));
            contacto.setTelefono(resultado.getString("telefono"));
         }
        }catch(SQLException ex){
           throw new SQLException(ex);
        }
      
        if (contacto.getTelefono().compareTo(tel)==0) {
            return true;
        }else{
            return false;
        }    
   }
     
  
    public  void consulta()throws SQLException{
        
        // Se introduce un dato (nombre o telefono) y el programa
        // determina el tipo de dato introducido, es decir, si es
        // un nombre o si es un telefono y a continuación lleva
        // a cabo  la consulta
        
        String dato;
        Scanner entrada = new Scanner(System.in);
        String nombre, telefono;
        Contacto contacto = null;
        
        do{
            System.out.println("Dame el dato a consultar (nombre o teléfono):");
            dato = entrada.nextLine();
            if (!Contacto.esValidoNombre(dato) && !Contacto.esValidoTelefono(dato)){
                System.out.println("Error, el dato introducido no es nombre, ni telefono");
            }
           
        } while (!Contacto.esValidoNombre(dato) && !Contacto.esValidoTelefono(dato));
        
        if (Contacto.esValidoNombre(dato)){
            nombre = dato.toUpperCase();
            contacto = buscarPorNombre(nombre);
            if (contacto  == null){
                System.out.println(nombre + " no esta en la agenda");
            } else{
                System.out.println(nombre + "\t" + contacto.getTelefono());
            }
        } else{  // Es un telefono valido
            telefono = dato;
            contacto = buscarPorTelefono(telefono);
             if (contacto == null){
                System.out.println(telefono + " no esta en la agenda");
            } else{
                System.out.println(contacto.getNombre()+ "\t" + telefono);
            }
        }
           
    }
    
    public void añade(Contacto contacto) throws SQLException{
        try{
            PreparedStatement consulta;
            consulta = con.prepareStatement("INSERT INTO " + this.nomTabla + "(nombre, telefono) VALUES(?, ?)");
            consulta.setString(1, contacto.getNombre());
            consulta.setString(2, contacto.getTelefono());
            consulta.execute();
        }catch(SQLException ex){
        throw new SQLException(ex);
      }
   }
    
      
    public void alta()throws SQLException{
        
        String nombre, telefono;
        Scanner entrada = new Scanner(System.in);
        
        do{
            do{

                System.out.println("Dame nombre a dar de alta:");
                nombre = entrada.nextLine();
                if (!Contacto.esValidoNombre(nombre)){
                    System.out.println("Error, nombre invalido");
                }

            } while (!Contacto.esValidoNombre(nombre));
            
            nombre = nombre.toLowerCase();
        
            if (buscarPorNombre (nombre) != null){
                System.out.println("Error, este nombre ya esta en la agenda");
            }
        } while (buscarPorNombre (nombre) != null);
        
        
        do{
            do{

                System.out.println("Dame el telefono a dar de alta:");
                telefono = entrada.nextLine();
                if (!Contacto.esValidoTelefono(telefono)){
                    System.out.println("Error, telefono invalido");
                }

            } while (!Contacto.esValidoTelefono(telefono));
            
            if (buscarPorTelefono(telefono) != null){
                System.out.println("Error, este teléfono está duplicado");
            }
        } while (buscarPorTelefono(telefono) != null);
        
        Contacto nuevo = new Contacto(nombre, telefono);
        
        añade(nuevo);
       
        System.out.println("Se ha dado de alta el registro");
            
           
    }
    
    public void eliminar(String nombre) throws SQLException{
      try{
         PreparedStatement consulta = con.prepareStatement("DELETE FROM " + this.nomTabla + " WHERE nombre = ?");
         consulta.setString(1, nombre);
         consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }

        
    
      
    public void baja()throws SQLException{
        
        String dato;
        Scanner entrada = new Scanner(System.in);
        String nombre, telefono;
        int pos;
        String respuesta;
        Contacto contacto = null;
        
        do{
            System.out.println("Dame el dato a dar de baja (nombre o teléfono):");
            dato = entrada.nextLine();
            if (!Contacto.esValidoNombre(dato) && !Contacto.esValidoTelefono(dato)){
                System.out.println("Error, el dato introducido no es nombre, ni telefono");
            }
           
        } while (!Contacto.esValidoNombre(dato) && !Contacto.esValidoTelefono(dato));
        
        
        if (Contacto.esValidoNombre(dato)){
            nombre = dato.toUpperCase();
            contacto = buscarPorNombre(nombre);
            if (contacto == null){
                System.out.println(nombre + " no esta en la agenda");
            } else{
                System.out.println(nombre + "\t" + contacto.getTelefono());
                // Se realiza la baja
                do{
                    System.out.println("¿Esta seguro de que quiere dar de baja dicho contacto(s/n)?");
                    respuesta = entrada.nextLine();
                    respuesta = respuesta.toUpperCase();
                    if (respuesta.charAt(0) != 'S' && respuesta.charAt(0) != 'N'){
                        System.out.println("Error, debe responder con S o N");
                    }
                } while (respuesta.charAt(0) != 'S' && respuesta.charAt(0) != 'N');
                
                if (respuesta.charAt(0) == 'S'){
                    eliminar(contacto.getNombre());
                    System.out.println("El contacto ha sido borrado");
                }
            }
        } else{  // Es un telefono valido
            telefono = dato;
            contacto = buscarPorTelefono(telefono);
             if (contacto == null){
                System.out.println(telefono + " no esta en la agenda");
            } else{
                System.out.println(contacto.getNombre() + "\t" + telefono);
                do{
                    System.out.println("¿Esta seguro de que quiere dar de baja dicho contacto(s/n)?");
                    respuesta = entrada.nextLine();
                    respuesta = respuesta.toUpperCase();
                    if (respuesta.charAt(0) != 'S' && respuesta.charAt(0) != 'N'){
                        System.out.println("Error, debe responder con S o N");
                    }
                } while (respuesta.charAt(0) != 'S' && respuesta.charAt(0) != 'N');
                
                if (respuesta.charAt(0) == 'S'){
                    eliminar(contacto.getNombre());
                    System.out.println("El contacto ha sido borrado");
                }
            }
        }
            
    }
    
    public void modificaTelefono(Contacto contacto) throws SQLException{
      try{
        PreparedStatement consulta;
        consulta = con.prepareStatement("UPDATE " + this.nomTabla + " SET telefono = ? WHERE nombre = ?");
        consulta.setString(1, contacto.getTelefono());
        consulta.setString(2, contacto.getNombre());
        consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
    
    
   public void modificaNombre(Contacto contacto) throws SQLException{
      try{
        PreparedStatement consulta;
        consulta = con.prepareStatement("UPDATE " + this.nomTabla + " SET nombre = ? WHERE telefono = ?");
        consulta.setString(1, contacto.getNombre());
        consulta.setString(2, contacto.getTelefono());
        consulta.executeUpdate();
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
   }
    
    
    public void modificacion()throws SQLException{
        String dato;
        Scanner entrada = new Scanner(System.in);
        String nombre, telefono;
       
        Contacto contacto = null;
        Contacto contacto1 = null;
        Contacto contactoMod = null;
        
        do{
            System.out.println("Dame el dato a modificar (nombre o teléfono):");
            dato = entrada.nextLine();
            if (!Contacto.esValidoNombre(dato) && !Contacto.esValidoTelefono(dato)){
                System.out.println("Error, el dato introducido no es nombre, ni telefono");
            }
           
        } while (!Contacto.esValidoNombre(dato) && !Contacto.esValidoTelefono(dato));
        
        if (Contacto.esValidoNombre(dato)){
            nombre = dato.toUpperCase();
            contacto = buscarPorNombre(nombre);
            if (contacto == null){
                System.out.println(nombre + " no esta en la agenda");
            } else{
                System.out.println(nombre + "\t" + contacto.getTelefono());
                
                do{
                    System.out.println("Dame el nuevo telefono(intro=sin modificar):");
                    telefono = entrada.nextLine();
                
                    if (telefono.length() != 0) {
                                //Significa que ha introducido información
                                if (!Contacto.esValidoTelefono(telefono)){
                                    System.out.println("Error, el telefono introducido es incorrecto");
                                    contacto1 = null;
                                } else{
                                    contacto1 = buscarPorTelefono(telefono);
                                    if (contacto1 == null){  //No esta duplicado
                                        contactoMod = new Contacto(nombre, telefono);
                                        modificaTelefono(contactoMod);
                                    } else if (contacto1 != contacto){
                                        System.out.println("Error, este telefono esta duplicado en la agenda");
                                    }
                                }
                    }
                } while (telefono.length() != 0 && (!Contacto.esValidoTelefono(telefono) || contacto1 != null));
            }
        } else{  // Es un telefono valido
            telefono = dato;
            contacto = buscarPorTelefono(telefono);
             if (contacto == null){
                System.out.println(telefono + " no esta en la agenda");
            } else{
                System.out.println(contacto.getNombre() + "\t" + telefono);
                do{
                    System.out.println("Dame el nuevo nombre(intro=sin modificar):");
                    nombre = entrada.nextLine();
                
                    if (nombre.length() != 0) {
                                //Significa que ha introducido información
                                if (!Contacto.esValidoNombre(nombre)){
                                    System.out.println("Error, el nombre introducido es incorrecto");
                                    contacto1 = null;
                                } else{
                                    contacto1 = buscarPorNombre(nombre);
                                    if (contacto1 == null){  //No esta duplicado
                                        contactoMod = new Contacto(nombre, telefono);
                                        modificaNombre(contactoMod);
                                    } else if (contacto1 != contacto){
                                        System.out.println("Error, este nombre esta duplicado en la agenda");
                                    }
                                }
                    }
                } while (nombre.length() != 0 && (!Contacto.esValidoNombre(nombre) || contacto1 != null));
                
            }
        }
            
    }
    
    
     public ArrayList <Contacto> recuperarTodas() throws SQLException{
      ArrayList <Contacto> arrayListContactos= new ArrayList();
      try{
         PreparedStatement consulta = con.prepareStatement("SELECT nombre, telefono FROM " + this.nomTabla + " ORDER BY nombre");
         ResultSet resultado = consulta.executeQuery();
         
         while(resultado.next()){
            arrayListContactos.add(new Contacto(resultado.getString("nombre"), resultado.getString("telefono")));
         }
      }catch(SQLException ex){
         throw new SQLException(ex);
      }
      return arrayListContactos;
   }
    
    
    public String listado() throws SQLException{
        
        boolean hayAlgunContacto = false;
        String cad= "";
        cad += "Listado de la Agenda Telefónica \n";
        cad += "----------------------------------------- \n";
        
        ArrayList <Contacto> tabla = recuperarTodas();
        
        for (int i = 0; i < tabla.size(); ++i){
           
                cad += (tabla.get(i).getNombre() + "\t" + tabla.get(i).getTelefono() + "\n");
                cad += "----------------------------------------- \n";
                hayAlgunContacto = true;
            
        }
        
        if (!hayAlgunContacto){
            System.out.println("Agenda está vacía");
        }
        return cad;
    }
    
}
