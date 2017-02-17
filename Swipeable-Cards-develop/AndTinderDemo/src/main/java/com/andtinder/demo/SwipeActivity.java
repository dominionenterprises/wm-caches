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

package com.andtinder.demo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.andtinder.model.CardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class SwipeActivity extends Activity {

	/**
	 * This variable is the container that will host our cards
	 */
	private CardContainer mCardContainer;
	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	private GoogleApiClient client;
	public volatile String[] addresses = new String[5];
	public volatile String[] images = new String[5];
	public volatile String[] crimes = new String[5];
	public volatile String[] links = new String[5];
	public volatile String[] prices = new String[5];

	public volatile boolean result = false;
	public volatile boolean temp;
	public SimpleCardStackAdapter adapter;
	public Resources r;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_swipe);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		mCardContainer = (CardContainer) findViewById(R.id.layoutview);

		r = getResources();

		adapter = new SimpleCardStackAdapter(this);

		client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
		//System.out.println("" + getHit());
		/*
		adapter.add(new CardModel("New Title0", "Bye", r.getDrawable(R.drawable.picture1)));
		adapter.add(new CardModel("New Title1", "Description goes here", r.getDrawable(R.drawable.picture2)));
		adapter.add(new CardModel("New Title2", "Description goes here", r.getDrawable(R.drawable.picture3)));
		adapter.add(new CardModel("New Title2", "Description goes here", r.getDrawable(R.drawable.picture1)));
		adapter.add(new CardModel("New Title3", "Description goes here", r.getDrawable(R.drawable.picture2)));
		adapter.add(new CardModel("New Title4", "Description goes here", r.getDrawable(R.drawable.picture3)));
		adapter.add(new CardModel("New Title5", "Description goes here", r.getDrawable(R.drawable.picture3)));
		adapter.add(new CardModel("New Title6", "Description goes here", r.getDrawable(R.drawable.picture1)));
		adapter.add(new CardModel("New Title7", "Description goes here", r.getDrawable(R.drawable.picture2)));
		adapter.add(new CardModel("New Title8", "Description goes here", r.getDrawable(R.drawable.picture3)));
		adapter.add(new CardModel("New Title9", "Description goes here", r.getDrawable(R.drawable.picture1)));
		adapter.add(new CardModel("New Title 10", "Hello", r.getDrawable(R.drawable.picture2)));
		*/


		for (int i = 0; i < 1; i++) {
			if (!result) {
				temp = getHit();
			}
			for (int j = 0; j < 10000000; j++) {
			}

		}

	}

	/**
	 * ATTENTION: This was auto-generated to implement the App Indexing API.
	 * See https://g.co/AppIndexing/AndroidStudio for more information.
	 */
	public Action getIndexApiAction() {
		Thing object = new Thing.Builder()
				.setName("Main Page") // TODO: Define a title for the content shown.
				// TODO: Make sure this auto-generated URL is correct.
				.setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
				.build();
		return new Action.Builder(Action.TYPE_VIEW)
				.setObject(object)
				.setActionStatus(Action.STATUS_TYPE_COMPLETED)
				.build();
	}

	@Override
	public void onStart() {
		super.onStart();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		client.connect();
		AppIndex.AppIndexApi.start(client, getIndexApiAction());
	}

	@Override
	public void onStop() {
		super.onStop();

		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.
		AppIndex.AppIndexApi.end(client, getIndexApiAction());
		client.disconnect();
	}

	public static Drawable drawableFromUrl(String url) throws IOException {
		Bitmap x;

		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.connect();
		InputStream input = connection.getInputStream();

		x = BitmapFactory.decodeStream(input);
		return new BitmapDrawable(x);
	}

	public boolean getHit(){
		// Instantiate the RequestQueue.

		RequestQueue queue = Volley.newRequestQueue(this);
		String url ="http://homesapi.herokuapp.com/matches";

		// Request a string response from the provided URL.
		StringRequest stringRequest;
		stringRequest = new StringRequest(Request.Method.GET, url,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						result = true;
						System.out.println("YES");
						// Display the first 500 characters of the response string.
						String fullLines[] = response.split("\\r?\\n");
						String lines[] = Arrays.copyOfRange(fullLines, 1, fullLines.length-1);
						String address = "";
						String street = "";
						String city = "";
						String zip = "";
						String state = "";
						int modLen = 10;
						int lastBracket = 9;
						int cityPos = 1;
						int crimePos = 2;
						int mainPos = 3;
						int postalPos = 4;
						int pricePos = 5;
						int imgPos = 6;
						int statePos = 7;
						int streetPos = 8;
						int foodScore = 0;
						int restPos = 0;
						int count = 0;

						int numResults = 5;
						modLen = lines.length / 5;
						lastBracket = modLen - 1;
						System.out.println("modLen is " + modLen);
						for (int i = 0; i < modLen; i++){
							if (lines[i].contains("city")){
								cityPos = i;
							}
							else if (lines[i].contains("crime_url")){
								crimePos = i;
							}
							else if (lines[i].contains("food_score")){
								foodScore = i;
							}
							else if (lines[i].contains("main_uri")){
								mainPos = i;
							}
							else if (lines[i].contains("price")){
								pricePos = i;
							}
							else if (lines[i].contains(("primary_image"))){
								imgPos = i;
							}
							else if (lines[i].contains("restaurant_search_url")){
								restPos = i;
							}
							else if (lines[i].contains("state")){
								statePos = i;
							} else if (lines[i].contains("street_address")){
								streetPos = i;
							}
							else if (lines[i].contains("postal_code")){
								postalPos = i;
							}

						}
						for (int i = 0; i < lines.length; i++){
							//System.out.println("i is " + i);
							//System.out.println("lines[i] is " + lines[i]);

							if (i % modLen == lastBracket) {

								address = street + ", " + city + ", " + state + " " +  zip;
								System.out.println(address);
								addresses[count++] = address;
								address = "";
								city = "";
								state = "";
								zip = "";
							}
							if (i % modLen == cityPos){
								int colonPos = lines[i].indexOf(":");
								city = lines[i].substring(colonPos + 3, lines[i].length()-3);
							}
							else if (i % modLen == streetPos) {
								int colonPos = lines[i].indexOf(":");
								street = lines[i].substring(colonPos + 3, lines[i].length()-1);


							}
							else if (i % modLen == postalPos){
								int colonPos = lines[i].indexOf(":");
								zip = lines[i].substring(colonPos+ 3, lines[i].length()-3);
							}

							else if (i % modLen == statePos){
								int colonPos = lines[i].indexOf(":");
								state = lines[i].substring(colonPos+ 3, lines[i].length()-3);
							}
							else if (i % modLen == pricePos){
								int colonPos = lines[i].indexOf(":");
								int commaPos = lines[i].lastIndexOf(",");
								prices[count] =lines[i].substring(colonPos+ 3, commaPos);
							}
							else if (i % modLen == imgPos){
								int colonPos = lines[i].indexOf(":");
								int quotePos = lines[i].lastIndexOf("\"");
								images[count] = lines[i].substring(colonPos+ 3, quotePos);
							}
							else if (i % modLen == crimePos){
								int colonPos = lines[i].indexOf(":");
								int quotePos = lines[i].lastIndexOf("\"");
								crimes[count] = lines[i].substring(colonPos+ 3, quotePos);
							}
							else if (i % modLen == mainPos){
								int colonPos = lines[i].indexOf(":");
								int quotePos = lines[i].lastIndexOf("\"");
								links[count] = lines[i].substring(colonPos+ 3, quotePos);
							}


						}

						for (int i = 0; i < 5; i++){
							System.out.println("address is " + addresses[i]);
							System.out.println("crimes is " + crimes[i]);
							System.out.println("images is " + images[i]);
							System.out.println("links is " + links[i]);
							System.out.println("prices is " + prices[i]);
						}

						completeOnCreate();
					}
				}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

				System.out.println("NOPE");
				System.out.println(error.toString());
				result = false;
				//Intent intent = new Intent(getBaseContext(), EndActivity.class);
				//intent.putExtra("testIntentEnd", false);
				//startActivity(intent);
			}
		});

		stringRequest.setRetryPolicy(new RetryPolicy() {
										 @Override
										 public int getCurrentTimeout() {
											 return 50000;
										 }

										 @Override
										 public int getCurrentRetryCount() {
											 return 50000;
										 }

										 @Override
										 public void retry(VolleyError error) throws VolleyError {

										 }
									 });

		// Add the request to the RequestQueue.
		queue.add(stringRequest);
		return result;
	}


	public void completeOnCreate(){
		addCards();
		CardModel cardModel = new CardModel("New Title 11", "World", r.getDrawable(R.drawable.picture1));
		cardModel.setOnClickListener(new CardModel.OnClickListener() {
			@Override
			public void OnClickListener() {
				Log.i("Swipeable Cards", "I am pressing the card");
			}
		});

		cardModel.setOnCardDismissedListener(new CardModel.OnCardDismissedListener() {
			@Override
			public void onLike() {
				Context context = getApplicationContext();
				CharSequence text = "LIKE!";
				int duration = Toast.LENGTH_SHORT;
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				Log.i("Swipeable Cards", "I like the card");
			}

			@Override
			public void onDislike() {
				Context context = getApplicationContext();
				CharSequence text = "DISLIKE!";
				int duration = Toast.LENGTH_SHORT;
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				Log.i("Swipeable Cards", "I dislike the card");
			}
		});

		adapter.add(cardModel);

		mCardContainer.setAdapter(adapter);
		// ATTENTION: This was auto-generated to implement the App Indexing API.
		// See https://g.co/AppIndexing/AndroidStudio for more information.

	}
	public void addCards(){
		for (int i = 0; i < prices.length; i++) {
			try {
				Drawable drawable = drawableFromUrl(images[i]);
				adapter.add(new CardModel("Price is $" + prices[i], addresses[i], drawable));
			} catch (IOException e) {
				System.out.println("error");
			}



		}

	}

}
