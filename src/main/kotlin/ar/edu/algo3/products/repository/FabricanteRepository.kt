package ar.edu.algo3.products.repository

import org.springframework.data.repository.CrudRepository
import ar.edu.algo3.products.domain.Fabricante

interface FabricanteRepository : CrudRepository<Fabricante, Long>