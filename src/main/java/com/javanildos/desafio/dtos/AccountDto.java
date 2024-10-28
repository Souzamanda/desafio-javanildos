package com.javanildos.desafio.dtos;

import java.util.UUID;

public record AccountDto(Long accountNumber, Long accountTypeId, UUID userId) {
}
