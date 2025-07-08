package frox.engine.architecture.infrastructure.config

import frox.engine.architecture.application.repository.ProductRepository
import frox.engine.architecture.application.usecase.product.contract.CreateProductUseCase
import frox.engine.architecture.application.usecase.product.contract.ProductUseCases
import frox.engine.architecture.application.usecase.product.implementation.CreateProductUseCaseImpl
import frox.engine.architecture.application.usecase.product.implementation.ProductUseCasesImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCasesConfig {
    @Bean
    fun createProductUseCase(productRepository: ProductRepository): CreateProductUseCase =
        CreateProductUseCaseImpl(productRepository)

    @Bean
    fun productUseCases(
        createProductUseCase: CreateProductUseCase
    ): ProductUseCases = ProductUseCasesImpl(
        createProductUseCase = createProductUseCase
    )
}