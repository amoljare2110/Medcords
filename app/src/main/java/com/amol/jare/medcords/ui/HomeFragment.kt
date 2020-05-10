package com.amol.jare.medcords.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.amol.jare.medcords.R
import com.amol.jare.medcords.utils.NetworkConnecitity
import com.amol.jare.medcords.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val button1 = root.findViewById<Button>(R.id.btn1)
        val button2 = root.findViewById<Button>(R.id.btn2)
        val button3 = root.findViewById<Button>(R.id.btn3)
        val button4 = root.findViewById<Button>(R.id.btn4)

        button1.setOnClickListener {
            getData("b1")
        }
        button2.setOnClickListener {
            getData("b2")
        }
        button3.setOnClickListener {
            getData("b3")
        }
        button4.setOnClickListener {
            getData("b4")
        }

        homeViewModel.realdata.observe(viewLifecycleOwner, Observer {
            Toast.makeText(
                requireContext(),

                "Status:" + it.status + ", errno:" + it.errCode + ",msg:" + it.msg + ",rstr:" + it.data.rstr,
                Toast.LENGTH_SHORT
            ).show()
        })
        return root
    }

    fun getData(inputValue: String) {
        if (NetworkConnecitity.isNetworkAvailable(requireContext())) {
            homeViewModel?.getData(inputValue)
        } else {
            Toast.makeText(
                requireContext(),
                getString(R.string.network_message),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
