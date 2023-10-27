package com.ms.user.core.dtos;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Data
public class EmailDto {
    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;
}
