package com.example.demo.chat

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer


@Configuration
@EnableWebSocketMessageBroker   //web socket 메세지 기능 활성화
class WebSocketConfig : WebSocketMessageBrokerConfigurer {

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {  //websocket 연결 endpoint
        registry.addEndpoint("/ws").withSockJS()
    }

    override fun configureMessageBroker(config: MessageBrokerRegistry) {    //endpoint prefix
        config.setApplicationDestinationPrefixes("/app")    //client -> server
        config.enableSimpleBroker("/topic")     //server -> client
    }
}