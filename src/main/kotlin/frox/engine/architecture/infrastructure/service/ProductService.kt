package frox.engine.architecture.infrastructure.service

import frox.engine.architecture.application.usecase.product.contract.CreateProductUseCase
import frox.engine.architecture.application.usecase.product.contract.ProductUseCases
import org.springframework.stereotype.Service

@Service
data class ProductService(
    override val createProductUseCase: CreateProductUseCase
) : ProductUseCases