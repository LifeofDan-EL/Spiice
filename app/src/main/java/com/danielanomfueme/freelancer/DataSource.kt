package com.danielanomfueme.freelancer

import models.FeedProject

class DataSource {
    companion object {

        fun  createDataSet(): ArrayList<FeedProject>{
            val list = ArrayList<FeedProject>()
            list.add(
                FeedProject(
                    "Wireframes",
                    "Francisco Fisher",
                    "Active"
                )
            )

            list.add(
                FeedProject(
                    "Need a new Logo",
                    "Amel Rio",
                    "Pending"
                )
            )

            list.add(
                FeedProject(
                    "Copywritter needed",
                    "John Wick",
                    "Active"
                )
            )
            return list
        }


    }
}