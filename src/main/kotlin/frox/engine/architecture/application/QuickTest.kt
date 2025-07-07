package frox.engine.architecture.application

import frox.engine.architecture.domain.model.Product
import frox.engine.architecture.application.repository.ProductRepository
import frox.engine.architecture.application.usecase.product.contract.CreateProductUseCase
import frox.engine.architecture.application.usecase.product.implementation.CreateProductUseCaseImpl
import frox.engine.architecture.presentation.dto.`in`.ProductCreateDto
import frox.engine.architecture.presentation.dto.out.ProductResponseDto
import java.math.BigDecimal
import java.time.Instant

class ProductRepositoryFake : ProductRepository {
    override fun save(product: Product): Product {
        return Product(
            id = "SOME_MONGO_ID",
            name = product.name,
            description = product.description,
            price = product.price,
            updatedAt = Instant.now(),
            createdAt = Instant.now(),
            enabled = true,
            categoryId = product.categoryId,
        )
    }

    override fun findById(id: String): Product? {
        TODO("Not yet implemented")
    }
}


fun main() {
    val productRepository = ProductRepositoryFake()
    val createProductUseCase = CreateProductUseCaseImpl(productRepository)
    val productController = ProductController(createProductUseCase)

    // ===== WEB ANALOGY
    val json = ProductCreateDto(
        name = "Product Test",
        description = "description",
        categoryId = "SOME_CATEGORY_ID",
        price = BigDecimal("123.40"),
    )

    val response = productController.createProduct(json)
    println(response)
}

class ProductController(
    private val createProductUseCase: CreateProductUseCase
) {
    fun createProduct(product: ProductCreateDto): ProductResponseDto {
        val domainProduct = Product(
            name = product.name,
            description = product.description,
            price = product.price,
            enabled = true,
            categoryId = product.categoryId,
        )

        val response = createProductUseCase(domainProduct)

        return ProductResponseDto(
            id = response.id!!,
            name = response.name,
            description = response.description,
            price = response.price,
            updatedAt = response.updatedAt,
            createdAt = response.createdAt!!
        )
    }
}