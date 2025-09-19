import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Apartado1 {
    public static void main(String[] args) throws IOException {
        //RUTAS
        String ruta1 = "src/texto1.txt";
        String ruta2 = "src/texto2.txt";

        copiar(ruta1,ruta2);

    }

    /**
     * Copia el texto del archivo 1 y lo pega en el archivo 2
     * @param ruta1 txt con texto a copiar
     * @param ruta2 donde se pegaré el texto
     * @throws IOException necesaria
     */
    public static void copiar(String ruta1, String ruta2) throws IOException {
        FileInputStream fis = new FileInputStream(ruta1);
        FileOutputStream fos = new FileOutputStream(ruta2,true); //si añadimos el true, no borrará los archivos del texto2

        byte[]b = new byte[fis.available()]; //devuelve un número estimado de bytes que puede leer
        int i = 0; //iterador
        //Mientras no sea -1
        while (true) {
            int bytes = fis.read(); //lee el archivo
            if (bytes == -1) { //si es uno cierra
                break;
            } else {//sino transforma en bytes el fis.read() y los guarda en un array
                byte bytes1 = (byte) bytes;
                b[i] = bytes1;
                i++; //para mover el indice del array

            }
        }
        fos.write(b); //escribe el texto guardado del primero documento en el segundo
        fos.close();
    }
}