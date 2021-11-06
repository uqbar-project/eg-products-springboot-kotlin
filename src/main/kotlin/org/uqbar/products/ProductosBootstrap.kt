package org.uqbar.products

import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer
import org.springframework.stereotype.Service
import org.uqbar.products.domain.Fabricante
import org.uqbar.products.domain.Producto
import org.uqbar.products.repository.FabricanteRepository
import org.uqbar.products.repository.ProductoRepository
import java.time.LocalDate

@Service
class ProductosBootstrap : InitializingBean {

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
            proveedores = if (i % 2 == 0) fabricantes.subList(0, 10).toSet() else fabricantes.subList(11, 15).toSet()
        }
        productosRepository.save(producto)
    }

    override fun afterPropertiesSet() {
        println("************************************************************************")
        println("Running initialization")
        println("************************************************************************")
        if (fabricanteRepository.count() > 0) return

        val fabricantes = mutableListOf<Fabricante>()
        (1..25).forEach { i -> fabricantes.add(crearFabricante(i)) }

        (1..5000).forEach { i -> crearProducto(i, fabricantes) }
    }

}

class ServletInitializer : SpringBootServletInitializer() {
    override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
        return application.sources(ProductsApplication::class.java)
    }
}