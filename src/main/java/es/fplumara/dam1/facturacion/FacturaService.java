package es.fplumara.dam1.facturacion;

public class FacturaService {

    private final Calculadora calc;

    public FacturaService(Calculadora calc) {
        this.calc = calc;
    }

    public int totalConIva(int base) {
        return calc.sumar(base, 21);
    }
}
