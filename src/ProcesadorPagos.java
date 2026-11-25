import java.util.ArrayList;
import java.util.List;

/**
 * Plantilla de taller: completa los métodos utilizando ligadura dinámica
 * y el operador instanceof para acceder a métodos propios de cada subclase.
 */
public class ProcesadorPagos {

    /**
     * TODO 1: Recorre la lista usando una referencia MetodoPago.
     * Imprime pago.procesarPago() y acumula calcularComision() y calcularTotal().
     */
    public void procesarLote(List<MetodoPago> pagos) {
        double totalComisiones = 0.0;
        double totalRecaudado = 0.0;

        // Implementa el ciclo polimórfico aquí

        System.out.println("Total comisiones del lote: $" + String.format("%.2f", totalComisiones));
        System.out.println("Total recaudado del lote: $" + String.format("%.2f", totalRecaudado));
    }

    /**
     * TODO 2: Usa instanceof (con pattern matching o casting explícito)
     * para auditar datos propios: calcularVuelto() en PagoEfectivo,
     * franquicia y últimos 4 dígitos en PagoTarjeta, banco en PagoTransferencia
     * y proveedor en PagoBilleteraDigital.
     */
    public void auditarCanalesEspecificos(List<MetodoPago> pagos) {
        double totalVueltosEfectivo = 0.0;
        int conteoTarjetas = 0;

        // Implementa la verificación segura con instanceof aquí

        System.out.println("Pagos con tarjeta auditados: " + conteoTarjetas);
        System.out.println("Total vueltos entregados en efectivo: $" + String.format("%.2f", totalVueltosEfectivo));
    }

    /**
     * TODO 3: Retorna una nueva lista con los pagos cuyo calcularTotal() >= minimo.
     */
    public List<MetodoPago> filtrarPorMontoMinimo(List<MetodoPago> pagos, double minimo) {
        List<MetodoPago> filtrados = new ArrayList<>();
        // Completa el filtro aquí
        return filtrados;
    }
}
