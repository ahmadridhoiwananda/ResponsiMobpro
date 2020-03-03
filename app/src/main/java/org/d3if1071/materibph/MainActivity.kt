package org.d3if1071.materibph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if1071.materibph.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        val navKontrol=this.findNavController(R.id.navFragmentKita)
        NavigationUI.setupActionBarWithNavController(this,navKontrol)

    }
    //untuk navigateUp(tombol back di pojok kanan atas aplikasi)
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.navFragmentKita)
        return navController.navigateUp()
    }

}
