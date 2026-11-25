/**
 * Subclase para pagos con tarjeta de crédito o débito.
 * Expone getters propios para auditoría mediante instanceof y downcasting.
 */
public class PagoTarjeta extends MetodoPago {
    private String ultimosCuatroDigitos;
    private String franquicia;

    public PagoTarjeta(String referencia, String titular, double montoBase, String ultimosCuatroDigitos, String franquicia) {
        super(referencia, titular, montoBase);
        if (ultimosCuatroDigitos == null || ultimosCuatroDigitos.trim().length() != 4) {
            throw new IllegalArgumentException("Debe indicar exactamente los últimos 4 dígitos de la tarjeta.");
        }
        this.ultimosCuatroDigitos = ultimosCuatroDigitos.trim();
        this.franquicia = (franquicia == null || franquicia.trim().isEmpty()) ? "Tarjeta" : franquicia.trim();
    }

    public String getUltimosCuatroDigitos() {
        return ultimosCuatroDigitos;
    }

    public String getFranquicia() {
        return franquicia;
    }

    @Override
    public double calcularComision() {
        return montoBase * 0.035;
    }

    @Override
    public String procesarPago() {
        return "Autorizando " + franquicia + " ****" + ultimosCuatroDigitos
                + " [" + referencia + "] por $" + String.format("%.2f", calcularTotal());
    }

    @Override
    public String mostrarComprobante() {
        return super.mostrarComprobante()
                + " | Canal: " + franquicia + " ****" + ultimosCuatroDigitos;
    }

    @Override
    public String toString() {
        return super.toString() + " [" + franquicia + " ****" + ultimosCuatroDigitos + "]";
    }
}
