package ar.edu.phm.products.repository

import ar.edu.phm.products.domain.Producto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository


interface ProductoRepository : PagingAndSortingRepository<Producto, Long>, CrudRepository<Producto, Long> {

//	@EntityGraph(attributePaths=[
//		"proveedores"
//	])
    override fun findAll(pageable: Pageable): Page<Producto>

}