package id.ac.polinema.intentexercise;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import model.EmailValidator;
import model.User;

public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;
    private EditText name, email, password, confirm_password, homepage, about;
    private ImageView avatarImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.text_fullname);
        email = findViewById(R.id.text_email);
        password = findViewById(R.id.text_password);
        confirm_password = findViewById(R.id.text_confirm_password);
        homepage = findViewById(R.id.text_homepage);
        about = findViewById(R.id.text_about);
        avatarImage = findViewById(R.id.image_profile);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }

        if (requestCode == GALLERY_REQUEST_CODE) {
            if (data != null) {
                try {
                    Uri imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    avatarImage.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }

    public void sendButton(View view){
        String nameText = name.getText().toString();
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();
        String cPasswordText = confirm_password.getText().toString();
        String homepageText = homepage.getText().toString();
        String aboutText = about.getText().toString();

        User user = new User(nameText,emailText,passwordText,cPasswordText,homepageText,aboutText);
        if(!(nameText).equals("") && !(emailText).equals("") && !(passwordText).equals("") &&
                !(cPasswordText).equals("") && !(homepageText).equals("") && !(aboutText).equals(""))
        {
            if (passwordText.equals(cPasswordText)){

                if(EmailValidator.validate(emailText)){

                    Intent intent = new Intent(this,ProfileActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "Email Tidak Sesuai !",Toast.LENGTH_SHORT).show();
                }

            }
            else{
                Toast.makeText(this, "Password Tidak Sesuai !",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Lengkapi data terlebih dahulu !",Toast.LENGTH_SHORT).show();
        }
    }

    public void handleImage(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }
}