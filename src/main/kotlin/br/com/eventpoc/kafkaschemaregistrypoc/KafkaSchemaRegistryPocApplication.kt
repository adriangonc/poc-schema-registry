package br.com.eventpoc.kafkaschemaregistrypoc

import br.com.eventpoc.kafkaschemaregistrypoc.entity.Pessoa
import br.com.eventpoc.kafkaschemaregistrypoc.producer.PessoaProducerImpl
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.Random

@SpringBootApplication
class KafkaSchemaRegistryPocApplication(

)

fun main(args: Array<String>) {
	runApplication<KafkaSchemaRegistryPocApplication>(*args)
}
