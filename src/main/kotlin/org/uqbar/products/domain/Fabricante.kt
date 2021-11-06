package org.uqbar.products.domain

import javax.persistence.*

@Entity
class Fabricante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Column(length=150)
    var nombre = ""
}