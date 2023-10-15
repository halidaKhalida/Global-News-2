package com.example.globalnews.utils

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException

class DetailFragmentArgs (
    public val noteId: String = "\"1\"",
) : NavArgs {
    public fun toBundle(): Bundle {
        val result = Bundle()
        result.putString("noteId", this.noteId)
        return result
    }

    public fun toSavedStateHandle(): SavedStateHandle {
        val result = SavedStateHandle()
        result.set("noteId", this.noteId)
        return result
    }

    public companion object {
        @JvmStatic
        public fun fromBundle(bundle: Bundle): DetailFragmentArgs {
            bundle.setClassLoader(DetailFragmentArgs::class.java.classLoader)
            val __noteId : String?
            if (bundle.containsKey("noteId")) {
                __noteId = bundle.getString("noteId")
                if (__noteId == null) {
                    throw IllegalArgumentException("Argument \"noteId\" is marked as non-null but was passed a null value.")
                }
            } else {
                __noteId = "\"1\""
            }
            return DetailFragmentArgs(__noteId)
        }

        @JvmStatic
        public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): DetailFragmentArgs {
            val __noteId : String?
            if (savedStateHandle.contains("noteId")) {
                __noteId = savedStateHandle["noteId"]
                if (__noteId == null) {
                    throw IllegalArgumentException("Argument \"noteId\" is marked as non-null but was passed a null value")
                }
            } else {
                __noteId = "\"1\""
            }
            return DetailFragmentArgs(__noteId)
        }
    }
}