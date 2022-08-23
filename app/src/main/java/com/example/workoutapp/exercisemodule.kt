package com.example.workoutapp

class exercisemodule(
    var id:Int,
    var Exercisename:String,
    var image:Int,
    var iscompleted:Boolean,
    var isselected:Boolean,

)
{
    fun getid():Int
    {
        return id
    }

    fun setid(id:Int)
    {
        this.id=id
    }


    fun getimage():Int
    {
        return image
    }

    fun setimage(image:Int)
    {
        this.image=image
    }


    fun getexercisename():String
    {
        return Exercisename
    }

    fun setexercisename(Exercisename: String)
    {
        this.Exercisename=Exercisename
    }


    fun getcompleted():Boolean
    {
        return iscompleted
    }

    fun setcompleted(iscompleted: Boolean)
    {
        this.iscompleted=iscompleted
    }


    fun getslected():Boolean
    {
        return isselected
    }

    fun setselected(isselected: Boolean)
    {
        this.isselected=isselected
    }
}