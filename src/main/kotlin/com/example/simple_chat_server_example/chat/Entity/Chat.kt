package com.example.simple_chat_server_example.chat.Entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Chat (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val roomId : Long?,

    val topic : String,
)