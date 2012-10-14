package com.vicmonmena.songserver.lab;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vicmonmena.songserver.lab.dao.SongDAO;
import com.vicmonmena.songserver.lab.domain.Song;
import com.vicmonmena.songserver.lab.util.ResourceNotFoundException;

/**
 * This class manage the rest server petitions from .../rest/{petition}
 * @author Vicente Montaño Mena.
 */
@Controller
@RequestMapping("")
public class RESTController {
	
	/**
	 * DAO to work with register songs.
	 */
	@Autowired
	private SongDAO songsDAO;
	
	/**
	 * It allows show log messages
	 */
	private static final Logger LOG = Logger.getLogger(RESTController.class);
	
	/**
	 * Create an instance of RESTController class.
	 */
	public RESTController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return Hello world! string.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody String test() {
        return "Hola Mundo !!!";
    }
	
	@RequestMapping(value = "/songs", method = RequestMethod.GET)
    public @ResponseBody List<Song> listSongs() {
        List<Song> songs = null;
        try {
            songs = songsDAO.getSongs();
            if (songs == null) {
                throw new ResourceNotFoundException(null);
            }
        } catch (Exception e) {
            LOG.error("Error obteniendo el listado completo de canciones.", e);
        }
        return songs;
    }
}