package uz.kmax.base.fragmentcontroller

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentController private constructor(
    @IdRes private val container: Int,
    private val fragmentManager: FragmentManager
) {

    fun startMainFragment(fr: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(container, fr)
        transaction.commit()
    }

    fun replaceFragment(fr: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(container, fr)
        transaction.addToBackStack(fr.toString())
        transaction.commit()
    }

    fun addFragment(fr: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(container, fr)
        transaction.addToBackStack(fr.toString())
        transaction.commit()
    }

    fun back() {
        fragmentManager.popBackStack()
    }

    fun getLastFragment(): Fragment {
        return fragmentManager.fragments[fragmentManager.fragments.size - 1]
    }

    companion object {
        var controller: FragmentController? = null
            private set

        fun init(@IdRes contentId: Int, fm: FragmentManager) {
            controller = FragmentController(contentId, fm)
        }
    }
}