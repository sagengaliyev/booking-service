package com.example.roomservice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    @NotBlank(message = "Имя не может быть пустым")
    private String name;
    @Email
    private String email;
}
