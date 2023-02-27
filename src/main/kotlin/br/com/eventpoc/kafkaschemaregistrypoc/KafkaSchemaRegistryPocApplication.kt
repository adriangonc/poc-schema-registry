package br.com.eventpoc.kafkaschemaregistrypoc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaSchemaRegistryPocApplication

fun main(args: Array<String>) {
	runApplication<KafkaSchemaRegistryPocApplication>(*args)
}
