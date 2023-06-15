package farmacia;

public class Medicamento implements Comparable <Medicamento>{
	protected int codigo;
	protected String nombre;
	protected String descripcion;
	protected double precio;
	protected String posologia;

	public Medicamento() {
		super();
	}

	public Medicamento(int codigo) {
		super();
		this.codigo = codigo;
	}

	public Medicamento(int codigo, String nombre, String descripcion, double precio, String posologia) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.posologia = posologia;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}
	
	public boolean equals (Object o) {
		boolean iguales=false;
		Medicamento m = (Medicamento) o;
		if (this.codigo==m.codigo) {
			iguales=true;
		}
		
		return iguales;
	}
	
	@Override
	public int compareTo(Medicamento o) {
		int resultado=0;
		resultado = this.codigo-o.codigo;
		return resultado;
	}
	
	public String toString () {
		String resultado="";
		resultado = "Código: " + codigo
				+ "\n" + "Nombre: " + nombre
				+ "\n" + "Descripión: " + descripcion
				+ "\n" + "Precio: " + precio
				+ "\n" + "Posología: " + posologia;
		
		return resultado;
	}


}
