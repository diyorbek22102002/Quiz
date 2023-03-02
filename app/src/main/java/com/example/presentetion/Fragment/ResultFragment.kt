package com.example.presentetion.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizapp.R
import com.example.quizapp.damain.ViewModel.QuizData
import com.example.quizapp.data.model.User_SQLite
import com.example.quizapp.databinding.FragmentResultBinding
import com.example.quizapp.db.room.DBSingle
import com.example.quizapp.screen.MAIN
import org.koin.android.ext.android.inject
import kotlin.concurrent.thread


class ResultFragment : Fragment() {
//    private val viewModel : QuizViewModel by viewModel()
    lateinit var  binding : FragmentResultBinding
    private val resultQuiz : QuizData by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionNow = binding.questionNow
        val questionMax = binding.questionMax
        val percentNumber = binding.percentnumber
        val finish = binding.finish
        val category = binding.cat
        val difficulty = binding.dif

        category.text = resultQuiz.category.toString()
        difficulty.text = resultQuiz.difficulty
        questionNow.text= resultQuiz.countTrueAnswers.toString()
        questionMax.text= resultQuiz.amount.toString()
        percentNumber.text=((resultQuiz.countTrueAnswers*100)/resultQuiz.amount).toString()


        val db = DBSingle.getInstance(requireContext()).membersDao()

        thread {
            db.insertAll(User_SQLite(0,resultQuiz.category.toString(),resultQuiz.difficulty,resultQuiz.countTrueAnswers,resultQuiz.amount))
        }
        thread {
            Log.e("Room", db.getAll().toString())
        }

        finish.setOnClickListener {
                MAIN.navController.navigate(R.id.action_resultFragment_to_mainFragment)
            MAIN.binding.bottomNavView.visibility = View.VISIBLE


        }


    }





    companion object {
        @JvmStatic
        fun newInstance() = ResultFragment()
    }
}