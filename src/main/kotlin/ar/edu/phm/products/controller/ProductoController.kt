package ar.edu.phm.products.controller

import ar.edu.phm.products.service.ProductoService
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
    fun buscarProductosRecientes() = productoService.buscarProductosRecientes()

}