package br.com.eventpoc.kafkaschemaregistrypoc.producer


import br.com.eventpoc.kafkaschemaregistrypoc.entity.Pessoa
import br.com.eventpoc.kafkaschemaregistrypoc.entity.PessoaDTO
import br.com.eventpoc.kafkaschemaregistrypoc.entity.PessoaDTO_v2
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.kafka.support.SendResult
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component
import org.springframework.util.concurrent.ListenableFuture
import org.springframework.util.concurrent.ListenableFutureCallback
import java.time.LocalDate

@Component
class PessoaProducerImpl(
    private val pessoaTemplate: KafkaTemplate<String, PessoaDTO>
) {
    private val log = LoggerFactory.getLogger(javaClass)

    val topicName = "Pessoa"

    fun persist(eventId: String, payload: Pessoa) {
        val dto = createDTO(payload)
        sendPessoaEvent(eventId, dto)
    }

    private fun sendPessoaEvent(eventId: String, dto: PessoaDTO_v2) {
        val event = createMessageWithHeaders(eventId, dto, topicName)

        val future: ListenableFuture<SendResult<String, PessoaDTO>> = pessoaTemplate.send(event)

        future.addCallback(object : ListenableFutureCallback<SendResult<String, PessoaDTO>> {
            override fun onSuccess(result: SendResult<String, PessoaDTO>?) {
                log.info("Pessoa enviada. MessageId $eventId")
            }

            override fun onFailure(ex: Throwable) {
                log.info("Erro no envio. MessageId $eventId")
            }
        })

    }

    private fun createDTO(payload: Pessoa): PessoaDTO_v2 {
        return PessoaDTO_v2.newBuilder().setId(payload.id).setNome(payload.nome).setCpf(payload.cpf)
            .setEmail(payload.email).build()
    }

    private fun createMessageWithHeaders(
        messageId: String,
        pessoaDTO: PessoaDTO_v2,
        topic: String
    ): Message<PessoaDTO_v2> {
        return MessageBuilder.withPayload(pessoaDTO)
            .setHeader("hash", pessoaDTO.hashCode())
            .setHeader("version", "1.0.0")
            .setHeader("endOfLife", LocalDate.now().plusDays(1L))
            .setHeader("type", "fct")
            .setHeader("cid", messageId)
            .setHeader(KafkaHeaders.TOPIC, topic)
            .setHeader(KafkaHeaders.MESSAGE_KEY, messageId)
            .build()
    }

}