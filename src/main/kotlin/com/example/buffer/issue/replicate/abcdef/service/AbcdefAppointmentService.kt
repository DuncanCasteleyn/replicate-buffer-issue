package com.example.buffer.issue.replicate.abcdef.service

import com.example.buffer.issue.replicate.abcdef.AbcdefAppointment
import com.example.buffer.issue.replicate.abcdef.data.AbcdefAppointmentRepository
import com.vaadin.hilla.BrowserCallable
import com.vaadin.hilla.crud.CrudRepositoryService
import jakarta.annotation.security.DenyAll
import jakarta.annotation.security.PermitAll
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@BrowserCallable
@PermitAll
class AbcdefAppointmentService(private val abcdefAppointmentRepository: AbcdefAppointmentRepository) :
    CrudRepositoryService<AbcdefAppointment, Long, AbcdefAppointmentRepository>() {

    @Transactional
    @DenyAll
    fun saveAppointment(appointment: AbcdefAppointment): AbcdefAppointment {
        return abcdefAppointmentRepository.save(appointment)
    }
}
