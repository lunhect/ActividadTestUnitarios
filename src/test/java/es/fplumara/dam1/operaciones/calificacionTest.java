package es.fplumara.dam1.operaciones;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class calificacionTest {

@ParameterizedTest
@CsvSource({
        "0.0, INSUFICIENTE",
        "4.99, INSUFICIENTE",
        "5.0, APROBADO",
        "6.99, APROBADO",
        "7.0, NOTABLE",
        "8.99, NOTABLE",
        "9.0, SOBRESALIENTE",
        "10.0, SOBRESALIENTE",

})


@DisplayName("COMPRUEBA NOTAS VALIDAS")

public void clasificacionNotasValidas(double nota, String resultadoEsperado){

    String resultado = Operaciones.calificacion((nota));
    assertEquals(resultadoEsperado,resultado);

}

    @Test
    @DisplayName("Test que falla con -0.01")
    void testFallaConMenos001() {
        assertThrows(IllegalArgumentException.class, () -> {
            Operaciones.calificacion(-0.01);
        });
    }

    @Test
    @DisplayName("Test que falla con 10.01")
    void testFallaCon1001() {
        assertThrows(IllegalArgumentException.class, () -> {
            Operaciones.calificacion(10.01);
        });
    }


    @Test
    @DisplayName("Test que falla con 10.01")
    void testFallaCon001() {
        assertThrows(IllegalArgumentException.class, () -> {
            Operaciones.calificacion(0.01);
        });
    }









}







