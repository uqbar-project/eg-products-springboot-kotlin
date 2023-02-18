package ar.edu.algo3.products.service

import ar.edu.algo3.products.repository.ProductoRepository
import ar.edu.algo3.products.serializer.ProductoDTO
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

const val PRODUCT_PAGINATION_AMOUNT = 2500

@Service
class ProductoService {

    @Autowired
    lateinit var productoRepository: ProductoRepository

    @Transactional(Transactional.TxType.NEVER)
    fun buscarProductosRecientes() =
        productoRepository
        .findAll(PageRequest.of(0, PRODUCT_PAGINATION_AMOUNT, Sort.Direction.ASC, "fechaIngreso"))
        .map { ProductoDTO.fromProducto(it) }

}