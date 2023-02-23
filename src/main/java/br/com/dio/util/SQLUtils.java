package br.com.dio.util;

public class SQLUtils {

    public static String builderWhere(int appId, String typeUser){
        if(appId != 0){
            StringBuffer where = new StringBuffer();
            where.append(" WHERE vo.appId = " + appId );
            where.append(" AND vo.deletado=false ");
            return where.toString();
        }
        return " ";
    }
}
