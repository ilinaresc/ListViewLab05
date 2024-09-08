package dev.irvinglinares.listviewlab05

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var arrSO = arrayOf("Android","iOS","Windows Phone","Blackberry OS","Firefox OS","Amazon World")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lsvSO: ListView = findViewById<ListView>(R.id.lsvSO)
        var adaptador: Any? = ArrayAdapter<Any?>(this, android.R.layout.simple_list_item_1, arrSO)
        lsvSO.adapter = adaptador as ArrayAdapter<*>?

        lsvSO.setOnItemClickListener { parent, view, position, l ->
            Toast.makeText(this, "Estamos en la posición: $position", Toast.LENGTH_SHORT).show()
        }

    }
}