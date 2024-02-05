package ar.edu.algo3.products.repository

import ar.edu.algo3.products.domain.Fabricante
import org.springframework.data.repository.CrudRepository

interface FabricanteRepository : CrudRepository<Fabricante, Long>