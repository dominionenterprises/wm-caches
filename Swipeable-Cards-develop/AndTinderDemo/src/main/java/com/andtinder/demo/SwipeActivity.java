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
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.andtinder.model.CardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_swipe);


		mCardContainer = (CardContainer) findViewById(R.id.layoutview);

		Resources r = getResources();

		SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);

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
		client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
}
