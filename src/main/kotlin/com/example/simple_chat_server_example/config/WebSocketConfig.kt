package com.example.simple_chat_server_example.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig : WebSocketMessageBrokerConfigurer {
    //클라 서버 세션 연결
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint("/chat").setAllowedOriginPatterns("*")
    }

    //pub과 sub의 데이터 통신 정의
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        //클라가 서버로 통신하는 것을 정의
        registry.setApplicationDestinationPrefixes("/pub")
        //서버가 클라에게 데이터를 전달할 때
        registry.enableSimpleBroker("/sub")
    }
}