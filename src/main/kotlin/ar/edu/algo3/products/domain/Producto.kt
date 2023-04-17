package ar.edu.algo3.products.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import java.time.LocalDate


@Entity
class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Column(length=150)
    var nombre = ""

    @Column
    var fechaIngreso = LocalDate.now()

    @JsonIgnore
    // Configuración correcta: LAZY
    // @ManyToMany(fetch = FetchType.LAZY)
    // Configuración para que no tire el session not found, trae el inconveniente de n + 1 queries
    @ManyToMany(fetch = FetchType.EAGER)
    var fabricantes: Set<Fabricante> = mutableSetOf()

    fun getNombresDeProveedores() = fabricantes.map { it.nombre }.toSet()
}
