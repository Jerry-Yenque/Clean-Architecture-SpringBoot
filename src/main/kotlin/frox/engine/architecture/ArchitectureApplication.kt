package frox.engine.architecture

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing

@SpringBootApplication
@EnableMongoAuditing
class ArchitectureApplication

fun main(args: Array<String>) {
    runApplication<ArchitectureApplication>(*args)
}
