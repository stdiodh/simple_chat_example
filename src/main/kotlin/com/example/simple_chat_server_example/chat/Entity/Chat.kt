package com.example.simple_chat_server_example.chat.Entity

import jakarta.persistence.*

@Entity
class Chat(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val roomId: Long? = null,

    @Column(nullable = false, unique = true)
    val topic: String
)
