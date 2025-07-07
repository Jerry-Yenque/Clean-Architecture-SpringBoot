package frox.engine.architecture.data.repository

import frox.engine.architecture.application.repository.ProductRepository
import frox.engine.architecture.data.mapper.toDocument
import frox.engine.architecture.data.mapper.toDomain
import frox.engine.architecture.domain.model.Product
import frox.engine.architecture.infrastructure.repository.ProductMongoRepository
import org.springframework.stereotype.Component

@Component
class ProductRepositoryImpl(private val productMongoRepository: ProductMongoRepository) : ProductRepository {
    override fun save(product: Product): Product {
        val saved = productMongoRepository.save(product.toDocument())
        return saved.toDomain()
    }

    override fun findById(id: String): Product? {
        val product = productMongoRepository.findById(id)
        return product.map { it.toDomain() }
            .orElse(null)
    }
}