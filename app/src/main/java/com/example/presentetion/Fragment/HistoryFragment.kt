package com.example.presentetion.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.db.room.DBSingle
import com.example.quizapp.history.RVHistoryAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.time.temporal.TemporalAmount
import kotlin.concurrent.thread


class HistoryFragment : Fragment() {
    lateinit var amount: SeekBar
//    lateinit var spinner: Spinner
//    lateinit var text_spinner : TextView
//    lateinit var spinner_2 : Spinner
//    lateinit var text_spinner_2 : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        amount = view.findViewById(R.id.seekbarHistory) as SeekBar
//        spinner   = view.findViewById(R.id.filter) as Spinner
//        text_spinner = view.findViewById(R.id.filter_text_1) as  TextView
//        spinner_2 = view.findViewById(R.id.filter_2) as Spinner
//        text_spinner_2  = view.findViewById(R.id.filter_text_2) as TextView

      // adapter ---------------------------------------------------------------------------------------------------
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_history)
         CoroutineScope(Dispatchers.IO).launch {

             val db = DBSingle.getInstance(requireContext()).membersDao()
             recyclerView.adapter = RVHistoryAdapter(db.getAll())
         }




      // spinner -----------------------------------------------------------------------------------------------------
//        val options = arrayOf("film","music","mathematics")
//        spinner.adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_activated_1,options)
//
//        spinner.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                text_spinner.text = options.get(p2)
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//                text_spinner.text = ""
//            }
//
//        }
        // spinner ------------------------------------------------------------------------------------------------------
//        val option_2 = arrayOf("Esy","midl","sinyr")
//        spinner_2.adapter = ArrayAdapter<String>(requireContext(),android.R.layout.simple_list_item_activated_1,option_2)
//
//        spinner_2.onItemSelectedListener  = object : AdapterView.OnItemSelectedListener{
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                text_spinner_2.text = option_2.get(p2)
//            }
//
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//                text_spinner_2.text =  ""
//            }
//
//        }
        // amount --------------------------------------------------------------------------------------------------------
//        amount.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
//            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
//
//            }
//
//            override fun onStartTrackingTouch(p0: SeekBar?) {
//
//            }
//
//            override fun onStopTrackingTouch(p0: SeekBar?) {
//
//            }
//
//        })



    }

    companion object {

        @JvmStatic
        fun newInstance() = HistoryFragment()

    }
}