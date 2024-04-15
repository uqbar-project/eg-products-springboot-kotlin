package ar.edu.phm.products

import ar.edu.phm.products.domain.Fabricante
import ar.edu.phm.products.domain.Producto
import ar.edu.phm.products.repository.FabricanteRepository
import ar.edu.phm.products.repository.ProductoRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ProductoBootstrap : InitializingBean {

    @Autowired
    lateinit var fabricanteRepository: FabricanteRepository

    @Autowired
    lateinit var productosRepository: ProductoRepository

    fun crearFabricante(i: Int): Fabricante =
        fabricanteRepository.save(Fabricante().apply {
            nombre = "Fabricante $i"
        })

    fun crearProducto(i: Int, fabricantes: List<Fabricante>) {
        val producto = Producto().apply {
            nombre = "Producto $i"
            fechaIngreso = LocalDate.now().minusWeeks(i.toLong())
            this.fabricantes = if (i % 2 == 0) fabricantes.subList(0, 10).toSet() else fabricantes.subList(11, 15).toSet()
        }
        productosRepository.save(producto)
    }

    override fun afterPropertiesSet() {
        println("************************************************************************")
        println("Running initialization")
        println("************************************************************************")
        if (fabricanteRepository.count() > 0) return

        val fabricantes = mutableListOf<Fabricante>()
        (1..500).forEach { i -> fabricantes.add(crearFabricante(i)) }

        (1..15000).forEach { i -> crearProducto(i, fabricantes) }
    }

}

class ServletInitializer : SpringBootServletInitializer() {
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(ProductoApplication::class.java)
    }
}