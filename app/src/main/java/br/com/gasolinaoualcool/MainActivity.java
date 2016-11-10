package br.com.gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edPrecoAlcool;
    private EditText edPrecoGasolina;
    private Button btnVerificar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edPrecoAlcool = (EditText) findViewById(R.id.edPrecoAlcool);
        edPrecoGasolina = (EditText) findViewById(R.id.edPrecoGasolina);
        btnVerificar = (Button) findViewById(R.id.btVerificar);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

        btnVerificar.setOnClickListener((View view) -> {

            final String valorTelaAlcool = edPrecoAlcool.getText().toString();
            final String valorTelaGasolina = edPrecoGasolina.getText().toString();

            if (valorTelaAlcool.isEmpty() || valorTelaGasolina.isEmpty()) {
                Toast toast = Toast.makeText(this, "Preço álcool ou preço gasolina está em branco, Por favor preencher",
                        Toast.LENGTH_SHORT);
                toast.show();
            } else {
                final double resultado = this.calcular(Double.parseDouble(valorTelaAlcool),
                        Double.parseDouble(valorTelaGasolina));

                if (resultado > 0.7)
                    tvResultado.setText("é melhor utilizar gasolina");
                else
                    tvResultado.setText("é melhor utilizar álcool");
            }
        });
    }

    private double calcular(final double precoAlcool, final double precoGasolina) {
        return precoAlcool / precoGasolina;
    }
}
