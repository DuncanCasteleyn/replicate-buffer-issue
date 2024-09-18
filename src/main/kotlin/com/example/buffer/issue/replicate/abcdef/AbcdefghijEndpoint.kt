package com.example.buffer.issue.replicate.abcdef

import com.vaadin.flow.spring.security.AuthenticationContext
import com.vaadin.hilla.Endpoint
import jakarta.annotation.security.PermitAll
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Endpoint
@PermitAll
class AbcdefghijEndpoint(
    private val authenticationContext: AuthenticationContext
) {

    fun getAuthenticatedTech(): Optional<UserDetails> {
        return authenticationContext.getAuthenticatedUser(UserDetails::class.java)
    }
}
