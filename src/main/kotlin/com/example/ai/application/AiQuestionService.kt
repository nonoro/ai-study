package com.example.ai.application

import jakarta.annotation.PostConstruct
import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.document.Document
import org.springframework.ai.vectorstore.VectorStore
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
class AiQuestionService(
    private val client: ChatClient,
    private val vectorStore: VectorStore,
) {

    fun question(query: String): String {
        return client.prompt(query)
            .system("about AI Study, replying korean")
            .call()
            .content()
    }

    @PostConstruct
    fun init() {
        val documents = listOf(
            Document("AI Study를 하고있는 사람들은 3명입니다"),
            Document("AI Study의 팀장은 영철입니다"),
            Document("AI Study의 팀원은 알렉스, 지미 입니다."),
            Document("AI Study의 팀원 알렉스는 35살입니다."),
            Document("AI Study의 팀원 지미는 20살입니다."),
            Document("AI Study의 팀원 영철은 28살입니다."),
            Document("AI Study는 1주일에 3번 진행합니다."),
        )
        vectorStore.add(documents)
    }
}
