package com.example.buffer.issue.replicate.abcdef.dto

import com.example.buffer.issue.replicate.abcdef.service.AbcdefAppointmentService
import com.vaadin.hilla.BrowserCallable
import com.vaadin.hilla.crud.FormService
import jakarta.annotation.security.PermitAll
import org.springframework.security.core.context.SecurityContextHolder

@BrowserCallable
@PermitAll
class AbcdefAppointmentDTOFormService(
    private val abcdefAppointmentService: AbcdefAppointmentService
) : FormService<AbcdefAppointmentDTO, String> {
    override fun save(value: AbcdefAppointmentDTO): AbcdefAppointmentDTO {

        val techId = SecurityContextHolder.getContext().authentication.name.toInt()

        val appointment = abcdefAppointmentService.saveAppointment(value.mapToEntity(techId))

        return appointment.mapToDto()
    }

    override fun delete(id: String) {
        TODO("Not yet implemented")
    }
}
