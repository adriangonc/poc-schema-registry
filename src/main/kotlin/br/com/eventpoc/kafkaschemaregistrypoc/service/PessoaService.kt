package br.com.eventpoc.kafkaschemaregistrypoc.service

import br.com.eventpoc.kafkaschemaregistrypoc.entity.Pessoa
import br.com.eventpoc.kafkaschemaregistrypoc.producer.PessoaProducerImpl
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PessoaService(
    val pessoaProducerImpl: PessoaProducerImpl
) {
    private val log = LoggerFactory.getLogger(javaClass)
    fun savePessoa(id: String, pessoa: Pessoa) {
        return pessoaProducerImpl.persist(id, pessoa)
    }





}