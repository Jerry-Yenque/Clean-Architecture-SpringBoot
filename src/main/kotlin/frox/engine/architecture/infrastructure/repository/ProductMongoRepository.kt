package frox.engine.architecture.infrastructure.repository

import frox.engine.architecture.data.model.ProductDocument
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductMongoRepository : MongoRepository<ProductDocument, String>