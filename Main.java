package Controlador;
import Modelo.InscripcionModel;
import vista.InscripcionView;
import javax.swing.SwingUtilities;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InscripcionModel model = new InscripcionModel();
            InscripcionView view = new InscripcionView();
            new InscripcionController(model, view);
            view.setVisible(true);
        });
    }
}