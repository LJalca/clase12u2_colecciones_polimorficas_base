/**
 * Superclase base para el procesamiento polimórfico de pagos.
 * Define los atributos protegidos comunes y los métodos que cada subclase
 * redefinirá mediante @Override según su canal de pago.
 */
public class MetodoPago {
    protected String referencia;
    protected String titular;
    protected double montoBase;

    public MetodoPago(String referencia, String titular, double montoBase) {
        if (referencia == null || referencia.trim().isEmpty()) {
            throw new IllegalArgumentException("La referencia de pago no puede estar vacía.");
        }
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del titular es obligatorio.");
        }
        if (montoBase <= 0) {
            throw new IllegalArgumentException("El monto base debe ser mayor a cero.");
        }
        this.referencia = referencia.trim();
        this.titular = titular.trim();
        this.montoBase = montoBase;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getTitular() {
        return titular;
    }

    public double getMontoBase() {
        return montoBase;
    }

    public double calcularComision() {
        return 0.0;
    }

    public double calcularTotal() {
        return montoBase + calcularComision();
    }

    public String procesarPago() {
        return "Procesando pago genérico [" + referencia + "] por $" + String.format("%.2f", calcularTotal());
    }

    public String mostrarComprobante() {
        return "Ref: " + referencia + " | Titular: " + titular
                + " | Base: $" + String.format("%.2f", montoBase)
                + " | Comisión: $" + String.format("%.2f", calcularComision())
                + " | Total: $" + String.format("%.2f", calcularTotal());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + referencia + " - " + titular + " - $"
                + String.format("%.2f", calcularTotal()) + "]";
    }
}
