package com.example.gustavogadini95909.model

data class PraiaModel(
    val nome: String,
    val cidade: String,
    val estado: String,
    val onRemove: (PraiaModel) -> Unit
)