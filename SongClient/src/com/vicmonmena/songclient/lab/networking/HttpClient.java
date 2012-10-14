/**
 * 
 */
package com.vicmonmena.songclient.lab.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * @author Vicente Montaño Mena.
 *
 */
public class HttpClient {
	
	/**
	 * @param host
	 * @param port
	 * @param path
	 * @param postBody
	 * @return
	 * @throws IOException
	 */
	public static String get(String host, int port, String path) 
		throws IOException {
		
		HttpHost target = new HttpHost(host, port);
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(path);
		HttpEntity results = null;
		try {
			HttpResponse response = client.execute(target, request);
			results = response.getEntity();
			return EntityUtils.toString(results);
		} catch (Exception e) {
			throw new RuntimeException("Web Service Failure",e);
		} finally {
			if (results!=null) {
				try {
					results.consumeContent();
				} catch (IOException e) {
				// empty, Checked exception but don't care
				}
			}
		}
	}
	
	/**
	 * @param host
	 * @param port
	 * @param path
	 * @return
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public static String getFromJSON(String host, int port, String path) 
		throws IOException, ClientProtocolException{
		HttpHost target = new HttpHost(host, port);
		StringBuilder builder = new StringBuilder();
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(path);
		try {
			HttpResponse response = client.execute(target, request);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				// Couldn't obtain the data
			}
		} catch (ClientProtocolException e) {
			throw new ClientProtocolException("Web Service Failure",e);
		} catch (IOException e) {
			throw e;
		}
		return builder.toString();
	}
}
