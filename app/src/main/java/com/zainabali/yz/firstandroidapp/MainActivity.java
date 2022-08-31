package com.zainabali.yz.firstandroidapp;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText userName , password;
    Button ok,cancel;
    String username1="Alaa";
    String pass="123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//ربط الدزاين بالكود
        userName=findViewById(R.id.PersonName);
        password=findViewById(R.id.userPassword);

        ok=findViewById(R.id.ok);
        ok.setOnClickListener(this);
        cancel=findViewById(R.id.cancel);
        cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ok:
                String input=userName.getText().toString();
                String input2=password.getText().toString();

                if (input.equalsIgnoreCase(username1)&& input2.equalsIgnoreCase(pass))
                {
                    Toast.makeText(this, "Success", Toast.LENGTH_LONG).show();
                    //save user name and password
                    SharedPreferences sharePref= getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor= sharePref.edit();
                    editor.putString("user_name_pref",input);
                    editor.putString("password_pref",input2);
                    editor.commit();
                    //Read from shared preferences  from get.string
                    SharedPreferences read= getPreferences(Context.MODE_PRIVATE);
                   String savedName;
                   savedName= read.getString("user_name_pref","");//كوتيشن فارغ معنا جيب الكي الي هو user_name_pref
//جيب قيمته واحفظها بالكوتيشن الفارغ واذا ملكه قيمه يرجع فارغ
                    Toast.makeText(this, "User Name is :"+ savedName, Toast.LENGTH_LONG).show();

                    //to delete password
                    SharedPreferences deletePref= getPreferences(Context.MODE_PRIVATE);
                   boolean deletePass =deletePref.edit().remove("password_pref").commit();
                    Toast.makeText(this, "Password is :"+ deletePass, Toast.LENGTH_LONG).show();
                }//end if



                else {  Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();}
                break;

            case R.id.cancel:
                userName.setText("");
                password.setText("");
                break;


    }
}
}//end_main_activity