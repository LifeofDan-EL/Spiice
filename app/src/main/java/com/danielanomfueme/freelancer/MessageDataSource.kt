package com.danielanomfueme.freelancer

import models.MessageProject

class MessageDataSource {
    companion object {

        fun  createDataSet(): ArrayList<MessageProject>{
            val list = ArrayList<MessageProject>()
            list.add(
                MessageProject(
                    "Alex Marchal",
                    "Francisco Fisher",
                    "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/engineered_truth_matt_tran.png"
                )
            )

            list.add(
                MessageProject(
                    "Norma Wilson",
                    "Amel Rio",
                    "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/engineered_truth_matt_tran.png"
                )
            )

            list.add(
                MessageProject(
                    "Morris Murphy",
                    "John Wick",
                    "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/engineered_truth_matt_tran.png"
                )
            )

            list.add(
                MessageProject(
                    "Kylie Lane",
                    "John Wick",
                    "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/engineered_truth_matt_tran.png"
                )
            )

            list.add(
                MessageProject(
                    "Ted Steward",
                    "John Wick",
                    "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/engineered_truth_matt_tran.png"
                )
            )

            list.add(
                MessageProject(
                    "Wade Mccoy",
                    "John Wick",
                    "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/engineered_truth_matt_tran.png"
                )
            )
            return list
        }

    }
}