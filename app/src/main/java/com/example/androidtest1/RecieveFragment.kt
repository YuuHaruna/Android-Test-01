package com.example.androidtest1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.androidtest1.databinding.FragmentRecieveBinding
import java.util.*

class RecieveFragment : Fragment() {
    private lateinit var binding: FragmentRecieveBinding
    private val args: RecieveFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecieveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cal = Calendar.getInstance()
        with(binding){
            toolbarReceivefragment.inflateMenu(R.menu.menu_receive)
            textviewReceiveSubject.text = args.subject
            textviewReceiveSender.text = args.sender
            textviewReceiveReceiver.text = getString(R.string.text_receive_receiver, args.receiver)
            textviewReceiveBody.text = args.body
            textViewReceiveAvatar.text = args.sender.firstOrNull().toString().uppercase()
            textviewReceiveDate.text = getString(R.string.text_receive_date, cal.get(Calendar.DATE), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR))
        }
        binding.toolbarReceivefragment.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }
}