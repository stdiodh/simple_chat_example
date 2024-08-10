package com.example.simple_chat_server_example.chat.controller

import com.example.simple_chat_server_example.chat.dto.ChatMessage
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class ChatController (
    val template: SimpMessagingTemplate
){
    @PostMapping("/create/topic")
    fun createChatRoom(@RequestBody topic : String){
        return
    }

    //특정 주제 메세지 전달
    @MessageMapping("/chat/message")
    fun sendMessage(message: ChatMessage) {
        template.convertAndSend("/sub/" + message.topic, message)
    }


}