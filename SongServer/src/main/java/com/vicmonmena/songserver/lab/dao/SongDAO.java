/**
 * 
 */
package com.vicmonmena.songserver.lab.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vicmonmena.songserver.lab.domain.Song;

/**
 * @author Vicente Montaño Mena.
 */
@Service
public class SongDAO {

	/**
	 * Songs list.
	 */
	private List<Song> songs;
	
	/**
	 * Initialize songs list.
	 */
	public SongDAO() {
		songs = new ArrayList<Song>();
		Song s1 = new Song(
			1,
			"Omen",
			"The prodigy",
			"Invaders Must Die",
			"3:36");
		Song s2 = new Song(
				2,
				"Thunder",
				"The prodigy",
				"Invaders Must Die",
				"4:08");
		Song s3 = new Song(
				3,
				"Colours",
				"The prodigy",
				"Invaders Must Die",
				"3:27");
		Song s4 = new Song(
				4,
				"Take Me to the Hospital",
				"The prodigy",
				"Invaders Must Die",
				"3:39");
		Song s5 = new Song(
				5,
				"Warriors Dance",
				"The prodigy",
				"Invaders Must Die",
				"5:12");
		Song s6 = new Song(
				5,
				"Run with the Wolves",
				"The prodigy",
				"Invaders Must Die",
				"4:24");
		Song s7 = new Song(
				5,
				"World's on Fire",
				"The prodigy",
				"Invaders Must Die",
				"4:50");
		Song s8 = new Song(
				5,
				"Piranha",
				"The prodigy",
				"Invaders Must Die",
				"4:05");
		songs.add(s1);
		songs.add(s2);
		songs.add(s3);
		songs.add(s4);
		songs.add(s5);
		songs.add(s6);
		songs.add(s7);
		songs.add(s8);
	}
	
	/**
	 * @return the complete songs list.
	 */
	public List<Song> getSongs() {
		return songs;
	}
	
	/**
	 * @param songId - song identifier to find a song in songs list. 
	 * @return a song in songs list.
	 */
	public Song getSong(int songId) {
		return songs.get(songId);
	}
	
	/**
	 * Add a new song in songs list.
	 * @param song - the new song in songs list.
	 */
	public void addSong(Song song) {
		songs.add(song);
	}
	
	/**
	 * Update a new song in songs list.
	 * @param song - the song to update in songs list.
	 * @param songId - song identifier to find the song to update in sogs list.
	 */
	public void editSong(Song song, int songId) {
		songs.set(songId, song);
	}
}
