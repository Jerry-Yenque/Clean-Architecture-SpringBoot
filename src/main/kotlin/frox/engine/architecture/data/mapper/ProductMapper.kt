package frox.engine.architecture.data.mapper

import frox.engine.architecture.data.model.ProductDocument
import frox.engine.architecture.domain.model.Product

fun ProductDocument.toDomain(): Product {
    return Product(
        id = this.id,
        name = this.name,
        description = this.description,
        price = this.price,
        updatedAt = this.updatedAt,
        createdAt = this.createdAt,
        enabled = this.enabled,
        categoryId = this.categoryId
    )
}

fun Product.toDocument(): ProductDocument { // Or maybe toPersistence to avoid detail of implementation (mongo)
    return ProductDocument(
        id = this.id,
        name = this.name,
        description = this.description,
        price = this.price,
        updatedAt = this.updatedAt,
        createdAt = this.createdAt,
        enabled = this.enabled,
        categoryId = this.categoryId,
    )
}