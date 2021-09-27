package com.nwg.newworlduide

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ExitDialog: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder
            .setIcon(R.drawable.icon)
            .setTitle("Exit?")
            .setMessage("Do you want to to Exit?")
            .setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                activity?.finish()
            })
            .setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
        return builder.create()
    }
}