package br.com.eventpoc.kafkaschemaregistrypoc.consumer

import br.com.eventpoc.kafkaschemaregistrypoc.entity.Pessoa
import br.com.eventpoc.kafkaschemaregistrypoc.entity.PessoaDTO
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload

class PessoaConsumerImpl {
    private val log = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["Pessoa"], groupId = "pessoa-consumer-group1")
    fun consumer(@Payload pessoaDTO: PessoaDTO) {
        val pessoa = Pessoa(pessoaDTO.getId().toString(), pessoaDTO.getNome().toString(), pessoaDTO.getCpf())
        log.info("Evento pessoa recebido, id=${pessoa.id}")
    }

}