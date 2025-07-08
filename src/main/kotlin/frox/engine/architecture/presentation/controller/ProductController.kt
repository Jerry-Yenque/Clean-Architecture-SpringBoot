package frox.engine.architecture.presentation.controller

import frox.engine.architecture.application.usecase.product.contract.ProductUseCases
import frox.engine.architecture.presentation.dto.`in`.ProductCreateDto
import frox.engine.architecture.presentation.dto.out.ProductResponseDto
import frox.engine.architecture.presentation.mapper.toDomain
import frox.engine.architecture.presentation.mapper.toDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(private val productUseCasesImpl: ProductUseCases) {

    @PostMapping
    fun createProduct(@RequestBody dto: ProductCreateDto): ResponseEntity<ProductResponseDto> {
        val result = productUseCasesImpl.createProductUseCase(dto.toDomain())
        println("createProduct $result")
        return ResponseEntity.status(HttpStatus.CREATED).body(result.toDto())
    }
}