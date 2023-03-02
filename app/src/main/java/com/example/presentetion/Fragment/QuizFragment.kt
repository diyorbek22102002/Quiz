package com.example.presentetion.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.quizapp.R
import com.example.quizapp.damain.ViewModel.QuizData
import com.example.quizapp.databinding.FragmentQuizBinding
import com.example.quizapp.screen.MAIN
import kotlinx.android.synthetic.main.fragment_quiz.*
import org.koin.android.ext.android.inject

class QuizFragment : Fragment() {
    lateinit var True : ImageView
    lateinit var Folse : ImageView
    private  lateinit var binding: FragmentQuizBinding
    private  val quiz : QuizData by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentQuizBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nowQuestion = binding.text1
        val maxQuestion = binding.text2
        val textQuestion = binding.textQuestion
        val progressBar = binding.ProgressBar
        val skip = binding.Skip
        Log.e("quiz",quiz.questionQuiz.toString())
        Log.e("amountQuiz",quiz.amount.toString())




            Log.e("Quiz2", quiz.toString())
            textQuestion.text = quiz.questionQuiz!!.results[quiz.numberQuestion].question
            maxQuestion.text = quiz.amount.toString()
            nowQuestion.text = quiz.numberQuestion.toString()
            progressBar.progress = quiz.numberQuestion
            Log.e("amount",quiz.amount.toString())
            Log.e("numberQuestion", quiz.numberQuestion.toString())
            Log.e("text", textQuestion.text.toString())




        True = binding.yas
        Folse = binding.no

        skip.setOnClickListener {
            if (quiz.numberQuestion + 1 < quiz.amount) {

                startQuiz(quiz.numberQuestion++)
            } else {
                startResult()
            }
        }


            if (quiz.questionQuiz!!.results[quiz.numberQuestion].type == "boolean") {
                TrueFolse()
                view.findViewById<ConstraintLayout>(R.id.lin_yasno)?.visibility = View.VISIBLE
                view.findViewById<ConstraintLayout>(R.id.lin_four)?.visibility = View.GONE

            } else {
                Initfour()
                view.findViewById<ConstraintLayout>(R.id.lin_four)?.visibility = View.VISIBLE
                view.findViewById<ConstraintLayout>(R.id.lin_yasno)?.visibility = View.GONE

            }


    }

    private fun TrueFolse() {

            True.setOnClickListener {
                if (quiz.questionQuiz!!.results[quiz.numberQuestion].correct_answer == "True")
                    quiz.countTrueAnswers++

                if (quiz.numberQuestion + 1 < quiz.amount) {
                    startQuiz(quiz.numberQuestion++)
                } else {
                    startResult()
                }
            }
            Folse.setOnClickListener {
                if (quiz.questionQuiz!!.results[quiz.numberQuestion].correct_answer == "False")

                    quiz.countTrueAnswers++

                if (quiz.numberQuestion + 1 < quiz.amount) {
                    startQuiz(quiz.numberQuestion++)
                } else {
                    startResult()
                }
            }


    }
    private fun Initfour(){


            Answer1.text = quiz.questionQuiz!!.results[quiz.numberQuestion].correct_answer
            Answer2.text = quiz.questionQuiz!!.results[quiz.numberQuestion].incorrect_answers[0]
            Answer3.text = quiz.questionQuiz!!.results[quiz.numberQuestion].incorrect_answers[1]
            Answer4.text = quiz.questionQuiz!!.results[quiz.numberQuestion].incorrect_answers[2]

            Answer1.setOnClickListener {
                if (quiz.questionQuiz!!.results[quiz.numberQuestion].correct_answer == Answer1.text.toString())
                    quiz.countTrueAnswers++

                if (quiz.numberQuestion + 1 < quiz.amount) {
                    Log.e("amount_2", quiz.amount.toString())
                    startQuiz(quiz.numberQuestion++)
                } else {
                    startResult()
                }
            }
            Answer2.setOnClickListener {
                if (quiz.questionQuiz!!.results[quiz.numberQuestion].correct_answer == Answer2.text.toString())
                    quiz.countTrueAnswers++

                if (quiz.numberQuestion + 1 < quiz.amount) {
                    startQuiz(quiz.numberQuestion++)
                } else {
                    startResult()
                }
            }
            Answer3.setOnClickListener {
                if (quiz.questionQuiz!!.results[quiz.numberQuestion].correct_answer == Answer3.text.toString())
                    quiz.countTrueAnswers++

                if (quiz.numberQuestion + 1 < quiz.amount) {
                    startQuiz(quiz.numberQuestion++)
                } else {
                    startResult()
                }
            }

            Answer4.setOnClickListener {
                if (quiz.questionQuiz!!.results[quiz.numberQuestion].correct_answer == Answer4.text.toString())
                    quiz.countTrueAnswers++

                if (quiz.numberQuestion + 1 < quiz.amount) {
                    startQuiz(quiz.numberQuestion++)
                } else {
                    startResult()
                }
            }

   }

    private fun startQuiz(number : Int ){
        MAIN.navController.navigate(R.id.action_quizFragment_self)
    }
    private fun startResult(){
                MAIN.navController.navigate(R.id.action_quizFragment_to_resultFragment)
   }

}