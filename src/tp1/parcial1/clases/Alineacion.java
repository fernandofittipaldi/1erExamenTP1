package tp1.parcial1.clases;

public class Alineacion extends Servicio implements CotizablePorManoObra {

	static final double EXTRABALANCEO = 500;

	private int horas;
	private boolean balanceo;

	public Alineacion(String descripcion, double porcentajeGanancia, String patente, int horas, boolean balanceo) {
		super(descripcion, porcentajeGanancia, patente);
		this.horas = horas;
		this.balanceo = balanceo;
	}

	@Override
	public double calcularCostoHoras() {
		return this.horas * CotizablePorManoObra.COSTOHORA;
	}

	@Override
	public double calcularPrecioCosto() {
		return this.balanceo ? calcularCostoHoras() + EXTRABALANCEO : calcularCostoHoras();
	}

}
