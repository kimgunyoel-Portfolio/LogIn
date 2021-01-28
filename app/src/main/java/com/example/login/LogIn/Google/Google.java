package com.example.login.LogIn.Google;

public class Google {
//
//    AppCompatActivity aGoogle;
//
//    private FirebaseAuth mAuth = null;
//    private GoogleSignInClient mGoogleSignInClient;
//    private static final int RC_SIGN_IN = 9001;
//    private SignInButton signInButton;
//
//    public Google(AppCompatActivity appCompatActivity){
//
//        aGoogle = appCompatActivity;
//
//        signInButton = aGoogle.findViewById(R.id.signInButton);
//
//        mAuth = FirebaseAuth.getInstance();
//        if (mAuth.getCurrentUser() != null) {
//            Intent intent = new Intent(aGoogle.getApplication(), LogOutActivity.class);
//            aGoogle.startActivity(intent);
//            aGoogle.finish();
//        }
//
//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken("456813381319-n5h1dea201ihtb1g1r63u8qkre3kd5jf.apps.googleusercontent.com")
//                .requestEmail()
//                .build();
//        mGoogleSignInClient = GoogleSignIn.getClient(aGoogle, gso);
//
//        signInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.println("구글로그인버튼 눌림");
//                signIn();
////                Intent intent = new Intent(aGoogle, LogOutActivity.class);
////                aGoogle.startActivity(intent);
////                aGoogle.finish();
//            }
//        });
//
//    }
//
//
//    public void signIn() {
//        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//        aGoogle.startActivityForResult(signInIntent, RC_SIGN_IN);
//    }
//
//    public void resultGoogle(int requestCode, int resultCode, @Nullable Intent data) {
//        //super.onActivityResult(requestCode, resultCode, data);
//        System.out.println("GoogleClass resultGoogle");
//        System.out.println("requestCode : " + requestCode);
//        System.out.println("resultCode : " + resultCode);
//        System.out.println("data : " + data.toString());
//
//
//        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            System.out.println("if requestCode == RC_SIGN_IN 진입");
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//            System.out.println("task : " + task.toString());
//            try {
//                // Google Sign In was successful, authenticate with Firebase
//                System.out.println("try 0");
//                //GoogleSignInAccount account = task.getResult(ApiException.class);
//                GoogleSignInAccount a = task.getResult(ApiException.class);
//                System.out.println("try 1");
//                //firebaseAuthWithGoogle(account);
//                firebaseAuthWithGoogle(a);
//                System.out.println("try 2");
//            } catch (ApiException e) {
//            }
//        }
//    }
//
//    public void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
//        System.out.println("파이어베이스 ㄴㅇㄴㅇㄴㅇ");
//
//        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            System.out.println("파이어베이스 성공");
//                            // Sign in success, update UI with the signed-in user's information
//                            //Snackbar.make(findViewById(R.id.layout_main), "Authentication Successed.", Snackbar.LENGTH_SHORT).show();
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//
//                            System.out.println("파이어베이스 실패");
//                            // If sign in fails, display a message to the user.
//                            //Snackbar.make(findViewById(R.id.layout_main), "Authentication Failed.", Snackbar.LENGTH_SHORT).show();
//                            updateUI(null);
//                        }
//                    }
//                });
//    }
//
//    public void updateUI(FirebaseUser user) { //update ui code here
//        System.out.println("updateUI() in...");
//        if (user != null) {
//            System.out.println("구글로그인됨");
//            Intent intent = new Intent(aGoogle, LogOutActivity.class);
//            aGoogle.startActivity(intent);
//            aGoogle.finish();
//
//        }
//    }

}
