package com.example.iva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.iva.R.id

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar los EditText
        precio = findViewById(id.precio)
        iva = findViewById(id.IVA)
        subtotal = findViewById(id.subtotal)
        total = findViewById(id.Total)
    }

    lateinit var precio: EditText
    lateinit var iva: EditText
    lateinit var subtotal: EditText
    lateinit var total: EditText

    fun calcular(v: View) {
        // Obtener los valores ingresados en los EditText y convertirlos a Double
        val precioValue = precio.text.toString().toDoubleOrNull() ?: 0.0
        val ivaValue = iva.text.toString().toDoubleOrNull() ?: 0.0

        // Calcular el subtotal y el total
        val subtotalValue = subTotal(precioValue)
        val ivaAmount = IVA(subtotalValue)
        val totalAmount = Total(subtotalValue, ivaAmount)

        // Mostrar los resultados en los EditText
        subtotal.setText(subtotalValue.toString())
        total.setText(totalAmount.toString())
    }

    // Calcular subtotal
    fun subTotal(precio: Double): Double {
        return precio
    }

    // Calcular IVA
    fun IVA(subtotal: Double): Double {
        return subtotal * 0.16
    }

    // Calcular total
    fun Total(subtotal: Double, iva: Double): Double {
        return subtotal + iva
    }
}

