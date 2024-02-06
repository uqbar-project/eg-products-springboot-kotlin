package ar.edu.phm.products.repository

import ar.edu.phm.products.domain.Fabricante
import org.springframework.data.repository.CrudRepository

interface FabricanteRepository : CrudRepository<Fabricante, Long>