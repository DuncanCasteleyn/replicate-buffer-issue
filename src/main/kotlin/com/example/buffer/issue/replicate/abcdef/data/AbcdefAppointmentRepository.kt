package com.example.buffer.issue.replicate.abcdef.data

import com.example.buffer.issue.replicate.abcdef.AbcdefAppointment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface AbcdefAppointmentRepository : JpaRepository<AbcdefAppointment, Long>,
    JpaSpecificationExecutor<AbcdefAppointment>
