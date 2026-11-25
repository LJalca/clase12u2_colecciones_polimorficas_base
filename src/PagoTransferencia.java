/**
 * Subclase para pagos mediante transferencia bancaria interbancaria.
 */
public class PagoTransferencia extends MetodoPago {
    private String bancoOrigen;
    private String numeroComprobante;

    public PagoTransferencia(String referencia, String titular, double montoBase, String bancoOrigen, String numeroComprobante) {
        super(referencia, titular, montoBase);
        if (bancoOrigen == null || bancoOrigen.trim().isEmpty()) {
            throw new IllegalArgumentException("El banco de origen es obligatorio.");
        }
        if (numeroComprobante == null || numeroComprobante.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de comprobante es obligatorio.");
        }
        this.bancoOrigen = bancoOrigen.trim();
        this.numeroComprobante = numeroComprobante.trim();
    }

    public String getBancoOrigen() {
        return bancoOrigen;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    @Override
    public double calcularComision() {
        return 0.50;
    }

    @Override
    public String procesarPago() {
        return "Transferencia validada (" + bancoOrigen + " #" + numeroComprobante
                + ") [" + referencia + "] por $" + String.format("%.2f", calcularTotal());
    }

    @Override
    public String mostrarComprobante() {
        return super.mostrarComprobante()
                + " | Banco: " + bancoOrigen + " (Comp: " + numeroComprobante + ")";
    }

    @Override
    public String toString() {
        return super.toString() + " [Transferencia " + bancoOrigen + "]";
    }
}
