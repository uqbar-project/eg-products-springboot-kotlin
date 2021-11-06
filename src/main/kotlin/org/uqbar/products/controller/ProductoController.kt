package org.uqbar.products.controller

import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.uqbar.products.repository.ProductoRepository
import org.uqbar.products.serializer.ProductoDTO

@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET])
class ProductoController {

    @Autowired
    lateinit var productoRepository: ProductoRepository

    @GetMapping("/productosRecientes")
    @ApiOperation("Trae la información de los últimos productos cargados.")
    fun buscarProductosRecientes() =
        productoRepository
            .findAll(PageRequest.of(0, 1000, Sort.Direction.ASC, "fechaIngreso"))
            .map { ProductoDTO.fromProducto(it) }

}