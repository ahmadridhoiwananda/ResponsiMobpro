package org.d3if1071.materibph


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.d3if1071.materibph.databinding.FragmentMenuDuaBinding
import org.d3if1071.materibph.databinding.FragmentUtamaBinding

/**
 * A simple [Fragment] subclass.
 */
class MenuDua : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMenuDuaBinding>(inflater,R.layout.fragment_menu_dua,container,false)

        return binding.root
    }


}
