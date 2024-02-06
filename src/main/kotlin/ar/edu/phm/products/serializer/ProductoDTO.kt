package ar.edu.phm.products.serializer

import ar.edu.phm.products.domain.Producto
import java.time.format.DateTimeFormatter

class ProductoDTO {
    lateinit var nombre: String
    lateinit var fechaIngreso: String
    lateinit var proveedores: Set<String>

    companion object {
        fun fromProducto(producto: Producto): ProductoDTO =
            ProductoDTO().apply {
                nombre = producto.nombre
                fechaIngreso = DateTimeFormatter.ofPattern("dd/MM/yyy").format(producto.fechaIngreso)
                proveedores = producto.getNombresDeProveedores()
            }
    }
}