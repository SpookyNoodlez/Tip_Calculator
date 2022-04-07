package ax.ha.it.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.text.DecimalFormat;

import ax.ha.it.tipcalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Calculator calculator;

    public MainActivity() {
        this.calculator = new Calculator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonCalculate.setOnClickListener(view -> {
            String billText = binding.tipLessBill.getText().toString();
            String percentText = binding.tipPercentage.getText().toString();

            try {
                double bill = Double.parseDouble(billText);
                double percent = Double.parseDouble(percentText);

                double tip = calculator.calculateTip(bill, percent);
                double total = bill + tip;

                DecimalFormat df = new DecimalFormat("0.00");
                String stringTotal = df.format(total);
                String stringTip = df.format(tip);

                binding.tipDisplay.setText(stringTip);
                binding.resultDisplay.setText(stringTotal);
            } catch (Exception e){
                //Pop up
                 Toast toast = Toast.makeText(getApplicationContext(),"Enter an amount and a percentage",Toast.LENGTH_SHORT);
                 toast.show();
            }
        });
    }
}