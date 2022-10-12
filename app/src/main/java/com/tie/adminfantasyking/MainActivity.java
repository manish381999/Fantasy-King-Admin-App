package com.tie.adminfantasyking;

import static com.tie.adminfantasyking.R.string.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;



import com.tie.adminfantasyking.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setTitle(dashboard);

        binding.uploadTeamA.setOnClickListener(view -> UploadTeamA());

        binding.updateTeam.setOnClickListener(view -> UpdateTeam());
        binding.deleteTeam.setOnClickListener(view -> DeleteTeam());
        binding.notification.setOnClickListener(view -> Notification());



    }

   private void UploadTeamA(){
        startActivity(new Intent(MainActivity.this, UploadTeamActivity.class));
   }


   private void UpdateTeam(){
        startActivity(new Intent(MainActivity.this,PreviewUpdateActivity.class));
   }

   private void DeleteTeam(){
        startActivity(new Intent(MainActivity.this,DeleteActivity.class));
   }

   private void Notification(){
        startActivity(new Intent(MainActivity.this,NotificationActivity.class));
   }

}