package com.godie.Blog.dto.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateCategoryRequestDto {
    @NotBlank(message = "Kategori adi gerekli")
    @Size(min = 1, max = 50, message = "Kategori adi {min} ila {max} karakter uzunlugunda olmali")
    private String name;

    @NotBlank(message = "Kategori aciklamasi gerekli")
    @Size(min = 1, max = 2000, message = "Kategori aciklamasi {min} ila {max} karakter uzunlugunda olmali")
    private String description;
}
