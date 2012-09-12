package util;

/**
 *
 * @author Alberto Emmanuel Esquivel Vega
 * Clase de Utilidades
 */
public class Util {
    
    /**
     * metodo que transforma la cadena de texto en double , en caso de que no se pueda hacer la transformacion 
     * regresa un NaN(Not a Number)
     * @param numero
     * @return 
     */
    public static Double parseInt(String numero){
        try{
            return Double.parseDouble(numero);
        }
        catch(NumberFormatException num){
            return Double.NaN;
        }
    }
    
}
