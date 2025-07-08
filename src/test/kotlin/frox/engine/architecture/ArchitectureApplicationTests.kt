package frox.engine.architecture

import frox.engine.architecture.presentation.dto.`in`.ProductCreateDto
import frox.engine.architecture.presentation.dto.out.ProductResponseDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import java.math.BigDecimal

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ArchitectureApplicationTests @Autowired constructor(
    private val restTemplate: TestRestTemplate
) {

    @Test
    fun contextLoads() {
    }

    @Test
    fun shouldCreateANewProduct() {
        val newProduct = ProductCreateDto(
            name = "Inca Kola 600ml",
            description = "A fizzy, bright yellow Peruvian soda with a unique sweet flavor—perfect for enjoying with any meal.",
            price = BigDecimal("5.00"),
            categoryId = "77b02d556715f702c09d4776"
        )

        val response = restTemplate.postForEntity(
            "/api/products",
            newProduct,
            ProductResponseDto::class.java  // Tipo esperado en el cuerpo de la respuesta
        )

        println("test $response")
        assertThat(response.statusCode).isEqualTo(HttpStatus.CREATED)

        val createdProduct = response.body
        assertThat(createdProduct).isNotNull()
        assertThat(createdProduct?.name).isEqualTo(newProduct.name)
        assertThat(createdProduct?.description).isEqualTo(newProduct.description)
        assertThat(createdProduct?.price).isEqualTo(newProduct.price)
    }
}
