import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListaEstudiante listaEstudiante = new ListaEstudiante();
        ListaCarrera listaCarrera = new ListaCarrera();

        imprimirReportesConTotales(listaEstudiante.getEstudiantes(), listaCarrera.getCarreras());
    }

    public static void imprimirReportesConTotales(List<Estudiante> estudiantes, List<Carrera> carreras) {
        // Calcular promedios de notas y edades por carrera
        for (Carrera carrera : carreras) {
            double sumPromedio = 0;
            double sumEdad = 0;
            int count = 0;

            for (Estudiante estudiante : estudiantes) {
                if (estudiante.carrera.equals(carrera.codigo)) {
                    sumPromedio += estudiante.promedio;
                    sumEdad += estudiante.edad;
                    count++;
                }
            }

            if (count > 0) {
                double promedioNotas = sumPromedio / count;
                double promedioEdad = sumEdad / count;
                System.out.println("Carrera: " + carrera.nombre);
                System.out.println("  Promedio de notas: " + promedioNotas);
                System.out.println("  Promedio de edad: " + promedioEdad);
                System.out.println("  Total de estudiantes: " + count);
                System.out.println();
            } else {
                System.out.println("Carrera: " + carrera.nombre);
                System.out.println("  No hay estudiantes en esta carrera.");
                System.out.println();
            }
        }
    }
}