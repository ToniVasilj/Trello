# HTTP requestes #
# Board #
**Get boards list:** \
**GET** http://localhost:8080/board/list

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
**Get list of bLists within the board by boardId** \
**GET** http://localhost:8080/board/{boardId}/list

**Get bList by Id of specific board** \
**GET** http://localhost:8080/board/{boardId}/get/{bListId}

**Save/Create new bList within specific board:** \
**POST** http://localhost:8080/board/{boardId}/save

**Delete bList by Id from specific board:** \
**DELETE** http://localhost:8080/board/{boardId}/delete/{bListId}