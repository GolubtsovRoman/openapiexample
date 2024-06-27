package ru.golubtsov.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.golubtsov.model.Worker

interface WorkerRepository: JpaRepository<Worker, Long>
