package com.grl.paises

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grl.paises.databinding.ActivityMainBinding
import com.grl.paises.databinding.ActivityPaisViewBinding

class PaisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPaisViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaisViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nombre = intent.getStringExtra("nombre")
        val mapa = intent.getIntExtra("mapa", 0)
        val bandera = intent.getIntExtra("bandera", 0)
        val isEU = intent.getBooleanExtra("pertenece", true)
        val capital = intent.getStringExtra("capital")
        val europa = intent.getIntExtra("europa", 0)
        val hab = intent.getStringExtra("habitantes")

        binding.titulo.text = nombre
        binding.mapita.setImageResource(mapa)
        binding.banderita.setImageResource(bandera)
        if (!isEU) {
            binding.textoEuropa.text = "Pais miembro de la Unión Europea"
        } else {
            binding.textoEuropa.text = "Pais NO miembro de la Unión Europea"
        }
        binding.capital.text = "Capital: $capital"
        binding.habitantes.text="Habitantes: $hab"

        if(europa==R.drawable.c_vacia)
            binding.imagenEuropa.setImageResource(R.drawable.europa)
        else
            binding.imagenEuropa.setImageResource(R.drawable.europe)

        binding.botoncito.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }
    }
}