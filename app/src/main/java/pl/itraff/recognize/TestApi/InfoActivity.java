package pl.itraff.recognize.TestApi;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class InfoActivity extends Activity {

	private final String URL = "http://recognize.im";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info);

		TextView info = (TextView) findViewById(R.id.info);
		info.setText(Html.fromHtml("Find out more: <a href=\"" + URL + "\">" + URL + "</a>"));
		info.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(URL));
				startActivity(intent);
			}
		});
	}

	public void backClickHandler(View v) {
		finish();
	}
}