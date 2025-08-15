package com.godie.Blog.dto.Tag;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTagRequestDto {

    @NotEmpty(message = "En az bir etiket gerekli")
    @Size(max = 10, message = "En fazla {max} etiket eklenebilir")
    private Set<
            @Size(min = 2, max = 30, message = "Etiket {min} ila {max} karakter uzunlugunda olmali")
                    String> names;
}
