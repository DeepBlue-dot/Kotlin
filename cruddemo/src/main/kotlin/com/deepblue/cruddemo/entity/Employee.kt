package com.deepblue.cruddemo.entity

import jakarta.persistence.*

@Entity
@Table(name = "employee")
class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private var id: Int,
    @Column(name = "first_name")
    private var firstName: String?,
    @Column(name = "last_name")
    private var lastName: String?,
    @Column(name = "email")
    private var email: String?,

) {
    constructor(): this(0, null, null, null)
    constructor(firstName: String, lastName: String, email: String): this(0, firstName, lastName, email)

    fun getId():Int = this.id
    fun getFirstName():String? = this.firstName
    fun getLastName(): String? = this.lastName
    fun getEmail(): String? = this.email

    fun setId(id: Int) {
        this.id=id
    }

    fun setFirstName(firstName: String) {
        this.firstName=firstName
    }

    fun setLastName(lastName: String) {
        this.lastName=lastName
    }
    fun setEmail(email: String) {
        this.email=email
    }
    override fun toString(): String {
        return "Employee(id=$id, firstName=$firstName, lastName=$lastName, email=$email)"
    }
}