package br.com.eventpoc.kafkaschemaregistrypoc.service

import br.com.eventpoc.kafkaschemaregistrypoc.entity.PessoaDTO
import br.com.eventpoc.kafkaschemaregistrypoc.producer.PessoaProducerImpl
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class PersonService(

) {
    private val log = LoggerFactory.getLogger(javaClass)

    /*fun sendEventAvro(event : PessoaDTO, topicName : String){
        try {
            pessoaProducerImpl.send(topicName, (event.toString()))
            log.info("Event send to kafka: \n ${event.toString()}")
        } catch (e: Exception){
            log.error("Erro ao enviar evento: \n ${event.toString()} ")
        }
    }*/

}