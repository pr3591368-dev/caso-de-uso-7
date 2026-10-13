package Modelo;

import java.util.ArrayList;

public class InscripcionModel {
    private final ArrayList<Curso> cursosDisponibles = new ArrayList<>();
    private final ArrayList<Curso> cursosInscritos = new ArrayList<>();

    public InscripcionModel() {
        cargarCursosIniciales();
    }

    private void cargarCursosIniciales() {
        cursosDisponibles.add(new Curso(1, "Matemáticas ", 450.00));
        cursosDisponibles.add(new Curso(2, "Programación ", 500.00));
        cursosDisponibles.add(new Curso(3, "Bases de Datos", 475.00));
        cursosDisponibles.add(new Curso(4, "Diseño ", 530.00));
        cursosDisponibles.add(new Curso(5, "Inglés ", 1000.00));
    }

    public ArrayList<Curso> getCursosDisponibles() { 
        return cursosDisponibles; 
    }

    public ArrayList<Curso> getCursosInscritos() { 
        return cursosInscritos; 
    }

    public boolean inscribirCurso(int indice) {
        if (indice >= 0 && indice < cursosDisponibles.size()) {
            Curso curso = cursosDisponibles.remove(indice);
            cursosInscritos.add(curso);
            return true;
        }
        return false;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Curso c : cursosInscritos) {
            total += c.getCosto();
        }
        return total;
    }

    public boolean inscribirCurso(Curso seleccionado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}