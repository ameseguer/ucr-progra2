/**
 * 
 */
package ArchivosCalle;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import Calle.Ciudad;
import Calle.Vehículo;

/**
 * @author amesegue
 *
 *  Esta clase no se usa. Es solo una muestra de como 'sacar' la serialización del objeto
 */ 
public class CiudadSerializer implements JsonSerializer<Ciudad> {

	@Override
	public JsonElement serialize(final Ciudad ciudadFuente, final Type type, JsonSerializationContext context) {
		final JsonObject jsonObject = new JsonObject();

		Gson gson = new GsonBuilder().create();

		final JsonArray jsonVehículossArray = new JsonArray();
		for (final Vehículo vehículo : ciudadFuente.getListaVehículos()) {

			jsonVehículossArray.add(gson.toJson(vehículo));
			
		}
		jsonObject.add("vehiculos", jsonVehículossArray);

		return jsonObject;
	}
}