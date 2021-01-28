package com.example.login.LogOut.Google;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;
import com.google.firebase.auth.FirebaseAuth;

//public class OutGoogle implements View.OnClickListener{
//
//    AppCompatActivity aOutGoogle;
//
//    private FirebaseAuth mAuth ;
//
//    Button btnLogout , btnRevoke;
//
//    public OutGoogle(AppCompatActivity appCompatActivity){
//
//        aOutGoogle = appCompatActivity;
//
//        mAuth = FirebaseAuth.getInstance();
//
//        btnLogout = (Button)aOutGoogle.findViewById(R.id.btn_google_logout);
//        btnRevoke = (Button)aOutGoogle.findViewById(R.id.btn_revoke);
//
//    }
//
//    private void signOut() {
//        FirebaseAuth.getInstance().signOut();
//    }
//
//    private void revokeAccess() {
//        mAuth.getCurrentUser().delete();
//    }
//
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn_google_logout:
//                signOut();
//                aOutGoogle.finishAffinity();
//                break;
//            case R.id.btn_revoke:
//                revokeAccess();
//                aOutGoogle.finishAffinity();
//                break;
//        }
//    }
//}
