package com.example.androidtest1

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.androidtest1.databinding.FragmentComposeBinding

class ComposeFragment : Fragment() {
    private lateinit var binding: FragmentComposeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentComposeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarComposefragment.inflateMenu(R.menu.menu_main)

        binding.toolbarComposefragment.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_send -> {
                    val subject = binding.edittextComposeSubject.text.toString()
                    val sender = binding.edittextComposeSender.text.toString()
                    val receiver = binding.edittextComposeReceiver.text.toString()
                    val body = binding.edittextComposeBody.text.toString()
                    view.findNavController()
                        .navigate(ComposeFragmentDirections.actionComposeFragmentToRecieveFragment(subject, sender, receiver, body))
                    true
                }
                else -> false
            }
        }
    }
}