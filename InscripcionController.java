package Controlador;

import Modelo.Curso;
import Modelo.InscripcionModel;
import vista.InscripcionView;

import javax.swing.*;
import java.awt.*;

public class InscripcionController {
    private final InscripcionModel model;
    private final InscripcionView view;

    public InscripcionController(InscripcionModel model, InscripcionView view) {
        this.model = model;
        this.view = view;

        actualizarVistasListas();
        
        this.view.btnInscribir.addActionListener(e -> inscribirCurso());
        this.view.btnFinalizar.addActionListener(e -> generarFichaPago());
    }

    private void actualizarVistasListas() {
        view.modeloDisponibles.clear();
        for (Curso c : model.getCursosDisponibles()) {
            view.modeloDisponibles.addElement(c);
        }

        view.modeloInscritos.clear();
        for (Curso c : model.getCursosInscritos()) {
            view.modeloInscritos.addElement(c);
        }

        view.lblMontoTotal.setText(String.format("Monto a Pagar: $%.2f", model.calcularTotal()));
    }

    private void inscribirCurso() {
        int index = view.listaDisponibles.getSelectedIndex();
        
        if (index != -1) {
            if (model.inscribirCurso(index)) {
                actualizarVistasListas();
            }
        } else {
            JOptionPane.showMessageDialog(view, 
                "Selecciona un curso de la lista de disponibles.", 
                "Atención", 
                JOptionPane.WARNING_MESSAGE);
        }
    }

    private void generarFichaPago() {
        if (model.getCursosInscritos().isEmpty()) {
            JOptionPane.showMessageDialog(view, 
                "No has inscrito ningún curso.", 
                "Atención", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder ficha = new StringBuilder();
        ficha.append("=========================================\n");
        ficha.append("              FICHA DE PAGO              \n");
        ficha.append("=========================================\n\n");
        ficha.append("Cursos Inscritos:\n");
        ficha.append("-----------------------------------------\n");

        for (Curso c : model.getCursosInscritos()) {
            ficha.append(String.format("- %-30s $%.2f\n", c.getNombre(), c.getCosto()));
        }

        ficha.append("-----------------------------------------\n");
        ficha.append(String.format("COSTO TOTAL:                   $%.2f\n", model.calcularTotal()));
        ficha.append("=========================================\n");

        JTextArea areaTexto = new JTextArea(ficha.toString());
        areaTexto.setFont(new Font("Monospaced", Font.PLAIN, 12));
        areaTexto.setEditable(false);

        JOptionPane.showMessageDialog(view, 
            new JScrollPane(areaTexto), 
            "Ficha de Pago Generada", 
            JOptionPane.PLAIN_MESSAGE);
    }
}