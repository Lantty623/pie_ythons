package com.example.animalstepper.data

import com.aallam.openai.api.BetaOpenAI
import com.aallam.openai.api.chat.ChatCompletionRequest
import com.aallam.openai.api.chat.ChatMessage
import com.aallam.openai.api.chat.ChatRole
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI

class AIFunFact {
    private val openAI = OpenAI("")
    private val id = ModelId("gpt-3.5-turbo")
    private val q : String = "Tell me a one sentence fun fact about a "

    //Returns a fun fact about the given animal
    @OptIn(BetaOpenAI::class)
    suspend fun loadFact(animal: String) : String {
        val chatCompletionRequest = ChatCompletionRequest(
                model = id,
                messages = listOf(
                    ChatMessage(
                        role = ChatRole.User,
                        content = q + animal
                    )
                )
            )


        return openAI.chatCompletion(chatCompletionRequest).choices[0].message?.content
            ?: "ERROR: Fun fact could not be generated. Please wait a few seconds before trying again!"
    }
}