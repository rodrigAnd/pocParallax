package com.fiap.pocparallax

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.core.widget.NestedScrollView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fixedCardContainer: FrameLayout = findViewById(R.id.fixed_card_container)
        // ...configure o conteúdo do card fixo conforme necessário

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val nestedScrollView: NestedScrollView = findViewById(R.id.nestedScrollView)

        val items = listOf("Card 1", "Card 2", "Card 3", "Card 4", "Card 5", "Card 6", "Card 7", "Card 8", "Card 9")

        val adapter = CardAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configura o comportamento de rolagem da NestedScrollView
        nestedScrollView.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
            // Calcula a diferença entre as posições atual e anterior do scroll
            val scrollDelta = abs(scrollY - oldScrollY)

            if (scrollDelta > 50) { // Define um limite para ocultar/mostrar o card fixo
                if (scrollY > oldScrollY) {
                    fixedCardContainer.visibility = View.GONE
                } else {
                    fixedCardContainer.visibility = View.VISIBLE
                }
            }
        })
    }
}
