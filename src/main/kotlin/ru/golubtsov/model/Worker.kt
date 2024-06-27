package ru.golubtsov.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "worker")
open class Worker {

    @Id
    open var id: Long = 0

    @Column(name = "full_name")
    open var fullName: String = ""

    @Column(name = "job_title")
    open var jobTitle: String = ""

}
