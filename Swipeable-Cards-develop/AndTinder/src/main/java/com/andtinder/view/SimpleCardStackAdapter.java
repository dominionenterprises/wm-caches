package com.andtinder.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andtinder.R;
import com.andtinder.model.CardModel;

public final class SimpleCardStackAdapter extends CardStackAdapter {

	Context context;

	public SimpleCardStackAdapter(Context mContext) {
		super(mContext);
		context = mContext;
	}

	@Override
	public View getCardView(int position, CardModel model, View convertView, ViewGroup parent) {
		if(convertView == null) {
			LayoutInflater inflater = LayoutInflater.from(getContext());
			convertView = inflater.inflate(R.layout.std_card_inner, parent, false);
			assert convertView != null;
		}

		((ImageView) convertView.findViewById(R.id.image)).setImageDrawable(model.getCardImageDrawable());
		((TextView) convertView.findViewById(R.id.title)).setText(model.getTitle());
		((TextView) convertView.findViewById(R.id.description)).setText(model.getDescription());
		((ImageView) convertView.findViewById(R.id.image_2)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.yelp.com/search?find_desc=Restaurants&find_loc=23508"));
				context.startActivity(browserIntent);
			}
		});
		((ImageView) convertView.findViewById(R.id.image_1)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://homes.com/property/3110-st-mihiel-ave-norfolk-va-23509/id-400028641515"));
				context.startActivity(browserIntent);
			}
		});

		return convertView;
	}
}
