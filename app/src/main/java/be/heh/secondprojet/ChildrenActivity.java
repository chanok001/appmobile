package be.heh.secondprojet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ChildrenActivity extends Activity {

    EditText et_children_Login;
    EditText et_children_Pwd;
    EditText et_children_Email;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_children);

        //contenus xml
        et_children_Login= (EditText) findViewById(R.id.et_children_login);
        et_children_Pwd= (EditText) findViewById(R.id.et_children_pwd);
        et_children_Email= (EditText) findViewById(R.id.et_children_email);
    }

    public void onChildrenClickManager(View v){
        switch(v.getId()){
            case R.id.bt_children_main:
                Toast.makeText(getApplicationContext(),
                        "Login :" + et_children_Login.getText().toString() +
                        "\n Password:" + et_children_Pwd.getText().toString() +
                        "\n email :" + et_children_Email.getText().toString(),
                        Toast.LENGTH_LONG).show();
                break;
        }
    }
}