package com.magrathea.api.product.data;

import com.magrathea.api.product.domain.dto.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String image;
    private Float price;

    public ProductEntity(ProductRequestDTO foodDto) {
        this.id = foodDto.id();
        this.title = foodDto.title();
        this.image = foodDto.image();
        this.price = foodDto.price();
    }
}
