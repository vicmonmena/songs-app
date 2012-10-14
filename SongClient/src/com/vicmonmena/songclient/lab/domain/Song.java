/**
 * 
 */
package com.vicmonmena.songclient.lab.domain;

import org.json.JSONException;
import org.json.JSONObject;

import com.vicmonmena.songclient.lab.networking.Jsonable;

/**
 * @author Vicente Montaño Mena.
 *
 */
public class Song implements Jsonable {

	/**
	 * Song identifier.
	 */
	private String title;
	
	/**
	 * Song author.
	 */
	private String author;
	
	/**
	 * Song album.
	 */
	private String album;
	
	/**
	 * Song duration.
	 */
	private String duration;
	
	/**
	 * Create an instance of this class.
	 */
	public Song() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create a new instance of this class initialized.
	 * @param id - song identifier.
	 * @param title - song title.
	 * @param author - song author.
	 * @param album - song album.
	 * @param duration - song duration.
	 */
	public Song(int id, String title, String author, String album, String duration) {
		super();
		this.title = title;
		this.author = author;
		this.album = album;
		this.duration = duration;
	}

	/**
	 * Create a new instance of this class from JSON object.
	 * @param source
	 * @throws JSONException
	 */
	public Song(JSONObject source) throws JSONException {
		this.title = source.getString("title");
		this.duration = source.getString("duration");
		this.album = source.getString("album");
		this.author = source.getString("author");
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(String album) {
		this.album = album;
	}

	/**
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/* (non-Javadoc)
	 * @see com.vicmonmena.songclient.lab.networking.Jsonable#getId()
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.vicmonmena.songclient.lab.networking.Jsonable#setId(int)
	 */
	@Override
	public int setId(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return title;
	}
	
	/* (non-Javadoc)
	 * @see com.vicmonmena.songclient.lab.networking.Jsonable#parseFromJSON(org.json.JSONObject)
	 */
	@Override
	public void parseFromJSON(JSONObject source) throws JSONException {
		this.title = source.getString("title");
		this.duration = source.getString("duration");
		this.album = source.getString("album");
		this.author = source.getString("author");
	}
}