package com.example.tema4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new Fragment1());
    }

    public void nextbtn(View view){
        if(currentFragment() instanceof Fragment1){
            replaceFragment(new Fragment2());
        }
        else if(currentFragment() instanceof Fragment2){
            replaceFragment(new Fragment3());
        }else if(currentFragment() instanceof Fragment3){
            replaceFragment(new Fragment4());
        }else if(currentFragment() instanceof Fragment4){
            replaceFragment(new Fragment1());
        }
    }
    public void prevbtn(View view){
        if(currentFragment() instanceof Fragment1){
            replaceFragment(new Fragment4());
        }
        else if(currentFragment() instanceof Fragment2){
            replaceFragment(new Fragment1());
        }else if(currentFragment() instanceof Fragment3){
            replaceFragment(new Fragment2());
        }else if(currentFragment() instanceof Fragment4){
            replaceFragment(new Fragment3());
        }
    }



    public void aboutbtn(View view){
        Intent intent_1 = new Intent(this, MainActivity2.class);

        if(currentFragment() instanceof Fragment1){
            intent_1.putExtra("value", "Girl with one eye");
        }else if(currentFragment() instanceof Fragment2){
            intent_1.putExtra("value", "Blue eyes");
        }else if(currentFragment() instanceof Fragment3){
            intent_1.putExtra("value", "Dreaming");
        }else if(currentFragment() instanceof Fragment4){
            intent_1.putExtra("value", "Tunel light");
        }
        startActivity(intent_1);
    }
    public Fragment currentFragment() {

        return getSupportFragmentManager().findFragmentById(R.id.frameLayout);
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}