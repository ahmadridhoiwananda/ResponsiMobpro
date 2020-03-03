package org.d3if1071.materibph


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.fragment_menu_satu.*
import org.d3if1071.materibph.databinding.FragmentMenuSatuBinding

/**
 * A simple [Fragment] subclass.
 */
class MenuSatu : Fragment() {
    lateinit var binding:FragmentMenuSatuBinding
    // KEY untuk SAVEINTANCE
     val KEY_HARGA = "harga_key"
     val KEY_NAMA = "nama_key"
     val KEY_KUE = "kue_key"
    val KEY_JUMLAH = "jumlah_key"
    val KEY_TOPPING = "topping_key"
    val KEY_GAMBAR = "gambar_key"

    //Varibel yang di inisialisiasi di atas agar bisa dipanggil global (banyak method)
    var harga :Int= 0
    var hasilKue :String =""
    var nama : String = ""
    var jumlahString : String = "0"
    var jumlah = 0
    var topping = 0
    var gambar =0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // pemanggilan binding
         binding = DataBindingUtil.inflate<FragmentMenuSatuBinding>(inflater,R.layout.fragment_menu_satu,container,false)


        //pemanggilan method reset() agar Visibility Gone saat pertama kali di jalankan
        reset()

        //saveintance
        if (savedInstanceState != null) {
            harga = savedInstanceState.getInt(KEY_HARGA,0)
            hasilKue = savedInstanceState.getString(KEY_KUE,"")
            nama = savedInstanceState.getString(KEY_NAMA,"")
            jumlah = savedInstanceState.getInt(KEY_JUMLAH,0)
            topping = savedInstanceState.getInt(KEY_TOPPING,0)
            gambar = savedInstanceState.getInt(KEY_GAMBAR,0)
            //method muncul untuk memunculkan semua yang telah di GONE kan
            muncul()
        }


        //Kodingan untuk fungsi button tambah dan kurang pada jumlah pemesanan
        binding.bTambah.setOnClickListener {
            jumlahString=binding.tvJumlah.text.toString()
            jumlah = jumlahString.toInt()+1
            binding.tvJumlah.setText(jumlah.toString())
        }
        binding.bKurang.setOnClickListener {
            if (tv_jumlah.text.toString().toInt()>0){
            jumlah = binding.tvJumlah.text.toString().toInt()-1
            binding.tvJumlah.setText(jumlah.toString())}
            else{
                Toast.makeText(this.context,"Tidak Bisa kurang dari 0",Toast.LENGTH_LONG).show()
            }
        }
        // fungsi apabila button BELI di tekan
         harga = 0
        binding.bBeli.setOnClickListener {
            /*
            * Harga 1 kue : Rp. 5000
            * topping
            *   -ice Cream = Rp. 2000
            *   -Ceres = Rp.1000
            * */
            //untuk meletakan harga topping Checkbox

             topping  = 0
            if (binding.cbIceCream.isChecked){
                topping += 2000
            }
            if (binding.cbCeres.isChecked){
                topping+=1000
            }

            // jumlah harga dengan rumus jumlah*5000+topping yg dipilih
            harga = binding.tvJumlah.text.toString().toInt()*5000+topping
            binding.tvHarga.setText(harga.toString())

            //menampilkan Nama di tampilan Struk nya
            nama = binding.etNama.text.toString()
            binding.tvPembeli.setText(nama)

            //if untuk pilihan di radio button
            if (binding.rbCoklat.isChecked){
                hasilKue = "Kue Coklat"
                binding.tvHasilKue.setText(hasilKue)
            }else if (binding.rbStarawberry.isChecked){
                hasilKue="Kue Starawberry"
                binding.tvHasilKue.setText(hasilKue)
            }

            //Gambar Save Intance
            gambar = R.drawable.hurufy
            binding.imageView.setImageResource(R.drawable.hurufy)

            //memunculkan Struk Pembelian yang telah di GONE kan
            muncul()
        }

        //Button Reset
        binding.bReset.setOnClickListener {
            reset()
            binding.tvJumlah.setText("0")
            binding.etNama.setText("")
            binding.cbCeres.isChecked = false
            binding.cbIceCream.isChecked = false
            binding.rbCoklat.isChecked= false
            binding.rbStarawberry.isChecked= false

        }

        //Button Share
        binding.bShare.setOnClickListener {


            val mIntent = Intent(Intent.ACTION_SEND)

            mIntent.data = Uri.parse("mailto:")
            mIntent.type = "text/plain"

            mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("fikrisaja05@gmail.com"))
            mIntent.putExtra(Intent.EXTRA_SUBJECT, "Jawaban")
            mIntent.putExtra(Intent.EXTRA_TEXT, "")
            try {
                startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
            }
            catch (e: Exception){

            }
        }

        //lajutan untuk saveintance agar ditampilkan saat rotasi
        harga = jumlah*5000+topping

        binding.tvPembeli.setText(nama)
        binding.tvHasilKue.setText(hasilKue)
        binding.tvHarga.setText(harga.toString())
        binding.tvJumlah.setText(jumlah.toString())
        binding.imageView.setImageResource(gambar)



        return binding.root
    }

    //untuk GONE Struk pembelian
    fun reset(){

        binding.tvHasilKue.visibility = View.GONE
        binding.tvStruk.visibility = View.GONE
        binding.tvPembeli.visibility = View.GONE
        binding.tvHarga.visibility = View.GONE
        binding.bShare.visibility = View.GONE
    }

    //Memunculkan Struk Pembelian
    fun muncul(){
        binding.tvHasilKue.visibility = View.VISIBLE
        binding.tvStruk.visibility = View.VISIBLE
        binding.tvPembeli.visibility = View.VISIBLE
        binding.tvHarga.visibility = View.VISIBLE
        binding.bShare.visibility = View.VISIBLE
    }

    //Save Intance State beserta key
    override fun onSaveInstanceState(outState: Bundle) {
        //(KEY,Data yang disimpan)
        outState.putString(KEY_NAMA,nama)
        outState.putInt(KEY_HARGA,harga)
        outState.putInt(KEY_JUMLAH,jumlah)
        outState.putString(KEY_KUE,hasilKue)
        outState.putInt(KEY_TOPPING,topping)
        outState.putInt(KEY_GAMBAR,gambar)

        super.onSaveInstanceState(outState)
    }







}
