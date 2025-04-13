package ar.edu.phm.products.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
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
     @ManyToMany(fetch = FetchType.LAZY)
    // Configuración para que no tire el session not found, no tiene el inconveniente de tirar n + 1 queries
    // pero siempre fuerza al producto a traer sus fabricantes
//    @ManyToMany(fetch = FetchType.EAGER)
    var fabricantes: Set<Fabricante> = mutableSetOf()

    fun getNombresDeProveedores() = fabricantes.map { it.nombre }.toSet()
}
