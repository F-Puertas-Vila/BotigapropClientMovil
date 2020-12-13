package fernandopuertas.ioc.botigapropclientmovil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView textViewRol, textViewNom, textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //if the user is not logged in
        //starting the login activity
        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }


        textViewRol = (TextView) findViewById(R.id.textViewRol);
        textViewNom = (TextView) findViewById(R.id.textViewNom);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);



        //getting the current user
        Usuari usuari = SharedPrefManager.getInstance(this).getUser();

        //setting the values to the textviews
        textViewRol.setText(usuari.getRol());
        textViewNom.setText(usuari.getNom());
        textViewEmail.setText(usuari.getEmail());

        //when the user presses logout button
        //calling the logout method
        findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();
            }
        });
    }
}