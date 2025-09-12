import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        /** Modificar las rutas para que funcione correctamente*/
        // Aquí defines las rutas fijas para tus pruebas
        //Ruta Principal
        String directorioBase = "/home/dam/Documentos/AD/P1-1 Ficheiros/src";
        //Ruta utilizada para probrar el delete()
        String directorioBorrar = "/home/dam/Documentos/AD/P1-1 Ficheiros/src/NuevoDir";
        //Ruta para probar el contenido de los directorios / Tienes que crear una carpeta con sub carpetas y esas sub carpetas con más carpetas dentro
        String directorio11 = "/home/dam/Documentos/AD/P1-1 Ficheiros/src/Objetos para eje 11";
        //Nombre para el archivo general
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
            System.out.println("11. Contido dun directorio");
            System.out.println("12. Recur");
            System.out.println("0.  Salir");
            System.out.print("Elige una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {

                case 2:
                    File archivoCompleto = new File(directorioBase, archivoBase);
                    if (eFicheiro(archivoCompleto.getAbsolutePath())) {
                        System.out.println("¡Es un archivo!");
                    } else {
                        System.out.println("No es un archivo.");
                    }
                    break;
                case 3:
                    creaDirectorio(directorioBase + "/ArquivosDir");
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
                case 11:
                    mContido(directorio11);
                    break;
                case 12:
                    recur(directorio11);
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


    public static void eDirectorio(String cadea){
        File archivo = new File(cadea);
        if(archivo.isDirectory()){
            System.out.println("\n Es directorio");
        }else{
            System.out.println("\n No es directorio");
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
        String ruta = archivo.getPath();
        if(creado){
            System.out.printf("Archivo creado");
            eDirectorio(ruta);
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
    public static void mContido(String dirName){
        File archivo = new File(dirName);
        String[] contidoArchivo = archivo.list();
        for(int i = 0; i<contidoArchivo.length; i++){
            System.out.println(contidoArchivo[i]);
        }
    }
    /**
     * 1º La carpeta principal, accede a su contenido a través de .list() y imprime los nombre de archivos y carpetas que tiene dentro
     * 2º Recorremos todas las carpetas que estaban en la primera
     * 3º Vuelve a buscar una carpeta pero esta vez que tenga algún nombre de "c", c son todos los nombres de las carpetas que tenia almacenado la primera
     * 4º Verifica que sean carpetas
     * 5º Si son carpetas vuelve a ejecutar el metodo pero en este caso con una nueva ruta, la ruta de cada una de las carpetas que tenia la primera
     *  Y asi sucesivamente si estas carpetas tienen más carpetas dentro de ellas
     * @param File ruta de la carpeta inicial
     */
    public static void recur(String File){
        File archivo = new File(File);
        String[] contido = archivo.list();
        for(String c : contido){
            System.out.println(c);
            File archivo2 = new File(File,c);
            if(archivo2.isDirectory()){
                recur(archivo2.getPath());
            }
        }
    }

}//end class