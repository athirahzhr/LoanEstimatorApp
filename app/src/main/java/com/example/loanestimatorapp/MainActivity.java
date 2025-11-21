package com.example.loanestimatorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loanestimatorapp.R;

public class MainActivity extends AppCompatActivity {

    EditText inPrice, inPayment, inRate, inPeriod;
    TextView resLoan, resInterest, resPayment, resMonthly;
    Button calcBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Input fields
        inPrice = findViewById(R.id.inPrice);
        inPayment = findViewById(R.id.inPayment);
        inRate = findViewById(R.id.inRate);
        inPeriod = findViewById(R.id.inPeriod);

        // Output fields
        resLoan = findViewById(R.id.resLoan);
        resInterest = findViewById(R.id.resInterest);
        resPayment = findViewById(R.id.resPayment);
        resMonthly = findViewById(R.id.resMonthly);

        // Button
        calcBtn = findViewById(R.id.calcBtn);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateLoan();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // If HOME selected
        if (id == R.id.nav_home) {
            Toast.makeText(this, "You are already on Home Page", Toast.LENGTH_SHORT).show();
            return true;
        }

        // If ABOUT selected
        if (id == R.id.nav_about) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void calculateLoan() {

        // Validate inputs
        if (inPrice.getText().toString().isEmpty() ||
                inPayment.getText().toString().isEmpty() ||
                inRate.getText().toString().isEmpty() ||
                inPeriod.getText().toString().isEmpty()) {

            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert inputs
        double price = Double.parseDouble(inPrice.getText().toString());
        double downPayment = Double.parseDouble(inPayment.getText().toString());
        double rate = Double.parseDouble(inRate.getText().toString());
        double years = Double.parseDouble(inPeriod.getText().toString());

        // Step 1: Loan Amount
        double loanAmount = price - downPayment;

        // Step 2: Total Interest
        double totalInterest = loanAmount * (rate / 100) * years;

        // Step 3: Total Payment
        double totalPayment = loanAmount + totalInterest;

        // Step 4: Monthly Payment
        double monthlyPayment = totalPayment / (years * 12);

        // Display results
        resLoan.setText("Loan Amount: RM " + String.format("%.2f", loanAmount));
        resInterest.setText("Total Interest: RM " + String.format("%.2f", totalInterest));
        resPayment.setText("Total Payment: RM " + String.format("%.2f", totalPayment));
        resMonthly.setText("Your Monthly Payment: RM " + String.format("%.2f", monthlyPayment));
    }
}
