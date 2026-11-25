import java.util.ArrayList;
import java.util.List;

/**
 * Plantilla base para el taller en IDE de la Sesión 12 (POO).
 * Completa los pasos TODO en Main.java y ProcesadorPagos.java.
 */
public class Main {
    public static void main(String[] args) {
        List<MetodoPago> lote = new ArrayList<>();

        // TODO A: Agrega al menos un objeto de cada subclase a lote (Upcasting implícito):
        // PagoEfectivo, PagoTarjeta, PagoTransferencia y PagoBilleteraDigital

        ProcesadorPagos procesador = new ProcesadorPagos();

        // TODO B: Invoca procesador.procesarLote(lote) y procesador.auditarCanalesEspecificos(lote)

        // TODO C: Invoca procesador.filtrarPorMontoMinimo(lote, 100.00) e imprime cuántos pagos cumplen
        System.out.println("Plantilla Taller Colecciones Polimórficas lista (elementos actuales: " + lote.size() + ")");
    }
}
