import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.resepmasakan.R

class ProfileFragment : Fragment() {

    private lateinit var tvNamaUser: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_profile, container, false)

        tvNamaUser = view.findViewById(R.id.tvNamaUser)

        // Ambil user_id yang dikirim dari MainActivity
        val userId = arguments?.getString("user_id")

        // Set nama user berdasarkan ID
        tvNamaUser.text = userId ?: "Nama Pengguna"

        return view
    }
}
