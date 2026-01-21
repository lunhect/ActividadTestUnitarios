package es.fplumara.dam1.operaciones;

public class Operaciones {

    /**
     * Devuelve una calificación cualitativa según la nota (0..10).
     * - < 0 o > 10 -> excepción
     * - 0..4.99 -> "INSUFICIENTE"
     * - 5..6.99 -> "APROBADO"
     * - 7..8.99 -> "NOTABLE"
     * - 9..10 -> "SOBRESALIENTE"
     */
    public static String calificacion(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota fuera de rango");
        }
        if (nota < 5) return "INSUFICIENTE";
        if (nota < 7) return "APROBADO";
        if (nota < 9) return "NOTABLE";
        return "SOBRESALIENTE";
    }


    /**
     * Calcula la media. Si no hay notas, lanza excepción.
     */
    public static double media(double... notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("No hay notas");
        }
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.length;
    }


}
