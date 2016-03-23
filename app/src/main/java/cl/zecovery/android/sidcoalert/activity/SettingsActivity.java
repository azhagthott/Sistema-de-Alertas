package cl.zecovery.android.sidcoalert.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import cl.zecovery.android.sidcoalert.R;

public class SettingsActivity extends PreferenceActivity {

    private static final String LOG_TAG = SettingsActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }

}
