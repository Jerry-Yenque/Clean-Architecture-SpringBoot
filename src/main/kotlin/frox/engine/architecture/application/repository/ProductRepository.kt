package frox.engine.architecture.application.repository

import frox.engine.architecture.domain.model.Product

interface ProductRepository {
    fun save(product: Product): Product
    fun findById(id: String): Product?
}