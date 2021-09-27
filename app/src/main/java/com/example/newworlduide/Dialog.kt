package com.nwg.newworlduide

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

object Dialog {
    fun message(context: Context?, title: String?, message: String?) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Ok"
            ) { dialog: DialogInterface, which: Int -> dialog.dismiss() }.show()
    }
}