package com.rauladrianoramos.alcoolougasolinawear

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textAlcool: TextView
    private lateinit var textGasolina: TextView
    private lateinit var textResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textAlcool = findViewById(R.id.text_alcool)
        textGasolina = findViewById(R.id.text_gasolina)
        textResultado = findViewById(R.id.textResultado)

        val bundle = intent.extras

        if (bundle != null) {

            val alcool = bundle.getString("alcool")
            val gasolina = bundle.getString("gasolina")
            val resultado = bundle.getDouble("resultado")

            textAlcool.text = "Preço Alcool: R$ $alcool"
            textGasolina.text = "Preço Gasolina: R$ $gasolina"

            if (resultado >= 0.7) {
                textResultado.text = "Melhor utilizar GASOLINA"
            } else {
                textResultado.text = "Melhor utilizar ALCOOL"
            }
        }
    }
}