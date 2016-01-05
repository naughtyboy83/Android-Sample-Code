package pl.itraff.recognize.TestApi;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;

public class Preferences extends PreferenceActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
		final Preference modePref = (Preference) findPreference("mode");
		modePref.setPersistent(true);
		final Preference allResultsPref = (Preference) findPreference("allResults");
		allResultsPref.setPersistent(true);
		if (PreferenceManager
				.getDefaultSharedPreferences(getBaseContext())
				.getString("mode", "single").equals("multi")) {
			allResultsPref.setTitle(R.string.show_all_instances);
		} else {
			allResultsPref.setTitle(R.string.show_all_results);
		}

		modePref.setOnPreferenceChangeListener(new OnPreferenceChangeListener() {

			@Override
			public boolean onPreferenceChange(Preference preference,
					Object newValue) {
				String mode = (String) newValue;
				if (mode.equals("multi")) {
					allResultsPref.setTitle(R.string.show_all_instances);
				} else {
					allResultsPref.setTitle(R.string.show_all_results);
				}
				modePref.getEditor().putString("mode", mode).commit();
				return true;
			}
		});
	}
}
