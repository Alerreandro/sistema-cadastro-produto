package programa;

import javax.swing.SwingUtilities;
import gui.InterfaceGrafica;

public class Main {
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            new InterfaceGrafica().setVisible(true);
        });
    }
}
