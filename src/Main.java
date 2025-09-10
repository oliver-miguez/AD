import java.io.File;
public class Main{
    public static void main(String[] args) {
        eDirectorio("/home/dam/Documentos/AD");
        eFicheiro("/home/dam/Documentos/AD");
        creaDirectorio("/home/dam/Documentos/AD/P1-1");
    }//en static


    public static boolean eDirectorio(String cadea){
        File archivo = new File(cadea);
        if(archivo.isDirectory()){
            return true;
        }else{
            return false;
        }
    }
    public static boolean eFicheiro(String cadea){
        File archivo = new File(cadea);
        if(archivo.isFile()){
            return true;
        }else{
            return false;
        }

    }
    public static void creaDirectorio(String cadea){
        File archivo = new File(cadea);
        boolean creado = archivo.mkdir();
        if(creado){
            System.out.printf("Archivo creado");
        }else{
            System.out.println("No se ha creado");
        }
    }


    public static void creaFicheiro(String dirName, String fileName){
        File archivo = new File(dirName);

    }
}//end class