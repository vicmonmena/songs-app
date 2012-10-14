/**
 * 
 */
package com.vicmonmena.songserver.lab.domain;

/**
 * @author Vicente
 *
 */
public class Song {

	private int id;
	private String title;
	private String author;
	private String album;
	private String duration;
	
	/**
	 * 
	 */
	public Song() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id - song identifier.
	 * @param title - song title.
	 * @param author - song author.
	 * @param album - song album.
	 * @param duration - song duration.
	 */
	public Song(int id, String title, String author, String album, String duration) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.album = album;
		this.duration = duration;
	}

	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
}
