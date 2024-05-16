package com.alaingauthier1.gastoviagem

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alaingauthier1.gastoviagem.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
//        setContentView(R.layout.activity_main);
        setContentView(binding.root);
        binding.buttonCalculate.setOnClickListener(this);
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_calculate) {
            calculate();
        }
    }

    private fun isInValidInputs(): Boolean {
        return (binding.editDistance.text.toString().trim().isEmpty()
                || binding.editPrice.text.toString().trim().isEmpty()
                || binding.editAutonomy.text.toString().trim().isEmpty()
                || binding.editAutonomy.text.toString().toFloat() == 0f)
    }


    private fun calculate() {

        if (isInValidInputs()) {
            Toast.makeText(this, R.string.invalid_inputs, Toast.LENGTH_SHORT).show();
        } else {
            //        val distance = findViewById<EditText>(R.id.edit_distance).toString().toFloat();
            //        val price = findViewById<EditText>(R.id.edit_price).toString().toFloat();
            //        val autonomy = findViewById<EditText>(R.id.edit_autonomy).toString().toFloat();
            val distance = binding.editDistance.text.toString().toFloat();
            val price = binding.editPrice.text.toString().toFloat();
            val autonomy = binding.editAutonomy.text.toString().toFloat();
            val totalValue = (distance * price) / autonomy;
            binding.textTotalValue.text = "R$ ${"%.2f".format(totalValue)}";
        }
    }

}