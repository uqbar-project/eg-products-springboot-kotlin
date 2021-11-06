package org.uqbar.products.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.uqbar.products.domain.Producto


interface ProductoRepository : PagingAndSortingRepository<Producto, Long> {

//	@EntityGraph(attributePaths=#[
//		"proveedores"
//	])
    override fun findAll(pageable: Pageable): Page<Producto>

}