/**
 * AndTinder v0.1 for Android
 *
 * @Author: Enrique López Mañas <eenriquelopez@gmail.com>
 * http://www.lopez-manas.com
 *
 * TAndTinder is a native library for Android that provide a
 * Tinder card like effect. A card can be constructed using an
 * image and displayed with animation effects, dismiss-to-like
 * and dismiss-to-unlike, and use different sorting mechanisms.
 *
 * AndTinder is compatible with API Level 13 and upwards
 *
 * @copyright: Enrique López Mañas
 * @license: Apache License 2.0
 */

package com.andtinder.model;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.lang.Object;

import javax.net.ssl.HttpsURLConnection;

public class Likes /*extends AsyncTask<URL, Integer, Long> */{
	 public enum Like {
	        None(0), Liked(1), Disliked(2);

	        public final int value;

	        private Like(int value) {
	            this.value = value;
	        }

	        public static Like fromValue(int value) {
	            for (Like style : Like.values()) {
	                if (style.value == value) {
	                    return style;
	                }
	            }
	            return null;
	        }
	    }

	/**
	 * Given a URL, sets up a connection and gets the HTTP response body from the server.
	 * If the network request is successful, it returns the response body in String form. Otherwise,
	 * it will throw an IOException.
	 */
//	private String downloadUrl(URL url) throws IOException {
//		InputStream stream = null;
//		HttpsURLConnection connection = null;
//		String result = null;
//		try {
//			connection = (HttpsURLConnection) url.openConnection();
//			// Timeout for reading InputStream arbitrarily set to 3000ms.
//			connection.setReadTimeout(3000);
//			// Timeout for connection.connect() arbitrarily set to 3000ms.
//			connection.setConnectTimeout(3000);
//			// For this use case, set HTTP method to GET.
//			connection.setRequestMethod("GET");
//			// Already true by default but setting just in case; needs to be true since this request
//			// is carrying an input (response) body.
//			connection.setDoInput(true);
//			// Open communications link (network traffic occurs here).
//			connection.connect();
//			publishProgress(DownloadCallback.Progress.CONNECT_SUCCESS);
//			int responseCode = connection.getResponseCode();
//			if (responseCode != HttpsURLConnection.HTTP_OK) {
//				throw new IOException("HTTP error code: " + responseCode);
//			}
//			// Retrieve the response body as an InputStream.
//			stream = connection.getInputStream();
//			publishProgress(DownloadCallback.Progress.GET_INPUT_STREAM_SUCCESS, 0);
//			if (stream != null) {
//				// Converts Stream to String with max length of 500.
//				result = readStream(stream, 500);
//			}
//		} finally {
//			// Close Stream and disconnect HTTPS connection.
//			if (stream != null) {
//				stream.close();
//			}
//			if (connection != null) {
//				connection.disconnect();
//			}
//		}
//		return result;
//	}



}
