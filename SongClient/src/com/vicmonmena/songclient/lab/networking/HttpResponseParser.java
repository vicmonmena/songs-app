/**
 * 
 */
package com.vicmonmena.songclient.lab.networking;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.vicmonmena.songclient.lab.domain.Song;

/**
 * @author Vicente
 *
 */
public class HttpResponseParser {

	/* Song JSON object
	{	"id":1,
		"duration":"3:36",
		"title":"Omen",
		"author":"The prodigy",
		"album":"Invaders Must Die"
	}
	*/
	
	/**
	 * @param source
	 * @return
	 * @throws JSONException
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 * @deprecated No consigo que funcione con tipos genericos.
	 */
	public static ArrayList parseJSON(String source, Class classType) 
		throws JSONException, InstantiationException, IllegalAccessException {
		ArrayList<Jsonable> items = null;
		try {
			JSONArray jsonArray = new JSONArray(source);
			int itemCount = jsonArray.length(); 
			items = new ArrayList<Jsonable>(itemCount);
			for (int i = 0; i < itemCount; i++) {
				Jsonable item = (Jsonable) classType.newInstance();
				item.parseFromJSON(jsonArray.getJSONObject(i));
				items.add(item);
			}
		} catch (JSONException e) {
			throw new JSONException("Exception parsing JSON to String");
		} catch (IllegalAccessException e) {
			throw new IllegalAccessException("Exception creating a new instance"
					+ "of " + classType);
		} catch (InstantiationException e) {
			throw new InstantiationException("Exception creating a new instance"
				+ "of " + classType);
		}
		return items;
	}
	
	/**
	 * @param source
	 * @return
	 * @throws JSONException
	 * @throws InstantiationException 
	 * @throws IllegalAccessException 
	 */
	public static ArrayList<Song> parseJSON(String source) 
		throws JSONException, InstantiationException, IllegalAccessException {
		ArrayList<Song> items = null;
		try {
			JSONArray jsonArray = new JSONArray(source);
			int itemCount = jsonArray.length(); 
			items = new ArrayList<Song>(itemCount);
			for (int i = 0; i < itemCount; i++) {
				items.add(new Song(jsonArray.getJSONObject(i)));
			}
		} catch (JSONException e) {
			throw new JSONException("Exception parsing JSON to String");
		}
		return items;
	}
}
