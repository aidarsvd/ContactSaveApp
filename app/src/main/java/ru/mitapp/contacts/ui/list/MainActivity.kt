package ru.mitapp.contacts.ui.list



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import ru.mitapp.contacts.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findNavController(R.id.fragment1)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment1)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }





}