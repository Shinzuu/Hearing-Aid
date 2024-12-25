package com.example.hearingaid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // State for Volume and Boost
    var volumeLevel: Float = 0.5f // Default volume level (50%)
        private set

    var boostLevel: Float = 0.5f // Default boost level (50%)
        private set

    var isProcessing: Boolean = false // Track if audio processing is active
        private set

    // Function to update Volume
    fun updateVolume(newVolume: Float) {
        volumeLevel = newVolume
        // Placeholder: Adjust audio playback volume
        println("Volume updated to $volumeLevel")
    }

    // Function to update Boost
    fun updateBoost(newBoost: Float) {
        boostLevel = newBoost
        // Placeholder: Adjust microphone gain or processing gain
        println("Boost updated to $boostLevel")
    }

    // Start/Stop audio processing
    fun toggleAudioProcessing() {
        isProcessing = !isProcessing
        viewModelScope.launch {
            if (isProcessing) {
                println("Audio processing started with Volume: $volumeLevel, Boost: $boostLevel")
                // Placeholder for real-time audio processing logic
            } else {
                println("Audio processing stopped")
            }
        }
    }
}
