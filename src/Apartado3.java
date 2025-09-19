import java.io.*;

public class Apartado3 {
    public static void main(String[] args) throws IOException {
        String ruta1 = "src/texto3.txt";
        String texto = "o tempo está xélido";

        FileInputStream fis = new FileInputStream(ruta1);
        DataInputStream dis = new DataInputStream(fis);
        FileOutputStream fos = new FileOutputStream(ruta1);
        DataOutputStream dos = new DataOutputStream(fos);
        int i = 0;
        int calculo =  0;
        while (i < 3) {
            System.out.println("Copiando a cadea: "+ texto);
            dos.writeUTF(texto);
            if(i == 0) {
                calculo = dos.size() - texto.length();
            }
            System.out.println("Tamaño original: ");
            System.out.println("Tamaño fichero: "+ dos.size());
            i++;
        }
        int tamañoFinal = dos.size();
        System.out.println("Tamaño final:"+tamañoFinal);
        int j = 0;
        while (j < 3){
            System.out.println("Quedan por leer: " + tamañoFinal + " bytes");
            String valor = dis.readUTF();
            int tamaño = valor.length();
            int valorQueFalta = tamañoFinal-tamaño-calculo;
            tamañoFinal = valorQueFalta;
            System.out.println("Quedan: "+ valorQueFalta);

            j++;
        }
    }


}

