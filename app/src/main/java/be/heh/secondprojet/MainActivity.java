package be.heh.secondprojet;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;

public class MainActivity extends Activity {
    SharedPreferences prefs_datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs_datas = PreferenceManager.getDefaultSharedPreferences(getApplication());
        if(!prefs_datas.getAll().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "votre login est : "
                                    + prefs_datas.getString("login", "NULL")+ "\n"
                                    + "votre password est : " + prefs_datas.getString("pwd", "NULL")+ "\n"
                                    + "votre email est : " + prefs_datas.getString("email", "NULL") + "\n",
                            Toast.LENGTH_SHORT)
                    .show();
        }

        /*Bundle extratxt = this.getIntent().getExtras();
        if(extratxt != null)
        {
            Toast.makeText(getApplicationContext(), "votre login est : "
                            + (extratxt.getString("login")) + "\n"
                            + "votre password est : " + (extratxt.getString("pwd")) + "\n"
                            + "votre email est : " + (extratxt.getString("email") + "\n" ), Toast.LENGTH_SHORT)
                    .show();
        }*/
    }

    public void onMainClickManager(View v){
        switch(v.getId()){
            case R.id.bt_main_children :
                Intent navChildren = new Intent(this,ChildrenActivity.class);
                startActivity(navChildren);

                Toast.makeText(getApplicationContext(),
                        "clic sur le bt Enfant",
                        Toast.LENGTH_SHORT)
                        .show();
                break;
        }
    }
}