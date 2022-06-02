package formacao.desenvolvedores.tecnologia.uno.projetodesoftwareorientadoaobjetos.conceitosintent.utils.app;

import android.content.Context;

public class UtilsApp {
    //Escopo de classe
    private int soma = 0;


    //Converter p/ tipos primitivos do Java
    public int convertToInt(double valorDouble){
        return (int) valorDouble;
    }

    /*public int convertToInt(Context context, String objstring) {
        try {
            return Integer.parseInt(objstring);
        }catch (NumberFormatException e){
            Toast.makeText(context, "Por favor 
    }*/

    public int convertToInt(byte valorByte){
        return (int) valorByte;
    }

    public static int convertToInt(short valorShort) {
        return (int) valorShort;

    }

    public int convertToInt(long valorLong) {
        return (int) valorLong;

    }






}
