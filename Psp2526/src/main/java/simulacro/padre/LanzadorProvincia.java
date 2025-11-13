package simulacro.padre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LanzadorProvincia {
	private static final String directorioGenerarClasses = "src/main/java/";
	private final static String rutaSource = "src/main/java/";


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LanzadorProvincia po = new LanzadorProvincia();
		
		String [] provincias = {"Huelva", "Sevilla", "Córdoba", "Málaga", "Jaén", "Granada", "Almería", "Cádiz"};
		Process[] procesosPepe = po.lanzarProcesos(provincias); 
		po.esperarProcesos(procesosPepe);
		po.compilaClase("simulacro.hijo/Provincia.java");


		po.lanzarProcesosYMostrarTotales(provincias);

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
	
	public void lanzarProcesosYMostrarTotales(String[] provincias) {

	    int totalPedidos = 0;

	 

	    // Primero recorremos todas las provincias para calcular el total

	    for (String provincia : provincias) {

	        String[] comando = { "java", "-cp", "target/classes", "dam.simulacro.Hijo.Provincia", provincia };

	        ProcessBuilder pb = new ProcessBuilder(comando);



	        try {

	            Process proceso = pb.start();



	            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

	            

	            String linea;

	            String ultimaLinea = null;



	            // Leer TODA la salida del hijo (por si imprime más de una línea)

	            while ((linea = reader.readLine()) != null) {

	                ultimaLinea = linea.trim();

	            }

	            // Imprime solo 1 linea

	            //String linea = reader.readLine(); // El hijo imprime el número de pedidos

	            reader.close();



	            if (ultimaLinea != null && !ultimaLinea.isEmpty()) {

	            //Muestra cada provincia y su número

	            System.out.println(ultimaLinea); 



	            // sumamos solo el número final (sin mostrarlo aparte)

                String soloNumero = ultimaLinea.replaceAll("[^0-9]", "").trim();

                if (!soloNumero.isEmpty()) {

                    totalPedidos += Integer.parseInt(soloNumero);

                }

            } else {

                System.out.println(provincia + ": (sin datos)");

            }





	            proceso.waitFor();



	        } catch (IOException | InterruptedException e) {

	            e.printStackTrace();

	        }

	    }



	    // Mostrar el total  arriba

	    System.out.println("Nº total de Pedidos : " + totalPedidos);

	}



	public void compilaClase(String ruta) {

		// Compilar el archivo fuente y generar el .class en el directorio target

		String[] comando = { "javac", "-d", directorioGenerarClasses, rutaSource + ruta };

		ProcessBuilder pb = new ProcessBuilder(comando);

		try {

			pb.redirectErrorStream(true);

			pb.inheritIO();

			int exit = pb.start().waitFor();

			 if (exit != 0) {

	                System.err.println("Error compilando la clase Provincia");

	            }

		} catch (IOException e) {

			e.printStackTrace();

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

	}






	

}


