package org.d3if1071.materibph


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import org.d3if1071.materibph.databinding.FragmentUtamaBinding

/**
 * A simple [Fragment] subclass.
 */
class Utama : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentUtamaBinding>(inflater,R.layout.fragment_utama,container,false)

        binding.tvMenuSatu.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_utama_to_menuSatu)
        }
        binding.bMenuDua.setOnClickListener { view:View ->
            view.findNavController().navigate(R.id.action_utama_to_menuDua)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return  NavigationUI.onNavDestinationSelected(item!!,view!!.findNavController())
                ||super.onOptionsItemSelected(item)


    }

}
