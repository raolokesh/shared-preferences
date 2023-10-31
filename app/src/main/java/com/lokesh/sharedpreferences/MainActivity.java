package com.lokesh.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.lokesh.sharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.submitTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.textView.setText(binding.editText.getText().toString());
            }
        });

        binding.saveTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveText();
            }
        });

        againLoadText();
    }

    private void saveText() {
        SharedPreferences preferences = getSharedPreferences("sharedPrefs",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("text",binding.textView.getText().toString());
        editor.putBoolean("switch",binding.switch1.isChecked());
        editor.apply();
        Toast.makeText(this, "Data is saved", Toast.LENGTH_SHORT).show();

    }

    private void  againLoadText(){
        String text;
        Boolean switchonoff;

        SharedPreferences preferences = getSharedPreferences("sharedPrefs",MODE_PRIVATE);
        text = preferences.getString("text","");
        switchonoff = preferences.getBoolean("switch",false);

        binding.textView.setText(text);
        binding.switch1.setChecked(switchonoff);

    }
}