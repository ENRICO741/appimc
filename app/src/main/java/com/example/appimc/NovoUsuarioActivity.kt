 package com.example.appimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast

 class NovoUsuarioActivity : AppCompatActivity() {

    lateinit var editNome: EditText
    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editDate: EditText
    lateinit var editRadioM: EditText
    lateinit var editRadioF: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editNome = findViewById(R.id.edit_Nome)
        editEmail = findViewById(R.id.edit_Email)
        editSenha = findViewById(R.id.edit_Senha)
        editProfissao = findViewById(R.id.edit_Profissao)
        editAltura = findViewById(R.id.edit_Altura)
        editDate = findViewById(R.id.edit_Date)
        editRadioF = findViewById(R.id.edit_RadioF)
        editRadioM = findViewById(R.id.edit_RadioM)

        supportActionBar!!.title = "Nova Conta"
    }

        //criar menu
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu, menu)
            return true
        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (validarCampos()) {
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val editor = arquivo.edit()

            editor.putString("email",editEmail.text.toString())
            editor.putString("senha",editSenha.text.toString())
            editor.putString("nome",editNome.text.toString())
            editor.putString("profissao",editProfissao.text.toString())
            editor.putString("altura",editAltura.text.toString())
            editor.putString("data",editDate.text.toString())
            editor.apply()

            Toast.makeText(this, "Usuario cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
            finish()

        }else{

        }

        return false
    }

    private fun validarCampos() : Boolean{
        var valido = true

        if (editNome.text.isEmpty()) {
            editNome.error= "Nome é obrigatório!"
            valido= false
        }

        if (editEmail.text.isEmpty()) {
            editEmail.error= "Email é obrigatório!"
            valido= false
        }

        if (editSenha.text.isEmpty()) {
            editSenha.error= "Senha é obrigatório!"
            valido= false
        }

        if (editProfissao.text.isEmpty()) {
            editProfissao.error= "Profissão é obrigatório!"
            valido= false
        }

        if (editAltura.text.isEmpty()) {
            editAltura.error= "Altura é obrigatório!"
            valido= false
        }

        if (editDate.text.isEmpty()) {
            editDate.error= "Data de Nascimento é obrigatório!"
            valido= false
        }

        return valido
    }
}