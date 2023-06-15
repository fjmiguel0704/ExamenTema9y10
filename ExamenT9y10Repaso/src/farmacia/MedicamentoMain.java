package farmacia;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class MedicamentoMain {
	static TreeSet<Medicamento> listaMedicamentos = new TreeSet<Medicamento>();
	static private int codigo;
	static private String nombre;
	static private String descripcion;
	static private double precio;
	static private String posologia;
	static private int opcion;
	static Scanner read = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Bienvenidos al sistema");
		leerFichero();

		do {
			menu();
			opcion = read.nextInt();
			read.nextLine();

			switch (opcion) {
			case 1:
				añadirMedicamento();
				break;
			case 2:
				listarMedicamentos();
				break;
			case 3:
				eliminarMedicamento();
				break;
			case 4:
				guardarFichero();
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción incorrecta");
			}
		} while (opcion != 0);

	}

	public static TreeSet<Medicamento> leerFichero() {
		try {
			Medicamento m = null;
			String linea = "";
			String med[];
			Scanner sc = new Scanner(new FileReader("src\\farmacia\\medicamentos.txt"));
			while (sc.hasNextLine()) {
				linea = sc.nextLine();
				med = linea.split(";");
				m = new Medicamento(Integer.parseInt(med[0]), med[1], med[2], Double.parseDouble(med[3]), med[4]);
				listaMedicamentos.add(m);
			}
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo");
			System.out.println(e.getMessage());
		}

		return listaMedicamentos;
	}

	public static void guardarFichero() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("src\\farmacia\\medicamentos.txt"));
			for (Medicamento medicamentos : listaMedicamentos) {
				bw.write(medicamentos.getCodigo() + ";" + medicamentos.getNombre() + ";" + medicamentos.getDescripcion()
						+ ";" + medicamentos.getPrecio() + ";" + medicamentos.getPosologia());
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			System.out.println("No se ha podido crear el fichero");
			System.out.println(e.getMessage());
		}
	}

	public static void eliminarMedicamento() {
		System.out.println("Código del medicamento a eliminar: ");
		codigo = read.nextInt();
		read.nextLine();
		Medicamento m = new Medicamento(codigo);
		if (listaMedicamentos.remove(m)) {
			System.out.println("Medicamento eliminado correctamente");
		} else {
			System.out.println("No existe el medicamento que desea eliminar");
		}
	}

	public static void listarMedicamentos() {
		for (Medicamento valores : listaMedicamentos) {
			System.out.println(valores);
			System.out.println("========================");
		}
	}

	public static void añadirMedicamento() {
		System.out.println("Código del medicamento nuevo: ");
		codigo = read.nextInt();
		read.nextLine();
		Medicamento med = new Medicamento(codigo);
		if (listaMedicamentos.contains(med)) {
			System.out.println("Ya existe este medicamento");
		} else {
			System.out.println("Nombre del medicamento: ");
			nombre = read.next();
			read.nextLine();
			System.out.println("Descripción del medicamento: ");
			descripcion = read.nextLine();
			System.out.println("Precio: ");
			precio = read.nextDouble();
			read.nextLine();
			System.out.println("Posología del medicamento: ");
			posologia = read.nextLine();
			Medicamento m = new Medicamento(codigo, nombre, descripcion, precio, posologia);
			listaMedicamentos.add(m);
			System.out.println("Producto añadido correctamente");
		}
	}

	public static void menu() {
		System.out.println();
		System.out.println("1. Añadir elemento");
		System.out.println("2. Listar medicamentos");
		System.out.println("3. Eliminar medicamento");
		System.out.println("4. Guardar medicamentos");
		System.out.println("0. Salir");
		System.out.println();
		System.out.println("Seleccione una opción: ");
	}

}
