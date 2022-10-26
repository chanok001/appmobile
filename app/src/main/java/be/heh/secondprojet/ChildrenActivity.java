package be.heh.secondprojet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChildrenActivity extends Activity {

    EditText et_children_Login;
    EditText et_children_Pwd;
    EditText et_children_Email;
    SharedPreferences prefs_datas;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_children);

        //contenus xml
        et_children_Login= (EditText) findViewById(R.id.et_children_login);
        et_children_Pwd= (EditText) findViewById(R.id.et_children_pwd);
        et_children_Email= (EditText) findViewById(R.id.et_children_email);
        prefs_datas = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    }

    public void onChildrenClickManager(View v){
        switch(v.getId()){
            case R.id.bt_children_main:
                if(et_children_Login.getText().toString().isEmpty() || et_children_Pwd.getText().toString().isEmpty() || et_children_Email.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "Complétez tous les champs !",
                        Toast.LENGTH_SHORT).show();}
                else{

                    SharedPreferences.Editor editeur_datas = prefs_datas.edit();
                    editeur_datas.putString("login", et_children_Login.getText().toString());
                    editeur_datas.putString("pwd", et_children_Pwd.getText().toString());
                    editeur_datas.putString("email", et_children_Email.getText().toString());
                    editeur_datas.commit();
                    Intent intent = new Intent (this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            break;
            case R.id.bt_children_list:
                Intent navList = new Intent(this,Activity_list.class);
                startActivity(navList);

                break;
            case R.id.bt_children_save:
                String str = et_children_Login.getText().toString() + "#" +
                        et_children_Pwd.getText().toString() + "#" +
                        et_children_Email.getText().toString()+ "#";
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
                try {
                    FileOutputStream ous = openFileOutput("monfichier.txt", MODE_APPEND);
                    byte[] tab;
                    tab = str.toString().getBytes();
                    ous.write(tab);
                    ous.close();
                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break; case R.id.bt_children_read:
                    /*try{
                        FileInputStream ous = new FileInputStream("monfichier.txt");
                        Scanner scanner =new Scanner(ous);
                        while (scanner.hasNextLine())
                        {
                            System.out.println(scanner.nextLine());
                        }
                        scanner.close();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }*/
                Intent file =new Intent(this,FileActivity.class);
                startActivity(file);
                 break;


        }

    }

}