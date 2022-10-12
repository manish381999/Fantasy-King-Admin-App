package com.tie.adminfantasyking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.tie.adminfantasyking.databinding.ActivityUploadTeamBinding;

import java.io.ByteArrayOutputStream;

import java.io.IOException;


public class UploadTeamActivity extends AppCompatActivity {
   ActivityUploadTeamBinding binding;
FirebaseDatabase database;
FirebaseStorage storage;
public String match,tournamentName,date,time,matchQuality,preview,statistics,teamA,teamB,aPlaying11,
        bPlaying11,captain,vCaptain,teamStatus;
    private final int REQa=1;
    private final int REQb=2;
    private final int REQc=3;
    private Bitmap bitmapA,bitmapB ,bitmapC;
    Uri uriA,uriB, uriC;
    String imTeamA= "";
    String imTeamB= "";
    String imTeam= "";
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityUploadTeamBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


database=FirebaseDatabase.getInstance();
storage=FirebaseStorage.getInstance();



    openGallery();
  binding.btUpload.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
          checkValidation();
      }
  });


    }

    private void checkValidation(){
        match=binding.etMatch.getText().toString();
        tournamentName=binding.etTournamentName.getText().toString();
        date=binding.etDate.getText().toString();
        time=binding.etTime.getText().toString();
        matchQuality=binding.etMatchQuality.getText().toString();
        preview=binding.etPreview.getText().toString();
        statistics=binding.etStatistics.getText().toString();
        teamA=binding.etTeamA.getText().toString();
        teamB=binding.etTeamB.getText().toString();
        aPlaying11=binding.etAPlaying11.getText().toString();
        bPlaying11=binding.etBPlaying11.getText().toString();
        captain=binding.etCaptain.getText().toString();
        vCaptain=binding.etVc.getText().toString();
        teamStatus=binding.etTeamStatus.getText().toString();

   if (match.isEmpty()){
       binding.etMatch.setError("Please enter match name");
       binding.etMatch.requestFocus();

        }else if(tournamentName.isEmpty()){
       binding.etTournamentName.setError("Please enter tournament name");
       binding.etTournamentName.requestFocus();

   }else if (date.isEmpty()){
       binding.etDate.setError("Please enter date");
       binding.etDate.requestFocus();

   }else if (time.isEmpty()){
       binding.etTime.setError("Please enter time");
       binding.etTime.requestFocus();

   }else if (matchQuality.isEmpty()){
       binding.etMatchQuality.setError("Please enter match quality");
       binding.etMatchQuality.requestFocus();

   }else if (preview.isEmpty()){
       binding.etPreview.setError("Please enter match preview");
       binding.etPreview.requestFocus();

   }else if (statistics.isEmpty()){
       binding.etStatistics.setError("Please enter match statistics");
       binding.etStatistics.requestFocus();

   }else if (teamA.isEmpty()){
       binding.etTeamA.setError("Please enter team name");
       binding.etTeamA.requestFocus();

   }else if (teamB.isEmpty()){
       binding.etTeamB.setError("Please enter team name");
       binding.etTeamB.requestFocus();

   }else if (aPlaying11.isEmpty()){
       binding.etAPlaying11.setError("Please enter Playing 11");
       binding.etAPlaying11.requestFocus();

   }else if (bPlaying11.isEmpty()){
       binding.etBPlaying11.setError("Please enter Playing 11");
       binding.etBPlaying11.requestFocus();

   }else if (captain.isEmpty()){
       binding.etCaptain.setError("Please enter captain name");
       binding.etCaptain.requestFocus();

   }else if (vCaptain.isEmpty()){
       binding.etVc.setError("Please enter Vc name");
       binding.etVc.requestFocus();

   }else if (teamStatus.isEmpty()){
       binding.etTeamStatus.setError("Please enter ");
       binding.etTeamStatus.requestFocus();
   }else {
       uploadImage();
   }


    }

    private void uploadImage(){

        ByteArrayOutputStream byteArrayOutputStreamA=new ByteArrayOutputStream();
        bitmapA.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStreamA);
        byte[]finalImageA=byteArrayOutputStreamA.toByteArray();

        ByteArrayOutputStream byteArrayOutputStreamB=new ByteArrayOutputStream();
        bitmapB.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStreamB);
        byte[]finaImageB=byteArrayOutputStreamB.toByteArray();

        ByteArrayOutputStream byteArrayOutputStreamC=new ByteArrayOutputStream();
        bitmapC.compress(Bitmap.CompressFormat.JPEG,50,byteArrayOutputStreamC);
        byte[]finalImage=byteArrayOutputStreamC.toByteArray();

        StorageReference referenceA=storage.getReference().child("Match details").child("Tournament").child(teamA+":"+System.currentTimeMillis());
        referenceA.putBytes(finalImageA).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if (task.isSuccessful()){
                    referenceA.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uriA) {
                            imTeamA=String.valueOf(uriA);
                            uploadData();
                        }
                    });
                }else {
                    Toast.makeText(UploadTeamActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();

                }
            }
        });

        StorageReference referenceB=storage.getReference().child("Match details").child("Tournament").child(teamB+":"+System.currentTimeMillis());
        referenceB.putBytes(finaImageB).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
            if (task.isSuccessful()){
                referenceB.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uriB) {
                        imTeamB=String.valueOf(uriB);

                    }
                });
            }else {
                Toast.makeText(UploadTeamActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
            }
        });

        StorageReference reference=storage.getReference().child("Match details").child("Tournament").child(teamStatus+":"+System.currentTimeMillis());
        reference.putBytes(finalImage).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if (task.isSuccessful()){
                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uriC) {
                            imTeam=String.valueOf(uriC);

                        }
                    });
                }else {
                    Toast.makeText(UploadTeamActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void uploadData(){

        final String key=database.getReference().push().getKey();

        UploadTeamModel uploadTeamModel=new UploadTeamModel(imTeamA,imTeamB,match,tournamentName,date,time,matchQuality,preview,statistics
        ,teamA,teamB,aPlaying11,bPlaying11,captain,vCaptain,teamStatus,imTeam,key);

        database.getReference().child("Match details").child(key).setValue(uploadTeamModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(UploadTeamActivity.this, "Notice Uploaded", Toast.LENGTH_SHORT).show();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UploadTeamActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openGallery() {
        binding.imTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickImgA=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickImgA,REQa);
            }
        });

        binding.imTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickImgB=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickImgB,REQb);
            }
        });

        binding.imTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickImgC=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickImgC,REQc);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQa && resultCode == RESULT_OK && data != null) {
            uriA = data.getData();
            try {
                bitmapA = MediaStore.Images.Media.getBitmap(getContentResolver(), uriA);
            } catch (IOException e) {
                e.printStackTrace();
            }
            binding.imTeamA.setImageBitmap(bitmapA);

        } else if (requestCode == REQb && resultCode == RESULT_OK && data != null) {
            uriB = data.getData();
            try {
                bitmapB = MediaStore.Images.Media.getBitmap(getContentResolver(), uriB);
            } catch (IOException e) {
                e.printStackTrace();
            }
            binding.imTeamB.setImageBitmap(bitmapB);

        }else
            if (requestCode==REQc && resultCode==RESULT_OK && data!=null){
                uriC=data.getData();
                try {
                    bitmapC= MediaStore.Images.Media.getBitmap(getContentResolver(),uriC);
                }catch (IOException e){
                    e.printStackTrace();
                }
                binding.imTeam.setImageBitmap(bitmapC);
            }


    }
}

