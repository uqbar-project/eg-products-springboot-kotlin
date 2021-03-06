package ar.edu.algo3.products.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import ar.edu.algo3.products.domain.Producto
import org.springframework.data.jpa.repository.EntityGraph


interface ProductoRepository : PagingAndSortingRepository<Producto, Long> {

//	@EntityGraph(attributePaths=[
//		"proveedores"
//	])
    override fun findAll(pageable: Pageable): Page<Producto>

}