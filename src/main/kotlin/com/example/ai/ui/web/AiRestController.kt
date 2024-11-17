package com.example.ai.ui.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import com.example.ai.application.AiQuestionService

@RestController
class AiRestController(
    private val questionService: AiQuestionService,
) {

    @GetMapping("/ai")
    fun question(@RequestParam query: String?): String {
        return questionService.question(query ?: "")
    }
}
