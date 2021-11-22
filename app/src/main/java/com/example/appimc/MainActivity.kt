package com.example.appimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.appimc.utils.calcularIdade

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val buttonNovaConta = findViewById<Button>(R.id.button_nova_conta)

        val buttonDashboard = findViewById<Button>(R.id.button_Entrar)

        val editEmail = findViewById<EditText>(R.id.edit_login_Email)
        val editSenha = findViewById<EditText>(R.id.edit_login_Senha)

        buttonDashboard.setOnClickListener{

            calcularIdade("")

            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

            val email = arquivo.getString("email","")
            val senha = arquivo.getString("senha","")

            if (email == editEmail.text.toString() && senha == editSenha.text.toString()){
                val abrirDashBoard = Intent(this, DashBoardActivity::class.java)
                startActivity(abrirDashBoard)
            } else{
                Toast.makeText(this, "Senha ou usuario incorreto", Toast.LENGTH_SHORT).show()
            }

            val abrirDashboard = Intent(this, DashBoardActivity::class.java)
            startActivity(abrirDashboard)
        }

        buttonNovaConta.setOnClickListener{
            val abrirNovaConta = Intent(this, NovoUsuarioActivity::class.java)
            startActivity(abrirNovaConta)
        }
    }
}