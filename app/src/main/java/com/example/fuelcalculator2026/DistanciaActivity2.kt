package com.example.fuelcalculator2026

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class DistanciaActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvTituloConsumoLitro)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // recuperar dados anteriores
        //recuperar IDs
        // passar todos os dados para a proxima tela ja calculado

        val precoCombustivel = intent.getDoubleExtra("PRECO_LITRO", 0.0)
        val consumoPorLitro = intent.getIntExtra("CONSUMO_LITRO", 0)


        val edtDistancia = findViewById<EditText>(R.id.edtDistancia)
        val btnDistanciaCalcular = findViewById<Button>(R.id.btnDistanciaCalcular)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_distancia)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        btnDistanciaCalcular.setOnClickListener {

            val distancia = edtDistancia.text.toString().toInt()
            val consumo = consumoPorLitro
            val precoCombustivel = precoCombustivel

            // calculo de litros necessarios

            val litrosNecessarios = distancia / consumo

            // calculo de custo total

            val custoTotal = litrosNecessarios * precoCombustivel

            val intent = Intent(this, ResultadoActivity2::class.java)
            intent.putExtra("DISTANCIA_PRECO_LITRO",precoCombustivel)
            intent.putExtra("DISTANCIA_CONSUMO_LITRO",consumo)
            intent.putExtra("DISTANCIA_VALOR",distancia)
            intent.putExtra("DISTANCIA_CUSTO_TOTAL", custoTotal)

            startActivity(intent)

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}