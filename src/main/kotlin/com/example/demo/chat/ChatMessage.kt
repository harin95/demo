package com.example.demo.chat

data class ChatMessage (
    var type: MessageType,
    var content: String?,
    var sender: String
)