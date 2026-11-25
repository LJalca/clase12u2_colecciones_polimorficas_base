/**
 * Subclase para pagos mediante billetera digital.
 */
public class PagoBilleteraDigital extends MetodoPago {
    private String proveedor;
    private String aliasUsuario;

    public PagoBilleteraDigital(String referencia, String titular, double montoBase, String proveedor, String aliasUsuario) {
        super(referencia, titular, montoBase);
        if (proveedor == null || proveedor.trim().isEmpty()) {
            throw new IllegalArgumentException("El proveedor de billetera digital es obligatorio.");
        }
        if (aliasUsuario == null || aliasUsuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El alias o número vinculado es obligatorio.");
        }
        this.proveedor = proveedor.trim();
        this.aliasUsuario = aliasUsuario.trim();
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getAliasUsuario() {
        return aliasUsuario;
    }

    @Override
    public double calcularComision() {
        double comision = montoBase * 0.015;
        return Math.min(comision, 3.00);
    }

    @Override
    public String procesarPago() {
        return "Débito QR en " + proveedor + " (" + aliasUsuario + ") [" + referencia
                + "] por $" + String.format("%.2f", calcularTotal());
    }

    @Override
    public String mostrarComprobante() {
        return super.mostrarComprobante()
                + " | Billetera: " + proveedor + " (" + aliasUsuario + ")";
    }

    @Override
    public String toString() {
        return super.toString() + " [" + proveedor + "]";
    }
}
