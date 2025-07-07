package frox.engine.architecture.presentation.dto.`in`

import java.math.BigDecimal

data class ProductCreateDto(
    val name: String,
    val description: String?, // = null,
    val categoryId: String,
    val price: BigDecimal
)
