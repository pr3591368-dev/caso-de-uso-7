package vista;
import Modelo.Curso;
import javax.swing.*;
import java.awt.*;
public class InscripcionView extends JFrame {
    public DefaultListModel<Curso> modeloDisponibles = new DefaultListModel<>();
    public DefaultListModel<Curso> modeloInscritos = new DefaultListModel<>();
    public JList<Curso> listaDisponibles = new JList<>(modeloDisponibles);
    public JList<Curso> listaInscritos = new JList<>(modeloInscritos);
    public JButton btnInscribir = new JButton("Inscribir Curso ->");
    public JButton btnFinalizar = new JButton("Finalizar Inscripción");
    public JLabel lblMontoTotal = new JLabel("Monto a Pagar: $0.00", SwingConstants.RIGHT);
    public InscripcionView() {
        setTitle("Sistema de Inscripción de Clases (MVC)");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.setBorder(BorderFactory.createTitledBorder("Cursos Disponibles"));
        panelIzquierdo.add(new JScrollPane(listaDisponibles), BorderLayout.CENTER);
        panelIzquierdo.add(btnInscribir, BorderLayout.SOUTH);
        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBorder(BorderFactory.createTitledBorder("Cursos Inscritos"));
        panelDerecho.add(new JScrollPane(listaInscritos), BorderLayout.CENTER);
        JPanel panelInferiorDerecho = new JPanel(new GridLayout(2, 1, 5, 5));
        lblMontoTotal.setFont(new Font("Arial", Font.BOLD, 14));
        panelInferiorDerecho.add(lblMontoTotal);
        panelInferiorDerecho.add(btnFinalizar);
        panelDerecho.add(panelInferiorDerecho, BorderLayout.SOUTH);
        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 15, 0));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCentral.add(panelIzquierdo);
        panelCentral.add(panelDerecho);

        add(panelCentral, BorderLayout.CENTER);
    }
}