# HTTP requestes #
# Board #
**Get boards:** \
**GET** http://localhost:8080/board/boards

**Get board by boardId:** \
**GET** http://localhost:8080/board/get/{boardId}

**Get board by boardName:** \
**GET** http://localhost:8080/board/getByName/{boardName}

**Save/Create new board:** \
**POST** http://localhost:8080/board/save

**Update board name:** \
**POST** http://localhost:8080/board/updateName

**Delete board by Id:** \
**DELTE** http://localhost:8080/board/delete/{boardId}

# BList #
**Get bLists within the specific board** \
**GET** http://localhost:8080/board/{boardId}/blists

**Get bList by Id** \
**GET** http://localhost:8080/blist/get/{bListId}

**Save/Create new bList within specific board:** \
**POST** http://localhost:8080/board/{boardId}/blist/save

**Delete bList by Id:** \
**DELETE** http://localhost:8080/blist/delete/{bListId}


# Card #
**Get cards within the specific bList of specific board** \
**GET** http://localhost:8080/board/{boardId}/list/{bListId}/cards

**Get card by Id** \
**GET** http://localhost:8080/card/get/{cardId}

**Save/Create new card within specific bList of specific board:** \
**POST** http://localhost:8080/board/{boardId}/blist/{bListId}/save

**Update card text:** \
**POST** http://localhost:8080/card/updateText

**Delete card by Id:** \
**DELETE** http://localhost:8080/card/delete/{cardId}