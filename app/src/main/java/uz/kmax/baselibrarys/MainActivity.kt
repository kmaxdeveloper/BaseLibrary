package uz.kmax.baselibrarys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.kmax.base.fragmentcontroller.FragmentController
import uz.kmax.baselibrarys.networkmonitor.NetworkFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentController.init(R.id.container, supportFragmentManager)
        FragmentController.controller?.startMainFragment(NetworkFragment())
    }
}