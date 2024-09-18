package com.example.buffer.issue.replicate.abcdef.dto

import com.example.buffer.issue.replicate.abcdef.AbcdefAppointment
import com.example.buffer.issue.replicate.abcdef.AbcdefAppointmentType
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PastOrPresent
import jakarta.validation.constraints.PositiveOrZero
import java.time.LocalDateTime

@JvmRecord
data class AbcdefAppointmentDTO(
    @field:NotBlank
    val clientId: String?,
    @field:NotBlank
    val orderId: String?,
    @field:NotNull
    @field:PastOrPresent
    val dateTime: LocalDateTime?,
    @field:NotNull
    val installation: AbcdefAppointmentTypeDTO?,
    @field:PositiveOrZero
    val extraInstallations: Int,
    val extraStreetWork: Boolean,
    val complexStreetIntervention: Boolean,
    val simpleDropcable: Boolean,
    val complexDropcable: Boolean
) {
    fun mapToEntity(techId: Int): AbcdefAppointment {
        return AbcdefAppointment(
            null,
            techId,
            clientId!!,
            orderId!!,
            dateTime!!,
            AbcdefAppointmentType.valueOf(installation!!.name),
            extraInstallations,
            extraStreetWork,
            complexStreetIntervention,
            simpleDropcable,
            complexDropcable
        )
    }
}

fun AbcdefAppointment.mapToDto(): AbcdefAppointmentDTO {
    return AbcdefAppointmentDTO(
        this.clientId,
        this.orderId,
        this.dateTime,
        AbcdefAppointmentTypeDTO.valueOf(this.installation.name),
        this.extraInstallations!!,
        this.extraStreetWork!!,
        this.complexStreetIntervention!!,
        this.simpleDropcable!!,
        this.complexDropcable!!
    )
}
