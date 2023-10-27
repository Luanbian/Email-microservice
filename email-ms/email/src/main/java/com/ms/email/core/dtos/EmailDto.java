package com.ms.email.core.dtos;

import java.util.UUID;

public record EmailDto(
        UUID userId,
        String emailTo,
        String subject,
        String text
) {}
