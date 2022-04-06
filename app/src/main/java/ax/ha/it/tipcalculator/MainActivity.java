package ax.ha.it.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;

import ax.ha.it.tipcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonCalculate.setOnClickListener(view -> {
            String billText = binding.tipLessBill.getText().toString();
            double bill = Double.parseDouble(billText);
            String percentText = binding.tipPercentage.getText().toString();
            double percent = Double.parseDouble(percentText);

            double tip = calculator.calculateTip(bill, percent);
            double total = bill + tip;

            binding.tipDisplay.setText(Double.toString(tip));
            binding.resultDisplay.setText(Double.toString(total));
        });

    }
}