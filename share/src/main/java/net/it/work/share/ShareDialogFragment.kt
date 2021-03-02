/*
 * Copyright (c) 2020. vipyinzhiwei <vipyinzhiwei@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.it.work.share

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_share_dialog.llMore
import kotlinx.android.synthetic.main.fragment_share_dialog.tvCancel
import kotlinx.android.synthetic.main.fragment_share_dialog.tvShareToQQ
import kotlinx.android.synthetic.main.fragment_share_dialog.tvShareToQQzone
import kotlinx.android.synthetic.main.fragment_share_dialog.tvShareToWeibo
import kotlinx.android.synthetic.main.fragment_share_dialog.tv_share_friends

/**
 * 分享对话框的弹出界面。
 */
open class ShareDialogFragment : BottomSheetDialogFragment() {

    private lateinit var shareContent: String

    private lateinit var attachedActivity: Activity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_share_dialog, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity?.let { act ->
            attachedActivity = act
            tv_share_friends.setDrawable(ContextCompat.getDrawable(act, R.drawable.ic_share_wechat_black_30dp), 30f, 30f, 1)
            tvShareToWeibo.setDrawable(ContextCompat.getDrawable(act, R.drawable.ic_share_weibo_black_30dp), 30f, 30f, 1)
            tvShareToQQ.setDrawable(ContextCompat.getDrawable(act, R.drawable.ic_share_qq_black_30dp), 30f, 30f, 1)
            tvShareToQQzone.setDrawable(ContextCompat.getDrawable(act, R.drawable.ic_share_qq_zone_black_30dp), 30f, 30f, 1)

            tvShareToQQ.setOnClickListener {
                share(attachedActivity, shareContent, SHARE_QQ)
                dismiss()
            }
            tv_share_friends.setOnClickListener {
                share(attachedActivity, shareContent, SHARE_WECHAT)
                dismiss()
            }
            tvShareToWeibo.setOnClickListener {
                share(attachedActivity, shareContent, SHARE_WEIBO)
                dismiss()
            }
            tvShareToQQzone.setOnClickListener {
                share(attachedActivity, shareContent, SHARE_QQZONE)
                dismiss()
            }
            llMore.setOnClickListener {
                share(attachedActivity, shareContent, SHARE_MORE)
                dismiss()
            }
            tvCancel.setOnClickListener {
                dismiss()
            }
        }
    }

    fun showDialog(activity: AppCompatActivity, shareContent: String) {
        show(activity.supportFragmentManager, "share_dialog")
        this.shareContent = shareContent
    }
}