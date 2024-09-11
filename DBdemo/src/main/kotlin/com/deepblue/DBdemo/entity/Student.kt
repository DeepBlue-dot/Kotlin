package com.deepblue.DBdemo.entity

import jakarta.persistence.*

@Entity
@Table(name = "student")
class Student(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private val id: Int = 0, // Changed to var to allow for a setter

    @Column(name = "first_name")
    private var _firstName: String? = null,

    @Column(name = "last_name")
    private var _lastName: String? = null,

    @Column(name = "email")
    private var _email: String? = null

) {
    constructor() : this(0, null, null, null)

    // Optional: Additional constructor for convenience
    constructor(firstName: String?, lastName: String?, email: String?) : this(0, firstName, lastName, email)

    fun getId(): Int{
        return this.id
    }
    // Getter and Setter for firstName
    fun getFirstName(): String? {
        return _firstName
    }

    fun setFirstName(firstName: String?) {
        this._firstName = firstName
    }

    // Getter and Setter for lastName
    fun getLastName(): String? {
        return _lastName
    }

    fun setLastName(lastName: String?) {
        this._lastName = lastName
    }

    // Getter and Setter for email
    fun getEmail(): String? {
        return _email
    }

    fun setEmail(email: String?) {
        this._email = email
    }

    override fun toString(): String {
        return "Student(id=$id, name=$_firstName, lastName=$_lastName, email=$_email)"
    }
}
