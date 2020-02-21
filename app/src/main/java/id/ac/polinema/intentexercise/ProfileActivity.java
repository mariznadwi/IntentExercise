package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import model.User;

public class ProfileActivity extends AppCompatActivity {

    private TextView name, email, homepage, about;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.label_fullname);
        email = findViewById(R.id.label_email);
        homepage = findViewById(R.id.label_homepage);
        about = findViewById(R.id.label_about);
        User value = getIntent().getParcelableExtra("user");
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            name.setText(value.getName());
            email.setText(value.getEmail());
            homepage.setText(value.getHomepage());
            about.setText(value.getAbout());

        }
    }

    public void visitHomepage(View view){
        User value = getIntent().getParcelableExtra("user");
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+value.getHomepage()));
        startActivity(browserIntent);
    }


}