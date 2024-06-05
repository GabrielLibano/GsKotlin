package com.example.gustavogadini95909.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.recyclerview.widget.RecyclerView
import com.example.gustavogadini95909.R
import com.example.gustavogadini95909.adapter.PraiasAdapter
import com.example.gustavogadini95909.model.PraiaModel
import com.example.gustavogadini95909.ui.theme.GustavoGadini95909Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewPraias);
        val praiasAdapter = PraiasAdapter()
        recyclerView.adapter = praiasAdapter

        val button = findViewById<Button>(R.id.buttonIncluir)
        val nome = findViewById<EditText>(R.id.editTextNomePraia)
        val cidade = findViewById<EditText>(R.id.editTextCidade)
        val estado = findViewById<EditText>(R.id.editTextEstado)
        val buttonExcluir = findViewById<Button>(R.id.buttonRemoverTudo)

        button.setOnClickListener {
            if (nome.text.isEmpty()) {
                nome.error = "Preencha o nome da praia"
                return@setOnClickListener
            }
            else if(cidade.text.isEmpty()){
                cidade.error = "Preencha a cidade"
                return@setOnClickListener
            }
            else if(estado.text.isEmpty()){
                estado.error = "Preencha o estado"
                return@setOnClickListener
            }
            else if(estado.length() < 2){
                estado.error = "Campo estado incorreto"
                return@setOnClickListener
            }

            val item = PraiaModel(
                nome = nome.text.toString(),
                cidade = cidade.text.toString(),
                estado = estado.text.toString(),
                onRemove = {
                    praiasAdapter.removeItem(it)
                }
            )

            praiasAdapter.addItem(item)

            nome.text.clear()
            cidade.text.clear()
            estado.text.clear()
        }

        buttonExcluir.setOnClickListener{
            praiasAdapter.removeAllItens()
        }
    }
}