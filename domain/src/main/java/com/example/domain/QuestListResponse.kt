 package com.example.domain

data class QuestListResponse(val results: List<QuestListItem>)

data class QuestListItem(val url: String)
