package com.androidbootcamp.myapplogin
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.androidbootcamp.myapplogin.databinding.ActivityMainBinding
const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        binding.buttonLogin.setOnClickListener{
            checkFields()
        }
    }

    fun checkFields(){
        val  stringInNameField = binding.fieldName.text.toString()
        val  stringInPasswordField= binding.fieldPassword.text.toString()
        if (stringInNameField == "" && stringInPasswordField == ""){
            Toast.makeText(this,"No se puede realizar la acción porque El campo nombre y contraseña está vacio", Toast.LENGTH_SHORT).show()
        }else {
            if (stringInNameField == ""){
                Toast.makeText(this,"No se puede realizar la acción porque El campo nombre está vacío", Toast.LENGTH_SHORT).show()
            }
            else {
                if (stringInPasswordField == ""){
                    Toast.makeText(this,"No se puede realizar la acción porque El campo contraseña está vacío", Toast.LENGTH_SHORT).show()
                }
            }
        }

        if (stringInNameField != "" && stringInPasswordField != ""){
            val intent = Intent(this,WelcomeActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE,stringInNameField)
            }
            startActivity(intent)
        }






    }

}