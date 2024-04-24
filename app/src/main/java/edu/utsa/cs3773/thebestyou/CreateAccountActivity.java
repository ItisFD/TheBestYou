package edu.utsa.cs3773.thebestyou;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3773.thebestyou.controller.AccountController;
import edu.utsa.cs3773.thebestyou.model.CreateAccount;
import edu.utsa.cs3773.thebestyou.model.UserProfile;

public class CreateAccountActivity extends AppCompatActivity {

    private AccountController accountController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        accountController = new AccountController();

        EditText Email = findViewById(R.id.Email);
        EditText Password = findViewById(R.id.Password);
        EditText ReenterPassword = findViewById(R.id.ReenterPassword);
        EditText PhoneNumber = findViewById(R.id.PhoneNumber);
        Button btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String reenteredPassword = ReenterPassword.getText().toString().trim();
                String phoneNumber = PhoneNumber.getText().toString().trim();

                if (!accountController.createAccount(email, password, reenteredPassword, phoneNumber)) {
                    Toast.makeText(CreateAccountActivity.this, "Please enter all details correctly.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CreateAccountActivity.this, "Account created successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CreateAccountActivity.this, ProfileActivity.class);
                    intent.putExtra("email", email);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            }
        });
    }
}
