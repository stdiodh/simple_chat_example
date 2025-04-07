package com.example.simple_chat_server_example.chat.repository

import com.example.simple_chat_server_example.chat.Entity.Chat
import org.springframework.data.jpa.repository.JpaRepository

interface ChatRepository : JpaRepository<Chat, Long>