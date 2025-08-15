package com.godie.Blog.dto.Post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePostRequestDto {

    @NotBlank(message = "Baslik gerekli")
    @Size(min = 3, max = 20, message = "Baslik {min} ila {max} karakter uzunlugunda olmali")
    private String title;

    @NotBlank(message = "Icerik gerekli")
    @Size(min = 5, max = 50000, message = "Icerik {min} ila {max} karakter uzunlugunda olmali")
    private String content;

    @NotNull(message = "Kategori ID gerekli")
    private Long categoryId;

    @Builder.Default
    @Size(max = 10, message = "Maksimum {max} etiket eklenebilir")
    private Set<Long> tagIds = new HashSet<>();
}
