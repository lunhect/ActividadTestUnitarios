package es.fplumara.dam1.facturacion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FacturaServiceTest {

    @Mock
    private Calculadora calc;  // mock objeto falso,

    @Test
    void totalConIva() {


        FacturaService facturaService = new FacturaService(calc);


        when(calc.sumar(100, 21)).thenReturn(121);

        // 3) Ejecutamos el método que queremos probar
        int resultado = facturaService.totalConIva(100);

        //compruebo
        assertEquals(121, resultado);


        verify(calc, times(1)).sumar(100, 21);


        verifyNoMoreInteractions(calc);
    }
    @Test
    void totalConIva0() {
        FacturaService facturaService = new FacturaService(calc);
        when(calc.sumar(0, 21)).thenReturn(21);

        int resultado = facturaService.totalConIva(0);

        assertEquals(21, resultado);


        verify(calc, times(1)).sumar(0, 21);
        verifyNoMoreInteractions(calc);
    }
}
