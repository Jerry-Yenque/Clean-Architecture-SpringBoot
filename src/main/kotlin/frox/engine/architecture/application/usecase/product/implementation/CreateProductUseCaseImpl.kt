package frox.engine.architecture.application.usecase.product.implementation

import frox.engine.architecture.domain.model.Product
import frox.engine.architecture.application.repository.ProductRepository
import frox.engine.architecture.application.usecase.product.contract.CreateProductUseCase
import org.springframework.stereotype.Component

@Component
class CreateProductUseCaseImpl(
    private val productRepository: ProductRepository
) : CreateProductUseCase {
    override operator fun invoke(product: Product): Product {
        return productRepository.save(product)
    }
}