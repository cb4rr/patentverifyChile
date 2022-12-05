package DigitoVerificador;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Pipe
 *
 *  Agregar
 *
 * 	static final String EXP_AUTO_VIEJO = "[A-Z]{2}[1-9]{1}[0-9]{3}";
 * 	static final String EXP_AUTO_NUEVO = "[BCDFGHJKLPRSTVWXYZ]{4}[0-9]{2}";
 *
 * 	static final String EXP_MOTO_VIEJA_5 = "[A-Z]{2}[0-9]{3}";
 * 	static final String EXP_MOTO_NUEVA_5 = "[BCDFGHJKLPRSTVWXYZ]{3}[0-9]{2}";
 *
 * 	static final String EXP_MOTO_VIEJA_6 = "[A-Z]{2}[0]{1}[0-9]{3}";
 * 	static final String EXP_MOTO_NUEVA_6 = "[BCDFGHJKLPRSTVWXYZ]{3}[0]{1}[0-9]{2}";
 *
 * 	static final String EXP_MOTO_VIEJA_CON_O = "[A-Z]{2}[O]{1}[0-9]{3}";
 * 	static final String EXP_MOTO_NUEVA_CON_O = "[BCDFGHJKLPRSTVWXYZ]{3}[O]{1}[0-9]{2}";
 *
 *
 */
public class Metodos
{    
    public static int digitoVerificador;
    public static String DVFinal;
    public static String PatenteFinal;
    public static String tipoVehiculo;

    public static void setTipoVehiculo(String tipo) {
       tipoVehiculo = tipo;
    }
    
    public Metodos(){
    digitoVerificador = 0;
    DVFinal = "";
    PatenteFinal = "";
    tipoVehiculo = "";
    }
    
    public static void getPatente(String patenteInterfaz) throws IOException {  
                String patente = patenteInterfaz;
                patente = patente.toUpperCase();
                tipoPatente(patente);
}
    
    public static void tipoPatente(String patente){
        String patenteString = patente;
        int tipoDigitoPatente;
                if(patente.matches("[B-HJ-LPR-TV-Z]{4}[0-9]{2}")){
                    try {
                        patente = autoNuevo(patente);
                        tipoDigitoPatente = calcularDigito(patente);
                        asignarAutoNuevoMoto(tipoDigitoPatente);
                        setPatenteFinal(patenteString+"-"+getDVFinal());
                        setTipoVehiculo("Patente Nueva");
                    } catch (IOException e) {
                        //
                    }
                }else if(patente.matches("[A-Z]{2}[0-9]{4}")){
                    try {
                        patente = autoViejo(patente);
                        tipoDigitoPatente = calcularDigito(patente);
                        asignarAutoViejo(tipoDigitoPatente);
                        setPatenteFinal(patenteString+"-"+getDVFinal());
                        setTipoVehiculo("Patente Antigua");
                    } catch (IOException e) {
                        //
                    }
                }else if(patente.matches("[B-HJ-LPR-TV-Z]{3}[0-9]{3}") || patente.matches("[B-HJ-LPR-TV-Z]{3}[0-9]{2}")){
                    try {
                        patente = motoNueva(patente);
                        tipoDigitoPatente = calcularDigito(patente);
                        asignarAutoNuevoMoto(tipoDigitoPatente);
                        setPatenteFinal(patenteString+"-"+getDVFinal());
                        setTipoVehiculo("Patente de Moto");
                    } catch (IOException e) {
                        //
                    }
        } else {
                    // Error message
                    showMessageDialog(null, "La patente ingresada no es valida","Error al ingresar patente", JOptionPane.ERROR_MESSAGE);
                    setDVFinal("");
                    setTipoVehiculo("");
                    setPatenteFinal("");
                }
    }
    
    public static void asignarAutoViejo(int tipoDigitoPatente){
        if(tipoDigitoPatente == 11){
            setDVFinal("0");
        }else if(tipoDigitoPatente == 10){
            setDVFinal("K");
        }else if(tipoDigitoPatente  < 10){
            setDVFinal(String.valueOf(tipoDigitoPatente));
        }
    }
     
    public static void asignarAutoNuevoMoto(int tipoDigitoPatente){
        if(tipoDigitoPatente == 0){
            setDVFinal("0");
        }else if(tipoDigitoPatente == 10){
            setDVFinal("K");
        }else if(tipoDigitoPatente  < 10){
            setDVFinal(String.valueOf(tipoDigitoPatente));
        }
    }
    
    
    public static void setDVFinal(String tipoDigitoPatente){
        DVFinal = tipoDigitoPatente;
    }
    
    public static String getDVFinal(){
        return DVFinal;
    }
    
    public static String autoViejo(String patente) throws IOException{
                
            ObjectMapper mapper = new ObjectMapper();  
            File fileObj = new File("C:\\Netbeans\\patentverifyChile\\src\\main\\java\\DigitoVerificador\\patenteDB.json");
                try {
                Map<String, Object> patenteDB = mapper.readValue(
                        fileObj, new TypeReference<>() {
                        });
                
                    String patente1 = patente.substring(0, 2);
                    
                    patente = ""+patenteDB.get(patente1) + patente.substring(2, 6);
                    
                   
                }  catch (Exception e) {
                    // Error
                }
        return patente;
    }
    
        public static String autoNuevo(String patente) throws IOException{
                
            ObjectMapper mapper = new ObjectMapper();  
            File fileObj = new File("C:\\Netbeans\\patentverifyChile\\src\\main\\java\\DigitoVerificador\\patenteDB.json");
                try {
                Map<String, Object> patenteDB = mapper.readValue(
                        fileObj, new TypeReference<>() {
                        });
                
                    String patente1 = patente.substring(0, 1);
                    String patente2 = patente.substring(1, 2);
                    String patente3 = patente.substring(2, 3);
                    String patente4 = patente.substring(3, 4);
                    
                    patente = ""+patenteDB.get(patente1)
                            +patenteDB.get(patente2) 
                            +patenteDB.get(patente3) 
                            +patenteDB.get(patente4) 
                            + patente.substring(4, 6);
                    
                   
                }  catch (Exception e) {
                    // Error
                }
        return patente;
    }
        
    public static String motoNueva(String patente) throws IOException{
                
            ObjectMapper mapper = new ObjectMapper();  
            File fileObj = new File("C:\\Netbeans\\patentverifyChile\\src\\main\\java\\DigitoVerificador\\patenteDB.json");
                try {
                Map<String, Object> patenteDB = mapper.readValue(
                        fileObj, new TypeReference<>() {
                        });
                
                    String patente1 = patente.substring(0, 1);
                    String patente2 = patente.substring(1, 2);
                    String patente3 = patente.substring(2, 3);
                    
                    String patenteMap = ""+patenteDB.get(patente1) 
                            +patenteDB.get(patente2) 
                            +patenteDB.get(patente3);
                    
                    
                            if(patente.length() == 5){
                                patente = patenteMap+"0"+patente.substring(3,5);
                            }else{
                                patente = patenteMap+patente.substring(3,6);
                            }
                    
                   
                }  catch (Exception e) {
                    // Error
                }
        return patente;
    }
      
    public static int calcularDigito(String patente) {
                
                int[] arrayMult = new int[patente.length()];
                int[] array7 = {2,7,6,5,4,3,2};
                int[] array6 = {7,6,5,4,3,2};
                
                    if(patente.length() == 7){
                    arrayMult = array7;
                    }else if(patente.length() == 6){
                    arrayMult = array6;
                    }
                
                    int totalSumaPatente = 0;
                    String[] numerosSeparados = patente.split("");
                    
                    int[] numerosPatente = new int[numerosSeparados.length];
                    
                    for (int i = 0; i < numerosSeparados.length; i++) {
                        numerosPatente[i] = Integer.parseInt(numerosSeparados[i]);
                    }
                    
                    for (int i = 0; i < numerosSeparados.length; i++){
                        numerosPatente[i] = numerosPatente[i] * arrayMult[i];
                        totalSumaPatente += numerosPatente[i];
                    }
                    
                    int modRun = totalSumaPatente % 11;

        return 11 - modRun;
    }

    public static void setPatenteFinal(String Patente) {
        PatenteFinal = Patente;
    }
    
    

}
