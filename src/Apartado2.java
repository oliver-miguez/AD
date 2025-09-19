import java.io.IOException;

public class Apartado2 {
    public static void main(String[] args) throws IOException {
        //Copia la imagen
        String ruta1 = "src/imagenOriginal.png";
        String ruta2 = "src/CopiaImagen.png";
        Apartado1.copiar(ruta1,ruta2); // a traves del apartado 1 hace lo mismo pero con imágenes
    }
}


/**
 * Respuesta a las preguntas del boletín:
 * 1- Si , pesan lo mismo las dos imagenes
 * 2-Si lo ejecutamos la primera vez solo creará una imagen con el mismo peso, pero si
 * ahora lo volvemos a ejecutar el peso será el doble
 */