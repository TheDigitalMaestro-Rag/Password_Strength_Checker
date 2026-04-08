package com.rag.passwordchecker

class PasswordChecker {

    fun checkStrength(password: String): String {
        var score = 0

        if (password.length >= 8) score++
        if (Regex(".*[A-Z].*").containsMatchIn(password)) score++
        if (Regex(".*[a-z].*").containsMatchIn(password)) score++
        if (Regex(".*[0-9].*").containsMatchIn(password)) score++
        if (Regex(".*[!@#\$%^&*()_+\\-].*").containsMatchIn(password)) score++

        return when {
            score < 3 -> "Weak"
            score < 5 -> "Medium"
            else -> "Strong"
        }
    }
}