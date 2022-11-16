package com.example.quizapp.questions

import android.util.Log
import com.example.quizapp.data.model.TextQuestion
import org.json.JSONObject

class QuestionJson {
    fun getQuestion():ArrayList<TextQuestion> {
        var questions_2 = ArrayList<TextQuestion>()
        var types = "{\"response_code\":0,\"results\":[{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Какая из следующих игр не является официальной в Nintendo &#039;s Super Smash Bros. серия?\",\"correct_answer\":\"Super Smash Bros. Крестовый поход\",\"incorrect_answers\":[\"Super Smash Bros. Рукопашный\",\"Super Smash Bros. Brawl\",\"Super Smash Bros. for Nintendo 3DS and Wii U\"]},{\"category\":\"Entertainment: Television\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"In the show, Doctor Who, what does T.A.R.D.I.S stand for?\",\"correct_answer\":\"Time And Relative Dimensions In Space\",\"incorrect_answers\":[\"Time And Resting Dimensions In Space\",\"Time And Relative Dimensions In Style\",\"Toilet Aid Rope Dog Is Soup\"]},{\"category\":\"Entertainment: Japanese Anime & Manga\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In the &quot;Sailor Moon&quot; series, what is Sailor Jupiter&#039;s civilian name?\",\"correct_answer\":\"Makoto Kino\",\"incorrect_answers\":[\"Minako Aino\",\"Usagi Tsukino\",\"Rei Hino\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which of these is the only fighter in the game &quot;Super Smash Bros. Melee&quot; capable of dealing damage with their taunt animation?\",\"correct_answer\":\"Luigi\",\"incorrect_answers\":[\"Mr. Game &amp; Watch\",\"Jigglypuff\",\"Pichu\"]},{\"category\":\"Entertainment: Japanese Anime & Manga\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In the 2011 TV anime series, &quot;THE iDOLM@STER&quot;, what was the name of Iori&#039;s stuffed toy bunny?\",\"correct_answer\":\"Charles\",\"incorrect_answers\":[\"Bubsy\",\"Kero\",\"Usagi\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In the 1980s, a service called Gameline allowed users to download games to what console?\",\"correct_answer\":\"Atari 2600\",\"incorrect_answers\":[\"Sega Genesis\",\"Nintendo Entertainment System\",\"ColecoVision\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What are Panama hats made out of?\",\"correct_answer\":\"Straw\",\"incorrect_answers\":[\"Silk\",\"Hemp\",\"Flax\"]},{\"category\":\"Entertainment: Music\",\"type\":\"multiple\",\"difficulty\":\"hard\",\"question\":\"Where was Nicki Minaj born?\",\"correct_answer\":\"Trinidad and Tobago\",\"incorrect_answers\":[\"Haiti\",\"Saint Lucia\",\"Grenada\"]},{\"category\":\"Sports\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"In the 2014 FIFA World Cup, what was the final score in the match Brazil - Germany?\",\"correct_answer\":\"1-7\",\"incorrect_answers\":[\"1-5\",\"1-6\",\"2-6\"]},{\"category\":\"Sports\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which NBA player has the most games played over the course of their career?\",\"correct_answer\":\"Robert Parish\",\"incorrect_answers\":[\"Kareem Abdul-Jabbar\",\"Kevin Garnett\",\"Kobe Bryant\"]}]}"
        var json = JSONObject(types)
        Log.e("JSON", json.toString())
        var result = json.getJSONArray("results")
        for (i in 0 until result.length()) {
            var result = result.getJSONObject(i)
            var category = result.getString("category")

            var type = result.getString("type")
            var difficulty = result.getString("difficulty")
            var question = result.getString("question")
            var correct_answer = result.getString("correct_answer")
            var incorrect_answers = ArrayList<String>()
            var incorrect_answers_json = result.getJSONArray("incorrect_answers")
            for (json in 0 until incorrect_answers_json.length()) {
                incorrect_answers.add(incorrect_answers_json.getString(json))
            }
             questions_2.add(TextQuestion(category,type,difficulty,question,correct_answer,incorrect_answers))

        }
        return questions_2
    }



}