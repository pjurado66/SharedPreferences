package com.pjurado.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pjurado.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val EMPTY_VALUE = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configView()
        binding.btnSalvaNombre.setOnClickListener {
            SharedApp.prefs.name = binding.etNombre.text.toString()
            configView()
        }

        binding.btnDeleteNombre.setOnClickListener {
            SharedApp.prefs.name = EMPTY_VALUE
            configView()
        }
    }

    fun showPerfil(){
        binding.tvNombre.visibility = View.VISIBLE
        binding.tvNombre.text = "Hola ${SharedApp.prefs.name}"
        binding.btnDeleteNombre.visibility = View.VISIBLE
        binding.etNombre.visibility = View.INVISIBLE
        binding.btnSalvaNombre.visibility = View.INVISIBLE
    }

    fun showInvitado(){
        binding.tvNombre.visibility = View.INVISIBLE
        binding.btnDeleteNombre.visibility = View.INVISIBLE
        binding.etNombre.visibility = View.VISIBLE
        binding.btnSalvaNombre.visibility = View.VISIBLE
    }

    fun configView(){
        if (isSavedName()) showPerfil() else showInvitado()
    }

    private fun isSavedName(): Boolean {
        val myName = SharedApp.prefs.name
        return myName != EMPTY_VALUE
    }
}