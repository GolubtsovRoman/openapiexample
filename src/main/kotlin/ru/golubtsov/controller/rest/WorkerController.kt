package ru.golubtsov.controller.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import ru.golubtsov.controller.WorkerOpenapiExample
import ru.golubtsov.controller.dto.Worker
import ru.golubtsov.dto.WorkerDto
import ru.golubtsov.service.WorkerService

@RestController
class WorkerController(
    private val workerService: WorkerService
): WorkerOpenapiExample {

    override fun findAllWorker(): ResponseEntity<List<Worker>> {
        val workers = workerService.fundAll().map { WorkerDto.toView(it) }
        return ResponseEntity.ok(workers)
    }

}
