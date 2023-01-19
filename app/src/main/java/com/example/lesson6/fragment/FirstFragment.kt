package com.example.lesson6.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson6.*
import com.example.lesson6.databinding.FragmentFirstBinding

 class FirstFragment : Fragment(), OnItemTextListener {

    private var binding: FragmentFirstBinding? = null
     private val textList = ArrayList<TextModel>()
    private val adapter = TextAdapter(textList, this)
    private val repo = TextRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        initialize()
    }

     private fun getData() {
         val bundle = arguments
         if (arguments != null) {
             val text = bundle?.getString("cat2")
             textList.add(TextModel(text.toString()))
         }
     }

    private fun initialize() {
        binding?.rvText?.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        textList.addAll(repo.getListOfText())
        binding?.rvText?.adapter = adapter
    }

     override fun onClick(textModel: TextModel) {
         val bundle = Bundle()
         bundle.putString("cat", textModel.text)
         parentFragmentManager.beginTransaction()
             .add(R.id.fragment_container_view, SecondFragment:: class.java, bundle)
             .addToBackStack("FirstFragment")
             .commit()
     }

     override fun onLongClick(model: TextModel) {
         recyclerView?.setonLongClick{
             textList.remove(TextModel(textList.toString()))
             val recyclerView : RecyclerView? = view?.findViewById(R.id.txt_text)
             val adapter : TextAdapter = TextAdapter(listText = textList, this)
             recyclerView?.adapter = adapter
             Toast.makeText(context, "Long clicked", Toast.LENGTH_SHORT).show()
             true
         }
     }

     override fun onDestroy() {
         super.onDestroy()
         binding = null
     }
 }

