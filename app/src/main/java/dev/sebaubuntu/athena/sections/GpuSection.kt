/*
 * SPDX-FileCopyrightText: 2023 Sebastiano Barezzi
 * SPDX-License-Identifier: Apache-2.0
 */

package dev.sebaubuntu.athena.sections

import android.app.ActivityManager
import android.content.Context
import dev.sebaubuntu.athena.R

object GpuSection : Section() {
    override val name = R.string.section_gpu_name
    override val description = R.string.section_gpu_description
    override val icon = R.drawable.ic_gpu
    override val requiredPermissions = arrayOf<String>()

    override fun getInfo(context: Context): Map<String, Map<String, String>> {
        val activityManager = context.getSystemService(ActivityManager::class.java)
        val configurationInfo = activityManager.deviceConfigurationInfo

        return mapOf(
            "GLES" to mapOf(
                "Version" to configurationInfo.glEsVersion
            )
        )
    }

    override val navigationActionId = R.id.action_mainFragment_to_gpuFragment
}
