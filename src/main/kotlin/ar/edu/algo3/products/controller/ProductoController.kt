package ar.edu.algo3.products.controller

import ar.edu.algo3.products.service.ProductoService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET])
class ProductoController {

    @Autowired
    lateinit var productoService: ProductoService

    @GetMapping("/productosRecientes")
    @Operation(summary = "Trae la información de los últimos productos cargados.")
    fun buscarProductosRecientes() = productoService.buscarProductosRecientes()

}