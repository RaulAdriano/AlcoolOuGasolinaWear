package com.rauladrianoramos.alcoolougasolinawear

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCalcular: Button
    private lateinit var editAlcool: EditText
    private lateinit var editGasolina: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular = findViewById(R.id.button_calcular)
        editAlcool = findViewById(R.id.edit_alcool)
        editGasolina = findViewById(R.id.edit_gasolina)

        buttonCalcular.setOnClickListener {


            val precoALcool = editAlcool.text.toString()
            val precoGasolina = editGasolina.text.toString()


            val resultadoValidacao = validarCampos(precoALcool, precoGasolina)

            if (resultadoValidacao) {

                val resultado = precoALcool.toDouble() / precoGasolina.toDouble()

                val intent = Intent(this, ResultadoActivity::class.java)

                intent.putExtra("gasolina", precoGasolina)
                intent.putExtra("alcool", precoALcool)
                intent.putExtra("resultado", resultado)



                startActivity(intent)
            }

        }
    }

    private fun validarCampos(precoALcool: String, precoGasolina: String): Boolean {

        editGasolina.error = null
        editAlcool.error = null

        if (precoALcool.isEmpty()) {
            editAlcool.error = "Digite o preço do Alcool"
            return false
        } else if (precoGasolina.isEmpty()) {
            editGasolina.error = "Digite o preço da Gasolina"
            return false
        }


        return true
    }


}