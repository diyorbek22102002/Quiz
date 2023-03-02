package com.example.presentetion.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.*
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.example.quizapp.R
import com.example.quizapp.damain.ViewModel.MainViewModel
import com.example.quizapp.damain.ViewModel.QuizData
import com.example.quizapp.databinding.FragmentMainBinding
import com.example.quizapp.screen.MAIN
import com.google.android.material.internal.NavigationMenu
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel



@Suppress("UNUSED_EXPRESSION")
class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding
    private val viewModel : MainViewModel by viewModel()
    private val quizQuestion = QuizData()
    var categoryId : ArrayList<Int> = ArrayList()
    var categoryName : ArrayList<String> = ArrayList()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            binding.start.setOnClickListener {
                viewModel.getQuestions()

            }
//      navController =   Navigation.findNavController(MAIN,R.id.Main_fragment)
//        binding.bottomNavView.setupWithNavController(na)





       //--------------------------------------------------------------------
        val sbAmount = binding.seekbar
        val amount = binding.sdAmount

        val  spinner2 = binding.spinner2
        val  option2 = arrayOf("easy", "medium", "hard")


        // SeekBar --------------------------------------------------------------------
        sbAmount.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                amount.text = p1.toString()
                viewModel.amount = p1
                Log.e("amount",viewModel.amount.toString())
                quizQuestion.amount = viewModel.amount

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })


        // spinner -----------------------------------------------------------------------------------------------------------
        viewModel.categoryLiveData.observe(viewLifecycleOwner){
            for (numbers in 0 until it.trivia_categories.size){
                categoryName.add(it.trivia_categories[numbers].name)
                categoryId.add(it.trivia_categories[numbers].id)
                binding.spinner.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_activated_1,categoryName)

            }
        }

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.category = categoryId[p2]





            }

            val entertainment = "Entertainment:Film"
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }

        // spinner_2 ----------------------------------------------------------------------------------------------------------
        spinner2.adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_activated_1, option2)

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                viewModel.difficulty = option2[p2]
                 Log.e("difficulty",viewModel.difficulty)
                quizQuestion.difficulty = viewModel.difficulty


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        viewModel.questionLiveData.observe(viewLifecycleOwner){
            Log.e("ListQuestion to Quiz",it.toString())
            MAIN.navController.navigate(R.id.action_mainFragment_to_quizFragment)
            MAIN.binding.bottomNavView.visibility = View.GONE

        }

   }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}