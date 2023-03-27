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
	val pessoaProducerImpl: PessoaProducerImpl
): ApplicationRunner{
	//TODO Remover após testes
	override fun run(args: ApplicationArguments?) {
		val pessoa = Pessoa("1532", "Adriano Goncalves", 123454)
		pessoaProducerImpl.persist("AB12341", pessoa)
	}
}

fun main(args: Array<String>) {
	runApplication<KafkaSchemaRegistryPocApplication>(*args)
}
