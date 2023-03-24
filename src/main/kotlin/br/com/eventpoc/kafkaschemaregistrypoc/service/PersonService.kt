package br.com.eventpoc.kafkaschemaregistrypoc.service

import br.com.eventpoc.kafkaschemaregistrypoc.entity.PessoaDTO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class PersonService(
    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, Any>
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun sendEventAvro(event : PessoaDTO, topicName : String){
        try {
            kafkaTemplate.send(topicName, (event.toString()))
            log.info("Event send to kafka: \n ${event.toString()}")
        } catch (e: Exception){
            log.error("Erro ao enviar evento: \n ${event.toString()} ")
        }
    }

}