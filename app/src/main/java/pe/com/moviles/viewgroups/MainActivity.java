package pe.com.moviles.viewgroups;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView txtImporte;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spConvertir);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lista_cambio, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        txtImporte = (TextView) findViewById(R.id.txtImporte);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                double resultado = 0;
                if (position == 1) {
                    Toast.makeText(getApplicationContext(), "CONVERSION SOLES A DOLARES", Toast.LENGTH_SHORT).show();
                    //CONVERSION SOLES A DOLARES
                    resultado = Double.parseDouble(txtImporte.getText().toString()) * 3.23;
                } else if (position == 2) {
                    //CONVERSION DOLARES A SOLES
                    Toast.makeText(getApplicationContext(), "CONVERSION DOLARES A SOLES", Toast.LENGTH_SHORT).show();
                    resultado = Double.parseDouble(txtImporte.getText().toString()) / 3.23;
                }
                txtResultado.setText(String.valueOf(String.format("%.2f",resultado)));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
