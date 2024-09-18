package com.example.buffer.issue.replicate.abcdef

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PastOrPresent
import jakarta.validation.constraints.PositiveOrZero
import java.time.LocalDateTime

@Entity
class AbcdefAppointment(
    @Id
    @GeneratedValue(generator = "abcdef_appointment_id_seq")
    @SequenceGenerator(name = "abcdef_appointment_id_seq", sequenceName = "abcdef_appointment_seq", allocationSize = 1)
    val id: Long? = null,
    @field:NotNull
    val technicianId: Int? = null,
    @field:NotBlank
    val clientId: String,
    @field:NotBlank
    val orderId: String,
    @field:NotNull
    @field:PastOrPresent
    val dateTime: LocalDateTime,
    @field:NotNull
    @Enumerated(EnumType.STRING)
    val installation: AbcdefAppointmentType,
    @field:PositiveOrZero
    val extraInstallations: Int?,
    @field:NotNull
    val extraStreetWork: Boolean?,
    @field:NotNull
    val complexStreetIntervention: Boolean?,
    @field:NotNull
    val simpleDropcable: Boolean?,
    @field:NotNull
    val complexDropcable: Boolean?
) {
}
