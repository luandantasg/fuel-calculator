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

class ConsumoPorLitroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo_por_litro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvTituloConsumoLitro)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // recuperar dados da da tela anterior
        //FINDVIEW
        // navegar proxima tela
        //passar dados da tela anterior junto com os dados dessa tela para a proxima

        val precoCombustivel = intent.getDoubleExtra("PRECO_COMBUSTIVEL", 0.0)
        val edtConsumoPorLitro = findViewById<EditText>(R.id.edtConsumoPorLitro)
        val btnConsumoPorLitro = findViewById<Button>(R.id.btnConsumoLitroProximo)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_consumo_litro)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        btnConsumoPorLitro.setOnClickListener {
            val consumoPorLitroValor = edtConsumoPorLitro.text.toString().toInt()
            val intent = Intent(this, DistanciaActivity2::class.java)
            intent.putExtra("CONSUMO_LITRO", consumoPorLitroValor)
            intent.putExtra("PRECO_LITRO", precoCombustivel)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

}