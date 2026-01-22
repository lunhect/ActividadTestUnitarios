package es.fplumara.dam1.operaciones;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
    void clasificacionNotasValidas(double nota, String resultadoEsperado) {
        String resultado = Operaciones.calificacion(nota); // llamo al método a probar con la nota
        assertEquals(resultadoEsperado, resultado);  // comprueba que el resultado real coincide con el esperado
    }

    @Test
    @DisplayName("fallos con -0.01 y 10.01")
    void fueradeRango() {

        assertThrows(IllegalArgumentException.class, () -> Operaciones.calificacion(-0.01)); // Verifica que -0.01 lanza excepción
        assertThrows(IllegalArgumentException.class, () -> Operaciones.calificacion(10.01));
    }


    static Stream<Arguments> posiblesCasos() {
        return Stream.of(
                Arguments.of(6.67,  new double[]{5.0, 7.0}),     //Hecho fallar aposta
                Arguments.of(10.0, new double[]{10.0}),         // 10
                Arguments.of(0.0,  new double[]{0.0, 0.0, 0.0}) // 0
        );
    }

    @ParameterizedTest
    @MethodSource("posiblesCasos")
    @DisplayName("posibles casos")
    void media(double esperado, double... notas) {
        assertEquals(esperado, Operaciones.media(notas), 0.0001);
    }



    /*  CON HELPER

    caso(6.0, 5.0, 7.0),
        caso(10.0, 10.0),
        caso(0.0, 0.0, 0.0, 0.0)

        */



    @Test
        @DisplayName("comprobar 3 medias distintas")
        void testmediasAssertall () {
            assertAll(     //assertAll ejecuta todo y revela cual falla, a dif de assertEquals que con uno.

                    () -> assertEquals(5.0, Operaciones.media(5, 5), 0.0001),
                    () -> assertEquals(10.0, Operaciones.media(10.0), 0.0001),
                    () -> assertEquals(6.67, Operaciones.media(8, 5.34), 0.0001)
            );


        }


//PENDIENTE  3.


    @Test
    @DisplayName("comprobaciónAssertThrows")
    void lanzamientoIllegal() {

        assertThrows(IllegalArgumentException.class, () -> Operaciones.media());
        assertThrows(IllegalArgumentException.class, () -> Operaciones.media((double[]) null));

    }




}


