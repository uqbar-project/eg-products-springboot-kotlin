package org.uqbar.products.repository

import org.springframework.data.repository.CrudRepository
import org.uqbar.products.domain.Fabricante

interface FabricanteRepository : CrudRepository<Fabricante, Long>