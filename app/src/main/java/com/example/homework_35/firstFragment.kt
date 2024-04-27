package com.example.homework_35

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_35.databinding.FragmentFirstBinding


class firstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var count = 0
    private  var isIncrementing = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { binding =FragmentFirstBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            if (isIncrementing){
                count++
                binding.tv0.text = count.toString()
                if (count == 10){
                    isIncrementing = false
                    binding.btn1.text = getText(R.string.minus_one)
                }
            }
            else {
                count --
                binding.tv0.text = count.toString()
                if (count == 0){
                    requireActivity().supportFragmentManager.beginTransaction().
                    replace(R.id.container, SecondFragment()).addToBackStack(null)
                        .commit()
                }
            }

        }
    } }




