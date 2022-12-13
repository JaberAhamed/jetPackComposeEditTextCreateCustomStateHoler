package com.jbdiscount.jetpackedittext.base
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.setValue

class EditableUserInputState(private val hint: String, initialTex: String) {

    var text by mutableStateOf(initialTex)

    val isHint: Boolean
        get() = text == hint

    companion object{
        val Saver:Saver<EditableUserInputState, *> = listSaver(
            save = { listOf(it.hint, it.text) },
            restore = {
                EditableUserInputState(
                    hint = it[0],
                    initialTex = it[1]
                )
            }
        )
    }
}


