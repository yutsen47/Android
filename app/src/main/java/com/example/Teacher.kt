package com.example.afinal

data class Teacher(
    val name: String,
    val title: String,
    val specialty: String,
    val photoResId: Int
)
object TeacherData {

    val teachers = listOf(
        Teacher(
            "廖秀莉",
            "教授 兼 系主任",
            "電子商務、網路經營、專案管理、數位學習、人工智慧",
            R.drawable.teacher_a
        ),
        Teacher(
            "吳肇銘",
            "教授",
            "網路行銷、大數據分析與資料探勘、智慧治理與電子化政府、地方創生、縮減數位落差",
            R.drawable.teacher_b
        ),
        Teacher(
            "皮世明",
            "教授 兼 教務長",
            "決策支援系統、商業智慧系統、醫療資訊系統、顧客關係管理",
            R.drawable.teacher_c
        ),
        Teacher(
            "劉士豪",
            "教授",
            "資訊管理專題、系統分析與設計、系統執行與評估、組織與資訊系統",
            R.drawable.teacher_d
        ),
        Teacher(
            "林志浩",
            "教授 兼 數位教育長",
            "行動通訊網路、智慧電網通訊、車載資通訊應用、系統最佳化、網路規劃與管理",
            R.drawable.teacher_e
        ),
        Teacher(
            "李國誠",
            "教授 兼 資訊長",
            "數位學習、類神經網路、資料開採、嵌入式系統程式設計",
            R.drawable.teacher_g
        ),
        Teacher(
            "李維平",
            "副教授",
            "人工智慧、大數據分析、資料探勘、智慧型投資、財務探勘",
            R.drawable.teacher_f
        ),
        Teacher(
            "廖慶榮",
            "副教授",
            "雲端計算與服務、磨課師與行動磨課師學習、數位學伴、創意問題解決",
            R.drawable.teacher_i
        ),
        Teacher(
            "賴錦慧",
            "副教授",
            "資料探勘、文字探勘、大數據分析、推薦系統、機器學習、資訊檢索、社群網路分析",
            R.drawable.teacher_h
        ),
        Teacher(
            "周賢明",
            "副教授",
            "環境感知計算、手機應用、人工智慧應用、物聯網應用",
            R.drawable.teacher_j
        ),
        Teacher(
            "闕豪恩",
            "副教授 兼 招生事務處副處長 兼 高教推廣中心主任",
            "資料探勘、數位學習、人工智慧 、醫療資訊",
            R.drawable.teacher_k
        ),
        Teacher(
            "吳岳穎",
            "助理教授",
            "IT專案管理、資訊系統導入、雲端服務治理",
            R.drawable.teacher_l
        )
    )
}