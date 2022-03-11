package ar.edu.algo3.products.controller

import ar.edu.algo3.products.repository.ProductoRepository
import ar.edu.algo3.products.serializer.ProductoDTO
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET])
class ProductoController {

    @Autowired
    lateinit var productoRepository: ProductoRepository

    @GetMapping("/productosRecientes")
    @Operation(summary = "Trae la información de los últimos productos cargados.")
    fun buscarProductosRecientes() =
        productoRepository
            .findAll(PageRequest.of(0, 1000, Sort.Direction.ASC, "fechaIngreso"))
            .map { ProductoDTO.fromProducto(it) }

}