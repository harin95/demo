package com.example.demo.chat

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.messaging.simp.SimpMessageHeaderAccessor
import org.springframework.web.bind.annotation.RestController


@RestController
class ChatController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    fun sendMessage(@Payload chatMessage: ChatMessage?): ChatMessage? { //구독중인 클라이언트 앱에 ChatMessage 데이터를 발행
        return chatMessage
    }

    @MessageMapping("/chat.addUser")    //session에 user를 추가
    @SendTo("/topic/public")
    fun addUser(@Payload chatMessage: ChatMessage, headerAccessor: SimpMessageHeaderAccessor): ChatMessage? {
        println("asdasdf")
        println(chatMessage.sender)
        headerAccessor.sessionAttributes!!["username"] = chatMessage.sender
        return chatMessage
    }
}