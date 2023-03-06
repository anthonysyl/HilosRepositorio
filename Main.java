import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Crear la ventana de la interfaz
        JFrame frame = new JFrame("Reproductor de música");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear el botón de inicio
        JButton startButton = new JButton("Iniciar");
        startButton.addActionListener(e -> {
            // Crear los hilos
            for (int i = 0; i < 4; i++) {
                Thread thread = new Thread(new Worker(i));
                thread.start();
            }
        });

        // Agregar el botón a la ventana
        frame.add(startButton);
        frame.setVisible(true);
    }
}