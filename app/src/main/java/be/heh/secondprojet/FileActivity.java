package be.heh.secondprojet;

import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileActivity extends Activity_list{
    TextView tv_file_datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tv_file_datas = (TextView) findViewById(R.id.tv_file_datas);
        tv_file_datas.setText("Contenu du fichier texte : \n");
        try {
            FileInputStream ins = openFileInput("monfichier.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                out.append(line);
            }
            reader.close();
            ins.close();
            String[] items = out.toString().split("#");
            int i = 0;
            for (String item : items) {
                tv_file_datas.setText(tv_file_datas.getText().toString() +
                        "item " + Integer.toString(i + 1) + " = " + item + "\n");
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
