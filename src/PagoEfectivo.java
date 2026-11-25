/**
 * Subclase para pagos en efectivo en ventanilla o punto de venta.
 * Incluye el método propio calcularVuelto() accesible mediante downcasting seguro.
 */
public class PagoEfectivo extends MetodoPago {
    private double montoEntregado;

    public PagoEfectivo(String referencia, String titular, double montoBase, double montoEntregado) {
        super(referencia, titular, montoBase);
        if (montoEntregado < montoBase) {
            throw new IllegalArgumentException("El monto entregado en efectivo no cubre el valor base.");
        }
        this.montoEntregado = montoEntregado;
    }

    public double getMontoEntregado() {
        return montoEntregado;
    }

    public double calcularVuelto() {
        return montoEntregado - calcularTotal();
    }

    @Override
    public double calcularComision() {
        return 0.0;
    }

    @Override
    public String procesarPago() {
        return "Pago en Efectivo [" + referencia + "] confirmado. Vuelto: $"
                + String.format("%.2f", calcularVuelto());
    }

    @Override
    public String mostrarComprobante() {
        return super.mostrarComprobante()
                + " | Entregado: $" + String.format("%.2f", montoEntregado)
                + " | Vuelto: $" + String.format("%.2f", calcularVuelto());
    }

    @Override
    public String toString() {
        return super.toString() + " [Efectivo]";
    }
}
