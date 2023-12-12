package com.grl.paises

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.grl.paises.adapter.PaisAdapter
import com.grl.paises.databinding.ActivityMainBinding
import com.grl.paises.domain.PaisDAO

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listaPaises: MutableList<Pais>
    private var miDao = PaisDAO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaPaises = miDao.cargarLista(this)
        initRecycleView(listaPaises)
    }

    private fun initRecycleView(lista: MutableList<Pais>) {
        val manager = LinearLayoutManager(this)
        binding.recyclePaises.layoutManager = manager
        binding.recyclePaises.adapter = PaisAdapter(lista) { onItemSelected(it) }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.unionEuropea) {
            val lista = mutableListOf<Pais>()
            for (p in listaPaises) {
                if (!p.isEurope) {
                    lista.add(p)
                }
            }
            binding.recyclePaises.adapter =
                PaisAdapter(lista) { onItemSelected(it) }
            binding.recyclePaises.adapter?.notifyDataSetChanged()
        } else if (id == R.id.restoPaises) {
            val lista = mutableListOf<Pais>()
            for (p in listaPaises) {
                if (p.isEurope) {
                    lista.add(p)
                }
            }
            binding.recyclePaises.adapter =
                PaisAdapter(lista) { onItemSelected(it) }
            binding.recyclePaises.adapter?.notifyDataSetChanged()
        } else if (id == R.id.todos) {
            binding.recyclePaises.adapter =
                PaisAdapter(listaPaises) { onItemSelected(it) }
            binding.recyclePaises.adapter?.notifyDataSetChanged()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun onItemSelected(pais: Pais) {
        val intent = Intent(this, PaisActivity::class.java)
        intent.putExtra("nombre",pais.nombre)
        intent.putExtra("europa",pais.imagenEuropa)
        intent.putExtra("pertenece",pais.isEurope)
        intent.putExtra("capital",pais.capital)
        intent.putExtra("habitantes",pais.poblation)
        intent.putExtra("mapa",pais.mapa)
        intent.putExtra("bandera",pais.bandera)
        this.startActivity(intent)
    }
}