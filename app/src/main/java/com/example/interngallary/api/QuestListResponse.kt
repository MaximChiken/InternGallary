package com.example.interngallary.api

data class QuestListResponse(val results: List<QuestListItem>)

data class QuestListItem(val url: String)
