package es.fplumara.dam1.coche;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
 class CocheServiceTest {

    @InjectMocks
    private final CocheService service = new CocheService(null);

    @ParameterizedTest
    @ValueSource(strings = {"1234ABC", "0000ZZZ", "9876QWE"})
    void matriculasValidas(String matricula) {
        assertTrue(service.validaMatricula(matricula));
    }

    @ParameterizedTest
    @CsvSource({
            "123ABC",        // faltan dígitos
            "12345ABC",       // sobran dígitos
            "1234AB",          // faltan letras
            "1234A1C",          // contiene número en letras
            "1234-ABC",          // guion
            "'1234 ABC'",         // espacio (comillas para que CSV lo lea bien)
            "1234abc"              // minúsculas
    })
    void matriculasInvalidas(String matricula) {
        assertFalse(service.validaMatricula(matricula));
    }


}
