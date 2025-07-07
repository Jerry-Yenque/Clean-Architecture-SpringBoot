package frox.engine.architecture.presentation.mapper

import frox.engine.architecture.domain.model.Product
import frox.engine.architecture.presentation.dto.`in`.ProductCreateDto
import frox.engine.architecture.presentation.dto.out.ProductResponseDto

fun ProductCreateDto.toDomain() : Product {
    return Product(
        name = this.name,
        description = this.description,
        price = this.price,
        enabled = true,
        categoryId = this.categoryId,
    )
}

fun Product.toDto() : ProductResponseDto {
    return ProductResponseDto(
        id = this.id!!,
        name = this.name,
        description = this.description,
        price = this.price,
        updatedAt = this.updatedAt,
        createdAt = this.createdAt!!
    )
}