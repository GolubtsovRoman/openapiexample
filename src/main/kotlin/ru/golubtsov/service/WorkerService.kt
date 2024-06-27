package ru.golubtsov.service

import org.springframework.stereotype.Service
import ru.golubtsov.dto.WorkerDto
import ru.golubtsov.repository.WorkerRepository

@Service
class WorkerService(
    private val workerRepository: WorkerRepository,
) {

    fun fundAll(): List<WorkerDto> = workerRepository.findAll().map { WorkerDto.fromEntity(it) }

}
