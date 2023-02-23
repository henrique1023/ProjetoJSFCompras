package br.com.dio.util;

public class Cast {

    public static int toInteger(Object var){
        int aux = 0;
        if(var != null) {
            aux = Integer.parseInt(var.toString());
        }
        return aux;
    }

    public static double toDouble(Object var){
        double aux = 0;
        if(var != null) {
            aux = Double.parseDouble(var.toString());
        }
        return aux;
    }

    public static long toLong(Object var){
        long aux = 0;
        if(var != null) {
            aux = Long.parseLong(var.toString());
        }
        return aux;
    }
}
