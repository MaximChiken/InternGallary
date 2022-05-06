package com.example.interngallary.api


data class NekoQuestListResponse(val results: List<NekoQuestListItem>)

data class NekoQuestListItem(val url: String)