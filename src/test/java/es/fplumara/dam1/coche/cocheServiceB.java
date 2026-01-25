package es.fplumara.dam1.coche;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class cocheServiceB {

    @Mock
    private CocheRepository cocheRepository;

    @InjectMocks
    private CocheService service;

    @Test
    void comprarCoche_Matricula_Valida() {
        Coche coche = mock(Coche.class);
        when(coche.getMatricula()).thenReturn("1234ABC");

        service.comprarCoche(coche);

        verify(cocheRepository).save(coche);
    }

    @Test
    void comprarCoche_segundo() {
        Coche coche = mock(Coche.class);
        when(coche.getMatricula()).thenReturn("1234-ABC");

        assertThrows(IllegalArgumentException.class, () -> service.comprarCoche(coche));

        verifyNoInteractions(cocheRepository);
    }

    @Test
    void buscarCoche_tercero() {
        Coche cocheFake = mock(Coche.class);
        when(cocheRepository.findByMatricula("9999ZZZ")).thenReturn(cocheFake);

        Coche result = service.buscarCoche("9999ZZZ");

        assertSame(cocheFake, result);
        verify(cocheRepository).findByMatricula("9999ZZZ");
    }

    @Test
    void buscarCoche_cuarto() {
        assertThrows(IllegalArgumentException.class, () -> service.buscarCoche("12AA"));

        verifyNoInteractions(cocheRepository);
    }
}



