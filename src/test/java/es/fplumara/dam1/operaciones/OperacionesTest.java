package es.fplumara.dam1.operaciones;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperacionesTest {

    @ParameterizedTest
    @CsvSource({
            "0.0, INSUFICIENTE",
            "4.99, INSUFICIENTE",
            "4.99, INSUFICIENTE",
            "5.0, APROBADO",
            "6.99, APROBADO",
            "7.0, NOTABLE",
            "8.99, NOTABLE",
            "9.0, SOBRESALIENTE",
            "10.0, SOBRESALIENTE"
    })

    @DisplayName("Comprueba las notas")
    public void clasificacionNotasValidas(double nota, String resultadoEsperado) {
        String resultado = Operaciones.calificacion(nota);
        assertEquals(resultadoEsperado,resultado);
    }

    @Test
    @DisplayName("fallos con -0.01 y 10.01")

    void fueradeRango() {

        assertThrows(IllegalArgumentException.class, () -> Operaciones.calificacion(-0.01));
        assertThrows(IllegalArgumentException.class, () -> Operaciones.calificacion(10.01));
    }


}


