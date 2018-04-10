/**
 * 
 */
package ArchivosCalle;

import Calle.Carro;
import Calle.Ciudad;
import Calle.Motocicleta;
import Calle.Vehículo;
import Calle.VehículoAutomotor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * @author amesegue
 *
 */
public class AdministradorArchivosJson implements AdministradorArchivos {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ArchivosCalle.AdministradorArchivos#cargarCiudad()
	 */
	@Override
	public Ciudad cargarCiudad(String rutaArchivo) {
		try {
			BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
			JsonReader lectorJson = new JsonReader(lector);
			Ciudad tmpCiudad;
			Gson gson = new Gson();
			tmpCiudad=gson.fromJson(lectorJson,null);
			//cerrar descriptores de archivos
			lectorJson.close();
			lector.close();
			//todo salió bien, devuelva la ciudad ya cargada
			return tmpCiudad;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Boolean guardarCiudad(String rutaArchivo, Ciudad ciudad) {
		try {
			
			BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaArchivo));
			JsonWriter escritorJson = new JsonWriter(escritor);
			
			RuntimeTypeAdapterFactory<Vehículo> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
				    .of(Vehículo.class, "type")
				    .registerSubtype(VehículoAutomotor.class, "vA")
				    .registerSubtype(Carro.class, "carro")
				    .registerSubtype(Motocicleta.class, "moto");
			
			Gson gson = new GsonBuilder().registerTypeAdapterFactory(runtimeTypeAdapterFactory).create();
			
			gson.toJson(ciudad, ciudad.getClass(), escritorJson);
			gson.toJson(ciudad, Ciudad.class, System.out);
			gson.toJson(ciudad, System.out);
			
			//cerrar descriptores de archivo
			//escritorJson.flush();
			escritorJson.close();
			//escritor.flush();
			escritor.close();
			
			//Todo salió bien, notificar éxito
			return true;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
		
	}

}
