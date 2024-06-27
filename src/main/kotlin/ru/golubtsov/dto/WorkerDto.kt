package ru.golubtsov.dto

import ru.golubtsov.model.Worker
import ru.golubtsov.controller.dto.Worker as WorkerView

data class WorkerDto(
    val id: Long,
    val fullName: String,
    val jobTitle: String,
) {
    companion object {
        fun fromEntity(e: Worker): WorkerDto = WorkerDto(e.id, e.fullName, e.jobTitle)

        fun toView(dto: WorkerDto) = WorkerView(dto.id, dto.fullName, dto.jobTitle)
    }
}
