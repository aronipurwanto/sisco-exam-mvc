package com.sisko.exam.master.attempt_answer_option.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttemptAnswerOptionReq {

    @NotBlank(message = "Attempt answer ID is required")
    private String attemptAnswerId;

    @NotBlank(message = "Option ID is required")
    private String questionOptionId;

    @NotNull(message = "selected is required")
    private boolean selected;
}
