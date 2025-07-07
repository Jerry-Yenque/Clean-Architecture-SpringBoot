package frox.engine.architecture.presentation.dto.out

import java.math.BigDecimal
import java.time.Instant

data class ProductResponseDto(
    val id: String,
    val name: String,
    val description: String?,
    val price: BigDecimal,
    val updatedAt: Instant?,
    val createdAt: Instant
)