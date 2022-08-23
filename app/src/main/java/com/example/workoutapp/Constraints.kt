package com.example.workoutapp

object Constraints {

    fun exerciselist():ArrayList<exercisemodule>
    {
        var List=ArrayList<exercisemodule>()

        var cobra=exercisemodule(
            1,
            "Cobra Strech",
            R.drawable.cobrastrech,
            false,
            false

        )


        List.add(cobra)

        // 2nd
        var crunch=exercisemodule(
            2,
            "Crunch",
            R.drawable.crunch,
            false,
            false
        )

        List.add(crunch)

        //3rd
        var glutebridge=exercisemodule(
            3,
            "Glute Bridge",
            R.drawable.glutebridge,
            false,
            false
        )

        List.add(glutebridge)

        //4th
        var jumpingjacks=exercisemodule(
            4,
            "jumping jacks",
            R.drawable.jumpingjacks,
            false,
            false
        )

        List.add(jumpingjacks)

        //5th

        var lunges=exercisemodule(
            5,
            "Lunges",
            R.drawable.lunges,
            false,
            false
        )

        List.add(lunges)


        //6th
        var planks=exercisemodule(
            6,
            "Planks",
            R.drawable.planks,
            false,
            false
        )

        List.add(planks)

        // 7th
        var pushups=exercisemodule(
            7,
            "Push Ups",
            R.drawable.pushups,
            false,
            false
        )

        List.add(pushups)

        //8
        var sideplanks=exercisemodule(
            8,
            "Side planks",
            R.drawable.sideplank,
            false,
            false
        )

        List.add(sideplanks)

        //9
        var squats=exercisemodule(
            9,
            "Squats",
            R.drawable.squats,
            false,
            false
        )

        List.add(squats)

        //10
        var superman=exercisemodule(
            10,
            "Superman",
            R.drawable.superman,
            false,
            false
        )

        List.add(superman)

        // 11
        var toetuching=exercisemodule(
            11,
            "Toe Touching",
            R.drawable.toetouching,
            false,
            false
        )

        List.add(toetuching)

        return List
    }
}