package com.dayvatas.artbookkotlin

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.dayvatas.artbookkotlin.databinding.ActivityArtDetailBinding
import com.google.android.material.snackbar.Snackbar


class ArtDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityArtDetailBinding
    private lateinit var activityResultLauncher : ActivityResultLauncher<Intent>
    private lateinit var permissionLauncher: ActivityResultLauncher<String>
    var selectedBitMap : Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        registerLauncher()
    }

    fun selectImage(view : View){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            //rationale
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){
                Snackbar.make(view, "Permission needed for gallery", Snackbar.LENGTH_INDEFINITE).setAction("Give Permission", View.OnClickListener {
                  //request permission

                }).show()
            }else{
                //request permission
            }

        }else{
            val intentToGallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            //intent
        }


    }

    fun saveClicked(view : View){

    }

    private fun registerLauncher(){
        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result ->
            if (result.resultCode == RESULT_OK) {
                val intentFromResult = result.data
                if(intentFromResult != null){
                    val imageData = intent.data
                    //binding.imageView.setImageURI(imageData)
                    if(imageData != null) {
                        try {
                            if(Build.VERSION.SDK_INT >= 28){
                                val source = ImageDecoder.createSource(this@ArtDetailActivity.contentResolver, imageData)
                                selectedBitMap = ImageDecoder.decodeBitmap(source)
                                binding.imageView.setImageBitmap(selectedBitMap)
                            }
                            else{
                                selectedBitMap = MediaStore.Images.Media.getBitmap(contentResolver, imageData)
                                binding.imageView.setImageBitmap(selectedBitMap)
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }

            }
    }
}