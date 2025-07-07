package frox.engine.architecture.domain.model

import java.math.BigDecimal
import java.time.Instant

data class Product(
    val id: String? = null,
    val name: String,
    val description: String?,
    val price: BigDecimal,
    val updatedAt: Instant? = null,
    val createdAt: Instant? = null,
    val enabled: Boolean,
    val categoryId: String
) {
    init {
        require(price > BigDecimal.ZERO) { "Product price must be positive" }
        require(categoryId.isNotBlank()) { "CategoryId cannot be blank" }
    }
}

fun main() {
    val product = Product(
        name = "Product Test",
        description = "Description for testing",
        price = BigDecimal.ONE,
        enabled = true,
        categoryId = "Category id for testing"
    )

    println(product)
}