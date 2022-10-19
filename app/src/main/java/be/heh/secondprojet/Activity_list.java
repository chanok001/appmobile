package be.heh.secondprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;

import java.util.prefs.PreferencesFactory;

public class Activity_list extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content,
                new NotreFragement()).commit();
    }

    @SuppressLint("ValidFragment")
    public static class NotreFragement extends PreferenceFragment {
        @Override
        public void onCreate(final Bundle saveInstanceState){
            super.onCreate(saveInstanceState);
            addPreferencesFromResource(R.xml.pref);
        }


    }
}