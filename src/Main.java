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

        String ruta = "";


        do {
            System.out.println("--- MENÚ DE OPERACIONES DE ARCHIVOS ---");
            System.out.print("Elige una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    //crea el fichero en una ruta especifica de nuestro dispositivo con ese nombre
                    creaDirectorio(directorioBase + "/ArquivosDir");
                    break;
                case 2:
                    //recoge la ruta de la carpeta creada anteriormente y crea el archivo en base a esa ruta y a ese nombre
                    ruta = creaDirectorio(directorioBase + "/ArquivosDir");
                    creaFicheiro(ruta,"Productos1");
                    break;
                case 3:
                    // 1º Recoge la ruta de la primera carpeta creada anteriormente
                    // 2º Con esa ruta crea una nueva carpeta dentro de la anterior
                    // 3º Recoge ahora la nueva ruta de la nueva carpeta y crea un nuevo fichero dentro de ella
                    ruta = creaDirectorio((directorioBase+"/ArquivosDir"));
                    creaDirectorio(ruta + "/Subdir");
                    String ruta2 = creaDirectorio(ruta+"/Subdir");
                    creaFicheiro(ruta2 , "Productos2");
                    break;
                case 4:
                    //Recoge la ruta de la carpeta y llama al metodo recur con esa ruta
                    ruta = creaDirectorio(directorioBase + "/ArquivosDir");
                    recur(ruta);
                    break;
                case 5:
                    ruta = creaDirectorio(directorioBase + "/ArquivosDir");
                    mLectura(ruta,"Productos1");
                    mEscritura(ruta, "Productos1");
                    calculaLonxitude(ruta, "Productos1");
                    break;
                case 6:
                    ruta = creaDirectorio(directorioBase + "/ArquivosDir");
                    mSoloLectura(ruta,"Productos1");
                    break;
                case 7:
                    ruta = creaDirectorio(directorioBase + "/ArquivosDir");
                    mSoloEscritura(ruta,"Productos1");
                    break;
                case 8:
                    ruta = creaDirectorio(directorioBase + "/ArquivosDir");
                    borrarDirectorio(ruta);
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
    public static String eFicheiro(String cadea){
        File archivo = new File(cadea);
        if(archivo.isFile()){
            return "Es un ficheiro";
        }else{
            return "No es un ficheiro";
        }

    }

    /**
     * 1º Creamos un objeto File que a traves del metodo mkdir utilizamos para crear el directorio
     * 2º Guardamos la ruta, util para próximos apartados
     * 3ªCon un Booleano verificamos si se ha creado o si no, los mostramos con un print() y a traves del eDirectorio(en el apartado 1)
     * verificamos si existe o si no
     * @param cadea Ruta de creación del Directorio
     * @return
     */
    public static String creaDirectorio(String cadea){
        File archivo = new File(cadea);
        boolean creado = archivo.mkdir();
        String ruta = archivo.getPath();
        if(creado){
            System.out.printf("Archivo creado");
            eDirectorio(ruta);
            return ruta;
        }else{
            System.out.println("El arquivo no se a creado porque ya existe");
            return ruta;
        }
    }

    /**
     * 1º Crea un objeto Fichero que recoge tanto la ruta en la que se quiere crear como el nombre que va a recibir
     * 2º En caso de que no exista , crea y verifica que si se ha creado ,es un archivo, utilizando el metodo isFile()
     * 3º Muestra el resultado
     * @param dirName ruta de la carpeta donde se quiere crear
     * @param fileName Nombre que recibirá el archivo
     * @throws IOException Excepción para que funcione
     */
    public static void creaFicheiro(String dirName, String fileName) throws IOException {
        File archivo = new File(dirName,fileName);
        if(archivo.createNewFile()){
            boolean fich = archivo.isFile();
            System.out.println("Fichero creado correctamente en el directorio");
            if(fich) {
                System.out.println("Es un fichero");
            }else{
                System.out.println("No es un fichero");
            }
        }else{
            System.out.println("No se ha creado fichero, ya existe");


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

    /**
     * Calcula el total de bytes que tiene el archivo a traves del metodo .length()
     * @param dirName ruta carpeta
     * @param fileName nombre archivo el cual se calculará el total de bytes
     */
    public static void calculaLonxitude(String dirName, String fileName){
        long longitudBytes = 0;
        File directorio = new File(dirName,fileName);
        longitudBytes =  directorio.length();
        System.out.println("Total de bytes:"+ longitudBytes);
    }

    /**
     * A traves del metodo setReadOnly() solo podremos leer el archivo y no modificarlo
     * @param dirName ruta de la carpeta
     * @param fileName nombre del archivo
     */
    public static void mLectura(String dirName, String fileName){
        File archivo = new File(dirName,fileName);
        boolean correcto = archivo.canRead();
        if(correcto){
            System.out.println("Ahora solo se puede leer");
        }else{
            System.out.println("Se puede leer");
        }
    }

    public static void mSoloLectura(String dirName, String fileName){
        File archivo = new File(dirName,fileName);
        boolean correcto = archivo.setReadOnly();
        if(correcto){
            System.out.println("Ahora solo se puede leer");
        }else{
            System.out.println("Se puede leer");
        }
    }

    /**
     * A traves del metodo canWrite permite comprobar si el archivo se puede leer
     * @param dirName ruta de la carpeta
     * @param fileName nombre del archivo
     * @throws IOException excepcion necesaria
     */
    public static void mEscritura(String dirName, String fileName) throws IOException {
        File archivo = new File(dirName,fileName);
        boolean permiso = archivo.canWrite();
        if(permiso) {
            System.out.println("Puede escribir");
        }else {
            System.out.println("No puede Escribir");
        }
    }

    /**
     * A traves del metodo setWritable permite escribir en el archivo
     * @param dirName ruta de la carpeta
     * @param fileName nombre del archivo
     */
    public static boolean mSoloEscritura(String dirName, String fileName) {
        File archivo = new File(dirName,fileName);
        boolean permiso = archivo.setWritable(true);
        System.out.println("Ahora se puede escribir");
        return  permiso;
    }

    /**
     * Permite borrar la carpeta seleccionada
     * @param dirName nombre carpeta
     */
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

    /**
     * 1º Crea un objeto File que recoge una ruta de una carpeta
     * 2º A traves del metodo .list() comprueba los archivos que contiene esa carpeta
     * @param dirName ruta del directorio
     */
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