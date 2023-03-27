package br.com.eventpoc.kafkaschemaregistrypoc.entity

import java.util.Date

data class Pessoa(
    val id: String,
    val nome: String,
    val cpf: Int
) {
}