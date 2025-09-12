import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        // Aquí defines las rutas fijas para tus pruebas
        String directorioBase = "/home/dam/Documentos/AD/P1-1 Ficheiros/src";
        String directorioBorrar = "/home/dam/Documentos/AD/P1-1 Ficheiros/src/NuevoDir";
        String archivoBase = "ArchivoCreadoPorCódigo";

        do {
            System.out.println("--- MENÚ DE OPERACIONES DE ARCHIVOS ---");
            System.out.println("Ruta de prueba: " + directorioBase);
            System.out.println("Archivo de prueba: " + archivoBase);
            System.out.println("------------------------------------");
            System.out.println("1.  Comprobar si es un directorio");
            System.out.println("2.  Comprobar si es un archivo");
            System.out.println("3.  Crear directorio");
            System.out.println("4.  Crear archivo");
            System.out.println("5.  Mostrar modo de acceso (lectura/escritura)");
            System.out.println("6.  Calcular tamaño en bytes");
            System.out.println("7.  Establecer modo de solo lectura");
            System.out.println("8.  Establecer modo de escritura");
            System.out.println("9.  Borrar archivo");
            System.out.println("10. Borrar directorio");
            System.out.println("0.  Salir");
            System.out.print("Elige una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    if (eDirectorio(directorioBase)) {
                        System.out.println("¡Es un directorio!");
                    } else {
                        System.out.println("No es un directorio.");
                    }
                    break;
                case 2:
                    File archivoCompleto = new File(directorioBase, archivoBase);
                    if (eFicheiro(archivoCompleto.getAbsolutePath())) {
                        System.out.println("¡Es un archivo!");
                    } else {
                        System.out.println("No es un archivo.");
                    }
                    break;
                case 3:
                    creaDirectorio(directorioBase + "/NuevoDir");
                    break;
                case 4:
                    creaFicheiro(directorioBase, archivoBase);
                    break;
                case 5:
                    modoAcceso(directorioBase, archivoBase);
                    break;
                case 6:
                    calculaLonxitude(directorioBase, archivoBase);
                    break;
                case 7:
                    mLectura(directorioBase, archivoBase);
                    break;
                case 8:
                    mEscritura(directorioBase, archivoBase);
                    break;
                case 9:
                    borraFicheiro(directorioBase, archivoBase);
                    break;
                case 10:
                    borrarDirectorio(directorioBorrar);
                    break;
                case 0:
                    System.out.println("cerrando");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
            System.out.println(); // Línea en blanco para mejor formato
        } while (opcion != 0);

        teclado.close();
    }


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
        }else{
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
    public static void mLectura(String dirName, String fileName){
        File archivo = new File(dirName,fileName);
        boolean correcto = archivo.setReadOnly();
        if(correcto){
            System.out.println("El directorio se puede leer");
        }else{
            System.out.println("Error, creo que esto no va bien ");
        }
    }
    public static boolean mEscritura(String dirName, String fileName) throws IOException {
        File archivo = new File(dirName,fileName);
        boolean permiso = archivo.setWritable(true);
        return permiso;

    }
    public static void borraFicheiro(String dirName, String fileName) throws IOException {
        File archivo = new File(dirName,fileName);{
            System.out.println("Nombre del archivo: " + fileName);
            boolean borrar = archivo.delete();
            if(borrar){
                System.out.println("borrado");
            }else{
                System.out.println("No se ha borrado");
            }
        }
    }
    public static void borrarDirectorio(String dirName){
        File archivo = new File(dirName);
        System.out.println("Nombre directorio:"+dirName);
        boolean borrarDir = archivo.delete();
        if (borrarDir){
            System.out.println("Borrado");
        }else{
            System.out.println("No borrado");
        }
    }

}//end class