package com.pixelpulse.app_final.Service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object RetrofitHelper {
    //Primero una URL del servidor
    val baseUrl= "https://demo8989983.mockable.io/"
    fun getRetrofit(): Retrofit {
        var retrofit: Retrofit? = null
        var okHttpClient: OkHttpClient?= getUnsafeOkHttpClient()
        retrofit = Retrofit.Builder().baseUrl(baseUrl)
            .client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
        return retrofit
    }

    private fun getUnsafeOkHttpClient(): OkHttpClient? {
        return try
        {
            val trustAllCerts = arrayOf<TrustManager>(
                object : X509TrustManager
                {
                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(chain: Array<X509Certificate?>?, authType: String?) {}
                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(chain: Array<X509Certificate?>?, authType: String?) {}
                    override fun getAcceptedIssuers(): Array<X509Certificate?>? { return arrayOf() }
                }
            )

            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, SecureRandom())

            val sslSocketFactory = sslContext.socketFactory
            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { hostname, session -> true }
            builder.build()
        }
        catch (e: java.lang.Exception)
        {
            throw RuntimeException(e)
        }
    }
}