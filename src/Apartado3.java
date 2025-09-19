import java.io.*;

public class Apartado3 {
    public static void main(String[] args) throws IOException {
        String ruta1 = "src/texto3.txt";
        String texto = "o tempo está xélido";

        FileInputStream fis = new FileInputStream(ruta1);
        DataInputStream dis = new DataInputStream(fis);
        FileOutputStream fos = new FileOutputStream(ruta1);
        DataOutputStream dos = new DataOutputStream(fos);

        int i = 0; //iterador
        int calculo =  0;
        //Muestra 3 veces el texto
        while (i < 3) {
            System.out.println("Copiando a cadea: "+ texto);
            dos.writeUTF(texto); //escribe el texto
            //calculo es la variable utilizada para calcular la diferencia de tamaño entre el texto y entre el dos.size()
            if(i == 0) {
                calculo = dos.size() - texto.length();
            }
            //Muestra el valor del tamaño del fichero
            System.out.println("Tamaño fichero: "+ dos.size());
            i++;
        }
        int tamañoFinal = dos.size(); //Tamaño final del archivo
        System.out.println("Tamaño final:"+tamañoFinal);

        int j = 0;//Iterador
        //Se ejecuta 3 veces para verificar cuantos bytes quedan
        while (j < 3){
            System.out.println("Quedan por leer: " + tamañoFinal + " bytes");
            String valor = dis.readUTF(); //Lee los bytes que tiene el primer texto
            int tamaño = valor.length(); //Transforma su valor en un int
            int valorQueFalta = tamañoFinal-tamaño-calculo; // Calculo para verificar lo bytes que quedan
            //calculo es la variable utilizada para calcular la diferencia de tamaño entre el texto y entre el dos.size()
            tamañoFinal = valorQueFalta;
            System.out.println("Quedan: "+ valorQueFalta);

            j++;
        }
    }


}

