import java.io.*;

public class Apartado2Eje3 {
    public static void main(String[] args) throws IOException {
        String ruta1 = "src/eje3.txt";
        String ruta2 = "src/copia_eje_3.txt";

        copiar(ruta1,ruta2);

    }

    /**
     * Crea un archivo con la info copiada UTILIZANDO EL BUFFERINPUT Y OUTPUT
     * @param ruta1 ruta de la que copia
     * @param ruta2 donde copia
     * @throws IOException
     */
    public static void copiar(String ruta1, String ruta2) throws IOException {
        FileInputStream fis = new FileInputStream(ruta1);
        FileOutputStream fos = new FileOutputStream(ruta2);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[]b = new byte[bis.available()]; //devuelve un número estimado de bytes que puede leer
        int i = 0; //iterador
        //Mientras no sea -1
        while (true) {
            int bytes = bis.read(); //lee el archivo
            if (bytes == -1) { //si es uno cierra
                break;
            } else {//sino transforma en bytes el fis.read() y los guarda en un array
                byte bytes1 = (byte) bytes;
                b[i] = bytes1;
                i++; //para mover el indice del array

            }
        }
        bos.write(b); //escribe el texto guardado del primero documento en el segundo
        bos.close();
    }
}