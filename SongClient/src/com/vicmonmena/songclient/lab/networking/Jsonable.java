/**
 * 
 */
package com.vicmonmena.songclient.lab.networking;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This interface allows to parse JSONObject to domain objects.
 * @author Vicente
 *
 */
public interface Jsonable {

	/**
	 * @return the identifier.
	 */
	public int getId();
	
	/**
	 * @param id - the new value of the identifier.
	 * @return
	 */
	public int setId(int id);
	
	/**
	 * Parse source to the object in the class which implement this method.
	 * @param source
	 * @throws JSONException
	 */
	public void parseFromJSON(JSONObject source) throws JSONException ;
	
}
