import java.io.File;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        //eDirectorio("/home/dam/Documentos/AD");
        //eFicheiro("/home/dam/Documentos/AD");
        //creaDirectorio("/home/dam/Documentos/AD/P1-1");
        //creaFicheiro("C:\\Users\\olimi\\Desktop\\2ºDam\\AD","ArchivoCreadoPorCódigo");
        //modoAcceso("C:\\Users\\olimi\\Desktop\\2ºDam\\AD","SePuedeLeerOEscribir");
        //calculaLonxitude("C:\\Users\\olimi\\Desktop\\2ºDam\\AD","OtroArchivo");
         mLectura("C:\\Users\\olimi\\Desktop\\2ºDam\\AD","ArchivoCreadoPorCódigo");
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
    public static void creaFicheiro(String dirName, String fileName) throws IOException {
        File archivo = new File(dirName,fileName);
        if(archivo.createNewFile()){
            System.out.println("Archivo creado correctamente en el directorio");
        }else{
            System.out.println("Problemas con la creación del archivo");
        }

    }
    public static void modoAcceso(String dirName, String fileName) throws IOException {
        File directorio = new File(dirName,fileName);
        if(directorio.createNewFile()){
            if(directorio.canRead()){
                System.out.println("Se puede leer");
            }else{
                System.out.println("No puede leer");
            }
            if(directorio.canWrite()){
                System.out.println("Se puede escribir");
            }else{
                System.out.println("No se puede escribir");
            }
        }
    }
    public static void calculaLonxitude(String dirName, String fileName){
        long longitudBytes = 0;
        File directorio = new File(dirName,fileName);
        longitudBytes =  directorio.length();
        System.out.println("Total de bytes:"+ longitudBytes);
    }

    //7) método mLectura (dirName, fileName)
    //Dada a ruta absoluta e nome dun arquivo, este método debe facer o arquivo de so
    //lectura.

    public static void mLectura(String dirName, String fileName){
        File archivo = new File(dirName,fileName);
        boolean correcto = archivo.setReadOnly();
        if(correcto){
            System.out.println("El directorio se puede leer");
        }else{
            System.out.println("Error, creo que esto no va bien ");
        }
    }


}//end class