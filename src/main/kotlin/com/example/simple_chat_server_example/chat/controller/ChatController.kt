package com.example.simple_chat_server_example.chat.controller

import com.example.simple_chat_server_example.chat.dto.ChatMessage
import com.example.simple_chat_server_example.chat.Entity.Chat
import com.example.simple_chat_server_example.chat.repository.ChatRepository
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.*
import org.springframework.stereotype.Controller

@Controller
class ChatController(
    private val template: SimpMessagingTemplate,
    private val chatRepository: ChatRepository
) {
    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @PostMapping("/create/topic")
    @ResponseBody
    fun createChatRoom(@RequestBody topic: String): String {
        val savedChat = chatRepository.save(Chat(topic = topic))
        return "Chat room created with topic: ${'$'}{savedChat.topic}"
    }

    // 특정 주제 메시지 전달
    @MessageMapping("/chat/message")
    fun sendMessage(message: ChatMessage) {
        template.convertAndSend("/sub/" + message.topic, message)
    }
}