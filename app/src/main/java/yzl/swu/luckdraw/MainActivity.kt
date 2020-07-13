package yzl.swu.luckdraw

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    //名单
    var list = listOf<String>("张三","李四","王五","刘六")
    //索引 确定数组人名
    var index = 0
    //定时器
    lateinit var timer:Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        //默认先显示第一个
        luckyname.text = list[index]

        //添加点击事件
        mStartBtn.setOnClickListener{
            //判断状态
            println(mStartBtn.text)
            if (mStartBtn.text.toString() == "Start"){
                //更改内容
                mStartBtn.text = "Stop"
                //更改背景颜色
                mStartBtn.setBackgroundColor(Color.RED)
                //定时器创建 分配任务
                timer = Timer()
                timer.schedule(object:TimerTask(){
                    override fun run() {
                       //判断是否越界
                        index = if (index+1 > list.size-1) 0 else index+1
                        println(index)
                        luckyname.text = list[index]
                    }
                },0,200)
            }else{
                mStartBtn.text = "Start"
                mStartBtn.setBackgroundColor(Color.rgb(76,175,80))
                timer.cancel()
            }
        }
    }
}
