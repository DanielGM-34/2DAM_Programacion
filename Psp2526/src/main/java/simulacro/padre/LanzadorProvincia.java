package simulacro.padre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import padres.LnazadorAnalisisTemperaturas;

public class LanzadorProvincia {
	private static final String directorioGenerarClasses = "src/main/java/";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LanzadorProvincia po = new LanzadorProvincia();
		
		String [] provincias = {"Huelva", "Sevilla", "Córdoba", "Málaga", "Jaén", "Granada", "Almería", "Cádiz"};
		Process[] procesosPepe = po.lanzarProcesos(provincias); 

	}
	public Process ejecutarClasePlantilla(String className, String classpath, String... args) {
		Process proceso = null;
		List<String> comando = new ArrayList<String>();
		comando.add("java"); 
		comando.add("-cp");
		comando.add(classpath);
		comando.add(className);
		comando.addAll(Arrays.asList(args));

		ProcessBuilder pb = new ProcessBuilder(comando);

		try {
			proceso = pb.start();
			int exitCode = proceso.waitFor();
			System.out.println("Código de salida: " + exitCode);

			if (exitCode != 0) {
				BufferedReader errorReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
				String lineaError;
				while ((lineaError = errorReader.readLine()) != null) {
					System.err.println("Error: " + lineaError);
				}
			} else {
				BufferedReader outputReader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
				String lineaSalida;
				while ((lineaSalida = outputReader.readLine()) != null) {
					System.out.println("Salida: " + lineaSalida);
				}
			}

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return proceso;
	}
	
	 
	
	public Process[] lanzarProcesos(String[] provincias) { 
	    Process[] procesos = new Process[provincias.length];
	    for (int i = 0; i < provincias.length; i++) {
	        procesos[i] = ejecutaProcesoProvincia(provincias[i]);
	    }
	    return procesos; 
	} 

	public Process ejecutaProcesoProvincia(String provincia) { 
	    Process proceso = null; 
	    String[] comando = {
	        "java", "-cp", directorioGenerarClasses,
	        "src\\main\\java\\simulacro\\hijo\\Provincia.java", 
	        provincia 
	    }; 

	    ProcessBuilder pb = new ProcessBuilder(comando);
	    try {
	        proceso = pb.start();

	        BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
	        String linea;
	        while ((linea = reader.readLine()) != null) {
	            System.out.println(provincia +" : "+ linea);
	        }

	        int exitCode = proceso.waitFor();
	        if (exitCode != 0) {
	            BufferedReader errorReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));
	            String errorLinea;
	            while ((errorLinea = errorReader.readLine()) != null) {
	                System.err.println("Error en hijo (" + provincia + "): " + errorLinea);
	            }
	        }

	    } catch (IOException | InterruptedException e) {
	        System.err.println("Error ejecutando proceso para provincia: " + provincia);
	        e.printStackTrace();
	    }

	    return proceso;
	}

	

	public int[] esperarProcesos(Process[] procesos) {
	    int[] salidas = new int[procesos.length];
	    for (int i = 0; i < procesos.length; i++) {
	        try {
	            salidas[i] = procesos[i].waitFor();
	        } catch (InterruptedException e) {
	            System.err.println("Error esperando proceso " + i);
	            e.printStackTrace();
	        }
	    }
	    return salidas;
	}

	
}
