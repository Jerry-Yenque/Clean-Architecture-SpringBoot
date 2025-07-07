package frox.engine.architecture.data.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType
import java.math.BigDecimal
import java.time.Instant

@Document(collection = "product")
data class ProductDocument(
    @Id
    val id: String? = null,
    val name: String,
    val description: String?,
    @Field(targetType = FieldType.DECIMAL128)
    val price: BigDecimal,
    @LastModifiedDate
    val updatedAt: Instant? = null,
    @CreatedDate
    val createdAt: Instant? = null,
    val enabled: Boolean,

    @Field(targetType = FieldType.OBJECT_ID)
    val categoryId: String
)
