package frox.engine.architecture.application.usecase.product.implementation

import frox.engine.architecture.application.usecase.product.contract.CreateProductUseCase
import frox.engine.architecture.application.usecase.product.contract.ProductUseCases

class ProductUseCasesImpl(
    override val createProductUseCase: CreateProductUseCase
) : ProductUseCases