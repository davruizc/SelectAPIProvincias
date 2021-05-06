package curso.web.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import curso.web.api.ClaseJson;

public class Leer {
	
	//TODO: pruebas
	public static void main(String[] args) {
		//String cadenaJson = fichero("c:\\provincias.json");
		
		String url_provincias = "https://raw.githubusercontent.com/IagoLast/pselect/master/data/provincias.json";
		String cadenaJson = url(url_provincias);
				
		ClaseJson[] listadoProvincias = new Gson().fromJson(cadenaJson, ClaseJson[].class);
		
        for (ClaseJson provincia : listadoProvincias) {
            System.out.println(provincia.getNm());
        }
	}
	
	public static String fichero(String fichero) {
		String output = "";
		
		try {
			FileReader f = new FileReader(fichero);
	
	        BufferedReader b = new BufferedReader(f);

	        String cadenaLeida;
	        while ((cadenaLeida = b.readLine()) != null) {
	        	output += cadenaLeida;
	        }
	        b.close();
	        
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return output;		
	}
	
	public static String url(String sUrl) {
		String output = "";
		
		try {
			URL url = new URL(sUrl);
	        
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        //conn.setRequestProperty("Accept", "application/json");
	        
	        if (conn.getResponseCode() != 200) {
	            //si la respuesta del servidor es distinta al codigo 200 lanzaremos una Exception
	            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
	        }
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	        
	        //creamos un StringBuilder para almacenar la respuesta del web service
	        StringBuilder sb = new StringBuilder();
	        int cp;
	        while ((cp = br.read()) != -1) {
	          sb.append((char) cp);
	        }
	        //en la cadena output almacenamos toda la respuesta del servidor
	        output = sb.toString();
	        //System.out.println(output);	        
        
	        conn.disconnect();
		} catch(Exception e) {
	        System.out.println(e.getMessage());
	    }
		
		return output;
	}
	
	//https://es.stackoverflow.com/questions/290349/como-reemplazar-caracteres-especiales-de-java-%C3%83
	public static String corregirNombre(String cadena) {
		/*
		//https://stackoverrun.com/es/q/474826
		cadena = cadena.replace("á", "�"); //�
		//cadena = cadena.replace("�?", "A"); //� TODO: no lo hace bien
		cadena = cadena.replace("é", "�"); //�
		cadena = cadena.replace("è", "�"); //�
		cadena = cadena.replace("í", "�"); //�
		cadena = cadena.replace("ó", "�"); //�
		cadena = cadena.replace("", ""); //�
		cadena = cadena.replace("ñ", "�");
		*/
		if(cadena.contains("vila"))
    		cadena = "Avila";
    	/*
		else if(cadena.contains("Araba"))
    		cadena = "Alava";
    	else if(cadena.equals("Castell�n/Castell�"))
    		cadena = "Castell�n";
    	else if(cadena.equals("Valencia/Val�ncia"))
    		cadena = "Valencia";
    	else if(cadena.equals("Alicante/Alacant"))
    		cadena = "Alicante";
    	*/    	
		return cadena;
	}
	
}
