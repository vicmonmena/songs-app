package com.vicmonmena.songclient.lab;

import java.util.ArrayList;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.vicmonmena.songclient.lab.domain.Song;
import com.vicmonmena.songclient.lab.networking.HttpClient;
import com.vicmonmena.songclient.lab.networking.HttpResponseParser;

/**
 * @author Vicente Montaño Mena.
 */
public class HomeActivity extends Activity {
	
	/**
	 * Listview to load the songs list.
	 */
	private ListView listView;
	
	/**
	 * Listview manager.
	 */
	private ArrayAdapter<Song> adapter;
	
	/**
	 * To load html content.
	 */
	private WebView  browser;
	
	/**
	 * It allows to show messages in log from this class. 
	 */
	private static final String TAG = HomeActivity.class.getSimpleName();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        try {
        	listView = ((ListView)findViewById(R.id.songs_list_view));
        	new LoadSongsTask().execute();
        } catch (Exception e) {
        	Log.e(TAG, "An exception was caught loading songs",e);
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }
    
    /**
     * AsyncTask to load the songs from server.
     */
    private class LoadSongsTask extends AsyncTask<Void, Void, ArrayList<Song>> {
		
		@Override
		protected void onPreExecute() {
			((LinearLayout)findViewById(R.id.loading_songs_layout))
				.setVisibility(LinearLayout.VISIBLE);
			listView.setVisibility(ListView.GONE);
//			((WebView) findViewById(R.id.webview)).setVisibility(WebView.GONE);
			((EditText)findViewById(R.id.song_edit_text)).setEnabled(false);
			((EditText)findViewById(R.id.song_edit_text)).setFocusable(false);
			super.onPreExecute();
		}
		
        @Override
        protected ArrayList<Song> doInBackground(Void... params) {
        	ArrayList<Song> songs = null;
        	try {
        		String path = getString(R.string.basepath) + 
        			getString(R.string.song_list_rest);
        		String result = HttpClient.getFromJSON(
        			getString(R.string.host), 
        			Integer.parseInt(getString(R.string.port)), 
        			path);
        		songs = HttpResponseParser.parseJSON(result);
        	} catch(Exception e) {
            	Log.e(TAG, "An exception was caught loading list view", e);
            }
        	
        	return songs;
        }

        @Override
        protected void onPostExecute(ArrayList<Song> result) {
        	
        	try {
	        	if(result != null) {
	        		adapter = new ArrayAdapter<Song>(
	            		HomeActivity.this,
	            		android.R.layout.simple_list_item_1,
	            		result);
	        		
	        		listView.setAdapter(adapter);
	        	}
        	} catch(Exception e) {
        		Log.e(HomeActivity.TAG, "Exception was caught onPostExecute LoadSongsTask",e);
        	}
			
        	((LinearLayout)findViewById(R.id.loading_songs_layout))
				.setVisibility(LinearLayout.GONE);
        	listView.setVisibility(ListView.VISIBLE);
			if (listView != null && listView.getCount() > 0) {
				((EditText)findViewById(R.id.song_edit_text)).setEnabled(true);
				((EditText)findViewById(R.id.song_edit_text)).setFocusable(true);
			}
			
        	// Showing webvie
//        	((WebView) findViewById(R.id.webview)).setVisibility(WebView.VISIBLE);
//        	((WebView) findViewById(R.id.webview))
//        		.loadData("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+result,
//        		"text/html; charset=UTF-8", "UTF-8");
		
	        super.onPostExecute(result);
        }		
    }
    
    public void refresh(View view) {
    	if(view.getId() == R.id.refresh_button) {
    		new LoadSongsTask().execute();
    	}
    }
}
