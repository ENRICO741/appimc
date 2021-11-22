package com.example.appimc.utils

import android.util.Log
import java.time.LocalDate
import java.time.Period

fun calcularIdade(dataNascimento: String): Int {

    val hoje = LocalDate.now()

    Log.i("xpto", hoje.toString())

    val nascimento = LocalDate.of(2000, 6, 20)

    val idade = Period.between(nascimento, hoje).years

    Log.i("xpto", idade.toString())

    return 0
}
