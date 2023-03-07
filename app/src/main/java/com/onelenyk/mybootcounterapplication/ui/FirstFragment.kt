package com.onelenyk.mybootcounterapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.onelenyk.mybootcounterapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    val viewModel by viewModels<FirstViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getAllBootEvents().observe(viewLifecycleOwner){  bootEvents ->

            val text = if(bootEvents.isEmpty()){
                "No boots detected"
            }else{
                val text = bootEvents.mapIndexed { index, bootEventEntity ->
                    "${index} - ${bootEventEntity.timestamp}"
                }.joinToString { "\n" }

                text
            }

            binding.textviewFirst.text = text

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}