import java.io.File;
import javax.sound.sampled.*;

public class Worker implements Runnable {
    private final int id;

    public Worker(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Hilo " + id + " iniciado");

        // Si es el último hilo, reproducir la canción
        if (id == 3) {
            try {
                // Obtener el archivo de la canción
                File file = new File("Musica/cancion.wav");

                // Crear un objeto AudioInputStream y reproducirlo
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();

                // Esperar a que termine la canción antes de finalizar el hilo
                while (clip.isOpen()) {
                    Thread.sleep(4000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Si no es el último hilo, simplemente esperar un tiempo aleatorio
            try {
                Thread.sleep((long) (Math.random() * 5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Hilo " + id + " finalizado");
    }
}
