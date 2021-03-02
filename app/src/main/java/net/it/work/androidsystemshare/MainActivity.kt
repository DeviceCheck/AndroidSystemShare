package net.it.work.androidsystemshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.tv_share
import net.it.work.share.ShareDialogFragment
import net.it.work.share.ShareManager

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    ShareManager.context = this
    tv_share.setOnClickListener {
      ShareDialogFragment().showDialog(this, "分享内容")
    }
  }
}