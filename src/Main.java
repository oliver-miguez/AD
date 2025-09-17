import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String ruta1 = "src/texto1.txt";
        String ruta2 = "src/texto2.txt";

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