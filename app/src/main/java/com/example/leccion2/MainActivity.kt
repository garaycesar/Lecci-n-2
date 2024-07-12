package com.example.leccion2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.leccion2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*
    Crea una aplicación que solicite al usuario que ingrese su calificación en un examen.
La calificación mínima para aprobar es 70.
Muestra un mensaje indicando si el usuario aprobó o reprobó, y en caso de aprobar, felicitarlo.
     */
    private lateinit var vista:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        vista=ActivityMainBinding.inflate(layoutInflater)
        setContentView(vista.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        vista.calcular.setOnClickListener {
            calcularExamen()
        }
    }
    private fun calcularExamen(){
        if(! vista.nota.text.toString().isNullOrEmpty() && ! vista.nombre.text.toString().isNullOrEmpty()){
            val nota=vista.nota.text.toString().toFloat()
            val nombre=vista.nombre.text.toString()
            var resultado=""
            if(nota <60){
                resultado="REPROBADO"
            }else if(nota>=60 && nota <70){
                resultado="SUPLETORIO"
            }else if(nota >=70 && nota <80){
                resultado ="APROBAD0"
            }else if(nota>= 80 && nota <=100){
                resultado ="SOBRESALIENTE"
            }else{
                resultado="NOTA NO VALIDA"
            }
            vista.resultado.setText("Hola $nombre su estado de calificacion es: $resultado")
        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
        }
    }
}