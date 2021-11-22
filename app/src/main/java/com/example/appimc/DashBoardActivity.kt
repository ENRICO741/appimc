package com.example.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DashBoardActivity : AppCompatActivity() {

    lateinit var tvnome: TextView
    lateinit var tvprofissao: TextView
    lateinit var tvaltura: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        tvnome = findViewById(R.id.tv_dash_nome)
        tvprofissao = findViewById(R.id.tv_dash_profissao)
        tvaltura = findViewById(R.id.tv_dash_altura)

        preencherDashboard()

        supportActionBar!!.hide()
    }

    private fun preencherDashboard(){
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        tvnome.text = arquivo.getString("nome","")
        tvprofissao.text = arquivo.getString("profissao","")
        tvaltura.text = arquivo.getString("altura","")
    }

}