package curso.web;

import java.util.ArrayList;
import java.util.Scanner;

import curso.web.datos.LeerDatos;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> listadoProvincias = LeerDatos.obtenerProvincias();
			
		int contador = 1;
		for (String provincia : listadoProvincias) {
			System.out.println(contador + ". " + provincia);
			contador++;
		}
		System.out.print("Introduce la provincia a mostrar: ");
		int opcion = sc.nextInt();
		
		String provincia = listadoProvincias.get(opcion-1);
		
		//String codigo = LeerDatos.getListadoProvinciasOrdenado().get(provincia);
		//System.out.println(codigo);
		
		ArrayList<String> listadoMunicipios = LeerDatos.obtenerMunicipiosXProvincia(provincia);
		for (String municipio : listadoMunicipios) {
			System.out.println(municipio);
		}
	}

}
