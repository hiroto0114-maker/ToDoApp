package com.example.todoapp

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.View.OnFocusChangeListener
import android.widget.*
import androidx.fragment.app.viewModels
import com.example.todoapp.databinding.FragmentToMakeListBinding
import java.util.*




// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ToMakeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ToMakeListFragment : Fragment(R.layout.fragment_to_make_list) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    private val viewModel:ToDoMakeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentToMakeListBinding.bind(view)
        binding.lifecycleOwner=viewLifecycleOwner
        binding.viewModel=viewModel
        val tvMenuName = view.findViewById<TextView>(R.id.editScheduledTime)
        val title = view.findViewById<EditText>(R.id.title)
        title.onFocusChangeListener = OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) title.hint=""
            else title.hint="Your hint"
        }
        tvMenuName.setOnClickListener{
            //Calendarインスタンスを取得
            //Calendarインスタンスを取得
            val date = Calendar.getInstance()

            //DatePickerDialogインスタンスを取得

            //DatePickerDialogインスタンスを取得
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { view, year, month, dayOfMonth -> //setした日付を取得して表示
                    viewModel.scheduledDate.value= String.format("%d / %02d / %02d", year, month + 1, dayOfMonth)
                },
                date[Calendar.YEAR],
                date[Calendar.MONTH],
                date[Calendar.DATE]
            )

            //dialogを表示
            datePickerDialog.show()
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ToMakeListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ToMakeListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}