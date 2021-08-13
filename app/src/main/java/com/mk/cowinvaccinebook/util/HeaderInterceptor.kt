package com.mk.cowinvaccinebook.util

import com.mk.cowinvaccinebook.data.preference.AppPreference
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(private val appPreference: AppPreference): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_3_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.105 Safari/537.36")
            .header("dnt","1")
            .header("origin", "https://selfregistration.cowin.gov.in")
            .header("referer", "https://selfregistration.cowin.gov.in/")
            .header("sec-fetch-dest", "empty")
            .header("sec-fetch-mode","cors")
            .header("sec-fetch-site","cross-site")
        appPreference.getBearerToken()?.let {
            requestBuilder.header("Authorization", "Bearer $it")
        }
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}