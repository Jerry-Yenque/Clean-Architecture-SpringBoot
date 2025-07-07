package frox.engine.architecture.application.usecase.product.contract

import frox.engine.architecture.domain.model.Product

interface CreateProductUseCase {
    operator fun invoke(product: Product) : Product
}