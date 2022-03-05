package tp1.parcial1.clases;

import java.util.ArrayList;

public class TallerMecanico {

	private ArrayList<Servicio> serviciosEfectuados;
	private String nombre;

	private static final String FORMATO_CANTIDADES = "Se efectuaron: %d cambios de aceite, %d encendido y %d alineacion\n";

	public TallerMecanico(String nombre) {
		this.nombre = nombre;
		this.serviciosEfectuados = new ArrayList<Servicio>();

	}

	public boolean agregarServicio(Servicio nuevoServicio) {
		boolean pudo = false;

		if (nuevoServicio != null) {
			pudo = this.serviciosEfectuados.add(nuevoServicio);
		}
		return pudo;
	}

	public void listarServicios() {
		int contAceite = 0;
		int contEncendido = 0;
		int contAlineacion = 0;
		double totalVentas = 0;

		for (Servicio servicio : serviciosEfectuados) {
			if (servicio instanceof CambioAceite) {
				contAceite++;
			} else if (servicio instanceof Encendido) {
				contEncendido++;
			} else if (servicio instanceof Alineacion) {
				contAlineacion++;
			}
			totalVentas += servicio.calcularPrecioVenta();
		}
		System.out.println("Taller " + this.nombre);
		System.out.printf(FORMATO_CANTIDADES, contAceite, contEncendido, contAlineacion);
		System.out.println("El importe total de ventas es de $ " + totalVentas);
	}
	
}
