package br.com.eventpoc.kafkaschemaregistrypoc.rest

import br.com.eventpoc.kafkaschemaregistrypoc.entity.Pessoa
import br.com.eventpoc.kafkaschemaregistrypoc.service.PessoaService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.handler.annotation.Header
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/pessoa")
class PessoaController(
    @Autowired
    private val pessoaService: PessoaService
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @PostMapping("/evento/{idEvento}")
    fun postPerson(@PathVariable idEvento: String, @RequestBody pessoa: Pessoa) {
        return pessoaService.savePessoa(idEvento, pessoa)
    }
}